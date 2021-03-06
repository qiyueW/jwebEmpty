package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;

import wx.web.bean.LoufangFYBZ;

/**
 *
 * @author wangchunzi
 */
final public class LoufangFYBZService {

    private static final String TABLE1 = "LoufangFYBZ";
    private static final String PK1 = "loufang_fybz_zj";
    private static final String STYLE1 = "loufang_fybz_zt";
    private static final String GE_LI_BIAO_SHI = "loufang_fybz_gelibiaoshi";
    public static final int FY_DIAN = 1;
    public static final int FY_SHUI = 2;
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return LoufangFYBZ
     */
    public static LoufangFYBZ selectOne(String id) {
        return DBO.service.S.selectOneByID(LoufangFYBZ.class, id);
    }

    /**
     * 检出xx楼的费用标准
     *
     * @param loufang_zj 楼的主键
     * @return LoufangFYBZ
     */
    public static LoufangFYBZ selectOneByLoufang_zj(String loufang_zj) {
        return DBO.service.S.selectOneByCondition(LoufangFYBZ.class, "WHERE loufang_fybz_loufang_zj='" + loufang_zj + "'");
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
    public static List<LoufangFYBZ> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(LoufangFYBZ.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(LoufangFYBZ.class) : DBO.service.S.selectCountByCondition(LoufangFYBZ.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(LoufangFYBZ obj) {
        obj.setLoufang_fybz_zt(0);
        if (selectCount("WHERE loufang_fybz_loufang_zj='" + obj.getLoufang_fybz_loufang_zj() + "'") > 0) {
            return MsgVO.setError("本楼房的费用标准已经存在。如果调整，请找到原记录进行修改");
        }
        int i = DBO.service.A.addOne(obj);
        return MsgVO.setAddRS(i);
    }

    /**
     * 删除指定数据。-1表示 不是未级，不能删除。
     *
     * @param id
     * @return
     */
    public static MsgVO dellOne(String id) {
        LoufangFYBZ cobj = selectOne(id);
        if (null == cobj || null == cobj.getLoufang_fybz_zj() || cobj.getLoufang_fybz_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(LoufangFYBZ.class, id, "loufang_fybz_zt<>0");
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
    public static MsgVO update(LoufangFYBZ obj) {

        if (selectOne(obj.getLoufang_fybz_zj()).getLoufang_fybz_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
                //loufang_fybz_zt,隔离标识,楼房主键,楼名 
                "loufang_fybz_zt,loufang_fybz_gelibiaoshi,loufang_fybz_loufang_zj,loufang_fybz_loufang_mc"));
    }
//---------------------------------------隔离标识管理--------------------------------------

    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<LoufangFYBZ> list = DBO.service.S.selectByCondition(LoufangFYBZ.class, "WHERE loufang_fybz_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiVast(List<LoufangFYBZ> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        LoufangFYBZ obj = DBO.service.S.selectOneByID(LoufangFYBZ.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(LoufangFYBZ obj, String gelibiaoshi) {
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
