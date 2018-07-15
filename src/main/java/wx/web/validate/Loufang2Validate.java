package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateJsonModel;
import system.web.validate.model.ValidateModel;
import wx.web.bean.Loufang2;

public class Loufang2Validate extends ValidateModel {

    public Loufang2Validate() {
        super(JSON_MODEL);
        ValidateJsonModel jsonEngine = new ValidateJsonModel(Loufang2.class);
        this.openJSONEngine(jsonEngine);
    }

    @Override
    public void iniValidate() {
        super
                .put("loufang_zj","[1-9]{1}[0-9]{23}", "父键丢失", false)//父键
                .put("loufang2_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("loufang2_bianhao","[\\w\\W]{1,20}", "编号:文本为空或长度超20字符", true)//编号
                .put("loufang2_mingcheng","[\\w\\W]{1,20}", "名称:文本为空或长度超20字符", true)//名称
                .put("loufang2_chuangwei","[0-9]{1,11}", "床位:请输入正整数。位数在1-11位之间", true)//床位
                .put("loufang2_ruzhurenshu","[0-9]{1,11}", "入住人数:请输入正整数。位数在1-11位之间", true)//入住人数
                .put("loufang2_ruzhuren_zj","[\\w\\W]+", "入住人主键集合:文本为空", false)//入住人主键集合
                .put("loufang2_lx","[\\w\\W]{0,20}", "房间类型:长度超20字符", false)//房间类型
                .put("loufang2_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}