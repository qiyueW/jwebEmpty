package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class ZhusuHetongValidate extends ValidateModel {

    public ZhusuHetongValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("zhusuhetong_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("zhusuhetong_zt", "[0|1|2|3|4]{1}", "状态:请输入正整数。位数在1-1位之间", false)//状态
                .put("zhusuhetong_loufang_zj", "[1-9]{1}[0-9]{23}", "楼主键丢失", true)//楼主键
                .put("zhusuhetong_loufang_mc", "[\\w\\W]{1,20}", "楼名称:文本为空或长度超20字符", true)//楼名称
                .put("zhusuhetong_loufang2_zj", "[1-9]{1}[0-9]{23}", "房主键丢失", true)//房主键
                .put("zhusuhetong_loufang2_bianhao", "[\\w\\W]{1,20}", "房编号:文本为空或长度超20字符", true)//房编号
                .put("zhusuhetong_qianyueren", "[\\w\\W]{1,20}", "签约人:文本为空或长度超20字符", true)//签约人
                .put("zhusuhetong_qianyueren_zj", "[1-9]{1}[0-9]{23}", "签约人主键丢失", true)//签约人主键
                .put("zhusuhetong_yajin", "[0-9]{0,11}", "押金:请输入正整数。位数在0-11位之间", false)//押金
                .put("zhusuhetong_zujin", "[0-9]{0,11}", "租金:请输入正整数。位数在0-11位之间", false)//租金
                .put("zhusuhetong_tj_xml", "[0-9]{0,11}", "项目费统计异常", false)//租金
                .put("zhusuhetong_kaishiriqi", "[0-9]{4}-[0-9]{2}-[0-9]{2}", "开始日期:请输入时间。例1988-08-21", true)//开始日期
                .put("zhusuhetong_jieshuriqi", "[0-9]{4}-[0-9]{2}-[0-9]{2}", "结束日期:请输入时间。例1988-08-21", false)//结束日期
                .put("zhusuhetong_jffs", "[0|1|2|3|4]{1}", "计费方式:请输入正整数。位数在1-1位之间", true)//
                .put("zhusuhetong_jffs_zdrq", "[0-9]{0,11}", "计费方式-指定日期:请输入正整数。位数在0-11位之间", false)//计费方式-指定日期
                .put("zhusuhetong_zuixiaozhusuriqi", "[0-9]{4}-[0-9]{2}-[0-9]{2}", "最小住宿日期:请输入时间。例1988-08-21", false)//最小住宿日期
                .put("zhusuhetong_bz", "[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}
