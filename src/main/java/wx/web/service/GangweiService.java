package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.List;
import java.util.Date;
import wx.web.bean.Gangwei;

/**
 *
 * @author wo
 */
final public class GangweiService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<Gangwei> select() {
        return DBO.service.S.select(Gangwei.class);
    }
    /**
     * 检出树
     *
     * @param condition
     * @return List
     */
    public static List<Gangwei> select(String condition) {
        return DBO.service.S.selectByCondition(Gangwei.class, condition);
    }
    /**
     * 检出一条记录
     *
     * @param id
     * @return Gangwei
     */
    public static Gangwei selectOne(String id) {
        return DBO.service.S.selectOneByID(Gangwei.class, id);
    }
//---------------------------------------隔离标识管理--------------------------------------
    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<Gangwei> list = DBO.service.S.selectByCondition(Gangwei.class, "WHERE gangwei_zj IN(" + Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, "gangwei_gelibiaoshi", gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        Gangwei obj = DBO.service.S.selectOneByID(Gangwei.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, "gangwei_gelibiaoshi", gelibiaoshi);
    }        
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(Gangwei obj) {
        obj.setGangwei_zt(0);
        obj.setGangwei_zhidanshijian(new Date());
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
        Gangwei cobj = selectOne(id);
        if (null == cobj||null==cobj.getGangwei_zj()||cobj.getGangwei_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<Gangwei> list = select();
        for (Gangwei fl : list) {
            if (fl.getGangwei_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(Gangwei.class, id, "gangwei_zt<>0");
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
    public static MsgVO update(Gangwei obj) {

        if (selectOne(obj.getGangwei_zj()).getGangwei_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //gangwei_zt,制单时间
                "gangwei_zt,gangwei_zhidanshijian,gangwei_gelibiaoshi"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "Gangwei", "gangwei_zj", "gangwei_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "Gangwei", "gangwei_zj", "gangwei_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "Gangwei", "gangwei_zj", "gangwei_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "Gangwei", "gangwei_zj", "gangwei_zt");
    }
}
