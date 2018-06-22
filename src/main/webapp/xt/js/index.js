function loadUserMainTree(divID) {
    //检出包结构  /*               
    var setting0 = {
        treeId: "xt_quanxian_zj",
        async: {enable: true, type: "post", url: path_home + "xt/menu/admin.jw"},
        data: {simpleData: {enable: true, idKey: "xt_quanxian_zj", pIdKey: "xt_quanxian_fzj", rootPId: "0"}, key: {name: "xt_quanxian_mc"}},
        callback: {
            onClick: function (event, id, treeNode) {
                if (treeNode.xt_quanxian_url) {
                    addTab(treeNode.xt_quanxian_mc, treeNode.xt_quanxian_url);
                }
            },
            onAsyncSuccess: function () {
                $.fn.zTree.getZTreeObj(divID).expandAll(true);
            }
        }
    };
    $.fn.zTree.init($("#" + divID), setting0);
}
function addTab(title, url) {
    if ($('#tt').tabs('exists', title)) {
        $('#tt').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="' + path_home + url + '" style="width:99.4%;height:99.4%;"></iframe>';
        $('#tt').tabs('add', {
            title: title,
            content: content,
            closable: true
        });
    }
}