package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class ChaoShuibiao {

    @system.base.annotation.ID
    private  String chaoshuibiao_zj ;// 主键
    private  String chaoshuibiao_loufang_zj ;// 楼主键 
    private  String chaoshuibiao_loufang_mc ;// 楼名称 
    private  String chaoshuibiao_loufang2_zj ;// 房主键 
    private  String chaoshuibiao_loufang2_bianma ;// 房编号 
    private  Double chaoshuibiao_dushu1 ;// 上次读数 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date chaoshuibiao_riqi1 ;// 上次抄表日期
    private  Double chaoshuibiao_dushu2 ;// 读数 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date chaoshuibiao_riqi2 ;// 抄表日期
    private  Double chaoshuibiao_shui ;// 水(吨) 
    private  Double chaoshuibiao_shui_danjia ;// 水单价 
    private  Double chaoshuibiao_shui_jine ;// 金额 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date chaoshuibiao_zhidanshijian ;// 制单时间
    private  String chaoshuibiao_zhidanren ;// 制单人 
    private  String chaoshuibiao_zhidanren_zj ;// 制单人主键 
    private  Integer chaoshuibiao_fentanrenshu ;// 分摊人数 
    private  Integer chaoshuibiao_yj_fentanrenshu ;// 已分摊人数 
    private  Integer chaoshuibiao_zt ;// 状态 
    private  String chaoshuibiao_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"chaoshuibiao_zj\":\"").append(chaoshuibiao_zj).append("\"")
                .append(",\"chaoshuibiao_loufang_zj\":\"").append(chaoshuibiao_loufang_zj).append("\"")
                .append(",\"chaoshuibiao_loufang_mc\":\"").append(chaoshuibiao_loufang_mc).append("\"")
                .append(",\"chaoshuibiao_loufang2_zj\":\"").append(chaoshuibiao_loufang2_zj).append("\"")
                .append(",\"chaoshuibiao_loufang2_bianma\":\"").append(chaoshuibiao_loufang2_bianma).append("\"")
                .append(",\"chaoshuibiao_dushu1\":\"").append(chaoshuibiao_dushu1).append("\"")
                .append(",\"chaoshuibiao_riqi1\":\"").append(Tool.dateToString(this.chaoshuibiao_riqi1, "yyyy-MM-dd")).append("\"")
                .append(",\"chaoshuibiao_dushu2\":\"").append(chaoshuibiao_dushu2).append("\"")
                .append(",\"chaoshuibiao_riqi2\":\"").append(Tool.dateToString(this.chaoshuibiao_riqi2, "yyyy-MM-dd")).append("\"")
                .append(",\"chaoshuibiao_shui\":\"").append(chaoshuibiao_shui).append("\"")
                .append(",\"chaoshuibiao_shui_danjia\":\"").append(chaoshuibiao_shui_danjia).append("\"")
                .append(",\"chaoshuibiao_shui_jine\":\"").append(chaoshuibiao_shui_jine).append("\"")
                .append(",\"chaoshuibiao_zhidanshijian\":\"").append(Tool.dateToString(this.chaoshuibiao_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"chaoshuibiao_zhidanren\":\"").append(chaoshuibiao_zhidanren).append("\"")
                .append(",\"chaoshuibiao_zhidanren_zj\":\"").append(chaoshuibiao_zhidanren_zj).append("\"")
                .append(",\"chaoshuibiao_fentanrenshu\":\"").append(chaoshuibiao_fentanrenshu).append("\"")
                .append(",\"chaoshuibiao_yj_fentanrenshu\":\"").append(chaoshuibiao_yj_fentanrenshu).append("\"")
                .append(",\"chaoshuibiao_zt\":\"").append(chaoshuibiao_zt).append("\"")
                .append(",\"chaoshuibiao_gelibiaoshi\":\"").append(chaoshuibiao_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param chaoshuibiao_zj String
     */
    public void setChaoshuibiao_zj(String chaoshuibiao_zj) {
        this.chaoshuibiao_zj=chaoshuibiao_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getChaoshuibiao_zj() {
        return this.chaoshuibiao_zj;
    }
    /**
     * 设置 楼主键
     *
     * @param chaoshuibiao_loufang_zj String
     */
    public void setChaoshuibiao_loufang_zj(String chaoshuibiao_loufang_zj) {
        this.chaoshuibiao_loufang_zj=chaoshuibiao_loufang_zj;
    }

    /**
     * 取得 楼主键
     *
     * @return String
     */
    public String getChaoshuibiao_loufang_zj() {
        return this.chaoshuibiao_loufang_zj;
    }
    /**
     * 设置 楼名称
     *
     * @param chaoshuibiao_loufang_mc String
     */
    public void setChaoshuibiao_loufang_mc(String chaoshuibiao_loufang_mc) {
        this.chaoshuibiao_loufang_mc=chaoshuibiao_loufang_mc;
    }

    /**
     * 取得 楼名称
     *
     * @return String
     */
    public String getChaoshuibiao_loufang_mc() {
        return this.chaoshuibiao_loufang_mc;
    }
    /**
     * 设置 房主键
     *
     * @param chaoshuibiao_loufang2_zj String
     */
    public void setChaoshuibiao_loufang2_zj(String chaoshuibiao_loufang2_zj) {
        this.chaoshuibiao_loufang2_zj=chaoshuibiao_loufang2_zj;
    }

    /**
     * 取得 房主键
     *
     * @return String
     */
    public String getChaoshuibiao_loufang2_zj() {
        return this.chaoshuibiao_loufang2_zj;
    }
    /**
     * 设置 房编号
     *
     * @param chaoshuibiao_loufang2_bianma String
     */
    public void setChaoshuibiao_loufang2_bianma(String chaoshuibiao_loufang2_bianma) {
        this.chaoshuibiao_loufang2_bianma=chaoshuibiao_loufang2_bianma;
    }

    /**
     * 取得 房编号
     *
     * @return String
     */
    public String getChaoshuibiao_loufang2_bianma() {
        return this.chaoshuibiao_loufang2_bianma;
    }
    /**
     * 设置 上次读数
     *
     * @param chaoshuibiao_dushu1 Double
     */
    public void setChaoshuibiao_dushu1(Double chaoshuibiao_dushu1) {
        this.chaoshuibiao_dushu1=chaoshuibiao_dushu1;
    }

    /**
     * 取得 上次读数
     *
     * @return Double
     */
    public Double getChaoshuibiao_dushu1() {
        return this.chaoshuibiao_dushu1;
    }
    /**
     * 设置 上次抄表日期
     *
     * @param chaoshuibiao_riqi1 Date
     */
    public void setChaoshuibiao_riqi1(Date chaoshuibiao_riqi1) {
        this.chaoshuibiao_riqi1=chaoshuibiao_riqi1;
    }

    /**
     * 取得 上次抄表日期
     *
     * @return Date
     */
    public Date getChaoshuibiao_riqi1() {
        return this.chaoshuibiao_riqi1;
    }
    /**
     * 设置 读数
     *
     * @param chaoshuibiao_dushu2 Double
     */
    public void setChaoshuibiao_dushu2(Double chaoshuibiao_dushu2) {
        this.chaoshuibiao_dushu2=chaoshuibiao_dushu2;
    }

    /**
     * 取得 读数
     *
     * @return Double
     */
    public Double getChaoshuibiao_dushu2() {
        return this.chaoshuibiao_dushu2;
    }
    /**
     * 设置 抄表日期
     *
     * @param chaoshuibiao_riqi2 Date
     */
    public void setChaoshuibiao_riqi2(Date chaoshuibiao_riqi2) {
        this.chaoshuibiao_riqi2=chaoshuibiao_riqi2;
    }

    /**
     * 取得 抄表日期
     *
     * @return Date
     */
    public Date getChaoshuibiao_riqi2() {
        return this.chaoshuibiao_riqi2;
    }
    /**
     * 设置 水(吨)
     *
     * @param chaoshuibiao_shui Double
     */
    public void setChaoshuibiao_shui(Double chaoshuibiao_shui) {
        this.chaoshuibiao_shui=chaoshuibiao_shui;
    }

    /**
     * 取得 水(吨)
     *
     * @return Double
     */
    public Double getChaoshuibiao_shui() {
        return this.chaoshuibiao_shui;
    }
    /**
     * 设置 水单价
     *
     * @param chaoshuibiao_shui_danjia Double
     */
    public void setChaoshuibiao_shui_danjia(Double chaoshuibiao_shui_danjia) {
        this.chaoshuibiao_shui_danjia=chaoshuibiao_shui_danjia;
    }

    /**
     * 取得 水单价
     *
     * @return Double
     */
    public Double getChaoshuibiao_shui_danjia() {
        return this.chaoshuibiao_shui_danjia;
    }
    /**
     * 设置 金额
     *
     * @param chaoshuibiao_shui_jine Double
     */
    public void setChaoshuibiao_shui_jine(Double chaoshuibiao_shui_jine) {
        this.chaoshuibiao_shui_jine=chaoshuibiao_shui_jine;
    }

    /**
     * 取得 金额
     *
     * @return Double
     */
    public Double getChaoshuibiao_shui_jine() {
        return this.chaoshuibiao_shui_jine;
    }
    /**
     * 设置 制单时间
     *
     * @param chaoshuibiao_zhidanshijian Date
     */
    public void setChaoshuibiao_zhidanshijian(Date chaoshuibiao_zhidanshijian) {
        this.chaoshuibiao_zhidanshijian=chaoshuibiao_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getChaoshuibiao_zhidanshijian() {
        return this.chaoshuibiao_zhidanshijian;
    }
    /**
     * 设置 制单人
     *
     * @param chaoshuibiao_zhidanren String
     */
    public void setChaoshuibiao_zhidanren(String chaoshuibiao_zhidanren) {
        this.chaoshuibiao_zhidanren=chaoshuibiao_zhidanren;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getChaoshuibiao_zhidanren() {
        return this.chaoshuibiao_zhidanren;
    }
    /**
     * 设置 制单人主键
     *
     * @param chaoshuibiao_zhidanren_zj String
     */
    public void setChaoshuibiao_zhidanren_zj(String chaoshuibiao_zhidanren_zj) {
        this.chaoshuibiao_zhidanren_zj=chaoshuibiao_zhidanren_zj;
    }

    /**
     * 取得 制单人主键
     *
     * @return String
     */
    public String getChaoshuibiao_zhidanren_zj() {
        return this.chaoshuibiao_zhidanren_zj;
    }
    /**
     * 设置 分摊人数
     *
     * @param chaoshuibiao_fentanrenshu Integer
     */
    public void setChaoshuibiao_fentanrenshu(Integer chaoshuibiao_fentanrenshu) {
        this.chaoshuibiao_fentanrenshu=chaoshuibiao_fentanrenshu;
    }

    /**
     * 取得 分摊人数
     *
     * @return Integer
     */
    public Integer getChaoshuibiao_fentanrenshu() {
        return this.chaoshuibiao_fentanrenshu;
    }
    /**
     * 设置 已分摊人数
     *
     * @param chaoshuibiao_yj_fentanrenshu Integer
     */
    public void setChaoshuibiao_yj_fentanrenshu(Integer chaoshuibiao_yj_fentanrenshu) {
        this.chaoshuibiao_yj_fentanrenshu=chaoshuibiao_yj_fentanrenshu;
    }

    /**
     * 取得 已分摊人数
     *
     * @return Integer
     */
    public Integer getChaoshuibiao_yj_fentanrenshu() {
        return this.chaoshuibiao_yj_fentanrenshu;
    }
    /**
     * 设置 状态
     *
     * @param chaoshuibiao_zt Integer
     */
    public void setChaoshuibiao_zt(Integer chaoshuibiao_zt) {
        this.chaoshuibiao_zt=chaoshuibiao_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getChaoshuibiao_zt() {
        return this.chaoshuibiao_zt;
    }
    /**
     * 设置 隔离标识
     *
     * @param chaoshuibiao_gelibiaoshi String
     */
    public void setChaoshuibiao_gelibiaoshi(String chaoshuibiao_gelibiaoshi) {
        this.chaoshuibiao_gelibiaoshi=chaoshuibiao_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getChaoshuibiao_gelibiaoshi() {
        return this.chaoshuibiao_gelibiaoshi;
    }
}