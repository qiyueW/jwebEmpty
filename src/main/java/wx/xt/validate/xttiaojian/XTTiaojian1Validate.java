package wx.xt.validate.xttiaojian;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateJsonModel;
import system.web.validate.model.ValidateModel;
import wx.xt.bean.xttiaojian.XTTiaojian1;

public class XTTiaojian1Validate extends ValidateModel {

    public XTTiaojian1Validate() {
        super(JSON_MODEL);
        ValidateJsonModel jsonEngine = new ValidateJsonModel(XTTiaojian1.class);
        this.openJSONEngine(jsonEngine);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_tiaojian1_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_tiaojian_zj","[1-9]{1}[0-9]{23}", "表头主键丢失", false)//表头主键
                .put("xt_tiaojian1_kuohao","[\\w\\W]{0,20}", "括号区:长度超20字符", false)//括号区
                .put("xt_tiaojian1_lianjiefu","[\\w\\W]{0,20}", "接连符:长度超20字符", false)//接连符
                .put("xt_tiaojian1_lianjiefu_mc","[\\w\\W]{0,20}", "接连符展示名:长度超20字符", false)//接连符展示名
                .put("xt_shezhi_tiaojian1_mc","[\\w\\W]{1,20}", "条件区展示名:文本为空或长度超20字符", false)//条件区展示名
                .put("xt_shezhi_tiaojian1_zhi","[\\w\\W]{1,200}", "条件区值:文本为空或长度超20字符", false)//条件区值
                .put("xt_tiaojian1_panduan","[\\w\\W]{1,20}", "判断区:文本为空或长度超20字符", false)//判断区
                .put("xt_tiaojian1_panduan_mc","[\\w\\W]{1,20}", "判断区展示名:文本为空或长度超20字符", false)//判断区展示名
                .put("xt_tiaojian1_zhi","[\\w\\W]{0,20}", "条件值:长度超20字符", false)//条件值
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}