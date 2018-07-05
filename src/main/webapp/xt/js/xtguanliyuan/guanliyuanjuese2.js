//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTreeByChkboxType("divID_Tree_menu_XtQuanxian", "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc", "/xt/xtjuese2/select/json.jw", true, 0, function (event, id, treeNode) {
    }, true);
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
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择管理员');
        return;
    }
    //取消权限树所有原有选择。
    var treeObj = $.fn.zTree.getZTreeObj("divID_Tree_menu_XtQuanxian");
    treeObj.checkAllNodes(false);
                        
    $.post(path_home + "xt/xtguanliyuan2/juese/select/json.jw", {id: f_getGuanliyuanGrid_zj(rows)}, function (d) {
        //重装上权限
        treeObj.expandAll(false);
        var rsdata = d.xt_juese_zj.split(",");
        var mynode;
        for (var i = 0; i < rsdata.length; i++) {
            mynode = treeObj.getNodeByParam("xt_juese_zj", rsdata[i], null);//通过代码列，检出节点
            if (null != mynode) {//节点不为空，把节点设置为勾选状态
                treeObj.checkNode(mynode, true, false);
            }
        }
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
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择需要绑定角色的管理员');
        return;
    }
    var xt_juese_zj = ztree_getNodesValues("divID_Tree_menu_XtQuanxian", "xt_juese_zj", 1);
    var xt_guanliyuan_zj = f_getGuanliyuanGrid_zj(rows);
    easyuiAjax("/xt/xtguanliyuan2/juese/adu.jw", {xt_juese_zj: xt_juese_zj, xt_guanliyuan_zj: xt_guanliyuan_zj}, "请确认权限设置操作", function () {
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