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
import wx.web.bean.Hetong;
import wx.web.service.HetongService;


/**
*1.添加请求路径：/base/hetong/save.jw <br>
*2.删除请求路径：/base/hetong/remove.jw <br>
*3.修改 <br>
*   3.1变更请求路径：/base/hetong/update.jw <br>
*   3.2查询请求路径：/base/hetong/update/select.jw <br>
*4.查询 <br>
*   4.1全部请求路径（对象实例）：/base/hetong/select/selectOne.jw <br>
*   4.2全部请求路径（JSON格式）：/base/hetong/select/json.jw <br>
*   4.3全部请求路径（TreeGRID格式）：/base/hetong/select/grid.jw <br>
*5.单据状态管理 <br>
*   5.1审核请求路径   ：/base/hetong/update/examine.jw <br>
*   5.2反审核请求路径 ：/base/hetong/update/unexamine.jw <br>
*   5.3作废请求路径   ：/base/hetong/update/void.jw <br>
*   5.4反作废请求路径 ：/base/hetong/update/unvoid.jw <br>
*6.上传管理 <br>
*   6.1图片上传请求路径   ：/base/hetong/up/img.jw <br>
*/
@H("/base/hetong")
public class HetongHM {

    JWeb jw;

    public HetongHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("BA")
    @M("/save")
    @Validate(wx.web.validate.HetongValidate.class)
    public void add() {
        Hetong obj = jw.getObject(Hetong.class);
        if (null == obj.getHetong_fzj()|| obj.getHetong_fzj().isEmpty()) {
            obj.setHetong_fzj("0");
        }
        //其他一些预定值设置
        jw.printOne(HetongService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("BD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(HetongService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("BU")
    @M("/update")
    @Validate(wx.web.validate.HetongValidate.class)
	public void update() {
		Hetong obj = jw.getObject(Hetong.class);
		if (null == obj.getHetong_zj() || obj.getHetong_zj().length() != 24)
			return;
		if (null == obj.getHetong_fzj() || obj.getHetong_fzj().isEmpty())
			obj.setHetong_fzj("0");

		List<Hetong> list = HetongService.select();
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "hetong_zj", "hetong_fzj", obj.getHetong_zj(),obj.getHetong_fzj()).key;
		
        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(HetongService.update(obj));
	}
    //@system.web.power.ann.SQ("BU")
    @M("/update/select")
	public void updateSelect() {
		String id = jw.getString("id");
		Hetong obj = HetongService.selectOne(id);
		if (null == obj.getHetong_zj())
			return;
		jw.request.setAttribute("Hetong", obj);
        jw.request.setAttribute("fl_P", HetongService.selectOne(obj.getHetong_fzj()));
		jw.forward("/admin/base/hetong/edit.jsp");
	}
//===================查询操作============================= 
   //@system.web.power.ann.SQ("BS") 
    @M("/select/selectOne")
	public void selectOne() {
		String id = jw.getString("id");
		Hetong obj = HetongService.selectOne(id);
		if (null == obj.getHetong_zj())
			return;
		jw.request.setAttribute("Hetong", obj);
        jw.request.setAttribute("fl_P", HetongService.selectOne(obj.getHetong_fzj()));
		jw.forward("/admin/base/hetong/one.jsp");
	}

   //@system.web.power.ann.SQ("BS")
    @M("/select/json")
    public static void select(JWeb jw) {
    // jw.printOne(Tool.entityToJSON(DBO.service.S.select(LoufangFL.class, "order by loufangfl_px ASC"))); 如果有排序的话，将loufangfl_px字段替换为你的项目中的字段
        jw.printOne(Tool.entityToJSON(HetongService.select()).replace("\n", "/n"));
    }
   //@system.web.power.ann.SQ("BS")
    @M("/select/json2")
    public static void select2(JWeb jw) {
        jw.printOne(EasyuiService.formatTree(HetongService.select(), "hetong_zj", "hetong_fzj", "hetong_mingcheng").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("BS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
    //如果有某个字段要进行排序,例 以主键=。=
        //jw.printOne(EasyuiService.formatTreeGrid(DBO.service.S.select(Hetong.class, "order by hetong_zj ASC" ), "hetong_zj", "hetong_fzj", "hetong_mingcheng"));
        jw.printOne(EasyuiService.formatTreeGrid(HetongService.select(), "hetong_zj", "hetong_fzj", "hetong_mingcheng").replace("\n", "/n"));
    }
//---------------------------------------单据状态管理---------------------------------------
    @M("/update/examine")//审核单据
    public void examine() {
        jw.printOne(HetongService.updateStyle_examine(jw.getString("ids")));
    }

    @M("/update/unexamine")//反审核
    public void unexamine() {
        jw.printOne(HetongService.updateStyle_unExamine(jw.getString("ids")));
    }

    @M("/update/void")//作废
    public void tovoid() {
        jw.printOne(HetongService.updateStyle_void(jw.getString("ids")));
    }

    @M("/update/unvoid")//反作废
    public void untovoid() {
        jw.printOne(HetongService.updateStyle_unVoid(jw.getString("ids")));
    }

//---------------------------------------文件图片管理---------------------------------------
    //@system.web.power.ann.SQ("BA")
    @M("/up/img")//图片上传
    public void upimg() {
        jw.printOne(HetongService.upOneImg(jw.request));
    }
}
