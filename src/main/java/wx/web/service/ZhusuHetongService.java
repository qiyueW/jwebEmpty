package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;
import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;
import wx.web.bean.ZhusuHetong;

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
        int i = DBO.service.D.deleteOneByID_CheckToDeny(ZhusuHetong.class, id, "zhusuhetong_zt<>0");
        if (i == -1) {
            return MsgVO.setError("单据锁定，无法删除");
        }
        return MsgVO.setDellRS(i);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(ZhusuHetong obj) {

        if (selectOne(obj.getZhusuhetong_zj()).getZhusuhetong_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
                //zhusuhetong_zt,隔离标识,制单时间
                "zhusuhetong_zt,zhusuhetong_gelibiaoshi,zhusuhetong_zhidanshijian"));
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
}
