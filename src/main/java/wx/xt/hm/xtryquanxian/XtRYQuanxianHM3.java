package wx.xt.hm.xtryquanxian;

import java.util.Set;

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
import wx.xt.service.XTJueseQuanxianService;
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
		XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
		//这是部门辅管员，只能操作部门里的人员
		if (null != admin.getXt_guanliyuan_bm() && admin.getXt_guanliyuan_bm().length() > 23) {
			 RY ry=RYService.selectOne(obj.getXt_ry_zj());
			 if(!admin.getXt_guanliyuan_bm().contains(ry.getRy_bm_zj())) {
				 jw.printOne(MsgVO.setError("无法绑定你管理部门外的人员"));
				 return;
			 }
		}
		if (null == obj.getXt_juese_zj()) {
			obj.setXt_juese_zj("");
		}
		if (null == obj.getXt_quanxian()) {
			obj.setXt_quanxian("");
		}
		// 当前制单人的 进行绑定过的人员权限。
		XtRYQuanxian ryq = XtRYQuanxianService.selectOne(obj.getXt_ry_zj(), admin.getXt_guanliyuan_zj());
		if (null == ryq.getXt_ryquanxian_zj()||ryq.getXt_ryquanxian_zj().isEmpty()) {// 新增
			obj.setXt_ryquanxian_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());// 传递隔离标识
			obj.setXt_ryquanxian_zhidanren(admin.getXt_guanliyuan_zj());// 制单人（管理员）主键
			jw.printOne(XtRYQuanxianService.addOne(obj));
			return;
		}
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
		if (id.isEmpty()||id.length()!=24) {
			return;
		}
		XtRYQuanxian ryqx = XtRYQuanxianService.selectOne(id);
		XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
		// 查看的是自己的记录
		// 或都没有角色的-别人的权限。
		if (ryqx.getXt_ryquanxian_zhidanren().equals(admin.getXt_guanliyuan_zj()) || null == ryqx.getXt_juese_zj() || ryqx.getXt_juese_zj().isEmpty()) {
			jw.printOne(ryqx);
			return;
		}
		// 别的管理员给业务员绑定过权限，可能是通过角色绑定权限。所以要合并角色的权限。
		// 检出相关联的角色（审核）权限。
		Set<String> juesepower = XTJueseQuanxianService.selectByJuese_shenhe(ryqx.getXt_juese_zj());
		if (juesepower.isEmpty()) {
			jw.printOne(ryqx);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (String str : juesepower) {
			sb.append(",").append(str);
		}
		// 如果人员没有直接权限，则将角色关联的-权限直接放进去（截去第一个字符，）
		if (ryqx.getXt_quanxian().isEmpty()) {
			ryqx.setXt_quanxian(sb.substring(1));
			jw.printOne(ryqx);
			return;
		}
		ryqx.setXt_quanxian(ryqx.getXt_quanxian() + sb.toString());
		jw.printOne(ryqx);
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
