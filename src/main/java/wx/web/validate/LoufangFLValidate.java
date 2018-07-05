package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class LoufangFLValidate extends ValidateModel {

    public LoufangFLValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("loufangfl_px","[0-9]{0,11}", "排序:请输入正整数。位数在0-11位之间", false)//排序
                .put("loufangfl_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("loufangfl_fzj","(0{1})|([1-9]{1}[0-9]{23})", "父主键丢失", false)//父主键
                .put("loufangfl_mc","[\\w\\W]{1,20}", "名称:文本为空或长度超20字符", true)//名称
                .put("loufangfl_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("loufangfl_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}