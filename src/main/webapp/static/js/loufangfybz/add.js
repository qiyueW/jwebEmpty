//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
//    toCreateTree("divID_Tree_menu_LoufangFYBZ", "loufang_fybz_zj", "${treeMypid}", "${treeMyname}", "/base/loufangfybz/select/json.jw", false, function (event, id, treeNode) {
//        $("#${treeMypid}").val(treeNode.loufang_fybz_zj)
//        $("#${treeMypid}_mc").textbox('setValue',treeNode.${treeMyname});        
//    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.loufang_fybz_zj = $("#loufang_fybz_zj").val()                
                data.loufang_fybz_loufang_zj = fzFormatZT($("#loufang_fybz_loufang_zj").val())//楼房主键
                data.loufang_fybz_loufang_mc = fzFormatZT($("#loufang_fybz_loufang_mc").val())//楼名
                data.loufang_fybz_dianfei = fzFormatZT($("#loufang_fybz_dianfei").val())//电费标准
                data.loufang_fybz_shuifei = fzFormatZT($("#loufang_fybz_shuifei").val())//水费标准
                data.loufang_fybz_shuifei_leng = fzFormatZT($("#loufang_fybz_shuifei_leng").val())//冷水费标准
                data.loufang_fybz_shuifei_re = fzFormatZT($("#loufang_fybz_shuifei_re").val())//热水费标准
                data.loufang_fybz_meiqi = fzFormatZT($("#loufang_fybz_meiqi").val())//煤气费标准
                data.loufang_fybz_zt = fzFormatZT($("#loufang_fybz_zt").val())//状态
                data.loufang_fybz_gelibiaoshi = fzFormatZT($("#loufang_fybz_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/loufangfybz/save.jw", data, "请确认保存操作", function () {
                });
            }
}
function clearForm() {
    $('#LoufangFYBZFormID').form('clear');
}
