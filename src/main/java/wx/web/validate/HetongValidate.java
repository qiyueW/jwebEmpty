package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class HetongValidate extends ValidateModel {

    public HetongValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("hetong_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("hetong_fzj","(0{1})|([1-9]{1}[0-9]{23})", "父子合同父键丢失", false)//父子合同父键
                .put("hetong_mingcheng","[\\w\\W]{1,200}", "合同名称:文本为空或长度超200字符", true)//合同名称
                .put("hetong_bianhao","[\\w\\W]{1,20}", "编号:文本为空或长度超20字符", true)//编号
                .put("hetong_kaishiriqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "开始日期:请输入时间。例1988-08-21", true)//开始日期
                .put("hetong_jieshuriqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "结束日期:请输入时间。例1988-08-21", true)//结束日期
                .put("hetong_qianyueren","[\\w\\W]{1,200}", "签约人:文本为空或长度超200字符", true)//签约人
                .put("hetong_qianyueren_zj","[1-9]{1}[0-9]{23}", "签约人主键丢失", true)//签约人主键
                .put("hetong_shoujihaoma","[\\w\\W]{0,50}", "手机号码:长度超50字符", false)//手机号码
                .put("hetong_xingbie","[\\w\\W]{1,1}", "性别:文本为空或长度超1字符", true)//性别
                .put("hetong_yuefangzu","[0-9]{0,11}", "月房租（月计）:请输入正整数。位数在0-11位之间", false)//月房租（月计）
                .put("hetong_qianyuerenzhaopian1","[\\w\\W]{0,200}", "签约人照片1:图片名及路径长度超200字符", false)//签约人照片1
                .put("hetong_qianyuerenzhaopian2","[\\w\\W]{0,200}", "签约人照片2:图片名及路径长度超200字符", false)//签约人照片2
                .put("hetong_qianyuerenzhaopian3","[\\w\\W]{0,200}", "签约人照片3:图片名及路径长度超200字符", false)//签约人照片3
                .put("hetong_beizhu","[\\w\\W]{0,200}", "合同备注:长度超200字符", false)//合同备注
                .put("hetong_neirong","[\\w\\W]+", "合同内容:文本为空", false)//合同内容
                .put("hetong_zt","[0|1|2|3|4]{1}", "单据状态:请输入正整数。位数在1-1位之间", true)//单据状态
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}