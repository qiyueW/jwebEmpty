package wx.xt.validate.xttiaojian;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XTTiaojianValidate extends ValidateModel {

    public XTTiaojianValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_tiaojian_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_shezhi_tiaojian_zhi","[\\w\\W]{1,20}", "模块标识符异常", true)//使用值
                .put("xt_tiaojian_mc","[\\w\\W]{1,20}", "条件方案名称:文本为空或长度超20字符", true)//条件方案名称
//                .put("xt_tiaojian_zhidanren_zj","[1-9]{1}[0-9]{23}", "方案制定人主键丢失", true)//方案制定人主键
//                .put("xt_tiaojian_gelibiaoshi","[\\w\\W]{1,20}", "单据隔离标识:文本为空或长度超20字符", false)//单据隔离标识
//                .put("xt_tiaojian_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", false)//状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}