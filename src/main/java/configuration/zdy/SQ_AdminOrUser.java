package configuration.zdy;

import configuration.MyPowerCheck;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.interfaces.IZDY;
import system.web.power.session.Login;
import system.web.power.session.PISD;

/**
 * 管理员或用户拥有授权都可以通行。
 *
 * @author wangchunzi
 */
public class SQ_AdminOrUser implements IZDY {

    @Override
    public boolean denyByTrue(JWeb jw, String urlCode) {
        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object obj = jw.session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        Object admin = jw.session.getAttribute(PDK.SESSION_ADMIN_KEY);
        if (null == obj && null == admin) {//未登录
            jw.printOne(MyPowerCheck.DL_ERROR);
            return true;
        }
        PISD pobj = null == obj ? (PISD) admin : (PISD) obj;
        if (urlCode.contains(",")) {//如果是包含某一种授权时，都可通过时，进行分割检查。
            String[] uc = urlCode.split(",");
            for (int i = 0; i < uc.length; i++) {
                if (!Login.isNoThisPower(pobj, uc[i])) {//没有权限-取反：即有权限的情况下，立马返回false，表示通过检查
                    return false;//如果有权限，即返回false
                }
            }
            return true;
        }
        if (Login.isNoThisPower(pobj, urlCode)) {
            jw.printOne(MyPowerCheck.SQ_ERROR);
            return true;
        }
        return false;
    }
}
