package wx.xt.hm.xtryquanxian;

import java.util.Set;

import configuration.MsgVO;
import plugins.easyui.EasyuiService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.XtRYQuanxian;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.service.XTJueseQuanxianService;
import wx.xt.service.XtRYQuanxianService;

/**
 */
@system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtryquanxian2")
@H("/xt/xtryquanxian2")
public class XtRYQuanxianHM2 {

	JWeb jw;

	public XtRYQuanxianHM2(JWeb jw) {
		this.jw = jw;
	}
	// ===================添加操作=============================
	// @system.web.power.ann.SQ("xtA")

	@M("/adu")
	@Validate(wx.xt.validate.XtRYQuanxianValidate.class)
	public void adu() {
		XtRYQuanxian obj = jw.getObject(XtRYQuanxian.class);
		XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
		XtRYQuanxian myAdmin;
		if (null == obj.getXt_juese_zj()) {
			obj.setXt_juese_zj("");
		}
		if (null == obj.getXt_quanxian()) {
			obj.setXt_quanxian("");
		}
		//选中了自己的单据 或别人的单据
		if (null != obj.getXt_ryquanxian_zj() && obj.getXt_ryquanxian_zj().length() == 24) {
			//从后台取数
			XtRYQuanxian htobj = XtRYQuanxianService.selectOne(obj.getXt_ryquanxian_zj());
			//是否本公司的
	        if (XtRYQuanxianService.isErrorGelibiaoshiOne(htobj, Gelibiaoshi.getGelibiaoshiAdmin(jw))) {//存在别人家的隔离标识的单据
	            return;
	        }
	        //后台没有对应主键的记录（可能同时操作，被其他人删除）
			if (null == htobj || null == htobj.getXt_ryquanxian_zj()) {
				jw.printOne(MsgVO.setError("无法进行修改。没找到相应单据。"));
				return;
			}
			// 如果是别人的单据，总管是没权修改的。但可以移除别人的权限。
			// 如果是别人的单据，音并且总管没有绑定过此业务员，则进行添加一条记录，用于记录总管的绑定权限。
			// 对别人的权限，如果要调整，可以直接删除。重新附值。
			
			//别人绑定的单据
			if (!htobj.getXt_ryquanxian_zhidanren().equals(admin.getXt_guanliyuan_zj())) {
				myAdmin = XtRYQuanxianService.selectOne(obj.getXt_ry_zj(), admin.getXt_guanliyuan_zj());
				
				//如果当前人没有给此业务员绑定过权限，可以以当前登录的管理员为制单人，新加一条记录。
				if (null == myAdmin.getXt_ryquanxian_zj()) {
					obj.setXt_ryquanxian_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());// 传递隔离标识
					obj.setXt_ryquanxian_zhidanren(admin.getXt_guanliyuan_zj());// 制单人（管理员）主键
					MsgVO vo = XtRYQuanxianService.addOne(obj);
					jw.printOne(MsgVO.setOK("提示：<br/>1.无法修改别人绑定的权限<br/>2.系统帮你新增一条由你绑定权限的记录<br/>3.如果有您需要，可以【移除】别人的权限。" + "<br/><br/>你绑定的结果：【" + vo.msg + "】"));
					return;
				}
				//无法修改别人的单据
				jw.printOne(MsgVO.setError("无法修改别人绑定的权限。如果有需要，请进行【移除】该权限操作！"));
				return;
			}
			//修改自己的单据权限
			jw.printOne(XtRYQuanxianService.update(obj));
			return;
		}
		// 当前制单人的 进行绑定过的人员权限。
			obj.setXt_ryquanxian_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());// 传递隔离标识
			obj.setXt_ryquanxian_zhidanren(admin.getXt_guanliyuan_zj());// 制单人（管理员）主键
			jw.printOne(XtRYQuanxianService.addOne(obj));
	}
	// ===================删除操作=============================
	// @system.web.power.ann.SQ("xtD")

	@M("/remove")
	public void dellVast() {
		String ids = jw.getString("ids", "");
		if (ids.length() < 24) {
			return;
		}
        if (XtRYQuanxianService.isErrorGelibiaoshiOne(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
		jw.printOne(XtRYQuanxianService.dellVast(ids));
	}

	// ===================修改操作=============================
	@M("/select/selectOne") // 针对表头的查询-一条记录的明细
	public void selectOne() {
		String id = jw.getString("id", "");
		if (id.isEmpty()||id.length()!=24) {
			return;
		}
		XtRYQuanxian ryqx = XtRYQuanxianService.selectOne(id);
        if (XtRYQuanxianService.isErrorGelibiaoshiOne(ryqx, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
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
