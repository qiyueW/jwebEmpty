package wx.xt.hm.xtjuese;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.MsgVO;
import java.util.List;
import system.base.tree.TreeService;
import system.base.tree.vo.IdPidEnum;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.bean.xtjuese.XtJuese;
import wx.xt.service.XtJueseService;

/**
 * 1.添加请求路径：/xt/xtjuese/save.jw <br>
 * 2.删除请求路径：/xt/xtjuese/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/xt/xtjuese/update.jw <br>
 * 3.2查询请求路径：/xt/xtjuese/update/select.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例）：/xt/xtjuese/select/selectOne.jw <br>
 * 4.2全部请求路径（JSON格式）：/xt/xtjuese/select/json.jw <br>
 * 4.3全部请求路径（TreeGRID格式）：/xt/xtjuese/select/grid.jw <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/xt/xtjuese/update/examine.jw <br>
 * 5.2反审核请求路径 ：/xt/xtjuese/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/xt/xtjuese/update/void.jw <br>
 * 5.4反作废请求路径 ：/xt/xtjuese/update/unvoid.jw <br>
 */
@H("/xt/xtjuese")
public class XtJueseHM {

    JWeb jw;

    public XtJueseHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xtjueseA")

    @M("/save")
    @Validate(wx.xt.validate.XtJueseValidate.class)
    public void add() {
        XtJuese obj = jw.getObject(XtJuese.class);
        if (null == obj.getXt_juese_fzj() || obj.getXt_juese_fzj().isEmpty()) {
            obj.setXt_juese_fzj("0");
        }
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        obj.setXt_juese_zhidanren_zj(admin.getXt_guanliyuan_zj());
        obj.setXt_juese_zhidanren(admin.getXt_guanliyuan_mc());
        obj.setXt_juese_gelibiaoshi(admin.getXt_guanliyuan_gelibiaoshi());
        //其他一些预定值设置
        jw.printOne(XtJueseService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("xtjueseD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (XtJueseService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("xtjueseU")

    @M("/update")
    @Validate(wx.xt.validate.XtJueseValidate.class)
    public void update() {
        XtJuese obj = jw.getObject(XtJuese.class);
        if (null == obj.getXt_juese_zj() || obj.getXt_juese_zj().length() != 24) {
            return;
        }
        if (null == obj.getXt_juese_fzj() || obj.getXt_juese_fzj().isEmpty()) {
            obj.setXt_juese_fzj("0");
        }
        if (XtJueseService.isErrorGelibiaoshiOne(obj.getXt_juese_zj(), Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        List<XtJuese> list = XtJueseService.select();
        int tkey = TreeService.CHECK.getError_FatherIsSon(list, "xt_juese_zj", "xt_juese_fzj", obj.getXt_juese_zj(), obj.getXt_juese_fzj()).key;

        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(XtJueseService.update(obj));
    }

    //@system.web.power.ann.SQ("xtjueseU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XtJuese obj = XtJueseService.selectOne(id);
        if (null == obj.getXt_juese_zj()) {
            return;
        }
        if (XtJueseService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("XtJuese", obj);
        jw.request.setAttribute("fl_P", XtJueseService.selectOne(obj.getXt_juese_fzj()));
        jw.forward("/xt/xtjuese/edit.jsp");
    }
//===================查询操作============================= 
//1-------------------所有操作--------------------------- 
    //@system.web.power.ann.SQ("xtjueseS") 

    @M("/select/selectOne")
    public void selectOne() {
        String id = jw.getString("id");
        XtJuese obj = XtJueseService.selectOne(id);
        if (null == obj.getXt_juese_zj()) {
            return;
        }
        if (XtJueseService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("XtJuese", obj);
        jw.request.setAttribute("fl_P", XtJueseService.selectOne(obj.getXt_juese_fzj()));
        jw.forward("/xt/xtjuese/one.jsp");
    }

    //@system.web.power.ann.SQ("xtjueseS")
    @M("/select/json")
    public static void select(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_juese_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(Tool.entityToJSON(XtJueseService.select(condition)).replace("\n", "/n"));
    }
    //@system.web.power.ann.SQ("xtjueseS")

    @M("/select/json2")
    public static void select2(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_juese_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(EasyuiService.formatTree(XtJueseService.select(condition), "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("xtjueseS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_juese_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(EasyuiService.formatTreeGrid(XtJueseService.select(condition), "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_examine(ids));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_unExamine(ids));
    }

    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_void(ids));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_unVoid(ids));
    }

}
