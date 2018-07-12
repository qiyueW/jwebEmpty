package  wx.xt.bean.xtguanliyuan;

import java.util.Date;

@system.base.annotation.Table
public class XtGuanliyuanHetong {

    @system.base.annotation.ID
    private  String xt_guanliyuanhetong_zj ;		// 管理员合同主键
    private  String xt_guanliyuan_zj ;					// 管理员主键
    private  String xt_guanliyuan_mc ;				// 管理员名称
    private  String xt_guanliyuan_gelibiaoshi ;	// 隔离标识 
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date xt_guanliyuan_tingyongriqi ;	// 停用日期
    @system.base.annotation.Time("yyyy-MM-dd")
    private  Date xt_guanliyuan_qingkongriqi ;	// 即使手工清空，也要在这个时间后。清空该总管所有资料日期
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private  Date xt_guanliyuan_zhidanshijian ;	// 制单时间
    
}