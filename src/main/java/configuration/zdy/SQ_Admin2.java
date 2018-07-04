package configuration.zdy;

import configuration.MsgVO;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.interfaces.IZDY;
import system.web.power.session.Login;
import system.web.power.session.PISD;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;

/**
 * 管理员(总管）
 *
 * @author wangchunzi
 */
public class SQ_Admin2 implements IZDY {

    @Override
    public boolean denyByTrue(JWeb jw, String urlCode) {
        System.out.println(jw.request.getRequestURI() + "urlCode:" + urlCode);
        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object admin = jw.session.getAttribute(PDK.SESSION_ADMIN_KEY);
        if (null == admin) {//未登录
            jw.printOne(MsgVO.setError("未登陆"));
            return true;
        }
        if (urlCode.isEmpty()) {
            System.out.println("检验成功，总管已经登陆。");
            return false;
        }
        PISD pobj = (PISD) admin;
        XtGuanliyuan xtadmin = (XtGuanliyuan) pobj.obj;
        if (xtadmin.getXt_guanliyuan_jibie() != 2) {//不是总管的，检验不合法。
            jw.printOne(MsgVO.setError("不是总管的，检验不合法"));
            return true;
        }
        if (urlCode.contains(",")) {//如果是包含某一种授权时，都可通过时，进行分割检查。
            String[] uc = urlCode.split(",");
            for (int i = 0; i < uc.length; i++) {
                if (!Login.isNoThisPower(pobj, uc[i])) {//没有权限-取反：即有权限的情况下，立马返回false，表示通过检查
                    return false;//如果有权限，即返回false
                }
            }
            return true;
        }
        return Login.isNoThisPower(pobj, urlCode);
    }
}
