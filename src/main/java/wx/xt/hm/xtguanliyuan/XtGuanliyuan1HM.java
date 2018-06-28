package wx.xt.hm.xtguanliyuan;

import configuration.MsgVO;
import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XtGuanliyuanService;

@H("/xt/xtguanliyuan1")
public class XtGuanliyuan1HM {

    JWeb jw;

    public XtGuanliyuan1HM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xtguanliyuanA")

    @M("/save")
    @Validate(wx.xt.validate.XtGuanliyuanValidate.class)
    public void add() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        obj.setXt_guanliyuan_jibie(2);
        if (XtGuanliyuanService.selectCount("WHERE xt_guanliyuan_jibie=2 AND xt_guanliyuan_gelibiaoshi='" + obj.getXt_guanliyuan_gelibiaoshi() + "'") > 0) {
            jw.printOne(MsgVO.setError("添加失败，已经存在标识为" + obj.getXt_guanliyuan_gelibiaoshi() + "的总管"));
            return;
        }
        jw.printOne(XtGuanliyuanService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("xtguanliyuanD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(XtGuanliyuanService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("xtguanliyuanU")

    @M("/update")
    @Validate(wx.xt.validate.XtGuanliyuanValidate.class)
    public void update() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        if (null == obj.getXt_guanliyuan_zj() || obj.getXt_guanliyuan_zj().length() != 24) {
            return;
        }
        jw.printOne(XtGuanliyuanService.update(obj));
    }

    //@system.web.power.ann.SQ("xtguanliyuanU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (null == obj.getXt_guanliyuan_zj()) {
            return;
        }
        jw.request.setAttribute("XtGuanliyuan", obj);
        jw.forward("/xt/xtguanliyuan/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    //@system.web.power.ann.SQ("xtguanliyuanS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (null == obj.getXt_guanliyuan_zj()) {
            return;
        }
        jw.request.setAttribute("XtGuanliyuan", obj);
        jw.forward("/xt/xtguanliyuan/one.jsp");
    }

    //@system.web.power.ann.SQ("xtguanliyuanS") 
    @M("/select/selectOne/json")//查询权限
    public void selectOneByJson() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (null == obj.getXt_guanliyuan_zj()) {
            return;
        }
        jw.printOne(obj.toString());
    }

    //@system.web.power.ann.SQ("xtguanliyuanS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw);
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(XtGuanliyuanService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    //@system.web.power.ann.SQ("xtguanliyuanS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw);
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                XtGuanliyuanService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                XtGuanliyuanService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(XtGuanliyuanService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(XtGuanliyuanService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(XtGuanliyuanService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(XtGuanliyuanService.updateStyle_unVoid(jw.getString("ids")));
    }

}
