package wx.xt.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class XtJuese {

    @system.base.annotation.ID
    private  String xt_juese_zj ;// 主键
    private  String xt_juese_fzj ;// 父键 
    private  String xt_juese_mc ;// 名称 
    private  String xt_juese_dm ;// 代码 
    private  Integer xt_juese_gongsi ;// 公私角色 
    private  String xt_juese_bz ;// 备注 
    private  Integer xt_juese_zt ;// 状态 
    private  String xt_juese_gelibiaoshi ;// 隔离标识 
    private  String xt_juese_zhidanren_zj ;// 制单人主键 
    private  String xt_juese_zhidanren ;// 制单人 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date xt_juese_zhidanshijian ;// 制单时间
    private  String xt_juese_xiugairen_zj ;// 修改人主键 
    private  String xt_juese_xiugairen ;// 修改人 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date xt_juese_xiugaishijian ;// 修改时间

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_juese_zj\":\"").append(xt_juese_zj).append("\"")
                .append(",\"xt_juese_fzj\":\"").append(xt_juese_fzj).append("\"")
                .append(",\"xt_juese_mc\":\"").append(xt_juese_mc).append("\"")
                .append(",\"xt_juese_dm\":\"").append(xt_juese_dm).append("\"")
                .append(",\"xt_juese_gongsi\":\"").append(xt_juese_gongsi).append("\"")
                .append(",\"xt_juese_bz\":\"").append(xt_juese_bz).append("\"")
                .append(",\"xt_juese_zt\":\"").append(xt_juese_zt).append("\"")
                .append(",\"xt_juese_gelibiaoshi\":\"").append(xt_juese_gelibiaoshi).append("\"")
                .append(",\"xt_juese_zhidanren_zj\":\"").append(xt_juese_zhidanren_zj).append("\"")
                .append(",\"xt_juese_zhidanren\":\"").append(xt_juese_zhidanren).append("\"")
                .append(",\"xt_juese_zhidanshijian\":\"").append(Tool.dateToString(this.xt_juese_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"xt_juese_xiugairen_zj\":\"").append(xt_juese_xiugairen_zj).append("\"")
                .append(",\"xt_juese_xiugairen\":\"").append(xt_juese_xiugairen).append("\"")
                .append(",\"xt_juese_xiugaishijian\":\"").append(Tool.dateToString(this.xt_juese_xiugaishijian, "yyyy-MM-dd HH:mm:ss")).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_juese_zj String
     */
    public void setXt_juese_zj(String xt_juese_zj) {
        this.xt_juese_zj=xt_juese_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_juese_zj() {
        return this.xt_juese_zj;
    }
    /**
     * 设置 父键
     *
     * @param xt_juese_fzj String
     */
    public void setXt_juese_fzj(String xt_juese_fzj) {
        this.xt_juese_fzj=xt_juese_fzj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getXt_juese_fzj() {
        return this.xt_juese_fzj;
    }
    /**
     * 设置 名称
     *
     * @param xt_juese_mc String
     */
    public void setXt_juese_mc(String xt_juese_mc) {
        this.xt_juese_mc=xt_juese_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getXt_juese_mc() {
        return this.xt_juese_mc;
    }
    /**
     * 设置 代码
     *
     * @param xt_juese_dm String
     */
    public void setXt_juese_dm(String xt_juese_dm) {
        this.xt_juese_dm=xt_juese_dm;
    }

    /**
     * 取得 代码
     *
     * @return String
     */
    public String getXt_juese_dm() {
        return this.xt_juese_dm;
    }
    /**
     * 设置 公私角色
     *
     * @param xt_juese_gongsi Integer
     */
    public void setXt_juese_gongsi(Integer xt_juese_gongsi) {
        this.xt_juese_gongsi=xt_juese_gongsi;
    }

    /**
     * 取得 公私角色
     *
     * @return Integer
     */
    public Integer getXt_juese_gongsi() {
        return this.xt_juese_gongsi;
    }
    /**
     * 设置 备注
     *
     * @param xt_juese_bz String
     */
    public void setXt_juese_bz(String xt_juese_bz) {
        this.xt_juese_bz=xt_juese_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getXt_juese_bz() {
        return this.xt_juese_bz;
    }
    /**
     * 设置 状态
     *
     * @param xt_juese_zt Integer
     */
    public void setXt_juese_zt(Integer xt_juese_zt) {
        this.xt_juese_zt=xt_juese_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getXt_juese_zt() {
        return this.xt_juese_zt;
    }
    /**
     * 设置 隔离标识
     *
     * @param xt_juese_gelibiaoshi String
     */
    public void setXt_juese_gelibiaoshi(String xt_juese_gelibiaoshi) {
        this.xt_juese_gelibiaoshi=xt_juese_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getXt_juese_gelibiaoshi() {
        return this.xt_juese_gelibiaoshi;
    }
    /**
     * 设置 制单人主键
     *
     * @param xt_juese_zhidanren_zj String
     */
    public void setXt_juese_zhidanren_zj(String xt_juese_zhidanren_zj) {
        this.xt_juese_zhidanren_zj=xt_juese_zhidanren_zj;
    }

    /**
     * 取得 制单人主键
     *
     * @return String
     */
    public String getXt_juese_zhidanren_zj() {
        return this.xt_juese_zhidanren_zj;
    }
    /**
     * 设置 制单人
     *
     * @param xt_juese_zhidanren String
     */
    public void setXt_juese_zhidanren(String xt_juese_zhidanren) {
        this.xt_juese_zhidanren=xt_juese_zhidanren;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getXt_juese_zhidanren() {
        return this.xt_juese_zhidanren;
    }
    /**
     * 设置 制单时间
     *
     * @param xt_juese_zhidanshijian Date
     */
    public void setXt_juese_zhidanshijian(Date xt_juese_zhidanshijian) {
        this.xt_juese_zhidanshijian=xt_juese_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getXt_juese_zhidanshijian() {
        return this.xt_juese_zhidanshijian;
    }
    /**
     * 设置 修改人主键
     *
     * @param xt_juese_xiugairen_zj String
     */
    public void setXt_juese_xiugairen_zj(String xt_juese_xiugairen_zj) {
        this.xt_juese_xiugairen_zj=xt_juese_xiugairen_zj;
    }

    /**
     * 取得 修改人主键
     *
     * @return String
     */
    public String getXt_juese_xiugairen_zj() {
        return this.xt_juese_xiugairen_zj;
    }
    /**
     * 设置 修改人
     *
     * @param xt_juese_xiugairen String
     */
    public void setXt_juese_xiugairen(String xt_juese_xiugairen) {
        this.xt_juese_xiugairen=xt_juese_xiugairen;
    }

    /**
     * 取得 修改人
     *
     * @return String
     */
    public String getXt_juese_xiugairen() {
        return this.xt_juese_xiugairen;
    }
    /**
     * 设置 修改时间
     *
     * @param xt_juese_xiugaishijian Date
     */
    public void setXt_juese_xiugaishijian(Date xt_juese_xiugaishijian) {
        this.xt_juese_xiugaishijian=xt_juese_xiugaishijian;
    }

    /**
     * 取得 修改时间
     *
     * @return Date
     */
    public Date getXt_juese_xiugaishijian() {
        return this.xt_juese_xiugaishijian;
    }
}