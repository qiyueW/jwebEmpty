package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.web.bean.BM;
import wx.web.bean.Gangwei;
import wx.web.bean.RY;
import wx.web.bean.Zhiwei;
import wx.web.service.BMService;
import wx.web.service.GangweiService;
import wx.web.service.RYService;
import wx.web.service.ZhiweiService;
import wx.xt.Gelibiaoshi;

/**
 * 1.添加请求路径：/base/ry/save.jw <br>
 * 2.删除请求路径（传参：id）：/base/ry/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/base/ry/update.jw <br>
 * 3.2查询请求路径(通过表头主键id，请求表头数据)：/base/ry/update/select.jw <br>
 * 3.3查询请求路径：/base/ry/update/select/grid.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例。通过主键传参：id）：/base/ry/select/selectOne.jw <br>
 * 4.2全部请求路径（分页查询-JSON格式）：/base/ry/select/json.jw <br>
 * 4.3全部请求路径（分页查询-GRID格式）：/base/ry/select/grid.jw <br>
 * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/base/ry/select/selectOne/body.jw <br>
 * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/ry/select/selectOne/bodyJSON.jw
 * <br>
 * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/ry/select/selectOne/bodyGrid.jw
 * <br>
 * 6.上传管理 <br>
 * 6.2文件上传请求路径 ：/base/ry/up/file.jw <br>
 */
@H("/base/ry")
public class RYHM {

    JWeb jw;

    public RYHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("BA")

    @M("/save")
    @Validate(wx.web.validate.RYValidate.class)
    public void add() {
        RY obj = jw.getObject(RY.class);
        obj.setRy_gelibiaoshi(Gelibiaoshi.getGelibiaoshi(jw));
        if (iniRYError(obj)) {
            return;
        }
        jw.printOne(RYService.addOne(obj));
    }

    private static boolean iniRYError(final RY obj) {
        BM bm = BMService.selectOne(obj.getRy_bm_zj());
        if (null == bm || null == bm.getBm_zj()) {
            return true;
        }
        if (null != obj.getRy_zhiwei_zj() && obj.getRy_zhiwei_zj().length() == 24) {
            Zhiwei zw = ZhiweiService.selectOne(obj.getRy_zhiwei_zj());
            obj.setRy_zhiwei(zw.getZhiwei_mc());
        }
        if (null != obj.getRy_gangwei_zj() && obj.getRy_gangwei_zj().length() == 24) {
            Gangwei gw = GangweiService.selectOne(obj.getRy_gangwei_zj());
            obj.setRy_gangwei(gw.getGangwei_mc());
        }
        obj.setRy_bm(bm.getBm_mc());
        return false;
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("BD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (RYService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(RYService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("BU")

    @M("/update")
    @Validate(wx.web.validate.RYValidate.class)
    public void update() {
        RY obj = jw.getObject(RY.class);
        if (RYService.isErrorGelibiaoshiOne(obj.getRy_zj(), Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        if (null == obj.getRy_zj() || obj.getRy_zj().length() != 24) {
            return;
        }
        if (iniRYError(obj)) {
            return;
        }
        jw.printOne(RYService.update(obj));
    }

    //@system.web.power.ann.SQ("BU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        if (RYService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        RY obj = RYService.selectOne(id);
        if (null == obj.getRy_zj()) {
            return;
        }
        jw.request.setAttribute("RY", obj);
        jw.forward("/admin/base/ry/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    //@system.web.power.ann.SQ("BS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        if (RYService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        RY obj = RYService.selectOne(id);
        if (null == obj.getRy_zj()) {
            return;
        }
        jw.request.setAttribute("RY", obj);
        jw.forward("/admin/base/ry/one.jsp");
    }

    //@system.web.power.ann.SQ("BS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "ry_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(RYService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    //@system.web.power.ann.SQ("BS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "ry_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                RYService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                RYService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (RYService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(RYService.updateStyle_examine(ids));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (RYService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(RYService.updateStyle_unExamine(ids));
    }

    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (RYService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(RYService.updateStyle_void(ids));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (RYService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(RYService.updateStyle_unVoid(ids));
    }
//---------------------------------------文件图片管理---------------------------------------
    //@system.web.power.ann.SQ("BA")

    @M("/up/file")//文件上传
    public void upfile() {
        jw.printOne(RYService.upOneFile(jw.request));
    }
}
