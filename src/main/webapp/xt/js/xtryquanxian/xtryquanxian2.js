//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
    toCreateTreeByChkboxType("divID_Tree_menu_XtJuese", "xt_juese_zj", "xt_juese_fzj", "xt_juese_mc", "/xt/xtjuese2/select/json.jw", true, 0, function (event, id, treeNode) {
    }, true);
//yhQC
    toCreateTree("divID_Tree_menu_XtQuanxian", "xt_quanxian_zj", "xt_quanxian_fzj", "xt_quanxian_mc", "/xt/power/admin.jw?key=yhQX", true, function (event, id, treeNode) {
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
        $.messager.alert('提示', '请选择查询权限的用户');
        return;
    }
    //取消权限树所有原有选择。
    var jueseObj = $.fn.zTree.getZTreeObj("divID_Tree_menu_XtJuese");
    var quanxianObj = $.fn.zTree.getZTreeObj("divID_Tree_menu_XtQuanxian");
    jueseObj.checkAllNodes(false);
    quanxianObj.checkAllNodes(false);
    $.post(path_home + "xt/xtryquanxian2/select/selectOne.jw", {id: rows[0].xt_ryquanxian_zj}, function (d) {
        //重装上权限
        jueseObj.expandAll(false);
        quanxianObj.expandAll(false);
        console.log(d)
        console.log(d.xt_juese_zj)
        console.log(d.xt_quanxian)
        var jueseRS = (d["xt_juese_zj"]).split(",");
        var quanxianRS = (d["xt_quanxian"]).split(",");
        var mynode;
        for (var i = 0; i < jueseRS.length; i++) {
            mynode = jueseObj.getNodeByParam("xt_juese_zj", jueseRS[i], null);//通过代码列，检出节点
            if (null != mynode) {//节点不为空，把节点设置为勾选状态
                jueseObj.checkNode(mynode, true, false);
            }
        }
        for (var i = 0; i < quanxianRS.length; i++) {
            mynode = quanxianObj.getNodeByParam("xt_quanxian_dm", quanxianRS[i], null);//通过代码列，检出节点
            if (null != mynode) {//节点不为空，把节点设置为勾选状态
                quanxianObj.checkNode(mynode, true, false);
                console.log(mynode)
            }
        }
        ztree_expandNotChoonse("divID_Tree_menu_XtJuese")
        ztree_expandNotChoonse("divID_Tree_menu_XtQuanxian")
    }, "json");
}

function setPower() {
    var rows = $('#dg').datagrid('getSelections');
    if (!rows[0]) {
        $.messager.alert('提示', '请选择需要绑定权限的用户');
        return;
    }
    var xt_juese_zj = ztree_getNodesValues("divID_Tree_menu_XtJuese", "xt_juese_zj", 1);
    var xt_quanxian = ztree_getNodesValues("divID_Tree_menu_XtQuanxian", "xt_quanxian_dm", 1);
    if(!xt_juese_zj){
        xt_juese_zj="";
    }
    if(!xt_quanxian){
        xt_quanxian="";
    }
    var ry_zj = rows[0].ry_zj;
    easyuiAjax("/xt/xtryquanxian2/adu.jw", {xt_juese_zj: xt_juese_zj, xt_quanxian: xt_quanxian, xt_ry_zj: ry_zj}, "请确认权限设置操作", function () {
        $('#dg').datagrid('reload');
    });
}

/**
 * 过滤条件
 * @returns {void}
 */
function f_condition() {
    $('#showConditionPage').panel({title: '过滤条件'});
    $('#showConditionPage').window('open');
    easyuiLoadWindowByURL('showConditionPage', '过滤条件', '/xt/xttiaojian/ry_tiaojian.jsp?key=RY');
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