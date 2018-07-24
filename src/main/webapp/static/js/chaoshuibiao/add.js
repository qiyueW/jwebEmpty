function submitForm(formid) {
    var vcheck = $('#' + formid).form('enableValidation').form('validate');
    if (vcheck) {
        var data = {};
        data.chaoshuibiao_loufang_zj = $('#chaoshuibiao_loufang_zj').val() //楼主键
        data.chaoshuibiao_loufang_mc = $('#chaoshuibiao_loufang_mc').val() //楼名称
        data.chaoshuibiao_loufang2_zj = $('#chaoshuibiao_loufang2_zj').val() //房主键
        data.chaoshuibiao_loufang2_bianma = $('#chaoshuibiao_loufang2_bianma').val() //房编号
        data.chaoshuibiao_dushu1 = $('#chaoshuibiao_dushu1').val() //上次读数
        data.chaoshuibiao_riqi1 = $('#chaoshuibiao_riqi1').val() //上次抄表日期
        data.chaoshuibiao_dushu2 = $('#chaoshuibiao_dushu2').val() //读数
        data.chaoshuibiao_riqi2 = $('#chaoshuibiao_riqi2').val() //抄表日期
        data.chaoshuibiao_shui = $('#chaoshuibiao_shui').val() //水(吨)
        data.chaoshuibiao_shui_danjia = $('#chaoshuibiao_shui_danjia').val() //水单价
        data.jsonkey = rs ? "[" + rs + "]" : "";
        easyuiAjax("/service/chaoshuibiao/save.jw", data, "请确认保存操作", function () {
            //回调函数
        });
    }
}