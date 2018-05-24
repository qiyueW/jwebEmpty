package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class Mytest {

    private  String mytest_zj ;// 主键 
    private  String mytest_fzj ;// 父键 
    private  String mytest_mc ;// 名称 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date mytest_zhidanshijian ;// 制单时间
    private  String mytest_bianhao ;// 编号 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"mytest_zj\":\"").append(mytest_zj).append("\"")
                .append(",\"mytest_fzj\":\"").append(mytest_fzj).append("\"")
                .append(",\"mytest_mc\":\"").append(mytest_mc).append("\"")
                .append(",\"mytest_zhidanshijian\":\"").append(Tool.dateToString(this.mytest_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"")
                .append(",\"mytest_bianhao\":\"").append(mytest_bianhao).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param mytest_zj String
     */
    public void setMytest_zj(String mytest_zj) {
        this.mytest_zj=mytest_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getMytest_zj() {
        return this.mytest_zj;
    }
    /**
     * 设置 父键
     *
     * @param mytest_fzj String
     */
    public void setMytest_fzj(String mytest_fzj) {
        this.mytest_fzj=mytest_fzj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getMytest_fzj() {
        return this.mytest_fzj;
    }
    /**
     * 设置 名称
     *
     * @param mytest_mc String
     */
    public void setMytest_mc(String mytest_mc) {
        this.mytest_mc=mytest_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getMytest_mc() {
        return this.mytest_mc;
    }
    /**
     * 设置 制单时间
     *
     * @param mytest_zhidanshijian Date
     */
    public void setMytest_zhidanshijian(Date mytest_zhidanshijian) {
        this.mytest_zhidanshijian=mytest_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getMytest_zhidanshijian() {
        return this.mytest_zhidanshijian;
    }
    /**
     * 设置 编号
     *
     * @param mytest_bianhao String
     */
    public void setMytest_bianhao(String mytest_bianhao) {
        this.mytest_bianhao=mytest_bianhao;
    }

    /**
     * 取得 编号
     *
     * @return String
     */
    public String getMytest_bianhao() {
        return this.mytest_bianhao;
    }
}