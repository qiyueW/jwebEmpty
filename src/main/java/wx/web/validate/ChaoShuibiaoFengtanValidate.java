package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateJsonModel;
import system.web.validate.model.ValidateModel;
import wx.web.bean.ChaoShuibiaoFengtan;

public class ChaoShuibiaoFengtanValidate extends ValidateModel {

    public ChaoShuibiaoFengtanValidate() {
        super(JSON_MODEL);
        ValidateJsonModel jsonEngine = new ValidateJsonModel(ChaoShuibiaoFengtan.class);
        this.openJSONEngine(jsonEngine);
    }

    @Override
    public void iniValidate() {
        super
                .put("chaoshuibiaofengtan_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("chaoshuibiao_zj","[1-9]{1}[0-9]{23}", "水表记录主键丢失", true)//水表记录主键
                .put("chaoshuibiaofengtan_shui","-?[0-9]{0,10}.?[0-9]{0,1}", "水:请输入合法数字。正数位在10位内，小数位在1位内", true)//水
                .put("chaoshuibiaofengtan_shui_danjia","-?[0-9]{0,9}.?[0-9]{0,3}", "水单价:请输入合法数字。正数位在7位内，小数位在3位内", true)//水单价
                .put("chaoshuibiaofengtan_feiyong","-?[0-9]{0,10}.?[0-9]{0,1}", "分摊费:请输入合法数字。正数位在10位内，小数位在1位内", true)//分摊费
                .put("chaoshuibiaofengtan_nfr","[\\w\\W]{1,20}", "纳费人:文本为空或长度超20字符", false)//纳费人
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}