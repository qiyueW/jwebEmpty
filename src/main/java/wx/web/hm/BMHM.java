package wx.web.hm;

import com.alibaba.fastjson.JSON;
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
import wx.web.bean.BM;
import wx.web.service.BMService;
import wx.xt.service.XTTiaojianService;

/**
 * 1.添加请求路径：/base/bm/save.jw <br>
 * 2.删除请求路径：/base/bm/remove.jw <br>
 * 3.修改 <br>
 * 3.1变更请求路径：/base/bm/update.jw <br>
 * 3.2查询请求路径：/base/bm/update/select.jw <br>
 * 4.查询 <br>
 * 4.1全部请求路径（对象实例）：/base/bm/select/selectOne.jw <br>
 * 4.2全部请求路径（JSON格式）：/base/bm/select/json.jw <br>
 * 4.3全部请求路径（TreeGRID格式）：/base/bm/select/grid.jw <br>
 * 5.单据状态管理 <br>
 * 5.1审核请求路径 ：/base/bm/update/examine.jw <br>
 * 5.2反审核请求路径 ：/base/bm/update/unexamine.jw <br>
 * 5.3作废请求路径 ：/base/bm/update/void.jw <br>
 * 5.4反作废请求路径 ：/base/bm/update/unvoid.jw <br>
 * 6.上传管理 <br>
 * 6.1图片上传请求路径 ：/base/bm/up/img.jw <br>
 */
@H("/base/bm")
public class BMHM {

    JWeb jw;

    public BMHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("BA")

    @M("/save")
    @Validate(wx.web.validate.BMValidate.class)
    public void add() {
        BM obj = jw.getObject(BM.class);
        if (null == obj.getBm_fzj() || obj.getBm_fzj().isEmpty()) {
            obj.setBm_fzj("0");
        }
        //其他一些预定值设置
        jw.printOne(BMService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("BD")

    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(BMService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("BU")

    @M("/update")
    @Validate(wx.web.validate.BMValidate.class)
    public void update() {
        BM obj = jw.getObject(BM.class);
        if (null == obj.getBm_zj() || obj.getBm_zj().length() != 24) {
            return;
        }
        if (null == obj.getBm_fzj() || obj.getBm_fzj().isEmpty()) {
            obj.setBm_fzj("0");
        }

        List<BM> list = BMService.select();
        int tkey = TreeService.CHECK.getError_FatherIsSon(list, "bm_zj", "bm_fzj", obj.getBm_zj(), obj.getBm_fzj()).key;

        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(BMService.update(obj));
    }

    //@system.web.power.ann.SQ("BU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        BM obj = BMService.selectOne(id);
        if (null == obj.getBm_zj()) {
            return;
        }
        jw.request.setAttribute("BM", obj);
        jw.request.setAttribute("fl_P", BMService.selectOne(obj.getBm_fzj()));
        jw.forward("/admin/base/bm/edit.jsp");
    }
//===================查询操作============================= 
    //@system.web.power.ann.SQ("BS") 

    @M("/select/selectOne")
    public void selectOne() {
        String id = jw.getString("id");
        BM obj = BMService.selectOne(id);
        if (null == obj.getBm_zj()) {
            return;
        }
        jw.request.setAttribute("BM", obj);
        jw.request.setAttribute("fl_P", BMService.selectOne(obj.getBm_fzj()));
        jw.forward("/admin/base/bm/one.jsp");
    }

    //@system.web.power.ann.SQ("BS")
    @M("/select/json")
    public static void select(JWeb jw) {
        // jw.printOne(Tool.entityToJSON(DBO.service.S.select(LoufangFL.class, "order by loufangfl_px ASC"))); 如果有排序的话，将loufangfl_px字段替换为你的项目中的字段
        jw.printOne(Tool.entityToJSON(BMService.select()).replace("\n", "/n"));
    }
    //@system.web.power.ann.SQ("BS")

    @M("/select/json2")
    public static void select2(JWeb jw) {
        jw.printOne(EasyuiService.formatTree(BMService.select(), "bm_zj", "bm_fzj", "bm_mc").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("BS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
        //如果有某个字段要进行排序,例 以主键=。=
        String x = jw.getString("key");
        
        String condition = XTTiaojianService.engineToSQLCondition(x);
        if (condition.length() > 0) {
            condition = "WHERE " + condition;
        }
        System.out.println(condition);
        jw.printOne(EasyuiService.formatTreeGrid(BMService.select(condition), "bm_zj", "bm_fzj", "bm_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------

    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(BMService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(BMService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(BMService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(BMService.updateStyle_unVoid(jw.getString("ids")));
    }

//---------------------------------------文件图片管理---------------------------------------
    //@system.web.power.ann.SQ("BA")
    @M("/up/img")//图片上传
    public void upimg() {
        jw.printOne(BMService.upOneImg(jw.request));
    }
}
