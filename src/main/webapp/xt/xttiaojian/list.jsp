
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护系统条件管理</title>
        <script type="text/javascript" src="${path_home}/xt/js/xttiaojian/list.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'xt_tiaojian_zj');
                $('#dg').datagrid('hideColumn', 'xt_shezhi_tiaojian_zj');
                $('#dg').datagrid('hideColumn', 'xt_tiaojian_zhidanren_zj');
                toCreateTree("divID_Tree_menu"
                        , "xt_shezhi_tiaojian_zj", "", "xt_shezhi_tiaojian_mc", "${path_home}/xt/xtshezhitiaojian/select/json.jw", false, function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.xt_shezhi_tiaojian_zj = treeNode.xt_shezhi_tiaojian_zj;
                            $('#dg').datagrid('reload');
                        }, true)
            });
        </script>
    </head>
    <body class="easyui-layout">

        <div data-options="region:'west',split:true,title:'模块列表'" style="width:250px;">
            <div id="divID_Tree_menu" class="ztree">menu</div>
        </div>

        <div data-options="region:'center',title:'列表中心'" id='centerMain'>
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   pagination:true,
                   pageSize:50,
                   pageList:[30,50,100,300,400,500],
                   rownumbers:true,
                   singleSelect:true,
                   showFooter:true,
                   toolbar:'#tb',
                   url:'${path_home}/xt/xttiaojian/select/grid.jw',
                   method:'post',queryParams: {xt_shezhi_tiaojian_zj:''},
                   onRowContextMenu:f_gridMenu
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'xt_tiaojian_zj'">主键</th>
                        <th data-options="field:'xt_shezhi_tiaojian_zj'">模块主键</th>
                        <th data-options="field:'xt_tiaojian_zhidanren_zj'">方案制定人主键</th>

                        <th data-options="field:'xt_shezhi_tiaojian_mc',width:150"><div>模块名称</div></th>
                        <th data-options="field:'xt_shezhi_tiaojian_zhi',width:90"><div>使用值</div></th>                    
                        <th data-options="field:'xt_tiaojian_mc',width:290"><div>条件方案名称</div></th>
                        <th data-options="field:'xt_tiaojian_zhidanren',width:120"><div>制定人名称</div></th>
                        <th data-options="field:'xt_tiaojian_gelibiaoshi',width:290"><div>单据隔离标识</div></th>
                        <th data-options="field:'xt_tiaojian_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)"iconCls="icon-remove" class="easyui-linkbutton" plain="true" onclick="dellRow()">删除一行</a>
                    <a href="javascript:void(0)" iconCls="icon-reload" class="easyui-linkbutton" plain="true" onclick="easyuiGridReload('dg')">刷新</a>
                    <a href="javascript:void(0)" iconCls="icon-edit" class="easyui-linkbutton" plain="true" onclick="updateRow()">修改</a>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="seeRow()">明细</a>
                </div>
                <div>
                    <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)});
                            pageCN('dg', 100)">
                        <option value="0">单行选择</option>
                        <option value="1">多行选择</option>
                    </select>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="update10()">反审核</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="update40()">反作废</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="update04()">作废</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="update01()">审核</a>
                </div>
            </div>
            <div id="showUpdatePage" class="easyui-window" style="overflow: hidden" fit="true"
                 data-options="closable:false,closed:true,modal:true,maximized:true">
            </div>
            <div id="showSeeOnePage" class="easyui-window" style="overflow: hidden" fit="true"
                 data-options="closable:false,closed:true,modal:true,maximized:true">
            </div>
            <div id="showConditionDiv" class="easyui-window" style="overflow: hidden" fit="true" 
                 data-options="closable:false,closed:true,modal:true,maximized:true">
            </div>
            <div id="gridShowIMG"></div>
            <div id="menu" class="easyui-menu" style="width:150px;">
                <div onclick="seeRow()">明细</div>
                <div onclick="updateRow()">修改</div>
                <div class="menu-sep"></div>
                <div onclick="easyuiGridReload('dg')">刷新</div>
                <div class="menu-sep"></div>
                <div onclick="update01()">审核</div>
                <div onclick="update10()">反审核</div>
            </div>
        </div>
    </body>
</html>
