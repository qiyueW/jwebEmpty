function f_panduan(value, row, index) {
    if (value instanceof Object) {
        row.xt_tiaojian1_panduan = value.xt_tiaojian1_panduan;
        row.xt_tiaojian1_panduan_mc = value.xt_tiaojian1_panduan_mc;
    }
    return row.xt_tiaojian1_panduan_mc;
}
function f_lianjiefu(value, row, index) {
    if (value instanceof Object) {
        row.xt_tiaojian1_lianjiefu = value.xt_tiaojian1_lianjiefu;
        row.xt_tiaojian1_lianjiefu_mc = value.xt_tiaojian1_lianjiefu_mc;
    }
    return row.xt_tiaojian1_lianjiefu_mc;
}
function f_tiaojianzhi(value, row, index) {
    if (value instanceof Object) {
        row.xt_shezhi_tiaojian1_zhi = value.xt_shezhi_tiaojian1_zhi;
        row.xt_shezhi_tiaojian1_mc = value.xt_shezhi_tiaojian1_mc;
    }
    return row.xt_shezhi_tiaojian1_mc;
}
function dellRowServlet() {
    var zj = $('#xt_tiaojian_zj').val();
    if (!zj) {
        $.messager.alert('提示', '请选择方案');
        return;
    }
    easyuiAjax("/xt/xttiaojian/remove2.jw", {id: zj}, "请确认删除操作", function () {
        easyuiGridReload('dg')
        $.fn.zTree.getZTreeObj("divID_Tree_menu").reAsyncChildNodes(null, "refresh");
    });
}
function upCondition() {
    $("#dg").datagrid('endEdit', getIndex());
    var datas = $('#dg').datagrid('getData');
    var rs = "";
    for (var i = 0; i < datas.total; i++) {
        if (datas.rows[i].xt_tiaojian1_kuohao || (
                datas.rows[i].xt_shezhi_tiaojian1_zhi && datas.rows[i].xt_shezhi_tiaojian1_mc
                && datas.rows[i].xt_tiaojian1_panduan && datas.rows[i].xt_tiaojian1_panduan_mc)
                ) //假设哪例不为空的情况下，才算进记录中，需要人为二次调整与判断
            rs = rs + getJsonByBody(datas.rows[i], i == 0 ? null : ",");
    }
    return rs ? "[" + rs + "]" : "";
}
////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function submitForm(formid, update) {
    var vcheck = $('#' + formid).form('enableValidation').form('validate');
    if (vcheck) {
        $("#dg").datagrid('endEdit', getIndex());
        var datas = $('#dg').datagrid('getData');
        var rs = "";
        for (var i = 0; i < datas.total; i++) {
            if (datas.rows[i].xt_tiaojian1_kuohao || (
                    datas.rows[i].xt_shezhi_tiaojian1_zhi && datas.rows[i].xt_shezhi_tiaojian1_mc
                    && datas.rows[i].xt_tiaojian1_panduan && datas.rows[i].xt_tiaojian1_panduan_mc)
                    ) //假设哪例不为空的情况下，才算进记录中，需要人为二次调整与判断
                rs = rs + getJsonByBody(datas.rows[i], i == 0 ? null : ",");
        }
        var data = {};
        data.xt_tiaojian_zj = $('#xt_tiaojian_zj').val()//主键，将由后台进行生成
        data.xt_tiaojian_mc = $('#xt_tiaojian_mc').val() //条件方案名称
        data.xt_shezhi_tiaojian_zhi = $('#xt_shezhi_tiaojian_zhi').val() //模块代号
        data.xt_tiaojian_gelibiaoshi = $('#xt_tiaojian_gelibiaoshi').val() //单据隔离标识
        data.xt_tiaojian_zt = $('#xt_tiaojian_zt').val() //状态
        data.jsonkey = rs ? "[" + rs + "]" : "";
        if (update) {
            easyuiAjax("/xt/xttiaojian/update2.jw", data, "请确认修改操作", function () {
                $.fn.zTree.getZTreeObj("divID_Tree_menu").reAsyncChildNodes(null, "refresh");
            });
        } else {
            easyuiAjax("/xt/xttiaojian/save.jw", data, "请确认保存操作", function () {
                $.fn.zTree.getZTreeObj("divID_Tree_menu").reAsyncChildNodes(null, "refresh");
            });
        }
    }
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
function getIndex() {
    var row = $("#dg").datagrid('getSelected');
    return row ? $("#dg").datagrid('getRowIndex', row) : 0;
}
function dellRow() {
    var index = getIndex()
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
    var index = getIndex()
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

//页面交互区
function f_queryByCondition() {
    window.parent.f_queryByCondition(upCondition());//调取aa函数
}
function closeCondition() {
    window.parent.f_closeCondition();
}