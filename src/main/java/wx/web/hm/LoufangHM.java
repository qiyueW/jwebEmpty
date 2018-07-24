package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import java.util.List;
import configuration.WebConfigModel;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;
import wx.web.service.LoufangService;
import wx.xt.Gelibiaoshi;

@H("/base/loufang")
public class LoufangHM {

    JWeb jw;

    public LoufangHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("loufangA")
    @M("/save")
    @Validate({wx.web.validate.LoufangValidate.class, wx.web.validate.Loufang2Validate.class})
    public void add() {
        Loufang obj = jw.getObject(Loufang.class);
        List<Loufang2> obj2 = (List<Loufang2>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        String gelibiaoshi = Gelibiaoshi.getGelibiaoshi(jw);
        obj.setLoufang_gelibiaoshi(gelibiaoshi);
        obj.setLoufang_danjian_chuangwei2(0);//单间已用
        obj.setLoufang_taojian_chuangwei2(0);//套间已用
        LoufangService.sumLoufang_add(obj, obj2, gelibiaoshi);
        jw.printOne(LoufangService.addOne(obj, obj2));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("loufangD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.dellVast(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("loufangU")
    @M("/update")
    @Validate({wx.web.validate.LoufangValidate.class, wx.web.validate.Loufang2Validate.class})
    public void update() {
        Loufang obj = jw.getObject(Loufang.class);
        if (null == obj || null == obj.getLoufang_zj() || obj.getLoufang_zj().length() != 24) {
            return;
        }
        String gelibiaoshi = Gelibiaoshi.getGelibiaoshi(jw);
        if (LoufangService.isErrorGelibiaoshiOne(obj, gelibiaoshi)) {//存在别人家的隔离标识的单据
            return;
        }
        List<Loufang2> obj2 = (List<Loufang2>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        LoufangService.sumLoufang_update(obj, obj2, gelibiaoshi);
        jw.printOne(LoufangService.update(obj, obj2));
    }

    @system.web.power.ann.SQ("loufangU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        Loufang obj = LoufangService.selectOne(id);
        if (null == obj.getLoufang_zj()) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("Loufang", obj);
        jw.forward("/admin/base/loufang/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("loufangS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        Loufang obj = LoufangService.selectOne(id);
        if (null == obj.getLoufang_zj()) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("Loufang", obj);
        jw.forward("/admin/base/loufang/one.jsp");
    }

    //@system.web.power.ann.SQ("loufangS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufang_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(LoufangService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("loufangS")
    @M("/select/grid2")//针对表头的查询-返回Grid数据
    public static void selectGrid2(JWeb jw) {
        jw.printOne(EasyuiService.formatGrid(
                LoufangService.select(Gelibiaoshi.getGelibiaoshiUser(jw)))
        );
    }

    @system.web.power.ann.SQ("loufangS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufang_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                LoufangService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                LoufangService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @system.web.power.ann.SQ("loufangS")
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id","");
        if(id.isEmpty()){
            return;
        }
        Loufang2 obj = LoufangService.selectOne2(id);
        if (null == obj.getLoufang_zj()) {
            jw.printOne("{}");
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(obj);
    }

    @system.web.power.ann.SQ("loufangS")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(Tool.entityToJSON(LoufangService.select2(id)));
    }

    @system.web.power.ann.SQ("loufangS")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(EasyuiService.formatGrid(LoufangService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @system.web.power.ann.SQ("loufangE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("loufangUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("loufangV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("loufangUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_unVoid(ids));
    }

}
