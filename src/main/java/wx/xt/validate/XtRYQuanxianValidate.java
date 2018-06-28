package wx.xt.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XtRYQuanxianValidate extends ValidateModel {

    public XtRYQuanxianValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_ryquanxian_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_ry_zj","[1-9]{1}[0-9]{23}", "人员主键丢失", true)//人员主键
                .put("xt_juese_zj","[\\w\\W]+", "角色主键集合:文本为空", false)//角色主键集合
                .put("xt_quanxian","[\\w\\W]+", "权限代码集合:文本为空", false)//权限代码集合
//                .put("xt_ryquanxian_zhidanren","[1-9]{1}[0-9]{23}", "制单人丢失", true)//制单人
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}