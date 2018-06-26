package wx.xt.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.List;
import java.util.Date;
import wx.xt.bean.xtjuese.XtJuese;

/**
 *
 * @author wo
 */
final public class XtJueseService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<XtJuese> select() {
        return DBO.service.S.select(XtJuese.class);
    }
    /**
     * 检出树
     *
     * @param condition
     * @return List
     */
    public static List<XtJuese> select(String condition) {
        return DBO.service.S.selectByCondition(XtJuese.class, condition);
    }
    /**
     * 检出一条记录
     *
     * @param id
     * @return XtJuese
     */
    public static XtJuese selectOne(String id) {
        return DBO.service.S.selectOneByID(XtJuese.class, id);
    }
//---------------------------------------隔离标识管理--------------------------------------
    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<XtJuese> list = DBO.service.S.selectByCondition(XtJuese.class, "WHERE xt_juese_gelibiaoshi IN(" + Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, "xt_juese_gelibiaoshi", gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        XtJuese obj = DBO.service.S.selectOneByID(XtJuese.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, "xt_juese_gelibiaoshi", gelibiaoshi);
    }    
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(XtJuese obj) {
        obj.setXt_juese_zt(0);
        obj.setXt_juese_zhidanshijian(new Date());
        int i = DBO.service.A.addOne(obj,"xt_juese_mc","xt_juese_dm");
        if(i==-1){
            return MsgVO.setError("添加异常：请检查这些字段(名称,代码)是否唯一");
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
        XtJuese cobj = selectOne(id);
        if (null == cobj||null==cobj.getXt_juese_zj()||cobj.getXt_juese_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<XtJuese> list = select();
        for (XtJuese fl : list) {
            if (fl.getXt_juese_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(XtJuese.class, id, "xt_juese_zt<>0");
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
    public static MsgVO update(XtJuese obj) {

        if (selectOne(obj.getXt_juese_zj()).getXt_juese_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //xt_juese_zt,制单时间
                "xt_juese_zt,xt_juese_zhidanshijian"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "XtJuese", "xt_juese_zj", "xt_juese_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "XtJuese", "xt_juese_zj", "xt_juese_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "XtJuese", "xt_juese_zj", "xt_juese_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "XtJuese", "xt_juese_zj", "xt_juese_zt");
    }
}
