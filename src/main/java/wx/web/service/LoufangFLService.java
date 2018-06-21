package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;

import wx.web.bean.LoufangFL;

/**
 *
 * @author wo
 */
final public class LoufangFLService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<LoufangFL> select() {
        return DBO.service.S.select(LoufangFL.class);
    }
    /**
     * 检出树
     *
     * @param condition
     * @return List
     */
    public static List<LoufangFL> select(String condition) {
        return DBO.service.S.selectByCondition(LoufangFL.class, condition);
    }
    /**
     * 检出一条记录
     *
     * @param id
     * @return LoufangFL
     */
    public static LoufangFL selectOne(String id) {
        return DBO.service.S.selectOneByID(LoufangFL.class, id);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(LoufangFL obj) {
        obj.setLoufangfl_zt(0);
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
        LoufangFL cobj = selectOne(id);
        if (null == cobj||null==cobj.getloufangfl_zj()||cobj.getLoufangfl_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<LoufangFL> list = select();
        for (LoufangFL fl : list) {
            if (fl.getLoufangfl_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(LoufangFL.class, id, "loufangfl_zt<>0");
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
    public static MsgVO update(LoufangFL obj) {

        if (selectOne(obj.getloufangfl_zj()).getLoufangfl_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //loufangfl_zt
                "loufangfl_zt"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "LoufangFL", "loufangfl_zj", "loufangfl_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "LoufangFL", "loufangfl_zj", "loufangfl_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "LoufangFL", "loufangfl_zj", "loufangfl_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "LoufangFL", "loufangfl_zj", "loufangfl_zt");
    }
}
