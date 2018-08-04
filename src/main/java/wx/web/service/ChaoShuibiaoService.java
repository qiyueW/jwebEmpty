package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.ArrayList;
import java.util.List;
import wx.web.bean.ChaoShuibiao;
import wx.web.bean.ChaoShuibiaoFengtan;
import wx.web.bean.LoufangFYBZ;
import wx.web.bean.ZhusuHetong;
import wx.web.service.vo.ShuiDianVO;

/**
 *
 * @author wangchunzi
 */
final public class ChaoShuibiaoService {

    private static final String TABLE1 = "ChaoShuibiao";
    private static final String PK1 = "chaoshuibiao_zj";
    private static final String STYLE1 = "chaoshuibiao_zt";
    private static final String GE_LI_BIAO_SHI = "chaoshuibiao_gelibiaoshi";
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return ChaoShuibiao
     */
    public static ChaoShuibiao selectOne(String id) {
        return DBO.service.S.selectOneByID(ChaoShuibiao.class, id);
    }

    /**
     * 检查某间房的最后一次抄表的记录
     *
     * @param loufang2_zj
     * @return ChaoShuibiao
     */
    public static ChaoShuibiao selectLastOne(String loufang2_zj) {
        return DBO.service.S.selectOneByCondition(ChaoShuibiao.class,
                "WHERE chaoshuibiao_loufang2_zj='" + loufang2_zj + "' ORDER BY chaoshuibiao_riqi2 DESC, chaoshuibiao_dushu2 DESC");
    }

