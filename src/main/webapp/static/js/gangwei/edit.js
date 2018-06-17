//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {
    toCreateTree("divID_Tree_menu_Gangwei", "gangwei_zj", "gangwei_fzj", "gangwei_mc", "/base/gangwei/select/json.jw", false,onclickdo,true);
    function onclickdo(event, id, treeNode) {
        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
            if (r) {
                $("#gangwei_fzj").val(treeNode.gangwei_zj)
                $("#gangwei_fzj_mc").textbox('setValue',treeNode.gangwei_mc); 
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
                data.gangwei_zj =fzFormatZT($("#gangwei_zj").val())//主键
                data.gangwei_fzj =fzFormatZT($("#gangwei_fzj").val())//父键
                data.gangwei_mc =fzFormatZT($("#gangwei_mc").val())//名称
                data.gangwei_zhidanshijian =fzFormatZT($("#gangwei_zhidanshijian").val())//制单时间
                data.gangwei_bz =fzFormatZT($("#gangwei_bz").val())//备注
                data.gangwei_zt =fzFormatZT($("#gangwei_zt").val())//状态
                data.gangwei_gelibiaoshi =fzFormatZT($("#gangwei_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/gangwei/update.jw", data, "请确认修改操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_Gangwei").reAsyncChildNodes(null, "refresh");
                });
            }
}
//移除上级
function clearFather() {
    $('#gangwei_fzj').val('')
    $("#gangwei_fzj_mc").textbox('setValue',''); 
}
