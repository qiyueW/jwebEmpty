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
            //if (datas.rows[i].xx) //假设哪例不为空的情况下，才算进记录中，需要人为二次调整与判断
                rs = rs + getJsonByBody(datas.rows[i], i == 0 ? null : ",");
        }
        var data = {};
//  data.danju_zj = $('#danju_zj').val()//主键，将由后台进行生成
            data.danjufl_zj = $('#danjufl_zj').val() //分类ID
            data.danju_mc = $('#danju_mc').val() //模块名
            data.danju_daima = $('#danju_daima').val() //模块代码
            data.danju_qianzhui = $('#danju_qianzhui').val() //单据前缀
            data.danju_shijian = $('#danju_shijian').val() //单据时间
            data.danju_liushuihao = $('#danju_liushuihao').val() //单据流水号
            data.danju_bz = $('#danju_bz').val() //备注
            data.danju_zhidanren_zj = $('#danju_zhidanren_zj').val() //制单人
            data.danju_zhidanshijian = $('#danju_zhidanshijian').val() //制单时间
            data.danju_xiugairen_zj = $('#danju_xiugairen_zj').val() //修改人
            data.danju_xiugaishijian = $('#danju_xiugaishijian').val() //修改时间
            data.danju_px = $('#danju_px').val() //排序
            data.danju_zt = $('#danju_zt').val() //单据状态
        data.jsonkey = rs ? "[" + rs + "]" : "";
        easyuiAjax("/base/danju/save.jw", data, "请确认保存操作", function () {
            //回调函数
        });
    }
    function getJsonByBody(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"danjuziduan_zj":"' + toFormatZT(obj.danjuziduan_zj) + '"' //主键
                + ',"danju_zj":"' + toFormatZT(obj.danju_zj) + '"' //表头id
                + ',"danjuziduan_mc":"' + toFormatZT(obj.danjuziduan_mc) + '"' //字段名称
                + ',"danjuziduan_daima":"' + toFormatZT(obj.danjuziduan_daima) + '"' //字段代码
                + ',"danjuziduan_leixing":"' + toFormatZT(obj.danjuziduan_leixing) + '"' //字段类型
                + ',"danjuziduan_xiaoshudian":"' + toFormatZT(obj.danjuziduan_xiaoshudian) + '"' //字段小数点
                + ',"danjuziduan_changdu":"' + toFormatZT(obj.danjuziduan_changdu) + '"' //字段长度
                + ',"danjuziduan_jiaonian":"' + toFormatZT(obj.danjuziduan_jiaonian) + '"' //是否必须校验
                + ',"danjuziduan_jiaoniankuizhi":"' + toFormatZT(obj.danjuziduan_jiaoniankuizhi) + '"' //检验规则
                + ',"danjuziduan_bz":"' + toFormatZT(obj.danjuziduan_bz) + '"' //备注
                + ',"danjuziduan_px":"' + toFormatZT(obj.danjuziduan_px) + '"' //排序
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