package wx.xt.hm.xtguanliyuan;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.ann.DL;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XtGuanliyuanService;

@DL(PDK.SESSION_SUPER_ADMIN_KEY)
@H("/xt/xtguanliyuan1/quanxian")
public class XtGuanliyuanQuanxian1HM {

    JWeb jw;

    public XtGuanliyuanQuanxian1HM(JWeb jw) {
        this.jw = jw;
    }
    //@system.web.power.ann.SQ("xtguanliyuanU")
    @M("/xiugan/quanxian")
    public void update() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        if (null == obj.getXt_guanliyuan_zj() || obj.getXt_guanliyuan_zj().length() != 24) {
            return;
        }
        System.out.println(obj.toString());
        jw.printOne(XtGuanliyuanService.update_quanxian(obj));
    }

    @M("/xiugan/bm")
    public void updateBM() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        if (null == obj.getXt_guanliyuan_zj() || obj.getXt_guanliyuan_zj().length() != 24) {
            return;
        }
        jw.printOne(XtGuanliyuanService.update_bm(obj));
    }
//===================查询操作=============================
    //@system.web.power.ann.SQ("xtguanliyuanS") 

    @M("/select/selectOne/json")//查询权限或部门管理范围
    public void selectOneByJson() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (null == obj.getXt_guanliyuan_zj()) {
            return;
        }
        jw.printOne(obj.toString());
    }
}
