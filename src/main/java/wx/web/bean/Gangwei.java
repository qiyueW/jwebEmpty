package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class Gangwei {

    @system.base.annotation.ID
    private  String gangwei_zj ;// 主键
    private  String gangwei_fzj ;// 父键 
    private  String gangwei_mc ;// 名称 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date gangwei_zhidanshijian ;// 制单时间
    private  String gangwei_bz ;// 备注 
    private  Integer gangwei_zt ;// 状态 
    private  String gangwei_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"gangwei_zj\":\"").append(gangwei_zj).append("\"")
                .append(",\"gangwei_fzj\":\"").append(gangwei_fzj).append("\"")
                .append(",\"gangwei_mc\":\"").append(gangwei_mc).append("\"")
                .append(",\"gangwei_zhidanshijian\":\"").append(Tool.dateToString(this.gangwei_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"gangwei_bz\":\"").append(gangwei_bz).append("\"")
                .append(",\"gangwei_zt\":\"").append(gangwei_zt).append("\"")
                .append(",\"gangwei_gelibiaoshi\":\"").append(gangwei_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param gangwei_zj String
     */
    public void setGangwei_zj(String gangwei_zj) {
        this.gangwei_zj=gangwei_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getGangwei_zj() {
        return this.gangwei_zj;
    }
    /**
     * 设置 父键
     *
     * @param gangwei_fzj String
     */
    public void setGangwei_fzj(String gangwei_fzj) {
        this.gangwei_fzj=gangwei_fzj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getGangwei_fzj() {
        return this.gangwei_fzj;
    }
    /**
     * 设置 名称
     *
     * @param gangwei_mc String
     */
    public void setGangwei_mc(String gangwei_mc) {
        this.gangwei_mc=gangwei_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getGangwei_mc() {
        return this.gangwei_mc;
    }
    /**
     * 设置 制单时间
     *
     * @param gangwei_zhidanshijian Date
     */
    public void setGangwei_zhidanshijian(Date gangwei_zhidanshijian) {
        this.gangwei_zhidanshijian=gangwei_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getGangwei_zhidanshijian() {
        return this.gangwei_zhidanshijian;
    }
    /**
     * 设置 备注
     *
     * @param gangwei_bz String
     */
    public void setGangwei_bz(String gangwei_bz) {
        this.gangwei_bz=gangwei_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getGangwei_bz() {
        return this.gangwei_bz;
    }
    /**
     * 设置 状态
     *
     * @param gangwei_zt Integer
     */
    public void setGangwei_zt(Integer gangwei_zt) {
        this.gangwei_zt=gangwei_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getGangwei_zt() {
        return this.gangwei_zt;
    }
    /**
     * 设置 隔离标识
     *
     * @param gangwei_gelibiaoshi String
     */
    public void setGangwei_gelibiaoshi(String gangwei_gelibiaoshi) {
        this.gangwei_gelibiaoshi=gangwei_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getGangwei_gelibiaoshi() {
        return this.gangwei_gelibiaoshi;
    }
}