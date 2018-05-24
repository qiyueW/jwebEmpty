package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import system.web.file.FI;
import system.web.file.engine.FileEngine;
import wx.web.bean.Hetong;

/**
 *
 * @author wo
 */
final public class HetongService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<Hetong> select() {
        return DBO.service.S.select(Hetong.class);
    }

    /**
     * 检出一条记录
     *
     * @param id
     * @return Hetong
     */
    public static Hetong selectOne(String id) {
        return DBO.service.S.selectOneByID(Hetong.class, id);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(Hetong obj) {
        obj.setHetong_zt(0);
        obj.setHetong_zhidanshijia(new Date());
        int i = DBO.service.A.addOne(obj,"hetong_bianhao");
        if(i==-1){
            return MsgVO.setError("添加异常：请检查这些字段(编号)是否唯一");
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
        Hetong cobj = selectOne(id);
        if (null == cobj||null==cobj.getHetong_zj()||cobj.getHetong_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<Hetong> list = select();
        for (Hetong fl : list) {
            if (fl.getHetong_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(Hetong.class, id, "hetong_zt<>0");
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
    public static MsgVO update(Hetong obj) {

        if (selectOne(obj.getHetong_zj()).getHetong_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //hetong_zt,制单时间
                "hetong_zt,hetong_zhidanshijia"));
    }
//---------------------------------------单据状态管理---------------------------------------

    /**
     * 审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_examine(String ids) {
        return BaseService.updateStyle_examine(ids, "Hetong", "hetong_zj", "hetong_zt");
    }

    /**
     * 反审核
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unExamine(String ids) {
        return BaseService.updateStyle_unExamine(ids, "Hetong", "hetong_zj", "hetong_zt");
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids, "Hetong", "hetong_zj", "hetong_zt");
    }

    /**
     * 反作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_unVoid(String ids) {
        return BaseService.updateStyle_unVoid(ids, "Hetong", "hetong_zj", "hetong_zt");
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
