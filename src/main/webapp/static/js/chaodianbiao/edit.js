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
        data.chaodianbiao_zj = $('#chaodianbiao_zj').val()//主键
            data.chaodianbiao_loufang_zj = $('#chaodianbiao_loufang_zj').val() //楼主键
            data.chaodianbiao_loufang_mc = $('#chaodianbiao_loufang_mc').val() //楼名称
            data.chaodianbiao_loufang2_zj = $('#chaodianbiao_loufang2_zj').val() //房主键
            data.chaodianbiao_loufang2_bianma = $('#chaodianbiao_loufang2_bianma').val() //房编号
            data.chaodianbiao_dushu1 = $('#chaodianbiao_dushu1').val() //上次读数
            data.chaodianbiao_riqi1 = $('#chaodianbiao_riqi1').val() //上次抄表日期
            data.chaodianbiao_dushu2 = $('#chaodianbiao_dushu2').val() //读数
            data.chaodianbiao_riqi2 = $('#chaodianbiao_riqi2').val() //抄表日期
            data.chaodianbiao_dian = $('#chaodianbiao_dian').val() //水(吨)
            data.chaodianbiao_dian_danjia = $('#chaodianbiao_dian_danjia').val() //水单价
            data.chaodianbiao_dian_jine = $('#chaodianbiao_dian_jine').val() //金额
            data.chaodianbiao_zhidanshijian = $('#chaodianbiao_zhidanshijian').val() //制单时间
            data.chaodianbiao_zhidanren = $('#chaodianbiao_zhidanren').val() //制单人
            data.chaodianbiao_zhidanren_zj = $('#chaodianbiao_zhidanren_zj').val() //制单人主键
            data.chaodianbiao_fentanrenshu = $('#chaodianbiao_fentanrenshu').val() //分摊人数
            data.chaodianbiao_yj_fentanrenshu = $('#chaodianbiao_yj_fentanrenshu').val() //已分摊人数
            data.chaodianbiao_zt = $('#chaodianbiao_zt').val() //状态
            data.chaodianbiao_gelibiaoshi = $('#chaodianbiao_gelibiaoshi').val() //隔离标识
        data.jsonkey = rs ? "[" + rs + "]" : "";
        easyuiAjax("/service/chaodianbiao/update.jw", data, "请确认修改操作", function () {
            //回调函数
        });
    }
    function getJsonByBody(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"chaodianbiaofengtan_zj":"' + toFormatZT(obj.chaodianbiaofengtan_zj) + '"' //主键
                + ',"chaodianbiao_zj":"' + toFormatZT(obj.chaodianbiao_zj) + '"' //水表记录主键
                + ',"chaodianbiaofengtan_dian":"' + toFormatZT(obj.chaodianbiaofengtan_dian) + '"' //水
                + ',"chaodianbiaofengtan_dian_danjia":"' + toFormatZT(obj.chaodianbiaofengtan_dian_danjia) + '"' //水单价
                + ',"chaodianbiaofengtan_feiyong":"' + toFormatZT(obj.chaodianbiaofengtan_feiyong) + '"' //分摊费
                + ',"chaodianbiaofengtan_nfsj":"' + toFormatZT(obj.chaodianbiaofengtan_nfsj) + '"' //纳费时间
                + ',"chaodianbiaofengtan_nfr_zj":"' + toFormatZT(obj.chaodianbiaofengtan_nfr_zj) + '"' //纳费人主键
                + ',"chaodianbiaofengtan_nfr":"' + toFormatZT(obj.chaodianbiaofengtan_nfr) + '"' //纳费人
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