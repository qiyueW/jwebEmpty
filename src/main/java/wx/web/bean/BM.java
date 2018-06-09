package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class BM {

    private  String bm_zj ;// 主键 
    private  String bm_fzj ;// 父键 
    private  String bm_mc ;// 名称 
    private  String bm_bianma ;// 编码 
    private  String bm_jianjie ;// 部门简介 
    private  String bm_tupian1 ;// 部门图片1 
    private  String bm_tupian2 ;// 部门图片2 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date bm_chuangjianshijian ;// 部门创建时间
    private  String bm_fuzhiren_zj ;// 部门负责人主键 
    private  String bm_fuzhiren ;// 部门负责人 
    private  Integer bm_zt ;// 部门状态 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"bm_zj\":\"").append(bm_zj).append("\"")
                .append(",\"bm_fzj\":\"").append(bm_fzj).append("\"")
                .append(",\"bm_mc\":\"").append(bm_mc).append("\"")
                .append(",\"bm_bianma\":\"").append(bm_bianma).append("\"")
                .append(",\"bm_jianjie\":\"").append(bm_jianjie).append("\"")
                .append(",\"bm_tupian1\":\"").append(bm_tupian1).append("\"")
                .append(",\"bm_tupian2\":\"").append(bm_tupian2).append("\"")
                .append(",\"bm_chuangjianshijian\":\"").append(Tool.dateToString(this.bm_chuangjianshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"bm_fuzhiren_zj\":\"").append(bm_fuzhiren_zj).append("\"")
                .append(",\"bm_fuzhiren\":\"").append(bm_fuzhiren).append("\"")
                .append(",\"bm_zt\":\"").append(bm_zt).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param bm_zj String
     */
    public void setBm_zj(String bm_zj) {
        this.bm_zj=bm_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getBm_zj() {
        return this.bm_zj;
    }
    /**
     * 设置 父键
     *
     * @param bm_fzj String
     */
    public void setBm_fzj(String bm_fzj) {
        this.bm_fzj=bm_fzj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getBm_fzj() {
        return this.bm_fzj;
    }
    /**
     * 设置 名称
     *
     * @param bm_mc String
     */
    public void setBm_mc(String bm_mc) {
        this.bm_mc=bm_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getBm_mc() {
        return this.bm_mc;
    }
    /**
     * 设置 编码
     *
     * @param bm_bianma String
     */
    public void setBm_bianma(String bm_bianma) {
        this.bm_bianma=bm_bianma;
    }

    /**
     * 取得 编码
     *
     * @return String
     */
    public String getBm_bianma() {
        return this.bm_bianma;
    }
    /**
     * 设置 部门简介
     *
     * @param bm_jianjie String
     */
    public void setBm_jianjie(String bm_jianjie) {
        this.bm_jianjie=bm_jianjie;
    }

    /**
     * 取得 部门简介
     *
     * @return String
     */
    public String getBm_jianjie() {
        return this.bm_jianjie;
    }
    /**
     * 设置 部门图片1
     *
     * @param bm_tupian1 String
     */
    public void setBm_tupian1(String bm_tupian1) {
        this.bm_tupian1=bm_tupian1;
    }

    /**
     * 取得 部门图片1
     *
     * @return String
     */
    public String getBm_tupian1() {
        return this.bm_tupian1;
    }
    /**
     * 设置 部门图片2
     *
     * @param bm_tupian2 String
     */
    public void setBm_tupian2(String bm_tupian2) {
        this.bm_tupian2=bm_tupian2;
    }

    /**
     * 取得 部门图片2
     *
     * @return String
     */
    public String getBm_tupian2() {
        return this.bm_tupian2;
    }
    /**
     * 设置 部门创建时间
     *
     * @param bm_chuangjianshijian Date
     */
    public void setBm_chuangjianshijian(Date bm_chuangjianshijian) {
        this.bm_chuangjianshijian=bm_chuangjianshijian;
    }

    /**
     * 取得 部门创建时间
     *
     * @return Date
     */
    public Date getBm_chuangjianshijian() {
        return this.bm_chuangjianshijian;
    }
    /**
     * 设置 部门负责人主键
     *
     * @param bm_fuzhiren_zj String
     */
    public void setBm_fuzhiren_zj(String bm_fuzhiren_zj) {
        this.bm_fuzhiren_zj=bm_fuzhiren_zj;
    }

    /**
     * 取得 部门负责人主键
     *
     * @return String
     */
    public String getBm_fuzhiren_zj() {
        return this.bm_fuzhiren_zj;
    }
    /**
     * 设置 部门负责人
     *
     * @param bm_fuzhiren String
     */
    public void setBm_fuzhiren(String bm_fuzhiren) {
        this.bm_fuzhiren=bm_fuzhiren;
    }

    /**
     * 取得 部门负责人
     *
     * @return String
     */
    public String getBm_fuzhiren() {
        return this.bm_fuzhiren;
    }
    /**
     * 设置 部门状态
     *
     * @param bm_zt Integer
     */
    public void setBm_zt(Integer bm_zt) {
        this.bm_zt=bm_zt;
    }

    /**
     * 取得 部门状态
     *
     * @return Integer
     */
    public Integer getBm_zt() {
        return this.bm_zt;
    }
}