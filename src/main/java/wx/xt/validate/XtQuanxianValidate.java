package wx.xt.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XtQuanxianValidate extends ValidateModel {

    public XtQuanxianValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_quanxian_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_quanxian_fzj", "(0{1})|([1-9]{1}[0-9]{23})", "父键丢失", false)//父键
                .put("xt_quanxian_px", "[0-9]{0,11}", "排序:请输入正整数。位数在0-11位之间", false)//排序
                .put("xt_quanxian_mc", "[\\w\\W]{1,200}", "名称:文本为空或长度超200字符", true)//名称
                .put("xt_quanxian_dm", "[\\w\\W]{1,200}", "权限代码:文本为空或长度超200字符", true)//权限代码
                .put("xt_quanxian_url", "[\\w\\W]{0,200}", "url:长度超200字符", false)//url
                .put("xt_quanxian_keshi", "[0|1|2]{1}", "可视:请输入正整数。位数在1-1位之间", true)//可视
                .put("xt_quanxian_zhankai", "[\\w\\W]{0,8}", "展开:长度超8字符", false)//展开
                .put("xt_quanxian_bz", "[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("xt_quanxian_zt", "[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
                .put("xt_quanxian_gelibiaoshi", "[\\w\\W]{0,200}", "隔离标识:长度超200字符", false)//隔离标识
                .put("xt_quanxian_jibie", "[0|1|2|3]{1}", "级别:请输入正整数。位数在1-1位之间", true)//级别
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}
