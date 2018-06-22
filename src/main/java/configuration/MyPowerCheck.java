package configuration;

import system.web.JWeb;
import system.web.power.interfaces.UPM;
import system.web.power.interfaces.UPMDefault;

/**
 *
 * @author wo
 */
public class MyPowerCheck extends UPMDefault implements UPM {
    @Override
    public void ggSuccess(String url, JWeb jw) {
        System.out.println("公共级的："+url+"\n地址："+jw.request.getRemoteAddr());
    }
    @Override//公共访问的url异常
    public void ggError(String url, JWeb jw) {
    }

    @Override//登陆状态验证通过
    public void dlSuccess(String url, JWeb jw) {
         System.out.println("登陆状态验证通过："+url+"\n地址："+jw.request.getRemoteAddr());
    }

    @Override//未登陆
    public void dlError(String url, JWeb jw) {
        System.out.println("未登陆，无法访问:" + url);
    }

    @Override//授权验证通过
    public void sqSuccess(String url, JWeb jw) {
        if(url.startsWith("/xt")){
            System.out.println("访问了系统级资源："+url+"\n地址："+jw.request.getRemoteAddr());
        }
    }

    @Override//授权检证失败
    public void sqError(String url, JWeb jw) {
        System.out.println("访问了授权级资源失败的："+url+"\n地址："+jw.request.getRemoteAddr());
    }

    @Override//访问需要授权的，但未通过登录验证
    public void sqNotLogin(String url, JWeb jw) {
        System.out.println("访问了授权级资源,但未通过登录验证的："+url+"\n地址："+jw.request.getRemoteAddr());
    }
}
