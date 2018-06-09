package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class DanjuValidate extends ValidateModel {

    public DanjuValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("danjufl_zj","[1-9]{1}[0-9]{23}", "分类ID丢失", false)//分类ID
                .put("danju_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("danju_mc","[\\w\\W]{1,200}", "模块名:文本为空或长度超200字符", true)//模块名
                .put("danju_daima","[\\w\\W]{1,200}", "模块代码:文本为空或长度超200字符", true)//模块代码
                .put("danju_qianzhui","[\\w\\W]{0,200}", "单据前缀:长度超200字符", false)//单据前缀
                .put("danju_shijian","[\\w\\W]{0,200}", "单据时间:长度超200字符", false)//单据时间
                .put("danju_liushuihao","[\\w\\W]{0,200}", "单据流水号:长度超200字符", false)//单据流水号
                .put("danju_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("danju_zhidanren_zj","[1-9]{1}[0-9]{23}", "制单人丢失", false)//制单人
                .put("danju_xiugairen_zj","[1-9]{1}[0-9]{23}", "修改人丢失", false)//修改人
                .put("danju_xiugaishijian","[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}", "修改时间:请输入时间。例1988-08-21 12:30:59", false)//修改时间
                .put("danju_px","[0-9]{0,11}", "排序:请输入正整数。位数在0-11位之间", false)//排序
                .put("danju_zt","[0|1|2|3|4]{1}", "单据状态:请输入正整数。位数在1-1位之间", false)//单据状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}