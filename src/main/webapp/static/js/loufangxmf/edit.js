//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
//function inido() {
//    toCreateTree("divID_Tree_menu_LoufangXMF", "${treeMyid}", "${treeMypid}", "${treeMyname}", "/base/loufangxmf/select/json.jw", false,onclickdo,true);
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
                data.loufangxmf_zj =fzFormatZT($("#loufangxmf_zj").val())//主键
                data.loufangxmf_gelibiaoshi =fzFormatZT($("#loufangxmf_gelibiaoshi").val())//隔离标识
                data.loufangxmf_mc =fzFormatZT($("#loufangxmf_mc").val())//项目名称
                data.loufangxmf_feiyong =fzFormatZT($("#loufangxmf_feiyong").val())//项目费
                data.loufangxmf_zt =fzFormatZT($("#loufangxmf_zt").val())//状态
                easyuiAjax("/base/loufangxmf/update.jw", data, "请确认修改操作", function () {
                    //$.fn.zTree.getZTreeObj("divID_Tree_menu_LoufangXMF").reAsyncChildNodes(null, "refresh");
                });
            }
}
