package wx.xt.bean.xtjuese;

@system.base.annotation.Table
public class XTJueseQuanxian {

    @system.base.annotation.ID
    private  String xt_juesequanxian_zj ;// 主键
    private  String xt_juese_zj ;// 角色主键 
    private  String xt_juese_dm ;// 角色代码 
    private  String xt_quanxian ;// 权限集合 
    private  String xt_zhidanren_zj ;// 制单人 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_juesequanxian_zj\":\"").append(xt_juesequanxian_zj).append("\"")
                .append(",\"xt_juese_zj\":\"").append(xt_juese_zj).append("\"")
                .append(",\"xt_juese_dm\":\"").append(xt_juese_dm).append("\"")
                .append(",\"xt_quanxian\":\"").append(xt_quanxian).append("\"")
                .append(",\"xt_zhidanren_zj\":\"").append(xt_zhidanren_zj).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_juesequanxian_zj String
     */
    public void setXt_juesequanxian_zj(String xt_juesequanxian_zj) {
        this.xt_juesequanxian_zj=xt_juesequanxian_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_juesequanxian_zj() {
        return this.xt_juesequanxian_zj;
    }
    /**
     * 设置 角色主键
     *
     * @param xt_juese_zj String
     */
    public void setXt_juese_zj(String xt_juese_zj) {
        this.xt_juese_zj=xt_juese_zj;
    }

    /**
     * 取得 角色主键
     *
     * @return String
     */
    public String getXt_juese_zj() {
        return this.xt_juese_zj;
    }
    /**
     * 设置 角色代码
     *
     * @param xt_juese_dm String
     */
    public void setXt_juese_dm(String xt_juese_dm) {
        this.xt_juese_dm=xt_juese_dm;
    }

    /**
     * 取得 角色代码
     *
     * @return String
     */
    public String getXt_juese_dm() {
        return this.xt_juese_dm;
    }
    /**
     * 设置 权限集合
     *
     * @param xt_quanxian String
     */
    public void setXt_quanxian(String xt_quanxian) {
        this.xt_quanxian=xt_quanxian;
    }

    /**
     * 取得 权限集合
     *
     * @return String
     */
    public String getXt_quanxian() {
        return this.xt_quanxian;
    }
    /**
     * 设置 制单人
     *
     * @param xt_zhidanren_zj String
     */
    public void setXt_zhidanren_zj(String xt_zhidanren_zj) {
        this.xt_zhidanren_zj=xt_zhidanren_zj;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getXt_zhidanren_zj() {
        return this.xt_zhidanren_zj;
    }
}