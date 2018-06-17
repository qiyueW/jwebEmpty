//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTree("divID_Tree_menu_Zhiwei", "zhiwei_zj", "zhiwei_fzj", "zhiwei_mc", "/base/zhiwei/select/json.jw", false, function (event, id, treeNode) {
        $("#zhiwei_fzj").val(treeNode.zhiwei_zj)
        $("#zhiwei_fzj_mc").textbox('setValue',treeNode.zhiwei_mc);        
    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.zhiwei_zj = $("#zhiwei_zj").val()                
                data.zhiwei_fzj = fzFormatZT($("#zhiwei_fzj").val())//父键
                data.zhiwei_mc = fzFormatZT($("#zhiwei_mc").val())//名称
                data.zhiwei_zhidanshijian = fzFormatZT($("#zhiwei_zhidanshijian").val())//制单时间
                data.zhiwei_bz = fzFormatZT($("#zhiwei_bz").val())//备注
                data.zhiwei_zt = fzFormatZT($("#zhiwei_zt").val())//状态
                data.zhiwei_gelibiaoshi = fzFormatZT($("#zhiwei_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/zhiwei/save.jw", data, "请确认保存操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_Zhiwei").reAsyncChildNodes(null, "refresh");
                });
            }
}
function clearForm() {
    $('#ZhiweiFormID').form('clear');
}
