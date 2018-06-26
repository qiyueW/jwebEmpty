package wx.web.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class RYValidate extends ValidateModel {

    public RYValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("ry_zj","[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("ry_bm","[\\w\\W]{1,50}", "部门:文本为空或长度超50字符", false)//部门
                .put("ry_bm_zj","[1-9]{1}[0-9]{23}", "部门主键丢失", true)//部门主键
                .put("ry_mc","[\\w\\W]{1,20}", "人员名称:文本为空或长度超20字符", true)//人员名称
                .put("ry_zhanghao","[\\w\\W]{1,100}", "账号:文本为空或长度超100字符", true)//账号
                .put("ry_mima","[\\w\\W]{1,100}", "密码:文本为空或长度超100字符", true)//密码
                .put("ry_xingbie","[\\w\\W]{1,2}", "性别:文本为空或长度超2字符", true)//性别
                .put("ry_ruzhiriqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "入职日期:请输入时间。例1988-08-21", true)//入职日期
                .put("ry_chushengriqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "出生日期:请输入时间。例1988-08-21", false)//出生日期
                .put("ry_lizhiriqi","[0-9]{4}-[0-9]{2}-[0-9]{2}", "离职日期:请输入时间。例1988-08-21", false)//离职日期
                .put("ry_jiguan","[\\w\\W]{0,20}", "籍贯:长度超20字符", false)//籍贯
                .put("ry_shouji1","[\\w\\W]{0,20}", "手机1:长度超20字符", false)//手机1
                .put("ry_youxiang","[a-z0-9\u4E00-\u9FA5]{1,79}@{1}[a-z0-9\u4E00-\u9FA5]{1,6}.[a-z0-9\u4E00-\u9FA5]{1,6}.?[[a-z0-9\u4E00-\u9FA5]]{0,6}", "邮箱:文本为空或长度超100字符", false)//邮箱
                .put("ry_hunyin","[\\w\\W]{0,2}", "婚姻状态:长度超2字符", false)//婚姻状态
                .put("ry_gangwei_zj","[1-9]{1}[0-9]{23}", "岗位主键丢失", false)//岗位主键
                .put("ry_gangwei","[\\w\\W]{0,50}", "岗位:长度超50字符", false)//岗位
                .put("ry_zhiwei_zj","[1-9]{1}[0-9]{23}", "职位主键丢失", false)//职位主键
                .put("ry_zhiwei","[\\w\\W]{0,50}", "职位:长度超50字符", false)//职位
                .put("ry_tupian","[\\w\\W]{0,200}", "图片:文件名及路径总长度超200字符", false)//图片
                .put("ry_bz","[\\w\\W]{0,200}", "备注:长度超200字符", false)//备注
                .put("ry_shenfenzheng","[\\w\\W]{0,200}", "身份证号码:长度超200字符", false)//身份证号码
                .put("ry_tupian_zhengjian1","[\\w\\W]{0,200}", "证件图_正面:文件名及路径总长度超200字符", false)//证件图_正面
                .put("ry_tupian_zhengjian2","[\\w\\W]{0,200}", "证件图_反面:文件名及路径总长度超200字符", false)//证件图_反面
                .put("ry_xianzhudizhi","[\\w\\W]{0,200}", "现住地址:长度超200字符", false)//现住地址
                .put("ry_jiatingdizhi","[\\w\\W]{0,200}", "家庭地址:长度超200字符", false)//家庭地址
                .put("ry_jinjilianxiren","[\\w\\W]{0,20}", "紧急联系人:长度超20字符", false)//紧急联系人
                .put("ry_jinjilianxiren_dianhua","[\\w\\W]{0,20}", "紧急联系人电话:长度超20字符", false)//紧急联系人电话
                .put("ry_gudingdianhua1","[\\w\\W]{0,20}", "固定电话1:长度超20字符", false)//固定电话1
                .put("ry_gudingdianhua2","[\\w\\W]{0,20}", "固定电话2:长度超20字符", false)//固定电话2
                .put("ry_qitatongxing","[\\w\\W]{0,50}", "其他通信:长度超50字符", false)//其他通信
                .put("ry_qitatongxing1","[\\w\\W]{0,50}", "其他通信1:长度超50字符", false)//其他通信1
                .put("ry_qitatongxing2","[\\w\\W]{0,50}", "其他通信2:长度超50字符", false)//其他通信2
                .put("ry_qitatongxing3","[\\w\\W]{0,50}", "其他通信3:长度超50字符", false)//其他通信3
                .put("ry_qitatongxing4","[\\w\\W]{0,50}", "其他通信4:长度超50字符", false)//其他通信4
                .put("ry_qitatongxing5","[\\w\\W]{0,50}", "其他通信5:长度超50字符", false)//其他通信5
                .put("ry_neibutongxing1","[\\w\\W]{0,50}", "内部通信1:长度超50字符", false)//内部通信1
                .put("ry_neibutongxing2","[\\w\\W]{0,50}", "内部通信2:长度超50字符", false)//内部通信2
                .put("ry_neibutongxing3","[\\w\\W]{0,50}", "内部通信3:长度超50字符", false)//内部通信3
                .put("ry_neibutongxing4","[\\w\\W]{0,50}", "内部通信4:长度超50字符", false)//内部通信4
                .put("ry_neibutongxing5","[\\w\\W]{0,50}", "内部通信5:长度超50字符", false)//内部通信5
                .put("ry_neibutongxing6","[\\w\\W]{0,50}", "内部通信6:长度超50字符", false)//内部通信6
                .put("ry_neibutongxing7","[\\w\\W]{0,50}", "内部通信7:长度超50字符", false)//内部通信7
                .put("ry_neibutongxing8","[\\w\\W]{0,50}", "内部通信8:长度超50字符", false)//内部通信8
                .put("ry_neibutongxing9","[\\w\\W]{0,50}", "内部通信9:长度超50字符", false)//内部通信9
                .put("ry_neibutongxing10","[\\w\\W]{0,50}", "内部通信10:长度超50字符", false)//内部通信10
                .put("ry_zhidanren_zj","[1-9]{1}[0-9]{23}", "制单人主键丢失", false)//制单人主键
                .put("ry_zhidanren","[\\w\\W]{1,200}", "制单人:文本为空或长度超200字符", false)//制单人
                .put("ry_gelibiaoshi","[\\w\\W]{1,20}", "隔离标识:文本为空或长度超20字符", false)//隔离标识
;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}