package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.List;
import java.util.Date;
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
    private static final String STYLE1 = "";
    
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
        int i = DBO.service.A.addOne(obj,"ry_zhanghao");
        if(i==-1){
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
        if (null == cobj||null==cobj.getRy_zj()) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }        
        int i = DBO.service.D.dellByID(RY.class, id);
        return MsgVO.setDellRS(i);
    }

    /**
     * 修改对象（reject字段的不进行修改）
     *
     * @param obj
     * @return
     */
    public static MsgVO update(RY obj) {

        return MsgVO.setUpdateRS(DBO.service.U.update_notNull(obj));
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
        FI upOne = file.upOne(configuration.file.OfficeFileModel.class);//可以自己写一个Model 系统默认office系列小部分
        return upOne;
    }
}
