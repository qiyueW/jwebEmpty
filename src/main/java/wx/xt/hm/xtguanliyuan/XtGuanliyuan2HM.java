package wx.xt.hm.xtguanliyuan;

import configuration.MsgVO;
import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import system.web.power.PDK;
import wx.xt.bean.XtGuanliyuan;
import wx.xt.service.XtGuanliyuanService;

/**
 * 1.添加请求路径：/xt/xtguanliyuan/save.jw <br>
 * 2.删除请求路径（传参：id）：/xt/xtguanliyuan/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/xt/xtguanliyuan/update.jw <br>
 * 3.2查询请求路径(通过表头主键id，请求表头数据)：/xt/xtguanliyuan/update/select.jw <br>
 * 3.3查询请求路径：/xt/xtguanliyuan/update/select/grid.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例。通过主键传参：id）：/xt/xtguanliyuan/select/selectOne.jw <br>
 * 4.2全部请求路径（分页查询-JSON格式）：/xt/xtguanliyuan/select/json.jw <br>
 * 4.3全部请求路径（分页查询-GRID格式）：/xt/xtguanliyuan/select/grid.jw <br>
 * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/xt/xtguanliyuan/select/selectOne/body.jw <br>
 * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xtguanliyuan/select/selectOne/bodyJSON.jw
 * <br>
 * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xtguanliyuan/select/selectOne/bodyGrid.jw
 * <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/xt/xtguanliyuan/update/examine.jw <br>
 * 5.2反审核请求路径 ：/xt/xtguanliyuan/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/xt/xtguanliyuan/update/void.jw <br>
 * 5.4反作废请求路径 ：/xt/xtguanliyuan/update/unvoid.jw <br>
 * 总管专用通道
 */
@system.web.power.ann.SQ(value = "xtguanliyuan2", scope = PDK.SESSION_ADMIN_KEY)
@H("/xt/xtguanliyuan2")
public class XtGuanliyuan2HM {

    JWeb jw;

    public XtGuanliyuan2HM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ(value = "xtguanliyuan2A", scope = PDK.SESSION_ADMIN_KEY)
    @M("/save")
    @Validate(wx.xt.validate.XtGuanliyuanValidate.class)
    public void add() {
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        obj.setXt_guanliyuan_jibie(3);
        obj.setXt_guanliyuan_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(XtGuanliyuanService.addOne(obj));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ(value = "xtguanliyuan2D", scope = PDK.SESSION_ADMIN_KEY)
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (XtGuanliyuanService.isErrorGelibiaoshi(id, jw)) {
            return;
        }
        jw.printOne(XtGuanliyuanService.dellOne(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ(value = "xtguanliyuan2U", scope = PDK.SESSION_ADMIN_KEY)
    @M("/update")
    @Validate(wx.xt.validate.XtGuanliyuanValidate.class)
    public void update() {
        XtGuanliyuan obj = jw.getObject(XtGuanliyuan.class);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.printOne(XtGuanliyuanService.update(obj));
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2U", scope = PDK.SESSION_ADMIN_KEY)
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.request.setAttribute("XtGuanliyuan", obj);
        jw.forward("/xt/xtguanliyuan/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ(value = "xtguanliyuan2S", scope = PDK.SESSION_ADMIN_KEY)
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.request.setAttribute("XtGuanliyuan", obj);
        jw.forward("/xt/xtguanliyuan/one.jsp");
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2S", scope = PDK.SESSION_ADMIN_KEY)
    @M("/select/selectOne/json")//查询权限
    public void selectOneByJson() {
        String id = jw.getString("id");
        XtGuanliyuan obj = XtGuanliyuanService.selectOne(id);
        if (XtGuanliyuanService.isErrorGelibiaoshi(obj, jw)) {
            return;
        }
        jw.printOne(obj.toString());
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2S", scope = PDK.SESSION_ADMIN_KEY)
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_guanliyuan_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(XtGuanliyuanService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2S", scope = PDK.SESSION_ADMIN_KEY)
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_guanliyuan_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                XtGuanliyuanService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                XtGuanliyuanService.selectCount(condition))
        );
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.SQ(value = "xtguanliyuan2E", scope = PDK.SESSION_ADMIN_KEY)
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2UE", scope = PDK.SESSION_ADMIN_KEY)
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        if(ids.contains(admin.getXt_guanliyuan_zj())){
            jw.printOne(MsgVO.setError("无法自己反审自己。这会引起无法登陆的异常"));
            return;
        }
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2V", scope = PDK.SESSION_ADMIN_KEY)
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ(value = "xtguanliyuan2UV", scope = PDK.SESSION_ADMIN_KEY)
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids", "");
        XtGuanliyuan admin = XtGuanliyuanService.getSessionXtGuanliyuan(jw);
        if (ids.isEmpty() || XtGuanliyuanService.isErrorGelibiaoshi(ids, admin.getXt_guanliyuan_gelibiaoshi())) {
            return;
        }
        jw.printOne(XtGuanliyuanService.updateStyle_unVoid(ids));
    }

}
