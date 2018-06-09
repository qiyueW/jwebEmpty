package wx.web.bean;

import configuration.Tool;

@system.base.annotation.Table
public class DanjuZiduan {

    @system.base.annotation.ID
    private  String danjuziduan_zj ;// 主键
    private  String danju_zj ;// 表头id 
    private  String danjuziduan_mc ;// 字段名称 
    private  String danjuziduan_daima ;// 字段代码 
    private  String danjuziduan_leixing ;// 字段类型 
    private  Integer danjuziduan_xiaoshudian ;// 字段小数点 
    private  String danjuziduan_changdu ;// 字段长度 
    private  String danjuziduan_jiaonian ;// 是否必须校验 
    private  String danjuziduan_jiaoniankuizhi ;// 检验规则 
    private  String danjuziduan_bz ;// 备注 
    private  Integer danjuziduan_px ;// 排序 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"danjuziduan_zj\":\"").append(danjuziduan_zj).append("\"")
                .append(",\"danju_zj\":\"").append(danju_zj).append("\"")
                .append(",\"danjuziduan_mc\":\"").append(danjuziduan_mc).append("\"")
                .append(",\"danjuziduan_daima\":\"").append(danjuziduan_daima).append("\"")
                .append(",\"danjuziduan_leixing\":\"").append(danjuziduan_leixing).append("\"")
                .append(",\"danjuziduan_xiaoshudian\":\"").append(danjuziduan_xiaoshudian).append("\"")
                .append(",\"danjuziduan_changdu\":\"").append(danjuziduan_changdu).append("\"")
                .append(",\"danjuziduan_jiaonian\":\"").append(danjuziduan_jiaonian).append("\"")
                .append(",\"danjuziduan_jiaoniankuizhi\":\"").append(danjuziduan_jiaoniankuizhi).append("\"")
                .append(",\"danjuziduan_bz\":\"").append(danjuziduan_bz).append("\"")
                .append(",\"danjuziduan_px\":\"").append(danjuziduan_px).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param danjuziduan_zj String
     */
    public void setDanjuziduan_zj(String danjuziduan_zj) {
        this.danjuziduan_zj=danjuziduan_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getDanjuziduan_zj() {
        return this.danjuziduan_zj;
    }
    /**
     * 设置 表头id
     *
     * @param danju_zj String
     */
    public void setDanju_zj(String danju_zj) {
        this.danju_zj=danju_zj;
    }

    /**
     * 取得 表头id
     *
     * @return String
     */
    public String getDanju_zj() {
        return this.danju_zj;
    }
    /**
     * 设置 字段名称
     *
     * @param danjuziduan_mc String
     */
    public void setDanjuziduan_mc(String danjuziduan_mc) {
        this.danjuziduan_mc=danjuziduan_mc;
    }

    /**
     * 取得 字段名称
     *
     * @return String
     */
    public String getDanjuziduan_mc() {
        return this.danjuziduan_mc;
    }
    /**
     * 设置 字段代码
     *
     * @param danjuziduan_daima String
     */
    public void setDanjuziduan_daima(String danjuziduan_daima) {
        this.danjuziduan_daima=danjuziduan_daima;
    }

    /**
     * 取得 字段代码
     *
     * @return String
     */
    public String getDanjuziduan_daima() {
        return this.danjuziduan_daima;
    }
    /**
     * 设置 字段类型
     *
     * @param danjuziduan_leixing String
     */
    public void setDanjuziduan_leixing(String danjuziduan_leixing) {
        this.danjuziduan_leixing=danjuziduan_leixing;
    }

    /**
     * 取得 字段类型
     *
     * @return String
     */
    public String getDanjuziduan_leixing() {
        return this.danjuziduan_leixing;
    }
    /**
     * 设置 字段小数点
     *
     * @param danjuziduan_xiaoshudian Integer
     */
    public void setDanjuziduan_xiaoshudian(Integer danjuziduan_xiaoshudian) {
        this.danjuziduan_xiaoshudian=danjuziduan_xiaoshudian;
    }

    /**
     * 取得 字段小数点
     *
     * @return Integer
     */
    public Integer getDanjuziduan_xiaoshudian() {
        return this.danjuziduan_xiaoshudian;
    }
    /**
     * 设置 字段长度
     *
     * @param danjuziduan_changdu String
     */
    public void setDanjuziduan_changdu(String danjuziduan_changdu) {
        this.danjuziduan_changdu=danjuziduan_changdu;
    }

    /**
     * 取得 字段长度
     *
     * @return String
     */
    public String getDanjuziduan_changdu() {
        return this.danjuziduan_changdu;
    }
    /**
     * 设置 是否必须校验
     *
     * @param danjuziduan_jiaonian String
     */
    public void setDanjuziduan_jiaonian(String danjuziduan_jiaonian) {
        this.danjuziduan_jiaonian=danjuziduan_jiaonian;
    }

    /**
     * 取得 是否必须校验
     *
     * @return String
     */
    public String getDanjuziduan_jiaonian() {
        return this.danjuziduan_jiaonian;
    }
    /**
     * 设置 检验规则
     *
     * @param danjuziduan_jiaoniankuizhi String
     */
    public void setDanjuziduan_jiaoniankuizhi(String danjuziduan_jiaoniankuizhi) {
        this.danjuziduan_jiaoniankuizhi=danjuziduan_jiaoniankuizhi;
    }

    /**
     * 取得 检验规则
     *
     * @return String
     */
    public String getDanjuziduan_jiaoniankuizhi() {
        return this.danjuziduan_jiaoniankuizhi;
    }
    /**
     * 设置 备注
     *
     * @param danjuziduan_bz String
     */
    public void setDanjuziduan_bz(String danjuziduan_bz) {
        this.danjuziduan_bz=danjuziduan_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getDanjuziduan_bz() {
        return this.danjuziduan_bz;
    }
    /**
     * 设置 排序
     *
     * @param danjuziduan_px Integer
     */
    public void setDanjuziduan_px(Integer danjuziduan_px) {
        this.danjuziduan_px=danjuziduan_px;
    }

    /**
     * 取得 排序
     *
     * @return Integer
     */
    public Integer getDanjuziduan_px() {
        return this.danjuziduan_px;
    }
}