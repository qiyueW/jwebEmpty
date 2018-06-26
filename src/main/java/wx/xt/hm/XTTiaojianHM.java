package wx.xt.hm;

import wx.xt.Gelibiaoshi;
import configuration.MsgVO;
import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import java.util.List;
import configuration.WebConfigModel;
import configuration.Tool;
import configuration.mvc.BaseService;
import plugins.easyui.EasyuiService;
import wx.xt.bean.xttiaojian.XTTiaojian;
import wx.xt.bean.xttiaojian.XTTiaojian1;
import wx.xt.service.XTTiaojianService;

/**
 * 1.添加请求路径：/xt/xttiaojian/save.jw <br>
 * 2.删除请求路径（传参：id）：/xt/xttiaojian/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/xt/xttiaojian/update.jw <br>
 * 3.2查询请求路径(通过表头主键id，请求表头数据)：/xt/xttiaojian/update/select.jw <br>
 * 3.3查询请求路径：/xt/xttiaojian/update/select/grid.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例。通过主键传参：id）：/xt/xttiaojian/select/selectOne.jw <br>
 * 4.2全部请求路径（分页查询-JSON格式）：/xt/xttiaojian/select/json.jw <br>
 * 4.3全部请求路径（分页查询-GRID格式）：/xt/xttiaojian/select/grid.jw <br>
 * 4.3全部请求路径(通过表体主键id，请求表体一条记录)：/xt/xttiaojian/select/selectOne/body.jw <br>
 * 4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xttiaojian/select/selectOne/bodyJSON.jw
 * <br>
 * 4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/xt/xttiaojian/select/selectOne/bodyGrid.jw
 * <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/xt/xttiaojian/update/examine.jw <br>
 * 5.2反审核请求路径 ：/xt/xttiaojian/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/xt/xttiaojian/update/void.jw <br>
 * 5.4反作废请求路径 ：/xt/xttiaojian/update/unvoid.jw <br>
 */
@H("/xt/xttiaojian")
public class XTTiaojianHM {

    JWeb jw;

    public XTTiaojianHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xttiaojianA")

