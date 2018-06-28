package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.List;
import java.util.Date;
import wx.web.bean.Zhiwei;

/**
 *
 * @author wo
 */
final public class ZhiweiService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<Zhiwei> select() {
        return DBO.service.S.select(Zhiwei.class);
    }
    /**
     * 检出树
     *
     * @param condition
     * @return List
     */
    public static List<Zhiwei> select(String condition) {
        return DBO.service.S.selectByCondition(Zhiwei.class, condition);
    }
    /**
     * 检出一条记录
     *
     * @param id
     * @return Zhiwei
     */
    public static Zhiwei selectOne(String id) {
        return DBO.service.S.selectOneByID(Zhiwei.class, id);
    }
//---------------------------------------隔离标识管理--------------------------------------
    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<Zhiwei> list = DBO.service.S.selectByCondition(Zhiwei.class, "WHERE zhiwei_zj IN(" + Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, "zhiwei_gelibiaoshi", gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        Zhiwei obj = DBO.service.S.selectOneByID(Zhiwei.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, "zhiwei_gelibiaoshi", gelibiaoshi);
    }    
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(Zhiwei obj) {
        obj.setZhiwei_zt(0);
        obj.setZhiwei_zhidanshijian(new Date());
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
        Zhiwei cobj = selectOne(id);
        if (null == cobj||null==cobj.getZhiwei_zj()||cobj.getZhiwei_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<Zhiwei> list = select();
        for (Zhiwei fl : list) {
            if (fl.getZhiwei_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(Zhiwei.class, id, "zhiwei_zt<>0");
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
    public static MsgVO update(Zhiwei obj) {

        if (selectOne(obj.getZhiwei_zj()).getZhiwei_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //zhiwei_zt,制单时间
                "zhiwei_zt,zhiwei_zhidanshijian"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "Zhiwei", "zhiwei_zj", "zhiwei_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "Zhiwei", "zhiwei_zj", "zhiwei_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "Zhiwei", "zhiwei_zj", "zhiwei_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "Zhiwei", "zhiwei_zj", "zhiwei_zt");
    }
}
