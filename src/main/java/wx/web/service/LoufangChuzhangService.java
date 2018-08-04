package wx.web.service;

import configuration.DBO;
import configuration.MsgVO;
import java.util.Date;
import java.util.List;
import wx.web.bean.LoufangNafei;
import wx.web.bean.RY;
import wx.web.bean.ZhusuHetong;

/**
 *
 * @author wangchunzi
 */
final public class LoufangChuzhangService {

//---------------------------------------查询---------------------------------------
//---------------------------------------统计区--------------------------------------
    /**
     * 统计表头数据(条件为null或为空时，表示统计整张表)
     *
     * @param where 条件
     * @return int
     */
    public static int selectCount(final String where) {
        return null == where || where.isEmpty() ? DBO.service.S.selectCount(LoufangNafei.class) : DBO.service.S.selectCountByCondition(LoufangNafei.class, where);
    }
//---------------------------------------增删改--------------------------------------

    /**
     * 添加数据
     *
     * @param htObj
     * @param nfrq
     * @return
     */
    public static MsgVO addOne(List<ZhusuHetong> htObj, Date nfrq) {
        return LoufangNafeiService.addVast(htObj,nfrq);
    }
}
