//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
//    toCreateTree("divID_Tree_menu_XtGuanliyuan", "xt_guanliyuan_zj", "${treeMypid}", "${treeMyname}", "/xt/xtguanliyuan/select/json.jw", false, function (event, id, treeNode) {
//        $("#${treeMypid}").val(treeNode.xt_guanliyuan_zj)
//        $("#${treeMypid}_mc").textbox('setValue',treeNode.${treeMyname});        
//    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.xt_guanliyuan_zj = $("#xt_guanliyuan_zj").val()                
                data.xt_guanliyuan_mc = fzFormatZT($("#xt_guanliyuan_mc").val())//管理员名称
                data.xt_guanliyuan_zhanghao = fzFormatZT($("#xt_guanliyuan_zhanghao").val())//管理员账号
                data.xt_guanliyuan_mima = fzFormatZT($("#xt_guanliyuan_mima").val())//管理员密码
                data.xt_guanliyuan_youxiang = fzFormatZT($("#xt_guanliyuan_youxiang").val())//管理员邮箱
                data.xt_guanliyuan_zt = fzFormatZT($("#xt_guanliyuan_zt").val())//管理员状态
                data.xt_guanliyuan_bz = fzFormatZT($("#xt_guanliyuan_bz").val())//管理员备注
                data.xt_guanliyuan_quanxian = fzFormatZT($("#xt_guanliyuan_quanxian").val())//管理员权限集合
                data.xt_guanliyuan_bm = fzFormatZT($("#xt_guanliyuan_bm").val())//管理员部门集合
                data.xt_guanliyuan_gelibiaoshi = fzFormatZT($("#xt_guanliyuan_gelibiaoshi").val())//隔离标识
                data.xt_guanliyuan_zhidanshijian = fzFormatZT($("#xt_guanliyuan_zhidanshijian").val())//制单时间
                easyuiAjax("/xt/xtguanliyuan1/save.jw", data, "请确认保存操作", function () {
//                    $.fn.zTree.getZTreeObj("divID_Tree_menu_XtGuanliyuan").reAsyncChildNodes(null, "refresh");
                });
            }
}
function clearForm() {
    $('#XtGuanliyuanFormID').form('clear');
}
