package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;

import wx.web.bean.LoufangXMF;

/**
 *
 * @author wangchunzi
 */
final public class LoufangXMFService {

    private static final String TABLE1 = "LoufangXMF";
    private static final String PK1 = "loufangxmf_zj";
    private static final String STYLE1 = "loufangxmf_zt";
    private static final String GE_LI_BIAO_SHI = "loufangxmf_gelibiaoshi";
//---------------------------------------查询---------------------------------------
    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return LoufangXMF
     */
    public static LoufangXMF selectOne(String id) {
        return DBO.service.S.selectOneByID(LoufangXMF.class, id);
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
    public static List<LoufangXMF> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(LoufangXMF.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }
    public static List<LoufangXMF> select(final String where) {
        return DBO.service.S.selectByCondition(LoufangXMF.class, where);
    }
//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(LoufangXMF.class) : DBO.service.S.selectCountByCondition(LoufangXMF.class, where);
    }    
//---------------------------------------增删改--------------------------------------
    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(LoufangXMF obj) {
        obj.setLoufangxmf_zt(0);
        int i = DBO.service.A.addOne(obj,"loufangxmf_mc");
        if(i==-1){
            return MsgVO.setError("添加异常：请检查这些字段(项目名称)是否唯一");
        }
        return MsgVO.setAddRS(i);
    }

    /**
     * 删除指定数据。-1表示 不是未级，不能删除。
     *
     * @param id
     * @return
     */
    public static MsgVO dellOne(String id) {
        LoufangXMF cobj = selectOne(id);
        if (null == cobj||null==cobj.getLoufangxmf_zj()||cobj.getLoufangxmf_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(LoufangXMF.class, id, "loufangxmf_zt<>0");
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
    public static MsgVO update(LoufangXMF obj) {

        if (selectOne(obj.getLoufangxmf_zj()).getLoufangxmf_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //loufangxmf_zt,隔离标识
                "loufangxmf_zt,loufangxmf_gelibiaoshi"));
    }
//---------------------------------------隔离标识管理--------------------------------------
    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<LoufangXMF> list = DBO.service.S.selectByCondition(LoufangXMF.class, "WHERE loufangxmf_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list,GE_LI_BIAO_SHI, gelibiaoshi);
    }
    public static boolean isErrorGelibiaoshiVast(List<LoufangXMF> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list,GE_LI_BIAO_SHI, gelibiaoshi);
    }
    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        LoufangXMF obj = DBO.service.S.selectOneByID(LoufangXMF.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj,GE_LI_BIAO_SHI, gelibiaoshi);
    }
    public static boolean isErrorGelibiaoshiOne(LoufangXMF obj, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiOne(obj,GE_LI_BIAO_SHI, gelibiaoshi);
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
        return BaseService.updateStyle_unExamine(ids,  TABLE1, PK1, STYLE1);
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids,  TABLE1, PK1, STYLE1);
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
