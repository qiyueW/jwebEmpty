package wx.web.service.vo;

import configuration.DBO;
import configuration.Tool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wx.web.bean.Loufang;
import wx.web.bean.Loufang2;
import wx.web.bean.ZhusuHetong;
import wx.web.service.LoufangService;

/**
 *
 * @author JWeb
 */
public class FangHTVO {

    public final Map<String, Loufang> lou = new HashMap();
    public final Map<String, Loufang2> fang = new HashMap();

    public Loufang getLoufang(final ZhusuHetong zh) {
        Loufang l = lou.get(zh.getZhusuhetong_loufang_zj());
        if (null == l) {
            l = LoufangService.selectOne(zh.getZhusuhetong_loufang_zj());
            lou.put(zh.getZhusuhetong_loufang_zj(), l);
        }
        return l;
    }

    public Loufang2 getLoufang2(final ZhusuHetong zh) {
        Loufang2 l = fang.get(zh.getZhusuhetong_loufang2_zj());
        if (null == l) {
            l = LoufangService.selectOne2(zh.getZhusuhetong_loufang2_zj());
            fang.put(zh.getZhusuhetong_loufang2_zj(), l);
        }
        return l;
    }

    /**
     * 添加合同时，对合同的房数进行数据更新。
     * <p>
     * 楼：总的入住人数（单/套)
     * <p>
     * 房：入住人数，入住人主键<p>
     * @param lou Loufang
     * @param fang Loufang2
     * @param ry_zj String
     */
    public void addHT(Loufang lou, Loufang2 fang, String ry_zj) {
        //入住人数+1
        fang.setLoufang2_ruzhurenshu(fang.getLoufang2_ruzhurenshu() + 1);
        //入住人主键集合增加
        fang.setLoufang2_ruzhuren_zj(Tool.isEmpty(fang.getLoufang2_ruzhuren_zj()) ? ry_zj : fang.getLoufang2_ruzhuren_zj() + "," + ry_zj);
        //更新楼的数据，如果是单间-入住人+1
        if (fang.getLoufang2_lx().equals(LoufangService.FANGJIAN_LX_DANJIAN)) {
            lou.setLoufang_danjian_chuangwei2(lou.getLoufang_danjian_chuangwei2() + 1);
        } else {//套间-入住人+1
            lou.setLoufang_taojian_chuangwei2(lou.getLoufang_taojian_chuangwei2() + 1);
        }
    }

    /**
     * 删除或作废合同时，对合同的房数进行数据更新。
     * <p>
     * 楼：总的入住人数（单/套)
     * <p>
     * 房：入住人数，入住人主键<p>
     * @param lou Loufang
     * @param fang Loufang2
     * @param ry_zj String
     */
    public void dellOrVoidHT(Loufang lou, Loufang2 fang, String ry_zj) {
        //入住人数-1
        fang.setLoufang2_ruzhurenshu(fang.getLoufang2_ruzhurenshu() - 1);
        //入住人主键集合减少
        if (fang.getLoufang2_ruzhuren_zj().equals(ry_zj)) {//只有一个人住时
            fang.setLoufang2_ruzhuren_zj("");
        } else {
            String[] zjs = fang.getLoufang2_ruzhuren_zj().split(",");
            StringBuilder sb = new StringBuilder();
            for (String str : zjs) {
                if (!str.equals(ry_zj)) {
                    sb.append(",").append(str);
                }
            }
            fang.setLoufang2_ruzhuren_zj(sb.length() > 0 ? sb.substring(1) : "");
        }
        //更新楼的数据，如果是单间-入住人-1
        if (fang.getLoufang2_lx().equals(LoufangService.FANGJIAN_LX_DANJIAN)) {
            lou.setLoufang_danjian_chuangwei2(lou.getLoufang_danjian_chuangwei2() - 1);
        } else {//套间-入住人-1
            lou.setLoufang_taojian_chuangwei2(lou.getLoufang_taojian_chuangwei2() - 1);
        }
    }

    public static List<String> getSQL_ByHT(final FangHTVO vo, List<String> contair) {
        if (null == contair) {
            contair = new ArrayList<>();
        }
        for (Map.Entry<String, Loufang> kv : vo.lou.entrySet()) {
            // 已用单间床位，已用套间床位
            contair.add(DBO.service.SQL.updateSome_alloy(kv.getValue(), "loufang_danjian_chuangwei2,loufang_taojian_chuangwei2"));
        }
        for (Map.Entry<String, Loufang2> kv : vo.fang.entrySet()) {
            // 入住人数   入住人主键集合 
            contair.add(DBO.service.SQL.updateSome_alloy(kv.getValue(), "loufang2_ruzhurenshu,loufang2_ruzhuren_zj"));
        }
        return contair;
    }
}
