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
import wx.web.bean.TestMyxx;
import wx.web.service.TestMyxxService;


/**
*1.添加请求路径：/service/testmyxx/save.jw <br>
*2.删除请求路径：/service/testmyxx/remove.jw <br>
*3.修改 <br>
*   3.1变更请求路径：/service/testmyxx/update.jw <br>
*   3.2查询请求路径：/service/testmyxx/update/select.jw <br>
*4.查询 <br>
*   4.1全部请求路径（对象实例）：/service/testmyxx/select/selectOne.jw <br>
*   4.2全部请求路径（JSON格式）：/service/testmyxx/select/json.jw <br>
*   4.3全部请求路径（TreeGRID格式）：/service/testmyxx/select/grid.jw <br>
*/
@H("/service/testmyxx")
public class TestMyxxHM {

    JWeb jw;

    public TestMyxxHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("SA")
    @M("/save")
    @Validate(wx.web.validate.TestMyxxValidate.class)
    public void add() {
        TestMyxx obj = jw.getObject(TestMyxx.class);
        if (null == obj.getTestmyxx_pid()|| obj.getTestmyxx_pid().isEmpty()) {
            obj.setTestmyxx_pid("0");
        }
        //其他一些预定值设置
        jw.printOne(TestMyxxService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("SD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(TestMyxxService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("SU")
    @M("/update")
    @Validate(wx.web.validate.TestMyxxValidate.class)
	public void update() {
		TestMyxx obj = jw.getObject(TestMyxx.class);
		if (null == obj.getTestmyxx_zj() || obj.getTestmyxx_zj().length() != 24)
			return;
		if (null == obj.getTestmyxx_pid() || obj.getTestmyxx_pid().isEmpty())
			obj.setTestmyxx_pid("0");

		List<TestMyxx> list = TestMyxxService.select();
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "testmyxx_zj", "testmyxx_pid", obj.getTestmyxx_zj(),obj.getTestmyxx_pid()).key;
		
        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(MsgVO.setError("修改失败:自己是自己的上级!"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(MsgVO.setError("修改失败:自己的子级是自己的上级!"));
            return;
        }
        jw.printOne(TestMyxxService.update(obj));
	}
    //@system.web.power.ann.SQ("SU")
    @M("/update/select")
	public void updateSelect() {
		String id = jw.getString("id");
		TestMyxx obj = TestMyxxService.selectOne(id);
		if (null == obj.getTestmyxx_zj())
			return;
		jw.request.setAttribute("TestMyxx", obj);
        jw.request.setAttribute("fl_P", TestMyxxService.selectOne(obj.getTestmyxx_pid()));
		jw.forward("/admin/service/testmyxx/edit.jsp");
	}
//===================查询操作============================= 
   //@system.web.power.ann.SQ("SS") 
    @M("/select/selectOne")
	public void selectOne() {
		String id = jw.getString("id");
		TestMyxx obj = TestMyxxService.selectOne(id);
		if (null == obj.getTestmyxx_zj())
			return;
		jw.request.setAttribute("TestMyxx", obj);
        jw.request.setAttribute("fl_P", TestMyxxService.selectOne(obj.getTestmyxx_pid()));
		jw.forward("/admin/service/testmyxx/one.jsp");
	}

   //@system.web.power.ann.SQ("SS")
    @M("/select/json")
    public static void select(JWeb jw) {
    // jw.printOne(Tool.entityToJSON(DBO.service.S.select(LoufangFL.class, "order by loufangfl_px ASC"))); 如果有排序的话，将loufangfl_px字段替换为你的项目中的字段
        jw.printOne(Tool.entityToJSON(TestMyxxService.select()).replace("\n", "/n"));
    }
   //@system.web.power.ann.SQ("SS")
    @M("/select/json2")
    public static void select2(JWeb jw) {
        jw.printOne(EasyuiService.formatTree(TestMyxxService.select(), "testmyxx_zj", "testmyxx_pid", "testmyxx_name").replace("\n", "/n"));
    }

    //@system.web.power.ann.SQ("SS")
    @M("/select/grid")
    public static void selectUI(JWeb jw) {//_UIGrid
    //如果有某个字段要进行排序,例 以主键=。=
        //jw.printOne(EasyuiService.formatTreeGrid(DBO.service.S.select(TestMyxx.class, "order by testmyxx_zj ASC" ), "testmyxx_zj", "testmyxx_pid", "testmyxx_name"));
        jw.printOne(EasyuiService.formatTreeGrid(TestMyxxService.select(), "testmyxx_zj", "testmyxx_pid", "testmyxx_name").replace("\n", "/n"));
    }

}
