package configuration;

import plugins.safecede.kaptcha.KaptchaConfig;
import system.web.JWeb;

/**
 *
 * @author wo
 */
public class IFactory {

    public static SafeCode getSafeCode_img(JWeb jw) {
        return new KaptchaConfig(jw);
    }
}
