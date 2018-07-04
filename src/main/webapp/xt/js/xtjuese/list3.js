function f_grid_xt_juese_gongsi(value, row, index) {
    if (value == "1") {
        return "公有"
    }
    if (value == "0") {
        return "私有"
    }
    return value;
}
function f_gridMenu(e, row) {         //右击事件
    e.preventDefault(); //阻止浏览器捕获右键事件
    $('#menu').menu('show', {
        left: e.pageX, //弹出窗口的方位坐标
        top: e.pageY
    });
    e.preventDefault();         //阻止浏览器自带的右键菜单弹出
}
/**
 * 过滤条件
 * @returns {void}
 */
function f_condition() {
    $('#showConditionPage').panel({title: '过滤条件'});
    $('#showConditionPage').window('open');
    easyuiLoadWindowByURL('showConditionPage', '过滤条件', '/xt/xttiaojian/ry_tiaojian.jsp?key=XtJuese');
}
function dellRow() {
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } 
    else if (rows[0].xt_juese_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法删除');
        return;
    }
    easyuiAjax("/xt/xtjuese3/remove.jw", {id: rows[0].xt_juese_zj}, "请确认删除操作", function () {
        easyuiTreeGridReload('dg')
    });
}
function updateRow() {
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } 
    else if (rows[0].xt_juese_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法修改');
        return;
    }
    easyuiLoadWindowByURL('showUpdatePage', '修改', '/xt/xtjuese3/update/select.jw?id=' + rows[0].xt_juese_zj);
}

function seeRow() {
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiLoadWindowByURL('showSeeOnePage', '明细', '/xt/xtjuese3/select/selectOne.jw?id=' + rows[0].xt_juese_zj);
}

//-------------------------单据状态管理-------------------------                
function update01() {//审核
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtjuese3/update/examine.jw", {ids: easyuiGetRowsID(rows, 'xt_juese_zj')}, "请确认审核操作", function () {
        easyuiTreeGridReload('dg')
    });
}
function update10() {//反审核
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtjuese3/update/unexamine.jw", {ids: easyuiGetRowsID(rows, 'xt_juese_zj')}, "请确认反审核操作", function () {
        easyuiTreeGridReload('dg')
    });
}
function update04() {//作废
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtjuese3/update/void.jw", {ids: easyuiGetRowsID(rows, 'xt_juese_zj')}, "请确认作废操作", function () {
        easyuiTreeGridReload('dg')
    });
}
function update40() {//反作废
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtjuese3/update/unvoid.jw", {ids: easyuiGetRowsID(rows, 'xt_juese_zj')}, "请确认反作废操作", function () {
        easyuiTreeGridReload('dg')
    });
}
//-------------------------子页面调用方法-------------------------                
function closethisWindow() {
    $('#showUpdatePage').panel('close');
}
function closethisWindowSeeOne() {
    $('#showSeeOnePage').panel('close');
}
function f_closeCondition() {
    $('#showConditionPage').panel('close');
}
function f_queryByCondition(jsonData) {
    $('#showConditionPage').panel('close');
    var queryParams = $('#dg').treegrid('options').queryParams;
    queryParams.key =jsonData;
    $('#dg').treegrid('reload');
}