package wx.xt.hm.xtryquanxian;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import plugins.easyui.EasyuiService;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.XtRYQuanxian;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XtRYQuanxianService;

/**
 */
@H("/xt/xtryquanxian2")
public class XtRYQuanxianHM2 {

    JWeb jw;

    public XtRYQuanxianHM2(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xtA")

    @M("/adu")
    @Validate(wx.xt.validate.XtRYQuanxianValidate.class)
    public void adu() {
        XtRYQuanxian obj = jw.getObject(XtRYQuanxian.class);
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (null == obj.getXt_juese_zj()) {
            obj.setXt_juese_zj("");
        }
        if (null == obj.getXt_quanxian()) {
            obj.setXt_quanxian("");
        }
        //当前制单人的 进行绑定过的人员权限。
        XtRYQuanxian ryq = XtRYQuanxianService.selectOne(obj.getXt_ry_zj(), admin.getXt_guanliyuan_zj());
        if (null == ryq.getXt_ryquanxian_zj()) {//新增
            obj.setXt_ryquanxian_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());//传递隔离标识
            obj.setXt_ryquanxian_zhidanren(admin.getXt_guanliyuan_zj());//制单人（管理员）主键
            jw.printOne(XtRYQuanxianService.addOne(obj));
            return;
        }
        obj.setXt_ryquanxian_zj(ryq.getXt_ryquanxian_zj());
        jw.printOne(XtRYQuanxianService.update(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("xtD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(XtRYQuanxianService.dellOne(id));
    }
//===================修改操作=============================    
    //=========表头查询操作===========
    //@system.web.power.ann.SQ("xtS") 

    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id", "");
        if (id.isEmpty()) {
            return;
        }
        jw.printOne(XtRYQuanxianService.selectOne(id));
    }

//    //@system.web.power.ann.SQ("xtS") 
//    @M("/select/selectOneByRyZJ")//针对表头的查询-一条记录的明细
//    public void selectOneByRyZJ() {
//        String ry_id = jw.getString("id", "");
//        if (ry_id.isEmpty()) {
//            return;
//        }
//        jw.printOne(XtRYQuanxianService.selectOneByRy(ry_id));
//    }
    //@system.web.power.ann.SQ("xtS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.engineToSQLCondition(jw.getString("key"));
        if (condition.length() > 0) {
            condition = "AND (" + condition + ")";
        }
        jw.printOne(EasyuiService.formatGrid(XtRYQuanxianService.select(
                admin.getXt_guanliyuan_gelibiaoshi(),
                admin.getXt_guanliyuan_bm(),
                condition
        )));
    }

}
