package wx.xt.validate.xtshezhitiaojian;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateJsonModel;
import system.web.validate.model.ValidateModel;
import wx.xt.bean.xtshezhitiaojian.XTShezhiTiaojian1;

public class XTShezhiTiaojian1Validate extends ValidateModel {

    public XTShezhiTiaojian1Validate() {
        super(JSON_MODEL);
        ValidateJsonModel jsonEngine = new ValidateJsonModel(XTShezhiTiaojian1.class);
        this.openJSONEngine(jsonEngine);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_shezhi_tiaojian1_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_shezhi_tiaojian_zj","[1-9]{1}[0-9]{23}", "表头主键丢失", false)//表头主键
                .put("xt_shezhi_tiaojian1_mc","[\\w\\W]{1,20}", "条件名:文本为空或长度超20字符", true)//条件名
                .put("xt_shezhi_tiaojian1_zhi","[\\w\\W]{1,200}", "条件值:文本为空或长度超200字符", true)//条件值
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}