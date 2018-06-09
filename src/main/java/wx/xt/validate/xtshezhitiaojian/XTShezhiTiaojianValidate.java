package wx.xt.validate.xtshezhitiaojian;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XTShezhiTiaojianValidate extends ValidateModel {

    public XTShezhiTiaojianValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_shezhi_tiaojian_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_shezhi_tiaojian_mc","[\\w\\W]{1,20}", "展示名称:文本为空或长度超20字符", true)//展示名称
                .put("xt_shezhi_tiaojian_zhi","[\\w\\W]{1,20}", "使用值:文本为空或长度超20字符", true)//使用值
                .put("xt_shezhi_tiaojian_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("xt_shezhi_tiaojian_zt","[0|1|2|3|4]{1}", "单据状态管理:请输入正整数。位数在1-1位之间", false)//单据状态管理
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}