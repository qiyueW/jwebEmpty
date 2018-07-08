package wx.xt.hm.vo;

import configuration.MsgVO;
import system.web.JWeb;

/**
 *
 * @author 汪春滋
 */
public class PasswordVO {
	
	private final String mypassword;//现在的密码
	private final JWeb jw;
	private final String oldpassword;//校对的密码
	public final String newpassword;//新密码
	
	public boolean isError() {
		if (oldpassword.isEmpty() || newpassword.isEmpty()) {
			return true;
		}
		if(!this.mypassword.equals(oldpassword)) {
			jw.printOne(MsgVO.setError("原密码输入有误，无法更改密码"));
			return true;
		}
		return false;
	}

	public PasswordVO(final JWeb jw, final String mypassword) {
		this.mypassword = mypassword;
		this.jw=jw;
		this.oldpassword = jw.getString("oldpassword", "").trim();
		this.newpassword = jw.getString("newpassword", "").trim();
	}

}
