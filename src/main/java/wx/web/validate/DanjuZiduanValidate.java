package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateJsonModel;
import system.web.validate.model.ValidateModel;
import wx.web.bean.DanjuZiduan;

public class DanjuZiduanValidate extends ValidateModel {

    public DanjuZiduanValidate() {
        super(JSON_MODEL);
        ValidateJsonModel jsonEngine = new ValidateJsonModel(DanjuZiduan.class);
        this.openJSONEngine(jsonEngine);
    }

    @Override
    public void iniValidate() {
        super
                .put("danjuziduan_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("danju_zj","[1-9]{1}[0-9]{23}", "表头id丢失", false)//表头id
                .put("danjuziduan_mc","[\\w\\W]{1,200}", "字段名称:文本为空或长度超200字符", true)//字段名称
                .put("danjuziduan_daima","[\\w\\W]{1,200}", "字段代码:文本为空或长度超200字符", true)//字段代码
                .put("danjuziduan_leixing","[\\w\\W]{0,200}", "字段类型:长度超200字符", false)//字段类型
                .put("danjuziduan_xiaoshudian","[0-9]{0,11}", "字段小数点:请输入正整数。位数在0-11位之间", false)//字段小数点
                .put("danjuziduan_changdu","[\\w\\W]{2,10}", "字段长度:长度超10字符", true)//字段长度
                .put("danjuziduan_jiaonian","[\\w\\W]{0,10}", "是否必须校验:长度超10字符", false)//是否必须校验
                .put("danjuziduan_jiaoniankuizhi","[\\w\\W]{0,300}", "检验规则:长度超300字符", false)//检验规则
                .put("danjuziduan_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("danjuziduan_px","[0-9]{0,11}", "排序:请输入正整数。位数在0-11位之间", false)//排序
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}