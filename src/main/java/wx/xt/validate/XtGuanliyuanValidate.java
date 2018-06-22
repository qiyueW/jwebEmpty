package wx.xt.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class XtGuanliyuanValidate extends ValidateModel {

    public XtGuanliyuanValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("xt_guanliyuan_zj","[1-9]{1}[0-9]{23}", "管理员主键丢失", false)//管理员主键
                .put("xt_guanliyuan_mc","[\\w\\W]{1,20}", "管理员名称:文本为空或长度超20字符", true)//管理员名称
                .put("xt_guanliyuan_zhanghao","[\\w\\W]{1,20}", "管理员账号:文本为空或长度超20字符", true)//管理员账号
                .put("xt_guanliyuan_mima","[\\w\\W]{1,64}", "管理员密码:文本为空或长度超64字符", true)//管理员密码
                .put("xt_guanliyuan_youxiang","[a-z0-9\u4E00-\u9FA5]{1,79}@{1}[a-z0-9\u4E00-\u9FA5]{1,6}.[a-z0-9\u4E00-\u9FA5]{1,6}.?[[a-z0-9\u4E00-\u9FA5]]{0,6}", "管理员邮箱:文本为空或长度超100字符", false)//管理员邮箱
                .put("xt_guanliyuan_zt","[0|1|2|3|4]{1}", "管理员状态:请输入正整数。位数在1-1位之间", true)//管理员状态
                .put("xt_guanliyuan_bz","[\\w\\W]{0,200}", "管理员备注:长度超200字符", false)//管理员备注
                .put("xt_guanliyuan_quanxian","[\\w\\W]+", "管理员权限集合:文本为空", false)//管理员权限集合
                .put("xt_guanliyuan_bm","[\\w\\W]+", "管理员部门集合:文本为空", false)//管理员部门集合
                .put("xt_guanliyuan_gelibiaoshi","[\\w\\W]{1,20}", "隔离标识:文本为空或长度超20字符", false)//隔离标识
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}