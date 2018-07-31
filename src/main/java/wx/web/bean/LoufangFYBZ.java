package wx.web.bean;

@system.base.annotation.Table
public class LoufangFYBZ {

    @system.base.annotation.ID
    private String loufang_fybz_zj;// 主键
    private String loufang_fybz_loufang_zj;// 楼房主键
    private String loufang_fybz_loufang_mc;// 楼名
    private Double loufang_fybz_dianfei;// 电费标准
    private Double loufang_fybz_shuifei;// 水费标准
    private Double loufang_fybz_shuifei_leng;// 冷水费标准
    private Double loufang_fybz_shuifei_re;// 热水费标准
    private Double loufang_fybz_meiqi;// 煤气费标准
    private Integer loufang_fybz_zt;// 状态
    private String loufang_fybz_gelibiaoshi;// 隔离标识

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufang_fybz_zj\":\"").append(loufang_fybz_zj).append("\"")
                .append(",\"loufang_fybz_loufang_zj\":\"").append(loufang_fybz_loufang_zj).append("\"")
                .append(",\"loufang_fybz_loufang_mc\":\"").append(loufang_fybz_loufang_mc).append("\"")
                .append(",\"loufang_fybz_dianfei\":\"").append(loufang_fybz_dianfei).append("\"")
                .append(",\"loufang_fybz_shuifei\":\"").append(loufang_fybz_shuifei).append("\"")
                .append(",\"loufang_fybz_shuifei_leng\":\"").append(loufang_fybz_shuifei_leng).append("\"")
                .append(",\"loufang_fybz_shuifei_re\":\"").append(loufang_fybz_shuifei_re).append("\"")
                .append(",\"loufang_fybz_meiqi\":\"").append(loufang_fybz_meiqi).append("\"")
                .append(",\"loufang_fybz_zt\":\"").append(loufang_fybz_zt).append("\"")
                .append(",\"loufang_fybz_gelibiaoshi\":\"").append(loufang_fybz_gelibiaoshi).append("\"}");
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param loufang_fybz_zj String
     */
    public void setLoufang_fybz_zj(String loufang_fybz_zj) {
        this.loufang_fybz_zj = loufang_fybz_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getLoufang_fybz_zj() {
        return this.loufang_fybz_zj;
    }

    /**
     * 设置 楼房主键
     *
     * @param loufang_fybz_loufang_zj String
     */
    public void setLoufang_fybz_loufang_zj(String loufang_fybz_loufang_zj) {
        this.loufang_fybz_loufang_zj = loufang_fybz_loufang_zj;
    }

    /**
     * 取得 楼房主键
     *
     * @return String
     */
    public String getLoufang_fybz_loufang_zj() {
        return this.loufang_fybz_loufang_zj;
    }

    /**
     * 设置 楼名
     *
     * @param loufang_fybz_loufang_mc String
     */
    public void setLoufang_fybz_loufang_mc(String loufang_fybz_loufang_mc) {
        this.loufang_fybz_loufang_mc = loufang_fybz_loufang_mc;
    }

    /**
     * 取得 楼名
     *
     * @return String
     */
    public String getLoufang_fybz_loufang_mc() {
        return this.loufang_fybz_loufang_mc;
    }

    /**
     * 设置 电费标准
     *
     * @param loufang_fybz_dianfei Double
     */
    public void setLoufang_fybz_dianfei(Double loufang_fybz_dianfei) {
        this.loufang_fybz_dianfei = loufang_fybz_dianfei;
    }

    /**
     * 取得 电费标准
     *
     * @return Double
     */
    public Double getLoufang_fybz_dianfei() {
        return this.loufang_fybz_dianfei;
    }

    /**
     * 设置 水费标准
     *
     * @param loufang_fybz_shuifei Double
     */
    public void setLoufang_fybz_shuifei(Double loufang_fybz_shuifei) {
        this.loufang_fybz_shuifei = loufang_fybz_shuifei;
    }

    /**
     * 取得 水费标准
     *
     * @return Double
     */
    public Double getLoufang_fybz_shuifei() {
        return this.loufang_fybz_shuifei;
    }

    /**
     * 设置 冷水费标准
     *
     * @param loufang_fybz_shuifei_leng Double
     */
    public void setLoufang_fybz_shuifei_leng(Double loufang_fybz_shuifei_leng) {
        this.loufang_fybz_shuifei_leng = loufang_fybz_shuifei_leng;
    }

    /**
     * 取得 冷水费标准
     *
     * @return Double
     */
    public Double getLoufang_fybz_shuifei_leng() {
        return this.loufang_fybz_shuifei_leng;
    }

    /**
     * 设置 热水费标准
     *
     * @param loufang_fybz_shuifei_re Double
     */
    public void setLoufang_fybz_shuifei_re(Double loufang_fybz_shuifei_re) {
        this.loufang_fybz_shuifei_re = loufang_fybz_shuifei_re;
    }

    /**
     * 取得 热水费标准
     *
     * @return Double
     */
    public Double getLoufang_fybz_shuifei_re() {
        return this.loufang_fybz_shuifei_re;
    }

    /**
     * 设置 煤气费标准
     *
     * @param loufang_fybz_meiqi Double
     */
    public void setLoufang_fybz_meiqi(Double loufang_fybz_meiqi) {
        this.loufang_fybz_meiqi = loufang_fybz_meiqi;
    }

    /**
     * 取得 煤气费标准
     *
     * @return Double
     */
    public Double getLoufang_fybz_meiqi() {
        return this.loufang_fybz_meiqi;
    }

    /**
     * 设置 状态
     *
     * @param loufang_fybz_zt Integer
     */
    public void setLoufang_fybz_zt(Integer loufang_fybz_zt) {
        this.loufang_fybz_zt = loufang_fybz_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getLoufang_fybz_zt() {
        return this.loufang_fybz_zt;
    }

    /**
     * 设置 隔离标识
     *
     * @param loufang_fybz_gelibiaoshi String
     */
    public void setLoufang_fybz_gelibiaoshi(String loufang_fybz_gelibiaoshi) {
        this.loufang_fybz_gelibiaoshi = loufang_fybz_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getLoufang_fybz_gelibiaoshi() {
        return this.loufang_fybz_gelibiaoshi;
    }
}