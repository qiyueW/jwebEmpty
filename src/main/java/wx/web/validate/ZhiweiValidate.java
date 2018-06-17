package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class ZhiweiValidate extends ValidateModel {

    public ZhiweiValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("zhiwei_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("zhiwei_fzj","(0{1})|([1-9]{1}[0-9]{23})", "父键丢失", false)//父键
                .put("zhiwei_mc","[\\w\\W]{1,200}", "名称:文本为空或长度超200字符", true)//名称
                .put("zhiwei_bz","[\\w\\W]{0,300}", "备注:长度超300字符", false)//备注
                .put("zhiwei_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
                .put("zhiwei_gelibiaoshi","[\\w\\W]{1,20}", "隔离标识:文本为空或长度超20字符", true)//隔离标识
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}