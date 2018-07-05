package wx.xt.hm.xtjuesequanxian;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.Tool;
import java.util.List;
import java.util.Set;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import wx.xt.bean.xtjuese.XtJuese;
import wx.xt.service.XTJueseQuanxianService;
import wx.xt.service.XtJueseService;

@H("/xt/xtjuesequanxian")
public class XtJueseQuanxianHM {

    JWeb jw;

    public XtJueseQuanxianHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    
    //@system.web.power.ann.SQ("xtjueseA")

    @M("/setpower")
    public void add() {
        String juese_zjs = jw.getString("juese_zj", "");
        String quanxian = jw.getString("quanxian", "");
        XtGuanliyuan admin = Gelibiaoshi.getAdminInfoBySession(jw);
        if (juese_zjs.trim().isEmpty()) {
            return;
        }
        List<XtJuese> list = XtJueseService.select("WHERE xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zjs) + ")");
        //其他一些预定值设置
        jw.printOne(XTJueseQuanxianService.setPower(list, juese_zjs, quanxian, admin.getXt_guanliyuan_zj()));
    }

//===================查询操作============================= 
    @M("/select/json")
    public static void select(JWeb jw) {//_UIGrid
        String x = jw.getString("juese_zj");
        Set<String> obj = XTJueseQuanxianService.selectByJuese(x);
        StringBuilder sb = new StringBuilder();
        for (String str : obj) {
            sb.append(",").append(str);
        }
        jw.printOne(sb.length() > 0 ? sb.substring(1) : "");
    }
//---------------------------------------单据状态管理---------------------------------------
}
