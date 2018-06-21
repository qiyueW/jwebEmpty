package wx.xt.hm;

import javax.imageio.ImageIO;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletOutputStream;
import static plugins.safecede.kaptcha.KaptchaConfig.KAPTCHA_PRODUCER;
import static plugins.safecede.kaptcha.KaptchaConfig.SESSION_KEY_VALUE;
import static plugins.safecede.kaptcha.KaptchaConfig.SESSION_KEY_DATE_VALUE;

@H("/xt/yanzhengma")
public class SafeCode {
    @M("/tupian")
    public static void imgsafeCode(JWeb jw) {
        ServletOutputStream out = null;
        try {
            jw.response.setDateHeader("Expires", 0);
            jw.response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            jw.response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            jw.response.setHeader("Pragma", "no-cache");
            jw.response.setContentType("image/jpeg");
            String capText = KAPTCHA_PRODUCER.createText();
            jw.session.setAttribute(SESSION_KEY_VALUE, capText);
            jw.request.getSession().setAttribute(SESSION_KEY_DATE_VALUE, new Date());
            BufferedImage bi = KAPTCHA_PRODUCER.createImage(capText);
            out = jw.response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
        } catch (IOException ex) {
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }
}
