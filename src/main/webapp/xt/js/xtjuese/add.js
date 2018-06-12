//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTree("divID_Tree_menu_XtJuese", "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc", "/xt/xtjuese/select/json.jw", false, function (event, id, treeNode) {
        $("#xt_juese_fzj").val(treeNode.xt_juese_zj)
        $("#xt_juese_fzj_mc").textbox('setValue',treeNode.xt_juese_mc);        
    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.xt_juese_zj = $("#xt_juese_zj").val()                
                data.xt_juese_fzj = fzFormatZT($("#xt_juese_fzj").val())//父键
                data.xt_juese_mc = fzFormatZT($("#xt_juese_mc").val())//名称
                data.xt_juese_dm = fzFormatZT($("#xt_juese_dm").val())//代码
                data.xt_juese_gongsi = fzFormatZT($("#xt_juese_gongsi").val())//公私角色
                data.xt_juese_bz = fzFormatZT($("#xt_juese_bz").val())//备注
                data.xt_juese_zt = fzFormatZT($("#xt_juese_zt").val())//状态
                data.xt_juese_gelibiaoshi = fzFormatZT($("#xt_juese_gelibiaoshi").val())//隔离标识
                data.xt_juese_zhidanren_zj = fzFormatZT($("#xt_juese_zhidanren_zj").val())//制单人主键
                data.xt_juese_zhidanren = fzFormatZT($("#xt_juese_zhidanren").val())//制单人
                data.xt_juese_zhidanshijian = fzFormatZT($("#xt_juese_zhidanshijian").val())//制单时间
                data.xt_juese_xiugairen_zj = fzFormatZT($("#xt_juese_xiugairen_zj").val())//修改人主键
                data.xt_juese_xiugairen = fzFormatZT($("#xt_juese_xiugairen").val())//修改人
                data.xt_juese_xiugaishijian = fzFormatZT($("#xt_juese_xiugaishijian").val())//修改时间
                easyuiAjax("/xt/xtjuese/save.jw", data, "请确认保存操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_XtJuese").reAsyncChildNodes(null, "refresh");
                });
            }
}
function clearForm() {
    $('#XtJueseFormID').form('clear');
}
