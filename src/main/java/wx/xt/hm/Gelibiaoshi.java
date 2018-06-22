package wx.xt.hm;

import system.web.JWeb;

/**
 *
 * @author wo
 */
public class Gelibiaoshi {

    public static final String GELIBIAOSHI_ADMIN = "__GELIBIAOSHI__#";
    public static final String GELIBIAOSHI_USER = "__GELIBIAOSHI2__#";

    public static void setSessionAdmin(JWeb jw, String gelibiaoshi) {
        jw.session.setAttribute(GELIBIAOSHI_ADMIN, gelibiaoshi);
    }

    public static void setSessionUser(JWeb jw, String gelibiaoshi) {
        jw.session.setAttribute(GELIBIAOSHI_USER, gelibiaoshi);
    }

    public static String getGelibiaoshiUser(JWeb jw) {
        Object obj = jw.session.getAttribute(GELIBIAOSHI_USER);
        return obj.toString();
    }

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

    public static void out(JWeb jw) {
        jw.session.removeAttribute(GELIBIAOSHI_ADMIN);
        jw.session.removeAttribute(GELIBIAOSHI_USER);
    }

}
