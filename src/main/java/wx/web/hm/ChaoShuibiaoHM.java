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
import wx.web.bean.ChaoShuibiao;
import wx.web.bean.ChaoShuibiaoFengtan;
import wx.web.bean.RY;
import wx.web.service.ChaoShuibiaoService;
import wx.web.service.ZhusuHetongService;
import wx.xt.Gelibiaoshi;

@H("/service/chaoshuibiao")
public class ChaoShuibiaoHM {

    JWeb jw;

    public ChaoShuibiaoHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("chaoshuibiaoA")
    @M("/save")
    @Validate({wx.web.validate.ChaoShuibiaoValidate.class})
    public void add() {
        ChaoShuibiao obj = jw.getObject(ChaoShuibiao.class);
        RY ry = Gelibiaoshi.getUserInfoBySession(jw);
        //设置分摊的人数——查询审核的合同
        obj.setChaoshuibiao_fentanrenshu(ZhusuHetongService.selectCountByLoufang2_zj(obj.getChaoshuibiao_loufang2_zj(), ry.getRy_gelibiaoshi()));
        //已分摊人数锁定为0
        obj.setChaoshuibiao_yj_fentanrenshu(0);
        //设置录单人
        obj.setChaoshuibiao_zhidanshijian(new Date());
        obj.setChaoshuibiao_zhidanren_zj(ry.getRy_zj());
        obj.setChaoshuibiao_zhidanren(ry.getRy_mc());
        //
        
        List<ChaoShuibiaoFengtan> obj2 = (List<ChaoShuibiaoFengtan>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        jw.printOne(ChaoShuibiaoService.addOne(obj, obj2));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("chaoshuibiaoD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.dellVast(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("chaoshuibiaoU")
    @M("/update")
    @Validate({wx.web.validate.ChaoShuibiaoValidate.class, wx.web.validate.ChaoShuibiaoFengtanValidate.class})
    public void update() {
        ChaoShuibiao obj = jw.getObject(ChaoShuibiao.class);
        if (null == obj || null == obj.getChaoshuibiao_zj() || obj.getChaoshuibiao_zj().length() != 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        List<ChaoShuibiaoFengtan> obj2 = (List<ChaoShuibiaoFengtan>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        for (ChaoShuibiaoFengtan o2 : obj2) {
            o2.setChaoshuibiao_zj(obj.getChaoshuibiao_zj());//锁定表头主键
        }
        jw.printOne(ChaoShuibiaoService.update(obj, obj2));
    }

    @system.web.power.ann.SQ("chaoshuibiaoU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        ChaoShuibiao obj = ChaoShuibiaoService.selectOne(id);
        if (null == obj.getChaoshuibiao_zj()) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ChaoShuibiao", obj);
        jw.forward("/admin/service/chaoshuibiao/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        ChaoShuibiao obj = ChaoShuibiaoService.selectOne(id);
        if (null == obj.getChaoshuibiao_zj()) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ChaoShuibiao", obj);
        jw.forward("/admin/service/chaoshuibiao/one.jsp");
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "chaoshuibiao_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(ChaoShuibiaoService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "chaoshuibiao_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                ChaoShuibiaoService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                ChaoShuibiaoService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        ChaoShuibiaoFengtan obj = ChaoShuibiaoService.selectOne2(id);
        if (null == obj.getChaoshuibiao_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(Tool.entityToJSON(ChaoShuibiaoService.select2(id)));
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(EasyuiService.formatGrid(ChaoShuibiaoService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @system.web.power.ann.SQ("chaoshuibiaoE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("chaoshuibiaoUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("chaoshuibiaoV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("chaoshuibiaoUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_unVoid(ids));
    }

}
