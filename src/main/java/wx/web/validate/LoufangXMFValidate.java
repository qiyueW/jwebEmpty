package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class LoufangXMFValidate extends ValidateModel {

    public LoufangXMFValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("loufangxmf_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("loufangxmf_mc","[\\w\\W]{1,20}", "项目名称:文本为空或长度超20字符", true)//项目名称
                .put("loufangxmf_feiyong","[0-9]{1,11}", "项目费:请输入正整数。位数在1-11位之间", true)//项目费
                .put("loufangxmf_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}