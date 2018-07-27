package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class ChaoDianbiaoFengtan {

    @system.base.annotation.ID
    private String chaodianbiaofengtan_zj;// 主键
    private String chaodianbiao_zj;// 水表记录主键 
    private Double chaodianbiaofengtan_dian;// 水 
    private Double chaodianbiaofengtan_dian_danjia;// 水单价 
    private Integer chaodianbiaofengtan_zhanyongtian;// 占用天数 
    private Double chaodianbiaofengtan_feiyong;// 分摊费 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private Date chaodianbiaofengtan_nfsj;// 纳费时间
    private String chaodianbiaofengtan_nfr_zj;// 纳费人主键 
    private String chaodianbiaofengtan_nfr;// 纳费人 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"chaodianbiaofengtan_zj\":\"").append(chaodianbiaofengtan_zj).append("\"")
                .append(",\"chaodianbiao_zj\":\"").append(chaodianbiao_zj).append("\"")
                .append(",\"chaodianbiaofengtan_dian\":\"").append(chaodianbiaofengtan_dian).append("\"")
                .append(",\"chaodianbiaofengtan_dian_danjia\":\"").append(chaodianbiaofengtan_dian_danjia).append("\"")
                .append(",\"chaodianbiaofengtan_zhanyongtian\":\"").append(chaodianbiaofengtan_zhanyongtian).append("\"")
                .append(",\"chaodianbiaofengtan_feiyong\":\"").append(chaodianbiaofengtan_feiyong).append("\"")
                .append(",\"chaodianbiaofengtan_nfsj\":\"").append(Tool.dateToString(this.chaodianbiaofengtan_nfsj, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"chaodianbiaofengtan_nfr_zj\":\"").append(chaodianbiaofengtan_nfr_zj).append("\"")
                .append(",\"chaodianbiaofengtan_nfr\":\"").append(chaodianbiaofengtan_nfr).append("\"}");
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param chaodianbiaofengtan_zj String
     */
    public void setChaodianbiaofengtan_zj(String chaodianbiaofengtan_zj) {
        this.chaodianbiaofengtan_zj = chaodianbiaofengtan_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getChaodianbiaofengtan_zj() {
        return this.chaodianbiaofengtan_zj;
    }

    /**
     * 设置 水表记录主键
     *
     * @param chaodianbiao_zj String
     */
    public void setChaodianbiao_zj(String chaodianbiao_zj) {
        this.chaodianbiao_zj = chaodianbiao_zj;
    }

    /**
     * 取得 水表记录主键
     *
     * @return String
     */
    public String getChaodianbiao_zj() {
        return this.chaodianbiao_zj;
    }

    /**
     * 设置 水
     *
     * @param chaodianbiaofengtan_dian Double
     */
    public void setChaodianbiaofengtan_dian(Double chaodianbiaofengtan_dian) {
        this.chaodianbiaofengtan_dian = chaodianbiaofengtan_dian;
    }

    /**
     * 取得 水
     *
     * @return Double
     */
    public Double getChaodianbiaofengtan_dian() {
        return this.chaodianbiaofengtan_dian;
    }

    /**
     * 设置 水单价
     *
     * @param chaodianbiaofengtan_dian_danjia Double
     */
    public void setChaodianbiaofengtan_dian_danjia(Double chaodianbiaofengtan_dian_danjia) {
        this.chaodianbiaofengtan_dian_danjia = chaodianbiaofengtan_dian_danjia;
    }

    /**
     * 取得 水单价
     *
     * @return Double
     */
    public Double getChaodianbiaofengtan_dian_danjia() {
        return this.chaodianbiaofengtan_dian_danjia;
    }

    /**
     * 设置 占用天数
     *
     * @param chaodianbiaofengtan_zhanyongtian Integer
     */
    public void setChaodianbiaofengtan_zhanyongtian(Integer chaodianbiaofengtan_zhanyongtian) {
        this.chaodianbiaofengtan_zhanyongtian = chaodianbiaofengtan_zhanyongtian;
    }

    /**
     * 取得 占用天数
     *
     * @return Integer
     */
    public Integer getChaodianbiaofengtan_zhanyongtian() {
        return this.chaodianbiaofengtan_zhanyongtian;
    }

    /**
     * 设置 分摊费
     *
     * @param chaodianbiaofengtan_feiyong Double
     */
    public void setChaodianbiaofengtan_feiyong(Double chaodianbiaofengtan_feiyong) {
        this.chaodianbiaofengtan_feiyong = chaodianbiaofengtan_feiyong;
    }

    /**
     * 取得 分摊费
     *
     * @return Double
     */
    public Double getChaodianbiaofengtan_feiyong() {
        return this.chaodianbiaofengtan_feiyong;
    }

    /**
     * 设置 纳费时间
     *
     * @param chaodianbiaofengtan_nfsj Date
     */
    public void setChaodianbiaofengtan_nfsj(Date chaodianbiaofengtan_nfsj) {
        this.chaodianbiaofengtan_nfsj = chaodianbiaofengtan_nfsj;
    }

    /**
     * 取得 纳费时间
     *
     * @return Date
     */
    public Date getChaodianbiaofengtan_nfsj() {
        return this.chaodianbiaofengtan_nfsj;
    }

    /**
     * 设置 纳费人主键
     *
     * @param chaodianbiaofengtan_nfr_zj String
     */
    public void setChaodianbiaofengtan_nfr_zj(String chaodianbiaofengtan_nfr_zj) {
        this.chaodianbiaofengtan_nfr_zj = chaodianbiaofengtan_nfr_zj;
    }

    /**
     * 取得 纳费人主键
     *
     * @return String
     */
    public String getChaodianbiaofengtan_nfr_zj() {
        return this.chaodianbiaofengtan_nfr_zj;
    }

    /**
     * 设置 纳费人
     *
     * @param chaodianbiaofengtan_nfr String
     */
    public void setChaodianbiaofengtan_nfr(String chaodianbiaofengtan_nfr) {
        this.chaodianbiaofengtan_nfr = chaodianbiaofengtan_nfr;
    }

    /**
     * 取得 纳费人
     *
     * @return String
     */
    public String getChaodianbiaofengtan_nfr() {
        return this.chaodianbiaofengtan_nfr;
    }
}
