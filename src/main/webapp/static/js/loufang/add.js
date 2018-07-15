////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
    if (vcheck) {
        $("#dg").datagrid('endEdit', getIndex());
        var datas = $('#dg').datagrid('getData');
        var rs = "";
        for (var i = 0; i < datas.total; i++) {
            if (datas.rows[i].loufang2_bianhao) //假设哪例不为空的情况下，才算进记录中，需要人为二次调整与判断
                rs = rs + getJsonByBody(datas.rows[i], i == 0 ? null : ",");
        }
        var data = {};
//  data.loufang_zj = $('#loufang_zj').val()//主键，将由后台进行生成
            data.loufangfl_zj = $('#loufangfl_zj').val() //分类外键
            data.loufang_mc = $('#loufang_mc').val() //名称
            data.loufang_tj_danrenfang = $('#loufang_tj_danrenfang').val() //单人房总数
            data.loufang_tj_taojianfang = $('#loufang_tj_taojianfang').val() //套间房总数
            data.loufang_dizhi = $('#loufang_dizhi').val() //地址
            data.loufang_bz = $('#loufang_bz').val() //备注
            data.loufang_gelibiaoshi = $('#loufang_gelibiaoshi').val() //隔离标识
            data.loufang_zt = $('#loufang_zt').val() //状态
        data.jsonkey = rs ? "[" + rs + "]" : "";
        easyuiAjax("/base/loufang/save.jw", data, "请确认保存操作", function () {
            //回调函数
        });
    }
    function getJsonByBody(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"loufang_zj":"' + toFormatZT(obj.loufang_zj) + '"' //父键
                + ',"loufang2_gelibiaoshi":"' + toFormatZT(obj.loufang2_gelibiaoshi) + '"' //隔离标识
                + ',"loufang2_zj":"' + toFormatZT(obj.loufang2_zj) + '"' //主键
                + ',"loufang2_bianhao":"' + toFormatZT(obj.loufang2_bianhao) + '"' //编号
                + ',"loufang2_mingcheng":"' + toFormatZT(obj.loufang2_mingcheng) + '"' //名称
                + ',"loufang2_chuangwei":"' + toFormatZT(obj.loufang2_chuangwei) + '"' //床位
                + ',"loufang2_ruzhurenshu":"' + toFormatZT(obj.loufang2_ruzhurenshu) + '"' //入住人数
                + ',"loufang2_ruzhuren_zj":"' + toFormatZT(obj.loufang2_ruzhuren_zj) + '"' //入住人主键集合
                + ',"loufang2_lx":"' + toFormatZT(obj.loufang2_lx) + '"' //房间类型
                + ',"loufang2_bz":"' + toFormatZT(obj.loufang2_bz) + '"' //备注
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