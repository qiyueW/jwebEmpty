package wx.xt.service;

import java.util.List;
import java.util.Set;

import configuration.DBO;
import configuration.MsgVO;
import wx.xt.bean.xtguanliyuan.XtGuanliyuanJuese;
import wx.xt.bean.xtjuese.XTJueseQuanxian;

/**
 *
 * @author wangchunzi
 */
final public class XtGuanliyuanJueseService {

//---------------------------------------查询---------------------------------------
    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return XtGuanliyuanJuese
     */
    public static XtGuanliyuanJuese selectOne(String id) {
        return DBO.service.S.selectOneByID(XtGuanliyuanJuese.class, id);
    }

    /**
     * 检出一条记录(表头)
     *
     * @param zj 表头主键
     * @return XtGuanliyuanJuese
     */
    public static XtGuanliyuanJuese selectOneByGuanliyuanZJ(String zj) {
        return DBO.service.S.selectOneByCondition(XtGuanliyuanJuese.class, "WHERE xt_guanliyuan_zj='" + zj + "'");
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
    public static List<XtGuanliyuanJuese> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(XtGuanliyuanJuese.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

    /**
     * 总管专用-针对辅管。检出指定辅管的所有角色，一旦发现存在要过滤的权限（在集合dellPower中），进行权限更新。
     * <p>
     * @param liststr 存放执行sql语句的容器
     * @param guanliyuan_zj 管理员主键
     * @param dellPower 要过滤的权限
     */
    public static void updateGuanliyuanJueseQianxianByRejectSomePower(List<String> liststr,String guanliyuan_zj,Set<String> dellPower){
    	XtGuanliyuanJuese admin=selectOneByGuanliyuanZJ(guanliyuan_zj);
    	List<XTJueseQuanxian> rq=XTJueseQuanxianService.selectByJueses(admin.getXt_juese_zj());
    	for(XTJueseQuanxian jrx:rq) {
    		//从角色绑定的权限中，移除要删除的权限。
    		jrx.setXt_quanxian(MyTool.toRejectStr(jrx.getXt_quanxian(),dellPower));
    		//重新解析成更新权限的sql语句。以备之后的事务管理，一起执行。
    		liststr.add(DBO.service.SQL.updateSome_alloy(jrx, "xt_quanxian"));
    	}
    }
//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(XtGuanliyuanJuese.class) : DBO.service.S.selectCountByCondition(XtGuanliyuanJuese.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(XtGuanliyuanJuese obj) {
        int i = DBO.service.A.addOne(obj);
        return i<1?MsgVO.setError("绑定失败，请稍后再试。"): MsgVO.setOK("绑定成功");
    }

    /**
     * 删除指定数据。-1表示 不是未级，不能删除。
     *
     * @param id
     * @return
     */
    public static MsgVO dellOne(String id) {
        XtGuanliyuanJuese cobj = selectOne(id);
        if (null == cobj || null == cobj.getXt_guanliyuanjuese_zj()) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.dellByID(XtGuanliyuanJuese.class, id);
        return MsgVO.setDellRS(i);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(XtGuanliyuanJuese obj) {
        return DBO.service.U.updateSome_alloy(obj,"xt_juese_zj")<1?
                MsgVO.setError("绑定失败，请稍后再试。"): MsgVO.setOK("绑定成功");
    }
}
