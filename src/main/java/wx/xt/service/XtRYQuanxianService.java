package wx.xt.service;

import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.Date;
import java.util.List;
import wx.xt.bean.ViewRYQuanxian;
import wx.xt.bean.XtRYQuanxian;

/**
 *
 * @author wangchunzi
 */
final public class XtRYQuanxianService {

    private static final String ADMIN_M_RY_BM//检出指定隔离标识部门的人员
            = "SELECT R.*,RQ.xt_ryquanxian_zj,RQ.xt_guanliyuan_mc "
            + "FROM "
            + "("
            + "SELECT * FROM RY WHERE RY.ry_gelibiaoshi='?1' AND RY.ry_bm_zj IN(?2) ?condition "//从人员表中，取出相同隔离标识的，某部门的人员
            + ") R "
            + "LEFT JOIN "
            + "(SELECT XtRYQuanxian.xt_ryquanxian_zj,XtRYQuanxian.xt_ry_zj,XtGuanliyuan.xt_guanliyuan_mc  FROM XtRYQuanxian "//从人员权限表中，检查 定制人的信息
            + "	 LEFT JOIN XtGuanliyuan ON XtRYQuanxian.xt_ryquanxian_zhidanren=XtGuanliyuan.xt_guanliyuan_zj"
            + ")RQ "
            + "ON R.ry_zj=RQ.xt_ry_zj;";
    private static final String ADMIN_M_RY//检出指定隔离标识的人员
            = "SELECT R.*,RQ.xt_ryquanxian_zj,RQ.xt_guanliyuan_mc "
            + "FROM "
            + "("
            + "SELECT * FROM RY WHERE RY.ry_gelibiaoshi='?1' ?condition "//从人员表中，取出相同隔离标识的，某部门的人员
            + ") R "
            + "LEFT JOIN "
            + "(SELECT XtRYQuanxian.xt_ryquanxian_zj, XtRYQuanxian.xt_ry_zj,XtGuanliyuan.xt_guanliyuan_mc  FROM XtRYQuanxian "//从人员权限表中，检查 定制人的信息
            + "	 LEFT JOIN XtGuanliyuan ON XtRYQuanxian.xt_ryquanxian_zhidanren=XtGuanliyuan.xt_guanliyuan_zj"
            + ")RQ "
            + "ON R.ry_zj=RQ.xt_ry_zj;";
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return XtRYQuanxian
     */
    public static XtRYQuanxian selectOne(String id) {
        return DBO.service.S.selectOneByID(XtRYQuanxian.class, id);
    }

    /**
     * 查询一个人的权限
     *
     * @param xt_ry_zj
     * @return
     */
    public static List<XtRYQuanxian> selectOneByRy(String xt_ry_zj) {
        return DBO.service.S.selectByCondition(XtRYQuanxian.class, "WHERE xt_ry_zj ='" + xt_ry_zj + "'");
    }

    /**
     * 通过制单人与人员主键，检出一条记录。（主要作用于：是否已经有旧的。）
     *
     * @param ryZJ
     * @param zdrZJ
     * @return XtRYQuanxian
     */
    public static XtRYQuanxian selectOne(String ryZJ, String zdrZJ) {
        return DBO.service.S.selectOneByCondition(XtRYQuanxian.class, "WHERE xt_ry_zj='" + ryZJ + "' AND xt_ryquanxian_zhidanren='" + zdrZJ + "'");
    }

    /**
     * @param gelibiaoshi
     * @param bm_zj
     * @param condition
     * @return List ViewRYQuanxian集合
     */
    public static List<ViewRYQuanxian> select(final String gelibiaoshi, final String bm_zj, String condition) {
        if (null == bm_zj || bm_zj.isEmpty()) {
            return DBO.service.ADUS.executeQueryVast(ViewRYQuanxian.class,
                    ADMIN_M_RY
                            .replace("?1", gelibiaoshi)
                            .replace("?condition", condition));
        } else {
            return DBO.service.ADUS.executeQueryVast(ViewRYQuanxian.class,
                    ADMIN_M_RY_BM
                            .replace("?1", gelibiaoshi)
                            .replace("?2", Tool.replaceDToDDD(bm_zj))
                            .replace("?condition", condition));
        }
    }

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(XtRYQuanxian obj) {
        obj.setXt_ryquanxian_zhidanshijian(new Date());
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
        XtRYQuanxian cobj = selectOne(id);
        if (null == cobj || null == cobj.getXt_ryquanxian_zj()) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.dellByID(XtRYQuanxian.class, id);
        return MsgVO.setDellRS(i);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(XtRYQuanxian obj) {
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_alloy(obj, "xt_juese_zj,xt_quanxian"));
    }
}