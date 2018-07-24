package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class LoufangValidate extends ValidateModel {

    public LoufangValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("loufang_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("loufangfl_zj","[1-9]{1}[0-9]{23}", "分类外键丢失", true)//分类外键
                .put("loufang_mc","[\\w\\W]{1,20}", "名称:文本为空或长度超20字符", true)//名称
                .put("loufang_dizhi","[\\w\\W]{0,200}", "地址:长度超200字符", false)//地址
                .put("loufang_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("loufang_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", false)//状态
                .put("loufang_danjian_chuangwei","[0-9]{0,11}", "单间床位:请输入正整数。位数在0-11位之间", false)//单间床位
                .put("loufang_danjian_chuangwei2","[0-9]{0,11}", "已用单间床位:请输入正整数。位数在0-11位之间", false)//已用单间床位
                .put("loufang_taojian_chuangwei","[0-9]{0,11}", "套间床位:请输入正整数。位数在0-11位之间", false)//套间床位
                .put("loufang_taojian_chuangwei2","[0-9]{0,11}", "已用套间床位:请输入正整数。位数在0-11位之间", false)//已用套间床位
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}