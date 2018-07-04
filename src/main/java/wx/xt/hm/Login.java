package wx.xt.hm;

import wx.xt.Gelibiaoshi;
import configuration.IFactory;
import configuration.MsgVO;
import configuration.SafeCode;
import java.util.List;
import plugins.safecede.kaptcha.KaptchaConfig;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.ann.DL;
import wx.web.bean.RY;
import wx.web.service.RYService;
import wx.xt.bean.XtRYQuanxian;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.hm.vo.LoginVO;
import wx.xt.service.XtGuanliyuanService;
import wx.xt.service.XtRYQuanxianService;

/**
 *
 * @author wo
 */
@H("/xt/loginmanager")
public class Login {

    @M("/login")
    public static void login(JWeb jw) {
        String ua = jw.getString("sort");
        if (null == ua) {
            return;
        }
        if ("admin".equals(ua)) {
            loginAdmin(jw);
        } else {
            loginUser(jw);
        }
    }

    @M("/out/user")
    public static void loginout(JWeb jw) {
        Gelibiaoshi.outUser(jw);
        system.web.power.session.Login.out(jw);
        jw.sendRedirect("/login.jsp");
    }

    @M("/out/admin")
    public static void adminOut(JWeb jw) {
        Gelibiaoshi.outAdmin(jw);
        system.web.power.session.Login.out(jw, PDK.SESSION_ADMIN_KEY);
        jw.sendRedirect("/login.jsp");
    }

    @M("/out/superAdmin")
    public static void superAdminOut(JWeb jw) {
        Gelibiaoshi.outSuperAdmin(jw);
        system.web.power.session.Login.out(jw, PDK.SESSION_SUPER_ADMIN_KEY);
        jw.sendRedirect("/login.jsp");
    }

    private static void loginUser(JWeb jw) {
        SafeCode sf = IFactory.getSafeCode_img(jw);
        if (!sf.isok()) {
            jw.printOne(MsgVO.setError("请输入正确的验证码"));
            return;
        }
        LoginVO vo = new LoginVO(jw);
        if (vo.isErrorParam()) {
            outErrorMsg(jw, sf, "公司标识或账号密码格式异常");
            return;
        }
        RY obj = RYService.selectOne(vo.xt_gelibiaoshi, vo.account, vo.password);
        if (null == obj || null == obj.getRy_zj()) {
            outErrorMsg(jw, sf, "登录失败，请检查以下项：<br/>1.【账号】、【密码】是否正确<br/>2.【标识】是否正确<br/>3.【方向】是否选对");
            return;
        }
        //登陆成功
        sf.clearErrorCount();
        Gelibiaoshi.setSessionUser(jw, obj.getRy_gelibiaoshi());
        //取出人员权限（列表，表示有多个管理员给这个业务员权限）
        List<XtRYQuanxian> ryq = XtRYQuanxianService.selectOneByRy(obj.getRy_zj());
        if (null == ryq || ryq.isEmpty()) {//表示没有权限
            system.web.power.session.Login.login(jw, obj, new String[]{});
        } else if (ryq.size() == 1) {//单条记录时
            system.web.power.session.Login.login(jw, obj, XtRYQuanxianService.getPower(ryq.get(0)));
        } else {
            system.web.power.session.Login.login(jw, obj, XtRYQuanxianService.getPower(ryq));
        }

        jw.printOne(MsgVO.setOK("登陆成功，正在进入单据界面.."));
    }

    private static void loginAdmin(JWeb jw) {
        SafeCode sf = IFactory.getSafeCode_img(jw);
        if (!sf.isok()) {
            jw.printOne(MsgVO.setError("验证码异常"));
            return;
        }
        LoginVO vo = new LoginVO(jw);
        if (vo.isErrorParam()) {
            outErrorMsg(jw, sf, "标识或账号密码格式异常");
            return;
        }
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(vo.xt_gelibiaoshi, vo.account, vo.password);
        if (null == obj || null == obj.getXt_guanliyuan_zj()) {
            outErrorMsg(jw, sf, "登录失败，请检查以下项：<br/>1.【账号】、【密码】是否正确<br/>2.【标识】是否正确<br/>3.【方向】是否选对");
            return;
        }
        //登陆成功
        sf.clearErrorCount();
        if (obj.getXt_guanliyuan_gelibiaoshi().equals(XtGuanliyuanService.GL_SUPERADMIN)) {
            system.web.power.session.Login.login(jw, obj, XtGuanliyuanService.myPower(obj), PDK.SESSION_SUPER_ADMIN_KEY);
            Gelibiaoshi.setSessionSuperAdmin(jw, obj.getXt_guanliyuan_gelibiaoshi());
            jw.printOne(new MsgVO("2", "登陆成功，正在进入单据界面.."));
        } else {
            Gelibiaoshi.setSessionAdmin(jw, obj.getXt_guanliyuan_gelibiaoshi());
            system.web.power.session.Login.login(jw, obj, XtGuanliyuanService.myPower(obj), PDK.SESSION_ADMIN_KEY);
            jw.printOne(MsgVO.setOK("登陆成功，正在进入单据界面.."));
        }
    }

    private static void outErrorMsg(final JWeb jw, final SafeCode sf, final String msg) {
        if (sf.getErrorCount() > KaptchaConfig.COUNT) {
            jw.printOne(MsgVO.setError(msg));
        } else {
            jw.printOne(MsgVO.setNotOK(msg));
        }
    }
}
