package wx.xt.hm;

import configuration.Tool;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.ann.DL;
import wx.xt.bean.XtGuanliyuan;
import wx.xt.service.XtQuanxianService;

/**
 *
 * @author wo
 */
@H("/xt/power")
public class Power {

    @M("/user")
    public static void power_user(JWeb jw) {
    }

    @DL(PDK.SESSION_ADMIN_KEY)
    @M("/admin")
    public static void power_admin(JWeb jw) {
        String key = jw.getString("key");
        XtGuanliyuan obj = system.web.power.session.Login.getUserInfo(XtGuanliyuan.class, jw, PDK.SESSION_ADMIN_KEY);
        if (null == obj.getXt_guanliyuan_quanxian() || obj.getXt_guanliyuan_quanxian().isEmpty()) {
            return;
        }
        if (null != key && key.equals("yhQC")) {//管理员给用户的权限 1。用户权限，角色权限（整合用户权限成为一个角色）
            jw.printOne(Tool.entityToJSON(
                    XtQuanxianService.select(
                            "WHERE xt_quanxian_jibie IN(3) AND xt_quanxian_dm IN(" + Tool.replaceDToDDD(obj.getXt_guanliyuan_quanxian()) + ")"
                    )
            ));
        } else if (null != key && key.equals("glyQX")) {//总管给普通管理员附值的权限
            jw.printOne(Tool.entityToJSON(
                    XtQuanxianService.select(
                            "WHERE xt_quanxian_jibie IN(0,2,3,4) AND xt_quanxian_dm IN(" + Tool.replaceDToDDD(obj.getXt_guanliyuan_quanxian()) + ")"
                    )
            ));
        }
    }

    @DL(PDK.SESSION_SUPER_ADMIN_KEY)
    @M("/superadmin")
    public static void power_superAdmin(JWeb jw) {//超级管理员给总管的权限
        jw.printOne(Tool.entityToJSON(XtQuanxianService.select("WHERE xt_quanxian_jibie IN(0,2,3,4)")));
    }
}
