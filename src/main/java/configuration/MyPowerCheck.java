package configuration;

import system.web.JWeb;
import system.web.power.interfaces.UPM;
import system.web.power.interfaces.UPMDefault;

/**
 *
 * @author wo
 */
public class MyPowerCheck extends UPMDefault implements UPM {

    public static final MsgVO SQ_ERROR = MsgVO.setError("没有权限。请向管理员申请权限。");
    public static final MsgVO DL_ERROR = MsgVO.setError("会话超时，或未登陆。请登陆后再尝试");

    @Override
    public void ggSuccess(String url, JWeb jw) {
//        System.out.println("公共级的：" + url + "\n地址：" + jw.request.getRemoteAddr());
    }

    @Override//公共访问的url异常
    public void ggError(String url, JWeb jw) {
    }

    @Override//登陆状态验证通过
    public void dlSuccess(String url, JWeb jw) {
//        System.out.println("登陆状态验证通过：" + url + "\n地址：" + jw.request.getRemoteAddr());
    }

    @Override//未登陆
    public void dlError(String url, JWeb jw) {
        jw.printOne(DL_ERROR);
    }

    @Override//授权验证通过
    public void sqSuccess(String url, JWeb jw) {
//        if (url.startsWith("/xt")) {
//            System.out.println("访问了系统级资源：" + url + "\n地址：" + jw.request.getRemoteAddr());
//        }
    }

    @Override//授权检证失败
    public void sqError(String url, JWeb jw) {
        jw.printOne(SQ_ERROR);
//        System.out.println("访问了授权级资源失败的：" + url + "\n地址：" + jw.request.getRemoteAddr());
    }

    @Override//访问需要授权的，但未通过登录验证
    public void sqNotLogin(String url, JWeb jw) {
        jw.printOne(DL_ERROR);
//        System.out.println("访问了授权级资源,但未通过登录验证的：" + url + "\n地址：" + jw.request.getRemoteAddr());
    }
}
