package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class ChaoShuibiaoValidate extends ValidateModel {

    public ChaoShuibiaoValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("chaoshuibiao_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("chaoshuibiao_loufang_zj","[1-9]{1}[0-9]{23}", "楼主键丢失", true)//楼主键
                .put("chaoshuibiao_loufang_mc","[\\w\\W]{1,20}", "楼名称:文本为空或长度超20字符", true)//楼名称
                .put("chaoshuibiao_loufang2_zj","[1-9]{1}[0-9]{23}", "房主键丢失", true)//房主键
                .put("chaoshuibiao_loufang2_bianma","[\\w\\W]{1,20}", "房编号:文本为空或长度超20字符", true)//房编号
                .put("chaoshuibiao_dushu1","-?[0-9]{0,10}.?[0-9]{0,1}", "上次读数:请输入合法数字。正数位在10位内，小数位在1位内", true)//上次读数
                .put("chaoshuibiao_riqi1","[0-9]{4}-[0-9]{2}-[0-9]{2}", "上次抄表日期:请输入时间。例1988-08-21", false)//上次抄表日期
                .put("chaoshuibiao_dushu2","-?[0-9]{0,10}.?[0-9]{0,1}", "读数:请输入合法数字。正数位在10位内，小数位在1位内", true)//读数
                .put("chaoshuibiao_riqi2","[0-9]{4}-[0-9]{2}-[0-9]{2}", "抄表日期:请输入时间。例1988-08-21", true)//抄表日期
//                .put("chaoshuibiao_shui","-?[0-9]{0,10}.?[0-9]{0,1}", "水(吨):请输入合法数字。正数位在10位内，小数位在1位内", true)//水(吨)
//                .put("chaoshuibiao_shui_danjia","-?[0-9]{0,10}.?[0-9]{0,1}", "水单价:请输入合法数字。正数位在7位内，小数位在3位内", true)//水单价
//                .put("chaoshuibiao_shui_jine","-?[0-9]{0,10}.?[0-9]{0,1}", "金额:请输入合法数字。正数位在10位内，小数位在1位内", true)//金额
//                .put("chaoshuibiao_fentanrenshu","[0-9]{1,11}", "分摊人数:请输入正整数。位数在1-11位之间", true)//分摊人数
//                .put("chaoshuibiao_yj_fentanrenshu","[0-9]{1,11}", "已分摊人数:请输入正整数。位数在1-11位之间", true)//已分摊人数
//                .put("chaoshuibiao_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}