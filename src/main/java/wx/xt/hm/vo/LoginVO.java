package wx.xt.hm.vo;

import system.web.JWeb;

/**
 *
 * @author wo
 */
public class LoginVO {

    public String xt_gelibiaoshi;
    public String account;
    public String password;

    private boolean errorParam = false;

    public boolean isErrorParam() {
        return this.errorParam;
    }

    public LoginVO(JWeb jw) {
        this.account = jw.getString("account");
        this.password = jw.getString("password");
        this.xt_gelibiaoshi = jw.getString("xt_gelibiaoshi");
        if (null == xt_gelibiaoshi || null == account || null == password) {
            errorParam = true;
            return;
        }
        xt_gelibiaoshi = xt_gelibiaoshi.trim();
        account = account.trim();
        password = password.trim();
        if (xt_gelibiaoshi.isEmpty() || account.isEmpty() || password.isEmpty()) {
            errorParam = true;
            return;
        }
        if (xt_gelibiaoshi.length() > 20 || account.length() > 50 || password.length() > 50) {
            errorParam = true;
        }
    }
}
