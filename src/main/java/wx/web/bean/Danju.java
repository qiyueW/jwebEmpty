package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class Danju {

    private  String danjufl_zj ;// 分类ID 
    @system.base.annotation.ID
    private  String danju_zj ;// 主键
    private  String danju_mc ;// 模块名 
    private  String danju_daima ;// 模块代码 
    private  String danju_qianzhui ;// 单据前缀 
    private  String danju_shijian ;// 单据时间 
    private  String danju_liushuihao ;// 单据流水号 
    private  String danju_bz ;// 备注 
    private  String danju_zhidanren_zj ;// 制单人 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date danju_zhidanshijian ;// 制单时间
    private  String danju_xiugairen_zj ;// 修改人 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date danju_xiugaishijian ;// 修改时间
    private  Integer danju_px ;// 排序 
    private  Integer danju_zt ;// 单据状态 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"danjufl_zj\":\"").append(danjufl_zj).append("\"")
                .append(",\"danju_zj\":\"").append(danju_zj).append("\"")
                .append(",\"danju_mc\":\"").append(danju_mc).append("\"")
                .append(",\"danju_daima\":\"").append(danju_daima).append("\"")
                .append(",\"danju_qianzhui\":\"").append(danju_qianzhui).append("\"")
                .append(",\"danju_shijian\":\"").append(danju_shijian).append("\"")
                .append(",\"danju_liushuihao\":\"").append(danju_liushuihao).append("\"")
                .append(",\"danju_bz\":\"").append(danju_bz).append("\"")
                .append(",\"danju_zhidanren_zj\":\"").append(danju_zhidanren_zj).append("\"")
                .append(",\"danju_zhidanshijian\":\"").append(Tool.dateToString(this.danju_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"danju_xiugairen_zj\":\"").append(danju_xiugairen_zj).append("\"")
                .append(",\"danju_xiugaishijian\":\"").append(Tool.dateToString(this.danju_xiugaishijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"danju_px\":\"").append(danju_px).append("\"")
                .append(",\"danju_zt\":\"").append(danju_zt).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 分类ID
     *
     * @param danjufl_zj String
     */
    public void setDanjufl_zj(String danjufl_zj) {
        this.danjufl_zj=danjufl_zj;
    }

    /**
     * 取得 分类ID
     *
     * @return String
     */
    public String getDanjufl_zj() {
        return this.danjufl_zj;
    }
    /**
     * 设置 主键
     *
     * @param danju_zj String
     */
    public void setDanju_zj(String danju_zj) {
        this.danju_zj=danju_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getDanju_zj() {
        return this.danju_zj;
    }
    /**
     * 设置 模块名
     *
     * @param danju_mc String
     */
    public void setDanju_mc(String danju_mc) {
        this.danju_mc=danju_mc;
    }

    /**
     * 取得 模块名
     *
     * @return String
     */
    public String getDanju_mc() {
        return this.danju_mc;
    }
    /**
     * 设置 模块代码
     *
     * @param danju_daima String
     */
    public void setDanju_daima(String danju_daima) {
        this.danju_daima=danju_daima;
    }

    /**
     * 取得 模块代码
     *
     * @return String
     */
    public String getDanju_daima() {
        return this.danju_daima;
    }
    /**
     * 设置 单据前缀
     *
     * @param danju_qianzhui String
     */
    public void setDanju_qianzhui(String danju_qianzhui) {
        this.danju_qianzhui=danju_qianzhui;
    }

    /**
     * 取得 单据前缀
     *
     * @return String
     */
    public String getDanju_qianzhui() {
        return this.danju_qianzhui;
    }
    /**
     * 设置 单据时间
     *
     * @param danju_shijian String
     */
    public void setDanju_shijian(String danju_shijian) {
        this.danju_shijian=danju_shijian;
    }

    /**
     * 取得 单据时间
     *
     * @return String
     */
    public String getDanju_shijian() {
        return this.danju_shijian;
    }
    /**
     * 设置 单据流水号
     *
     * @param danju_liushuihao String
     */
    public void setDanju_liushuihao(String danju_liushuihao) {
        this.danju_liushuihao=danju_liushuihao;
    }

    /**
     * 取得 单据流水号
     *
     * @return String
     */
    public String getDanju_liushuihao() {
        return this.danju_liushuihao;
    }
    /**
     * 设置 备注
     *
     * @param danju_bz String
     */
    public void setDanju_bz(String danju_bz) {
        this.danju_bz=danju_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getDanju_bz() {
        return this.danju_bz;
    }
    /**
     * 设置 制单人
     *
     * @param danju_zhidanren_zj String
     */
    public void setDanju_zhidanren_zj(String danju_zhidanren_zj) {
        this.danju_zhidanren_zj=danju_zhidanren_zj;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getDanju_zhidanren_zj() {
        return this.danju_zhidanren_zj;
    }
    /**
     * 设置 制单时间
     *
     * @param danju_zhidanshijian Date
     */
    public void setDanju_zhidanshijian(Date danju_zhidanshijian) {
        this.danju_zhidanshijian=danju_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getDanju_zhidanshijian() {
        return this.danju_zhidanshijian;
    }
    /**
     * 设置 修改人
     *
     * @param danju_xiugairen_zj String
     */
    public void setDanju_xiugairen_zj(String danju_xiugairen_zj) {
        this.danju_xiugairen_zj=danju_xiugairen_zj;
    }

    /**
     * 取得 修改人
     *
     * @return String
     */
    public String getDanju_xiugairen_zj() {
        return this.danju_xiugairen_zj;
    }
    /**
     * 设置 修改时间
     *
     * @param danju_xiugaishijian Date
     */
    public void setDanju_xiugaishijian(Date danju_xiugaishijian) {
        this.danju_xiugaishijian=danju_xiugaishijian;
    }

    /**
     * 取得 修改时间
     *
     * @return Date
     */
    public Date getDanju_xiugaishijian() {
        return this.danju_xiugaishijian;
    }
    /**
     * 设置 排序
     *
     * @param danju_px Integer
     */
    public void setDanju_px(Integer danju_px) {
        this.danju_px=danju_px;
    }

    /**
     * 取得 排序
     *
     * @return Integer
     */
    public Integer getDanju_px() {
        return this.danju_px;
    }
    /**
     * 设置 单据状态
     *
     * @param danju_zt Integer
     */
    public void setDanju_zt(Integer danju_zt) {
        this.danju_zt=danju_zt;
    }

    /**
     * 取得 单据状态
     *
     * @return Integer
     */
    public Integer getDanju_zt() {
        return this.danju_zt;
    }
}