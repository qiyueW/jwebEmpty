package wx.web.bean;

@system.base.annotation.Table
public class Loufang {

    @system.base.annotation.ID
    private  String loufang_zj ;// 主键
    private  String loufangfl_zj ;// 分类外键 
    private  String loufang_mc ;// 名称 
    private  String loufang_dizhi ;// 地址 
    private  String loufang_bz ;// 备注 
    private  String loufang_gelibiaoshi ;// 隔离标识 
    private  Integer loufang_zt ;// 状态 
    private  Integer loufang_danjian_chuangwei ;// 单间床位 
    private  Integer loufang_danjian_chuangwei2 ;// 已用单间床位 
    private  Integer loufang_taojian_chuangwei ;// 套间床位 
    private  Integer loufang_taojian_chuangwei2 ;// 已用套间床位 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufang_zj\":\"").append(loufang_zj).append("\"")
                .append(",\"loufangfl_zj\":\"").append(loufangfl_zj).append("\"")
                .append(",\"loufang_mc\":\"").append(loufang_mc).append("\"")
                .append(",\"loufang_dizhi\":\"").append(loufang_dizhi).append("\"")
                .append(",\"loufang_bz\":\"").append(loufang_bz).append("\"")
                .append(",\"loufang_gelibiaoshi\":\"").append(loufang_gelibiaoshi).append("\"")
                .append(",\"loufang_zt\":\"").append(loufang_zt).append("\"")
                .append(",\"loufang_danjian_chuangwei\":\"").append(loufang_danjian_chuangwei).append("\"")
                .append(",\"loufang_danjian_chuangwei2\":\"").append(loufang_danjian_chuangwei2).append("\"")
                .append(",\"loufang_taojian_chuangwei\":\"").append(loufang_taojian_chuangwei).append("\"")
                .append(",\"loufang_taojian_chuangwei2\":\"").append(loufang_taojian_chuangwei2).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param loufang_zj String
     */
    public void setLoufang_zj(String loufang_zj) {
        this.loufang_zj=loufang_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getLoufang_zj() {
        return this.loufang_zj;
    }
    /**
     * 设置 分类外键
     *
     * @param loufangfl_zj String
     */
    public void setLoufangfl_zj(String loufangfl_zj) {
        this.loufangfl_zj=loufangfl_zj;
    }

    /**
     * 取得 分类外键
     *
     * @return String
     */
    public String getLoufangfl_zj() {
        return this.loufangfl_zj;
    }
    /**
     * 设置 名称
     *
     * @param loufang_mc String
     */
    public void setLoufang_mc(String loufang_mc) {
        this.loufang_mc=loufang_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getLoufang_mc() {
        return this.loufang_mc;
    }
    /**
     * 设置 地址
     *
     * @param loufang_dizhi String
     */
    public void setLoufang_dizhi(String loufang_dizhi) {
        this.loufang_dizhi=loufang_dizhi;
    }

    /**
     * 取得 地址
     *
     * @return String
     */
    public String getLoufang_dizhi() {
        return this.loufang_dizhi;
    }
    /**
     * 设置 备注
     *
     * @param loufang_bz String
     */
    public void setLoufang_bz(String loufang_bz) {
        this.loufang_bz=loufang_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getLoufang_bz() {
        return this.loufang_bz;
    }
    /**
     * 设置 隔离标识
     *
     * @param loufang_gelibiaoshi String
     */
    public void setLoufang_gelibiaoshi(String loufang_gelibiaoshi) {
        this.loufang_gelibiaoshi=loufang_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getLoufang_gelibiaoshi() {
        return this.loufang_gelibiaoshi;
    }
    /**
     * 设置 状态
     *
     * @param loufang_zt Integer
     */
    public void setLoufang_zt(Integer loufang_zt) {
        this.loufang_zt=loufang_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getLoufang_zt() {
        return this.loufang_zt;
    }
    /**
     * 设置 单间床位
     *
     * @param loufang_danjian_chuangwei Integer
     */
    public void setLoufang_danjian_chuangwei(Integer loufang_danjian_chuangwei) {
        this.loufang_danjian_chuangwei=loufang_danjian_chuangwei;
    }

    /**
     * 取得 单间床位
     *
     * @return Integer
     */
    public Integer getLoufang_danjian_chuangwei() {
        return this.loufang_danjian_chuangwei;
    }
    /**
     * 设置 已用单间床位
     *
     * @param loufang_danjian_chuangwei2 Integer
     */
    public void setLoufang_danjian_chuangwei2(Integer loufang_danjian_chuangwei2) {
        this.loufang_danjian_chuangwei2=loufang_danjian_chuangwei2;
    }

    /**
     * 取得 已用单间床位
     *
     * @return Integer
     */
    public Integer getLoufang_danjian_chuangwei2() {
        return this.loufang_danjian_chuangwei2;
    }
    /**
     * 设置 套间床位
     *
     * @param loufang_taojian_chuangwei Integer
     */
    public void setLoufang_taojian_chuangwei(Integer loufang_taojian_chuangwei) {
        this.loufang_taojian_chuangwei=loufang_taojian_chuangwei;
    }

    /**
     * 取得 套间床位
     *
     * @return Integer
     */
    public Integer getLoufang_taojian_chuangwei() {
        return this.loufang_taojian_chuangwei;
    }
    /**
     * 设置 已用套间床位
     *
     * @param loufang_taojian_chuangwei2 Integer
     */
    public void setLoufang_taojian_chuangwei2(Integer loufang_taojian_chuangwei2) {
        this.loufang_taojian_chuangwei2=loufang_taojian_chuangwei2;
    }

    /**
     * 取得 已用套间床位
     *
     * @return Integer
     */
    public Integer getLoufang_taojian_chuangwei2() {
        return this.loufang_taojian_chuangwei2;
    }
}