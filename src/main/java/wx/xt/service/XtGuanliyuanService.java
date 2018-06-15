package wx.xt.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;
import java.util.Date;
import wx.xt.bean.XtGuanliyuan;

/**
 *
 * @author wangchunzi
 */
final public class XtGuanliyuanService {
    private static final String TABLE1 = "XtGuanliyuan";
    private static final String PK1 = "xt_guanliyuan_zj";
    private static final String STYLE1 = "xt_guanliyuan_zt";
    
//---------------------------------------查询---------------------------------------
    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return XtGuanliyuan
     */
    public static XtGuanliyuan selectOne(String id) {
        return DBO.service.S.selectOneByID(XtGuanliyuan.class, id);
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
    public static List<XtGuanliyuan> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(XtGuanliyuan.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(XtGuanliyuan.class) : DBO.service.S.selectCountByCondition(XtGuanliyuan.class, where);
    }    
//---------------------------------------增删改--------------------------------------
    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(XtGuanliyuan obj) {
        obj.setXt_guanliyuan_zt(0);
        obj.setXt_guanliyuan_zhidanshijian(new Date());
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
        XtGuanliyuan cobj = selectOne(id);
        if (null == cobj||null==cobj.getXt_guanliyuan_zj()||cobj.getXt_guanliyuan_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(XtGuanliyuan.class, id, "xt_guanliyuan_zt<>0");
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
    public static MsgVO update(XtGuanliyuan obj) {

        if (selectOne(obj.getXt_guanliyuan_zj()).getXt_guanliyuan_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //xt_guanliyuan_zt,制单时间
                "xt_guanliyuan_zt,xt_guanliyuan_zhidanshijian"));
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
