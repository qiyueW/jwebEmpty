package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import system.web.file.FI;
import system.web.file.engine.FileEngine;
import wx.web.bean.BM;

/**
 *
 * @author wo
 */
final public class BMService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<BM> select() {
        return DBO.service.S.select(BM.class);
    }
    /**
     * 检出树
     *
     * @param condition
     * @return List
     */
    public static List<BM> select(String condition) {
        return DBO.service.S.selectByCondition(BM.class, condition);
    }
    /**
     * 检出一条记录
     *
     * @param id
     * @return BM
     */
    public static BM selectOne(String id) {
        return DBO.service.S.selectOneByID(BM.class, id);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(BM obj) {
        obj.setBm_zt(0);
        obj.setBm_chuangjianshijian(new Date());
        int i = DBO.service.A.addOne(obj,"bm_bianma");
        if(i==-1){
            return MsgVO.setError("添加异常：请检查这些字段(编码)是否唯一");
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
        BM cobj = selectOne(id);
        if (null == cobj||null==cobj.getBm_zj()||cobj.getBm_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<BM> list = select();
        for (BM fl : list) {
            if (fl.getBm_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(BM.class, id, "bm_zt<>0");
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
    public static MsgVO update(BM obj) {

        if (selectOne(obj.getBm_zj()).getBm_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //bm_zt,部门创建时间
                "bm_zt,bm_chuangjianshijian"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "BM", "bm_zj", "bm_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "BM", "bm_zj", "bm_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "BM", "bm_zj", "bm_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "BM", "bm_zj", "bm_zt");
    }
//---------------------------------------文件图片管理---------------------------------------
    /**
     * 上传图片
     *
     * @param reqeust
     * @return FI
     */
    public static FI upOneImg(HttpServletRequest reqeust) {
        FileEngine file = new FileEngine(reqeust);
        FI upOne = file.upOne(configuration.file.ImgFileModel.class);//可以自己写一个Model
        return upOne;
    }
}
