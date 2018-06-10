package wx.xt.hm;

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
import wx.xt.bean.XtQuanxian;
import wx.xt.service.XtQuanxianService;

/**
 * 1.添加请求路径：/xt/xtquanxian/save.jw <br>
 * 2.删除请求路径：/xt/xtquanxian/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/xt/xtquanxian/update.jw <br>
 * 3.2查询请求路径：/xt/xtquanxian/update/select.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例）：/xt/xtquanxian/select/selectOne.jw <br>
 * 4.2全部请求路径（JSON格式）：/xt/xtquanxian/select/json.jw <br>
 * 4.3全部请求路径（TreeGRID格式）：/xt/xtquanxian/select/grid.jw <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/xt/xtquanxian/update/examine.jw <br>
 * 5.2反审核请求路径 ：/xt/xtquanxian/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/xt/xtquanxian/update/void.jw <br>
 * 5.4反作废请求路径 ：/xt/xtquanxian/update/unvoid.jw <br>
 */
@H("/xt/xtquanxian")
public class XtQuanxianHM {

    JWeb jw;

    public XtQuanxianHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xtquanxianA")

    @M("/save")
    @Validate(wx.xt.validate.XtQuanxianValidate.class)
    public void add() {
        XtQuanxian obj = jw.getObject(XtQuanxian.class);
        if (null == obj.getXt_quanxian_fzj() || obj.getXt_quanxian_fzj().isEmpty()) {
            obj.setXt_quanxian_fzj("0");
        }
        //其他一些预定值设置
        jw.printOne(XtQuanxianService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("xtquanxianD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(XtQuanxianService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("xtquanxianU")

    @M("/update")
    @Validate(wx.xt.validate.XtQuanxianValidate.class)
    public void update() {
        XtQuanxian obj = jw.getObject(XtQuanxian.class);
        if (null == obj.getXt_quanxian_zj() || obj.getXt_quanxian_zj().length() != 24) {
            return;
        }
        if (null == obj.getXt_quanxian_fzj() || obj.getXt_quanxian_fzj().isEmpty()) {
            obj.setXt_quanxian_fzj("0");
        }

        List<XtQuanxian> list = XtQuanxianService.select();
        int tkey = TreeService.CHECK.getError_FatherIsSon(list, "xt_quanxian_zj", "xt_quanxian_fzj", obj.getXt_quanxian_zj(), obj.getXt_quanxian_fzj()).key;

        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(XtQuanxianService.update(obj));
    }

    //@system.web.power.ann.SQ("xtquanxianU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        XtQuanxian obj = XtQuanxianService.selectOne(id);
        if (null == obj.getXt_quanxian_zj()) {
            return;
        }
        jw.request.setAttribute("XtQuanxian", obj);
        jw.request.setAttribute("fl_P", XtQuanxianService.selectOne(obj.getXt_quanxian_fzj()));
        jw.forward("/xt/xtquanxian/edit.jsp");
    }
//===================查询操作============================= 
    //@system.web.power.ann.SQ("xtquanxianS") 

    @M("/select/selectOne")
    public void selectOne() {
        String id = jw.getString("id");
        XtQuanxian obj = XtQuanxianService.selectOne(id);
        if (null == obj.getXt_quanxian_zj()) {
            return;
        }
        jw.request.setAttribute("XtQuanxian", obj);
        jw.request.setAttribute("fl_P", XtQuanxianService.selectOne(obj.getXt_quanxian_fzj()));
        jw.forward("/xt/xtquanxian/one.jsp");
    }

    //@system.web.power.ann.SQ("xtquanxianS")
    @M("/select/json")
    public static void select(JWeb jw) {
        // jw.printOne(Tool.entityToJSON(DBO.service.S.select(LoufangFL.class, "order by loufangfl_px ASC"))); 如果有排序的话，将loufangfl_px字段替换为你的项目中的字段
        jw.printOne(Tool.entityToJSON(XtQuanxianService.select()));
    }

    @M("/select/json/menu1")
    public static void selectMenu1(JWeb jw) {
        jw.printOne(Tool.entityToJSON(XtQuanxianService.selectMenu()));
    }
    //@system.web.power.ann.SQ("xtquanxianS")

    @M("/select/json2")
    public static void select2(JWeb jw) {
        jw.printOne(EasyuiService.formatTree(XtQuanxianService.select(), "xt_quanxian_zj", "xt_quanxian_fzj", "xt_quanxian_mc").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("xtquanxianS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        //如果有某个字段要进行排序,例 以主键=。=
        //jw.printOne(EasyuiService.formatTreeGrid(DBO.service.S.select(XtQuanxian.class, "order by xt_quanxian_zj ASC" ), "xt_quanxian_zj", "xt_quanxian_fzj", "xt_quanxian_mc"));
        String x = jw.getString("key");
        String condition = wx.xt.service.XTTiaojianService.engineToSQLCondition(x);
        if (condition.length() > 0) {
            condition = "WHERE " + condition;
        }
        System.out.println(condition);
        jw.printOne(EasyuiService.formatTreeGrid(XtQuanxianService.select(condition), "xt_quanxian_zj", "xt_quanxian_fzj", "xt_quanxian_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(XtQuanxianService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(XtQuanxianService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(XtQuanxianService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(XtQuanxianService.updateStyle_unVoid(jw.getString("ids")));
    }

}
