package wx.web.bean;

@system.base.annotation.Table
public class Loufang2 {

    private  String loufang_zj ;// 父键 
    private  String loufang2_gelibiaoshi ;// 隔离标识 
    @system.base.annotation.ID
    private  String loufang2_zj ;// 主键
    private  String loufang2_bianhao ;// 编号 
    private  String loufang2_mingcheng ;// 名称 
    private  Integer loufang2_chuangwei ;// 床位 
    private  Integer loufang2_ruzhurenshu ;// 入住人数 
    private  String loufang2_ruzhuren_zj ;// 入住人主键集合 
    private  String loufang2_lx ;// 房间类型 
    private  String loufang2_bz ;// 备注 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"loufang_zj\":\"").append(loufang_zj).append("\"")
                .append(",\"loufang2_gelibiaoshi\":\"").append(loufang2_gelibiaoshi).append("\"")
                .append(",\"loufang2_zj\":\"").append(loufang2_zj).append("\"")
                .append(",\"loufang2_bianhao\":\"").append(loufang2_bianhao).append("\"")
                .append(",\"loufang2_mingcheng\":\"").append(loufang2_mingcheng).append("\"")
                .append(",\"loufang2_chuangwei\":\"").append(loufang2_chuangwei).append("\"")
                .append(",\"loufang2_ruzhurenshu\":\"").append(loufang2_ruzhurenshu).append("\"")
                .append(",\"loufang2_ruzhuren_zj\":\"").append(loufang2_ruzhuren_zj).append("\"")
                .append(",\"loufang2_lx\":\"").append(loufang2_lx).append("\"")
                .append(",\"loufang2_bz\":\"").append(loufang2_bz).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 父键
     *
     * @param loufang_zj String
     */
    public void setLoufang_zj(String loufang_zj) {
        this.loufang_zj=loufang_zj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getLoufang_zj() {
        return this.loufang_zj;
    }
    /**
     * 设置 隔离标识
     *
     * @param loufang2_gelibiaoshi String
     */
    public void setLoufang2_gelibiaoshi(String loufang2_gelibiaoshi) {
        this.loufang2_gelibiaoshi=loufang2_gelibiaoshi;
    }

    /**
     * 取得 隔离标识
     *
     * @return String
     */
    public String getLoufang2_gelibiaoshi() {
        return this.loufang2_gelibiaoshi;
    }
    /**
     * 设置 主键
     *
     * @param loufang2_zj String
     */
    public void setLoufang2_zj(String loufang2_zj) {
        this.loufang2_zj=loufang2_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getLoufang2_zj() {
        return this.loufang2_zj;
    }
    /**
     * 设置 编号
     *
     * @param loufang2_bianhao String
     */
    public void setLoufang2_bianhao(String loufang2_bianhao) {
        this.loufang2_bianhao=loufang2_bianhao;
    }

    /**
     * 取得 编号
     *
     * @return String
     */
    public String getLoufang2_bianhao() {
        return this.loufang2_bianhao;
    }
    /**
     * 设置 名称
     *
     * @param loufang2_mingcheng String
     */
    public void setLoufang2_mingcheng(String loufang2_mingcheng) {
        this.loufang2_mingcheng=loufang2_mingcheng;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getLoufang2_mingcheng() {
        return this.loufang2_mingcheng;
    }
    /**
     * 设置 床位
     *
     * @param loufang2_chuangwei Integer
     */
    public void setLoufang2_chuangwei(Integer loufang2_chuangwei) {
        this.loufang2_chuangwei=loufang2_chuangwei;
    }

    /**
     * 取得 床位
     *
     * @return Integer
     */
    public Integer getLoufang2_chuangwei() {
        return this.loufang2_chuangwei;
    }
    /**
     * 设置 入住人数
     *
     * @param loufang2_ruzhurenshu Integer
     */
    public void setLoufang2_ruzhurenshu(Integer loufang2_ruzhurenshu) {
        this.loufang2_ruzhurenshu=loufang2_ruzhurenshu;
    }

    /**
     * 取得 入住人数
     *
     * @return Integer
     */
    public Integer getLoufang2_ruzhurenshu() {
        return this.loufang2_ruzhurenshu;
    }
    /**
     * 设置 入住人主键集合
     *
     * @param loufang2_ruzhuren_zj String
     */
    public void setLoufang2_ruzhuren_zj(String loufang2_ruzhuren_zj) {
        this.loufang2_ruzhuren_zj=loufang2_ruzhuren_zj;
    }

    /**
     * 取得 入住人主键集合
     *
     * @return String
     */
    public String getLoufang2_ruzhuren_zj() {
        return this.loufang2_ruzhuren_zj;
    }
    /**
     * 设置 房间类型
     *
     * @param loufang2_lx String
     */
    public void setLoufang2_lx(String loufang2_lx) {
        this.loufang2_lx=loufang2_lx;
    }

    /**
     * 取得 房间类型
     *
     * @return String
     */
    public String getLoufang2_lx() {
        return this.loufang2_lx;
    }
    /**
     * 设置 备注
     *
     * @param loufang2_bz String
     */
    public void setLoufang2_bz(String loufang2_bz) {
        this.loufang2_bz=loufang2_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getLoufang2_bz() {
        return this.loufang2_bz;
    }
}