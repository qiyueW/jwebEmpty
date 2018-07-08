                                    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护系统权限</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/xt/js/xtquanxian/list.js"></script>
        <script>
            $(function () {
                $('#dg').treegrid('hideColumn', 'xt_quanxian_zj');
                $('#dg').treegrid('hideColumn', 'xt_quanxian_fzj');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <table id="dg" class="easyui-treegrid" fit='true'
               data-options="
               treeField:'xt_quanxian_mc',
               idField:'xt_quanxian_zj',
               rownumbers:true,
               singleSelect:true,
               showFooter:true,
               toolbar:'#tb',
               url:'${path_home}/xt/xtquanxian/select/grid.jw',
               onContextMenu:f_gridMenu">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>                    <th data-options="field:'xt_quanxian_zj'">主键</th>
                    <th data-options="field:'xt_quanxian_fzj'">父键</th>
                    <th data-options="field:'xt_quanxian_px',width:90"><div>排序</div></th>
                    <th data-options="field:'xt_quanxian_mc',width:360"><div>名称</div></th>
                    <th data-options="field:'xt_quanxian_dm',width:160"><div>权限代码</div></th>
                    <th data-options="field:'xt_quanxian_url',width:190"><div>url</div></th>
                    <th data-options="field:'xt_quanxian_keshi',width:40"><div>可视</div></th>
                    <th data-options="field:'xt_quanxian_zhankai',width:40"><div>展开</div></th>
                    <th data-options="field:'xt_quanxian_bz',width:130"><div>备注</div></th>
                    <th data-options="field:'xt_quanxian_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    <!--<th data-options="field:'xt_quanxian_gelibiaoshi',width:90"><div>隔离标识</div></th>-->
                    <th data-options="field:'xt_quanxian_jibie',width:90"><div>级别</div></th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <div>
                <a href="javascript:void(0)"iconCls="icon-remove" class="easyui-linkbutton" plain="true" onclick="dellRow()">删除一行</a>
                <a href="javascript:void(0)" iconCls="icon-reload" class="easyui-linkbutton" plain="true" onclick="easyuiTreeGridReload('dg')">刷新</a>
                <a href="javascript:void(0)" iconCls="icon-edit" class="easyui-linkbutton" plain="true" onclick="updateRow()">修改</a>
                <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="seeRow()">明细</a>
                <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="f_condition()">过滤条件</a>
            </div>
            <div>
                <select onchange="$('#dg').treegrid({singleSelect: (this.value == 0)});
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
        <div id="showConditionPage" class="easyui-window" style="overflow: hidden" fit="true" 
             data-options="closable:false,closed:true,modal:true,maximized:true">
        </div> 
        <div id="gridShowIMG"></div>
        <div id="menu" class="easyui-menu" style="width:150px;">
            <div onclick="seeRow()">明细</div>
            <div onclick="updateRow()">修改</div>
            <div class="menu-sep"></div>
            <div onclick="easyuiTreeGridReload('dg')">刷新</div>
            <div class="menu-sep"></div>
            <div onclick="update01()">审核</div>
            <div onclick="update10()">反审核</div>
        </div>
    </body>
</html>
