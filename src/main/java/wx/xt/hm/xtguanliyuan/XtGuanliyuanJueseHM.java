package wx.xt.hm.xtguanliyuan;

import configuration.MsgVO;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import wx.xt.Gelibiaoshi;
import wx.xt.bean.xtguanliyuan.XtGuanliyuanJuese;
import wx.xt.service.XtGuanliyuanJueseService;

/**
 * <br>
 * 总管专用
 */
@H("/xt/xtguanliyuan2/juese")
public class XtGuanliyuanJueseHM {

    JWeb jw;

    public XtGuanliyuanJueseHM(JWeb jw) {
        this.jw = jw;
    }
//===================修改操作=============================    

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuanjueseAUD")
    @M("/adu")
    @Validate(wx.xt.validate.XtGuanliyuanJueseValidate.class)
    public void adu() {
        XtGuanliyuanJuese obj = jw.getObject(XtGuanliyuanJuese.class);
        if (null == obj.getXt_guanliyuan_zj() || obj.getXt_guanliyuan_zj().length() != 24) {
            return;
        }
        XtGuanliyuanJuese admin = XtGuanliyuanJueseService.selectOneByGuanliyuanZJ(obj.getXt_guanliyuan_zj());
        if (null == admin || null == admin.getXt_guanliyuan_zj()) {//后台还没有记录，执行添加操作。
            if (null == obj.getXt_juese_zj() || obj.getXt_juese_zj().isEmpty()) {
                jw.printOne(MsgVO.setNotOK("此管理员没有可取消的角色。"));
                return;
            }
            //进行隔离标识的绑定。
            obj.setXt_guanliyuanjuese_gelibiaoshi(Gelibiaoshi.getGelibiaoshiAdmin(jw));
            //添加新的管理员绑定。
            jw.printOne(XtGuanliyuanJueseService.addOne(obj));
            return;
        }
        obj.setXt_guanliyuanjuese_zj(admin.getXt_guanliyuanjuese_zj());
        //已经存在记录，执行修改操作。
        jw.printOne(XtGuanliyuanJueseService.update(obj));
    }
//===================查询操作=============================

    @system.web.power.ann.ZDY(zdy = configuration.zdy.SQ_Admin2.class, value = "xtguanliyuanjueseAUD")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String x = jw.getString("id", "");
        if (x.isEmpty()) {
            return;
        }
        jw.printOne(XtGuanliyuanJueseService.selectOneByGuanliyuanZJ(x));
    }
}
