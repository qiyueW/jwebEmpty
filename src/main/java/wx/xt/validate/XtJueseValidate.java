package wx.xt.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XtJueseValidate extends ValidateModel {

    public XtJueseValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_juese_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("xt_juese_fzj","(0{1})|([1-9]{1}[0-9]{23})", "父键丢失", false)//父键
                .put("xt_juese_mc","[\\w\\W]{1,200}", "名称:文本为空或长度超200字符", true)//名称
                .put("xt_juese_dm","[\\w\\W]{1,20}", "代码:文本为空或长度超20字符", true)//代码
                .put("xt_juese_gongsi","[0|1|2|3|4]{1}", "公私角色:请输入正整数。位数在1-1位之间", true)//公私角色
                .put("xt_juese_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("xt_juese_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", false)//状态
//                .put("xt_juese_gelibiaoshi","[\\w\\W]{0,20}", "隔离标识:长度超20字符", false)//隔离标识
//                .put("xt_juese_zhidanren_zj","[1-9]{1}[0-9]{23}", "制单人主键丢失", true)//制单人主键
//                .put("xt_juese_zhidanren","[\\w\\W]{1,20}", "制单人:文本为空或长度超20字符", true)//制单人
//                .put("xt_juese_xiugairen_zj","[1-9]{1}[0-9]{23}", "修改人主键丢失", false)//修改人主键
//                .put("xt_juese_xiugairen","[\\w\\W]{0,20}", "修改人:长度超20字符", false)//修改人
//                .put("xt_juese_xiugaishijian","[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}", "修改时间:请输入时间。例1988-08-21 12:30:59", false)//修改时间
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}