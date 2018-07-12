package wx.xt.hm.xtguanliyuan;

import configuration.MsgVO;
import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XtGuanliyuanService;

/**
 * 总管专用通道
 */
@system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "")
@H("/xt/xtguanliyuan2")
public class XtGuanliyuan2HM {

    JWeb jw;

    public XtGuanliyuan2HM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2A")
    @M("/save")
    @Validate(wx.xt.validate.XtGuanliyuanValidate.class)
    public void add() {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        obj.setXt_guanliyuan_jibie(3);
        obj.setXt_guanliyuan_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(XtGuanliyuanService.addOne(obj));
    }
//===================删除操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2D")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (XtGuanliyuanService.isErrorGelibiaoshi(id, jw)) {
            return;
        }
        jw.printOne(XtGuanliyuanService.dellOne(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2U")
    @M("/update")
    @Validate(wx.xt.validate.XtGuanliyuanValidate.class)
    public void update() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.printOne(XtGuanliyuanService.update(obj));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2U")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.request.setAttribute("XtGuanliyuan", obj);
        jw.forward("/xt/xtguanliyuan/edit2.jsp");
    }
    
    /**
	 * 重置辅管级的密码
	 */
	@M("/update/password3")
	public void updatePassword2() {
		String id = jw.getString("id");
		String newpassword=jw.getString("newpassword","");
		if(id.length()!=24||newpassword.trim().isEmpty()) {
			return;
		}
		XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
		if (null == obj.getXt_guanliyuan_zj()) {
			return;
		}
		if(obj.getXt_guanliyuan_jibie()!=3) {
			jw.printOne(MsgVO.setError("只能重置辅管的密码。"));
			return;
		}
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {//非同个隔离标识
            return;
        }
        obj.setXt_guanliyuan_mima(newpassword);
		jw.printOne(XtGuanliyuanService.update_password(obj));
	}
	
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2S")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.request.setAttribute("XtGuanliyuan", obj);
        jw.forward("/xt/xtguanliyuan/one2.jsp");
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2S")
    @M("/select/selectOne/json")//查询权限
    public void selectOneByJson() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.printOne(obj.toString());
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2S")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_guanliyuan_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(XtGuanliyuanService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2S")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_guanliyuan_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                XtGuanliyuanService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                XtGuanliyuanService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2E")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_examine(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2UE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (ids.contains(admin.getXt_guanliyuan_zj())) {
            jw.printOne(MsgVO.setError("无法自己反审自己。这会引起无法登陆的异常"));
            return;
        }
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2V")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_void(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuan2UV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_unVoid(ids));
    }

}
