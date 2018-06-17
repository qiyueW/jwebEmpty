//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTree("divID_Tree_menu_Gangwei", "gangwei_zj", "gangwei_fzj", "gangwei_mc", "/base/gangwei/select/json.jw", false, function (event, id, treeNode) {
        $("#gangwei_fzj").val(treeNode.gangwei_zj)
        $("#gangwei_fzj_mc").textbox('setValue',treeNode.gangwei_mc);        
    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.gangwei_zj = $("#gangwei_zj").val()                
                data.gangwei_fzj = fzFormatZT($("#gangwei_fzj").val())//父键
                data.gangwei_mc = fzFormatZT($("#gangwei_mc").val())//名称
                data.gangwei_zhidanshijian = fzFormatZT($("#gangwei_zhidanshijian").val())//制单时间
                data.gangwei_bz = fzFormatZT($("#gangwei_bz").val())//备注
                data.gangwei_zt = fzFormatZT($("#gangwei_zt").val())//状态
                data.gangwei_gelibiaoshi = fzFormatZT($("#gangwei_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/gangwei/save.jw", data, "请确认保存操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_Gangwei").reAsyncChildNodes(null, "refresh");
                });
            }
}
function clearForm() {
    $('#GangweiFormID').form('clear');
}
