package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.MsgVO;
import java.util.List;
import configuration.WebConfigModel;
import configuration.Tool;
import plugins.easyui.EasyuiService;
import java.util.Date;import wx.web.bean.RY;
import wx.web.service.RYService;


/**
*1.添加请求路径：/base/ry/save.jw <br>
*2.删除请求路径（传参：id）：/base/ry/remove.jw <br>
*3.修改 <br>
*   3.1变更请求路径：/base/ry/update.jw <br>
*   3.2查询请求路径(通过表头主键id，请求表头数据)：/base/ry/update/select.jw <br>
*   3.3查询请求路径：/base/ry/update/select/grid.jw <br>
*4.查询 <br>
*   4.1全部请求路径（对象实例。通过主键传参：id）：/base/ry/select/selectOne.jw <br>
*   4.2全部请求路径（分页查询-JSON格式）：/base/ry/select/json.jw <br>
*   4.3全部请求路径（分页查询-GRID格式）：/base/ry/select/grid.jw <br>
*   4.3全部请求路径(通过表体主键id，请求表体一条记录)：/base/ry/select/selectOne/body.jw <br>
*   4.4全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/ry/select/selectOne/bodyJSON.jw <br>
*   4.5全部请求路径(修改与查询明细共用。通过表头主键传参pid，请求表体关联的数据)：/base/ry/select/selectOne/bodyGrid.jw <br>
*6.上传管理 <br>
*   6.2文件上传请求路径   ：/base/ry/up/file.jw <br>
*/
@H("/base/ry")
public class RYHM {

    JWeb jw;

    public RYHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("BA")
    @M("/save")
    @Validate(wx.web.validate.RYValidate.class)
    public void add() {
        RY obj = jw.getObject(RY.class);
        jw.printOne(RYService.addOne(obj));
    }
//===================删除操作=============================    
    //@system.web.power.ann.SQ("BD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() != 24) {
            return;
        }
        jw.printOne(RYService.dellOne(id));
    }
//===================修改操作=============================    
    //@system.web.power.ann.SQ("BU")
    @M("/update")
    @Validate(wx.web.validate.RYValidate.class)
	public void update() {
		RY obj = jw.getObject(RY.class);
		if (null == obj.getRy_zj() || obj.getRy_zj().length() != 24)
			return;
        jw.printOne(RYService.update(obj));
	}
    //@system.web.power.ann.SQ("BU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        RY obj =  RYService.selectOne(id);
        if (null == obj.getRy_zj()) {
            return;
        }
        jw.request.setAttribute("RY", obj);
        jw.forward("/admin/base/ry/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

   //@system.web.power.ann.SQ("BS") 
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
	public void selectOne() {
		String id = jw.getString("id");
		RY obj = RYService.selectOne(id);
		if (null == obj.getRy_zj())
			return;
		jw.request.setAttribute("RY", obj);
		jw.forward("/admin/base/ry/one.jsp");
	}

   //@system.web.power.ann.SQ("BS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String x = jw.getString("key");
        String condition = wx.xt.service.XTTiaojianService.engineToSQLCondition(x);
        if (condition.length() > 0) {
            condition = "WHERE " + condition;
        }
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(RYService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

   //@system.web.power.ann.SQ("BS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = "";
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
            RYService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
            RYService.selectCount(condition))
        );
    }

//---------------------------------------文件图片管理---------------------------------------
    //@system.web.power.ann.SQ("BA")
    @M("/up/file")//文件上传
    public void upfile() {
        jw.printOne(RYService.upOneFile(jw.request));
    }
}
