//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
//    toCreateTree("divID_Tree_menu_LoufangXMF", "loufangxmf_zj", "${treeMypid}", "${treeMyname}", "/base/loufangxmf/select/json.jw", false, function (event, id, treeNode) {
//        $("#${treeMypid}").val(treeNode.loufangxmf_zj)
//        $("#${treeMypid}_mc").textbox('setValue',treeNode.${treeMyname});        
//    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.loufangxmf_zj = $("#loufangxmf_zj").val()                
                data.loufangxmf_gelibiaoshi = fzFormatZT($("#loufangxmf_gelibiaoshi").val())//隔离标识
                data.loufangxmf_mc = fzFormatZT($("#loufangxmf_mc").val())//项目名称
                data.loufangxmf_feiyong = fzFormatZT($("#loufangxmf_feiyong").val())//项目费
                data.loufangxmf_zt = fzFormatZT($("#loufangxmf_zt").val())//状态
                easyuiAjax("/base/loufangxmf/save.jw", data, "请确认保存操作", function () {
                });
            }
}
function clearForm() {
    $('#LoufangXMFFormID').form('clear');
}
