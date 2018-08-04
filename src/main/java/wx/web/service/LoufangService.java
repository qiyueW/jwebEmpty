package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.List;

import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;
import wx.web.bean.ZhusuHetong;
import wx.web.service.vo.FangHTVO;

/**
 *
 * @author wangchunzi
 */
final public class LoufangService {

    private static final String TABLE1 = "Loufang";
    private static final String PK1 = "loufang_zj";
    private static final String STYLE1 = "loufang_zt";
    private static final String GE_LI_BIAO_SHI = "loufang_gelibiaoshi";
    public static final String FANGJIAN_LX_DANJIAN = "单间";
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return Loufang
     */
    public static Loufang selectOne(String id) {
        return DBO.service.S.selectOneByID(Loufang.class, id);
    }

    /**
     * 检出一条记录(表体)
     *
     * @param id 表体主键
     * @return Loufang2
     */
    public static Loufang2 selectOne2(String id) {
        return DBO.service.S.selectOneByID(Loufang2.class, id);
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
    public static List<Loufang> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(Loufang.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

    public static List<Loufang> select(String GLBS) {
        return DBO.service.S.selectByCondition(Loufang.class, "WHERE loufang_gelibiaoshi='" + GLBS + "'");
    }

    public static List<Loufang> selectCanUse(String GLBS) {
        return DBO.service.S.selectByCondition(Loufang.class, "WHERE loufang_gelibiaoshi='" + GLBS + "' AND (loufang_danjian_chuangwei>loufang_danjian_chuangwei2 OR loufang_taojian_chuangwei>loufang_taojian_chuangwei2)");
    }

    /**
     * 检出表体数据 根据表头主键
     *
     * @param pid 表头的主键
     * @return List
     */
    public static List<Loufang2> select2(String pid) {
        return DBO.service.S.selectByCondition(Loufang2.class, "WHERE " + PK1 + " IN('" + pid + "')");
    }

    /**
     * 通过指定楼，房单编号，隔离标识
     *
     * @param loufang_zj 通过指定楼的主键
     * @param bianma 房单编号
     * @param gelibiaoshi 隔离标识
     * @return
     */
    public static Loufang2 select2One(String loufang_zj, String bianma, String gelibiaoshi) {
        return DBO.service.S.selectOneByCondition(Loufang2.class,
                "loufang_zj='" + loufang_zj + "' AND loufang2_bianhao='" + bianma + "' AND loufang2_gelibiaoshi='" + gelibiaoshi + "'"
        );
    }
//---------------------------------------统计区--------------------------------------

    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(Loufang.class) : DBO.service.S.selectCountByCondition(Loufang.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj 1方
     * @param list 多方
     * @return MsgVO
     */
    public static MsgVO addOne(Loufang obj, List<Loufang2> list) {
        plugins.Table<Loufang2> table = new plugins.Table(list);
        if (!table.isUnique("loufang2_bianhao")) {
            return MsgVO.setError("添加异常,表体编号不唯一，请调整后再试");
        }
        obj.setLoufang_zt(0);

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
        if (DBO.service.S.selectCountByCondition(Loufang.class, "WHERE loufang_zt<>0 AND loufang_zj IN(" + Tool.replaceDToDDD(ids) + ")") > 0) {
            return MsgVO.setError("选择的单据中存在锁定的单据，无法删除");
        }
        return MsgVO.setDellRS(DBO.service.D.ooDelete(ids, Loufang.class, Loufang2.class));
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
    public static MsgVO update(Loufang obj, List<Loufang2> list) {
        if (null == obj.getLoufang_zj() || obj.getLoufang_zj().length() != 24) {
            return MsgVO.setError("修改异常,表头信息丢失，请退出修改界面后，重新操作");
        }
        plugins.Table<Loufang2> table = new plugins.Table(list);
        if (!table.isUnique("loufang2_bianhao")) {
            return MsgVO.setError("修改异常,表体编号不唯一，请调整后再试");
        }
        if (selectOne(obj.getLoufang_zj()).getLoufang_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        int[] i = DBO.service.ADUS.executeBatch(
                //loufang_zt,隔离标识
                DBO.service.SQL.updateSome_reject(obj, "loufang_zt,loufang_gelibiaoshi,loufang_danjian_chuangwei2,loufang_taojian_chuangwei2")//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(Loufang2.class, "WHERE loufang_zj='" + obj.getLoufang_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(list)//加入新表体的值
        );
        if (null == i) {
            return MsgVO.setError("修改操作异常。请通知管理查询服务器日志");
        }
        return MsgVO.setUpdateRS(i[0]);
    }

    /**
     * 将入住的楼，进行重新统计；入住的房，数据+1
     * <p>
     * 注：执行事务时，需要单线程或锁定线程开启同步。否则这统计的数据可能不准备。
     *
     * @param obj Loufang 入住的楼
     * @param obj2 Loufang2 入住的房间
     * @param ruzhuren_zj 入住人员
     * @param gelibiaoshi 客户的隔离标识
     * @return 可执行的sql语句。2条
     */
    public static String[] ruzhu(Loufang obj, Loufang2 obj2, String ruzhuren_zj, String gelibiaoshi) {
        //房间床位+1
        obj2.setLoufang2_ruzhurenshu(obj2.getLoufang2_ruzhurenshu() + 1);
        //入住人员增加新人
        obj2.setLoufang2_ruzhuren_zj(Tool.isEmpty(obj2.getLoufang2_ruzhuren_zj()) ? ruzhuren_zj : obj2.getLoufang2_ruzhuren_zj() + "," + ruzhuren_zj);
        //重新统计表头的已用床位
        if (obj2.getLoufang2_lx().equals(FANGJIAN_LX_DANJIAN)) {
            obj.setLoufang_danjian_chuangwei2(obj.getLoufang_danjian_chuangwei2() + 1);//已用单间+1
        } else {
            obj.setLoufang_taojian_chuangwei2(obj.getLoufang_taojian_chuangwei2() + 1);//已用套间+1
        }
        String[] sql = new String[2];
        sql[0] = DBO.service.SQL.updateSome_alloy(obj, "loufang_danjian_chuangwei2,loufang_taojian_chuangwei2");
        sql[1] = DBO.service.SQL.updateSome_alloy(obj2, "loufang2_ruzhurenshu,loufang2_ruzhuren_zj");
        return sql;
    }

    /**
     * 合同变更时（人员退房、作废时、删除时、新增合同、重启反作废时）
     *
     * @param zhobj 针对一个合同处理（当不为null时，只执行此记录）
     * @param zhList 针对多个合同处理（当zhobj为null时，执行此记录）
     * @param isAdd 是否
     * @return List sql语句
     */
    public static List<String> getSql_updateLoufang(ZhusuHetong zhobj, List<ZhusuHetong> zhList, boolean isAdd) {
        FangHTVO vo = new FangHTVO();
        if (null != zhobj) {
            vo.dellOrVoidHT(vo.getLoufang(zhobj), vo.getLoufang2(zhobj), zhobj.getZhusuhetong_qianyueren_zj());
        } else {
            if (isAdd) {
                for (ZhusuHetong zh : zhList) {
                    vo.addHT(vo.getLoufang(zh), vo.getLoufang2(zh), zh.getZhusuhetong_qianyueren_zj());
                }
            } else {
                for (ZhusuHetong zh : zhList) {
                    vo.dellOrVoidHT(vo.getLoufang(zh), vo.getLoufang2(zh), zh.getZhusuhetong_qianyueren_zj());
                }
            }
        }
        return FangHTVO.getSQL_ByHT(vo, null);
    }

    public static void sumLoufang_add(final Loufang obj, final List<Loufang2> list, final String gelibiaoshi) {
        int count_danjian = 0;//合计单间的数量
        int count_taojian = 0;//合计套件的数据
        for (Loufang2 o2 : list) {
            o2.setLoufang2_gelibiaoshi(gelibiaoshi);
            if (o2.getLoufang2_lx().equals(FANGJIAN_LX_DANJIAN)) {
                count_danjian = count_danjian + o2.getLoufang2_chuangwei();//统计单间床位
            } else {
                count_taojian = count_taojian + o2.getLoufang2_chuangwei();//统计套间床位
            }
            o2.setLoufang2_ruzhurenshu(0);//入住人数锁定0
        }
        obj.setLoufang_danjian_chuangwei(count_danjian);
        obj.setLoufang_taojian_chuangwei(count_taojian);
    }

    public static void sumLoufang_update(final Loufang obj, final List<Loufang2> list, final String gelibiaoshi) {
        int count_danjian = 0;//合计单间的数量
        int count_taojian = 0;//合计套件的数据
        for (Loufang2 o2 : list) {
            o2.setLoufang2_gelibiaoshi(gelibiaoshi);
            o2.setLoufang_zj(obj.getLoufang_zj());//锁定表头主键
            if (o2.getLoufang2_lx().equals(FANGJIAN_LX_DANJIAN)) {
                count_danjian = count_danjian + o2.getLoufang2_chuangwei();//统计单间床位
            } else {
                count_taojian = count_taojian + o2.getLoufang2_chuangwei();//统计套间床位
            }
            if (null == o2.getLoufang2_ruzhurenshu()) {
                o2.setLoufang2_ruzhurenshu(0);//入住人数锁定0
            }
        }
        obj.setLoufang_danjian_chuangwei(count_danjian);
        obj.setLoufang_taojian_chuangwei(count_taojian);
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
        List<Loufang> list = DBO.service.S.selectByCondition(Loufang.class, "WHERE loufang_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiVast(List<Loufang> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        Loufang obj = DBO.service.S.selectOneByID(Loufang.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(Loufang obj, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

}
