package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class LoufangNafeiValidate extends ValidateModel {

    public LoufangNafeiValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("loufangnafei_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("loufangnafei_lou_mc","[\\w\\W]{1,20}", "楼名称:文本为空或长度超20字符", true)//楼名称
                .put("loufangnafei_fang_bianma","[\\w\\W]{1,20}", "房编码:文本为空或长度超20字符", true)//房编码
                .put("loufangnafei_ren","[\\w\\W]{1,20}", "纳费人:文本为空或长度超20字符", true)//纳费人
                .put("loufangnafei_yingnariqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "应纳日期:请输入时间。例1988-08-21", true)//应纳日期
                .put("loufangnafei_nafeiriqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "纳费日期:请输入时间。例1988-08-21", false)//纳费日期
                .put("loufangnafei_zongfeiyong","-?[0-9]{0,10}.?[0-9]{0,1}", "总费用:请输入合法数字。正数位在10位内，小数位在1位内", true)//总费用
                .put("loufangnafei_zongfeiyong2","-?[0-9]{0,10}.?[0-9]{0,1}", "已纳费用:请输入合法数字。正数位在10位内，小数位在1位内", true)//已纳费用
                .put("loufangnafei_fangzu","-?[0-9]{0,10}.?[0-9]{0,1}", "房租:请输入合法数字。正数位在10位内，小数位在1位内", true)//房租
                .put("loufangnafei_feiyong_shui","-?[0-9]{0,10}.?[0-9]{0,1}", "水费:请输入合法数字。正数位在10位内，小数位在1位内", true)//水费
                .put("loufangnafei_feiyong_dian","-?[0-9]{0,10}.?[0-9]{0,1}", "电费:请输入合法数字。正数位在10位内，小数位在1位内", true)//电费
                .put("loufangnafei_feiyong_xm","-?[0-9]{0,10}.?[0-9]{0,1}", "项目费:请输入合法数字。正数位在10位内，小数位在1位内", true)//项目费
                .put("loufangnafei_feiyong_meiqi","-?[0-9]{0,10}.?[0-9]{0,1}", "煤气费:请输入合法数字。正数位在10位内，小数位在1位内", false)//煤气费
                .put("loufangnafei_zt","[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", true)//状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}