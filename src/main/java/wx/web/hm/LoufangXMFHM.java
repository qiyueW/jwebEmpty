package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.web.bean.LoufangXMF;
import wx.web.service.LoufangXMFService;
import wx.xt.Gelibiaoshi;

@H("/base/loufangxmf")
public class LoufangXMFHM {

    JWeb jw;

    public LoufangXMFHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("loufangxmfA")
    @M("/save")
    @Validate(wx.web.validate.LoufangXMFValidate.class)
    public void add() {
        LoufangXMF obj = jw.getObject(LoufangXMF.class);
        obj.setLoufangxmf_gelibiaoshi(Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(LoufangXMFService.addOne(obj));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("loufangxmfD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (LoufangXMFService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangXMFService.dellOne(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("loufangxmfU")
    @M("/update")
    @Validate(wx.web.validate.LoufangXMFValidate.class)
    public void update() {
        LoufangXMF obj = jw.getObject(LoufangXMF.class);
        if (null == obj.getLoufangxmf_zj() || obj.getLoufangxmf_zj().length() != 24) {
            return;
        }
        if (LoufangXMFService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangXMFService.update(obj));
    }

    @system.web.power.ann.SQ("loufangxmfU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        LoufangXMF obj = LoufangXMFService.selectOne(id);
        if (null == obj.getLoufangxmf_zj()) {
            return;
        }
        if (LoufangXMFService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangXMF", obj);
        jw.forward("/admin/base/loufangxmf/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("loufangxmfS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        LoufangXMF obj = LoufangXMFService.selectOne(id);
        if (null == obj.getLoufangxmf_zj()) {
            return;
        }
        if (LoufangXMFService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangXMF", obj);
        jw.forward("/admin/base/loufangxmf/one.jsp");
    }

    @system.web.power.ann.SQ("loufangxmfS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangxmf_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(LoufangXMFService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("loufangxmfS")
    @M("/select/grid2")//针对表头的查询-返回Grid数据
    public static void selectGrid2(JWeb jw) {
        jw.printOne(EasyuiService.formatGrid(
                LoufangXMFService.select(Gelibiaoshi.getGelibiaoshiUser(jw)))
        );
    }

    @system.web.power.ann.SQ("loufangxmfS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangxmf_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                LoufangXMFService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                LoufangXMFService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.SQ("loufangxmfE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (LoufangXMFService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangXMFService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("loufangxmfUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (LoufangXMFService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangXMFService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("loufangxmfV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (LoufangXMFService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangXMFService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("loufangxmfUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (LoufangXMFService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangXMFService.updateStyle_unVoid(ids));
    }

}
