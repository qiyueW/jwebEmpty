package wx.xt.bean.xttiaojian;

@system.base.annotation.Table
public class XTTiaojian1 {

    @system.base.annotation.ID
    private  String xt_tiaojian1_zj ;// 主键
    private  String xt_tiaojian_zj ;// 表头主键 
    private  String xt_tiaojian1_kuohao ;// 括号区 
    private  String xt_tiaojian1_lianjiefu ;// 接连符 
    private  String xt_tiaojian1_lianjiefu_mc ;// 接连符展示名 
    private  String xt_shezhi_tiaojian1_mc ;// 条件区展示名 
    private  String xt_shezhi_tiaojian1_zhi ;// 条件区值 
    private  String xt_tiaojian1_panduan ;// 判断区 
    private  String xt_tiaojian1_panduan_mc ;// 判断区展示名 
    private  String xt_tiaojian1_zhi ;// 条件值 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"xt_tiaojian1_zj\":\"").append(xt_tiaojian1_zj).append("\"")
                .append(",\"xt_tiaojian_zj\":\"").append(xt_tiaojian_zj).append("\"")
                .append(",\"xt_tiaojian1_kuohao\":\"").append(xt_tiaojian1_kuohao).append("\"")
                .append(",\"xt_tiaojian1_lianjiefu\":\"").append(xt_tiaojian1_lianjiefu).append("\"")
                .append(",\"xt_tiaojian1_lianjiefu_mc\":\"").append(xt_tiaojian1_lianjiefu_mc).append("\"")
                .append(",\"xt_shezhi_tiaojian1_mc\":\"").append(xt_shezhi_tiaojian1_mc).append("\"")
                .append(",\"xt_shezhi_tiaojian1_zhi\":\"").append(xt_shezhi_tiaojian1_zhi).append("\"")
                .append(",\"xt_tiaojian1_panduan\":\"").append(xt_tiaojian1_panduan).append("\"")
                .append(",\"xt_tiaojian1_panduan_mc\":\"").append(xt_tiaojian1_panduan_mc).append("\"")
                .append(",\"xt_tiaojian1_zhi\":\"").append(xt_tiaojian1_zhi).append("\"}")
                ;
        return sb.toString();
    }

    /**
     * 设置 主键
     *
     * @param xt_tiaojian1_zj String
     */
    public void setXt_tiaojian1_zj(String xt_tiaojian1_zj) {
        this.xt_tiaojian1_zj=xt_tiaojian1_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getXt_tiaojian1_zj() {
        return this.xt_tiaojian1_zj;
    }
    /**
     * 设置 表头主键
     *
     * @param xt_tiaojian_zj String
     */
    public void setXt_tiaojian_zj(String xt_tiaojian_zj) {
        this.xt_tiaojian_zj=xt_tiaojian_zj;
    }

    /**
     * 取得 表头主键
     *
     * @return String
     */
    public String getXt_tiaojian_zj() {
        return this.xt_tiaojian_zj;
    }
    /**
     * 设置 括号区
     *
     * @param xt_tiaojian1_kuohao String
     */
    public void setXt_tiaojian1_kuohao(String xt_tiaojian1_kuohao) {
        this.xt_tiaojian1_kuohao=xt_tiaojian1_kuohao;
    }

    /**
     * 取得 括号区
     *
     * @return String
     */
    public String getXt_tiaojian1_kuohao() {
        return this.xt_tiaojian1_kuohao;
    }
    /**
     * 设置 接连符
     *
     * @param xt_tiaojian1_lianjiefu String
     */
    public void setXt_tiaojian1_lianjiefu(String xt_tiaojian1_lianjiefu) {
        this.xt_tiaojian1_lianjiefu=xt_tiaojian1_lianjiefu;
    }

    /**
     * 取得 接连符
     *
     * @return String
     */
    public String getXt_tiaojian1_lianjiefu() {
        return this.xt_tiaojian1_lianjiefu;
    }
    /**
     * 设置 接连符展示名
     *
     * @param xt_tiaojian1_lianjiefu_mc String
     */
    public void setXt_tiaojian1_lianjiefu_mc(String xt_tiaojian1_lianjiefu_mc) {
        this.xt_tiaojian1_lianjiefu_mc=xt_tiaojian1_lianjiefu_mc;
    }

    /**
     * 取得 接连符展示名
     *
     * @return String
     */
    public String getXt_tiaojian1_lianjiefu_mc() {
        return this.xt_tiaojian1_lianjiefu_mc;
    }
    /**
     * 设置 条件区展示名
     *
     * @param xt_shezhi_tiaojian1_mc String
     */
    public void setXt_shezhi_tiaojian1_mc(String xt_shezhi_tiaojian1_mc) {
        this.xt_shezhi_tiaojian1_mc=xt_shezhi_tiaojian1_mc;
    }

    /**
     * 取得 条件区展示名
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian1_mc() {
        return this.xt_shezhi_tiaojian1_mc;
    }
    /**
     * 设置 条件区值
     *
     * @param xt_shezhi_tiaojian1_zhi String
     */
    public void setXt_shezhi_tiaojian1_zhi(String xt_shezhi_tiaojian1_zhi) {
        this.xt_shezhi_tiaojian1_zhi=xt_shezhi_tiaojian1_zhi;
    }

    /**
     * 取得 条件区值
     *
     * @return String
     */
    public String getXt_shezhi_tiaojian1_zhi() {
        return this.xt_shezhi_tiaojian1_zhi;
    }
    /**
     * 设置 判断区
     *
     * @param xt_tiaojian1_panduan String
     */
    public void setXt_tiaojian1_panduan(String xt_tiaojian1_panduan) {
        this.xt_tiaojian1_panduan=xt_tiaojian1_panduan;
    }

    /**
     * 取得 判断区
     *
     * @return String
     */
    public String getXt_tiaojian1_panduan() {
        return this.xt_tiaojian1_panduan;
    }
    /**
     * 设置 判断区展示名
     *
     * @param xt_tiaojian1_panduan_mc String
     */
    public void setXt_tiaojian1_panduan_mc(String xt_tiaojian1_panduan_mc) {
        this.xt_tiaojian1_panduan_mc=xt_tiaojian1_panduan_mc;
    }

    /**
     * 取得 判断区展示名
     *
     * @return String
     */
    public String getXt_tiaojian1_panduan_mc() {
        return this.xt_tiaojian1_panduan_mc;
    }
    /**
     * 设置 条件值
     *
     * @param xt_tiaojian1_zhi String
     */
    public void setXt_tiaojian1_zhi(String xt_tiaojian1_zhi) {
        this.xt_tiaojian1_zhi=xt_tiaojian1_zhi;
    }

    /**
     * 取得 条件值
     *
     * @return String
     */
    public String getXt_tiaojian1_zhi() {
        return this.xt_tiaojian1_zhi;
    }
}