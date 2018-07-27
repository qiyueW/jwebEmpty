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
        data.chaoshuibiao_zj = $('#chaoshuibiao_zj').val()//主键
            data.chaoshuibiao_loufang_zj = $('#chaoshuibiao_loufang_zj').val() //楼主键
            data.chaoshuibiao_loufang_mc = $('#chaoshuibiao_loufang_mc').val() //楼名称
            data.chaoshuibiao_loufang2_zj = $('#chaoshuibiao_loufang2_zj').val() //房主键
            data.chaoshuibiao_loufang2_bianma = $('#chaoshuibiao_loufang2_bianma').val() //房编号
            data.chaoshuibiao_dushu1 = $('#chaoshuibiao_dushu1').val() //上次读数
            data.chaoshuibiao_riqi1 = $('#chaoshuibiao_riqi1').val() //上次抄表日期
            data.chaoshuibiao_dushu2 = $('#chaoshuibiao_dushu2').val() //读数
            data.chaoshuibiao_riqi2 = $('#chaoshuibiao_riqi2').val() //抄表日期
            data.chaoshuibiao_shui = $('#chaoshuibiao_shui').val() //水(吨)
            data.chaoshuibiao_shui_danjia = $('#chaoshuibiao_shui_danjia').val() //水单价
            data.chaoshuibiao_shui_jine = $('#chaoshuibiao_shui_jine').val() //金额
            data.chaoshuibiao_zhidanshijian = $('#chaoshuibiao_zhidanshijian').val() //制单时间
            data.chaoshuibiao_zhidanren = $('#chaoshuibiao_zhidanren').val() //制单人
            data.chaoshuibiao_zhidanren_zj = $('#chaoshuibiao_zhidanren_zj').val() //制单人主键
            data.chaoshuibiao_fentanrenshu = $('#chaoshuibiao_fentanrenshu').val() //分摊人数
            data.chaoshuibiao_yj_fentanrenshu = $('#chaoshuibiao_yj_fentanrenshu').val() //已分摊人数
            data.chaoshuibiao_zt = $('#chaoshuibiao_zt').val() //状态
            data.chaoshuibiao_gelibiaoshi = $('#chaoshuibiao_gelibiaoshi').val() //隔离标识
        data.jsonkey = rs ? "[" + rs + "]" : "";
        easyuiAjax("/service/chaoshuibiao/update.jw", data, "请确认修改操作", function () {
            //回调函数
        });
    }
    function getJsonByBody(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"chaoshuibiaofengtan_zj":"' + toFormatZT(obj.chaoshuibiaofengtan_zj) + '"' //主键
                + ',"chaoshuibiao_zj":"' + toFormatZT(obj.chaoshuibiao_zj) + '"' //水表记录主键
                + ',"chaoshuibiaofengtan_shui":"' + toFormatZT(obj.chaoshuibiaofengtan_shui) + '"' //水
                + ',"chaoshuibiaofengtan_shui_danjia":"' + toFormatZT(obj.chaoshuibiaofengtan_shui_danjia) + '"' //水单价
                + ',"chaoshuibiaofengtan_feiyong":"' + toFormatZT(obj.chaoshuibiaofengtan_feiyong) + '"' //分摊费
                + ',"chaoshuibiaofengtan_nfsj":"' + toFormatZT(obj.chaoshuibiaofengtan_nfsj) + '"' //纳费时间
                + ',"chaoshuibiaofengtan_nfr_zj":"' + toFormatZT(obj.chaoshuibiaofengtan_nfr_zj) + '"' //纳费人主键
                + ',"chaoshuibiaofengtan_nfr":"' + toFormatZT(obj.chaoshuibiaofengtan_nfr) + '"' //纳费人
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