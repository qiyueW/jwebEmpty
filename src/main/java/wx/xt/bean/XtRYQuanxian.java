package wx.xt.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class XtRYQuanxian {

    @system.base.annotation.ID
    private  String xt_ryquanxian_zj ;// 主键
    private  String xt_ry_zj ;// 人员主键 
    private  String xt_juese_zj ;// 角色主键集合 
    private  String xt_quanxian ;// 权限代码集合 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date xt_ryquanxian_zhidanshijian ;// 制单时间
    private  String xt_ryquanxian_zhidanren ;// 制单人 
    private  String xt_ryquanxian_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_ryquanxian_zj\":\"").append(xt_ryquanxian_zj).append("\"")
                .append(",\"xt_ry_zj\":\"").append(xt_ry_zj).append("\"")
                .append(",\"xt_juese_zj\":\"").append(xt_juese_zj).append("\"")
                .append(",\"xt_quanxian\":\"").append(xt_quanxian).append("\"")
                .append(",\"xt_ryquanxian_zhidanshijian\":\"").append(Tool.dateToString(this.xt_ryquanxian_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"xt_ryquanxian_zhidanren\":\"").append(xt_ryquanxian_zhidanren).append("\"")
                .append(",\"xt_ryquanxian_gelibiaoshi\":\"").append(xt_ryquanxian_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_ryquanxian_zj String
     */
    public void setXt_ryquanxian_zj(String xt_ryquanxian_zj) {
        this.xt_ryquanxian_zj=xt_ryquanxian_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_ryquanxian_zj() {
        return this.xt_ryquanxian_zj;
    }
    /**
     * 设置 人员主键
     *
     * @param xt_ry_zj String
     */
    public void setXt_ry_zj(String xt_ry_zj) {
        this.xt_ry_zj=xt_ry_zj;
    }

    /**
     * 取得 人员主键
     *
     * @return String
     */
    public String getXt_ry_zj() {
        return this.xt_ry_zj;
    }
    /**
     * 设置 角色主键集合
     *
     * @param xt_juese_zj String
     */
    public void setXt_juese_zj(String xt_juese_zj) {
        this.xt_juese_zj=xt_juese_zj;
    }

    /**
     * 取得 角色主键集合
     *
     * @return String
     */
    public String getXt_juese_zj() {
        return this.xt_juese_zj;
    }
    /**
     * 设置 权限代码集合
     *
     * @param xt_quanxian String
     */
    public void setXt_quanxian(String xt_quanxian) {
        this.xt_quanxian=xt_quanxian;
    }

    /**
     * 取得 权限代码集合
     *
     * @return String
     */
    public String getXt_quanxian() {
        return this.xt_quanxian;
    }
    /**
     * 设置 制单时间
     *
     * @param xt_ryquanxian_zhidanshijian Date
     */
    public void setXt_ryquanxian_zhidanshijian(Date xt_ryquanxian_zhidanshijian) {
        this.xt_ryquanxian_zhidanshijian=xt_ryquanxian_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getXt_ryquanxian_zhidanshijian() {
        return this.xt_ryquanxian_zhidanshijian;
    }
    /**
     * 设置 制单人
     *
     * @param xt_ryquanxian_zhidanren String
     */
    public void setXt_ryquanxian_zhidanren(String xt_ryquanxian_zhidanren) {
        this.xt_ryquanxian_zhidanren=xt_ryquanxian_zhidanren;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getXt_ryquanxian_zhidanren() {
        return this.xt_ryquanxian_zhidanren;
    }
    /**
     * 设置 隔离标识
     *
     * @param xt_ryquanxian_gelibiaoshi String
     */
    public void setXt_ryquanxian_gelibiaoshi(String xt_ryquanxian_gelibiaoshi) {
        this.xt_ryquanxian_gelibiaoshi=xt_ryquanxian_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getXt_ryquanxian_gelibiaoshi() {
        return this.xt_ryquanxian_gelibiaoshi;
    }
}