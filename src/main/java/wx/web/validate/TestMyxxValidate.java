package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class TestMyxxValidate extends ValidateModel {

    public TestMyxxValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("testmyxx_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("testmyxx_pid","(0{1})|([1-9]{1}[0-9]{23})", "父键丢失", false)//父键
                .put("testmyxx_name","[\\w\\W]{1,200}", "名称:文本为空或长度超200字符", true)//名称
                .put("testmyxx_name2","[\\w\\W]{1,50}", "名称2:文本为空或长度超50字符", true)//名称2
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}