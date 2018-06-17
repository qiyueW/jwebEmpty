package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class Zhiwei {

    @system.base.annotation.ID
    private  String zhiwei_zj ;// 主键
    private  String zhiwei_fzj ;// 父键 
    private  String zhiwei_mc ;// 名称 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date zhiwei_zhidanshijian ;// 制单时间
    private  String zhiwei_bz ;// 备注 
    private  Integer zhiwei_zt ;// 状态 
    private  String zhiwei_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"zhiwei_zj\":\"").append(zhiwei_zj).append("\"")
                .append(",\"zhiwei_fzj\":\"").append(zhiwei_fzj).append("\"")
                .append(",\"zhiwei_mc\":\"").append(zhiwei_mc).append("\"")
                .append(",\"zhiwei_zhidanshijian\":\"").append(Tool.dateToString(this.zhiwei_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"zhiwei_bz\":\"").append(zhiwei_bz).append("\"")
                .append(",\"zhiwei_zt\":\"").append(zhiwei_zt).append("\"")
                .append(",\"zhiwei_gelibiaoshi\":\"").append(zhiwei_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param zhiwei_zj String
     */
    public void setZhiwei_zj(String zhiwei_zj) {
        this.zhiwei_zj=zhiwei_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getZhiwei_zj() {
        return this.zhiwei_zj;
    }
    /**
     * 设置 父键
     *
     * @param zhiwei_fzj String
     */
    public void setZhiwei_fzj(String zhiwei_fzj) {
        this.zhiwei_fzj=zhiwei_fzj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getZhiwei_fzj() {
        return this.zhiwei_fzj;
    }
    /**
     * 设置 名称
     *
     * @param zhiwei_mc String
     */
    public void setZhiwei_mc(String zhiwei_mc) {
        this.zhiwei_mc=zhiwei_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getZhiwei_mc() {
        return this.zhiwei_mc;
    }
    /**
     * 设置 制单时间
     *
     * @param zhiwei_zhidanshijian Date
     */
    public void setZhiwei_zhidanshijian(Date zhiwei_zhidanshijian) {
        this.zhiwei_zhidanshijian=zhiwei_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getZhiwei_zhidanshijian() {
        return this.zhiwei_zhidanshijian;
    }
    /**
     * 设置 备注
     *
     * @param zhiwei_bz String
     */
    public void setZhiwei_bz(String zhiwei_bz) {
        this.zhiwei_bz=zhiwei_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getZhiwei_bz() {
        return this.zhiwei_bz;
    }
    /**
     * 设置 状态
     *
     * @param zhiwei_zt Integer
     */
    public void setZhiwei_zt(Integer zhiwei_zt) {
        this.zhiwei_zt=zhiwei_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getZhiwei_zt() {
        return this.zhiwei_zt;
    }
    /**
     * 设置 隔离标识
     *
     * @param zhiwei_gelibiaoshi String
     */
    public void setZhiwei_gelibiaoshi(String zhiwei_gelibiaoshi) {
        this.zhiwei_gelibiaoshi=zhiwei_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getZhiwei_gelibiaoshi() {
        return this.zhiwei_gelibiaoshi;
    }
}