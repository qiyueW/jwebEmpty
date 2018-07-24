package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import java.util.Date;
import plugins.easyui.EasyuiService;
import wx.web.bean.RY;
import wx.web.bean.ZhusuHetong;
import wx.web.service.ZhusuHetongService;
import wx.xt.Gelibiaoshi;

@H("/base/zhusuhetong")
public class ZhusuHetongHM {

    JWeb jw;

    public ZhusuHetongHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("zhusuhetongA")
    @M("/save")
    @Validate(wx.web.validate.ZhusuHetongValidate.class)
    public void add() {
        ZhusuHetong obj = jw.getObject(ZhusuHetong.class);
        RY ry = Gelibiaoshi.getUserInfoBySession(jw);
        //隔离标识
        obj.setZhusuhetong_gelibiaoshi(ry.getRy_gelibiaoshi());
        //制单人
        obj.setZhusuhetong_zhidanren(ry.getRy_mc());
        obj.setZhusuhetong_zhidanren_zj(ry.getRy_zj());
        obj.setZhusuhetong_zhidanshijian(new Date());
        //状态
        obj.setZhusuhetong_zt(0);
        //项目费统计，没有值时，锁定为0
        if (Tool.isEmpty(obj.getZhusuhetong_xml_zj())) {
            obj.setZhusuhetong_tj_xml(0);
        }
        jw.printOne(ZhusuHetongService.addOne(obj));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("zhusuhetongD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (ZhusuHetongService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ZhusuHetongService.dellOne(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("zhusuhetongU")
    @M("/update")
    @Validate(wx.web.validate.ZhusuHetongValidate.class)
    public void update() {
        ZhusuHetong obj = jw.getObject(ZhusuHetong.class);
        if (null == obj.getZhusuhetong_zj() || obj.getZhusuhetong_zj().length() != 24) {
            return;
        }
        if (ZhusuHetongService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        if (Tool.isEmpty(obj.getZhusuhetong_xml_zj())) {
            obj.setZhusuhetong_tj_xml(0);
        }
        jw.printOne(ZhusuHetongService.update(obj));
    }

    @system.web.power.ann.SQ("zhusuhetongU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        ZhusuHetong obj = ZhusuHetongService.selectOne(id);
        if (null == obj.getZhusuhetong_zj()) {
            return;
        }
        if (ZhusuHetongService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ZhusuHetong", obj);
        jw.forward("/admin/base/zhusuhetong/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("zhusuhetongS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        ZhusuHetong obj = ZhusuHetongService.selectOne(id);
        if (null == obj.getZhusuhetong_zj()) {
            return;
        }
        if (ZhusuHetongService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ZhusuHetong", obj);
        jw.forward("/admin/base/zhusuhetong/one.jsp");
    }

    @system.web.power.ann.SQ("zhusuhetongS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "zhusuhetong_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(ZhusuHetongService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("zhusuhetongS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "zhusuhetong_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                ZhusuHetongService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                ZhusuHetongService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.SQ("zhusuhetongE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (ZhusuHetongService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ZhusuHetongService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("zhusuhetongUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (ZhusuHetongService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ZhusuHetongService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("zhusuhetongV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (ZhusuHetongService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ZhusuHetongService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("zhusuhetongUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (ZhusuHetongService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ZhusuHetongService.updateStyle_unVoid(ids));
    }

}
