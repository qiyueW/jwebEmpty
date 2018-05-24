package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;
import java.util.Date;
import wx.web.bean.Mytest;

/**
 *
 * @author wo
 */
final public class MytestService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<Mytest> select() {
        return DBO.service.S.select(Mytest.class);
    }

    /**
     * 检出一条记录
     *
     * @param id
     * @return Mytest
     */
    public static Mytest selectOne(String id) {
        return DBO.service.S.selectOneByID(Mytest.class, id);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(Mytest obj) {
        obj.setMytest_zhidanshijian(new Date());
        int i = DBO.service.A.addOne(obj, "mytest_bianhao");
        if (i == -1) {
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
        Mytest cobj = selectOne(id);
        if (null == cobj || null == cobj.getMytest_zj()) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        List<Mytest> list = select();
        for (Mytest fl : list) {
            if (fl.getMytest_fzj().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.dellByID(Mytest.class, id);
        return MsgVO.setDellRS(i);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(Mytest obj) {

        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
                //制单时间
                "mytest_zhidanshijian"));
    }
}
