//package wx.xt.hm.xtguanliyuan;
//
//import wx.xt.hm.*;
//import configuration.Page;
//import system.base.annotation.H;
//import system.base.annotation.M;
//import system.base.annotation.Validate;
//import system.web.JWeb;
//import configuration.Tool;
//import plugins.easyui.EasyuiService;
//import wx.xt.bean.XtGuanliyuan;
//import wx.xt.service.XtGuanliyuanService;
//
///**
// * 1.添加请求路径：/xt/xtguanliyuan/save.jw <br>
// * 2.删除请求路径（传参：id）：/xt/xtguanliyuan/remove.jw <br>
// * 3.修改 <br>
// * 3.1变更请求路径：/xt/xtguanliyuan/update.jw <br>
// * 3.2查询请求路径(通过表头主键id，请求表头数据)：/xt/xtguanliyuan/update/select.jw <br>
// * 3.3查询请求路径：/xt/xtguanliyuan/update/select/grid.jw <br>
// * 4.查询 <br>
// * 4.1全部请求路径（对象实例。通过主键传参：id）：/xt/xtguanliyuan/select/selectOne.jw <br>
// * 4.2全部请求路径（分页查询-JSON格式）：/xt/xtguanliyuan/select/json.jw <br>
// * 4.3全部请求路径（分页查询-GRID格式）：/xt/xtguanliyuan/select/grid.jw <br>
// * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/xt/xtguanliyuan/select/selectOne/body.jw <br>
// * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xtguanliyuan/select/selectOne/bodyJSON.jw
// * <br>
// * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xtguanliyuan/select/selectOne/bodyGrid.jw
// * <br>
// * 5.单据状态管理 <br>
// * 5.1审核请求路径 ：/xt/xtguanliyuan/update/examine.jw <br>
// * 5.2反审核请求路径 ：/xt/xtguanliyuan/update/unexamine.jw <br>
// * 5.3作废请求路径 ：/xt/xtguanliyuan/update/void.jw <br>
// * 5.4反作废请求路径 ：/xt/xtguanliyuan/update/unvoid.jw <br>
// * 管理员专用通道
// */
//@H("/xt/xtguanliyuan3")
//public class XtGuanliyuanHM3 {
//
//    JWeb jw;
//
//    public XtGuanliyuanHM3(JWeb jw) {
//        this.jw = jw;
//    }
// 
////===================查询操作=============================
//    //=========表头查询操作===========
//
//    //@system.web.power.ann.SQ("xtguanliyuanS") 
//    @M("/select/selectOne")//针对表头的查询-一条记录的明细
//    public void selectOne() {
//        String id = jw.getString("id");
//        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
//        if (null == obj.getXt_guanliyuan_zj()) {
//            return;
//        }
//        jw.request.setAttribute("XtGuanliyuan", obj);
//        jw.forward("/xt/xtguanliyuan/one.jsp");
//    }
//    //@system.web.power.ann.SQ("xtguanliyuanS") 
//    @M("/select/selectOne/json")//查询权限
//    public void selectOneByJson() {
//        String id = jw.getString("id");
//        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
//        if (null == obj.getXt_guanliyuan_zj()) {
//            return;
//        }
//        jw.printOne(obj.toString());
//    }
//}
