package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.util.List;

import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;

/**
 *
 * @author wangchunzi
 */
final public class LoufangService {
    private static final String TABLE1 = "Loufang";
    private static final String PK1 = "loufang_zj";
    private static final String STYLE1 = "loufang_zt";
    private static final String GE_LI_BIAO_SHI = "loufang_gelibiaoshi";
//---------------------------------------查询---------------------------------------
    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return Loufang
     */
    public static Loufang selectOne(String id) {
        return DBO.service.S.selectOneByID(Loufang.class, id);
    }

    /**
     * 检出一条记录(表体)
     *
     * @param id 表体主键
     * @return Loufang2
     */
    public static Loufang2 selectOne2(String id) {
        return DBO.service.S.selectOneByID(Loufang2.class, id);
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
    public static List<Loufang> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(Loufang.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

    /**
     * 检出表体数据 根据表头主键
     *
     * @param pid 表头的主键
     * @return List
     */
    public static List<Loufang2> select2(String pid) {
        return DBO.service.S.selectByCondition(Loufang2.class, "WHERE "+PK1+" IN('" + pid + "')");
    }
//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(Loufang.class) : DBO.service.S.selectCountByCondition(Loufang.class, where);
    }    
//---------------------------------------增删改--------------------------------------
    /**
     * 添加数据
     *
     * @param obj 1方
     * @param list 多方
     * @return MsgVO
     */
    public static MsgVO addOne(Loufang  obj, List<Loufang2 > list) {
        plugins.Table<Loufang2> table = new plugins.Table(list);
        if(!table.isUnique("loufang2_bianhao")){
            return MsgVO.setError("添加异常,表体编号不唯一，请调整后再试");
        }
        obj.setLoufang_zt(0);

        int[] i = DBO.service.A.add_OM(obj, list);
        if (null == i) {
            return MsgVO.setError("添加异常,请通知管理检查后台数据库连接是否异常。");
        }
        return MsgVO.setAddRS(i[0]);
    }
    /**
     * 删除指定数据。
     *
     * @param ids
     * @return
     */
    public static MsgVO dellVast(String ids) {
        if (DBO.service.S.selectCountByCondition(Loufang.class, "WHERE loufang_zt<>0 AND loufang_zj IN(" + Tool.replaceDToDDD(ids) + ")") > 0) {
            return MsgVO.setError("选择的单据中存在锁定的单据，无法删除");
        }
        return MsgVO.setDellRS(DBO.service.D.ooDelete(ids, Loufang.class, Loufang2.class));
    }
    /**
     * 修改 一条记录（一个表头，多个表体。即一对多表）<br>
     * 本方法采用删除旧表体的方法，强烈建议反审核时，此单一定是没有其他引用才可以反审，反审后才能修改。<br>
     * 否则，如果其他单据有引用表体的id的话，此单某部分数据结构就会失去关联
     *
     * @param obj 表头对象
     * @param list 表体集合
     * @return MsgVO
     */
    public static MsgVO update(Loufang obj, List<Loufang2> list) {
        if (null == obj.getLoufang_zj() || obj.getLoufang_zj().length() != 24) {
            return MsgVO.setError("修改异常,表头信息丢失，请退出修改界面后，重新操作");
        }    
        plugins.Table<Loufang2> table = new plugins.Table(list);
        if(!table.isUnique("loufang2_bianhao")){
            return MsgVO.setError("修改异常,表体编号不唯一，请调整后再试");
        }
        if (selectOne(obj.getLoufang_zj()).getLoufang_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        int[] i = DBO.service.ADUS.executeBatch(
                //loufang_zt,隔离标识
                DBO.service.SQL.updateSome_reject(obj, "loufang_zt,loufang_gelibiaoshi")//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(Loufang2.class, "WHERE loufang_zj='" + obj.getLoufang_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(list)//加入新表体的值
        );
        if(null==i){
            return MsgVO.setError("修改操作异常。请通知管理查询服务器日志");
        }
        return MsgVO.setUpdateRS(i[0]);
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
        return BaseService.updateStyle_unExamine(ids,  TABLE1, PK1, STYLE1);
    }

    /**
     * 作废
     *
     * @param ids
     * @return
     */
    public static MsgVO updateStyle_void(String ids) {
        return BaseService.updateStyle_void(ids,  TABLE1, PK1, STYLE1);
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

//---------------------------------------隔离标识管理--------------------------------------
    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<Loufang> list = DBO.service.S.selectByCondition(Loufang.class, "WHERE loufang_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list,GE_LI_BIAO_SHI, gelibiaoshi);
    }
    public static boolean isErrorGelibiaoshiVast(List<Loufang> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list,GE_LI_BIAO_SHI, gelibiaoshi);
    }
    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        Loufang obj = DBO.service.S.selectOneByID(Loufang.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj,GE_LI_BIAO_SHI, gelibiaoshi);
    }
    public static boolean isErrorGelibiaoshiOne(Loufang obj, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiOne(obj,GE_LI_BIAO_SHI, gelibiaoshi);
    }

}
