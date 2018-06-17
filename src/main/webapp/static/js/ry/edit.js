//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
//function inido() {
//    toCreateTree("divID_Tree_menu_RY", "${treeMyid}", "${treeMypid}", "${treeMyname}", "/base/ry/select/json.jw", false,onclickdo,true);
//    function onclickdo(event, id, treeNode) {
//        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
//            if (r) {
//                $("#${treeMypid}").val(treeNode.${treeMyid})
//                $("#${treeMypid}_mc").textbox('setValue',treeNode.${treeMyname}); 
//           }
//        });
//    }
//}
var close = false;
function closeMySelf() {
    if (!close) {
        $.messager.confirm('请确认', "单据还没保存，是否关闭此页面?", function (r) {
            if (r) {
                window.parent.closethisWindow();
            }
        });
    } else {
        window.parent.closethisWindow();
    }
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                close=true
                var data = {}
                data.ry_zj =fzFormatZT($("#ry_zj").val())//主键
                data.ry_bm =fzFormatZT($("#ry_bm").val())//部门
                data.ry_bm_zj =fzFormatZT($("#ry_bm_zj").val())//部门主键
                data.ry_mc =fzFormatZT($("#ry_mc").val())//人员名称
                data.ry_zhanghao =fzFormatZT($("#ry_zhanghao").val())//账号
                data.ry_mima =fzFormatZT($("#ry_mima").val())//密码
                data.ry_xingbie =fzFormatZT($("#ry_xingbie").val())//性别
                data.ry_ruzhiriqi =fzFormatZT($("#ry_ruzhiriqi").val())//入职日期
                data.ry_chushengriqi =fzFormatZT($("#ry_chushengriqi").val())//出生日期
                data.ry_lizhiriqi =fzFormatZT($("#ry_lizhiriqi").val())//离职日期
                data.ry_jiguan =fzFormatZT($("#ry_jiguan").val())//籍贯
                data.ry_shouji1 =fzFormatZT($("#ry_shouji1").val())//手机1
                data.ry_youxiang =fzFormatZT($("#ry_youxiang").val())//邮箱
                data.ry_hunyin =fzFormatZT($("#ry_hunyin").val())//婚姻状态
                data.ry_gangwei_zj =fzFormatZT($("#ry_gangwei_zj").val())//岗位主键
                data.ry_gangwei =fzFormatZT($("#ry_gangwei").val())//岗位
                data.ry_zhiwei_zj =fzFormatZT($("#ry_zhiwei_zj").val())//职位主键
                data.ry_zhiwei =fzFormatZT($("#ry_zhiwei").val())//职位
                data.ry_tupian =fzFormatZT($("#ry_tupian").val())//图片
                data.ry_bz =fzFormatZT($("#ry_bz").val())//备注
                data.ry_shenfenzheng =fzFormatZT($("#ry_shenfenzheng").val())//身份证号码
                data.ry_tupian_zhengjian1 =fzFormatZT($("#ry_tupian_zhengjian1").val())//证件图_正面
                data.ry_tupian_zhengjian2 =fzFormatZT($("#ry_tupian_zhengjian2").val())//证件图_反面
                data.ry_xianzhudizhi =fzFormatZT($("#ry_xianzhudizhi").val())//现住地址
                data.ry_jiatingdizhi =fzFormatZT($("#ry_jiatingdizhi").val())//家庭地址
                data.ry_jinjilianxiren =fzFormatZT($("#ry_jinjilianxiren").val())//紧急联系人
                data.ry_jinjilianxiren_dianhua =fzFormatZT($("#ry_jinjilianxiren_dianhua").val())//紧急联系人电话
                data.ry_gudingdianhua1 =fzFormatZT($("#ry_gudingdianhua1").val())//固定电话1
                data.ry_gudingdianhua2 =fzFormatZT($("#ry_gudingdianhua2").val())//固定电话2
                data.ry_qitatongxing =fzFormatZT($("#ry_qitatongxing").val())//其他通信
                data.ry_qitatongxing1 =fzFormatZT($("#ry_qitatongxing1").val())//其他通信1
                data.ry_qitatongxing2 =fzFormatZT($("#ry_qitatongxing2").val())//其他通信2
                data.ry_qitatongxing3 =fzFormatZT($("#ry_qitatongxing3").val())//其他通信3
                data.ry_qitatongxing4 =fzFormatZT($("#ry_qitatongxing4").val())//其他通信4
                data.ry_qitatongxing5 =fzFormatZT($("#ry_qitatongxing5").val())//其他通信5
                data.ry_neibutongxing1 =fzFormatZT($("#ry_neibutongxing1").val())//内部通信1
                data.ry_neibutongxing2 =fzFormatZT($("#ry_neibutongxing2").val())//内部通信2
                data.ry_neibutongxing3 =fzFormatZT($("#ry_neibutongxing3").val())//内部通信3
                data.ry_neibutongxing4 =fzFormatZT($("#ry_neibutongxing4").val())//内部通信4
                data.ry_neibutongxing5 =fzFormatZT($("#ry_neibutongxing5").val())//内部通信5
                data.ry_neibutongxing6 =fzFormatZT($("#ry_neibutongxing6").val())//内部通信6
                data.ry_neibutongxing7 =fzFormatZT($("#ry_neibutongxing7").val())//内部通信7
                data.ry_neibutongxing8 =fzFormatZT($("#ry_neibutongxing8").val())//内部通信8
                data.ry_neibutongxing9 =fzFormatZT($("#ry_neibutongxing9").val())//内部通信9
                data.ry_neibutongxing10 =fzFormatZT($("#ry_neibutongxing10").val())//内部通信10
                data.ry_zhidanren_zj =fzFormatZT($("#ry_zhidanren_zj").val())//制单人主键
                data.ry_zhidanren =fzFormatZT($("#ry_zhidanren").val())//制单人
                data.ry_gelibiaoshi =fzFormatZT($("#ry_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/ry/update.jw", data, "请确认修改操作", function () {
                    //$.fn.zTree.getZTreeObj("divID_Tree_menu_RY").reAsyncChildNodes(null, "refresh");
                });
            }
}
