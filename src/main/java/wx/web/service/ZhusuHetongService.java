package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import system.base.date.DateService;
import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;
import wx.web.bean.ZhusuHetong;
import wx.web.service.vo.FangHTVO;

/**
 *
 * @author wangchunzi
 */
final public class ZhusuHetongService {

    private static final String TABLE1 = "ZhusuHetong";
    private static final String PK1 = "zhusuhetong_zj";
    private static final String STYLE1 = "zhusuhetong_zt";
    private static final String GE_LI_BIAO_SHI = "zhusuhetong_gelibiaoshi";
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return ZhusuHetong
     */
    public static ZhusuHetong selectOne(String id) {
        return DBO.service.S.selectOneByID(ZhusuHetong.class, id);
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
    public static List<ZhusuHetong> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(ZhusuHetong.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

    /**
     * 通过房间的主键，统计像这样的房有多少间（一合同一间）审核状态下
     *
     * @param loufang2_zj
     * @param gelibiaoshi
     * @return
     */
    public static List<ZhusuHetong> select(final String loufang2_zj, String gelibiaoshi) {
        return DBO.service.S.selectByCondition(ZhusuHetong.class,
                "WHERE zhusuhetong_loufang2_zj='" + loufang2_zj
                + "' AND zhusuhetong_gelibiaoshi='" + gelibiaoshi
                + "' AND zhusuhetong_zt='" + BaseService.SHENHE + "'"
        );
    }

    /**
     * 通过合同主键，检查所有审核的合同。
     *
     * @param zhusuhetong_zjs
     * @return
     */
    public static List<ZhusuHetong> selectByIDs_Shenhe(final String zhusuhetong_zjs) {
        return DBO.service.S.selectByCondition(ZhusuHetong.class,
                "WHERE zhusuhetong_zj=" + Tool.replaceDToDDD(zhusuhetong_zjs) + " AND zhusuhetong_zt='" + BaseService.SHENHE + "'"
        );
    }

    /**
     * 检查某楼的所有审核的合同
     *
     * @param lou_zj
     * @return
     */
    public static List<ZhusuHetong> selectByLouZJ_Shenhe(final String lou_zj) {
        return DBO.service.S.selectByCondition(ZhusuHetong.class,
                "WHERE zhusuhetong_loufang_zj=" + Tool.replaceDToDDD(lou_zj) + " AND zhusuhetong_zt='" + BaseService.SHENHE + "'"
        );
    }

    /**
     * 检查某房的所有审核的合同
     *
     * @param fang_zj
     * @return
     */
    public static List<ZhusuHetong> selectByFangZJ_Shenhe(final String fang_zj) {
        return DBO.service.S.selectByCondition(ZhusuHetong.class,
                "WHERE zhusuhetong_loufang2_zj=" + Tool.replaceDToDDD(fang_zj) + " AND zhusuhetong_zt='" + BaseService.SHENHE + "'"
        );
    }
//---------------------------------------工具区--------------------------------------

    /**
     * 计算纳费日期
     *
     * @param obj ZhusuHetong
     * @param yearMonth 【出账月】
     * @return Date
     */
    public static Date js_nfrq(final ZhusuHetong obj, Date yearMonth) {
        LocalDate nfrq = null == yearMonth ? LocalDate.now() : DateService.TO.toLocalDate(yearMonth);//出账日期
        switch (obj.getZhusuhetong_jffs()) {
            case 1: {//按入住日
                return DateService.TO.toDate(
                        DateService.NT.nextMonth_jump(//参考入住日，计算【出账月】的同天日。
                                obj.getZhusuhetong_kaishiriqi(), nfrq.getYear(), nfrq.getMonthValue()
                        ));
            }
            case 2: {//【出账月】月底
                return DateService.TO.toDate(
                        nfrq.with(TemporalAdjusters.lastDayOfMonth())
                );
            }
            case 3: {//每月x号
                //指定的日期超出【出账月】最后一天的日期。取本月最后一天
                if (nfrq.lengthOfMonth() < obj.getZhusuhetong_jffs_zdrq()) {
                    return DateService.TO.toDate(
                            nfrq.with(TemporalAdjusters.lastDayOfMonth())
                    );
                }
                //返回【出账月】，指定日期。
                return DateService.TO.toDate(
                        nfrq.with(TemporalAdjusters.firstDayOfMonth()).plusDays(obj.getZhusuhetong_jffs_zdrq() - 1)
                );
            }
        }
        return null;
    }

//    public static void main(String args[]) {
//        LocalDate ld = LocalDate.parse("2018-07-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate nextMonth_jump = nextMonth_jump(
//                Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 2018, 9);
////        DateService.TO.toLocalDate("1988-08");//出账日期
////        DateService.TO.toDate(nextMonth_jump);
//        System.out.println(nextMonth_jump.getMonthValue());
//    }
//
//    final static public LocalDate nextMonth_jump(Date date, int year, int month) {
//
//        LocalDate ld1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
////        LocalDate.parse("1988-08-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
////        DateService.TO.toLocalDate(date);
//        LocalDate now = LocalDate.of(year, month, 1);
//        int i = ld1.getDayOfMonth() > now.lengthOfMonth()
//                ? now.lengthOfMonth()
//                : ld1.getDayOfMonth();
//        return now.plusDays(--i);
//    }
//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(ZhusuHetong.class) : DBO.service.S.selectCountByCondition(ZhusuHetong.class, where);
    }

    /**
     * 通过房间的主键，统计像这样的房有多少间（一合同一间）审核状态下
     *
     * @param loufang2_zj
     * @param gelibiaoshi
     * @return
     */
    public static int selectCountByLoufang2_zj(final String loufang2_zj, String gelibiaoshi) {
        return DBO.service.S.selectCountByCondition(ZhusuHetong.class,
                "WHERE zhusuhetong_loufang2_zj='" + loufang2_zj
                + "' AND zhusuhetong_gelibiaoshi='" + gelibiaoshi
                + "' AND zhusuhetong_zt='" + BaseService.SHENHE + "'"
        );
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    synchronized public static MsgVO addOne(ZhusuHetong obj) {
//        int i = DBO.service.A.addOne(obj);
        Loufang louObj = LoufangService.selectOne(obj.getZhusuhetong_loufang_zj());
        if (null == louObj || null == louObj.getLoufang_zj()) {
            return MsgVO.setError("没有此栋楼:" + obj.getZhusuhetong_loufang_mc());
        }
        Loufang2 fangObj = LoufangService.selectOne2(obj.getZhusuhetong_loufang2_zj());
        if (null == fangObj || null == fangObj.getLoufang2_zj()) {
            return MsgVO.setError("没有此房间:" + obj.getZhusuhetong_loufang2_bianhao());
        } else if (fangObj.getLoufang2_ruzhurenshu() >= fangObj.getLoufang2_chuangwei()) {//入住人数大于或等于床位
            return MsgVO.setError("此房间(" + obj.getZhusuhetong_loufang2_bianhao() + ")已经住满人！");
        }
        String[] sql = LoufangService.ruzhu(louObj, fangObj, obj.getZhusuhetong_qianyueren_zj(), obj.getZhusuhetong_gelibiaoshi());

        int is[] = DBO.service.ADUS.executeBatch(
                DBO.service.SQL.addOne(obj),
                sql[0],
                sql[1]
        );
        return MsgVO.setAddRS(is[0]);
    }

    /**
     * 删除指定数据。-1表示 不是未级，不能删除。
     *
     * @param id
     * @return
     */
    public static MsgVO dellOne(String id) {
        ZhusuHetong cobj = selectOne(id);
        if (null == cobj || null == cobj.getZhusuhetong_zj() || cobj.getZhusuhetong_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<String> sql = LoufangService.getSql_updateLoufang(cobj, null, false);
        sql.add(DBO.service.SQL.dellByID(ZhusuHetong.class, id));
        int i[] = DBO.service.ADUS.executeBatch(sql.toArray(new String[sql.size()]));
        return MsgVO.setDellRS(i[0] > 0 ? 1 : 0);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(ZhusuHetong obj) {
        //合同，检查未修前，数据是否符合修改
        ZhusuHetong old = selectOne(obj.getZhusuhetong_zj());
        if (old.getZhusuhetong_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        //zhusuhetong_zt,隔离标识,制单时间,制单人,制单人主键,签约人,签约人主键
        String rejectSqlField = "zhusuhetong_zt,zhusuhetong_gelibiaoshi,zhusuhetong_zhidanshijian,zhusuhetong_zhidanren,zhusuhetong_zhidanren_zj,zhusuhetong_qianyueren,zhusuhetong_qianyueren_zj";
        //当楼房不变时，只更新合同
        if (old.getZhusuhetong_loufang_zj().equals(obj.getZhusuhetong_loufang_zj()) && old.getZhusuhetong_loufang2_bianhao().equals(obj.getZhusuhetong_loufang2_bianhao())) {
            return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj, rejectSqlField));
        }
        //使用楼房工具对象，当合同变动时，重新更新楼房对象相关的数据。
        FangHTVO vo = new FangHTVO();
        vo.dellOrVoidHT(vo.getLoufang(old), vo.getLoufang2(old), old.getZhusuhetong_qianyueren_zj());
        vo.addHT(vo.getLoufang(obj), vo.getLoufang2(obj), old.getZhusuhetong_qianyueren_zj());
        List<String> sql = FangHTVO.getSQL_ByHT(vo, null);
        sql.add(DBO.service.SQL.updateSome_reject(obj, rejectSqlField));
        int i[] = DBO.service.ADUS.executeBatch(sql.toArray(new String[sql.size()]));
        return MsgVO.setUpdateRS(i[0] > 0 ? 1 : 0);
    }
//---------------------------------------隔离标识管理--------------------------------------

    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<ZhusuHetong> list = DBO.service.S.selectByCondition(ZhusuHetong.class, "WHERE zhusuhetong_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiVast(List<ZhusuHetong> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        ZhusuHetong obj = DBO.service.S.selectOneByID(ZhusuHetong.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(ZhusuHetong obj, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
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

    /**
     * 检查合同的人员，在date1与date2间，占用了多少天。
     *
     * @param obj 合同人员
     * @param date1 开始
     * @param date2 结束
     * @return
     */
    public static int getMyUserData(final ZhusuHetong obj, final Date date1, final Date date2) {
        return DateService.RUN.minus(
                date2,//上次抽检日期
                //合同开始日期在date1之前或等于date1，直接按date1与date2的差距离算。否则按合同的日期与date2的差距算。
                (obj.getZhusuhetong_kaishiriqi().compareTo(date1) <= 0 ? date1 : obj.getZhusuhetong_kaishiriqi())
        );
    }

}
