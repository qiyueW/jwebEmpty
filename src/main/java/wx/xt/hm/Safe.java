package wx.xt.hm;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.ann.DL;
import system.web.power.ann.SQ;
import system.web.power.ann.ZDY;
import wx.web.bean.RY;
import wx.web.service.RYService;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.hm.vo.PasswordVO;
import wx.xt.service.XtGuanliyuanService;

/**
 * 修改密码、忘记密码专区
 * 
 * @author 汪春滋
 */
@H("/xt/safe")
public class Safe {
	// ==============超级管理员区==============
	@DL(PDK.SESSION_SUPER_ADMIN_KEY)
	@M("/admin1/update/password")
	public static void admin1_login(JWeb jw) {
		admin_updatepassworod(jw, Gelibiaoshi.getSuperAdminInfoBySession(jw));
	}
	// ==============总管与辅助混合区==========
	@DL(PDK.SESSION_ADMIN_KEY)
	@M("/admin23/update/password")
	public static void admin23_login(JWeb jw) {
		jw.forwardServlet(2 == Gelibiaoshi.getAdminInfoBySession(jw).getXt_guanliyuan_jibie() ? "/xt/safe/admin2/update/password" : "/xt/safe/admin3/update/password");
	}

	// ==============总管区==============
	@ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "updatepassword2")
	@M("/admin2/update/password")
	public static void admin2_login(JWeb jw) {
		admin_updatepassworod(jw, Gelibiaoshi.getAdminInfoBySession(jw));
	}

	// ==============辅管区==============
	@ZDY(zdy = configuration.zdy.SQ_Admin3.class, value = "updatepassword3")
	@M("/admin3/update/password")
	public static void admin3_login(JWeb jw) {
		admin_updatepassworod(jw, Gelibiaoshi.getAdminInfoBySession(jw));
	}

	// ==============管理员公共区==========
	private static void admin_updatepassworod(JWeb jw, XtGuanliyuan obj) {
		PasswordVO vo = new PasswordVO(jw, obj.getXt_guanliyuan_mima());
		if (vo.isError()) {
			return;
		}
		obj.setXt_guanliyuan_mima(vo.newpassword);
		jw.printOne(XtGuanliyuanService.update_password(obj));
	}

	// ==============业务员区==============
	@SQ(value = "updatepasswordUser")
	@M("/user/update/password")
	public static void user(JWeb jw) {
		RY obj = Gelibiaoshi.getUserInfoBySession(jw);
		PasswordVO vo = new PasswordVO(jw, obj.getRy_mima());
		if (vo.isError()) {
			return;
		}
		obj.setRy_mima(vo.newpassword);
		jw.printOne(RYService.update_password(obj));
	}
}
