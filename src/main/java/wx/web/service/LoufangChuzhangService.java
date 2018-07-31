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
     * @param hetong_zjs
     * @param ryObj
     * @return
     */
    public static MsgVO addOne(String hetong_zjs, RY ryObj) {
        List<ZhusuHetong> htObj = ZhusuHetongService.selectByIDs_Shenhe(hetong_zjs);
        if (null == htObj || htObj.isEmpty()) {
            return MsgVO.setError("没找到可用的合同。请检查合同是否已经【审核】");
        }
        if (ZhusuHetongService.isErrorGelibiaoshiVast(htObj, ryObj.getRy_gelibiaoshi())) {//跨域
            return null;
        }
        LoufangNafei obj=new LoufangNafei();
        Date now=new Date();
        obj.setLoufangnafei_chuzhangshijian(now);
        obj.setLoufangnafei_fang_bianma(hetong_zjs);
        LoufangNafeiService.addOne(obj);
        return MsgVO.setAddRS(1);
    }
}
