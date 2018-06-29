function f_xtguanliyuan_jibie(value, row, index) {
    switch (value) {
        case '1':return "超级管理员"
        case '2':return "总管"
        case '3':return "普通管理员"
    }
    return value;
}
function f_gridMenu(e, rowIndex, rowData) {         //右击事件
    $('#menu').menu('show', {
        left: e.pageX, //弹出窗口的方位坐标
        top: e.pageY
    });
    e.preventDefault();         //阻止浏览器自带的右键菜单弹出
}
function dellRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } 
    else if (rows[0].xt_guanliyuan_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法删除');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan1/remove.jw", {id: rows[0].xt_guanliyuan_zj}, "请确认删除操作", function () {
        easyuiGridReload('dg')
    });
}
function updateRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } 
    else if (rows[0].xt_guanliyuan_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法修改');
        return;
    }
    easyuiLoadWindowByURL('showUpdatePage', '修改', '/xt/xtguanliyuan1/update/select.jw?id=' + rows[0].xt_guanliyuan_zj);
}

function seeRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiLoadWindowByURL('showSeeOnePage', '明细', '/xt/xtguanliyuan1/select/selectOne.jw?id=' + rows[0].xt_guanliyuan_zj);
}

//-------------------------单据状态管理-------------------------                
function update01() {//审核
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan1/update/examine.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认审核操作", function () {
        easyuiGridReload('dg')
    });
}
function update10() {//反审核
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan1/update/unexamine.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认反审核操作", function () {
        easyuiGridReload('dg')
    });
}
function update04() {//作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan1/update/void.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认作废操作", function () {
        easyuiGridReload('dg')
    });
}
function update40() {//反作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan1/update/unvoid.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认反作废操作", function () {
        easyuiGridReload('dg')
    });
}
//-------------------------子页面调用方法-------------------------                
function closethisWindow() {
    $('#showUpdatePage').panel('close');
}
function closethisWindowSeeOne() {
    $('#showSeeOnePage').panel('close');
}
/**
 * 过滤条件
 * @returns {void}
 */
function f_condition() {
    $('#showConditionPage').panel({title: '过滤条件'});
    $('#showConditionPage').window('open');
    easyuiLoadWindowByURL('showConditionPage', '过滤条件', '/xt/xttiaojian/ry_tiaojian.jsp?key=XtGuanliyuan');
}
function f_closeCondition() {
    $('#showConditionPage').panel('close');
}
function f_queryByCondition(jsonData) {
    $('#showConditionPage').panel('close');
    var queryParams = $('#dg').datagrid('options').queryParams;
    queryParams.key =jsonData;
    $('#dg').datagrid('reload');
}