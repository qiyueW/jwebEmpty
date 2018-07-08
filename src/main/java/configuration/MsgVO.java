package configuration;

/**
 *
 * @author wo
 */
public class MsgVO {

    public final String key;
    public final String msg;

    public String getResponseMsg() {
        StringBuilder sb = new StringBuilder();
        return sb.append("{\"statusCode\":\"").append(this.key).append("\",\"msg\":\"").append(this.msg).append("\"}").toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("{\"statusCode\":\"").append(this.key).append("\",\"msg\":\"").append(this.msg).append("\"}").toString();
    }

    public MsgVO(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    /**
     * 操作成功的
     *
     * @param msg
     * @return
     */
    public static MsgVO setOK(final String msg) {
        return new MsgVO("1", msg);//"操作成功"
    }

    /**
     * 操作成功的
     *
     * @return
     */
    public static MsgVO setOK() {
        return new MsgVO("1", "操作成功");//
    }

    /**
     * 操作不成功的
     *
     * @param msg
     * @return
     */
    public static MsgVO setNotOK(final String msg) {
        return new MsgVO("0", msg);//"操作成功"
    }

    /**
     * 操作不成功的
     *
     * @return
     */
    public static MsgVO setNotOK() {
        return new MsgVO("0", "操作不成功");//
    }

    public static MsgVO setError() {
        return new MsgVO("-1", "执行异常");//
    }

    public static MsgVO setError(final String msg) {
        return new MsgVO("-1", msg);//
    }

    /**
     * 操作不成功的:单据已锁定
     *
     * @param msg
     * @return
     */
    public static MsgVO setNotOK_lock(final String msg) {
        return new MsgVO("0", "操作失败：单据已锁定");//"操作成功"
    }

    /**
     * 添加的
     *
     * @param key
     * @return
     */
    public static MsgVO setAddRS(int key) {
        if (key == -1) {
            return setError("添加操作异常");
        }
        return key == 1 ? setOK("添加成功") : setNotOK("添加失败");
    }

    /**
     * 删除操作
     *
     * @param key
     * @return
     */
    public static MsgVO setDellRS(int key) {
        if (key == -1) {
            return setError("删除操作异常");
        }
        return key > 0 ? setOK("删除成功") : setNotOK("删除失败");
    }

    /**
     * 删除操作
     *
     * @param key
     * @return
     */
    public static MsgVO setUpdateRS(int key) {
        if (key == -1) {
            return setError("修改异常操作异常");
        }
        return key > 0 ? setOK("修改成功") : setNotOK("修改失败");
    }
}
