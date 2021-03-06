function f_gridMenu(e, rowIndex, rowData) {         //右击事件
    $('#menu').menu('show', {
        left: e.pageX, //弹出窗口的方位坐标
        top: e.pageY
    });
    e.preventDefault();         //阻止浏览器自带的右键菜单弹出
}
function updateRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    } else if (rows[0].chaoshuibiao_zt != '0') {
        $.messager.alert('异常', '单据锁定，无法修改');
        return;
    }
    easyuiLoadWindowByURL('showUpdatePage', '修改', '/service/chaoshuibiao/update/select.jw?id=' + rows[0].chaoshuibiao_zj);
}

function seeRow() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiLoadWindowByURL('showSeeOnePage', '明细', '/service/chaoshuibiao/select/selectOne.jw?id=' + rows[0].chaoshuibiao_zj);
}

//-------------------------单据状态管理-------------------------                
function update1() {//上月楼，一键出账。
    var lou_zj = $('#chaoshuibiao_loufang_zj').val();
    if (!lou_zj) {
        $.messager.alert('提示', '请先选择楼房');
        return;
    }
    var date = new Date();
    var mydate;
    if (date.getMonth() == 0) {
        mydate = date.getFullYear() - 1 + "-12";
    } else {
        mydate = date.getFullYear() + (date.getMonth() < 10 ? "-0" : "-") + date.getMonth();
    }
    easyuiAjax("/service/loufangchuzhang/save.jw", {
        lou: lou_zj, yearMoth: mydate
    }, "请确认" + mydate + "月份的出账", function () {

    });
}
function update2() {//上月楼，一键出账。
    var lou_zj = $('#chaoshuibiao_loufang_zj').val();
    if (!lou_zj) {
        $.messager.alert('提示', '请先选择楼房');
        return;
    }
    var date = new Date();
    var mydate = date.getFullYear() + (date.getMonth() < 10 ? "-0" : "-") + (date.getMonth()+1);
    easyuiAjax("/service/loufangchuzhang/save.jw", {
        lou: lou_zj, yearMoth: mydate
    }, "请确认" + mydate + "月份的出账", function () {
    });
}
function update04() {//作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/service/chaoshuibiao/update/void.jw", {ids: easyuiGetRowsID(rows, 'chaoshuibiao_zj')}, "请确认作废操作", function () {
        easyuiGridReload('dg')
    });
}
function update40() {//反作废
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择行');
        return;
    }
    easyuiAjax("/service/chaoshuibiao/update/unvoid.jw", {ids: easyuiGetRowsID(rows, 'chaoshuibiao_zj')}, "请确认反作废操作", function () {
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
    easyuiLoadWindowByURL('showConditionPage', '过滤条件', '/xt/xttiaojian/ry_tiaojian.jsp?key=ChaoShuibiao');
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