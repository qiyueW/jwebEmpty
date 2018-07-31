package wx.xt.hm.xtguanliyuan;

import configuration.Tool;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XtGuanliyuanService;

/**
 * 总管对普通管理员权限绑定
 *
 * @author wo
 */
@system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "")
@H("/xt/xtguanliyuan2/quanxian")
public class XtGuanliyuanQuanxian2HM {

    JWeb jw;

    public XtGuanliyuanQuanxian2HM(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuanquanxian2_xiuganquanxian")
    @M("/xiugan/quanxian")
    public void update() {
        XtGuanliyuan newAdmin = jw.getObject(XtGuanliyuan.class);
        if (null == newAdmin.getXt_guanliyuan_zj() || newAdmin.getXt_guanliyuan_zj().length() != 24) {
            return;
        }
        //管理员只能管理自己公司的辅助
        XtGuanliyuan oldAdmin=XtGuanliyuanService.selectOne(newAdmin.getXt_guanliyuan_zj());
        if(XtGuanliyuanService.isErrorGelibiaoshi(oldAdmin, jw)) {
        	return;
        }
        ///如果以前的权限为空，则可以直接添加进去
        if(Tool.isEmpty(oldAdmin.getXt_guanliyuan_quanxian())) {
        	 jw.printOne(XtGuanliyuanService.update_quanxian(newAdmin));
        	 return;
        }
        //XtGuanliyuan admin2=Gelibiaoshi.getAdminInfoBySession(jw);
        jw.printOne(XtGuanliyuanService.update_quanxian(newAdmin));
        
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuanquanxian2_xiuganbm")
    @M("/xiugan/bm")
    public void updateBM() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        if (null == obj.getXt_guanliyuan_zj() || obj.getXt_guanliyuan_zj().length() != 24) {
            return;
        }
        jw.printOne(XtGuanliyuanService.update_bm(obj));
    }
//===================查询操作=============================

    @M("/select/selectOne/json")//查询权限或部门管理范围
    public void selectOneByJson() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (null == obj.getXt_guanliyuan_zj()) {
            return;
        }
        obj.setXt_guanliyuan_mima("不要这样啦");
        jw.printOne(obj.toString());
    }

}
