package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.web.bean.LoufangNafei;
import wx.web.service.LoufangNafeiService;
import wx.xt.Gelibiaoshi;

@H("/service/loufangchuzhang")
public class LoufangChuzhangHM {

    JWeb jw;

    public LoufangChuzhangHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("loufangchuzhangA")
    @M("/save")
    @Validate(wx.web.validate.LoufangNafeiValidate.class)
    public void add() {
        LoufangNafei obj = jw.getObject(LoufangNafei.class);
        jw.printOne(LoufangNafeiService.addOne(obj));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("loufangchuzhangD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (LoufangNafeiService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangNafeiService.dellOne(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("loufangchuzhangU")
    @M("/update")
    @Validate(wx.web.validate.LoufangNafeiValidate.class)
    public void update() {
        LoufangNafei obj = jw.getObject(LoufangNafei.class);
        if (null == obj.getLoufangnafei_zj() || obj.getLoufangnafei_zj().length() != 24) {
            return;
        }
        if (LoufangNafeiService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangNafeiService.update(obj));
    }

    @system.web.power.ann.SQ("loufangchuzhangU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        LoufangNafei obj = LoufangNafeiService.selectOne(id);
        if (null == obj.getLoufangnafei_zj()) {
            return;
        }
        if (LoufangNafeiService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangNafei", obj);
        jw.forward("/admin/service/loufangnafei/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("loufangchuzhangS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        LoufangNafei obj = LoufangNafeiService.selectOne(id);
        if (null == obj.getLoufangnafei_zj()) {
            return;
        }
        if (LoufangNafeiService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangNafei", obj);
        jw.forward("/admin/service/loufangnafei/one.jsp");
    }

    @system.web.power.ann.SQ("loufangchuzhangS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangnafei_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(LoufangNafeiService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("loufangchuzhangS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangnafei_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                LoufangNafeiService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                LoufangNafeiService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.SQ("loufangchuzhangE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (LoufangNafeiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangNafeiService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("loufangchuzhangUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (LoufangNafeiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangNafeiService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("loufangchuzhangV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (LoufangNafeiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangNafeiService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("loufangchuzhangUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (LoufangNafeiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangNafeiService.updateStyle_unVoid(ids));
    }

}
