package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import static configuration.mvc.BaseService.SHENHE;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import system.web.file.FI;
import system.web.file.engine.FileEngine;
import wx.web.bean.RY;

/**
 *
 * @author wangchunzi
 */
final public class RYService {

    private static final String TABLE1 = "RY";
    private static final String PK1 = "ry_zj";
    private static final String STYLE1 = "ry_zt";

//---------------------------------------查询---------------------------------------
    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return RY
     */
    public static RY selectOne(String id) {
        return DBO.service.S.selectOneByID(RY.class, id);
    }

    /**
     * 检出一条记录
     *
     * @param gelibiaoshi
     * @param zh
     * @param mm
     * @return RY
     */
    public static RY selectOne(String gelibiaoshi, String zh, String mm) {
        return DBO.service.S.selectOneByCondition(RY.class, "WHERE ry_gelibiaoshi='" + gelibiaoshi + "' AND ry_zhanghao='" + zh + "' AND ry_mima='" + mm + "' AND ry_zt=" + SHENHE);
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
    public static List<RY> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(RY.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }
//---------------------------------------隔离标识管理--------------------------------------

    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<RY> list = DBO.service.S.selectByCondition(RY.class, "WHERE ry_zj IN(" + Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, "ry_gelibiaoshi", gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        RY obj = DBO.service.S.selectOneByID(RY.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, "ry_gelibiaoshi", gelibiaoshi);
    }
//---------------------------------------统计区--------------------------------------

    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(RY.class) : DBO.service.S.selectCountByCondition(RY.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(RY obj) {
        obj.setRy_zt(0);
        int i = DBO.service.A.addOneByCondition(obj, "WHERE ry_zhanghao='" + obj.getRy_zhanghao() + "' AND ry_gelibiaoshi='" + obj.getRy_gelibiaoshi() + "'");
        if (i == -1) {
            return MsgVO.setError("添加异常：请检查这些字段(账号)是否唯一");
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
        RY cobj = selectOne(id);
        if (null == cobj || null == cobj.getRy_zj() || cobj.getRy_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(RY.class, id, "ry_zt<>0");
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
    public static MsgVO update(RY obj) {

        if (selectOne(obj.getRy_zj()).getRy_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
                //状态,账号,密码,隔离标识,制单人,制单人主键
                "ry_zt,ry_zhanghao,ry_mima,ry_gelibiaoshi,ry_zhidanren,ry_zhidanren_zj"));
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
//---------------------------------------文件图片管理---------------------------------------

    /**
     * 上传文件
     *
     * @param reqeust
     * @return FI
     */
    public static FI upOneFile(HttpServletRequest reqeust) {
        FileEngine file = new FileEngine(reqeust);
        FI upOne = file.upOne(configuration.file.ImgFileModel.class);//可以自己写一个Model 系统默认office系列小部分
        return upOne;
    }
}
