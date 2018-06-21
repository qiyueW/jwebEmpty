package configuration;

/**
 *
 * @author wo
 */
public interface SafeCode {

//    boolean compareTimeByLastTime_trueByError();
//    long getLastTime();
    int getErrorCount();

    void clearErrorCount();

    /**
     * 取得session key
     *
     * @return
     */
    String getSessionKey();

    /**
     * 移除在session中的安全码
     */
    void removeSessionValue();

    /**
     * 校对验证码。
     *
     * @param code
     * @return
     */
    boolean isok(String code);

    /**
     * 校对验证码。采用默认的参数key自动获取用户传参，并进行校对
     *
     * @return
     */
    boolean isok();

}
