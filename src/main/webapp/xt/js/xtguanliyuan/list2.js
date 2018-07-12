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
    easyuiAjax("/xt/xtguanliyuan2/remove.jw", {id: rows[0].xt_guanliyuan_zj}, "请确认删除操作", function () {
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
    easyuiLoadWindowByURL('showUpdatePage', '修改', '/xt/xtguanliyuan2/update/select.jw?id=' + rows[0].xt_guanliyuan_zj);
}

function seeRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiLoadWindowByURL('showSeeOnePage', '明细', '/xt/xtguanliyuan2/select/selectOne.jw?id=' + rows[0].xt_guanliyuan_zj);
}

//-------------------------单据状态管理-------------------------                
function update01() {//审核
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan2/update/examine.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认审核操作", function () {
        easyuiGridReload('dg')
    });
}
function update10() {//反审核
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan2/update/unexamine.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认反审核操作", function () {
        easyuiGridReload('dg')
    });
}
function update04() {//作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan2/update/void.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认作废操作", function () {
        easyuiGridReload('dg')
    });
}
function update40() {//反作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/xt/xtguanliyuan2/update/unvoid.jw", {ids: easyuiGetRowsID(rows, 'xt_guanliyuan_zj')}, "请确认反作废操作", function () {
        easyuiGridReload('dg')
    });
}
function f_resetpassword() {//重置辅管密码
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
	$.messager.prompt('重置密码', '请输入重置后的密码', function(r) {
		if (r) {
			easyuiAjax("/xt/xtguanliyuan2/update/password3.jw", {
				newpassword : r,
				id : rows[0]['xt_guanliyuan_zj']
			}, "请确认你重置的密码为："+r, function() {
			});
		}else{
			$.messager.alert('提示', '无法重置。请输入一个重置后的新密码');
		}
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