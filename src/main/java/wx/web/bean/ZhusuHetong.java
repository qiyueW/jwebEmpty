package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class ZhusuHetong {

    @system.base.annotation.ID
    private  String zhusuhetong_zj ;// 主键
    private  String zhusuhetong_gelibiaoshi ;// 隔离标识 
    private  Integer zhusuhetong_zt ;// 状态 
    private  String zhusuhetong_loufang_zj ;// 楼主键 
    private  String zhusuhetong_loufang_mc ;// 楼名称 
    private  String zhusuhetong_loufang2_zj ;// 房主键 
    private  String zhusuhetong_loufang2_bianhao ;// 房编号 
    private  String zhusuhetong_qianyueren ;// 签约人 
    private  String zhusuhetong_qianyueren_zj ;// 签约人主键 
    private  Integer zhusuhetong_yajin ;// 押金 
    private  Integer zhusuhetong_zujin ;// 租金 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date zhusuhetong_kaishiriqi ;// 开始日期
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date zhusuhetong_jieshuriqi ;// 结束日期
    private  Integer zhusuhetong_jffs ;//  
    private  Integer zhusuhetong_jffs_zdrq ;// 计费方式-指定日期 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date zhusuhetong_zuixiaozhusuriqi ;// 最小住宿日期
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date zhusuhetong_zhidanshijian ;// 制单时间
    private  String zhusuhetong_zhidanren ;// 制单人 
    private  String zhusuhetong_zhidanren_zj ;// 制单人主键 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date zhusuhetong_xiugaishijian ;// 修改时间
    private  String zhusuhetong_xiugairen ;// 修改人 
    private  String zhusuhetong_xiugairen_zj ;// 修改人主键 
    private  String zhusuhetong_bz ;// 备注 
    private  Integer zhusuhetong_tj_xml ;// 统计项目费 
    private  String zhusuhetong_xml_zj ;// 楼房项目 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"zhusuhetong_zj\":\"").append(zhusuhetong_zj).append("\"")
                .append(",\"zhusuhetong_gelibiaoshi\":\"").append(zhusuhetong_gelibiaoshi).append("\"")
                .append(",\"zhusuhetong_zt\":\"").append(zhusuhetong_zt).append("\"")
                .append(",\"zhusuhetong_loufang_zj\":\"").append(zhusuhetong_loufang_zj).append("\"")
                .append(",\"zhusuhetong_loufang_mc\":\"").append(zhusuhetong_loufang_mc).append("\"")
                .append(",\"zhusuhetong_loufang2_zj\":\"").append(zhusuhetong_loufang2_zj).append("\"")
                .append(",\"zhusuhetong_loufang2_bianhao\":\"").append(zhusuhetong_loufang2_bianhao).append("\"")
                .append(",\"zhusuhetong_qianyueren\":\"").append(zhusuhetong_qianyueren).append("\"")
                .append(",\"zhusuhetong_qianyueren_zj\":\"").append(zhusuhetong_qianyueren_zj).append("\"")
                .append(",\"zhusuhetong_yajin\":\"").append(zhusuhetong_yajin).append("\"")
                .append(",\"zhusuhetong_zujin\":\"").append(zhusuhetong_zujin).append("\"")
                .append(",\"zhusuhetong_kaishiriqi\":\"").append(Tool.dateToString(this.zhusuhetong_kaishiriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"zhusuhetong_jieshuriqi\":\"").append(Tool.dateToString(this.zhusuhetong_jieshuriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"zhusuhetong_jffs\":\"").append(zhusuhetong_jffs).append("\"")
                .append(",\"zhusuhetong_jffs_zdrq\":\"").append(zhusuhetong_jffs_zdrq).append("\"")
                .append(",\"zhusuhetong_zuixiaozhusuriqi\":\"").append(Tool.dateToString(this.zhusuhetong_zuixiaozhusuriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"zhusuhetong_zhidanshijian\":\"").append(Tool.dateToString(this.zhusuhetong_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"zhusuhetong_zhidanren\":\"").append(zhusuhetong_zhidanren).append("\"")
                .append(",\"zhusuhetong_zhidanren_zj\":\"").append(zhusuhetong_zhidanren_zj).append("\"")
                .append(",\"zhusuhetong_xiugaishijian\":\"").append(Tool.dateToString(this.zhusuhetong_xiugaishijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"zhusuhetong_xiugairen\":\"").append(zhusuhetong_xiugairen).append("\"")
                .append(",\"zhusuhetong_xiugairen_zj\":\"").append(zhusuhetong_xiugairen_zj).append("\"")
                .append(",\"zhusuhetong_bz\":\"").append(zhusuhetong_bz).append("\"")
                .append(",\"zhusuhetong_tj_xml\":\"").append(zhusuhetong_tj_xml).append("\"")
                .append(",\"zhusuhetong_xml_zj\":\"").append(zhusuhetong_xml_zj).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param zhusuhetong_zj String
     */
    public void setZhusuhetong_zj(String zhusuhetong_zj) {
        this.zhusuhetong_zj=zhusuhetong_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getZhusuhetong_zj() {
        return this.zhusuhetong_zj;
    }
    /**
     * 设置 隔离标识
     *
     * @param zhusuhetong_gelibiaoshi String
     */
    public void setZhusuhetong_gelibiaoshi(String zhusuhetong_gelibiaoshi) {
        this.zhusuhetong_gelibiaoshi=zhusuhetong_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getZhusuhetong_gelibiaoshi() {
        return this.zhusuhetong_gelibiaoshi;
    }
    /**
     * 设置 状态
     *
     * @param zhusuhetong_zt Integer
     */
    public void setZhusuhetong_zt(Integer zhusuhetong_zt) {
        this.zhusuhetong_zt=zhusuhetong_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getZhusuhetong_zt() {
        return this.zhusuhetong_zt;
    }
    /**
     * 设置 楼主键
     *
     * @param zhusuhetong_loufang_zj String
     */
    public void setZhusuhetong_loufang_zj(String zhusuhetong_loufang_zj) {
        this.zhusuhetong_loufang_zj=zhusuhetong_loufang_zj;
    }

    /**
     * 取得 楼主键
     *
     * @return String
     */
    public String getZhusuhetong_loufang_zj() {
        return this.zhusuhetong_loufang_zj;
    }
    /**
     * 设置 楼名称
     *
     * @param zhusuhetong_loufang_mc String
     */
    public void setZhusuhetong_loufang_mc(String zhusuhetong_loufang_mc) {
        this.zhusuhetong_loufang_mc=zhusuhetong_loufang_mc;
    }

    /**
     * 取得 楼名称
     *
     * @return String
     */
    public String getZhusuhetong_loufang_mc() {
        return this.zhusuhetong_loufang_mc;
    }
    /**
     * 设置 房主键
     *
     * @param zhusuhetong_loufang2_zj String
     */
    public void setZhusuhetong_loufang2_zj(String zhusuhetong_loufang2_zj) {
        this.zhusuhetong_loufang2_zj=zhusuhetong_loufang2_zj;
    }

    /**
     * 取得 房主键
     *
     * @return String
     */
    public String getZhusuhetong_loufang2_zj() {
        return this.zhusuhetong_loufang2_zj;
    }
    /**
     * 设置 房编号
     *
     * @param zhusuhetong_loufang2_bianhao String
     */
    public void setZhusuhetong_loufang2_bianhao(String zhusuhetong_loufang2_bianhao) {
        this.zhusuhetong_loufang2_bianhao=zhusuhetong_loufang2_bianhao;
    }

    /**
     * 取得 房编号
     *
     * @return String
     */
    public String getZhusuhetong_loufang2_bianhao() {
        return this.zhusuhetong_loufang2_bianhao;
    }
    /**
     * 设置 签约人
     *
     * @param zhusuhetong_qianyueren String
     */
    public void setZhusuhetong_qianyueren(String zhusuhetong_qianyueren) {
        this.zhusuhetong_qianyueren=zhusuhetong_qianyueren;
    }

    /**
     * 取得 签约人
     *
     * @return String
     */
    public String getZhusuhetong_qianyueren() {
        return this.zhusuhetong_qianyueren;
    }
    /**
     * 设置 签约人主键
     *
     * @param zhusuhetong_qianyueren_zj String
     */
    public void setZhusuhetong_qianyueren_zj(String zhusuhetong_qianyueren_zj) {
        this.zhusuhetong_qianyueren_zj=zhusuhetong_qianyueren_zj;
    }

    /**
     * 取得 签约人主键
     *
     * @return String
     */
    public String getZhusuhetong_qianyueren_zj() {
        return this.zhusuhetong_qianyueren_zj;
    }
    /**
     * 设置 押金
     *
     * @param zhusuhetong_yajin Integer
     */
    public void setZhusuhetong_yajin(Integer zhusuhetong_yajin) {
        this.zhusuhetong_yajin=zhusuhetong_yajin;
    }

    /**
     * 取得 押金
     *
     * @return Integer
     */
    public Integer getZhusuhetong_yajin() {
        return this.zhusuhetong_yajin;
    }
    /**
     * 设置 租金
     *
     * @param zhusuhetong_zujin Integer
     */
    public void setZhusuhetong_zujin(Integer zhusuhetong_zujin) {
        this.zhusuhetong_zujin=zhusuhetong_zujin;
    }

    /**
     * 取得 租金
     *
     * @return Integer
     */
    public Integer getZhusuhetong_zujin() {
        return this.zhusuhetong_zujin;
    }
    /**
     * 设置 开始日期
     *
     * @param zhusuhetong_kaishiriqi Date
     */
    public void setZhusuhetong_kaishiriqi(Date zhusuhetong_kaishiriqi) {
        this.zhusuhetong_kaishiriqi=zhusuhetong_kaishiriqi;
    }

    /**
     * 取得 开始日期
     *
     * @return Date
     */
    public Date getZhusuhetong_kaishiriqi() {
        return this.zhusuhetong_kaishiriqi;
    }
    /**
     * 设置 结束日期
     *
     * @param zhusuhetong_jieshuriqi Date
     */
    public void setZhusuhetong_jieshuriqi(Date zhusuhetong_jieshuriqi) {
        this.zhusuhetong_jieshuriqi=zhusuhetong_jieshuriqi;
    }

    /**
     * 取得 结束日期
     *
     * @return Date
     */
    public Date getZhusuhetong_jieshuriqi() {
        return this.zhusuhetong_jieshuriqi;
    }
    /**
     * 设置 
     *
     * @param zhusuhetong_jffs Integer
     */
    public void setZhusuhetong_jffs(Integer zhusuhetong_jffs) {
        this.zhusuhetong_jffs=zhusuhetong_jffs;
    }

    /**
     * 取得 
     *
     * @return Integer
     */
    public Integer getZhusuhetong_jffs() {
        return this.zhusuhetong_jffs;
    }
    /**
     * 设置 计费方式-指定日期
     *
     * @param zhusuhetong_jffs_zdrq Integer
     */
    public void setZhusuhetong_jffs_zdrq(Integer zhusuhetong_jffs_zdrq) {
        this.zhusuhetong_jffs_zdrq=zhusuhetong_jffs_zdrq;
    }

    /**
     * 取得 计费方式-指定日期
     *
     * @return Integer
     */
    public Integer getZhusuhetong_jffs_zdrq() {
        return this.zhusuhetong_jffs_zdrq;
    }
    /**
     * 设置 最小住宿日期
     *
     * @param zhusuhetong_zuixiaozhusuriqi Date
     */
    public void setZhusuhetong_zuixiaozhusuriqi(Date zhusuhetong_zuixiaozhusuriqi) {
        this.zhusuhetong_zuixiaozhusuriqi=zhusuhetong_zuixiaozhusuriqi;
    }

    /**
     * 取得 最小住宿日期
     *
     * @return Date
     */
    public Date getZhusuhetong_zuixiaozhusuriqi() {
        return this.zhusuhetong_zuixiaozhusuriqi;
    }
    /**
     * 设置 制单时间
     *
     * @param zhusuhetong_zhidanshijian Date
     */
    public void setZhusuhetong_zhidanshijian(Date zhusuhetong_zhidanshijian) {
        this.zhusuhetong_zhidanshijian=zhusuhetong_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getZhusuhetong_zhidanshijian() {
        return this.zhusuhetong_zhidanshijian;
    }
    /**
     * 设置 制单人
     *
     * @param zhusuhetong_zhidanren String
     */
    public void setZhusuhetong_zhidanren(String zhusuhetong_zhidanren) {
        this.zhusuhetong_zhidanren=zhusuhetong_zhidanren;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getZhusuhetong_zhidanren() {
        return this.zhusuhetong_zhidanren;
    }
    /**
     * 设置 制单人主键
     *
     * @param zhusuhetong_zhidanren_zj String
     */
    public void setZhusuhetong_zhidanren_zj(String zhusuhetong_zhidanren_zj) {
        this.zhusuhetong_zhidanren_zj=zhusuhetong_zhidanren_zj;
    }

    /**
     * 取得 制单人主键
     *
     * @return String
     */
    public String getZhusuhetong_zhidanren_zj() {
        return this.zhusuhetong_zhidanren_zj;
    }
    /**
     * 设置 修改时间
     *
     * @param zhusuhetong_xiugaishijian Date
     */
    public void setZhusuhetong_xiugaishijian(Date zhusuhetong_xiugaishijian) {
        this.zhusuhetong_xiugaishijian=zhusuhetong_xiugaishijian;
    }

    /**
     * 取得 修改时间
     *
     * @return Date
     */
    public Date getZhusuhetong_xiugaishijian() {
        return this.zhusuhetong_xiugaishijian;
    }
    /**
     * 设置 修改人
     *
     * @param zhusuhetong_xiugairen String
     */
    public void setZhusuhetong_xiugairen(String zhusuhetong_xiugairen) {
        this.zhusuhetong_xiugairen=zhusuhetong_xiugairen;
    }

    /**
     * 取得 修改人
     *
     * @return String
     */
    public String getZhusuhetong_xiugairen() {
        return this.zhusuhetong_xiugairen;
    }
    /**
     * 设置 修改人主键
     *
     * @param zhusuhetong_xiugairen_zj String
     */
    public void setZhusuhetong_xiugairen_zj(String zhusuhetong_xiugairen_zj) {
        this.zhusuhetong_xiugairen_zj=zhusuhetong_xiugairen_zj;
    }

    /**
     * 取得 修改人主键
     *
     * @return String
     */
    public String getZhusuhetong_xiugairen_zj() {
        return this.zhusuhetong_xiugairen_zj;
    }
    /**
     * 设置 备注
     *
     * @param zhusuhetong_bz String
     */
    public void setZhusuhetong_bz(String zhusuhetong_bz) {
        this.zhusuhetong_bz=zhusuhetong_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getZhusuhetong_bz() {
        return this.zhusuhetong_bz;
    }
    /**
     * 设置 统计项目费
     *
     * @param zhusuhetong_tj_xml Integer
     */
    public void setZhusuhetong_tj_xml(Integer zhusuhetong_tj_xml) {
        this.zhusuhetong_tj_xml=zhusuhetong_tj_xml;
    }

    /**
     * 取得 统计项目费
     *
     * @return Integer
     */
    public Integer getZhusuhetong_tj_xml() {
        return this.zhusuhetong_tj_xml;
    }
    /**
     * 设置 楼房项目
     *
     * @param zhusuhetong_xml_zj String
     */
    public void setZhusuhetong_xml_zj(String zhusuhetong_xml_zj) {
        this.zhusuhetong_xml_zj=zhusuhetong_xml_zj;
    }

    /**
     * 取得 楼房项目
     *
     * @return String
     */
    public String getZhusuhetong_xml_zj() {
        return this.zhusuhetong_xml_zj;
    }
}