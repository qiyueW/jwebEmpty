package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class LoufangFYBZValidate extends ValidateModel {

    public LoufangFYBZValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("loufang_fybz_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("loufang_fybz_loufang_zj","[1-9]{1}[0-9]{23}", "楼房主键丢失", true)//楼房主键
                .put("loufang_fybz_loufang_mc","[\\w\\W]{1,20}", "楼名:文本为空或长度超20字符", true)//楼名
                .put("loufang_fybz_dianfei","-?[0-9]{1,7}.?[0-9]{0,3}", "电费标准:请输入合法数字。正数位在7位内，小数位在3位内", true)//电费标准
                .put("loufang_fybz_shuifei","-?[0-9]{1,7}.?[0-9]{0,3}", "水费标准:请输入合法数字。正数位在7位内，小数位在3位内", true)//水费标准
                .put("loufang_fybz_shuifei_leng","-?[0-9]{0,7}.?[0-9]{0,3}", "冷水费标准:请输入合法数字。正数位在7位内，小数位在3位内", true)//冷水费标准
                .put("loufang_fybz_shuifei_re","-?[0-9]{0,7}.?[0-9]{0,3}", "热水费标准:请输入合法数字。正数位在7位内，小数位在3位内", true)//热水费标准
                .put("loufang_fybz_meiqi","-?[0-9]{0,7}.?[0-9]{0,3}", "煤气费标准:请输入合法数字。正数位在7位内，小数位在3位内", true)//煤气费标准
                .put("loufang_fybz_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}