package wx.xt.service;

import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import wx.xt.bean.xtjuese.XTJueseQuanxian;
import wx.xt.bean.xtjuese.XtJuese;

/**
 *
 * @author wangchunzi
 */
final public class XTJueseQuanxianService {

    private static final String TABLE1 = "XTJueseQuanxian";
    private static final String PK1 = "xt_juesequanxian_zj";
//---------------------------------------查询---------------------------------------

    /**
     * 通过角色ID查询 权限集合
     *
     * @param juese_zj
     * @return List 权限集合
     */
    public static Set<String> selectByJuese(final String juese_zj) {
        String wheresql = " WHERE xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zj) + ")";
        return toObjectPower(select(wheresql));
    }

    /**
     * 通过个人角色ID查询 权限集合
     *
     * @param juese_zjs
     * @param ry_zj
     * @return List 权限集合
     */
    public static Set<String> selectByJuese(final String juese_zjs, final String ry_zj) {
        String wheresql = "WHERE xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zjs) + ") AND xt_zhidanren_zj='" + ry_zj + "'";
        return toObjectPower(select(wheresql));
    }

    public static List<XTJueseQuanxian> select(final String where) {
        return DBO.service.S.selectByCondition(XTJueseQuanxian.class, null == where ? "" : where);
    }

    private static Set<String> toObjectPower(List<XTJueseQuanxian> list) {
        Set<String> qc = new HashSet();
        if (null == list || list.isEmpty()) {
            return qc;
        }
        for (XTJueseQuanxian obj : list) {
            if (null != obj.getXt_quanxian() && !obj.getXt_quanxian().isEmpty()) {
                for (String str : obj.getXt_quanxian().split(",")) {
                    qc.add(str);
                }
            }
        }
        return qc;
    }
//---------------------------------------统计区--------------------------------------

    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(XTJueseQuanxian.class) : DBO.service.S.selectCountByCondition(XTJueseQuanxian.class, where);
    }
//---------------------------------------增删改--------------------------------------
   /**
     * 设置权限-公有
     *
     * @param list
     * @param juese_zjs
     * @param quanxian_dm
     * @return MsgVO
     */
    public static MsgVO setPower(List<XtJuese> list, String juese_zjs, String quanxian_dm) {
        int i;
        if (null == quanxian_dm || quanxian_dm.isEmpty()) {
            i = DBO.service.ADUS.executeUpdate("DELETE  FROM " + TABLE1 + "  WHERE xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zjs) + ")");
            return i > 0 ? MsgVO.setOK("设置成功") : MsgVO.setNotOK("操作失败或没有可操作的单据");
        }
        List<XTJueseQuanxian> xx = toObject(list, quanxian_dm);

        int[] is = DBO.service.ADUS.executeBatch(
                "DELETE  FROM " + TABLE1 + "  WHERE xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zjs) + ")",
                DBO.service.SQL.addVast(xx)
        );
        return null == is || is[0] + is[1] == 0 ? MsgVO.setNotOK("权限设置异常") : MsgVO.setOK("设置成功");
    }
    
    /**
     * 设置权限-私有
     *
     * @param list
     * @param juese_zjs
     * @param quanxian_dm
     * @param zhidanren_zj
     * @return MsgVO
     */
    public static MsgVO setPower(List<XtJuese> list, String juese_zjs, String quanxian_dm, String zhidanren_zj) {
        int i;
        if (null == quanxian_dm || quanxian_dm.isEmpty()) {
            i = DBO.service.ADUS.executeUpdate("DELETE  FROM " + TABLE1 + "  WHERE xt_zhidanren_zj='"+zhidanren_zj+"' AND xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zjs) + ") ");
            return i > 0 ? MsgVO.setOK("设置成功") : MsgVO.setNotOK("操作失败或没有可操作的单据");
        }
        List<XTJueseQuanxian> xx = toObject(list, quanxian_dm, zhidanren_zj);

        int[] is = DBO.service.ADUS.executeBatch(
                "DELETE  FROM " + TABLE1 + "  WHERE xt_juese_zj IN(" + Tool.replaceDToDDD(juese_zjs) + ")",
                DBO.service.SQL.addVast(xx)
        );
        return null == is || is[0] + is[1] == 0 ? MsgVO.setNotOK("权限设置异常") : MsgVO.setOK("设置成功");
    }
    private static List<XTJueseQuanxian> toObject(List<XtJuese> jlist, String quanxian) {
        List<XTJueseQuanxian> list = new ArrayList<>();
        XTJueseQuanxian obj;
        for (XtJuese jobj : jlist) {
            obj = new XTJueseQuanxian();
            obj.setXt_juese_zj(jobj.getXt_juese_zj());
            obj.setXt_juese_dm(jobj.getXt_juese_dm());
            obj.setXt_quanxian(quanxian);
            list.add(obj);
        }
        return list;
    }
    private static List<XTJueseQuanxian> toObject(List<XtJuese> jlist, String quanxian, String zhidanren_zj) {
        List<XTJueseQuanxian> list = new ArrayList<>();
        XTJueseQuanxian obj;
        for (XtJuese jobj : jlist) {
            obj = new XTJueseQuanxian();
            obj.setXt_juese_zj(jobj.getXt_juese_zj());
            obj.setXt_juese_dm(jobj.getXt_juese_dm());
            obj.setXt_zhidanren_zj(zhidanren_zj);
            obj.setXt_quanxian(quanxian);
            list.add(obj);
        }
        return list;
    }

}
