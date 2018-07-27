package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class ChaoDianbiao {

    @system.base.annotation.ID
    private String chaodianbiao_zj;// 主键
    private String chaodianbiao_loufang_zj;// 楼主键 
    private String chaodianbiao_loufang_mc;// 楼名称 
    private String chaodianbiao_loufang2_zj;// 房主键 
    private String chaodianbiao_loufang2_bianma;// 房编号 
    private Double chaodianbiao_dushu1;// 上次读数 
    @system.base.annotation.Time("yyyy-MM-dd")
    private Date chaodianbiao_riqi1;// 上次抄表日期
    private Double chaodianbiao_dushu2;// 读数 
    @system.base.annotation.Time("yyyy-MM-dd")
    private Date chaodianbiao_riqi2;// 抄表日期
    private Double chaodianbiao_dian;// 水(吨) 
    private Double chaodianbiao_dian_danjia;// 水单价 
    private Double chaodianbiao_dian_jine;// 金额 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private Date chaodianbiao_zhidanshijian;// 制单时间
    private String chaodianbiao_zhidanren;// 制单人 
    private String chaodianbiao_zhidanren_zj;// 制单人主键 
    private Integer chaodianbiao_fentanrenshu;// 分摊人数 
    private Integer chaodianbiao_yj_fentanrenshu;// 已分摊人数 
    private Integer chaodianbiao_zt;// 状态 
    private String chaodianbiao_gelibiaoshi;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"chaodianbiao_zj\":\"").append(chaodianbiao_zj).append("\"")
                .append(",\"chaodianbiao_loufang_zj\":\"").append(chaodianbiao_loufang_zj).append("\"")
                .append(",\"chaodianbiao_loufang_mc\":\"").append(chaodianbiao_loufang_mc).append("\"")
                .append(",\"chaodianbiao_loufang2_zj\":\"").append(chaodianbiao_loufang2_zj).append("\"")
                .append(",\"chaodianbiao_loufang2_bianma\":\"").append(chaodianbiao_loufang2_bianma).append("\"")
                .append(",\"chaodianbiao_dushu1\":\"").append(chaodianbiao_dushu1).append("\"")
                .append(",\"chaodianbiao_riqi1\":\"").append(Tool.dateToString(this.chaodianbiao_riqi1, "yyyy-MM-dd")).append("\"")
                .append(",\"chaodianbiao_dushu2\":\"").append(chaodianbiao_dushu2).append("\"")
                .append(",\"chaodianbiao_riqi2\":\"").append(Tool.dateToString(this.chaodianbiao_riqi2, "yyyy-MM-dd")).append("\"")
                .append(",\"chaodianbiao_dian\":\"").append(chaodianbiao_dian).append("\"")
                .append(",\"chaodianbiao_dian_danjia\":\"").append(chaodianbiao_dian_danjia).append("\"")
                .append(",\"chaodianbiao_dian_jine\":\"").append(chaodianbiao_dian_jine).append("\"")
                .append(",\"chaodianbiao_zhidanshijian\":\"").append(Tool.dateToString(this.chaodianbiao_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"chaodianbiao_zhidanren\":\"").append(chaodianbiao_zhidanren).append("\"")
                .append(",\"chaodianbiao_zhidanren_zj\":\"").append(chaodianbiao_zhidanren_zj).append("\"")
                .append(",\"chaodianbiao_fentanrenshu\":\"").append(chaodianbiao_fentanrenshu).append("\"")
                .append(",\"chaodianbiao_yj_fentanrenshu\":\"").append(chaodianbiao_yj_fentanrenshu).append("\"")
                .append(",\"chaodianbiao_zt\":\"").append(chaodianbiao_zt).append("\"")
                .append(",\"chaodianbiao_gelibiaoshi\":\"").append(chaodianbiao_gelibiaoshi).append("\"}");
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param chaodianbiao_zj String
     */
    public void setChaodianbiao_zj(String chaodianbiao_zj) {
        this.chaodianbiao_zj = chaodianbiao_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getChaodianbiao_zj() {
        return this.chaodianbiao_zj;
    }

    /**
     * 设置 楼主键
     *
     * @param chaodianbiao_loufang_zj String
     */
    public void setChaodianbiao_loufang_zj(String chaodianbiao_loufang_zj) {
        this.chaodianbiao_loufang_zj = chaodianbiao_loufang_zj;
    }

    /**
     * 取得 楼主键
     *
     * @return String
     */
    public String getChaodianbiao_loufang_zj() {
        return this.chaodianbiao_loufang_zj;
    }

    /**
     * 设置 楼名称
     *
     * @param chaodianbiao_loufang_mc String
     */
    public void setChaodianbiao_loufang_mc(String chaodianbiao_loufang_mc) {
        this.chaodianbiao_loufang_mc = chaodianbiao_loufang_mc;
    }

    /**
     * 取得 楼名称
     *
     * @return String
     */
    public String getChaodianbiao_loufang_mc() {
        return this.chaodianbiao_loufang_mc;
    }

    /**
     * 设置 房主键
     *
     * @param chaodianbiao_loufang2_zj String
     */
    public void setChaodianbiao_loufang2_zj(String chaodianbiao_loufang2_zj) {
        this.chaodianbiao_loufang2_zj = chaodianbiao_loufang2_zj;
    }

    /**
     * 取得 房主键
     *
     * @return String
     */
    public String getChaodianbiao_loufang2_zj() {
        return this.chaodianbiao_loufang2_zj;
    }

    /**
     * 设置 房编号
     *
     * @param chaodianbiao_loufang2_bianma String
     */
    public void setChaodianbiao_loufang2_bianma(String chaodianbiao_loufang2_bianma) {
        this.chaodianbiao_loufang2_bianma = chaodianbiao_loufang2_bianma;
    }

    /**
     * 取得 房编号
     *
     * @return String
     */
    public String getChaodianbiao_loufang2_bianma() {
        return this.chaodianbiao_loufang2_bianma;
    }

    /**
     * 设置 上次读数
     *
     * @param chaodianbiao_dushu1 Double
     */
    public void setChaodianbiao_dushu1(Double chaodianbiao_dushu1) {
        this.chaodianbiao_dushu1 = chaodianbiao_dushu1;
    }

    /**
     * 取得 上次读数
     *
     * @return Double
     */
    public Double getChaodianbiao_dushu1() {
        return this.chaodianbiao_dushu1;
    }

    /**
     * 设置 上次抄表日期
     *
     * @param chaodianbiao_riqi1 Date
     */
    public void setChaodianbiao_riqi1(Date chaodianbiao_riqi1) {
        this.chaodianbiao_riqi1 = chaodianbiao_riqi1;
    }

    /**
     * 取得 上次抄表日期
     *
     * @return Date
     */
    public Date getChaodianbiao_riqi1() {
        return this.chaodianbiao_riqi1;
    }

    /**
     * 设置 读数
     *
     * @param chaodianbiao_dushu2 Double
     */
    public void setChaodianbiao_dushu2(Double chaodianbiao_dushu2) {
        this.chaodianbiao_dushu2 = chaodianbiao_dushu2;
    }

    /**
     * 取得 读数
     *
     * @return Double
     */
    public Double getChaodianbiao_dushu2() {
        return this.chaodianbiao_dushu2;
    }

    /**
     * 设置 抄表日期
     *
     * @param chaodianbiao_riqi2 Date
     */
    public void setChaodianbiao_riqi2(Date chaodianbiao_riqi2) {
        this.chaodianbiao_riqi2 = chaodianbiao_riqi2;
    }

    /**
     * 取得 抄表日期
     *
     * @return Date
     */
    public Date getChaodianbiao_riqi2() {
        return this.chaodianbiao_riqi2;
    }

    /**
     * 设置 水(吨)
     *
     * @param chaodianbiao_dian Double
     */
    public void setChaodianbiao_dian(Double chaodianbiao_dian) {
        this.chaodianbiao_dian = chaodianbiao_dian;
    }

    /**
     * 取得 水(吨)
     *
     * @return Double
     */
    public Double getChaodianbiao_dian() {
        return this.chaodianbiao_dian;
    }

    /**
     * 设置 水单价
     *
     * @param chaodianbiao_dian_danjia Double
     */
    public void setChaodianbiao_dian_danjia(Double chaodianbiao_dian_danjia) {
        this.chaodianbiao_dian_danjia = chaodianbiao_dian_danjia;
    }

    /**
     * 取得 水单价
     *
     * @return Double
     */
    public Double getChaodianbiao_dian_danjia() {
        return this.chaodianbiao_dian_danjia;
    }

    /**
     * 设置 金额
     *
     * @param chaodianbiao_dian_jine Double
     */
    public void setChaodianbiao_dian_jine(Double chaodianbiao_dian_jine) {
        this.chaodianbiao_dian_jine = chaodianbiao_dian_jine;
    }

    /**
     * 取得 金额
     *
     * @return Double
     */
    public Double getChaodianbiao_dian_jine() {
        return this.chaodianbiao_dian_jine;
    }

    /**
     * 设置 制单时间
     *
     * @param chaodianbiao_zhidanshijian Date
     */
    public void setChaodianbiao_zhidanshijian(Date chaodianbiao_zhidanshijian) {
        this.chaodianbiao_zhidanshijian = chaodianbiao_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getChaodianbiao_zhidanshijian() {
        return this.chaodianbiao_zhidanshijian;
    }

    /**
     * 设置 制单人
     *
     * @param chaodianbiao_zhidanren String
     */
    public void setChaodianbiao_zhidanren(String chaodianbiao_zhidanren) {
        this.chaodianbiao_zhidanren = chaodianbiao_zhidanren;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getChaodianbiao_zhidanren() {
        return this.chaodianbiao_zhidanren;
    }

    /**
     * 设置 制单人主键
     *
     * @param chaodianbiao_zhidanren_zj String
     */
    public void setChaodianbiao_zhidanren_zj(String chaodianbiao_zhidanren_zj) {
        this.chaodianbiao_zhidanren_zj = chaodianbiao_zhidanren_zj;
    }

    /**
     * 取得 制单人主键
     *
     * @return String
     */
    public String getChaodianbiao_zhidanren_zj() {
        return this.chaodianbiao_zhidanren_zj;
    }

    /**
     * 设置 分摊人数
     *
     * @param chaodianbiao_fentanrenshu Integer
     */
    public void setChaodianbiao_fentanrenshu(Integer chaodianbiao_fentanrenshu) {
        this.chaodianbiao_fentanrenshu = chaodianbiao_fentanrenshu;
    }

    /**
     * 取得 分摊人数
     *
     * @return Integer
     */
    public Integer getChaodianbiao_fentanrenshu() {
        return this.chaodianbiao_fentanrenshu;
    }

    /**
     * 设置 已分摊人数
     *
     * @param chaodianbiao_yj_fentanrenshu Integer
     */
    public void setChaodianbiao_yj_fentanrenshu(Integer chaodianbiao_yj_fentanrenshu) {
        this.chaodianbiao_yj_fentanrenshu = chaodianbiao_yj_fentanrenshu;
    }

    /**
     * 取得 已分摊人数
     *
     * @return Integer
     */
    public Integer getChaodianbiao_yj_fentanrenshu() {
        return this.chaodianbiao_yj_fentanrenshu;
    }

    /**
     * 设置 状态
     *
     * @param chaodianbiao_zt Integer
     */
    public void setChaodianbiao_zt(Integer chaodianbiao_zt) {
        this.chaodianbiao_zt = chaodianbiao_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getChaodianbiao_zt() {
        return this.chaodianbiao_zt;
    }

    /**
     * 设置 隔离标识
     *
     * @param chaodianbiao_gelibiaoshi String
     */
    public void setChaodianbiao_gelibiaoshi(String chaodianbiao_gelibiaoshi) {
        this.chaodianbiao_gelibiaoshi = chaodianbiao_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getChaodianbiao_gelibiaoshi() {
        return this.chaodianbiao_gelibiaoshi;
    }
}
