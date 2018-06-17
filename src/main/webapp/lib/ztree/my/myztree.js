
/**
 * 获得指定字段的值（通过'v,v1,v2,v3'的格式字符串返回）
 * @param {type} treeID
 * @param {type} columnName
 * @param {type} index_0_1_2 0表示未勾选，1表示勾选，2表示全部默认是全部。
 * @returns {String}
 */
function ztree_getNodesValues(treeID, columnName, index_0_1_2) {
    var obj = $.fn.zTree.getZTreeObj(treeID);
    var nodes;
    //如果没有此参数，或此参数为2，表示取所有节点的值。
    if (null == index_0_1_2 || index_0_1_2 == 2) {
        nodes = obj.getNodes();
    } else {
        //如果等于1，取所有勾选节点。否则取未勾选的节点。
        nodes = obj.getCheckedNodes(index_0_1_2 == 1 ? true : false);
    }
    var rs = "";
    for (var i = 0; i < nodes.length; i++) {
        rs = rs + "," + nodes[i][columnName];//.data.role_id;
    }
    return rs.substring(1);
}

function ztree_expandNotChoonse(treeID) {
    var obj = $.fn.zTree.getZTreeObj(treeID);//检出树
    var nodes = obj.getCheckedNodes(false);//所有未勾选的节点
    var nodesOK = obj.getCheckedNodes(true);//所有未勾选的节点
    for (var i = 0; i < nodesOK.length; i++) {
        obj.expandNode(nodesOK[i], true, false, true);//执行展开
    }
    for (var i = 0; i < nodes.length; i++) {
        if (nodes[i].getCheckStatus().half || nodes[i].checked) {
            obj.expandNode(nodes[i], true, false, true);//执行展开
        }
    }
}

function ztree_getNodeSonValue(node, columnName) {
    if (!node || !columnName)
        return;
    var str = "";
    getALLSon(node);
    return str.substring(1);

    function getALLSon(node) {
        str += "," + node[columnName]
        if (node.isParent) {
            var sonNode = node.children;
            if (sonNode) {
                for (var i = 0; i < sonNode.length; i++) {
                    getALLSon(sonNode[i]);
                }
            }
        }
    }

}