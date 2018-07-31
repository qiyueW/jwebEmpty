package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class LoufangNafei {

    @system.base.annotation.ID
    private  String loufangnafei_zj ;// 主键
    private  String loufangnafei_lou_zj ;// 楼主键 
    private  String loufangnafei_fang_zj ;// 房主键 
    private  String loufangnafei_gelibiaoshi ;// 隔离标识 
    private  String loufangnafei_lou_mc ;// 楼名称 
    private  String loufangnafei_fang_bianma ;// 房编码 
    private  String loufangnafei_ren ;// 纳费人 
    private  String loufangnafei_ren_zj ;// 纳费人主键 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date loufangnafei_yingnariqi ;// 应纳日期
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date loufangnafei_nafeiriqi ;// 纳费日期
    private  Double loufangnafei_zongfeiyong ;// 总费用 
    private  Double loufangnafei_zongfeiyong2 ;// 已纳费用 
    private  Double loufangnafei_fangzu ;// 房租 
    private  Double loufangnafei_feiyong_shui ;// 水费 
    private  String loufangnafei_feiyong_shui_zj ;// 水费主键集合 
    private  Double loufangnafei_feiyong_dian ;// 电费 
    private  String loufangnafei_feiyong_dian_zj ;// 电费主键集合 
    private  Double loufangnafei_feiyong_xm ;// 项目费 
    private  String loufangnafei_feiyong_xm_zj ;// 项目费主键集合 
    private  Double loufangnafei_feiyong_meiqi ;// 煤气费 
    private  String loufangnafei_feiyong_meiqi_zj ;// 煤气费主键集合 
    private  Integer loufangnafei_zt ;// 状态 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date loufangnafei_chuzhangshijian ;// 出账时间

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufangnafei_zj\":\"").append(loufangnafei_zj).append("\"")
                .append(",\"loufangnafei_lou_zj\":\"").append(loufangnafei_lou_zj).append("\"")
                .append(",\"loufangnafei_fang_zj\":\"").append(loufangnafei_fang_zj).append("\"")
                .append(",\"loufangnafei_gelibiaoshi\":\"").append(loufangnafei_gelibiaoshi).append("\"")
                .append(",\"loufangnafei_lou_mc\":\"").append(loufangnafei_lou_mc).append("\"")
                .append(",\"loufangnafei_fang_bianma\":\"").append(loufangnafei_fang_bianma).append("\"")
                .append(",\"loufangnafei_ren\":\"").append(loufangnafei_ren).append("\"")
                .append(",\"loufangnafei_ren_zj\":\"").append(loufangnafei_ren_zj).append("\"")
                .append(",\"loufangnafei_yingnariqi\":\"").append(Tool.dateToString(this.loufangnafei_yingnariqi, "yyyy-MM-dd")).append("\"")
                .append(",\"loufangnafei_nafeiriqi\":\"").append(Tool.dateToString(this.loufangnafei_nafeiriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"loufangnafei_zongfeiyong\":\"").append(loufangnafei_zongfeiyong).append("\"")
                .append(",\"loufangnafei_zongfeiyong2\":\"").append(loufangnafei_zongfeiyong2).append("\"")
                .append(",\"loufangnafei_fangzu\":\"").append(loufangnafei_fangzu).append("\"")
                .append(",\"loufangnafei_feiyong_shui\":\"").append(loufangnafei_feiyong_shui).append("\"")
                .append(",\"loufangnafei_feiyong_shui_zj\":\"").append(loufangnafei_feiyong_shui_zj).append("\"")
                .append(",\"loufangnafei_feiyong_dian\":\"").append(loufangnafei_feiyong_dian).append("\"")
                .append(",\"loufangnafei_feiyong_dian_zj\":\"").append(loufangnafei_feiyong_dian_zj).append("\"")
                .append(",\"loufangnafei_feiyong_xm\":\"").append(loufangnafei_feiyong_xm).append("\"")
                .append(",\"loufangnafei_feiyong_xm_zj\":\"").append(loufangnafei_feiyong_xm_zj).append("\"")
                .append(",\"loufangnafei_feiyong_meiqi\":\"").append(loufangnafei_feiyong_meiqi).append("\"")
                .append(",\"loufangnafei_feiyong_meiqi_zj\":\"").append(loufangnafei_feiyong_meiqi_zj).append("\"")
                .append(",\"loufangnafei_zt\":\"").append(loufangnafei_zt).append("\"")
                .append(",\"loufangnafei_chuzhangshijian\":\"").append(Tool.dateToString(this.loufangnafei_chuzhangshijian, "yyyy-MM-dd HH:mm:ss")).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param loufangnafei_zj String
     */
    public void setLoufangnafei_zj(String loufangnafei_zj) {
        this.loufangnafei_zj=loufangnafei_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getLoufangnafei_zj() {
        return this.loufangnafei_zj;
    }
    /**
     * 设置 楼主键
     *
     * @param loufangnafei_lou_zj String
     */
    public void setLoufangnafei_lou_zj(String loufangnafei_lou_zj) {
        this.loufangnafei_lou_zj=loufangnafei_lou_zj;
    }

    /**
     * 取得 楼主键
     *
     * @return String
     */
    public String getLoufangnafei_lou_zj() {
        return this.loufangnafei_lou_zj;
    }
    /**
     * 设置 房主键
     *
     * @param loufangnafei_fang_zj String
     */
    public void setLoufangnafei_fang_zj(String loufangnafei_fang_zj) {
        this.loufangnafei_fang_zj=loufangnafei_fang_zj;
    }

    /**
     * 取得 房主键
     *
     * @return String
     */
    public String getLoufangnafei_fang_zj() {
        return this.loufangnafei_fang_zj;
    }
    /**
     * 设置 隔离标识
     *
     * @param loufangnafei_gelibiaoshi String
     */
    public void setLoufangnafei_gelibiaoshi(String loufangnafei_gelibiaoshi) {
        this.loufangnafei_gelibiaoshi=loufangnafei_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getLoufangnafei_gelibiaoshi() {
        return this.loufangnafei_gelibiaoshi;
    }
    /**
     * 设置 楼名称
     *
     * @param loufangnafei_lou_mc String
     */
    public void setLoufangnafei_lou_mc(String loufangnafei_lou_mc) {
        this.loufangnafei_lou_mc=loufangnafei_lou_mc;
    }

    /**
     * 取得 楼名称
     *
     * @return String
     */
    public String getLoufangnafei_lou_mc() {
        return this.loufangnafei_lou_mc;
    }
    /**
     * 设置 房编码
     *
     * @param loufangnafei_fang_bianma String
     */
    public void setLoufangnafei_fang_bianma(String loufangnafei_fang_bianma) {
        this.loufangnafei_fang_bianma=loufangnafei_fang_bianma;
    }

    /**
     * 取得 房编码
     *
     * @return String
     */
    public String getLoufangnafei_fang_bianma() {
        return this.loufangnafei_fang_bianma;
    }
    /**
     * 设置 纳费人
     *
     * @param loufangnafei_ren String
     */
    public void setLoufangnafei_ren(String loufangnafei_ren) {
        this.loufangnafei_ren=loufangnafei_ren;
    }

    /**
     * 取得 纳费人
     *
     * @return String
     */
    public String getLoufangnafei_ren() {
        return this.loufangnafei_ren;
    }
    /**
     * 设置 纳费人主键
     *
     * @param loufangnafei_ren_zj String
     */
    public void setLoufangnafei_ren_zj(String loufangnafei_ren_zj) {
        this.loufangnafei_ren_zj=loufangnafei_ren_zj;
    }

    /**
     * 取得 纳费人主键
     *
     * @return String
     */
    public String getLoufangnafei_ren_zj() {
        return this.loufangnafei_ren_zj;
    }
    /**
     * 设置 应纳日期
     *
     * @param loufangnafei_yingnariqi Date
     */
    public void setLoufangnafei_yingnariqi(Date loufangnafei_yingnariqi) {
        this.loufangnafei_yingnariqi=loufangnafei_yingnariqi;
    }

    /**
     * 取得 应纳日期
     *
     * @return Date
     */
    public Date getLoufangnafei_yingnariqi() {
        return this.loufangnafei_yingnariqi;
    }
    /**
     * 设置 纳费日期
     *
     * @param loufangnafei_nafeiriqi Date
     */
    public void setLoufangnafei_nafeiriqi(Date loufangnafei_nafeiriqi) {
        this.loufangnafei_nafeiriqi=loufangnafei_nafeiriqi;
    }

    /**
     * 取得 纳费日期
     *
     * @return Date
     */
    public Date getLoufangnafei_nafeiriqi() {
        return this.loufangnafei_nafeiriqi;
    }
    /**
     * 设置 总费用
     *
     * @param loufangnafei_zongfeiyong Double
     */
    public void setLoufangnafei_zongfeiyong(Double loufangnafei_zongfeiyong) {
        this.loufangnafei_zongfeiyong=loufangnafei_zongfeiyong;
    }

    /**
     * 取得 总费用
     *
     * @return Double
     */
    public Double getLoufangnafei_zongfeiyong() {
        return this.loufangnafei_zongfeiyong;
    }
    /**
     * 设置 已纳费用
     *
     * @param loufangnafei_zongfeiyong2 Double
     */
    public void setLoufangnafei_zongfeiyong2(Double loufangnafei_zongfeiyong2) {
        this.loufangnafei_zongfeiyong2=loufangnafei_zongfeiyong2;
    }

    /**
     * 取得 已纳费用
     *
     * @return Double
     */
    public Double getLoufangnafei_zongfeiyong2() {
        return this.loufangnafei_zongfeiyong2;
    }
    /**
     * 设置 房租
     *
     * @param loufangnafei_fangzu Double
     */
    public void setLoufangnafei_fangzu(Double loufangnafei_fangzu) {
        this.loufangnafei_fangzu=loufangnafei_fangzu;
    }

    /**
     * 取得 房租
     *
     * @return Double
     */
    public Double getLoufangnafei_fangzu() {
        return this.loufangnafei_fangzu;
    }
    /**
     * 设置 水费
     *
     * @param loufangnafei_feiyong_shui Double
     */
    public void setLoufangnafei_feiyong_shui(Double loufangnafei_feiyong_shui) {
        this.loufangnafei_feiyong_shui=loufangnafei_feiyong_shui;
    }

    /**
     * 取得 水费
     *
     * @return Double
     */
    public Double getLoufangnafei_feiyong_shui() {
        return this.loufangnafei_feiyong_shui;
    }
    /**
     * 设置 水费主键集合
     *
     * @param loufangnafei_feiyong_shui_zj String
     */
    public void setLoufangnafei_feiyong_shui_zj(String loufangnafei_feiyong_shui_zj) {
        this.loufangnafei_feiyong_shui_zj=loufangnafei_feiyong_shui_zj;
    }

    /**
     * 取得 水费主键集合
     *
     * @return String
     */
    public String getLoufangnafei_feiyong_shui_zj() {
        return this.loufangnafei_feiyong_shui_zj;
    }
    /**
     * 设置 电费
     *
     * @param loufangnafei_feiyong_dian Double
     */
    public void setLoufangnafei_feiyong_dian(Double loufangnafei_feiyong_dian) {
        this.loufangnafei_feiyong_dian=loufangnafei_feiyong_dian;
    }

    /**
     * 取得 电费
     *
     * @return Double
     */
    public Double getLoufangnafei_feiyong_dian() {
        return this.loufangnafei_feiyong_dian;
    }
    /**
     * 设置 电费主键集合
     *
     * @param loufangnafei_feiyong_dian_zj String
     */
    public void setLoufangnafei_feiyong_dian_zj(String loufangnafei_feiyong_dian_zj) {
        this.loufangnafei_feiyong_dian_zj=loufangnafei_feiyong_dian_zj;
    }

    /**
     * 取得 电费主键集合
     *
     * @return String
     */
    public String getLoufangnafei_feiyong_dian_zj() {
        return this.loufangnafei_feiyong_dian_zj;
    }
    /**
     * 设置 项目费
     *
     * @param loufangnafei_feiyong_xm Double
     */
    public void setLoufangnafei_feiyong_xm(Double loufangnafei_feiyong_xm) {
        this.loufangnafei_feiyong_xm=loufangnafei_feiyong_xm;
    }

    /**
     * 取得 项目费
     *
     * @return Double
     */
    public Double getLoufangnafei_feiyong_xm() {
        return this.loufangnafei_feiyong_xm;
    }
    /**
     * 设置 项目费主键集合
     *
     * @param loufangnafei_feiyong_xm_zj String
     */
    public void setLoufangnafei_feiyong_xm_zj(String loufangnafei_feiyong_xm_zj) {
        this.loufangnafei_feiyong_xm_zj=loufangnafei_feiyong_xm_zj;
    }

    /**
     * 取得 项目费主键集合
     *
     * @return String
     */
    public String getLoufangnafei_feiyong_xm_zj() {
        return this.loufangnafei_feiyong_xm_zj;
    }
    /**
     * 设置 煤气费
     *
     * @param loufangnafei_feiyong_meiqi Double
     */
    public void setLoufangnafei_feiyong_meiqi(Double loufangnafei_feiyong_meiqi) {
        this.loufangnafei_feiyong_meiqi=loufangnafei_feiyong_meiqi;
    }

    /**
     * 取得 煤气费
     *
     * @return Double
     */
    public Double getLoufangnafei_feiyong_meiqi() {
        return this.loufangnafei_feiyong_meiqi;
    }
    /**
     * 设置 煤气费主键集合
     *
     * @param loufangnafei_feiyong_meiqi_zj String
     */
    public void setLoufangnafei_feiyong_meiqi_zj(String loufangnafei_feiyong_meiqi_zj) {
        this.loufangnafei_feiyong_meiqi_zj=loufangnafei_feiyong_meiqi_zj;
    }

    /**
     * 取得 煤气费主键集合
     *
     * @return String
     */
    public String getLoufangnafei_feiyong_meiqi_zj() {
        return this.loufangnafei_feiyong_meiqi_zj;
    }
    /**
     * 设置 状态
     *
     * @param loufangnafei_zt Integer
     */
    public void setLoufangnafei_zt(Integer loufangnafei_zt) {
        this.loufangnafei_zt=loufangnafei_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getLoufangnafei_zt() {
        return this.loufangnafei_zt;
    }
    /**
     * 设置 出账时间
     *
     * @param loufangnafei_chuzhangshijian Date
     */
    public void setLoufangnafei_chuzhangshijian(Date loufangnafei_chuzhangshijian) {
        this.loufangnafei_chuzhangshijian=loufangnafei_chuzhangshijian;
    }

    /**
     * 取得 出账时间
     *
     * @return Date
     */
    public Date getLoufangnafei_chuzhangshijian() {
        return this.loufangnafei_chuzhangshijian;
    }
}