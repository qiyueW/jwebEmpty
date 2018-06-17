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
import wx.web.bean.Zhiwei;
import wx.web.service.ZhiweiService;


/**
*1.添加请求路径：/base/zhiwei/save.jw <br>
*2.删除请求路径：/base/zhiwei/remove.jw <br>
*3.修改 <br>
*   3.1变更请求路径：/base/zhiwei/update.jw <br>
*   3.2查询请求路径：/base/zhiwei/update/select.jw <br>
*4.查询 <br>
*   4.1全部请求路径（对象实例）：/base/zhiwei/select/selectOne.jw <br>
*   4.2全部请求路径（JSON格式）：/base/zhiwei/select/json.jw <br>
*   4.3全部请求路径（TreeGRID格式）：/base/zhiwei/select/grid.jw <br>
*5.单据状态管理 <br>
*   5.1审核请求路径   ：/base/zhiwei/update/examine.jw <br>
*   5.2反审核请求路径 ：/base/zhiwei/update/unexamine.jw <br>
*   5.3作废请求路径   ：/base/zhiwei/update/void.jw <br>
*   5.4反作废请求路径 ：/base/zhiwei/update/unvoid.jw <br>
*/
@H("/base/zhiwei")
public class ZhiweiHM {

    JWeb jw;

    public ZhiweiHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("zhiweiA")
    @M("/save")
    @Validate(wx.web.validate.ZhiweiValidate.class)
    public void add() {
        Zhiwei obj = jw.getObject(Zhiwei.class);
        if (null == obj.getZhiwei_fzj()|| obj.getZhiwei_fzj().isEmpty()) {
            obj.setZhiwei_fzj("0");
        }
        //其他一些预定值设置
        jw.printOne(ZhiweiService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("zhiweiD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(ZhiweiService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("zhiweiU")
    @M("/update")
    @Validate(wx.web.validate.ZhiweiValidate.class)
	public void update() {
		Zhiwei obj = jw.getObject(Zhiwei.class);
		if (null == obj.getZhiwei_zj() || obj.getZhiwei_zj().length() != 24)
			return;
		if (null == obj.getZhiwei_fzj() || obj.getZhiwei_fzj().isEmpty())
			obj.setZhiwei_fzj("0");

		List<Zhiwei> list = ZhiweiService.select();
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "zhiwei_zj", "zhiwei_fzj", obj.getZhiwei_zj(),obj.getZhiwei_fzj()).key;
		
        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(ZhiweiService.update(obj));
	}
    //@system.web.power.ann.SQ("zhiweiU")
    @M("/update/select")
	public void updateSelect() {
		String id = jw.getString("id");
		Zhiwei obj = ZhiweiService.selectOne(id);
		if (null == obj.getZhiwei_zj())
			return;
		jw.request.setAttribute("Zhiwei", obj);
        jw.request.setAttribute("fl_P", ZhiweiService.selectOne(obj.getZhiwei_fzj()));
		jw.forward("/admin/base/zhiwei/edit.jsp");
	}
//===================查询操作============================= 
   //@system.web.power.ann.SQ("zhiweiS") 
    @M("/select/selectOne")
	public void selectOne() {
		String id = jw.getString("id");
		Zhiwei obj = ZhiweiService.selectOne(id);
		if (null == obj.getZhiwei_zj())
			return;
		jw.request.setAttribute("Zhiwei", obj);
        jw.request.setAttribute("fl_P", ZhiweiService.selectOne(obj.getZhiwei_fzj()));
		jw.forward("/admin/base/zhiwei/one.jsp");
	}

   //@system.web.power.ann.SQ("zhiweiS")
    @M("/select/json")
    public static void select(JWeb jw) {
    // jw.printOne(Tool.entityToJSON(DBO.service.S.select(LoufangFL.class, "order by loufangfl_px ASC"))); 如果有排序的话，将loufangfl_px字段替换为你的项目中的字段
        jw.printOne(Tool.entityToJSON(ZhiweiService.select()).replace("\n", "/n"));
    }
   //@system.web.power.ann.SQ("zhiweiS")
    @M("/select/json2")
    public static void select2(JWeb jw) {
        jw.printOne(EasyuiService.formatTree(ZhiweiService.select(), "zhiwei_zj", "zhiwei_fzj", "zhiwei_mc").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("zhiweiS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
    //如果有某个字段要进行排序,例 以主键=。=
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw);
        jw.printOne(EasyuiService.formatTreeGrid(ZhiweiService.select(condition), "zhiwei_zj", "zhiwei_fzj", "zhiwei_mc").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------
    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(ZhiweiService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(ZhiweiService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(ZhiweiService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(ZhiweiService.updateStyle_unVoid(jw.getString("ids")));
    }

}
