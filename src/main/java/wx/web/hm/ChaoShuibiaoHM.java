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
import wx.web.bean.ChaoShuibiao;
import wx.web.bean.ChaoShuibiaoFengtan;
import wx.web.bean.LoufangFYBZ;
import wx.web.bean.RY;
import wx.web.bean.ZhusuHetong;
import wx.web.service.ChaoShuibiaoService;
import wx.web.service.LoufangFYBZService;
import wx.web.service.ZhusuHetongService;
import wx.xt.Gelibiaoshi;

@H("/service/chaoshuibiao")
public class ChaoShuibiaoHM {

    JWeb jw;

    public ChaoShuibiaoHM(JWeb jw) {
        this.jw = jw;
    }
//===================添加操作=============================    

    @system.web.power.ann.SQ("chaoshuibiaoA")
    @M("/save")
    @Validate({wx.web.validate.ChaoShuibiaoValidate.class})
    public void add() {
        ChaoShuibiao obj = jw.getObject(ChaoShuibiao.class);
        RY ry = Gelibiaoshi.getUserInfoBySession(jw);
        //检出此楼标准费用
        LoufangFYBZ fyObj = LoufangFYBZService.selectOneByLoufang_zj(obj.getChaoshuibiao_loufang_zj());
        if (null == fyObj || null == fyObj.getLoufang_fybz_zj()) {
            jw.printOne(MsgVO.setError("记录表异常：请先建立此楼的【楼房费用标准】。"));
            return;
        }
        if (obj.getChaoshuibiao_riqi2().compareTo(DateService.TO.toDate(LocalDate.now())) > 0) {
            jw.printOne(MsgVO.setError("记录表异常：记录日期超前。"));
            return;
        }
        if (obj.getChaoshuibiao_riqi1().compareTo(obj.getChaoshuibiao_riqi2()) > 0) {
            jw.printOne(MsgVO.setError("记录表异常：上次的记录日期比这次大。"));
            return;
        }
        double shui = obj.getChaoshuibiao_dushu2() - obj.getChaoshuibiao_dushu1();
        if (shui <= 0) {
            jw.printOne(MsgVO.setError("异常：本次抄表读数小于上次读数。本次记录的用水为：" + shui + "吨，"));
            return;
        }
        //上次的抄表情况
        ChaoShuibiao lastObj = ChaoShuibiaoService.selectLastOne(obj.getChaoshuibiao_loufang2_zj());
        if (null == lastObj || null == lastObj.getChaoshuibiao_zj()) {
            obj.setChaoshuibiao_dushu1(0.0);
        } else {
            obj.setChaoshuibiao_dushu1(lastObj.getChaoshuibiao_dushu2());
            obj.setChaoshuibiao_riqi1(lastObj.getChaoshuibiao_riqi2());
        }
        //设置隔离标识
        obj.setChaoshuibiao_gelibiaoshi(ry.getRy_gelibiaoshi());
        //设置分摊的人数——查询审核的合同
        List<ZhusuHetong> zhusuren = ZhusuHetongService.select(obj.getChaoshuibiao_loufang2_zj(), ry.getRy_gelibiaoshi());
        obj.setChaoshuibiao_fentanrenshu(zhusuren.size());
        //已分摊人数锁定为0
        obj.setChaoshuibiao_yj_fentanrenshu(0);
        //设置录单人
        obj.setChaoshuibiao_zhidanshijian(new Date());
        obj.setChaoshuibiao_zhidanren_zj(ry.getRy_zj());
        obj.setChaoshuibiao_zhidanren(ry.getRy_mc());
        //水，水费单价，水金额
        ChaoShuibiaoService.feiyong_shuibiao(obj, shui, fyObj);
        //开始计算分摊
        List<ChaoShuibiaoFengtan> obj2 = ChaoShuibiaoService.feiyong_fentang(obj, zhusuren, fyObj);
        jw.printOne(ChaoShuibiaoService.addOne(obj, obj2));
    }
//===================删除操作=============================    

    @system.web.power.ann.SQ("chaoshuibiaoD")
    @M("/remove")
    public void dellVast() {
        String id = jw.getString("id");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.dellVast(id));
    }
