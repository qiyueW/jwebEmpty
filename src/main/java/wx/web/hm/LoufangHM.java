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
import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;
import wx.web.service.LoufangService;
import wx.xt.Gelibiaoshi;

/**
 * 1.添加请求路径：/base/loufang/save.jw <br>
 * 2.删除请求路径（传参：id）：/base/loufang/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/base/loufang/update.jw <br>
 * 3.2查询请求路径(通过表头主键id，请求表头数据)：/base/loufang/update/select.jw <br>
 * 3.3查询请求路径：/base/loufang/update/select/grid.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例。通过主键传参：id）：/base/loufang/select/selectOne.jw <br>
 * 4.2全部请求路径（分页查询-JSON格式）：/base/loufang/select/json.jw <br>
 * 4.3全部请求路径（分页查询-GRID格式）：/base/loufang/select/grid.jw <br>
 * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/base/loufang/select/selectOne/body.jw <br>
 * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/loufang/select/selectOne/bodyJSON.jw
 * <br>
 * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/loufang/select/selectOne/bodyGrid.jw
 * <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/base/loufang/update/examine.jw <br>
 * 5.2反审核请求路径 ：/base/loufang/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/base/loufang/update/void.jw <br>
 * 5.4反作废请求路径 ：/base/loufang/update/unvoid.jw <br>
 */
@H("/base/loufang")
public class LoufangHM {

    JWeb jw;

    public LoufangHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("loufangA")

    @M("/save")
    @Validate({wx.web.validate.LoufangValidate.class, wx.web.validate.Loufang2Validate.class})
    public void add() {
        Loufang obj = jw.getObject(Loufang.class);
        String glbs = Gelibiaoshi.getGelibiaoshi(jw);
        List<Loufang2> obj2 = (List<Loufang2>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        obj.setLoufang_gelibiaoshi(glbs);
        for(Loufang2 o2:obj2){
            o2.setLoufang2_gelibiaoshi(glbs);
        }
        jw.printOne(LoufangService.addOne(obj, obj2));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("loufangD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.dellVast(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("loufangU")

    @M("/update")
    @Validate({wx.web.validate.LoufangValidate.class, wx.web.validate.Loufang2Validate.class})
    public void update() {
        Loufang obj = jw.getObject(Loufang.class);
        if (null == obj || null == obj.getLoufang_zj() || obj.getLoufang_zj().length() != 24) {
            return;
        }
        String glbs = Gelibiaoshi.getGelibiaoshi(jw);
        if (LoufangService.isErrorGelibiaoshiOne(obj, glbs)) {//存在别人家的隔离标识的单据
            return;
        }
        List<Loufang2> obj2 = (List<Loufang2>) jw.request.getAttribute(WebConfigModel.JSONKEY);

        for (Loufang2 o2 : obj2) {
            o2.setLoufang_zj(obj.getLoufang_zj());//锁定表头主键
            o2.setLoufang2_gelibiaoshi(glbs);
        }
        jw.printOne(LoufangService.update(obj, obj2));
    }

    //@system.web.power.ann.SQ("loufangU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        Loufang obj = LoufangService.selectOne(id);
        if (null == obj.getLoufang_zj()) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("Loufang", obj);
        jw.forward("/admin/base/loufang/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    //@system.web.power.ann.SQ("loufangS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        Loufang obj = LoufangService.selectOne(id);
        if (null == obj.getLoufang_zj()) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("Loufang", obj);
        jw.forward("/admin/base/loufang/one.jsp");
    }

    //@system.web.power.ann.SQ("loufangS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufang_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(LoufangService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    //@system.web.power.ann.SQ("loufangS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufang_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                LoufangService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                LoufangService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        Loufang2 obj = LoufangService.selectOne2(id);
        if (null == obj.getLoufang_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    //@system.web.power.ann.SQ("loufangU")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(Tool.entityToJSON(LoufangService.select2(id)));
    }

    //@system.web.power.ann.SQ("loufangU")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (LoufangService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(EasyuiService.formatGrid(LoufangService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_examine(ids));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_unExamine(ids));
    }

    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_void(ids));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (LoufangService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangService.updateStyle_unVoid(ids));
    }

}
