package wx.web.service;

import configuration.DBO;
import configuration.MsgVO;
import java.util.Date;
import java.util.List;
import wx.web.bean.TestMyxx;

/**
 *
 * @author wo
 */
final public class TestMyxxService {
//---------------------------------------查询---------------------------------------

    /**
     * 检出树
     *
     * @return List
     */
    public static List<TestMyxx> select() {
        return DBO.service.S.select(TestMyxx.class);
    }

    /**
     * 检出一条记录
     *
     * @param id
     * @return TestMyxx
     */
    public static TestMyxx selectOne(String id) {
        return DBO.service.S.selectOneByID(TestMyxx.class, id);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param obj
     * @return
     */
    public static MsgVO addOne(TestMyxx obj) {
        obj.setTestmyxx_zhidanshijian(new Date());
        int i = DBO.service.A.addOne(obj,"testmyxx_name2");
        if(i==-1){
            return MsgVO.setError("添加异常：请检查这些字段(名称2)是否唯一");
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
        TestMyxx cobj = selectOne(id);
        if (null == cobj||null==cobj.getTestmyxx_zj()) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }        
        List<TestMyxx> list = select();
        for (TestMyxx fl : list) {
            if (fl.getTestmyxx_pid().equals(id)) {//表示删除的对象，存在子级。
                return MsgVO.setError("删除的对象存在子级");
            }
        }
        int i = DBO.service.D.dellByID(TestMyxx.class, id);
        return MsgVO.setDellRS(i);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(TestMyxx obj) {

  
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
        //制单时间
                "testmyxx_zhidanshijian"));
    }
}
