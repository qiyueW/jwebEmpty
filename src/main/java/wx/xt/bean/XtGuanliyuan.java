package wx.xt.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class XtGuanliyuan {

    @system.base.annotation.ID
    private  String xt_guanliyuan_zj ;// 管理员主键
    private  String xt_guanliyuan_mc ;// 管理员名称 
    private  String xt_guanliyuan_zhanghao ;// 管理员账号 
    private  String xt_guanliyuan_mima ;// 管理员密码 
    private  String xt_guanliyuan_youxiang ;// 管理员邮箱 
    private  Integer xt_guanliyuan_zt ;// 管理员状态 
    private  String xt_guanliyuan_bz ;// 管理员备注 
    private  String xt_guanliyuan_quanxian ;// 管理员权限集合 
    private  String xt_guanliyuan_bm ;// 管理员部门集合 
    private  String xt_guanliyuan_gelibiaoshi ;// 隔离标识 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date xt_guanliyuan_zhidanshijian ;// 制单时间

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_guanliyuan_zj\":\"").append(xt_guanliyuan_zj).append("\"")
                .append(",\"xt_guanliyuan_mc\":\"").append(xt_guanliyuan_mc).append("\"")
                .append(",\"xt_guanliyuan_zhanghao\":\"").append(xt_guanliyuan_zhanghao).append("\"")
                .append(",\"xt_guanliyuan_mima\":\"").append(xt_guanliyuan_mima).append("\"")
                .append(",\"xt_guanliyuan_youxiang\":\"").append(xt_guanliyuan_youxiang).append("\"")
                .append(",\"xt_guanliyuan_zt\":\"").append(xt_guanliyuan_zt).append("\"")
                .append(",\"xt_guanliyuan_bz\":\"").append(xt_guanliyuan_bz).append("\"")
                .append(",\"xt_guanliyuan_quanxian\":\"").append(xt_guanliyuan_quanxian).append("\"")
                .append(",\"xt_guanliyuan_bm\":\"").append(xt_guanliyuan_bm).append("\"")
                .append(",\"xt_guanliyuan_gelibiaoshi\":\"").append(xt_guanliyuan_gelibiaoshi).append("\"")
                .append(",\"xt_guanliyuan_zhidanshijian\":\"").append(Tool.dateToString(this.xt_guanliyuan_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 管理员主键
     *
     * @param xt_guanliyuan_zj String
     */
    public void setXt_guanliyuan_zj(String xt_guanliyuan_zj) {
        this.xt_guanliyuan_zj=xt_guanliyuan_zj;
    }

    /**
     * 取得 管理员主键
     *
     * @return String
     */
    public String getXt_guanliyuan_zj() {
        return this.xt_guanliyuan_zj;
    }
    /**
     * 设置 管理员名称
     *
     * @param xt_guanliyuan_mc String
     */
    public void setXt_guanliyuan_mc(String xt_guanliyuan_mc) {
        this.xt_guanliyuan_mc=xt_guanliyuan_mc;
    }

    /**
     * 取得 管理员名称
     *
     * @return String
     */
    public String getXt_guanliyuan_mc() {
        return this.xt_guanliyuan_mc;
    }
    /**
     * 设置 管理员账号
     *
     * @param xt_guanliyuan_zhanghao String
     */
    public void setXt_guanliyuan_zhanghao(String xt_guanliyuan_zhanghao) {
        this.xt_guanliyuan_zhanghao=xt_guanliyuan_zhanghao;
    }

    /**
     * 取得 管理员账号
     *
     * @return String
     */
    public String getXt_guanliyuan_zhanghao() {
        return this.xt_guanliyuan_zhanghao;
    }
    /**
     * 设置 管理员密码
     *
     * @param xt_guanliyuan_mima String
     */
    public void setXt_guanliyuan_mima(String xt_guanliyuan_mima) {
        this.xt_guanliyuan_mima=xt_guanliyuan_mima;
    }

    /**
     * 取得 管理员密码
     *
     * @return String
     */
    public String getXt_guanliyuan_mima() {
        return this.xt_guanliyuan_mima;
    }
    /**
     * 设置 管理员邮箱
     *
     * @param xt_guanliyuan_youxiang String
     */
    public void setXt_guanliyuan_youxiang(String xt_guanliyuan_youxiang) {
        this.xt_guanliyuan_youxiang=xt_guanliyuan_youxiang;
    }

    /**
     * 取得 管理员邮箱
     *
     * @return String
     */
    public String getXt_guanliyuan_youxiang() {
        return this.xt_guanliyuan_youxiang;
    }
    /**
     * 设置 管理员状态
     *
     * @param xt_guanliyuan_zt Integer
     */
    public void setXt_guanliyuan_zt(Integer xt_guanliyuan_zt) {
        this.xt_guanliyuan_zt=xt_guanliyuan_zt;
    }

    /**
     * 取得 管理员状态
     *
     * @return Integer
     */
    public Integer getXt_guanliyuan_zt() {
        return this.xt_guanliyuan_zt;
    }
    /**
     * 设置 管理员备注
     *
     * @param xt_guanliyuan_bz String
     */
    public void setXt_guanliyuan_bz(String xt_guanliyuan_bz) {
        this.xt_guanliyuan_bz=xt_guanliyuan_bz;
    }

    /**
     * 取得 管理员备注
     *
     * @return String
     */
    public String getXt_guanliyuan_bz() {
        return this.xt_guanliyuan_bz;
    }
    /**
     * 设置 管理员权限集合
     *
     * @param xt_guanliyuan_quanxian String
     */
    public void setXt_guanliyuan_quanxian(String xt_guanliyuan_quanxian) {
        this.xt_guanliyuan_quanxian=xt_guanliyuan_quanxian;
    }

    /**
     * 取得 管理员权限集合
     *
     * @return String
     */
    public String getXt_guanliyuan_quanxian() {
        return this.xt_guanliyuan_quanxian;
    }
    /**
     * 设置 管理员部门集合
     *
     * @param xt_guanliyuan_bm String
     */
    public void setXt_guanliyuan_bm(String xt_guanliyuan_bm) {
        this.xt_guanliyuan_bm=xt_guanliyuan_bm;
    }

    /**
     * 取得 管理员部门集合
     *
     * @return String
     */
    public String getXt_guanliyuan_bm() {
        return this.xt_guanliyuan_bm;
    }
    /**
     * 设置 隔离标识
     *
     * @param xt_guanliyuan_gelibiaoshi String
     */
    public void setXt_guanliyuan_gelibiaoshi(String xt_guanliyuan_gelibiaoshi) {
        this.xt_guanliyuan_gelibiaoshi=xt_guanliyuan_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getXt_guanliyuan_gelibiaoshi() {
        return this.xt_guanliyuan_gelibiaoshi;
    }
    /**
     * 设置 制单时间
     *
     * @param xt_guanliyuan_zhidanshijian Date
     */
    public void setXt_guanliyuan_zhidanshijian(Date xt_guanliyuan_zhidanshijian) {
        this.xt_guanliyuan_zhidanshijian=xt_guanliyuan_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getXt_guanliyuan_zhidanshijian() {
        return this.xt_guanliyuan_zhidanshijian;
    }
}