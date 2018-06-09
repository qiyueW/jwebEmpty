package wx.xt.bean.xtshezhitiaojian;

@system.base.annotation.Table
public class XTShezhiTiaojian {

    @system.base.annotation.ID
    private  String xt_shezhi_tiaojian_zj ;// 主键
    private  String xt_shezhi_tiaojian_mc ;// 展示名称 
    private  String xt_shezhi_tiaojian_zhi ;// 使用值 
    private  String xt_shezhi_tiaojian_bz ;// 备注 
    private  Integer xt_shezhi_tiaojian_zt ;// 单据状态管理 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_shezhi_tiaojian_zj\":\"").append(xt_shezhi_tiaojian_zj).append("\"")
                .append(",\"xt_shezhi_tiaojian_mc\":\"").append(xt_shezhi_tiaojian_mc).append("\"")
                .append(",\"xt_shezhi_tiaojian_zhi\":\"").append(xt_shezhi_tiaojian_zhi).append("\"")
                .append(",\"xt_shezhi_tiaojian_bz\":\"").append(xt_shezhi_tiaojian_bz).append("\"")
                .append(",\"xt_shezhi_tiaojian_zt\":\"").append(xt_shezhi_tiaojian_zt).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_shezhi_tiaojian_zj String
     */
    public void setXt_shezhi_tiaojian_zj(String xt_shezhi_tiaojian_zj) {
        this.xt_shezhi_tiaojian_zj=xt_shezhi_tiaojian_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian_zj() {
        return this.xt_shezhi_tiaojian_zj;
    }
    /**
     * 设置 展示名称
     *
     * @param xt_shezhi_tiaojian_mc String
     */
    public void setXt_shezhi_tiaojian_mc(String xt_shezhi_tiaojian_mc) {
        this.xt_shezhi_tiaojian_mc=xt_shezhi_tiaojian_mc;
    }

    /**
     * 取得 展示名称
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
        this.xt_shezhi_tiaojian_zhi=xt_shezhi_tiaojian_zhi;
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
     * 设置 备注
     *
     * @param xt_shezhi_tiaojian_bz String
     */
    public void setXt_shezhi_tiaojian_bz(String xt_shezhi_tiaojian_bz) {
        this.xt_shezhi_tiaojian_bz=xt_shezhi_tiaojian_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian_bz() {
        return this.xt_shezhi_tiaojian_bz;
    }
    /**
     * 设置 单据状态管理
     *
     * @param xt_shezhi_tiaojian_zt Integer
     */
    public void setXt_shezhi_tiaojian_zt(Integer xt_shezhi_tiaojian_zt) {
        this.xt_shezhi_tiaojian_zt=xt_shezhi_tiaojian_zt;
    }

    /**
     * 取得 单据状态管理
     *
     * @return Integer
     */
    public Integer getXt_shezhi_tiaojian_zt() {
        return this.xt_shezhi_tiaojian_zt;
    }
}