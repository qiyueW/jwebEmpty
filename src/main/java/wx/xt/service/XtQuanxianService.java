package wx.xt.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;

import wx.xt.bean.XtQuanxian;

/**
 *
 * @author wo
 */
final public class XtQuanxianService {
//---------------------------------------查询---------------------------------------

    private static final String PX = "order by xt_quanxian_px ASC";//锁定排序，按xt_quanxian_px字段来

    /**
     * 检出树
     *
     * @return List
     */
    public static List<XtQuanxian> select() {
        return DBO.service.S.select(XtQuanxian.class, PX);
    }
    
    /**
     * 取出可视化的菜单
     *
     * @return
     */
    public static List<XtQuanxian> selectMenu() {
        return DBO.service.S.selectByCondition(XtQuanxian.class, "WHERE xt_quanxian_keshi=1", PX);
    }

    /**
     * 检出树
     *
     * @param condition
     * @return List
     */
    public static List<XtQuanxian> select(String condition) {
        return DBO.service.S.selectByCondition(XtQuanxian.class, condition, PX);
    }

    /**
     * 检出一条记录
     *
     * @param id
     * @return XtQuanxian
     */
    public static XtQuanxian selectOne(String id) {
        return DBO.service.S.selectOneByID(XtQuanxian.class, id);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(XtQuanxian obj) {
        obj.setXt_quanxian_zt(0);
        int i = DBO.service.A.addOne(obj, "xt_quanxian_dm");
        if (i == -1) {
            return MsgVO.setError("添加异常：请检查这些字段(权限代码)是否唯一");
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
        XtQuanxian cobj = selectOne(id);
        if (null == cobj || null == cobj.getXt_quanxian_zj() || cobj.getXt_quanxian_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<XtQuanxian> list = select();
        for (XtQuanxian fl : list) {
            if (fl.getXt_quanxian_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(XtQuanxian.class, id, "xt_quanxian_zt<>0");
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
    public static MsgVO update(XtQuanxian obj) {

        if (selectOne(obj.getXt_quanxian_zj()).getXt_quanxian_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
                //xt_quanxian_zt
                "xt_quanxian_zt"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "XtQuanxian", "xt_quanxian_zj", "xt_quanxian_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "XtQuanxian", "xt_quanxian_zj", "xt_quanxian_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "XtQuanxian", "xt_quanxian_zj", "xt_quanxian_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "XtQuanxian", "xt_quanxian_zj", "xt_quanxian_zt");
    }
}
