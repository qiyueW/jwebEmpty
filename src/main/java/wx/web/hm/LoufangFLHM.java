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
import wx.web.bean.LoufangFL;
import wx.web.service.LoufangFLService;
import wx.xt.Gelibiaoshi;

/**
 * 1.添加请求路径：/base/loufangfl/save.jw <br>
 * 2.删除请求路径：/base/loufangfl/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/base/loufangfl/update.jw <br>
 * 3.2查询请求路径：/base/loufangfl/update/select.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例）：/base/loufangfl/select/selectOne.jw <br>
 * 4.2全部请求路径（JSON格式）：/base/loufangfl/select/json.jw <br>
 * 4.3全部请求路径（TreeGRID格式）：/base/loufangfl/select/grid.jw <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/base/loufangfl/update/examine.jw <br>
 * 5.2反审核请求路径 ：/base/loufangfl/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/base/loufangfl/update/void.jw <br>
 * 5.4反作废请求路径 ：/base/loufangfl/update/unvoid.jw <br>
 */
@H("/base/loufangfl")
public class LoufangFLHM {

    JWeb jw;

    public LoufangFLHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("loufangflA")

    @M("/save")
    @Validate(wx.web.validate.LoufangFLValidate.class)
    public void add() {
        LoufangFL obj = jw.getObject(LoufangFL.class);
        if (null == obj.getLoufangfl_fzj() || obj.getLoufangfl_fzj().isEmpty()) {
            obj.setLoufangfl_fzj("0");
        }
        obj.setLoufangfl_gelibiaoshi(Gelibiaoshi.getGelibiaoshi(jw));
        //其他一些预定值设置
        jw.printOne(LoufangFLService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("loufangflD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        if (LoufangFLService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFLService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("loufangflU")

    @M("/update")
    @Validate(wx.web.validate.LoufangFLValidate.class)
    public void update() {
        LoufangFL obj = jw.getObject(LoufangFL.class);
        if (null == obj.getloufangfl_zj() || obj.getloufangfl_zj().length() != 24) {
            return;
        }
        if (null == obj.getLoufangfl_fzj() || obj.getLoufangfl_fzj().isEmpty()) {
            obj.setLoufangfl_fzj("0");
        }
        if (LoufangFLService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        List<LoufangFL> list = LoufangFLService.select();
        int tkey = TreeService.CHECK.getError_FatherIsSon(list, "loufangfl_zj", "loufangfl_fzj", obj.getloufangfl_zj(), obj.getLoufangfl_fzj()).key;

        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(LoufangFLService.update(obj));
    }

    //@system.web.power.ann.SQ("loufangflU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        LoufangFL obj = LoufangFLService.selectOne(id);
        if (null == obj.getloufangfl_zj()) {
            return;
        }
        if (LoufangFLService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangFL", obj);
        jw.request.setAttribute("fl_P", LoufangFLService.selectOne(obj.getLoufangfl_fzj()));
        jw.forward("/admin/base/loufangfl/edit.jsp");
    }
//===================查询操作============================= 
    //@system.web.power.ann.SQ("loufangflS") 

    @M("/select/selectOne")
    public void selectOne() {
        String id = jw.getString("id");
        LoufangFL obj = LoufangFLService.selectOne(id);
        if (null == obj.getloufangfl_zj()) {
            return;
        }
        if (LoufangFLService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("LoufangFL", obj);
        jw.request.setAttribute("fl_P", LoufangFLService.selectOne(obj.getLoufangfl_fzj()));
        jw.forward("/admin/base/loufangfl/one.jsp");
    }

    //@system.web.power.ann.SQ("loufangflS")
    @M("/select/json")
    public static void select(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangfl_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(Tool.entityToJSON(LoufangFLService.select(condition)).replace("\n", "/n"));
    }
    //@system.web.power.ann.SQ("loufangflS")

    @M("/select/json2")
    public static void select2(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangfl_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(EasyuiService.formatTree(LoufangFLService.select(condition), "loufangfl_zj", "loufangfl_fzj", "loufangfl_mc").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("loufangflS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "loufangfl_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        jw.printOne(EasyuiService.formatTreeGrid(LoufangFLService.select(condition), "loufangfl_zj", "loufangfl_fzj", "loufangfl_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (LoufangFLService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFLService.updateStyle_examine(ids));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (LoufangFLService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFLService.updateStyle_unExamine(ids));
    }

    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (LoufangFLService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFLService.updateStyle_void(ids));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (LoufangFLService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(LoufangFLService.updateStyle_unVoid(ids));
    }

}
