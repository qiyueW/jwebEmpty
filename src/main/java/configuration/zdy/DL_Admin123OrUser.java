package configuration.zdy;

import configuration.MyPowerCheck;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.interfaces.IZDY;

/**
 * 管理员或用户拥有授权都可以通行。
 *
 * @author wangchunzi
 */
public class DL_Admin123OrUser implements IZDY {

    @Override
    public boolean denyByTrue(JWeb jw, String urlCode) {
        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object obj = jw.session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        if (null != obj) {
            return false;
        }
        obj = jw.session.getAttribute(PDK.SESSION_ADMIN_KEY);
        if (null != obj) {
            return false;
        }
        obj = jw.session.getAttribute(PDK.SESSION_SUPER_ADMIN_KEY);
        if (null == obj) {
            jw.printOne(MyPowerCheck.DL_ERROR);
            return true;
        }
        return false;
    }
}
