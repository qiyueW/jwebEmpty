package wx.web.bean;

import configuration.Tool;

@system.base.annotation.Table
public class LoufangXMF {

    @system.base.annotation.ID
    private  String loufangxmf_zj ;// 主键
    private  String loufangxmf_gelibiaoshi ;// 隔离标识 
    private  String loufangxmf_mc ;// 项目名称 
    private  Integer loufangxmf_feiyong ;// 项目费 
    private  Integer loufangxmf_zt ;// 状态 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufangxmf_zj\":\"").append(loufangxmf_zj).append("\"")
                .append(",\"loufangxmf_gelibiaoshi\":\"").append(loufangxmf_gelibiaoshi).append("\"")
                .append(",\"loufangxmf_mc\":\"").append(loufangxmf_mc).append("\"")
                .append(",\"loufangxmf_feiyong\":\"").append(loufangxmf_feiyong).append("\"")
                .append(",\"loufangxmf_zt\":\"").append(loufangxmf_zt).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param loufangxmf_zj String
     */
    public void setLoufangxmf_zj(String loufangxmf_zj) {
        this.loufangxmf_zj=loufangxmf_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getLoufangxmf_zj() {
        return this.loufangxmf_zj;
    }
    /**
     * 设置 隔离标识
     *
     * @param loufangxmf_gelibiaoshi String
     */
    public void setLoufangxmf_gelibiaoshi(String loufangxmf_gelibiaoshi) {
        this.loufangxmf_gelibiaoshi=loufangxmf_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getLoufangxmf_gelibiaoshi() {
        return this.loufangxmf_gelibiaoshi;
    }
    /**
     * 设置 项目名称
     *
     * @param loufangxmf_mc String
     */
    public void setLoufangxmf_mc(String loufangxmf_mc) {
        this.loufangxmf_mc=loufangxmf_mc;
    }

    /**
     * 取得 项目名称
     *
     * @return String
     */
    public String getLoufangxmf_mc() {
        return this.loufangxmf_mc;
    }
    /**
     * 设置 项目费
     *
     * @param loufangxmf_feiyong Integer
     */
    public void setLoufangxmf_feiyong(Integer loufangxmf_feiyong) {
        this.loufangxmf_feiyong=loufangxmf_feiyong;
    }

    /**
     * 取得 项目费
     *
     * @return Integer
     */
    public Integer getLoufangxmf_feiyong() {
        return this.loufangxmf_feiyong;
    }
    /**
     * 设置 状态
     *
     * @param loufangxmf_zt Integer
     */
    public void setLoufangxmf_zt(Integer loufangxmf_zt) {
        this.loufangxmf_zt=loufangxmf_zt;
    }

    /**
     * 取得 状态
     *
     * @return Integer
     */
    public Integer getLoufangxmf_zt() {
        return this.loufangxmf_zt;
    }
}