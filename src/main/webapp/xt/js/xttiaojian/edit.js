//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
//初始化
function inido() {

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
        close=true;
        $("#dg").datagrid('endEdit', getIndex());
        var datas = $('#dg').datagrid('getData');
        var rs = "";
        for (var i = 0; i < datas.total; i++) {
            //if (datas.rows[i].xx) //假设哪例不为空的情况下，才算进记录中，需要人为二次调整与判断
                rs = rs + getJsonByBody(datas.rows[i], i == 0 ? null : ",");
        }
        var data = {};
        data.xt_tiaojian_zj = $('#xt_tiaojian_zj').val()//主键
            data.xt_shezhi_tiaojian_zj = $('#xt_shezhi_tiaojian_zj').val() //条件方案名称
            data.xt_tiaojian_mc = $('#xt_tiaojian_mc').val() //条件方案名称
            data.xt_tiaojian_zhidanren_zj = $('#xt_tiaojian_zhidanren_zj').val() //方案制定人主键
            data.xt_tiaojian_gelibiaoshi = $('#xt_tiaojian_gelibiaoshi').val() //单据隔离标识
            data.xt_tiaojian_zt = $('#xt_tiaojian_zt').val() //状态
        data.jsonkey = rs ? "[" + rs + "]" : "";
        easyuiAjax("/xt/xttiaojian/update.jw", data, "请确认修改操作", function () {
            //回调函数
        });
    }
    function getJsonByBody(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"xt_tiaojian1_zj":"' + toFormatZT(obj.xt_tiaojian1_zj) + '"' //主键
                + ',"xt_tiaojian_zj":"' + toFormatZT(obj.xt_tiaojian_zj) + '"' //表头主键
                + ',"xt_tiaojian1_kuohao":"' + toFormatZT(obj.xt_tiaojian1_kuohao) + '"' //括号区
                + ',"xt_tiaojian1_lianjiefu":"' + toFormatZT(obj.xt_tiaojian1_lianjiefu) + '"' //接连符
                + ',"xt_tiaojian1_lianjiefu_mc":"' + toFormatZT(obj.xt_tiaojian1_lianjiefu_mc) + '"' //接连符展示名
                + ',"xt_shezhi_tiaojian1_mc":"' + toFormatZT(obj.xt_shezhi_tiaojian1_mc) + '"' //条件区展示名
                + ',"xt_shezhi_tiaojian1_zhi":"' + toFormatZT(obj.xt_shezhi_tiaojian1_zhi) + '"' //条件区值
                + ',"xt_tiaojian1_panduan":"' + toFormatZT(obj.xt_tiaojian1_panduan) + '"' //判断区
                + ',"xt_tiaojian1_panduan_mc":"' + toFormatZT(obj.xt_tiaojian1_panduan_mc) + '"' //判断区展示名
                + ',"xt_tiaojian1_zhi":"' + toFormatZT(obj.xt_tiaojian1_zhi) + '"' //条件值
        return str + "}";
    }
}

function getIndex() {
    var row = $("#dg").datagrid('getSelected');
    return row ? $("#dg").datagrid('getRowIndex', row) : 0;
}
function dellRow() {
    var index =getIndex()
    $("#dg").datagrid('deleteRow', index)
    if (editIndex) {
        $('#dg').datagrid('endEdit', editIndex);
        editIndex = undefined;
    }
}
function addRow() {
    var index = getIndex();
    $("#dg").datagrid('insertRow', {
        index: (++index),
        row: {}
    });
}
function MoveUp() {
    var index =getIndex()
    mysort(index, 'up', 'dg');
}
//下移
function MoveDown() {
    var index = getIndex()
    mysort(index, 'down', 'dg');
}
function mysort(index, type, gridname) {
    $("#dg").datagrid('endEdit', index);
    if ("up" == type) {
        if (index != 0) {
            var toup = $('#' + gridname).datagrid('getData').rows[index];
            var todown = $('#' + gridname).datagrid('getData').rows[index - 1];
            $('#' + gridname).datagrid('getData').rows[index] = todown;
            $('#' + gridname).datagrid('getData').rows[index - 1] = toup;
            $('#' + gridname).datagrid('refreshRow', index);
            $('#' + gridname).datagrid('refreshRow', index - 1);
            $('#' + gridname).datagrid('selectRow', index - 1);
        }
    } else if ("down" == type) {
        var rows = $('#' + gridname).datagrid('getRows').length;
        if (index != rows - 1) {
            var todown = $('#' + gridname).datagrid('getData').rows[index];
            var toup = $('#' + gridname).datagrid('getData').rows[index + 1];
            $('#' + gridname).datagrid('getData').rows[index + 1] = todown;
            $('#' + gridname).datagrid('getData').rows[index] = toup;
            $('#' + gridname).datagrid('refreshRow', index);
            $('#' + gridname).datagrid('refreshRow', index + 1);
            $('#' + gridname).datagrid('selectRow', index + 1);
        }
    }
}
$.extend($.fn.datagrid.methods, {
    editCell: function (jq, param) {
        return jq.each(function () {
            var opts = $(this).datagrid('options');
            var fields = $(this).datagrid('getColumnFields', true).concat($(this).datagrid('getColumnFields'));
            for (var i = 0; i < fields.length; i++) {
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor1 = col.editor;
                if (fields[i] != param.field) {
                    col.editor = null;
                }
            }
            $(this).datagrid('beginEdit', param.index);
            for (var i = 0; i < fields.length; i++) {
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor = col.editor1;
            }
        });
    }
});

var editIndex = undefined;
function endEditing() {
    if (editIndex == undefined) {
        return true
    }
    if ($('#dg').datagrid('validateRow', editIndex)) {
        $('#dg').datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}
var i = 1;
function onClickCell(index, field) {
    $('#dg').datagrid('endEdit', editIndex);
    $("#dg").datagrid('beginEdit', index);//{index:index, field: field}
    var ed = $("#dg").datagrid('getEditor', {index: index, field: field});//获取当前编辑器
    $(ed.target).focus();//获取焦点
    //
//                if (endEditing()) {
//                    console.log("doing endEditing()"+(++i))
//                    $('#dg').datagrid('selectRow', index)
//                            .datagrid('editCell', {index: index, field: field});
    editIndex = index;
//                }
}