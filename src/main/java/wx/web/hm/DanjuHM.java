package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.MsgVO;
import java.util.List;
import configuration.WebConfigModel;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import java.util.Date;
import wx.web.bean.Danju;
import wx.web.bean.DanjuZiduan;
import wx.web.service.DanjuService;

/**
 * 1.添加请求路径：/base/danju/save.jw <br>
 * 2.删除请求路径（传参：id）：/base/danju/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/base/danju/update.jw <br>
 * 3.2查询请求路径(通过表头主键id，请求表头数据)：/base/danju/update/select.jw <br>
 * 3.3查询请求路径：/base/danju/update/select/grid.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例。通过主键传参：id）：/base/danju/select/selectOne.jw <br>
 * 4.2全部请求路径（分页查询-JSON格式）：/base/danju/select/json.jw <br>
 * 4.3全部请求路径（分页查询-GRID格式）：/base/danju/select/grid.jw <br>
 * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/base/danju/select/selectOne/body.jw <br>
 * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/danju/select/selectOne/bodyJSON.jw
 * <br>
 * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/danju/select/selectOne/bodyGrid.jw
 * <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/base/danju/update/examine.jw <br>
 * 5.2反审核请求路径 ：/base/danju/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/base/danju/update/void.jw <br>
 * 5.4反作废请求路径 ：/base/danju/update/unvoid.jw <br>
 */
@H("/base/danju")
public class DanjuHM {

    JWeb jw;

    public DanjuHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("BA")

    @M("/save")
    @Validate({wx.web.validate.DanjuValidate.class, wx.web.validate.DanjuZiduanValidate.class})
    public void add() {
        Danju obj = jw.getObject(Danju.class);
        List<DanjuZiduan> obj2 = (List<DanjuZiduan>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        jw.printOne(DanjuService.addOne(obj, obj2));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("BD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        jw.printOne(DanjuService.dellVast(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("BU")

    @M("/update")
    @Validate({wx.web.validate.DanjuValidate.class, wx.web.validate.DanjuZiduanValidate.class})
    public void update() {
        Danju obj = jw.getObject(Danju.class);
        System.out.println(obj);
        List<DanjuZiduan> obj2 = (List<DanjuZiduan>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        for (DanjuZiduan o2 : obj2) {
            o2.setDanju_zj(obj.getDanju_zj());//锁定表头主键
        }
        jw.printOne(DanjuService.update(obj, obj2));
    }

    //@system.web.power.ann.SQ("BU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        Danju obj = DanjuService.selectOne(id);
        if (null == obj.getDanju_zj()) {
            return;
        }
        jw.request.setAttribute("Danju", obj);
        jw.forward("/admin/base/danju/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    //@system.web.power.ann.SQ("BS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        Danju obj = DanjuService.selectOne(id);
        if (null == obj.getDanju_zj()) {
            return;
        }
        jw.request.setAttribute("Danju", obj);
        jw.forward("/admin/base/danju/one.jsp");
    }

    //@system.web.power.ann.SQ("BS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = "";
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(DanjuService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }
    //@system.web.power.ann.SQ("BS")

    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = "";
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                DanjuService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                DanjuService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        DanjuZiduan obj = DanjuService.selectOne2(id);
        if (null == obj.getDanju_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    //@system.web.power.ann.SQ("BU")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        jw.printOne(Tool.entityToJSON(DanjuService.select2(id)));
    }

    //@system.web.power.ann.SQ("BU")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        jw.printOne(EasyuiService.formatGrid(DanjuService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(DanjuService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(DanjuService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(DanjuService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(DanjuService.updateStyle_unVoid(jw.getString("ids")));
    }

}
