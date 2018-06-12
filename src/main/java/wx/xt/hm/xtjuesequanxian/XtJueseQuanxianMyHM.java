package wx.xt.hm.xtjuesequanxian;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.MsgVO;
import java.util.List;
import system.base.tree.TreeService;
import system.base.tree.vo.IdPidEnum;
import plugins.easyui.EasyuiService;
import wx.xt.bean.XtJuese;
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
@H("/xt/xtjuese/quanxian/my")
public class XtJueseQuanxianMyHM {

    JWeb jw;

    public XtJueseQuanxianMyHM(JWeb jw) {
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
        obj.setXt_juese_zhidanren_zj("wangchunzi");
        obj.setXt_juese_zhidanren("汪春滋");
        obj.setXt_juese_gelibiaoshi("A001");
        //其他一些预定值设置
        jw.printOne(XtJueseService.addOne(obj));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("xtjueseU")
    @M("/update")
    @Validate(wx.xt.validate.XtJueseValidate.class)
    public void updatePower() {
        XtJuese obj = jw.getObject(XtJuese.class);
        if (null == obj.getXt_juese_zj() || obj.getXt_juese_zj().length() != 24) {
            return;
        }
        if (null == obj.getXt_juese_fzj() || obj.getXt_juese_fzj().isEmpty()) {
            obj.setXt_juese_fzj("0");
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

//===================查询操作============================= 
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        String x = jw.getString("key");
        String condition = wx.xt.service.XTTiaojianService.engineToSQLCondition(x);
        String zhidanren = "wangchunzi";
        if (condition.length() > 0) {
            condition = "WHERE xt_juese_zhidanren='" + zhidanren + "' AND (" + condition + ")";
        } else {
            condition = "WHERE xt_juese_zhidanren='" + zhidanren + "'";
        }
        jw.printOne(EasyuiService.formatTreeGrid(XtJueseService.select(condition), "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(XtJueseService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(XtJueseService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(XtJueseService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(XtJueseService.updateStyle_unVoid(jw.getString("ids")));
    }

}