    @M("/save")
    @Validate({wx.xt.validate.xttiaojian.XTTiaojianValidate.class, wx.xt.validate.xttiaojian.XTTiaojian1Validate.class})
    public void add() {
        XTTiaojian obj = jw.getObject(XTTiaojian.class);
        obj.setXt_tiaojian_gelibiaoshi(Gelibiaoshi.getGelibiaoshi(jw));//隔离标识，正常从人员的会话中提取
        obj.setXt_tiaojian_zhidanren_zj(Gelibiaoshi.getAdminOrUserID(jw));//创建人。正常从人员的会话中提取。
        obj.setXt_tiaojian_zhidanren("汪春滋");
        List<XTTiaojian1> obj2 = (List<XTTiaojian1>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        jw.printOne(XTTiaojianService.addOne(obj, obj2));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("xttiaojianD")

    @M("/remove2")//用户删除自己的查询表单
    public void dellOne() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        XTTiaojian obj = XTTiaojianService.selectOne(id);
        if (obj.getXt_tiaojian_zt() == BaseService.SHENHE) {
            jw.printOne(MsgVO.setError("无法删除公共单据"));
            return;
        }
        jw.printOne(XTTiaojianService.dellOne(id));
    }

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        jw.printOne(XTTiaojianService.dellVast(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("xttiaojianU")

    @M("/update2")
    @Validate({wx.xt.validate.xttiaojian.XTTiaojianValidate.class, wx.xt.validate.xttiaojian.XTTiaojian1Validate.class})
    public void update2() {
        XTTiaojian obj = jw.getObject(XTTiaojian.class);
        if (null == obj || null == obj.getXt_tiaojian_zj()) {
            jw.printOne(MsgVO.setError("请选择要修改的单据"));
            return;
        }
        XTTiaojian sqlvo = XTTiaojianService.selectOne(obj.getXt_tiaojian_zj());
//        if (!sqlvo.getXt_tiaojian_zhidanren_zj().equals("会话中拿出人员信息")||!sqlvo.getXt_tiaojian_gelibiaoshi().equals("会话中拿出人员信息中的隔离标识")) {
//            return MsgVO.setError("无法删除别人的单据");
//        }
        if (sqlvo.getXt_tiaojian_zt() == BaseService.SHENHE) {
            jw.printOne(MsgVO.setError("无法修改公共单据"));
            return;
        }
        List<XTTiaojian1> obj2 = (List<XTTiaojian1>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        for (XTTiaojian1 o2 : obj2) {
            o2.setXt_tiaojian_zj(obj.getXt_tiaojian_zj());//锁定表头主键
        }
        jw.printOne(XTTiaojianService.update(obj, obj2));
    }

    @M("/update")
    @Validate({wx.xt.validate.xttiaojian.XTTiaojianValidate.class, wx.xt.validate.xttiaojian.XTTiaojian1Validate.class})
    public void update() {
        XTTiaojian obj = jw.getObject(XTTiaojian.class);
        List<XTTiaojian1> obj2 = (List<XTTiaojian1>) jw.request.getAttribute(WebConfigModel.JSONKEY);
        for (XTTiaojian1 o2 : obj2) {
            o2.setXt_tiaojian_zj(obj.getXt_tiaojian_zj());//锁定表头主键
        }
        jw.printOne(XTTiaojianService.update(obj, obj2));
    }

    //@system.web.power.ann.SQ("xttiaojianU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XTTiaojian obj = XTTiaojianService.selectOne(id);
        if (null == obj.getXt_tiaojian_zj()) {
            return;
        }
        jw.request.setAttribute("XTTiaojian", obj);
        jw.forward("/xt/xttiaojian/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    //@system.web.power.ann.SQ("xttiaojianS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        XTTiaojian obj = XTTiaojianService.selectOne(id);
        if (null == obj.getXt_tiaojian_zj()) {
            return;
        }
        jw.request.setAttribute("XTTiaojian", obj);
        jw.forward("/xt/xttiaojian/one.jsp");
    }

    //@system.web.power.ann.SQ("xttiaojianS")
    @M("/select/myself/json")//查询自己的或公共的方案
    public static void selectMyselfJSON(JWeb jw) {
        String condition = Gelibiaoshi.getAdminOrUserID(jw);
        jw.printOne(Tool.entityToJSON(XTTiaojianService.selectByRy(Gelibiaoshi.getGelibiaoshi(jw), condition, jw.getString("key"))));
    }

    //@system.web.power.ann.SQ("xttiaojianS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = "WHERE xt_tiaojian_gelibiaoshi='" + Gelibiaoshi.getGelibiaoshi(jw) + "'";
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(XTTiaojianService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }
    //@system.web.power.ann.SQ("xttiaojianS")

    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = "WHERE xt_tiaojian_gelibiaoshi='" + Gelibiaoshi.getGelibiaoshi(jw) + "'";
        String fl_zj = jw.getString("xt_shezhi_tiaojian_zj");
        if (!fl_zj.isEmpty()) {
            condition =condition+ "AND xt_shezhi_tiaojian_zj='" + fl_zj + "'";
        }
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                XTTiaojianService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                XTTiaojianService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        XTTiaojian1 obj = XTTiaojianService.selectOne2(id);
        if (null == obj.getXt_tiaojian_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    //@system.web.power.ann.SQ("xttiaojianU")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        jw.printOne(Tool.entityToJSON(XTTiaojianService.select2(id)));
    }

    //@system.web.power.ann.SQ("xttiaojianU")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        if (null != id) {
            jw.printOne(EasyuiService.formatGrid(XTTiaojianService.select2(id)));
        }
    }

//---------------------------------------单据状态管理---------------------------------------
    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(XTTiaojianService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(XTTiaojianService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(XTTiaojianService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(XTTiaojianService.updateStyle_unVoid(jw.getString("ids")));
    }

}
