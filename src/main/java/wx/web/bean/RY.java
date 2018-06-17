package wx.web.bean;

import configuration.Tool;
import java.util.Date;

@system.base.annotation.Table
public class RY {

    @system.base.annotation.ID
    private  String ry_zj ;// 主键
    private  String ry_bm ;// 部门 
    private  String ry_bm_zj ;// 部门主键 
    private  String ry_mc ;// 人员名称 
    private  String ry_zhanghao ;// 账号 
    private  String ry_mima ;// 密码 
    private  String ry_xingbie ;// 性别 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date ry_ruzhiriqi ;// 入职日期
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date ry_chushengriqi ;// 出生日期
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date ry_lizhiriqi ;// 离职日期
    private  String ry_jiguan ;// 籍贯 
    private  String ry_shouji1 ;// 手机1 
    private  String ry_youxiang ;// 邮箱 
    private  String ry_hunyin ;// 婚姻状态 
    private  String ry_gangwei_zj ;// 岗位主键 
    private  String ry_gangwei ;// 岗位 
    private  String ry_zhiwei_zj ;// 职位主键 
    private  String ry_zhiwei ;// 职位 
    private  String ry_tupian ;// 图片 
    private  String ry_bz ;// 备注 
    private  String ry_shenfenzheng ;// 身份证号码 
    private  String ry_tupian_zhengjian1 ;// 证件图_正面 
    private  String ry_tupian_zhengjian2 ;// 证件图_反面 
    private  String ry_xianzhudizhi ;// 现住地址 
    private  String ry_jiatingdizhi ;// 家庭地址 
    private  String ry_jinjilianxiren ;// 紧急联系人 
    private  String ry_jinjilianxiren_dianhua ;// 紧急联系人电话 
    private  String ry_gudingdianhua1 ;// 固定电话1 
    private  String ry_gudingdianhua2 ;// 固定电话2 
    private  String ry_qitatongxing ;// 其他通信 
    private  String ry_qitatongxing1 ;// 其他通信1 
    private  String ry_qitatongxing2 ;// 其他通信2 
    private  String ry_qitatongxing3 ;// 其他通信3 
    private  String ry_qitatongxing4 ;// 其他通信4 
    private  String ry_qitatongxing5 ;// 其他通信5 
    private  String ry_neibutongxing1 ;// 内部通信1 
    private  String ry_neibutongxing2 ;// 内部通信2 
    private  String ry_neibutongxing3 ;// 内部通信3 
    private  String ry_neibutongxing4 ;// 内部通信4 
    private  String ry_neibutongxing5 ;// 内部通信5 
    private  String ry_neibutongxing6 ;// 内部通信6 
    private  String ry_neibutongxing7 ;// 内部通信7 
    private  String ry_neibutongxing8 ;// 内部通信8 
    private  String ry_neibutongxing9 ;// 内部通信9 
    private  String ry_neibutongxing10 ;// 内部通信10 
    private  String ry_zhidanren_zj ;// 制单人主键 
    private  String ry_zhidanren ;// 制单人 
    private  String ry_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"ry_zj\":\"").append(ry_zj).append("\"")
                .append(",\"ry_bm\":\"").append(ry_bm).append("\"")
                .append(",\"ry_bm_zj\":\"").append(ry_bm_zj).append("\"")
                .append(",\"ry_mc\":\"").append(ry_mc).append("\"")
                .append(",\"ry_zhanghao\":\"").append(ry_zhanghao).append("\"")
                .append(",\"ry_mima\":\"").append(ry_mima).append("\"")
                .append(",\"ry_xingbie\":\"").append(ry_xingbie).append("\"")
                .append(",\"ry_ruzhiriqi\":\"").append(Tool.dateToString(this.ry_ruzhiriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"ry_chushengriqi\":\"").append(Tool.dateToString(this.ry_chushengriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"ry_lizhiriqi\":\"").append(Tool.dateToString(this.ry_lizhiriqi, "yyyy-MM-dd")).append("\"")
                .append(",\"ry_jiguan\":\"").append(ry_jiguan).append("\"")
                .append(",\"ry_shouji1\":\"").append(ry_shouji1).append("\"")
                .append(",\"ry_youxiang\":\"").append(ry_youxiang).append("\"")
                .append(",\"ry_hunyin\":\"").append(ry_hunyin).append("\"")
                .append(",\"ry_gangwei_zj\":\"").append(ry_gangwei_zj).append("\"")
                .append(",\"ry_gangwei\":\"").append(ry_gangwei).append("\"")
                .append(",\"ry_zhiwei_zj\":\"").append(ry_zhiwei_zj).append("\"")
                .append(",\"ry_zhiwei\":\"").append(ry_zhiwei).append("\"")
                .append(",\"ry_tupian\":\"").append(ry_tupian).append("\"")
                .append(",\"ry_bz\":\"").append(ry_bz).append("\"")
                .append(",\"ry_shenfenzheng\":\"").append(ry_shenfenzheng).append("\"")
                .append(",\"ry_tupian_zhengjian1\":\"").append(ry_tupian_zhengjian1).append("\"")
                .append(",\"ry_tupian_zhengjian2\":\"").append(ry_tupian_zhengjian2).append("\"")
                .append(",\"ry_xianzhudizhi\":\"").append(ry_xianzhudizhi).append("\"")
                .append(",\"ry_jiatingdizhi\":\"").append(ry_jiatingdizhi).append("\"")
                .append(",\"ry_jinjilianxiren\":\"").append(ry_jinjilianxiren).append("\"")
                .append(",\"ry_jinjilianxiren_dianhua\":\"").append(ry_jinjilianxiren_dianhua).append("\"")
                .append(",\"ry_gudingdianhua1\":\"").append(ry_gudingdianhua1).append("\"")
                .append(",\"ry_gudingdianhua2\":\"").append(ry_gudingdianhua2).append("\"")
                .append(",\"ry_qitatongxing\":\"").append(ry_qitatongxing).append("\"")
                .append(",\"ry_qitatongxing1\":\"").append(ry_qitatongxing1).append("\"")
                .append(",\"ry_qitatongxing2\":\"").append(ry_qitatongxing2).append("\"")
                .append(",\"ry_qitatongxing3\":\"").append(ry_qitatongxing3).append("\"")
                .append(",\"ry_qitatongxing4\":\"").append(ry_qitatongxing4).append("\"")
                .append(",\"ry_qitatongxing5\":\"").append(ry_qitatongxing5).append("\"")
                .append(",\"ry_neibutongxing1\":\"").append(ry_neibutongxing1).append("\"")
                .append(",\"ry_neibutongxing2\":\"").append(ry_neibutongxing2).append("\"")
                .append(",\"ry_neibutongxing3\":\"").append(ry_neibutongxing3).append("\"")
                .append(",\"ry_neibutongxing4\":\"").append(ry_neibutongxing4).append("\"")
                .append(",\"ry_neibutongxing5\":\"").append(ry_neibutongxing5).append("\"")
                .append(",\"ry_neibutongxing6\":\"").append(ry_neibutongxing6).append("\"")
                .append(",\"ry_neibutongxing7\":\"").append(ry_neibutongxing7).append("\"")
                .append(",\"ry_neibutongxing8\":\"").append(ry_neibutongxing8).append("\"")
                .append(",\"ry_neibutongxing9\":\"").append(ry_neibutongxing9).append("\"")
                .append(",\"ry_neibutongxing10\":\"").append(ry_neibutongxing10).append("\"")
                .append(",\"ry_zhidanren_zj\":\"").append(ry_zhidanren_zj).append("\"")
                .append(",\"ry_zhidanren\":\"").append(ry_zhidanren).append("\"")
                .append(",\"ry_gelibiaoshi\":\"").append(ry_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param ry_zj String
     */
    public void setRy_zj(String ry_zj) {
        this.ry_zj=ry_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getRy_zj() {
        return this.ry_zj;
    }
    /**
     * 设置 部门
     *
     * @param ry_bm String
     */
    public void setRy_bm(String ry_bm) {
        this.ry_bm=ry_bm;
    }

    /**
     * 取得 部门
     *
     * @return String
     */
    public String getRy_bm() {
        return this.ry_bm;
    }
    /**
     * 设置 部门主键
     *
     * @param ry_bm_zj String
     */
    public void setRy_bm_zj(String ry_bm_zj) {
        this.ry_bm_zj=ry_bm_zj;
    }

    /**
     * 取得 部门主键
     *
     * @return String
     */
    public String getRy_bm_zj() {
        return this.ry_bm_zj;
    }
    /**
     * 设置 人员名称
     *
     * @param ry_mc String
     */
    public void setRy_mc(String ry_mc) {
        this.ry_mc=ry_mc;
    }

    /**
     * 取得 人员名称
     *
     * @return String
     */
    public String getRy_mc() {
        return this.ry_mc;
    }
    /**
     * 设置 账号
     *
     * @param ry_zhanghao String
     */
    public void setRy_zhanghao(String ry_zhanghao) {
        this.ry_zhanghao=ry_zhanghao;
    }

    /**
     * 取得 账号
     *
     * @return String
     */
    public String getRy_zhanghao() {
        return this.ry_zhanghao;
    }
    /**
     * 设置 密码
     *
     * @param ry_mima String
     */
    public void setRy_mima(String ry_mima) {
        this.ry_mima=ry_mima;
    }

    /**
     * 取得 密码
     *
     * @return String
     */
    public String getRy_mima() {
        return this.ry_mima;
    }
    /**
     * 设置 性别
     *
     * @param ry_xingbie String
     */
    public void setRy_xingbie(String ry_xingbie) {
        this.ry_xingbie=ry_xingbie;
    }

    /**
     * 取得 性别
     *
     * @return String
     */
    public String getRy_xingbie() {
        return this.ry_xingbie;
    }
    /**
     * 设置 入职日期
     *
     * @param ry_ruzhiriqi Date
     */
    public void setRy_ruzhiriqi(Date ry_ruzhiriqi) {
        this.ry_ruzhiriqi=ry_ruzhiriqi;
    }

    /**
     * 取得 入职日期
     *
     * @return Date
     */
    public Date getRy_ruzhiriqi() {
        return this.ry_ruzhiriqi;
    }
    /**
     * 设置 出生日期
     *
     * @param ry_chushengriqi Date
     */
    public void setRy_chushengriqi(Date ry_chushengriqi) {
        this.ry_chushengriqi=ry_chushengriqi;
    }

    /**
     * 取得 出生日期
     *
     * @return Date
     */
    public Date getRy_chushengriqi() {
        return this.ry_chushengriqi;
    }
    /**
     * 设置 离职日期
     *
     * @param ry_lizhiriqi Date
     */
    public void setRy_lizhiriqi(Date ry_lizhiriqi) {
        this.ry_lizhiriqi=ry_lizhiriqi;
    }

    /**
     * 取得 离职日期
     *
     * @return Date
     */
    public Date getRy_lizhiriqi() {
        return this.ry_lizhiriqi;
    }
    /**
     * 设置 籍贯
     *
     * @param ry_jiguan String
     */
    public void setRy_jiguan(String ry_jiguan) {
        this.ry_jiguan=ry_jiguan;
    }

    /**
     * 取得 籍贯
     *
     * @return String
     */
    public String getRy_jiguan() {
        return this.ry_jiguan;
    }
    /**
     * 设置 手机1
     *
     * @param ry_shouji1 String
     */
    public void setRy_shouji1(String ry_shouji1) {
        this.ry_shouji1=ry_shouji1;
    }

    /**
     * 取得 手机1
     *
     * @return String
     */
    public String getRy_shouji1() {
        return this.ry_shouji1;
    }
    /**
     * 设置 邮箱
     *
     * @param ry_youxiang String
     */
    public void setRy_youxiang(String ry_youxiang) {
        this.ry_youxiang=ry_youxiang;
    }

    /**
     * 取得 邮箱
     *
     * @return String
     */
    public String getRy_youxiang() {
        return this.ry_youxiang;
    }
    /**
     * 设置 婚姻状态
     *
     * @param ry_hunyin String
     */
    public void setRy_hunyin(String ry_hunyin) {
        this.ry_hunyin=ry_hunyin;
    }

    /**
     * 取得 婚姻状态
     *
     * @return String
     */
    public String getRy_hunyin() {
        return this.ry_hunyin;
    }
    /**
     * 设置 岗位主键
     *
     * @param ry_gangwei_zj String
     */
    public void setRy_gangwei_zj(String ry_gangwei_zj) {
        this.ry_gangwei_zj=ry_gangwei_zj;
    }

    /**
     * 取得 岗位主键
     *
     * @return String
     */
    public String getRy_gangwei_zj() {
        return this.ry_gangwei_zj;
    }
    /**
     * 设置 岗位
     *
     * @param ry_gangwei String
     */
    public void setRy_gangwei(String ry_gangwei) {
        this.ry_gangwei=ry_gangwei;
    }

    /**
     * 取得 岗位
     *
     * @return String
     */
    public String getRy_gangwei() {
        return this.ry_gangwei;
    }
    /**
     * 设置 职位主键
     *
     * @param ry_zhiwei_zj String
     */
    public void setRy_zhiwei_zj(String ry_zhiwei_zj) {
        this.ry_zhiwei_zj=ry_zhiwei_zj;
    }

    /**
     * 取得 职位主键
     *
     * @return String
     */
    public String getRy_zhiwei_zj() {
        return this.ry_zhiwei_zj;
    }
    /**
     * 设置 职位
     *
     * @param ry_zhiwei String
     */
    public void setRy_zhiwei(String ry_zhiwei) {
        this.ry_zhiwei=ry_zhiwei;
    }

    /**
     * 取得 职位
     *
     * @return String
     */
    public String getRy_zhiwei() {
        return this.ry_zhiwei;
    }
    /**
     * 设置 图片
     *
     * @param ry_tupian String
     */
    public void setRy_tupian(String ry_tupian) {
        this.ry_tupian=ry_tupian;
    }

    /**
     * 取得 图片
     *
     * @return String
     */
    public String getRy_tupian() {
        return this.ry_tupian;
    }
    /**
     * 设置 备注
     *
     * @param ry_bz String
     */
    public void setRy_bz(String ry_bz) {
        this.ry_bz=ry_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getRy_bz() {
        return this.ry_bz;
    }
    /**
     * 设置 身份证号码
     *
     * @param ry_shenfenzheng String
     */
    public void setRy_shenfenzheng(String ry_shenfenzheng) {
        this.ry_shenfenzheng=ry_shenfenzheng;
    }

    /**
     * 取得 身份证号码
     *
     * @return String
     */
    public String getRy_shenfenzheng() {
        return this.ry_shenfenzheng;
    }
    /**
     * 设置 证件图_正面
     *
     * @param ry_tupian_zhengjian1 String
     */
    public void setRy_tupian_zhengjian1(String ry_tupian_zhengjian1) {
        this.ry_tupian_zhengjian1=ry_tupian_zhengjian1;
    }

    /**
     * 取得 证件图_正面
     *
     * @return String
     */
    public String getRy_tupian_zhengjian1() {
        return this.ry_tupian_zhengjian1;
    }
    /**
     * 设置 证件图_反面
     *
     * @param ry_tupian_zhengjian2 String
     */
    public void setRy_tupian_zhengjian2(String ry_tupian_zhengjian2) {
        this.ry_tupian_zhengjian2=ry_tupian_zhengjian2;
    }

    /**
     * 取得 证件图_反面
     *
     * @return String
     */
    public String getRy_tupian_zhengjian2() {
        return this.ry_tupian_zhengjian2;
    }
    /**
     * 设置 现住地址
     *
     * @param ry_xianzhudizhi String
     */
    public void setRy_xianzhudizhi(String ry_xianzhudizhi) {
        this.ry_xianzhudizhi=ry_xianzhudizhi;
    }

    /**
     * 取得 现住地址
     *
     * @return String
     */
    public String getRy_xianzhudizhi() {
        return this.ry_xianzhudizhi;
    }
    /**
     * 设置 家庭地址
     *
     * @param ry_jiatingdizhi String
     */
    public void setRy_jiatingdizhi(String ry_jiatingdizhi) {
        this.ry_jiatingdizhi=ry_jiatingdizhi;
    }

    /**
     * 取得 家庭地址
     *
     * @return String
     */
    public String getRy_jiatingdizhi() {
        return this.ry_jiatingdizhi;
    }
    /**
     * 设置 紧急联系人
     *
     * @param ry_jinjilianxiren String
     */
    public void setRy_jinjilianxiren(String ry_jinjilianxiren) {
        this.ry_jinjilianxiren=ry_jinjilianxiren;
    }

    /**
     * 取得 紧急联系人
     *
     * @return String
     */
    public String getRy_jinjilianxiren() {
        return this.ry_jinjilianxiren;
    }
    /**
     * 设置 紧急联系人电话
     *
     * @param ry_jinjilianxiren_dianhua String
     */
    public void setRy_jinjilianxiren_dianhua(String ry_jinjilianxiren_dianhua) {
        this.ry_jinjilianxiren_dianhua=ry_jinjilianxiren_dianhua;
    }

    /**
     * 取得 紧急联系人电话
     *
     * @return String
     */
    public String getRy_jinjilianxiren_dianhua() {
        return this.ry_jinjilianxiren_dianhua;
    }
    /**
     * 设置 固定电话1
     *
     * @param ry_gudingdianhua1 String
     */
    public void setRy_gudingdianhua1(String ry_gudingdianhua1) {
        this.ry_gudingdianhua1=ry_gudingdianhua1;
    }

    /**
     * 取得 固定电话1
     *
     * @return String
     */
    public String getRy_gudingdianhua1() {
        return this.ry_gudingdianhua1;
    }
    /**
     * 设置 固定电话2
     *
     * @param ry_gudingdianhua2 String
     */
    public void setRy_gudingdianhua2(String ry_gudingdianhua2) {
        this.ry_gudingdianhua2=ry_gudingdianhua2;
    }

    /**
     * 取得 固定电话2
     *
     * @return String
     */
    public String getRy_gudingdianhua2() {
        return this.ry_gudingdianhua2;
    }
    /**
     * 设置 其他通信
     *
     * @param ry_qitatongxing String
     */
    public void setRy_qitatongxing(String ry_qitatongxing) {
        this.ry_qitatongxing=ry_qitatongxing;
    }

    /**
     * 取得 其他通信
     *
     * @return String
     */
    public String getRy_qitatongxing() {
        return this.ry_qitatongxing;
    }
    /**
     * 设置 其他通信1
     *
     * @param ry_qitatongxing1 String
     */
    public void setRy_qitatongxing1(String ry_qitatongxing1) {
        this.ry_qitatongxing1=ry_qitatongxing1;
    }

    /**
     * 取得 其他通信1
     *
     * @return String
     */
    public String getRy_qitatongxing1() {
        return this.ry_qitatongxing1;
    }
    /**
     * 设置 其他通信2
     *
     * @param ry_qitatongxing2 String
     */
    public void setRy_qitatongxing2(String ry_qitatongxing2) {
        this.ry_qitatongxing2=ry_qitatongxing2;
    }

    /**
     * 取得 其他通信2
     *
     * @return String
     */
    public String getRy_qitatongxing2() {
        return this.ry_qitatongxing2;
    }
    /**
     * 设置 其他通信3
     *
     * @param ry_qitatongxing3 String
     */
    public void setRy_qitatongxing3(String ry_qitatongxing3) {
        this.ry_qitatongxing3=ry_qitatongxing3;
    }

    /**
     * 取得 其他通信3
     *
     * @return String
     */
    public String getRy_qitatongxing3() {
        return this.ry_qitatongxing3;
    }
    /**
     * 设置 其他通信4
     *
     * @param ry_qitatongxing4 String
     */
    public void setRy_qitatongxing4(String ry_qitatongxing4) {
        this.ry_qitatongxing4=ry_qitatongxing4;
    }

    /**
     * 取得 其他通信4
     *
     * @return String
     */
    public String getRy_qitatongxing4() {
        return this.ry_qitatongxing4;
    }
    /**
     * 设置 其他通信5
     *
     * @param ry_qitatongxing5 String
     */
    public void setRy_qitatongxing5(String ry_qitatongxing5) {
        this.ry_qitatongxing5=ry_qitatongxing5;
    }

    /**
     * 取得 其他通信5
     *
     * @return String
     */
    public String getRy_qitatongxing5() {
        return this.ry_qitatongxing5;
    }
    /**
     * 设置 内部通信1
     *
     * @param ry_neibutongxing1 String
     */
    public void setRy_neibutongxing1(String ry_neibutongxing1) {
        this.ry_neibutongxing1=ry_neibutongxing1;
    }

    /**
     * 取得 内部通信1
     *
     * @return String
     */
    public String getRy_neibutongxing1() {
        return this.ry_neibutongxing1;
    }
    /**
     * 设置 内部通信2
     *
     * @param ry_neibutongxing2 String
     */
    public void setRy_neibutongxing2(String ry_neibutongxing2) {
        this.ry_neibutongxing2=ry_neibutongxing2;
    }

    /**
     * 取得 内部通信2
     *
     * @return String
     */
    public String getRy_neibutongxing2() {
        return this.ry_neibutongxing2;
    }
    /**
     * 设置 内部通信3
     *
     * @param ry_neibutongxing3 String
     */
    public void setRy_neibutongxing3(String ry_neibutongxing3) {
        this.ry_neibutongxing3=ry_neibutongxing3;
    }

    /**
     * 取得 内部通信3
     *
     * @return String
     */
    public String getRy_neibutongxing3() {
        return this.ry_neibutongxing3;
    }
    /**
     * 设置 内部通信4
     *
     * @param ry_neibutongxing4 String
     */
    public void setRy_neibutongxing4(String ry_neibutongxing4) {
        this.ry_neibutongxing4=ry_neibutongxing4;
    }

    /**
     * 取得 内部通信4
     *
     * @return String
     */
    public String getRy_neibutongxing4() {
        return this.ry_neibutongxing4;
    }
    /**
     * 设置 内部通信5
     *
     * @param ry_neibutongxing5 String
     */
    public void setRy_neibutongxing5(String ry_neibutongxing5) {
        this.ry_neibutongxing5=ry_neibutongxing5;
    }

    /**
     * 取得 内部通信5
     *
     * @return String
     */
    public String getRy_neibutongxing5() {
        return this.ry_neibutongxing5;
    }
    /**
     * 设置 内部通信6
     *
     * @param ry_neibutongxing6 String
     */
    public void setRy_neibutongxing6(String ry_neibutongxing6) {
        this.ry_neibutongxing6=ry_neibutongxing6;
    }

    /**
     * 取得 内部通信6
     *
     * @return String
     */
    public String getRy_neibutongxing6() {
        return this.ry_neibutongxing6;
    }
    /**
     * 设置 内部通信7
     *
     * @param ry_neibutongxing7 String
     */
    public void setRy_neibutongxing7(String ry_neibutongxing7) {
        this.ry_neibutongxing7=ry_neibutongxing7;
    }

    /**
     * 取得 内部通信7
     *
     * @return String
     */
    public String getRy_neibutongxing7() {
        return this.ry_neibutongxing7;
    }
    /**
     * 设置 内部通信8
     *
     * @param ry_neibutongxing8 String
     */
    public void setRy_neibutongxing8(String ry_neibutongxing8) {
        this.ry_neibutongxing8=ry_neibutongxing8;
    }

    /**
     * 取得 内部通信8
     *
     * @return String
     */
    public String getRy_neibutongxing8() {
        return this.ry_neibutongxing8;
    }
    /**
     * 设置 内部通信9
     *
     * @param ry_neibutongxing9 String
     */
    public void setRy_neibutongxing9(String ry_neibutongxing9) {
        this.ry_neibutongxing9=ry_neibutongxing9;
    }

    /**
     * 取得 内部通信9
     *
     * @return String
     */
    public String getRy_neibutongxing9() {
        return this.ry_neibutongxing9;
    }
    /**
     * 设置 内部通信10
     *
     * @param ry_neibutongxing10 String
     */
    public void setRy_neibutongxing10(String ry_neibutongxing10) {
        this.ry_neibutongxing10=ry_neibutongxing10;
    }

    /**
     * 取得 内部通信10
     *
     * @return String
     */
    public String getRy_neibutongxing10() {
        return this.ry_neibutongxing10;
    }
    /**
     * 设置 制单人主键
     *
     * @param ry_zhidanren_zj String
     */
    public void setRy_zhidanren_zj(String ry_zhidanren_zj) {
        this.ry_zhidanren_zj=ry_zhidanren_zj;
    }

    /**
     * 取得 制单人主键
     *
     * @return String
     */
    public String getRy_zhidanren_zj() {
        return this.ry_zhidanren_zj;
    }
    /**
     * 设置 制单人
     *
     * @param ry_zhidanren String
     */
    public void setRy_zhidanren(String ry_zhidanren) {
        this.ry_zhidanren=ry_zhidanren;
    }

    /**
     * 取得 制单人
     *
     * @return String
     */
    public String getRy_zhidanren() {
        return this.ry_zhidanren;
    }
    /**
     * 设置 隔离标识
     *
     * @param ry_gelibiaoshi String
     */
    public void setRy_gelibiaoshi(String ry_gelibiaoshi) {
        this.ry_gelibiaoshi=ry_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getRy_gelibiaoshi() {
        return this.ry_gelibiaoshi;
    }
}