//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {
    toCreateTree("divID_Tree_menu_XtQuanxian", "xt_quanxian_zj", "xt_quanxian_fzj", "xt_quanxian_mc", "/xt/xtquanxian/select/json.jw", false,onclickdo,true);
    function onclickdo(event, id, treeNode) {
        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
            if (r) {
                $("#xt_quanxian_fzj").val(treeNode.xt_quanxian_zj)
                $("#xt_quanxian_fzj_mc").textbox('setValue',treeNode.xt_quanxian_mc); 
            }
        });
    }
}
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
                data.xt_quanxian_zj =fzFormatZT($("#xt_quanxian_zj").val())//主键
                data.xt_quanxian_fzj =fzFormatZT($("#xt_quanxian_fzj").val())//父键
                data.xt_quanxian_px =fzFormatZT($("#xt_quanxian_px").val())//排序
                data.xt_quanxian_mc =fzFormatZT($("#xt_quanxian_mc").val())//名称
                data.xt_quanxian_dm =fzFormatZT($("#xt_quanxian_dm").val())//权限代码
                data.xt_quanxian_url =fzFormatZT($("#xt_quanxian_url").val())//url
                data.xt_quanxian_keshi =fzFormatZT($("#xt_quanxian_keshi").val())//可视
                data.xt_quanxian_zhankai =fzFormatZT($("#xt_quanxian_zhankai").val())//展开
                data.xt_quanxian_bz =fzFormatZT($("#xt_quanxian_bz").val())//备注
                data.xt_quanxian_zt =fzFormatZT($("#xt_quanxian_zt").val())//状态
                data.xt_quanxian_gelibiaoshi =fzFormatZT($("#xt_quanxian_gelibiaoshi").val())//隔离标识
                easyuiAjax("/xt/xtquanxian/update.jw", data, "请确认修改操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_XtQuanxian").reAsyncChildNodes(null, "refresh");
                });
            }
}
//移除上级
function clearFather() {
    $('#xt_quanxian_fzj').val('')
    $("#xt_quanxian_fzj_mc").textbox('setValue',''); 
}
