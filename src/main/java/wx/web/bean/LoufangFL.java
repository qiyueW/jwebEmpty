package wx.web.bean;

import configuration.Tool;

@system.base.annotation.Table
public class LoufangFL {

    private  Integer loufangfl_px ;// 排序 
    @system.base.annotation.ID
    private  String loufangfl_zj ;// 主键
    private  String loufangfl_fzj ;// 父主键 
    private  String loufangfl_mc ;// 名称 
    private  String loufangfl_bz ;// 备注 
    private  Integer loufangfl_zt ;// 状态 
    private  String loufangfl_gelibiaoshi ;// 隔离标识 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufangfl_px\":\"").append(loufangfl_px).append("\"")
                .append(",\"loufangfl_zj\":\"").append(loufangfl_zj).append("\"")
                .append(",\"loufangfl_fzj\":\"").append(loufangfl_fzj).append("\"")
                .append(",\"loufangfl_mc\":\"").append(loufangfl_mc).append("\"")
                .append(",\"loufangfl_bz\":\"").append(loufangfl_bz).append("\"")
                .append(",\"loufangfl_zt\":\"").append(loufangfl_zt).append("\"")
                .append(",\"loufangfl_gelibiaoshi\":\"").append(loufangfl_gelibiaoshi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 排序
     *
     * @param loufangfl_px Integer
     */
    public void setLoufangfl_px(Integer loufangfl_px) {
        this.loufangfl_px=loufangfl_px;
    }

    /**
     * 取得 排序
     *
     * @return Integer
     */
    public Integer getLoufangfl_px() {
        return this.loufangfl_px;
    }
    /**
     * 设置 主键
     *
     * @param loufangfl_zj String
     */
    public void setloufangfl_zj(String loufangfl_zj) {
        this.loufangfl_zj=loufangfl_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getloufangfl_zj() {
        return this.loufangfl_zj;
    }
    /**
     * 设置 父主键
     *
     * @param loufangfl_fzj String
     */
    public void setLoufangfl_fzj(String loufangfl_fzj) {
        this.loufangfl_fzj=loufangfl_fzj;
    }

    /**
     * 取得 父主键
     *
     * @return String
     */
    public String getLoufangfl_fzj() {
        return this.loufangfl_fzj;
    }
    /**
     * 设置 名称
     *
     * @param loufangfl_mc String
     */
    public void setLoufangfl_mc(String loufangfl_mc) {
        this.loufangfl_mc=loufangfl_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getLoufangfl_mc() {
        return this.loufangfl_mc;
    }
    /**
     * 设置 备注
     *
     * @param loufangfl_bz String
     */
    public void setLoufangfl_bz(String loufangfl_bz) {
        this.loufangfl_bz=loufangfl_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getLoufangfl_bz() {
        return this.loufangfl_bz;
    }
    /**
     * 设置 状态
     *
     * @param loufangfl_zt Integer
     */
    public void setLoufangfl_zt(Integer loufangfl_zt) {
        this.loufangfl_zt=loufangfl_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getLoufangfl_zt() {
        return this.loufangfl_zt;
    }
    /**
     * 设置 隔离标识
     *
     * @param loufangfl_gelibiaoshi String
     */
    public void setLoufangfl_gelibiaoshi(String loufangfl_gelibiaoshi) {
        this.loufangfl_gelibiaoshi=loufangfl_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getLoufangfl_gelibiaoshi() {
        return this.loufangfl_gelibiaoshi;
    }
}