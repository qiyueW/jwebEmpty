package wx.web.hm;

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
import wx.web.bean.Gangwei;
import wx.web.service.GangweiService;
import wx.xt.Gelibiaoshi;

/**
 * 1.添加请求路径：/base/gangwei/save.jw <br>
 * 2.删除请求路径：/base/gangwei/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/base/gangwei/update.jw <br>
 * 3.2查询请求路径：/base/gangwei/update/select.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例）：/base/gangwei/select/selectOne.jw <br>
 * 4.2全部请求路径（JSON格式）：/base/gangwei/select/json.jw <br>
 * 4.3全部请求路径（TreeGRID格式）：/base/gangwei/select/grid.jw <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/base/gangwei/update/examine.jw <br>
 * 5.2反审核请求路径 ：/base/gangwei/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/base/gangwei/update/void.jw <br>
 * 5.4反作废请求路径 ：/base/gangwei/update/unvoid.jw <br>
 */
@H("/base/gangwei")
public class GangweiHM {

    JWeb jw;

    public GangweiHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiA")
    @M("/save")
    @Validate(wx.web.validate.GangweiValidate.class)
    public void add() {
        Gangwei obj = jw.getObject(Gangwei.class);
        if (null == obj.getGangwei_fzj() || obj.getGangwei_fzj().isEmpty()) {
            obj.setGangwei_fzj("0");
        }
        obj.setGangwei_gelibiaoshi(Gelibiaoshi.getGelibiaoshi(jw));
        //其他一些预定值设置
        jw.printOne(GangweiService.addOne(obj));
    }
//===================删除操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (GangweiService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(GangweiService.dellOne(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiU")
    @M("/update")
    @Validate(wx.web.validate.GangweiValidate.class)
    public void update() {
        Gangwei obj = jw.getObject(Gangwei.class);
        if (null == obj.getGangwei_zj() || obj.getGangwei_zj().length() != 24) {
            return;
        }
        if (GangweiService.isErrorGelibiaoshiOne(obj.getGangwei_zj(), Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        if (null == obj.getGangwei_fzj() || obj.getGangwei_fzj().isEmpty()) {
            obj.setGangwei_fzj("0");
        }

        List<Gangwei> list = GangweiService.select();
        int tkey = TreeService.CHECK.getError_FatherIsSon(list, "gangwei_zj", "gangwei_fzj", obj.getGangwei_zj(), obj.getGangwei_fzj()).key;

        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(GangweiService.update(obj));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        if (GangweiService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        Gangwei obj = GangweiService.selectOne(id);
        if (null == obj.getGangwei_zj()) {
            return;
        }
        jw.request.setAttribute("Gangwei", obj);
        jw.request.setAttribute("fl_P", GangweiService.selectOne(obj.getGangwei_fzj()));
        jw.forward("/admin/base/gangwei/edit.jsp");
    }
//===================查询操作============================= 

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiS")
    @M("/select/selectOne")
    public void selectOne() {
        String id = jw.getString("id");
        if (GangweiService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        Gangwei obj = GangweiService.selectOne(id);
        if (null == obj.getGangwei_zj()) {
            return;
        }
        jw.request.setAttribute("Gangwei", obj);
        jw.request.setAttribute("fl_P", GangweiService.selectOne(obj.getGangwei_fzj()));
        jw.forward("/admin/base/gangwei/one.jsp");
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiS")
    @M("/select/json")
    public static void select(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "gangwei_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(Tool.entityToJSON(GangweiService.select(condition)).replace("\n", "/n"));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiS")
    @M("/select/json2")
    public static void select2(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "gangwei_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(EasyuiService.formatTree(GangweiService.select(condition), "gangwei_zj", "gangwei_fzj", "gangwei_mc").replace("\n", "/n"));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        //如果有某个字段要进行排序,例 以主键=。=
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "gangwei_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(EasyuiService.formatTreeGrid(GangweiService.select(condition), "gangwei_zj", "gangwei_fzj", "gangwei_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (GangweiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(GangweiService.updateStyle_examine(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (GangweiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(GangweiService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (GangweiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(GangweiService.updateStyle_void(ids));
    }

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_AdminOrUser.class, value = "gangweiUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (GangweiService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(GangweiService.updateStyle_unVoid(ids));
    }

}
