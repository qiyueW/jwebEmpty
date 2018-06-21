package wx.xt.bean;

import configuration.Tool;

@system.base.annotation.Table
public class XtQuanxian {

    @system.base.annotation.ID
    private String xt_quanxian_zj;// 主键
    private String xt_quanxian_fzj;// 父键 
    private Integer xt_quanxian_px;// 排序 
    private String xt_quanxian_mc;// 名称 
    private String xt_quanxian_dm;// 权限代码 
    private String xt_quanxian_url;// url 
    private Integer xt_quanxian_keshi;// 可视 
    private String xt_quanxian_zhankai;// 展开 
    private String xt_quanxian_bz;// 备注 
    private Integer xt_quanxian_zt;// 状态 
    private String xt_quanxian_gelibiaoshi;// 隔离标识 
    private Integer xt_quanxian_jibie;// 级别 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_quanxian_zj\":\"").append(xt_quanxian_zj).append("\"")
                .append(",\"xt_quanxian_fzj\":\"").append(xt_quanxian_fzj).append("\"")
                .append(",\"xt_quanxian_px\":\"").append(xt_quanxian_px).append("\"")
                .append(",\"xt_quanxian_mc\":\"").append(xt_quanxian_mc).append("\"")
                .append(",\"xt_quanxian_dm\":\"").append(xt_quanxian_dm).append("\"")
                .append(",\"xt_quanxian_url\":\"").append(xt_quanxian_url).append("\"")
                .append(",\"xt_quanxian_keshi\":\"").append(xt_quanxian_keshi).append("\"")
                .append(",\"xt_quanxian_zhankai\":\"").append(xt_quanxian_zhankai).append("\"")
                .append(",\"xt_quanxian_bz\":\"").append(xt_quanxian_bz).append("\"")
                .append(",\"xt_quanxian_zt\":\"").append(xt_quanxian_zt).append("\"")
                .append(",\"xt_quanxian_gelibiaoshi\":\"").append(xt_quanxian_gelibiaoshi).append("\"")
                .append(",\"xt_quanxian_jibie\":\"").append(xt_quanxian_jibie).append("\"}");
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_quanxian_zj String
     */
    public void setXt_quanxian_zj(String xt_quanxian_zj) {
        this.xt_quanxian_zj = xt_quanxian_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_quanxian_zj() {
        return this.xt_quanxian_zj;
    }

    /**
     * 设置 父键
     *
     * @param xt_quanxian_fzj String
     */
    public void setXt_quanxian_fzj(String xt_quanxian_fzj) {
        this.xt_quanxian_fzj = xt_quanxian_fzj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getXt_quanxian_fzj() {
        return this.xt_quanxian_fzj;
    }

    /**
     * 设置 排序
     *
     * @param xt_quanxian_px Integer
     */
    public void setXt_quanxian_px(Integer xt_quanxian_px) {
        this.xt_quanxian_px = xt_quanxian_px;
    }

    /**
     * 取得 排序
     *
     * @return Integer
     */
    public Integer getXt_quanxian_px() {
        return this.xt_quanxian_px;
    }

    /**
     * 设置 名称
     *
     * @param xt_quanxian_mc String
     */
    public void setXt_quanxian_mc(String xt_quanxian_mc) {
        this.xt_quanxian_mc = xt_quanxian_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getXt_quanxian_mc() {
        return this.xt_quanxian_mc;
    }

    /**
     * 设置 权限代码
     *
     * @param xt_quanxian_dm String
     */
    public void setXt_quanxian_dm(String xt_quanxian_dm) {
        this.xt_quanxian_dm = xt_quanxian_dm;
    }

    /**
     * 取得 权限代码
     *
     * @return String
     */
    public String getXt_quanxian_dm() {
        return this.xt_quanxian_dm;
    }

    /**
     * 设置 url
     *
     * @param xt_quanxian_url String
     */
    public void setXt_quanxian_url(String xt_quanxian_url) {
        this.xt_quanxian_url = xt_quanxian_url;
    }

    /**
     * 取得 url
     *
     * @return String
     */
    public String getXt_quanxian_url() {
        return this.xt_quanxian_url;
    }

    /**
     * 设置 可视
     *
     * @param xt_quanxian_keshi Integer
     */
    public void setXt_quanxian_keshi(Integer xt_quanxian_keshi) {
        this.xt_quanxian_keshi = xt_quanxian_keshi;
    }

    /**
     * 取得 可视
     *
     * @return Integer
     */
    public Integer getXt_quanxian_keshi() {
        return this.xt_quanxian_keshi;
    }

    /**
     * 设置 展开
     *
     * @param xt_quanxian_zhankai String
     */
    public void setXt_quanxian_zhankai(String xt_quanxian_zhankai) {
        this.xt_quanxian_zhankai = xt_quanxian_zhankai;
    }

    /**
     * 取得 展开
     *
     * @return String
     */
    public String getXt_quanxian_zhankai() {
        return this.xt_quanxian_zhankai;
    }

    /**
     * 设置 备注
     *
     * @param xt_quanxian_bz String
     */
    public void setXt_quanxian_bz(String xt_quanxian_bz) {
        this.xt_quanxian_bz = xt_quanxian_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getXt_quanxian_bz() {
        return this.xt_quanxian_bz;
    }

    /**
     * 设置 状态
     *
     * @param xt_quanxian_zt Integer
     */
    public void setXt_quanxian_zt(Integer xt_quanxian_zt) {
        this.xt_quanxian_zt = xt_quanxian_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getXt_quanxian_zt() {
        return this.xt_quanxian_zt;
    }

    /**
     * 设置 隔离标识
     *
     * @param xt_quanxian_gelibiaoshi String
     */
    public void setXt_quanxian_gelibiaoshi(String xt_quanxian_gelibiaoshi) {
        this.xt_quanxian_gelibiaoshi = xt_quanxian_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getXt_quanxian_gelibiaoshi() {
        return this.xt_quanxian_gelibiaoshi;
    }

    /**
     * 设置 级别
     *
     * @param xt_quanxian_jibie Integer
     */
    public void setXt_quanxian_jibie(Integer xt_quanxian_jibie) {
        this.xt_quanxian_jibie = xt_quanxian_jibie;
    }

    /**
     * 取得 级别
     *
     * @return Integer
     */
    public Integer getXt_quanxian_jibie() {
        return this.xt_quanxian_jibie;
    }
}
