package wx.xt.hm.xtryquanxian;

import configuration.MsgVO;
import plugins.easyui.EasyuiService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import system.web.power.PDK;
import wx.web.bean.RY;
import wx.web.service.RYService;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.XtRYQuanxian;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XtRYQuanxianService;

/**
 */
@system.web.power.ann.SQ(value = "xtryquanxian3", scope = PDK.SESSION_ADMIN_KEY)
@H("/xt/xtryquanxian3")
public class XtRYQuanxianHM3 {

	JWeb jw;

	public XtRYQuanxianHM3(JWeb jw) {
		this.jw = jw;
	}
	// ===================添加操作=============================
	// @system.web.power.ann.SQ("xtA")

	@M("/adu")
	@Validate(wx.xt.validate.XtRYQuanxianValidate.class)
	public void adu() {
		XtRYQuanxian obj = jw.getObject(XtRYQuanxian.class);
		System.out.println("0:"+obj);
		XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
		System.out.println("====0====");
		//这是部门辅管员，只能操作部门里的人员
		if (null != admin.getXt_guanliyuan_bm() && admin.getXt_guanliyuan_bm().length() > 23) {
			 RY ry=RYService.selectOne(obj.getXt_ry_zj());
			 if(!admin.getXt_guanliyuan_bm().contains(ry.getRy_bm_zj())) {
				 jw.printOne(MsgVO.setError("无法绑定你管理部门外的人员"));
				 return;
			 }
		}
		System.out.println("====1====");
		if (null == obj.getXt_juese_zj()) {
			obj.setXt_juese_zj("");
		}
		if (null == obj.getXt_quanxian()) {
			obj.setXt_quanxian("");
		}
		// 当前制单人的 进行绑定过的人员权限。
		XtRYQuanxian ryq = XtRYQuanxianService.selectOne(obj.getXt_ry_zj(), admin.getXt_guanliyuan_zj());
		if (null == ryq.getXt_ryquanxian_zj()||ryq.getXt_ryquanxian_zj().isEmpty()) {// 新增
			System.out.println("====add1====");
			obj.setXt_ryquanxian_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());// 传递隔离标识
			obj.setXt_ryquanxian_zhidanren(admin.getXt_guanliyuan_zj());// 制单人（管理员）主键
			jw.printOne(XtRYQuanxianService.addOne(obj));
			return;
		}
		System.out.println("====2====");
		ryq = XtRYQuanxianService.selectOne(obj.getXt_ryquanxian_zj());
		if(!ryq.getXt_ryquanxian_zhidanren().equals(admin.getXt_guanliyuan_zj())) {
			jw.printOne(MsgVO.setError("无法对别人绑定的权限进行修改。如果非要修改，请通知【总管】进行处理。"));
			return;
		}
		obj.setXt_ryquanxian_zj(ryq.getXt_ryquanxian_zj());
		jw.printOne(XtRYQuanxianService.update(obj));
	}
	// ===================删除操作=============================
	// @system.web.power.ann.SQ("xtD")

	@M("/remove")
	public void dellVast() {
		String ids = jw.getString("ids", "");
		if (ids.length() < 24) {
			return;
		}
		XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
		jw.printOne(XtRYQuanxianService.dellVast(ids, admin.getXt_guanliyuan_zj()));
	}
	// ===================修改操作=============================
	// =========表头查询操作===========
	// @system.web.power.ann.SQ("xtS")

	@M("/select/selectOne") // 针对表头的查询-一条记录的明细
	public void selectOne() {
		String id = jw.getString("id", "");
		if (id.isEmpty()) {
			return;
		}
		jw.printOne(XtRYQuanxianService.selectOne(id));
	}

	@M("/select/grid") // 针对表头的查询-返回Grid数据
	public static void selectGrid(JWeb jw) {
		XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
		String condition = wx.xt.service.XTTiaojianService.engineToSQLCondition(jw.getString("key"));
		if (condition.length() > 0) {
			condition = "AND (" + condition + ")";
		}
		jw.printOne(EasyuiService.formatGrid(XtRYQuanxianService.select(admin.getXt_guanliyuan_gelibiaoshi(), admin.getXt_guanliyuan_bm(), condition)));
	}

}
