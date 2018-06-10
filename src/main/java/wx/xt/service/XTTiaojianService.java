package wx.xt.service;

import com.alibaba.fastjson.JSON;
import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import system.base.date.DateService;
import wx.xt.bean.xtshezhitiaojian.XTShezhiTiaojian;

import wx.xt.bean.xttiaojian.XTTiaojian;
import wx.xt.bean.xttiaojian.XTTiaojian1;

/**
 *
 * @author wangchunzi
 */
final public class XTTiaojianService {

    private static final String TABLE1 = "XTTiaojian";
    private static final String PK1 = "xt_tiaojian_zj";
    private static final String STYLE1 = "xt_tiaojian_zt";

//---------------------------------------查询---------------------------------------
    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return XTTiaojian
     */
    public static XTTiaojian selectOne(String id) {
        return DBO.service.S.selectOneByID(XTTiaojian.class, id);
    }

    /**
     * 检出一条记录(表体)
     *
     * @param id 表体主键
     * @return XTTiaojian1
     */
    public static XTTiaojian1 selectOne2(String id) {
        return DBO.service.S.selectOneByID(XTTiaojian1.class, id);
    }

    /**
     * 检出表头数据
     *
     * @param page 页码
     * @param size 多少页
     * @param where 条件
     * @param ordery 排序
     * @return List 表头集合
     */
    public static List<XTTiaojian> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(XTTiaojian.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

    /**
     * 检出表头数据
     *
     * @param gelibiaoshi
     * @param ry_zj
     * @param mokuaizhi
     * @return List 表头集合
     */
    public static List<XTTiaojian> selectByRy(String gelibiaoshi, String ry_zj, String mokuaizhi) {
        gelibiaoshi = null == gelibiaoshi || gelibiaoshi.isEmpty() ? "" : "xt_tiaojian_gelibiaoshi='" + gelibiaoshi + "' AND";
//        System.out.println("WHERE " + gelibiaoshi + " xt_shezhi_tiaojian_zhi='" + mokuaizhi + "' AND (xt_tiaojian_zt=" + BaseService.SHENHE + " OR xt_tiaojian_zhidanren_zj='" + ry_zj + "')");
        //审核状态或者自己添加的方案
        return DBO.service.S.selectByCondition(XTTiaojian.class,
                //隔离标识+模块代码的条件下，找出人员自己的条件方案或公共方案
                "WHERE " + gelibiaoshi + " xt_shezhi_tiaojian_zhi='" + mokuaizhi + "' AND (xt_tiaojian_zt=" + BaseService.SHENHE + " OR xt_tiaojian_zhidanren_zj='" + ry_zj + "')");
    }

    /**
     * 检出表体数据 根据表头主键
     *
     * @param pid 表头的主键
     * @return List
     */
    public static List<XTTiaojian1> select2(String pid) {
        return DBO.service.S.selectByCondition(XTTiaojian1.class, "WHERE " + PK1 + " IN('" + pid + "')");
    }
//---------------------------------------统计区--------------------------------------

    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(XTTiaojian.class) : DBO.service.S.selectCountByCondition(XTTiaojian.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj 1方
     * @param list 多方
     * @return MsgVO
     */
    public static MsgVO addOne(XTTiaojian obj, List<XTTiaojian1> list) {
//        if (DBO.service.S.selectCountByCondition(XTTiaojian .class, "WHERE xt_tiaojian_mc='"+obj.getXt_tiaojian_mc()+"'") > 0) {
//            return MsgVO.setError("添加异常,条件方案名称当中，存有不唯一的。请调整后再试");
//        }
        XTShezhiTiaojian hobj = XTShezhiTiaojianService.selectOneByHeadCode(obj.getXt_shezhi_tiaojian_zhi());
        if (null == hobj || null == hobj.getXt_shezhi_tiaojian_zj()) {
            return MsgVO.setError("添加异常,无法绑定指定的模块");
        }
        obj.setXt_shezhi_tiaojian_zj(hobj.getXt_shezhi_tiaojian_zj());
        obj.setXt_shezhi_tiaojian_mc(hobj.getXt_shezhi_tiaojian_mc());
        obj.setXt_tiaojian_zt(0);

        int[] i = DBO.service.A.add_OM(obj, list);
        if (null == i) {
            return MsgVO.setError("添加异常,请通知管理检查后台数据库连接是否异常。");
        }
        return MsgVO.setAddRS(i[0]);
    }

    /**
     * 删除指定数据。
     *
     * @param id
     * @return
     */
    public static MsgVO dellOne(String id) {
        return MsgVO.setDellRS(DBO.service.D.ooDelete(id, XTTiaojian.class, XTTiaojian1.class));
    }

    /**
     * 删除指定数据。
     *
     * @param ids
     * @return
     */
    public static MsgVO dellVast(String ids) {
        if (DBO.service.S.selectCountByCondition(XTTiaojian.class, "WHERE xt_tiaojian_zt<>0 AND xt_tiaojian_zj IN(" + Tool.replaceDToDDD(ids) + ")") > 0) {
            return MsgVO.setError("选择的单据中存在锁定的单据，无法删除");
        }
        return MsgVO.setDellRS(DBO.service.D.ooDelete(ids, XTTiaojian.class, XTTiaojian1.class));
    }

    /**
     * 修改 一条记录（一个表头，多个表体。即一对多表）<br>
     * 本方法采用删除旧表体的方法，强烈建议反审核时，此单一定是没有其他引用才可以反审，反审后才能修改。<br>
     * 否则，如果其他单据有引用表体的id的话，此单某部分数据结构就会失去关联
     *
     * @param obj 表头对象
     * @param list 表体集合
     * @return MsgVO
     */
    public static MsgVO update(XTTiaojian obj, List<XTTiaojian1> list) {
        if (null == obj.getXt_tiaojian_zj() || obj.getXt_tiaojian_zj().length() != 24) {
            return MsgVO.setError("修改异常,表头信息丢失，请退出修改界面后，重新操作");
        }
//        if (DBO.service.S.selectCountByCondition(XTTiaojian.class, "WHERE xt_tiaojian_zj<>'" + obj.getXt_tiaojian_zj() + "' AND (xt_tiaojian_mc='" + obj.getXt_tiaojian_mc() + "')") > 0) {
//            return MsgVO.setError("修改异常,条件方案名称当中，存有不唯一的。请调整后再试");
//        }
        if (selectOne(obj.getXt_tiaojian_zj()).getXt_tiaojian_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        int[] i = DBO.service.ADUS.executeBatch(
                //xt_tiaojian_zt
                DBO.service.SQL.updateSome_alloy(obj, "xt_tiaojian_mc")//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(XTTiaojian1.class, "WHERE xt_tiaojian_zj='" + obj.getXt_tiaojian_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(list)//加入新表体的值
        );
        if (null == i) {
            return MsgVO.setError("修改操作异常。请通知管理查询服务器日志");
        }
        return MsgVO.setUpdateRS(i[0]);
    }

//---------------------------------------单据状态管理---------------------------------------
    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, TABLE1, PK1, STYLE1);
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, TABLE1, PK1, STYLE1);
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, TABLE1, PK1, STYLE1);
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, TABLE1, PK1, STYLE1);
    }
