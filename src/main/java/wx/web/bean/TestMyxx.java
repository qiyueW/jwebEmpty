package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class TestMyxx {

    private  String testmyxx_zj ;// 主键 
    private  String testmyxx_pid ;// 父键 
    private  String testmyxx_name ;// 名称 
    private  String testmyxx_name2 ;// 名称2 
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date testmyxx_zhidanshijian ;// 制单时间

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"testmyxx_zj\":\"").append(testmyxx_zj).append("\"")
                .append(",\"testmyxx_pid\":\"").append(testmyxx_pid).append("\"")
                .append(",\"testmyxx_name\":\"").append(testmyxx_name).append("\"")
                .append(",\"testmyxx_name2\":\"").append(testmyxx_name2).append("\"")
                .append(",\"testmyxx_zhidanshijian\":\"").append(Tool.dateToString(this.testmyxx_zhidanshijian, "yyyy-MM-dd HH:mm:ss")).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param testmyxx_zj String
     */
    public void setTestmyxx_zj(String testmyxx_zj) {
        this.testmyxx_zj=testmyxx_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getTestmyxx_zj() {
        return this.testmyxx_zj;
    }
    /**
     * 设置 父键
     *
     * @param testmyxx_pid String
     */
    public void setTestmyxx_pid(String testmyxx_pid) {
        this.testmyxx_pid=testmyxx_pid;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getTestmyxx_pid() {
        return this.testmyxx_pid;
    }
    /**
     * 设置 名称
     *
     * @param testmyxx_name String
     */
    public void setTestmyxx_name(String testmyxx_name) {
        this.testmyxx_name=testmyxx_name;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getTestmyxx_name() {
        return this.testmyxx_name;
    }
    /**
     * 设置 名称2
     *
     * @param testmyxx_name2 String
     */
    public void setTestmyxx_name2(String testmyxx_name2) {
        this.testmyxx_name2=testmyxx_name2;
    }

    /**
     * 取得 名称2
     *
     * @return String
     */
    public String getTestmyxx_name2() {
        return this.testmyxx_name2;
    }
    /**
     * 设置 制单时间
     *
     * @param testmyxx_zhidanshijian Date
     */
    public void setTestmyxx_zhidanshijian(Date testmyxx_zhidanshijian) {
        this.testmyxx_zhidanshijian=testmyxx_zhidanshijian;
    }

    /**
     * 取得 制单时间
     *
     * @return Date
     */
    public Date getTestmyxx_zhidanshijian() {
        return this.testmyxx_zhidanshijian;
    }
}