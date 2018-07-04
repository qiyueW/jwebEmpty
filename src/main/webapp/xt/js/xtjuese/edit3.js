//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {
    toCreateTree("divID_Tree_menu_XtJuese", "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc", "/xt/xtjuese3/select/json.jw", false,onclickdo,true);
    function onclickdo(event, id, treeNode) {
        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
            if (r) {
                $("#xt_juese_fzj").val(treeNode.xt_juese_zj)
                $("#xt_juese_fzj_mc").textbox('setValue',treeNode.xt_juese_mc); 
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
                data.xt_juese_zj =fzFormatZT($("#xt_juese_zj").val())//主键
                data.xt_juese_fzj =fzFormatZT($("#xt_juese_fzj").val())//父键
                data.xt_juese_mc =fzFormatZT($("#xt_juese_mc").val())//名称
                data.xt_juese_dm =fzFormatZT($("#xt_juese_dm").val())//代码
                data.xt_juese_gongsi =fzFormatZT($("#xt_juese_gongsi").val())//公私角色
                data.xt_juese_bz =fzFormatZT($("#xt_juese_bz").val())//备注
                data.xt_juese_zt =fzFormatZT($("#xt_juese_zt").val())//状态
                data.xt_juese_gelibiaoshi =fzFormatZT($("#xt_juese_gelibiaoshi").val())//隔离标识
                data.xt_juese_zhidanren_zj =fzFormatZT($("#xt_juese_zhidanren_zj").val())//制单人主键
                data.xt_juese_zhidanren =fzFormatZT($("#xt_juese_zhidanren").val())//制单人
                data.xt_juese_zhidanshijian =fzFormatZT($("#xt_juese_zhidanshijian").val())//制单时间
                data.xt_juese_xiugairen_zj =fzFormatZT($("#xt_juese_xiugairen_zj").val())//修改人主键
                data.xt_juese_xiugairen =fzFormatZT($("#xt_juese_xiugairen").val())//修改人
                data.xt_juese_xiugaishijian =fzFormatZT($("#xt_juese_xiugaishijian").val())//修改时间
                easyuiAjax("/xt/xtjuese3/update.jw", data, "请确认修改操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_XtJuese").reAsyncChildNodes(null, "refresh");
                });
            }
}
//移除上级
function clearFather() {
    $('#xt_juese_fzj').val('')
    $("#xt_juese_fzj_mc").textbox('setValue',''); 
}
