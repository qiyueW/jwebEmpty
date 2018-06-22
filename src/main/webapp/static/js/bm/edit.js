//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {
    toCreateTree("divID_Tree_menu_BM", "bm_zj", "bm_fzj", "bm_mc", "/base/bm/select/json.jw", false,onclickdo,true);
    function onclickdo(event, id, treeNode) {
        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
            if (r) {
                $("#bm_fzj").val(treeNode.bm_zj)
                $("#bm_fzj_mc").textbox('setValue',treeNode.bm_mc); 
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
                data.bm_zj =fzFormatZT($("#bm_zj").val())//主键
                data.bm_fzj =fzFormatZT($("#bm_fzj").val())//父键
                data.bm_mc =fzFormatZT($("#bm_mc").val())//名称
                data.bm_bianma =fzFormatZT($("#bm_bianma").val())//编码
                data.bm_jianjie =fzFormatZT($("#bm_jianjie").val())//部门简介
                data.bm_tupian1 =fzFormatZT($("#bm_tupian1").val())//部门图片1
                data.bm_tupian2 =fzFormatZT($("#bm_tupian2").val())//部门图片2
                data.bm_chuangjianshijian =fzFormatZT($("#bm_chuangjianshijian").val())//部门创建时间
                data.bm_fuzhiren_zj =fzFormatZT($("#bm_fuzhiren_zj").val())//部门负责人主键
                data.bm_fuzhiren =fzFormatZT($("#bm_fuzhiren").val())//部门负责人
                data.bm_zt =fzFormatZT($("#bm_zt").val())//部门状态
                data.bm_gelibiaoshi =fzFormatZT($("#bm_gelibiaoshi").val())//隔离标识
                easyuiAjax("/base/bm/update.jw", data, "请确认修改操作", function () {
                    $.fn.zTree.getZTreeObj("divID_Tree_menu_BM").reAsyncChildNodes(null, "refresh");
                });
            }
}
//移除上级
function clearFather() {
    $('#bm_fzj').val('')
    $("#bm_fzj_mc").textbox('setValue',''); 
}
