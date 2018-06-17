//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {
    toCreateTree("divID_Tree_menu_Zhiwei", "zhiwei_zj", "zhiwei_fzj", "zhiwei_mc", "/base/zhiwei/select/json.jw", false,onclickdo,true);
    function onclickdo(event, id, treeNode) {
        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
            if (r) {
                $("#zhiwei_fzj").val(treeNode.zhiwei_zj)
                $("#zhiwei_fzj_mc").textbox('setValue',treeNode.zhiwei_mc); 
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
                data.zhiwei_zj =fzFormatZT($("#zhiwei_zj").val())//主键
                data.zhiwei_fzj =fzFormatZT($("#zhiwei_fzj").val())//父键
                data.zhiwei_mc =fzFormatZT($("#zhiwei_mc").val())//名称
                data.zhiwei_zhidanshijian =fzFormatZT($("#zhiwei_zhidanshijian").val())//制单时间
                data.zhiwei_bz =fzFormatZT($("#zhiwei_bz").val())//备注
                data.zhiwei_zt =fzFormatZT($("#zhiwei_zt").val())//状态
                data.zhiwei_gelibiaoshi =fzFormatZT($("#zhiwei_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/zhiwei/update.jw", data, "请确认修改操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_Zhiwei").reAsyncChildNodes(null, "refresh");
                });
            }
}
//移除上级
function clearFather() {
    $('#zhiwei_fzj').val('')
    $("#zhiwei_fzj_mc").textbox('setValue',''); 
}
