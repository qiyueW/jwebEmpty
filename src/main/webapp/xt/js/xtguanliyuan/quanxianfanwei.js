//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTreeByChkboxType("divID_Tree_menu_XtQuanxian", "bm_zj", "bm_fzj", "bm_mc", "/base/bm/select/json.jw", true, 0, function (event, id, treeNode) {
    }, true);
}
function f_xtguanliyuan_jibie(value, row, index) {
    switch (value) {
        case '1':return "超级管理员"
        case '2':return "总管"
        case '3':return "普通管理员"
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
function seeRowPower() {
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择管理员');
        return;
    }
    //取消权限树所有原有选择。
    var treeObj = $.fn.zTree.getZTreeObj("divID_Tree_menu_XtQuanxian");
    treeObj.checkAllNodes(false);
    $.post(path_home + "/xt/xtguanliyuan2/quanxian/select/selectOne/json.jw", {id: f_getGuanliyuanGrid_zj(rows)}, function (d) {
        //重装上权限
        treeObj.expandAll(false);
        var rsdata = d.xt_guanliyuan_bm.split(",");
        var mynode;
        for (var i = 0; i < rsdata.length; i++) {
            mynode = treeObj.getNodeByParam("bm_zj", rsdata[i], null);//通过代码列，检出节点
            if (null != mynode) {//节点不为空，把节点设置为勾选状态
                treeObj.checkNode(mynode, true, false);
            }
        }
        var halfCheck = treeObj.getNodes()[0].getCheckStatus();

        ztree_expandNotChoonse("divID_Tree_menu_XtQuanxian")
    }, "json");
}
function f_getGuanliyuanGrid_zj(rows) {
    var rs = "";
    for (var i = 0; i < rows.length; i++) {
        if (i == 0) {
            rs = rs + rows[i].xt_guanliyuan_zj;
        } else {
            rs = rs + "," + rows[i].xt_guanliyuan_zj;
        }
    }
    return rs;
}

function setPower() {
    var rows = $('#dg').treegrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择角色');
        return;
    }
    var bms = ztree_getNodesValues("divID_Tree_menu_XtQuanxian", "bm_zj", 1);
    var xt_guanliyuan_zj = f_getGuanliyuanGrid_zj(rows);

    easyuiAjax("/xt/xtguanliyuan2/quanxian/xiugan/bm.jw", {xt_guanliyuan_bm: bms, xt_guanliyuan_zj: xt_guanliyuan_zj}, "请确认权限设置操作", function () {
    });
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
    queryParams.key = jsonData;
    $('#dg').datagrid('reload');
}