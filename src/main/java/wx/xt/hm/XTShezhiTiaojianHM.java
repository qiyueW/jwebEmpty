package wx.xt.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import java.util.List;
import configuration.WebConfigModel;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.xt.bean.xtshezhitiaojian.XTShezhiTiaojian;
import wx.xt.bean.xtshezhitiaojian.XTShezhiTiaojian1;
import wx.xt.service.XTShezhiTiaojianService;

/**
 * 1.添加请求路径：/xt/xtshezhitiaojian/save.jw <br>
 * 2.删除请求路径（传参：id）：/xt/xtshezhitiaojian/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/xt/xtshezhitiaojian/update.jw <br>
 * 3.2查询请求路径(通过表头主键id，请求表头数据)：/xt/xtshezhitiaojian/update/select.jw <br>
 * 3.3查询请求路径：/xt/xtshezhitiaojian/update/select/grid.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例。通过主键传参：id）：/xt/xtshezhitiaojian/select/selectOne.jw <br>
 * 4.2全部请求路径（JSON格式）：/xt/xtshezhitiaojian/select/json.jw <br>
 * 4.3全部请求路径（分页查询-GRID格式）：/xt/xtshezhitiaojian/select/grid.jw <br>
 * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/xt/xtshezhitiaojian/select/selectOne/body.jw
 * <br>
 * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xtshezhitiaojian/select/selectOne/bodyJSON.jw
 * <br>
 * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xtshezhitiaojian/select/selectOne/bodyGrid.jw
 * <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/xt/xtshezhitiaojian/update/examine.jw <br>
 * 5.2反审核请求路径 ：/xt/xtshezhitiaojian/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/xt/xtshezhitiaojian/update/void.jw <br>
 * 5.4反作废请求路径 ：/xt/xtshezhitiaojian/update/unvoid.jw <br>
 */
@H("/xt/xtshezhitiaojian")
public class XTShezhiTiaojianHM {

    JWeb jw;

    public XTShezhiTiaojianHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xtshezhitiaojianA")

    @M("/save")
    @Validate({wx.xt.validate.xtshezhitiaojian.XTShezhiTiaojianValidate.class, wx.xt.validate.xtshezhitiaojian.XTShezhiTiaojian1Validate.class})
    public void add() {
        XTShezhiTiaojian obj = jw.getObject(XTShezhiTiaojian.class);
        List<XTShezhiTiaojian1> obj2 = (List<XTShezhiTiaojian1>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        jw.printOne(XTShezhiTiaojianService.addOne(obj, obj2));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("xtshezhitiaojianD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        jw.printOne(XTShezhiTiaojianService.dellVast(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("xtshezhitiaojianU")

    @M("/update")
    @Validate({wx.xt.validate.xtshezhitiaojian.XTShezhiTiaojianValidate.class, wx.xt.validate.xtshezhitiaojian.XTShezhiTiaojian1Validate.class})
    public void update() {
        XTShezhiTiaojian obj = jw.getObject(XTShezhiTiaojian.class);
        List<XTShezhiTiaojian1> obj2 = (List<XTShezhiTiaojian1>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        for (XTShezhiTiaojian1 o2 : obj2) {
            o2.setXt_shezhi_tiaojian_zj(obj.getXt_shezhi_tiaojian_zj());//锁定表头主键
        }
        jw.printOne(XTShezhiTiaojianService.update(obj, obj2));
    }

    //@system.web.power.ann.SQ("xtshezhitiaojianU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XTShezhiTiaojian obj = XTShezhiTiaojianService.selectOne(id);
        if (null == obj.getXt_shezhi_tiaojian_zj()) {
            return;
        }
        jw.request.setAttribute("XTShezhiTiaojian", obj);
        jw.forward("/xt/xtshezhitiaojian/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    //@system.web.power.ann.SQ("xtshezhitiaojianS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        XTShezhiTiaojian obj = XTShezhiTiaojianService.selectOne(id);
        if (null == obj.getXt_shezhi_tiaojian_zj()) {
            return;
        }
        jw.request.setAttribute("XTShezhiTiaojian", obj);
        jw.forward("/xt/xtshezhitiaojian/one.jsp");
    }

    //@system.web.power.ann.SQ("xtshezhitiaojianS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        jw.printOne(Tool.entityToJSON(XTShezhiTiaojianService.select()));
    }
    //@system.web.power.ann.SQ("xtshezhitiaojianS")

    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = "";
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                XTShezhiTiaojianService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                XTShezhiTiaojianService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        XTShezhiTiaojian1 obj = XTShezhiTiaojianService.selectOne2(id);
        if (null == obj.getXt_shezhi_tiaojian_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    //@system.web.power.ann.SQ("xtshezhitiaojianU")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String key = jw.getString("key");
        if (null != key) {
            jw.printOne(Tool.entityToJSON(XTShezhiTiaojianService.select2ByHeadCode(key)));
        } else {
            String id = jw.getString("pid");
            jw.printOne(Tool.entityToJSON(XTShezhiTiaojianService.select2(id)));
        }
    }

    //@system.web.power.ann.SQ("xtshezhitiaojianU")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        jw.printOne(EasyuiService.formatGrid(XTShezhiTiaojianService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(XTShezhiTiaojianService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(XTShezhiTiaojianService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(XTShezhiTiaojianService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(XTShezhiTiaojianService.updateStyle_unVoid(jw.getString("ids")));
    }

}
