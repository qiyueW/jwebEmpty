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
import java.util.Date;
import plugins.easyui.EasyuiService;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.bean.xtjuese.XtJuese;
import wx.xt.service.XtJueseService;

/**
 *
 * @author wangchunzi
 */
@H("/xt/xtjuese2")
public class XtJuese2HM {

    JWeb jw;

    public XtJuese2HM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2A")
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

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2D")
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

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2U")
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
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (XtJueseService.isErrorGelibiaoshiOne(obj.getXt_juese_zj(), admin.getXt_guanliyuan_gelibiaoshi())) {//存在别人家的隔离标识的单据
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
        obj.setXt_juese_xiugairen_zj(admin.getXt_guanliyuan_zj());
        obj.setXt_juese_xiugairen(admin.getXt_guanliyuan_mc());
        obj.setXt_juese_xiugaishijian(new Date());
        jw.printOne(XtJueseService.update(obj));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2U")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XtJuese obj = XtJueseService.selectOne(id);
        if (null == obj.getXt_juese_zj()) {
            return;
        }
        if (XtJueseService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("XtJuese", obj);
        jw.request.setAttribute("fl_P", XtJueseService.selectOne(obj.getXt_juese_fzj()));
        jw.forward("/xt/xtjuese/edit2.jsp");
    }
//===================查询操作============================= 
//1-------------------所有操作--------------------------- 

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2S")
    @M("/select/selectOne")
    public void selectOne() {
        String id = jw.getString("id");
        XtJuese obj = XtJueseService.selectOne(id);
        if (null == obj.getXt_juese_zj()) {
            return;
        }
        if (XtJueseService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("XtJuese", obj);
        jw.request.setAttribute("fl_P", XtJueseService.selectOne(obj.getXt_juese_fzj()));
        jw.forward("/xt/xtjuese/one2.jsp");
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2S")
    @M("/select/json")
    public static void select(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_juese_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(Tool.entityToJSON(XtJueseService.select(condition)).replace("\n", "/n"));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2S")
    @M("/select/json2")
    public static void select2(JWeb jw) {
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_juese_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(EasyuiService.formatTree(XtJueseService.select(condition), "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc").replace("\n", "/n"));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2S")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "xt_juese_gelibiaoshi", admin.getXt_guanliyuan_gelibiaoshi());
        jw.printOne(EasyuiService.formatTreeGrid(XtJueseService.select(condition), "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2E")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_examine(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2UE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2V")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_void(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtjuese2UV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (XtJueseService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(XtJueseService.updateStyle_unVoid(ids));
    }

}
