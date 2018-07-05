package wx.xt.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import static configuration.mvc.BaseService.SHENHE;
import java.util.List;
import java.util.Date;
import java.util.Set;
import system.web.JWeb;
import wx.xt.bean.xtguanliyuan.XtGuanliyuan;
import static wx.xt.Gelibiaoshi.getAdminInfoBySession;
import wx.xt.bean.xtguanliyuan.XtGuanliyuanJuese;

/**
 *
 * @author wangchunzi
 */
final public class XtGuanliyuanService {

    private static final String TABLE1 = "XtGuanliyuan";
    private static final String PK1 = "xt_guanliyuan_zj";
    private static final String STYLE1 = "xt_guanliyuan_zt";
    public static final String GL_SUPERADMIN = "S";

    static {
        XtGuanliyuan u = DBO.service.S.selectOneByCondition(XtGuanliyuan.class, "WHERE  xt_guanliyuan_gelibiaoshi='" + GL_SUPERADMIN + "'");
        if (null == u.getXt_guanliyuan_zj()) {
            u.setXt_guanliyuan_bm(null);
            u.setXt_guanliyuan_gelibiaoshi(GL_SUPERADMIN);
            u.setXt_guanliyuan_mc("超级管理员");
            u.setXt_guanliyuan_zhanghao("S");
            u.setXt_guanliyuan_mima("S");
            u.setXt_guanliyuan_jibie(1);
            u.setXt_guanliyuan_quanxian("");
            u.setXt_guanliyuan_bm("");
            u.setXt_guanliyuan_youxiang("");
            u.setXt_guanliyuan_zt(SHENHE);
            u.setXt_guanliyuan_bz("");
            u.setXt_guanliyuan_zhidanshijian(new Date());
            DBO.service.A.addOne(u);
        }
    }
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return XtGuanliyuan
     */
    public static XtGuanliyuan selectOne(String id) {
        return DBO.service.S.selectOneByID(XtGuanliyuan.class, id);
    }

    public static String[] myPower(final XtGuanliyuan obj) {
        //找到管理员绑定的角色。
        XtGuanliyuanJuese juese = XtGuanliyuanJueseService.selectOneByGuanliyuanZJ(obj.getXt_guanliyuan_zj());
        if (null == juese || null == juese.getXt_guanliyuanjuese_zj()) {
            return null != obj.getXt_guanliyuan_quanxian() ? obj.getXt_guanliyuan_quanxian().split(",") : new String[]{};
        }
//        Set<String> power = XTJueseQuanxianService.selectByJuese(juese.getXt_juese_zj());
         Set<String> power = XTJueseQuanxianService.selectByJuese_shenhe(juese.getXt_juese_zj());
        if (null != obj.getXt_guanliyuan_quanxian()) {
            for (String str : obj.getXt_guanliyuan_quanxian().split(",")) {
                power.add(str);
            }
        }
        String[] mypower = new String[power.size()];
        power.toArray(mypower);
        return mypower;
    }

    /**
     * 检出一条记录 已经审核的记录（登录专用）
     *
     * @param gelibiaoshi
     * @param zhanghao
     * @param mima
     * @return
     */
    public static XtGuanliyuan selectOne(String gelibiaoshi, String zhanghao, String mima) {
        return DBO.service.S.selectOneByCondition(XtGuanliyuan.class, "WHERE xt_guanliyuan_zt=" + SHENHE
                + " AND xt_guanliyuan_gelibiaoshi='" + gelibiaoshi
                + "' AND xt_guanliyuan_zhanghao='" + zhanghao
                + "' AND xt_guanliyuan_mima='" + mima + "'");
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
    public static List<XtGuanliyuan> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(XtGuanliyuan.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }
//---------------------------------------统计区--------------------------------------

    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(XtGuanliyuan.class) : DBO.service.S.selectCountByCondition(XtGuanliyuan.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(XtGuanliyuan obj) {
        if (selectCount("WHERE xt_guanliyuan_zhanghao='" + obj.getXt_guanliyuan_zhanghao() + "' AND xt_guanliyuan_gelibiaoshi='" + obj.getXt_guanliyuan_gelibiaoshi() + "'") > 0) {
            return MsgVO.setError("账号重复");
        }
        obj.setXt_guanliyuan_zt(0);
        obj.setXt_guanliyuan_zhidanshijian(new Date());
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
        XtGuanliyuan cobj = selectOne(id);
        if (null == cobj || null == cobj.getXt_guanliyuan_zj() || cobj.getXt_guanliyuan_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(XtGuanliyuan.class, id, "xt_guanliyuan_zt<>0");
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
    public static MsgVO update(XtGuanliyuan obj) {

        if (selectOne(obj.getXt_guanliyuan_zj()).getXt_guanliyuan_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_alloy(obj,
                //管理员名称,管理员密码,管理员邮箱,管理员备注
                "xt_guanliyuan_mc,xt_guanliyuan_mima,xt_guanliyuan_youxiang,xt_guanliyuan_bz"));
    }

    public static MsgVO update_bm(XtGuanliyuan obj) {

        if (selectOne(obj.getXt_guanliyuan_zj()).getXt_guanliyuan_zt() != BaseService.XINZENG) {
            return MsgVO.setError("无法附部门范围：管理员已审核");
        }
        //设置权限
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_alloy(obj, "xt_guanliyuan_bm"));
    }

    public static MsgVO update_quanxian(XtGuanliyuan obj) {

        if (selectOne(obj.getXt_guanliyuan_zj()).getXt_guanliyuan_zt() != BaseService.XINZENG) {
            return MsgVO.setError("无法附权限：管理员已审核");
        }
        //设置权限
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_alloy(obj, "xt_guanliyuan_quanxian"));
    }
//---------------------------------------隔离标识管理---------------------------------------

    public static boolean isErrorGelibiaoshi(String ids, String gelibiaoshi) {
        List<XtGuanliyuan> list = DBO.service.S.selectByCondition(XtGuanliyuan.class, "WHERE xt_guanliyuan_zj IN(" + Tool.replaceDToDDD(ids) + ")");
        for (XtGuanliyuan obj : list) {
            if (!obj.getXt_guanliyuan_gelibiaoshi().equals(gelibiaoshi)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isErrorGelibiaoshi(String zj, JWeb jw) {
        XtGuanliyuan obj = selectOne(zj);
        XtGuanliyuan admin = getAdminInfoBySession(jw);
        return null == obj || null == obj.getXt_guanliyuan_zj() || !admin.getXt_guanliyuan_gelibiaoshi().equals(obj.getXt_guanliyuan_gelibiaoshi());
    }

    public static boolean isErrorGelibiaoshi(XtGuanliyuan obj, JWeb jw) {
        XtGuanliyuan admin = getAdminInfoBySession(jw);
        return null == obj || null == obj.getXt_guanliyuan_zj() || !admin.getXt_guanliyuan_gelibiaoshi().equals(obj.getXt_guanliyuan_gelibiaoshi());
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
}
