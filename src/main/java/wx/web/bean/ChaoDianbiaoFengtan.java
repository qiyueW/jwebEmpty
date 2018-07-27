package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class ChaoShuibiaoFengtan {

    @system.base.annotation.ID
    private  String chaoshuibiaofengtan_zj ;// 主键
    private  String chaoshuibiao_zj ;// 水表记录主键 
    private  Double chaoshuibiaofengtan_shui ;// 水 
    private  Double chaoshuibiaofengtan_shui_danjia ;// 水单价 
    private  Double chaoshuibiaofengtan_feiyong ;// 分摊费 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date chaoshuibiaofengtan_nfsj ;// 纳费时间
    private  String chaoshuibiaofengtan_nfr_zj ;// 纳费人主键 
    private  String chaoshuibiaofengtan_nfr ;// 纳费人 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"chaoshuibiaofengtan_zj\":\"").append(chaoshuibiaofengtan_zj).append("\"")
                .append(",\"chaoshuibiao_zj\":\"").append(chaoshuibiao_zj).append("\"")
                .append(",\"chaoshuibiaofengtan_shui\":\"").append(chaoshuibiaofengtan_shui).append("\"")
                .append(",\"chaoshuibiaofengtan_shui_danjia\":\"").append(chaoshuibiaofengtan_shui_danjia).append("\"")
                .append(",\"chaoshuibiaofengtan_feiyong\":\"").append(chaoshuibiaofengtan_feiyong).append("\"")
                .append(",\"chaoshuibiaofengtan_nfsj\":\"").append(Tool.dateToString(this.chaoshuibiaofengtan_nfsj, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"chaoshuibiaofengtan_nfr_zj\":\"").append(chaoshuibiaofengtan_nfr_zj).append("\"")
                .append(",\"chaoshuibiaofengtan_nfr\":\"").append(chaoshuibiaofengtan_nfr).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param chaoshuibiaofengtan_zj String
     */
    public void setChaoshuibiaofengtan_zj(String chaoshuibiaofengtan_zj) {
        this.chaoshuibiaofengtan_zj=chaoshuibiaofengtan_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getChaoshuibiaofengtan_zj() {
        return this.chaoshuibiaofengtan_zj;
    }
    /**
     * 设置 水表记录主键
     *
     * @param chaoshuibiao_zj String
     */
    public void setChaoshuibiao_zj(String chaoshuibiao_zj) {
        this.chaoshuibiao_zj=chaoshuibiao_zj;
    }

    /**
     * 取得 水表记录主键
     *
     * @return String
     */
    public String getChaoshuibiao_zj() {
        return this.chaoshuibiao_zj;
    }
    /**
     * 设置 水
     *
     * @param chaoshuibiaofengtan_shui Double
     */
    public void setChaoshuibiaofengtan_shui(Double chaoshuibiaofengtan_shui) {
        this.chaoshuibiaofengtan_shui=chaoshuibiaofengtan_shui;
    }

    /**
     * 取得 水
     *
     * @return Double
     */
    public Double getChaoshuibiaofengtan_shui() {
        return this.chaoshuibiaofengtan_shui;
    }
    /**
     * 设置 水单价
     *
     * @param chaoshuibiaofengtan_shui_danjia Double
     */
    public void setChaoshuibiaofengtan_shui_danjia(Double chaoshuibiaofengtan_shui_danjia) {
        this.chaoshuibiaofengtan_shui_danjia=chaoshuibiaofengtan_shui_danjia;
    }

    /**
     * 取得 水单价
     *
     * @return Double
     */
    public Double getChaoshuibiaofengtan_shui_danjia() {
        return this.chaoshuibiaofengtan_shui_danjia;
    }
    /**
     * 设置 分摊费
     *
     * @param chaoshuibiaofengtan_feiyong Double
     */
    public void setChaoshuibiaofengtan_feiyong(Double chaoshuibiaofengtan_feiyong) {
        this.chaoshuibiaofengtan_feiyong=chaoshuibiaofengtan_feiyong;
    }

    /**
     * 取得 分摊费
     *
     * @return Double
     */
    public Double getChaoshuibiaofengtan_feiyong() {
        return this.chaoshuibiaofengtan_feiyong;
    }
    /**
     * 设置 纳费时间
     *
     * @param chaoshuibiaofengtan_nfsj Date
     */
    public void setChaoshuibiaofengtan_nfsj(Date chaoshuibiaofengtan_nfsj) {
        this.chaoshuibiaofengtan_nfsj=chaoshuibiaofengtan_nfsj;
    }

    /**
     * 取得 纳费时间
     *
     * @return Date
     */
    public Date getChaoshuibiaofengtan_nfsj() {
        return this.chaoshuibiaofengtan_nfsj;
    }
    /**
     * 设置 纳费人主键
     *
     * @param chaoshuibiaofengtan_nfr_zj String
     */
    public void setChaoshuibiaofengtan_nfr_zj(String chaoshuibiaofengtan_nfr_zj) {
        this.chaoshuibiaofengtan_nfr_zj=chaoshuibiaofengtan_nfr_zj;
    }

    /**
     * 取得 纳费人主键
     *
     * @return String
     */
    public String getChaoshuibiaofengtan_nfr_zj() {
        return this.chaoshuibiaofengtan_nfr_zj;
    }
    /**
     * 设置 纳费人
     *
     * @param chaoshuibiaofengtan_nfr String
     */
    public void setChaoshuibiaofengtan_nfr(String chaoshuibiaofengtan_nfr) {
        this.chaoshuibiaofengtan_nfr=chaoshuibiaofengtan_nfr;
    }

    /**
     * 取得 纳费人
     *
     * @return String
     */
    public String getChaoshuibiaofengtan_nfr() {
        return this.chaoshuibiaofengtan_nfr;
    }
}