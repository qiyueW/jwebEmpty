function submitForm(formid) {
    var vcheck = $('#' + formid).form('enableValidation').form('validate');
    if (vcheck) {
        var data = {};
        data.chaodianbiao_loufang_zj = $('#chaodianbiao_loufang_zj').val() //楼主键
        data.chaodianbiao_loufang_mc = $('#chaodianbiao_loufang_mc').val() //楼名称
        data.chaodianbiao_loufang2_zj = $('#chaodianbiao_loufang2_zj').val() //房主键
        data.chaodianbiao_loufang2_bianma = $('#chaodianbiao_loufang2_bianma').val() //房编号
        data.chaodianbiao_dushu1 = $('#chaodianbiao_dushu1').val() //上次读数
        data.chaodianbiao_riqi1 = $('#chaodianbiao_riqi1').val() //上次抄表日期
        data.chaodianbiao_dushu2 = $('#chaodianbiao_dushu2').val() //读数
        data.chaodianbiao_riqi2 = $('#chaodianbiao_riqi2').val() //抄表日期
        data.chaodianbiao_dian = $('#chaodianbiao_dian').val() //水(吨)
        data.chaodianbiao_dian_danjia = $('#chaodianbiao_dian_danjia').val() //水单价
        easyuiAjax("/service/chaodianbiao/save.jw", data, "请确认保存操作", function () {
            //回调函数
        });
    }
}