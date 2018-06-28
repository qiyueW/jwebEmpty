package wx.xt.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XtGuanliyuanJueseValidate extends ValidateModel {

    public XtGuanliyuanJueseValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_guanliyuanjuese_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_guanliyuan_zj", "[1-9]{1}[0-9]{23}", "管理员主键丢失", true)//管理员主键
                .put("xt_juese_zj", "[\\w\\W]+", "角色主键集合:文本为空", false)//角色主键集合
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}