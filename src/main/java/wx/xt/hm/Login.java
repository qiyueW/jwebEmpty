package wx.xt.hm;

import configuration.IFactory;
import configuration.MsgVO;
import configuration.SafeCode;
import plugins.safecede.kaptcha.KaptchaConfig;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import wx.xt.bean.XtGuanliyuan;
import wx.xt.hm.vo.LoginVO;
import wx.xt.service.XtGuanliyuanService;

/**
 *
 * @author wo
 */
@H("/xt/loginmanager")
public class Login {

    @M("/login/user")
    public static void login(JWeb jw) {
        String ua = jw.getString("sort");
        if (null == ua) {
            return;
        }
        if ("admin".equals(ua)) {
            loginAdmin(jw);
        }

    }

    private static void loginAdmin(JWeb jw) {
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
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(vo.xt_gelibiaoshi, vo.account, vo.password);
        if (null == obj || null == obj.getXt_guanliyuan_zj()) {
            outErrorMsg(jw, sf, "登录失败，请检查账号密码是否正确");
            return;
        }
        if (obj.getXt_guanliyuan_gelibiaoshi().equals(XtGuanliyuanService.GL_SUPERADMIN)) {
            system.web.power.session.Login.login(jw, obj, XtGuanliyuanService.myPower(obj), PDK.SESSION_SUPER_ADMIN_KEY);
        } else {
            system.web.power.session.Login.login(jw, obj,XtGuanliyuanService.myPower(obj), PDK.SESSION_ADMIN_KEY);
        }
        //登陆成功
        sf.clearErrorCount();
        jw.printOne(MsgVO.setOK("登陆成功，正在进入单据界面.."));
    }

    private static void outErrorMsg(final JWeb jw, final SafeCode sf, final String msg) {
        if (sf.getErrorCount() > KaptchaConfig.COUNT) {
            jw.printOne(MsgVO.setError(msg));
        } else {
            jw.printOne(MsgVO.setNotOK(msg));
        }
    }
}
