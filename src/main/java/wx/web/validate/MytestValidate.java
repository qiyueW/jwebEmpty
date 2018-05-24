package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class MytestValidate extends ValidateModel {

    public MytestValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("mytest_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("mytest_fzj","(0{1})|([1-9]{1}[0-9]{23})", "父键丢失", false)//父键
                .put("mytest_mc","[\\w\\W]{1,200}", "名称:文本为空或长度超200字符", true)//名称
                .put("mytest_bianhao","[\\w\\W]{1,10}", "编号:文本为空或长度超10字符", true)//编号
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}