package wx.web.service;

import configuration.mvc.BaseService;
import configuration.DBO;
import configuration.MsgVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import system.base.date.DateService;
import wx.web.bean.ChaoDianbiaoFengtan;
import wx.web.bean.ChaoShuibiaoFengtan;
import wx.web.bean.LoufangNafei;
import wx.web.bean.ZhusuHetong;
import wx.web.service.vo.ShuiDianVO;

/**
 *
 * @author wangchunzi
 */
final public class LoufangNafeiService {

    private static final String TABLE1 = "LoufangNafei";
    private static final String PK1 = "loufangnafei_zj";
    private static final String STYLE1 = "loufangnafei_zt";
    private static final String GE_LI_BIAO_SHI = "loufangnafei_gelibiaoshi";
//---------------------------------------查询---------------------------------------

    /**
     * 检出一条记录(表头)
     *
     * @param id 表头主键
     * @return LoufangNafei
     */
    public static LoufangNafei selectOne(String id) {
        return DBO.service.S.selectOneByID(LoufangNafei.class, id);
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
    public static List<LoufangNafei> select(final int page, final int size, final String where, final String ordery) {
        return DBO.service.S.selectVastByCondition(LoufangNafei.class, page, size, null == where ? "" : where, null == ordery ? "" : ordery);
    }

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
     * @param list
     * @param nfrq
     * @return
     */
    public static MsgVO addVast(List<ZhusuHetong> list, Date nfrq) {
        List<ChaoDianbiaoFengtan> dianF = ChaoDianbiaoService.select_feiyong(null);
        List<ChaoShuibiaoFengtan> shuiF = ChaoShuibiaoService.select_feiyong(null);
        Date zhidanriqi = new Date();
        String zhidanshijian = DateService.getDate(zhidanriqi, "yyyy-MM-dd HH:mm:ss");

        List<LoufangNafei> nflist = new ArrayList<>(list.size());
        StringBuilder idDian = new StringBuilder();
        StringBuilder idShui = new StringBuilder();
        for (ZhusuHetong htObj : list) {
            nflist.add(
                    iniOne(htObj, dianF, shuiF, nfrq, zhidanriqi, idDian, idShui)
            );
        }
        Set<String> sql = new HashSet();
        sql.add(DBO.service.SQL.addVast(nflist));
        if (idShui.length() > 0) {//更新水表的
            sql.add(ChaoShuibiaoService.getSQL_update_feiyong_nfsj(zhidanshijian, idShui.substring(1)));
        }
        if (idDian.length() > 0) {//更新电表的
            sql.add(ChaoDianbiaoService.getSQL_update_feiyong_nfsj(zhidanshijian, idDian.substring(1)));
        }
        int i[] = DBO.service.ADUS.executeBatch(sql.toArray(new String[sql.size()]));
//        int i = DBO.service.A.addVast(nflist);
        return i[0] > 0 ? MsgVO.setOK("出账成功" + i[1] + "条记录") : MsgVO.setError("没有或出账数据");
    }

    /**
     *
     * @param htObj 合同对象
     * @param dianF 电费集合
     * @param shuiF 水费集合
     * @param nfrq 纳费月份
     * @param zhidanriqi 制单日期
     * @param idDian
     * @param idShui
     * @return LoufangNafei
     */
    public static LoufangNafei iniOne(ZhusuHetong htObj,
            List<ChaoDianbiaoFengtan> dianF, List<ChaoShuibiaoFengtan> shuiF,
            Date nfrq, Date zhidanriqi,
            StringBuilder idDian, StringBuilder idShui) {
        LoufangNafei obj = new LoufangNafei();
        obj.setLoufangnafei_zt(0);
        obj.setLoufangnafei_gelibiaoshi(htObj.getZhusuhetong_gelibiaoshi());
        obj.setLoufangnafei_chuzhangshijian(null == zhidanriqi ? new Date() : zhidanriqi);
        //应纳费人
        obj.setLoufangnafei_ren(htObj.getZhusuhetong_qianyueren());
        obj.setLoufangnafei_ren_zj(htObj.getZhusuhetong_qianyueren_zj());
        //应该纳费日期
        obj.setLoufangnafei_yingnariqi(ZhusuHetongService.js_nfrq(htObj, nfrq));
        //楼，楼编号
        obj.setLoufangnafei_lou_mc(htObj.getZhusuhetong_loufang_mc());
        obj.setLoufangnafei_lou_zj(htObj.getZhusuhetong_loufang_zj());
        //房，房编号
        obj.setLoufangnafei_fang_bianma(htObj.getZhusuhetong_loufang2_bianhao());
        obj.setLoufangnafei_fang_zj(htObj.getZhusuhetong_loufang2_zj());
        //租金
        obj.setLoufangnafei_fangzu((double) htObj.getZhusuhetong_zujin());
        //项目费
        obj.setLoufangnafei_feiyong_xm((double) htObj.getZhusuhetong_tj_xml());//项目费
        obj.setLoufangnafei_feiyong_xm_zj(htObj.getZhusuhetong_xml_zj());//项目主键集合
        //水
        ShuiDianVO sdvo;
        sdvo = ChaoShuibiaoService.tj_feiyong(shuiF, htObj.getZhusuhetong_qianyueren_zj());
        obj.setLoufangnafei_feiyong_shui(sdvo.sum);
        obj.setLoufangnafei_feiyong_shui_zj(sdvo.ids);
        if (sdvo.ids.length() > 0) {
            idShui.append(",").append(sdvo.ids);
        }
        //电
        sdvo = ChaoDianbiaoService.tj_feiyong(dianF, htObj.getZhusuhetong_qianyueren_zj());
        obj.setLoufangnafei_feiyong_dian(sdvo.sum);
        obj.setLoufangnafei_feiyong_dian_zj(sdvo.ids);
        if (sdvo.ids.length() > 0) {
            idDian.append(",").append(sdvo.ids);
        }
        //总费用
        obj.setLoufangnafei_zongfeiyong(
                obj.getLoufangnafei_fangzu() + obj.getLoufangnafei_feiyong_xm() + obj.getLoufangnafei_feiyong_shui() + obj.getLoufangnafei_feiyong_dian()
        );
        //锁定已交的费用为0
        obj.setLoufangnafei_zongfeiyong2(0D);
        return obj;
    }

    /**
     * 删除指定数据。-1表示 不是未级，不能删除。
     *
     * @param id
     * @return
     */
    public static MsgVO dellOne(String id) {
        LoufangNafei cobj = selectOne(id);
        if (null == cobj || null == cobj.getLoufangnafei_zj() || cobj.getLoufangnafei_zt() != BaseService.XINZENG) {
            return MsgVO.setError("没找到该记录。请刷新后再尝试");
        }
        int i = DBO.service.D.deleteOneByID_CheckToDeny(LoufangNafei.class, id, "loufangnafei_zt<>0");
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
    public static MsgVO update(LoufangNafei obj) {

        if (selectOne(obj.getLoufangnafei_zj()).getLoufangnafei_zt() != BaseService.XINZENG) {
            return MsgVO.setError();
        }
        return MsgVO.setUpdateRS(DBO.service.U.updateSome_reject(obj,
                //loufangnafei_zt,隔离标识,出账时间
                "loufangnafei_zt,loufangnafei_gelibiaoshi,loufangnafei_chuzhangshijian"));
    }
//---------------------------------------隔离标识管理--------------------------------------

    public static boolean isErrorGelibiaoshiVast(String ids, String gelibiaoshi) {
        List<LoufangNafei> list = DBO.service.S.selectByCondition(LoufangNafei.class, "WHERE loufangnafei_zj IN(" + configuration.Tool.replaceDToDDD(ids) + ")");
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiVast(List<LoufangNafei> list, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiVast(list, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(String id, String gelibiaoshi) {
        LoufangNafei obj = DBO.service.S.selectOneByID(LoufangNafei.class, id);
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
    }

    public static boolean isErrorGelibiaoshiOne(LoufangNafei obj, String gelibiaoshi) {
        return BaseService.isErrorGelibiaoshiOne(obj, GE_LI_BIAO_SHI, gelibiaoshi);
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
