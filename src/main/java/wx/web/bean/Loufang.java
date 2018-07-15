package wx.web.bean;

@system.base.annotation.Table
public class Loufang {
    @system.base.annotation.ID
    private  String loufang_zj ;// 主键
    private  String loufangfl_zj ;// 分类外键 
    private  String loufang_mc ;// 名称 
    private  Integer loufang_tj_danrenfang ;// 单人房总数 
    private  Integer loufang_tj_taojianfang ;// 套间房总数 
    private  String loufang_dizhi ;// 地址 
    private  String loufang_bz ;// 备注 
    private  String loufang_gelibiaoshi ;// 隔离标识 
    private  Integer loufang_zt ;// 状态 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufang_zj\":\"").append(loufang_zj).append("\"")
                .append(",\"loufangfl_zj\":\"").append(loufangfl_zj).append("\"")
                .append(",\"loufang_mc\":\"").append(loufang_mc).append("\"")
                .append(",\"loufang_tj_danrenfang\":\"").append(loufang_tj_danrenfang).append("\"")
                .append(",\"loufang_tj_taojianfang\":\"").append(loufang_tj_taojianfang).append("\"")
                .append(",\"loufang_dizhi\":\"").append(loufang_dizhi).append("\"")
                .append(",\"loufang_bz\":\"").append(loufang_bz).append("\"")
                .append(",\"loufang_gelibiaoshi\":\"").append(loufang_gelibiaoshi).append("\"")
                .append(",\"loufang_zt\":\"").append(loufang_zt).append("\"}")
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
     * 设置 单人房总数
     *
     * @param loufang_tj_danrenfang Integer
     */
    public void setLoufang_tj_danrenfang(Integer loufang_tj_danrenfang) {
        this.loufang_tj_danrenfang=loufang_tj_danrenfang;
    }

    /**
     * 取得 单人房总数
     *
     * @return Integer
     */
    public Integer getLoufang_tj_danrenfang() {
        return this.loufang_tj_danrenfang;
    }
    /**
     * 设置 套间房总数
     *
     * @param loufang_tj_taojianfang Integer
     */
    public void setLoufang_tj_taojianfang(Integer loufang_tj_taojianfang) {
        this.loufang_tj_taojianfang=loufang_tj_taojianfang;
    }

    /**
     * 取得 套间房总数
     *
     * @return Integer
     */
    public Integer getLoufang_tj_taojianfang() {
        return this.loufang_tj_taojianfang;
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
}