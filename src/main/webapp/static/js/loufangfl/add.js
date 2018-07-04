//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTree("divID_Tree_menu_LoufangFL", "loufangfl_zj", "loufangfl_fzj", "loufangfl_mc", "/base/loufangfl/select/json.jw", false, function (event, id, treeNode) {
        $("#loufangfl_fzj").val(treeNode.loufangfl_zj)
        $("#loufangfl_fzj_mc").textbox('setValue',treeNode.loufangfl_mc);        
    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.loufangfl_zj = $("#loufangfl_zj").val()                
                data.loufangfl_px = fzFormatZT($("#loufangfl_px").val())//排序
                data.loufangfl_fzj = fzFormatZT($("#loufangfl_fzj").val())//父主键
                data.loufangfl_mc = fzFormatZT($("#loufangfl_mc").val())//名称
                data.loufangfl_bz = fzFormatZT($("#loufangfl_bz").val())//备注
                data.loufangfl_zt = fzFormatZT($("#loufangfl_zt").val())//状态
                data.loufangfl_gelibiaoshi = fzFormatZT($("#loufangfl_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/loufangfl/save.jw", data, "请确认保存操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_LoufangFL").reAsyncChildNodes(null, "refresh");
                });
            }
}
function clearForm() {
    $('#LoufangFLFormID').form('clear');
}
