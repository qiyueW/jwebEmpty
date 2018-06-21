package plugins.safecede.kaptcha;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import configuration.SafeCode;
import java.util.Properties;
import javax.imageio.ImageIO;
import system.web.JWeb;

/**
 *
 * @author wo
 */
public class KaptchaConfig implements SafeCode {

    public static final Properties PROPS = new Properties();
    public static final Producer KAPTCHA_PRODUCER;
    public static final String SESSION_KEY_VALUE;
    public static final String PARAM_KEY_VALUE = "xt_safecode";
    public static final String SESSION_KEY_DATE_VALUE;
    public static final long LIMIT_TIME = 500;//登录间隔至少要达到多少时间算有校
    public static final String COUNT_KEY = "xt_error_count";//记录登录错误了几个。
    public static final int COUNT = 2;//登录错5次后，开始验证码。

    private final JWeb jw;

    public KaptchaConfig(JWeb jw) {
        this.jw = jw;
        addCount();
    }

    static {
        ImageIO.setUseCache(false);
        //设置宽和高。
        PROPS.put(Constants.KAPTCHA_IMAGE_WIDTH, "200");
        PROPS.put(Constants.KAPTCHA_IMAGE_HEIGHT, "60");
        //kaptcha.border：是否显示边框。
        PROPS.put(Constants.KAPTCHA_BORDER, "no");
        //kaptcha.textproducer.font.color：字体颜色
        PROPS.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        //kaptcha.textproducer.char.space：字符间距
        PROPS.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");
        PROPS.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "6");
        //设置字体。
        PROPS.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");

        Config config1 = new Config(PROPS);
        KAPTCHA_PRODUCER = config1.getProducerImpl();
        SESSION_KEY_VALUE = config1.getSessionKey();
        SESSION_KEY_DATE_VALUE = config1.getSessionDate();
    }

    @Override
    public String getSessionKey() {
        return SESSION_KEY_VALUE;
    }

    @Override
    public void removeSessionValue() {
        jw.session.removeAttribute(SESSION_KEY_VALUE);
    }

    @Override
    public boolean isok(String code) {
        if (null == code || code.length() != 6) {
            return false;
        }
        Object systemCode = jw.session.getAttribute(SESSION_KEY_VALUE);
        if (null == systemCode) {
            return false;
        }
        jw.session.removeAttribute(SESSION_KEY_VALUE);
        jw.session.removeAttribute(SESSION_KEY_DATE_VALUE);
        return systemCode.toString().equalsIgnoreCase(code);
    }

    @Override
    public boolean isok() {
        if (getErrorCount() <= COUNT) {//可以进行非验证码状态
            jw.session.removeAttribute(SESSION_KEY_VALUE);
            jw.session.removeAttribute(SESSION_KEY_DATE_VALUE);
            return true;
        }
        Object userCode = jw.request.getParameter(PARAM_KEY_VALUE);
        Object systemCode = jw.session.getAttribute(SESSION_KEY_VALUE);
        if (null == userCode || null == systemCode) {
            return false;
        }
        String code = userCode.toString();
        if (code.length() != 6) {
            return false;
        }
        jw.session.removeAttribute(SESSION_KEY_VALUE);
        jw.session.removeAttribute(SESSION_KEY_DATE_VALUE);
        return systemCode.toString().equalsIgnoreCase(code);
    }

    private void addCount() {
        Object count = jw.session.getAttribute(COUNT_KEY);
        if (null == count) {//第一次登录
            jw.session.setAttribute(COUNT_KEY, 1);
            return;
        }
        jw.session.setAttribute(COUNT_KEY, ((int) count) + 1);
    }

    @Override
    public int getErrorCount() {
        Object count = jw.session.getAttribute(COUNT_KEY);
        if (null == count) {//第一次登录
            return 0;
        }
        return (int) count;
    }

    @Override
    public void clearErrorCount() {
        jw.session.removeAttribute(COUNT_KEY);
    }
}
