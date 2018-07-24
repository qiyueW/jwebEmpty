//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
//function inido() {
//    toCreateTree("divID_Tree_menu_LoufangFYBZ", "${treeMyid}", "${treeMypid}", "${treeMyname}", "/base/loufangfybz/select/json.jw", false,onclickdo,true);
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
                data.loufang_fybz_zj =fzFormatZT($("#loufang_fybz_zj").val())//主键
                data.loufang_fybz_loufang_zj =fzFormatZT($("#loufang_fybz_loufang_zj").val())//楼房主键
                data.loufang_fybz_loufang_mc =fzFormatZT($("#loufang_fybz_loufang_mc").val())//楼名
                data.loufang_fybz_dianfei =fzFormatZT($("#loufang_fybz_dianfei").val())//电费标准
                data.loufang_fybz_shuifei =fzFormatZT($("#loufang_fybz_shuifei").val())//水费标准
                data.loufang_fybz_shuifei_leng =fzFormatZT($("#loufang_fybz_shuifei_leng").val())//冷水费标准
                data.loufang_fybz_shuifei_re =fzFormatZT($("#loufang_fybz_shuifei_re").val())//热水费标准
                data.loufang_fybz_meiqi =fzFormatZT($("#loufang_fybz_meiqi").val())//煤气费标准
                data.loufang_fybz_zt =fzFormatZT($("#loufang_fybz_zt").val())//状态
                data.loufang_fybz_gelibiaoshi =fzFormatZT($("#loufang_fybz_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/loufangfybz/update.jw", data, "请确认修改操作", function () {
                    //$.fn.zTree.getZTreeObj("divID_Tree_menu_LoufangFYBZ").reAsyncChildNodes(null, "refresh");
                });
            }
}