    /**
     * 检出一条记录(表体)
     *
     * @param id 表体主键
     * @return ChaoShuibiaoFengtan
     */
    public static ChaoShuibiaoFengtan selectOne2(String id) {
        return DBO.service.S.selectOneByID(ChaoShuibiaoFengtan.class, id);
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
    public static List<ChaoShuibiao> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(ChaoShuibiao.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

    /**
     * 检出表体数据 根据表头主键
     *
     * @param pid 表头的主键
     * @return List
     */
    public static List<ChaoShuibiaoFengtan> select2(String pid) {
        return DBO.service.S.selectByCondition(ChaoShuibiaoFengtan.class, "WHERE " + PK1 + " IN('" + pid + "')");
    }

    /**
     * 取得更新纳费时间的sql语句。(只语句紧更新时间)
     *
     * @param cdbf
     * @return
     */
    public static String getUpdateSQL_nfsj(ChaoShuibiaoFengtan cdbf) {
        return DBO.service.SQL.updateSome_alloy(cdbf, "chaoshuibiaofengtan_nfsj");
    }

    /**
     * 找出所有未纳费人的（注意：无视隔离标识）
     *
     * @param ry_zj
     * @return
     */
    public static List<ChaoShuibiaoFengtan> select_feiyong(String ry_zj) {
        return Tool.isEmpty(ry_zj)
                ? DBO.service.S.selectByCondition(ChaoShuibiaoFengtan.class, "WHERE chaoshuibiaofengtan_nfsj IS NULL")
                : DBO.service.S.selectByCondition(ChaoShuibiaoFengtan.class, "WHERE chaoshuibiaofengtan_nfsj IS NULL AND chaoshuibiaofengtan_nfr_zj='" + ry_zj + "'");
    }

    public static String getSQL_update_feiyong_nfsj(String date, String ids) {
        if (Tool.isEmpty(ids)) {
            return "";
        }
        if (Tool.isEmpty(date)) {
            return "UPDATE ChaoShuibiaoFengtan SET chaoshuibiaofengtan_nfsj=null WHERE chaoshuibiaofengtan_zj IN(" + Tool.replaceDToDDD(ids) + ")";
        }
        return "UPDATE ChaoShuibiaoFengtan SET chaoshuibiaofengtan_nfsj='" + date + "' WHERE chaoshuibiaofengtan_zj IN(" + Tool.replaceDToDDD(ids) + ")";
    }
//---------------------------------------统计区--------------------------------------

    public static ShuiDianVO tj_feiyong(List<ChaoShuibiaoFengtan> list, String ry_zj) {
        double x = 0D;
        StringBuilder sb = new StringBuilder();
        for (ChaoShuibiaoFengtan obj : list) {
            if (obj.getChaoshuibiaofengtan_nfr_zj().equals(ry_zj)) {
                x = x + obj.getChaoshuibiaofengtan_feiyong();
                sb.append(",").append(obj.getChaoshuibiaofengtan_zj());
            }
        }
        return new ShuiDianVO(x, sb.length() == 0 ? "" : sb.substring(1));
    }

    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(ChaoShuibiao.class) : DBO.service.S.selectCountByCondition(ChaoShuibiao.class, where);
    }

    /**
     * 计算水表的费用(水，水费单价，水金额)
     *
     * @param obj
     * @param shui
     * @param fyObj
     */
    public static void feiyong_shuibiao(ChaoShuibiao obj, double shui, LoufangFYBZ fyObj) {
        obj.setChaoshuibiao_shui(shui);
        obj.setChaoshuibiao_shui_danjia(fyObj.getLoufang_fybz_shuifei());
        obj.setChaoshuibiao_shui_jine(fyObj.getLoufang_fybz_shuifei() * obj.getChaoshuibiao_shui());
    }

    public static List<ChaoShuibiaoFengtan> feiyong_fentang(ChaoShuibiao obj, List<ZhusuHetong> zhusuren, LoufangFYBZ fyObj) {
        List<ChaoShuibiaoFengtan> obj2;
        ChaoShuibiaoFengtan obj2sm;
        int countDay = 0;
        int myCountDay;
        if (null != zhusuren) {//表示新增，从合同中取出人数
            obj2 = new ArrayList<>();
            for (ZhusuHetong zhobj : zhusuren) {
                obj2sm = new ChaoShuibiaoFengtan();
                //分摊的纳费人
                obj2sm.setChaoshuibiaofengtan_nfr(zhobj.getZhusuhetong_qianyueren());
                obj2sm.setChaoshuibiaofengtan_nfr_zj(zhobj.getZhusuhetong_qianyueren_zj());
                //写入本房的水单价
                obj2sm.setChaoshuibiaofengtan_shui_danjia(fyObj.getLoufang_fybz_shuifei());
                //本人占用了几天
                myCountDay = ZhusuHetongService.getMyUserData(zhobj, obj.getChaoshuibiao_riqi1(), obj.getChaoshuibiao_riqi2());
                countDay = countDay + myCountDay;//累计天数，用于一会的费用分摊
                obj2sm.setChaoshuibiaofengtan_zhanyongtian(myCountDay);
                obj2.add(obj2sm);
            }
        } else {//表示更新，从旧记录中取出数据
            obj2 = select2(obj.getChaoshuibiao_zj());
        }
//        for (ChaoShuibiaoFengtan cbobj : obj2) {
//            countDay = countDay + cbobj.getChaoshuibiaofengtan_zhanyongtian();
//        }
        double ft_zyb_shui = obj.getChaoshuibiao_shui() / countDay;//分摊，每1份天，占用的水
        for (ChaoShuibiaoFengtan cbobj : obj2) {
            //分到的水
            cbobj.setChaoshuibiaofengtan_shui(ft_zyb_shui * cbobj.getChaoshuibiaofengtan_zhanyongtian());
            //计算水的费用
            cbobj.setChaoshuibiaofengtan_feiyong(cbobj.getChaoshuibiaofengtan_shui() * cbobj.getChaoshuibiaofengtan_shui_danjia());
        }
        return obj2;
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj 1方
     * @param list 多方
     * @return MsgVO
     */
    public static MsgVO addOne(ChaoShuibiao obj, List<ChaoShuibiaoFengtan> list) {
        obj.setChaoshuibiao_zt(0);
        if (null == list || list.isEmpty()) {
            return DBO.service.A.addOne(obj) > 0 ? MsgVO.setOK("记录成功!") : MsgVO.setNotOK("抄表异常：记录失败");
        }
        int[] i = DBO.service.A.add_OM(obj, list);
        if (null == i) {
            return MsgVO.setError("添加异常,请通知管理检查后台数据库连接是否异常。");
        }
        return MsgVO.setAddRS(i[0]);
    }

    /**
     * 删除指定数据。
     *
     * @param ids
     * @return
     */
    public static MsgVO dellVast(String ids) {
        if (DBO.service.S.selectCountByCondition(ChaoShuibiao.class, "WHERE chaoshuibiao_zt<>0 AND chaoshuibiao_zj IN(" + Tool.replaceDToDDD(ids) + ")") > 0) {
            return MsgVO.setError("选择的单据中存在锁定的单据，无法删除");
        }
        return MsgVO.setDellRS(DBO.service.D.ooDelete(ids, ChaoShuibiao.class, ChaoShuibiaoFengtan.class));
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
    public static MsgVO update(ChaoShuibiao obj, List<ChaoShuibiaoFengtan> list) {
        if (selectOne(obj.getChaoshuibiao_zj()).getChaoshuibiao_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        String alloyUpdate = "chaoshuibiao_dushu2,chaoshuibiao_shui,chaoshuibiao_shui_danjia,chaoshuibiao_shui_jine";
        if (null == list || list.isEmpty()) {
            return MsgVO.setUpdateRS(DBO.service.U.updateSome_alloy(obj, alloyUpdate));
        }
        int[] i = DBO.service.ADUS.executeBatch(
                //读数,水(吨) ,水单价 ,金额
                DBO.service.SQL.updateSome_alloy(obj, alloyUpdate)//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(ChaoShuibiaoFengtan.class, "WHERE chaoshuibiao_zj='" + obj.getChaoshuibiao_zj() + "'")//清空旧表体的值
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

//---------------------------------------隔离标识管理--------------------------------------
    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<ChaoShuibiao> list = DBO.service.S.selectByCondition(ChaoShuibiao.class, "WHERE chaoshuibiao_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiVast(List<ChaoShuibiao> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        ChaoShuibiao obj = DBO.service.S.selectOneByID(ChaoShuibiao.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(ChaoShuibiao obj, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

}
