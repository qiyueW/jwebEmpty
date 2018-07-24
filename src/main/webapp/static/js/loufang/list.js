function f_initListLoufang() {
    var caobj = new Obj_condition_append();
    toCreateTree("divID_Tree_menu_LoufangFL", "loufangfl_zj", "loufangfl_fzj", "loufangfl_mc", "/base/loufangfl/select/json.jw", false, function (event, id, treeNode) {
        $("#loufangfl_zj").val(treeNode.loufangfl_zj)
        var queryParams = $('#dg').datagrid('options').queryParams;
        caobj.setConditionData(queryParams.key);
        caobj.appendAND("loufangfl_zj","=", treeNode.loufangfl_zj);
        queryParams.key =caobj.getConditionByJSonStr();
        $('#dg').datagrid('reload');
    }, true);
}
function f_gridMenu(e, rowIndex, rowData) {
    $('#menu').menu('show', {
        left: e.pageX, //弹出窗口的方位坐标
        top: e.pageY
    });
    e.preventDefault();
}
function dellRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } else if (rows[0].loufang_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法删除');
        return;
    }
    easyuiAjax("/base/loufang/remove.jw", {id: rows[0].loufang_zj}, "请确认删除操作", function () {
        easyuiGridReload('dg')
    });
}
function updateRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } else if (rows[0].loufang_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法修改');
        return;
    }
    easyuiLoadWindowByURL('showUpdatePage', '修改', '/base/loufang/update/select.jw?id=' + rows[0].loufang_zj);
}

function seeRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiLoadWindowByURL('showSeeOnePage', '明细', '/base/loufang/select/selectOne.jw?id=' + rows[0].loufang_zj);
}

//-------------------------单据状态管理-------------------------                
function update01() {//审核
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/base/loufang/update/examine.jw", {ids: easyuiGetRowsID(rows, 'loufang_zj')}, "请确认审核操作", function () {
        easyuiGridReload('dg')
    });
}
function update10() {//反审核
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/base/loufang/update/unexamine.jw", {ids: easyuiGetRowsID(rows, 'loufang_zj')}, "请确认反审核操作", function () {
        easyuiGridReload('dg')
    });
}
function update04() {//作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/base/loufang/update/void.jw", {ids: easyuiGetRowsID(rows, 'loufang_zj')}, "请确认作废操作", function () {
        easyuiGridReload('dg')
    });
}
function update40() {//反作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/base/loufang/update/unvoid.jw", {ids: easyuiGetRowsID(rows, 'loufang_zj')}, "请确认反作废操作", function () {
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
    easyuiLoadWindowByURL('showConditionPage', '过滤条件', '/xt/xttiaojian/ry_tiaojian.jsp?key=Loufang');
}
function f_closeCondition() {
    $('#showConditionPage').panel('close');
}
function f_queryByCondition(jsonData) {
    $('#showConditionPage').panel('close');
    var queryParams = $('#dg').datagrid('options').queryParams;
    queryParams.key = jsonData;
    $('#dg').datagrid('reload');
}