//---------------------------------------交互区---------------------------------------

    public static String engineToSQLCondition(String json) {
        if (null == json) {
            return "";
        }
        List<XTTiaojian1> list1 = JSON.parseArray(
                json.replace("（", "(").replace("）", ")").replace("'", "")
                , XTTiaojian1.class);
        if (null == list1 || list1.isEmpty()) {
            return "";
        }
        list1.get(0).setXt_tiaojian1_lianjiefu("");
        StringBuilder sb = new StringBuilder();
        for (XTTiaojian1 obj : list1) {
            sb.append(toFormatOne(obj));
        }
        return sb.toString();
    }

    private static String toFormatOne(XTTiaojian1 obj) {
        if (null == obj.getXt_shezhi_tiaojian1_zhi() || obj.getXt_shezhi_tiaojian1_zhi().isEmpty()) {
            return obj.getXt_tiaojian1_kuohao();
        }
        if (obj.getXt_tiaojian1_zhi().endsWith("天内")) {
            String mydate = obj.getXt_tiaojian1_zhi().replace("天内", "");
            if (Tool.isNumeric(mydate)) {
                int d = Integer.parseInt(mydate);
                LocalDate now = LocalDate.now();
                LocalDate start = now.minusDays(d > 0 ? d - 1 : 0);
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " BETWEEN '" + start.format(df) + "' AND '" + now.format(df) + " 23:59:59' ";
            }
        }
        switch (obj.getXt_tiaojian1_zhi()) {
            case "当天时间":
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " BETWEEN '" + DateService.getDate(new Date(), "yyyy-MM-dd")
                        + "' AND '" + DateService.getDate(new Date(), "yyyy-MM-dd") + " 23:59:59' ";
            case "本月":
                String[] date = DateService.SCOPE.currentMonth1_End("yyyy-MM-dd");
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " BETWEEN '" + date[0] + "' AND '" + date[1] + "'";
            case "本月时间":
                String[] date1 = DateService.SCOPE.currentMonth1_End("yyyy-MM-dd");
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " BETWEEN '" + date1[0] + "' AND '" + date1[1] + " 23:59:59' ";
        }

        switch (obj.getXt_tiaojian1_panduan()) {
            case "LIKE%": {
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " LIKE '" + defaultValue(obj.getXt_tiaojian1_zhi()) + "%' ";
            }
            case "%LIKE%": {
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " LIKE '%" + defaultValue(obj.getXt_tiaojian1_zhi()) + "%' ";
            }
            case "%LIKE": {
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " LIKE '%" + defaultValue(obj.getXt_tiaojian1_zhi()) + "' ";
            }
            case "IN": {
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " IN('" + defaultValue(obj.getXt_tiaojian1_zhi()) + "')";
            }
            default: {// = <> > < >= <=
                return obj.getXt_tiaojian1_kuohao() + obj.getXt_tiaojian1_lianjiefu()
                        + " " + obj.getXt_shezhi_tiaojian1_zhi() + " " + obj.getXt_tiaojian1_panduan() + " '" + defaultValue(obj.getXt_tiaojian1_zhi()) + "' ";
            }
        }
    }

    private static String defaultValue(String str) {
        if (null == str) {
            return "";
        }
        switch (str) {
            case "当天":
                return DateService.getDate(new Date(), "yyyy-MM-dd");
//            case "当天时间":
//                return DateService.getDate(new Date(), "yyyy-MM-dd") + " 23:59:59";
            case "保存":
            case "新增":
                return "" + BaseService.XINZENG;
            case "通过":
            case "审核":
                return "" + BaseService.SHENHE;
            case "作废":
                return "" + BaseService.ZUOFEI;
            case "锁定":
                return "" + BaseService.SUODING;
            case "流程":
                return "" + BaseService.LIUCHENG;
        }
        return str;
    }
}
