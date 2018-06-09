package wx.xt.bean.xttiaojian;

@system.base.annotation.Table
public class XTTiaojian {

    @system.base.annotation.ID
    private String xt_tiaojian_zj;// 主键
    private String xt_shezhi_tiaojian_zj;// 模块主键 
    private String xt_shezhi_tiaojian_mc;// 模块名称 
    private String xt_shezhi_tiaojian_zhi;// 使用值 
    private String xt_tiaojian_mc;// 条件方案名称 
    private String xt_tiaojian_zhidanren_zj;// 方案制定人主键 
    private String xt_tiaojian_zhidanren;// 制定人名称 
    private String xt_tiaojian_gelibiaoshi;// 单据隔离标识 
    private Integer xt_tiaojian_zt;// 状态 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_tiaojian_zj\":\"").append(xt_tiaojian_zj).append("\"")
                .append(",\"xt_shezhi_tiaojian_zj\":\"").append(xt_shezhi_tiaojian_zj).append("\"")
                .append(",\"xt_shezhi_tiaojian_mc\":\"").append(xt_shezhi_tiaojian_mc).append("\"")
                .append(",\"xt_shezhi_tiaojian_zhi\":\"").append(xt_shezhi_tiaojian_zhi).append("\"")
                .append(",\"xt_tiaojian_mc\":\"").append(xt_tiaojian_mc).append("\"")
                .append(",\"xt_tiaojian_zhidanren_zj\":\"").append(xt_tiaojian_zhidanren_zj).append("\"")
                .append(",\"xt_tiaojian_zhidanren\":\"").append(xt_tiaojian_zhidanren).append("\"")
                .append(",\"xt_tiaojian_gelibiaoshi\":\"").append(xt_tiaojian_gelibiaoshi).append("\"")
                .append(",\"xt_tiaojian_zt\":\"").append(xt_tiaojian_zt).append("\"}");
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_tiaojian_zj String
     */
    public void setXt_tiaojian_zj(String xt_tiaojian_zj) {
        this.xt_tiaojian_zj = xt_tiaojian_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_tiaojian_zj() {
        return this.xt_tiaojian_zj;
    }

    /**
     * 设置 模块主键
     *
     * @param xt_shezhi_tiaojian_zj String
     */
    public void setXt_shezhi_tiaojian_zj(String xt_shezhi_tiaojian_zj) {
        this.xt_shezhi_tiaojian_zj = xt_shezhi_tiaojian_zj;
    }

    /**
     * 取得 模块主键
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian_zj() {
        return this.xt_shezhi_tiaojian_zj;
    }

    /**
     * 设置 模块名称
     *
     * @param xt_shezhi_tiaojian_mc String
     */
    public void setXt_shezhi_tiaojian_mc(String xt_shezhi_tiaojian_mc) {
        this.xt_shezhi_tiaojian_mc = xt_shezhi_tiaojian_mc;
    }

    /**
     * 取得 模块名称
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian_mc() {
        return this.xt_shezhi_tiaojian_mc;
    }

    /**
     * 设置 使用值
     *
     * @param xt_shezhi_tiaojian_zhi String
     */
    public void setXt_shezhi_tiaojian_zhi(String xt_shezhi_tiaojian_zhi) {
        this.xt_shezhi_tiaojian_zhi = xt_shezhi_tiaojian_zhi;
    }

    /**
     * 取得 使用值
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian_zhi() {
        return this.xt_shezhi_tiaojian_zhi;
    }

    /**
     * 设置 条件方案名称
     *
     * @param xt_tiaojian_mc String
     */
    public void setXt_tiaojian_mc(String xt_tiaojian_mc) {
        this.xt_tiaojian_mc = xt_tiaojian_mc;
    }

    /**
     * 取得 条件方案名称
     *
     * @return String
     */
    public String getXt_tiaojian_mc() {
        return this.xt_tiaojian_mc;
    }

    /**
     * 设置 方案制定人主键
     *
     * @param xt_tiaojian_zhidanren_zj String
     */
    public void setXt_tiaojian_zhidanren_zj(String xt_tiaojian_zhidanren_zj) {
        this.xt_tiaojian_zhidanren_zj = xt_tiaojian_zhidanren_zj;
    }

    /**
     * 取得 方案制定人主键
     *
     * @return String
     */
    public String getXt_tiaojian_zhidanren_zj() {
        return this.xt_tiaojian_zhidanren_zj;
    }

    /**
     * 设置 制定人名称
     *
     * @param xt_tiaojian_zhidanren String
     */
    public void setXt_tiaojian_zhidanren(String xt_tiaojian_zhidanren) {
        this.xt_tiaojian_zhidanren = xt_tiaojian_zhidanren;
    }

    /**
     * 取得 制定人名称
     *
     * @return String
     */
    public String getXt_tiaojian_zhidanren() {
        return this.xt_tiaojian_zhidanren;
    }

    /**
     * 设置 单据隔离标识
     *
     * @param xt_tiaojian_gelibiaoshi String
     */
    public void setXt_tiaojian_gelibiaoshi(String xt_tiaojian_gelibiaoshi) {
        this.xt_tiaojian_gelibiaoshi = xt_tiaojian_gelibiaoshi;
    }

    /**
     * 取得 单据隔离标识
     *
     * @return String
     */
    public String getXt_tiaojian_gelibiaoshi() {
        return this.xt_tiaojian_gelibiaoshi;
    }

    /**
     * 设置 状态
     *
     * @param xt_tiaojian_zt Integer
     */
    public void setXt_tiaojian_zt(Integer xt_tiaojian_zt) {
        this.xt_tiaojian_zt = xt_tiaojian_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getXt_tiaojian_zt() {
        return this.xt_tiaojian_zt;
    }
}