//===================修改操作=============================    

    @system.web.power.ann.SQ("chaoshuibiaoU")
    @M("/update")
    public void update() {
        String id = jw.getString("chaoshuibiao_zj", "");
        Double dushu = jw.getDouble("chaoshuibiao_dushu2");
        if (null == dushu || id.length() != 24) {
            return;
        }
        ChaoShuibiao obj = ChaoShuibiaoService.selectOne(id);
        if (null == obj || ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            jw.printOne(MsgVO.setError("没有找到此楼"));
            return;
        }
        if (obj.getChaoshuibiao_yj_fentanrenshu() > 0) {
            jw.printOne(MsgVO.setError("无法修改,单据已锁定：已经有"+obj.getChaoshuibiao_yj_fentanrenshu()+"个人上交分摊费。"));
            return;
        }
        //调整读数
        obj.setChaoshuibiao_dushu2(dushu);
        //调整读数引起的水值变化
        double shui = obj.getChaoshuibiao_dushu2() - obj.getChaoshuibiao_dushu1();
        if (shui <= 0) {
            jw.printOne(MsgVO.setError("异常：本次抄表读数小于上次读数。本次记录的用水为：" + shui + "吨，"));
            return;
        }
        //检出此楼标准费用
        LoufangFYBZ fyObj = LoufangFYBZService.selectOneByLoufang_zj(obj.getChaoshuibiao_loufang_zj());
        //重新设置：水，水费单价，水金额
        ChaoShuibiaoService.feiyong_shuibiao(obj, shui, fyObj);
        //开始计算分摊
        List<ChaoShuibiaoFengtan> obj2 = ChaoShuibiaoService.feiyong_fentang(obj, null, fyObj);
        jw.printOne(ChaoShuibiaoService.update(obj, obj2));
    }

    @system.web.power.ann.SQ("chaoshuibiaoU")
    @M("/update/select")
    public void updateSelect() {
        String id = jw.getString("id");
        ChaoShuibiao obj = ChaoShuibiaoService.selectOne(id);
        if (null == obj.getChaoshuibiao_zj()) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ChaoShuibiao", obj);
        jw.forward("/admin/service/chaoshuibiao/edit.jsp");
    }
//===================查询操作=============================
    //=========表头查询操作===========

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne")//针对表头的查询-一条记录的明细
    public void selectOne() {
        String id = jw.getString("id");
        ChaoShuibiao obj = ChaoShuibiaoService.selectOne(id);
        if (null == obj.getChaoshuibiao_zj()) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.request.setAttribute("ChaoShuibiao", obj);
        jw.forward("/admin/service/chaoshuibiao/one.jsp");
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/last")//针对表头的查询-一条记录的明细
    public void selectOneLast() {
        String loufang2_zj = jw.getString("loufang2_zj");
        ChaoShuibiao obj = ChaoShuibiaoService.selectLastOne(loufang2_zj);
        if (null == obj || null == obj.getChaoshuibiao_zj()) {
            jw.printOne("{}");
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(obj, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(obj);
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/json")//针对表头的查询-返回json数据
    public static void selectJSON(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "chaoshuibiao_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(Tool.entityToJSON(ChaoShuibiaoService.select(page.getPage(), page.getRows(), condition, page.getOrderBy())));
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/grid")//针对表头的查询-返回Grid数据
    public static void selectGrid(JWeb jw) {
        String condition = wx.xt.service.XTTiaojianService.openConditionByReturnWhere_key(jw, "chaoshuibiao_gelibiaoshi", Gelibiaoshi.getGelibiaoshi(jw));
        Page page = EasyuiService.getPageAndOrderby(jw);
        jw.printOne(EasyuiService.formatGrid(
                ChaoShuibiaoService.select(page.getPage(), page.getRows(), condition, page.getOrderBy()),
                ChaoShuibiaoService.selectCount(condition))
        );
    }

    //=========表体查询操作===========
    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/body")//针对表体的查询-一条记录的明细
    public void selectOneBody() {
        String id = jw.getString("id");
        ChaoShuibiaoFengtan obj = ChaoShuibiaoService.selectOne2(id);
        if (null == obj.getChaoshuibiao_zj()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(obj);
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/bodyJSON")
    public void selectOneBodyJSON() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(Tool.entityToJSON(ChaoShuibiaoService.select2(id)));
    }

    @system.web.power.ann.SQ("chaoshuibiaoS")
    @M("/select/selectOne/bodyGrid")
    public void selectOneBodyGrid() {//针对表体的查询
        String id = jw.getString("pid");
        if (null == id || id.length() < 24) {
            return;
        }
        if (ChaoShuibiaoService.isErrorGelibiaoshiOne(id, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(EasyuiService.formatGrid(ChaoShuibiaoService.select2(id)));
    }

//---------------------------------------单据状态管理---------------------------------------
    @system.web.power.ann.SQ("chaoshuibiaoE")
    @M("/update/examine")//审核单据
    public void examine() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_examine(ids));
    }

    @system.web.power.ann.SQ("chaoshuibiaoUE")
    @M("/update/unexamine")//反审核
    public void unexamine() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_unExamine(ids));
    }

    @system.web.power.ann.SQ("chaoshuibiaoV")
    @M("/update/void")//作废
    public void tovoid() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_void(ids));
    }

    @system.web.power.ann.SQ("chaoshuibiaoUV")
    @M("/update/unvoid")//反作废
    public void untovoid() {
        String ids = jw.getString("ids");
        if (ChaoShuibiaoService.isErrorGelibiaoshiVast(ids, Gelibiaoshi.getGelibiaoshi(jw))) {//存在别人家的隔离标识的单据
            return;
        }
        jw.printOne(ChaoShuibiaoService.updateStyle_unVoid(ids));
    }

}
