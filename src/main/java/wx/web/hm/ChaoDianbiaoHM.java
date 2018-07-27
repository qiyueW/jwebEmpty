package wx.web.hm;

import configuration.Page;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.MsgVO;
import java.util.List;
import configuration.Tool;
import java.time.LocalDate;
import plugins.easyui.EasyuiService;
import java.util.Date;
import system.base.date.DateService;
import wx.web.bean.ChaoDianbiao;
import wx.web.bean.ChaoDianbiaoFengtan;
import wx.web.bean.LoufangFYBZ;
import wx.web.bean.RY;
import wx.web.bean.ZhusuHetong;
import wx.web.service.ChaoDianbiaoService;
import wx.web.service.LoufangFYBZService;
import wx.web.service.ZhusuHetongService;
import wx.xt.Gelibiaoshi;

@H("/service/chaodianbiao")
public class ChaoDianbiaoHM {

    JWeb jw;

    public ChaoDianbiaoHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("chaodianbiaoA")
    @M("/save")
    @Validate({wx.web.validate.ChaoDianbiaoValidate.class})
    public void add() {
        ChaoDianbiao obj = jw.getObject(ChaoDianbiao.class);
        RY ry = Gelibiaoshi.getUserInfoBySession(jw);
        //检出此楼标准费用
        LoufangFYBZ fyObj = LoufangFYBZService.selectOneByLoufang_zj(obj.getChaodianbiao_loufang_zj());
        if (null == fyObj || null == fyObj.getLoufang_fybz_zj()) {
            jw.printOne(MsgVO.setError("记录表异常：请先建立此楼的【楼房费用标准】。"));
            return;
        }
        if (obj.getChaodianbiao_riqi2().compareTo(DateService.TO.toDate(LocalDate.now())) > 0) {
            jw.printOne(MsgVO.setError("记录表异常：记录日期超前。"));
            return;
        }
        if (obj.getChaodianbiao_riqi1().compareTo(obj.getChaodianbiao_riqi2()) > 0) {
            jw.printOne(MsgVO.setError("记录表异常：上次的记录日期比这次大。"));
            return;
        }
        double dian = obj.getChaodianbiao_dushu2() - obj.getChaodianbiao_dushu1();
        if (dian <= 0) {
            jw.printOne(MsgVO.setError("异常：本次抄表读数小于上次读数。本次记录的用水为：" + dian + "吨，"));
            return;
        }
        //上次的抄表情况
        ChaoDianbiao lastObj = ChaoDianbiaoService.selectLastOne(obj.getChaodianbiao_loufang2_zj());
        if (null == lastObj || null == lastObj.getChaodianbiao_zj()) {
            obj.setChaodianbiao_dushu1(0.0);
        } else {
            obj.setChaodianbiao_dushu1(lastObj.getChaodianbiao_dushu2());
            obj.setChaodianbiao_riqi1(lastObj.getChaodianbiao_riqi2());
        }
        //设置隔离标识
        obj.setChaodianbiao_gelibiaoshi(ry.getRy_gelibiaoshi());
        //设置分摊的人数——查询审核的合同
        List<ZhusuHetong> zhusuren = ZhusuHetongService.select(obj.getChaodianbiao_loufang2_zj(), ry.getRy_gelibiaoshi());
        obj.setChaodianbiao_fentanrenshu(zhusuren.size());
        //已分摊人数锁定为0
        obj.setChaodianbiao_yj_fentanrenshu(0);
        //设置录单人
        obj.setChaodianbiao_zhidanshijian(new Date());
        obj.setChaodianbiao_zhidanren_zj(ry.getRy_zj());
        obj.setChaodianbiao_zhidanren(ry.getRy_mc());
        //水，水费单价，水金额
        ChaoDianbiaoService.feiyong_dianbiao(obj, dian, fyObj);
        //开始计算分摊
        List<ChaoDianbiaoFengtan> obj2 = ChaoDianbiaoService.feiyong_fentang(obj, zhusuren, fyObj);
        jw.printOne(ChaoDianbiaoService.addOne(obj, obj2));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("chaodianbiaoD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoDianbiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoDianbiaoService.dellVast(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("chaodianbiaoU")
    @M("/update")
    public void update() {
        String id = jw.getString("chaodianbiao_zj", "");
        Double dushu = jw.getDouble("chaodianbiao_dushu2");
        if (null == dushu || id.length() != 24) {
            return;
        }
        ChaoDianbiao obj = ChaoDianbiaoService.selectOne(id);
        if (null == obj || ChaoDianbiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            jw.printOne(MsgVO.setError("没有找到此楼"));
            return;
        }
        if (obj.getChaodianbiao_yj_fentanrenshu() > 0) {
            jw.printOne(MsgVO.setError("无法修改,单据已锁定：已经有"+obj.getChaodianbiao_yj_fentanrenshu()+"个人上交分摊费。"));
            return;
        }
        //调整读数
        obj.setChaodianbiao_dushu2(dushu);
        //调整读数引起的水值变化
        double dian = obj.getChaodianbiao_dushu2() - obj.getChaodianbiao_dushu1();
        if (dian <= 0) {
            jw.printOne(MsgVO.setError("异常：本次抄表读数小于上次读数。本次记录的用水为：" + dian + "吨，"));
            return;
        }
        //检出此楼标准费用
        LoufangFYBZ fyObj = LoufangFYBZService.selectOneByLoufang_zj(obj.getChaodianbiao_loufang_zj());
        //重新设置：水，水费单价，水金额
        ChaoDianbiaoService.feiyong_dianbiao(obj, dian, fyObj);
        //开始计算分摊
        List<ChaoDianbiaoFengtan> obj2 = ChaoDianbiaoService.feiyong_fentang(obj, null, fyObj);
        jw.printOne(ChaoDianbiaoService.update(obj, obj2));
    }

    @system.web.power.ann.SQ("chaodianbiaoU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        ChaoDianbiao obj = ChaoDianbiaoService.selectOne(id);
        if (null == obj.getChaodianbiao_zj()) {
            return;
        }
        if (ChaoDianbiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ChaoDianbiao", obj);
        jw.forward("/admin/service/chaodianbiao/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        ChaoDianbiao obj = ChaoDianbiaoService.selectOne(id);
        if (null == obj.getChaodianbiao_zj()) {
            return;
        }
        if (ChaoDianbiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ChaoDianbiao", obj);
        jw.forward("/admin/service/chaodianbiao/one.jsp");
    }

    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/selectOne/last")//针对表头的查询-一条记录的明细
    public void selectOneLast() {
        String loufang2_zj = jw.getString("loufang2_zj");
        ChaoDianbiao obj = ChaoDianbiaoService.selectLastOne(loufang2_zj);
        if (null == obj || null == obj.getChaodianbiao_zj()) {
            jw.printOne("{}");
            return;
        }
        if (ChaoDianbiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(obj);
    }

    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "chaodianbiao_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(ChaoDianbiaoService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "chaodianbiao_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                ChaoDianbiaoService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                ChaoDianbiaoService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        ChaoDianbiaoFengtan obj = ChaoDianbiaoService.selectOne2(id);
        if (null == obj.getChaodianbiao_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoDianbiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(Tool.entityToJSON(ChaoDianbiaoService.select2(id)));
    }

    @system.web.power.ann.SQ("chaodianbiaoS")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoDianbiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(EasyuiService.formatGrid(ChaoDianbiaoService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @system.web.power.ann.SQ("chaodianbiaoE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (ChaoDianbiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoDianbiaoService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("chaodianbiaoUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (ChaoDianbiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoDianbiaoService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("chaodianbiaoV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (ChaoDianbiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoDianbiaoService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("chaodianbiaoUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (ChaoDianbiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoDianbiaoService.updateStyle_unVoid(ids));
    }

}
