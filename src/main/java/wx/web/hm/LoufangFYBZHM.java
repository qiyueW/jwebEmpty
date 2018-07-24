package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.web.bean.LoufangFYBZ;
import wx.web.service.LoufangFYBZService;
import wx.xt.Gelibiaoshi;
@H("/base/loufangfybz")
public class LoufangFYBZHM {

    JWeb jw;

    public LoufangFYBZHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    @system.web.power.ann.SQ("loufangfybzA")
    @M("/save")
    @Validate(wx.web.validate.LoufangFYBZValidate.class)
    public void add() {
        LoufangFYBZ obj = jw.getObject(LoufangFYBZ.class);
        obj.setLoufang_fybz_gelibiaoshi(Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(LoufangFYBZService.addOne(obj));
    }
//===================删除操作=============================    
    @system.web.power.ann.SQ("loufangfybzD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (LoufangFYBZService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFYBZService.dellOne(id));
    }
//===================修改操作=============================    
    @system.web.power.ann.SQ("loufangfybzU")
    @M("/update")
    @Validate(wx.web.validate.LoufangFYBZValidate.class)
	public void update() {
		LoufangFYBZ obj = jw.getObject(LoufangFYBZ.class);
		if (null == obj.getLoufang_fybz_zj() || obj.getLoufang_fybz_zj().length() != 24)
			return;
        if (LoufangFYBZService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFYBZService.update(obj));
	}
    @system.web.power.ann.SQ("loufangfybzU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        LoufangFYBZ obj =  LoufangFYBZService.selectOne(id);
        if (null == obj.getLoufang_fybz_zj()) {
            return;
        }
        if (LoufangFYBZService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangFYBZ", obj);
        jw.forward("/admin/base/loufangfybz/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("loufangfybzS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
	public void selectOne() {
		String id = jw.getString("id");
		LoufangFYBZ obj = LoufangFYBZService.selectOne(id);
		if (null == obj.getLoufang_fybz_zj())
			return;
        if (LoufangFYBZService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
		jw.request.setAttribute("LoufangFYBZ", obj);
		jw.forward("/admin/base/loufangfybz/one.jsp");
	}

    @system.web.power.ann.SQ("loufangfybzS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufang_fybz_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(LoufangFYBZService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("loufangfybzS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufang_fybz_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
            LoufangFYBZService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
            LoufangFYBZService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------
    @system.web.power.ann.SQ("loufangfybzE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (LoufangFYBZService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFYBZService.updateStyle_examine(ids));
    }
    @system.web.power.ann.SQ("loufangfybzUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (LoufangFYBZService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFYBZService.updateStyle_unExamine(ids));
    }
    @system.web.power.ann.SQ("loufangfybzV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (LoufangFYBZService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFYBZService.updateStyle_void(ids));
    }
    @system.web.power.ann.SQ("loufangfybzUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (LoufangFYBZService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFYBZService.updateStyle_unVoid(ids));
    }


}
