package wx.xt.bean.xtshezhitiaojian;

@system.base.annotation.Table
public class XTShezhiTiaojian1 {

    @system.base.annotation.ID
    private  String xt_shezhi_tiaojian1_zj ;// 主键
    private  String xt_shezhi_tiaojian_zj ;// 表头主键 
    private  String xt_shezhi_tiaojian1_mc ;// 条件名 
    private  String xt_shezhi_tiaojian1_zhi ;// 条件值 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_shezhi_tiaojian1_zj\":\"").append(xt_shezhi_tiaojian1_zj).append("\"")
                .append(",\"xt_shezhi_tiaojian_zj\":\"").append(xt_shezhi_tiaojian_zj).append("\"")
                .append(",\"xt_shezhi_tiaojian1_mc\":\"").append(xt_shezhi_tiaojian1_mc).append("\"")
                .append(",\"xt_shezhi_tiaojian1_zhi\":\"").append(xt_shezhi_tiaojian1_zhi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_shezhi_tiaojian1_zj String
     */
    public void setXt_shezhi_tiaojian1_zj(String xt_shezhi_tiaojian1_zj) {
        this.xt_shezhi_tiaojian1_zj=xt_shezhi_tiaojian1_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian1_zj() {
        return this.xt_shezhi_tiaojian1_zj;
    }
    /**
     * 设置 表头主键
     *
     * @param xt_shezhi_tiaojian_zj String
     */
    public void setXt_shezhi_tiaojian_zj(String xt_shezhi_tiaojian_zj) {
        this.xt_shezhi_tiaojian_zj=xt_shezhi_tiaojian_zj;
    }

    /**
     * 取得 表头主键
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian_zj() {
        return this.xt_shezhi_tiaojian_zj;
    }
    /**
     * 设置 条件名
     *
     * @param xt_shezhi_tiaojian1_mc String
     */
    public void setXt_shezhi_tiaojian1_mc(String xt_shezhi_tiaojian1_mc) {
        this.xt_shezhi_tiaojian1_mc=xt_shezhi_tiaojian1_mc;
    }

    /**
     * 取得 条件名
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian1_mc() {
        return this.xt_shezhi_tiaojian1_mc;
    }
    /**
     * 设置 条件值
     *
     * @param xt_shezhi_tiaojian1_zhi String
     */
    public void setXt_shezhi_tiaojian1_zhi(String xt_shezhi_tiaojian1_zhi) {
        this.xt_shezhi_tiaojian1_zhi=xt_shezhi_tiaojian1_zhi;
    }

    /**
     * 取得 条件值
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian1_zhi() {
        return this.xt_shezhi_tiaojian1_zhi;
    }
}