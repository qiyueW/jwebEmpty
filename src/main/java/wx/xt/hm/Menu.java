package wx.xt.hm;

import configuration.Tool;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.ann.DL;
import wx.web.bean.RY;
import wx.xt.bean.XtGuanliyuan;
import wx.xt.service.XtQuanxianService;

/**
 *
 * @author wo
 */
@H("/xt/menu")
public class Menu {

    @DL
    @M("/user")
    public static void menu_user(JWeb jw) {
        RY ry = system.web.power.session.Login.getUserInfo(RY.class, jw, PDK.SESSION_ADMIN_KEY);
        if (null == ry) {
            return;
        }
        jw.printOne(Tool.entityToJSON(
                XtQuanxianService.select(
                        "WHERE xt_quanxian_keshi IN(1) AND xt_quanxian_jibie IN(3,4) AND xt_quanxian_dm IN(" + Tool.replaceDToDDD(ry.getRy_zj()) + ")"
                )
        ));
    }

    @DL(PDK.SESSION_ADMIN_KEY)
    @M("/admin")
    public static void menu_admin(JWeb jw) {
        XtGuanliyuan obj = system.web.power.session.Login.getUserInfo(XtGuanliyuan.class, jw, PDK.SESSION_ADMIN_KEY);
        if (null == obj.getXt_guanliyuan_quanxian() || obj.getXt_guanliyuan_quanxian().isEmpty()) {
            return;
        }
        jw.printOne(Tool.entityToJSON(
                XtQuanxianService.select(
                        "WHERE xt_quanxian_keshi IN(1) AND xt_quanxian_jibie IN(0,2,4) AND xt_quanxian_dm IN(" + Tool.replaceDToDDD(obj.getXt_guanliyuan_quanxian()) + ")"
                )
        ));
    }

    @DL(PDK.SESSION_SUPER_ADMIN_KEY)
    @M("/superadmin")
    public static void menu_superAdmin(JWeb jw) {
        jw.printOne(Tool.entityToJSON(XtQuanxianService.select("WHERE xt_quanxian_keshi IN(1) AND xt_quanxian_jibie IN(0,1)")));
    }
}
