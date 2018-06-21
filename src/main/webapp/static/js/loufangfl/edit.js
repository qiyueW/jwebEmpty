//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {
    toCreateTree("divID_Tree_menu_LoufangFL", "loufangfl_zj", "loufangfl_fzj", "loufangfl_mc", "/base/loufangfl/select/json.jw", false,onclickdo,true);
    function onclickdo(event, id, treeNode) {
        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
            if (r) {
                $("#loufangfl_fzj").val(treeNode.loufangfl_zj)
                $("#loufangfl_fzj_mc").textbox('setValue',treeNode.loufangfl_mc); 
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
                data.loufangfl_px =fzFormatZT($("#loufangfl_px").val())//排序
                data.loufangfl_zj =fzFormatZT($("#loufangfl_zj").val())//主键
                data.loufangfl_fzj =fzFormatZT($("#loufangfl_fzj").val())//父主键
                data.loufangfl_mc =fzFormatZT($("#loufangfl_mc").val())//名称
                data.loufangfl_bz =fzFormatZT($("#loufangfl_bz").val())//备注
                data.loufangfl_zt =fzFormatZT($("#loufangfl_zt").val())//状态
                easyuiAjax("/base/loufangfl/update.jw", data, "请确认修改操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_LoufangFL").reAsyncChildNodes(null, "refresh");
                });
            }
}
//移除上级
function clearFather() {
    $('#loufangfl_fzj').val('')
    $("#loufangfl_fzj_mc").textbox('setValue',''); 
}
