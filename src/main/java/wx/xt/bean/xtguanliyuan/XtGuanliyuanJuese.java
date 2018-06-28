package wx.xt.bean.xtguanliyuan;

@system.base.annotation.Table
public class XtGuanliyuanJuese {

    @system.base.annotation.ID
    private  String xt_guanliyuanjuese_zj ;// 主键
    private  String xt_guanliyuan_zj ;// 管理员主键 
    private  String xt_juese_zj ;// 角色主键集合 
    private  String xt_guanliyuanjuese_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_guanliyuanjuese_zj\":\"").append(xt_guanliyuanjuese_zj).append("\"")
                .append(",\"xt_guanliyuan_zj\":\"").append(xt_guanliyuan_zj).append("\"")
                .append(",\"xt_juese_zj\":\"").append(xt_juese_zj).append("\"")
                .append(",\"xt_guanliyuanjuese_gelibiaoshi\":\"").append(xt_guanliyuanjuese_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_guanliyuanjuese_zj String
     */
    public void setXt_guanliyuanjuese_zj(String xt_guanliyuanjuese_zj) {
        this.xt_guanliyuanjuese_zj=xt_guanliyuanjuese_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_guanliyuanjuese_zj() {
        return this.xt_guanliyuanjuese_zj;
    }
    /**
     * 设置 管理员主键
     *
     * @param xt_guanliyuan_zj String
     */
    public void setXt_guanliyuan_zj(String xt_guanliyuan_zj) {
        this.xt_guanliyuan_zj=xt_guanliyuan_zj;
    }

    /**
     * 取得 管理员主键
     *
     * @return String
     */
    public String getXt_guanliyuan_zj() {
        return this.xt_guanliyuan_zj;
    }
    /**
     * 设置 角色主键集合
     *
     * @param xt_juese_zj String
     */
    public void setXt_juese_zj(String xt_juese_zj) {
        this.xt_juese_zj=xt_juese_zj;
    }

    /**
     * 取得 角色主键集合
     *
     * @return String
     */
    public String getXt_juese_zj() {
        return this.xt_juese_zj;
    }
    /**
     * 设置 隔离标识
     *
     * @param xt_guanliyuanjuese_gelibiaoshi String
     */
    public void setXt_guanliyuanjuese_gelibiaoshi(String xt_guanliyuanjuese_gelibiaoshi) {
        this.xt_guanliyuanjuese_gelibiaoshi=xt_guanliyuanjuese_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getXt_guanliyuanjuese_gelibiaoshi() {
        return this.xt_guanliyuanjuese_gelibiaoshi;
    }
}