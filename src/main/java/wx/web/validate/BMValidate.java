package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class BMValidate extends ValidateModel {

    public BMValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("bm_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("bm_fzj","(0{1})|([1-9]{1}[0-9]{23})", "父键丢失", false)//父键
                .put("bm_mc","[\\w\\W]{1,200}", "名称:文本为空或长度超200字符", true)//名称
                .put("bm_bianma","[\\w\\W]{1,10}", "编码:文本为空或长度超10字符", true)//编码
                .put("bm_jianjie","[\\w\\W]+", "部门简介:文本为空", false)//部门简介
                .put("bm_tupian1","[\\w\\W]{0,200}", "部门图片1:图片名及路径长度超200字符", false)//部门图片1
                .put("bm_tupian2","[\\w\\W]{0,200}", "部门图片2:图片名及路径长度超200字符", false)//部门图片2
                .put("bm_fuzhiren_zj","[1-9]{1}[0-9]{23}", "部门负责人主键丢失", false)//部门负责人主键
                .put("bm_fuzhiren","[\\w\\W]{0,20}", "部门负责人:长度超20字符", false)//部门负责人
                .put("bm_zt","[0|1|2|3|4]{1}", "部门状态:请输入正整数。位数在1-1位之间", true)//部门状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}