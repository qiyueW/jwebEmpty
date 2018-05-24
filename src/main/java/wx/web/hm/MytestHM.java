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
import wx.web.bean.Mytest;
import wx.web.service.MytestService;


/**
*1.添加请求路径：/service/mytest/save.jw <br>
*2.删除请求路径：/service/mytest/remove.jw <br>
*3.修改 <br>
*   3.1变更请求路径：/service/mytest/update.jw <br>
*   3.2查询请求路径：/service/mytest/update/select.jw <br>
*4.查询 <br>
*   4.1全部请求路径（对象实例）：/service/mytest/select/selectOne.jw <br>
*   4.2全部请求路径（JSON格式）：/service/mytest/select/json.jw <br>
*   4.3全部请求路径（TreeGRID格式）：/service/mytest/select/grid.jw <br>
*/
@H("/service/mytest")
public class MytestHM {

    JWeb jw;

    public MytestHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("SA")
    @M("/save")
    @Validate(wx.web.validate.MytestValidate.class)
    public void add() {
        Mytest obj = jw.getObject(Mytest.class);
        if (null == obj.getMytest_fzj()|| obj.getMytest_fzj().isEmpty()) {
            obj.setMytest_fzj("0");
        }
        //其他一些预定值设置
        jw.printOne(MytestService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("SD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(MytestService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("SU")
    @M("/update")
    @Validate(wx.web.validate.MytestValidate.class)
	public void update() {
		Mytest obj = jw.getObject(Mytest.class);
		if (null == obj.getMytest_zj() || obj.getMytest_zj().length() != 24)
			return;
		if (null == obj.getMytest_fzj() || obj.getMytest_fzj().isEmpty())
			obj.setMytest_fzj("0");

		List<Mytest> list = MytestService.select();
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "mytest_zj", "mytest_fzj", obj.getMytest_zj(),obj.getMytest_fzj()).key;
		
        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(MytestService.update(obj));
	}
    //@system.web.power.ann.SQ("SU")
    @M("/update/select")
	public void updateSelect() {
		String id = jw.getString("id");
		Mytest obj = MytestService.selectOne(id);
		if (null == obj.getMytest_zj())
			return;
		jw.request.setAttribute("Mytest", obj);
        jw.request.setAttribute("fl_P", MytestService.selectOne(obj.getMytest_fzj()));
		jw.forward("/admin/service/mytest/edit.jsp");
	}
//===================查询操作============================= 
   //@system.web.power.ann.SQ("SS") 
    @M("/select/selectOne")
	public void selectOne() {
		String id = jw.getString("id");
		Mytest obj = MytestService.selectOne(id);
		if (null == obj.getMytest_zj())
			return;
		jw.request.setAttribute("Mytest", obj);
        jw.request.setAttribute("fl_P", MytestService.selectOne(obj.getMytest_fzj()));
		jw.forward("/admin/service/mytest/one.jsp");
	}

   //@system.web.power.ann.SQ("SS")
    @M("/select/json")
    public static void select(JWeb jw) {
    // jw.printOne(Tool.entityToJSON(DBO.service.S.select(LoufangFL.class, "order by loufangfl_px ASC"))); 如果有排序的话，将loufangfl_px字段替换为你的项目中的字段
        jw.printOne(Tool.entityToJSON(MytestService.select()).replace("\n", "/n"));
    }
   //@system.web.power.ann.SQ("SS")
    @M("/select/json2")
    public static void select2(JWeb jw) {
        jw.printOne(EasyuiService.formatTree(MytestService.select(), "mytest_zj", "mytest_fzj", "mytest_mc").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("SS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
    //如果有某个字段要进行排序,例 以主键=。=
        //jw.printOne(EasyuiService.formatTreeGrid(DBO.service.S.select(Mytest.class, "order by mytest_zj ASC" ), "mytest_zj", "mytest_fzj", "mytest_mc"));
        jw.printOne(EasyuiService.formatTreeGrid(MytestService.select(), "mytest_zj", "mytest_fzj", "mytest_mc").replace("\n", "/n"));
    }

}
