//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
//function inido() {
//    toCreateTree("divID_Tree_menu_XtGuanliyuan", "${treeMyid}", "${treeMypid}", "${treeMyname}", "/xt/xtguanliyuan/select/json.jw", false,onclickdo,true);
//    function onclickdo(event, id, treeNode) {
//        $.messager.confirm('更换上级', '请确认是否改变他的上级?', function (r) {
//            if (r) {
//                $("#${treeMypid}").val(treeNode.${treeMyid})
//                $("#${treeMypid}_mc").textbox('setValue',treeNode.${treeMyname}); 
//           }
//        });
//    }
//}
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
                data.xt_guanliyuan_zj =fzFormatZT($("#xt_guanliyuan_zj").val())//管理员主键
                data.xt_guanliyuan_mc =fzFormatZT($("#xt_guanliyuan_mc").val())//管理员名称
                data.xt_guanliyuan_zhanghao =fzFormatZT($("#xt_guanliyuan_zhanghao").val())//管理员账号
                data.xt_guanliyuan_mima =fzFormatZT($("#xt_guanliyuan_mima").val())//管理员密码
                data.xt_guanliyuan_youxiang =fzFormatZT($("#xt_guanliyuan_youxiang").val())//管理员邮箱
                data.xt_guanliyuan_zt =fzFormatZT($("#xt_guanliyuan_zt").val())//管理员状态
                data.xt_guanliyuan_bz =fzFormatZT($("#xt_guanliyuan_bz").val())//管理员备注
                data.xt_guanliyuan_quanxian =fzFormatZT($("#xt_guanliyuan_quanxian").val())//管理员权限集合
                data.xt_guanliyuan_bm =fzFormatZT($("#xt_guanliyuan_bm").val())//管理员部门集合
                data.xt_guanliyuan_gelibiaoshi =fzFormatZT($("#xt_guanliyuan_gelibiaoshi").val())//隔离标识
                data.xt_guanliyuan_zhidanshijian =fzFormatZT($("#xt_guanliyuan_zhidanshijian").val())//制单时间
                easyuiAjax("/xt/xtguanliyuan/update.jw", data, "请确认修改操作", function () {
                    //$.fn.zTree.getZTreeObj("divID_Tree_menu_XtGuanliyuan").reAsyncChildNodes(null, "refresh");
                });
            }
}
