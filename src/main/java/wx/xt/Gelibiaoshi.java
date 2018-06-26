package wx.xt;

import system.web.JWeb;
import system.web.power.PDK;
import wx.web.bean.RY;
import wx.xt.bean.XtGuanliyuan;

/**
 *
 * @author wo
 */
public class Gelibiaoshi {

    public static final String GELIBIAOSHI_ADMIN = "__GELIBIAOSHI__#";
    public static final String GELIBIAOSHI_USER = "__GELIBIAOSHI2__#";

//----------------------------------------
    public static String getGelibiaoshiAdmin(JWeb jw) {
        return jw.session.getAttribute(GELIBIAOSHI_ADMIN).toString();
    }

    public static String getGelibiaoshi(JWeb jw) {
        Object obj = jw.session.getAttribute(GELIBIAOSHI_ADMIN);
        if (null != obj) {
            return obj.toString();
        }
        obj = jw.session.getAttribute(GELIBIAOSHI_USER);
        return obj.toString();
    }

    public static String getGelibiaoshiUser(JWeb jw) {
        Object obj = jw.session.getAttribute(GELIBIAOSHI_USER);
        return obj.toString();
    }
//-------------------------系统管理员相关---------------
    public static XtGuanliyuan getSessionXtGuanliyuan(JWeb jw) {
        return system.web.power.session.Login.getUserInfo(XtGuanliyuan.class, jw, PDK.SESSION_ADMIN_KEY);
    }

    public static String getAdminOrUserID(JWeb jw) {
        RY obj = system.web.power.session.Login.getUserInfo(RY.class, jw, PDK.SESSION_DEFAULT_USER_KEY);
        if (null != obj) {
            return obj.getRy_zj();
        }
        XtGuanliyuan admin = getSessionXtGuanliyuan(jw);
        return admin.getXt_guanliyuan_zj();
    }
//----------------------------------------

    public static void setSessionAdmin(JWeb jw, String gelibiaoshi) {
        jw.session.setAttribute(GELIBIAOSHI_ADMIN, gelibiaoshi);
    }

    public static void setSessionUser(JWeb jw, String gelibiaoshi) {
        jw.session.setAttribute(GELIBIAOSHI_USER, gelibiaoshi);
    }

    public static void out(JWeb jw) {
        jw.session.removeAttribute(GELIBIAOSHI_ADMIN);
        jw.session.removeAttribute(GELIBIAOSHI_USER);
    }

}
