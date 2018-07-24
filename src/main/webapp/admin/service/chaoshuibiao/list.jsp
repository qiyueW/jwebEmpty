
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护抄水表</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/chaoshuibiao/list.js"></script>        
        <script>
            $(function (){
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_loufang_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_loufang2_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_zhidanren');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_zhidanren_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_gelibiaoshi');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <table id="dg" class="easyui-datagrid" fit='true'
               data-options="
               pagination:true,
               pageSize:50,
               pageList:[30,50,100,300,400,500],
               rownumbers:true,
               singleSelect:true,
               showFooter:true,
               toolbar:'#tb',
               url:'${path_home}/service/chaoshuibiao/select/grid.jw',
               onRowContextMenu:f_gridMenu
               ">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                    <th data-options="field:'chaoshuibiao_zj'">主键</th>
                    <th data-options="field:'chaoshuibiao_loufang_zj'">楼主键</th>
                       <th data-options="field:'chaoshuibiao_loufang_mc',width:90"><div>楼名称</div></th>
                    <th data-options="field:'chaoshuibiao_loufang2_zj'">房主键</th>
                       <th data-options="field:'chaoshuibiao_loufang2_bianma',width:90"><div>房编号</div></th>
                       <th data-options="field:'chaoshuibiao_dushu1',width:90"><div>上次读数</div></th>
                    <th data-options="field:'chaoshuibiao_riqi1',width:130"><div>上次抄表日期</div></th>
                       <th data-options="field:'chaoshuibiao_dushu2',width:90"><div>读数</div></th>
                    <th data-options="field:'chaoshuibiao_riqi2',width:130"><div>抄表日期</div></th>
                       <th data-options="field:'chaoshuibiao_shui',width:90"><div>水(吨)</div></th>
                       <th data-options="field:'chaoshuibiao_shui_danjia',width:90"><div>水单价</div></th>
                       <th data-options="field:'chaoshuibiao_shui_jine',width:90"><div>金额</div></th>
                    <th data-options="field:'chaoshuibiao_zhidanshijian',width:130"><div>制单时间</div></th>
                    <th data-options="field:'chaoshuibiao_zhidanren'">制单人</th>
                    <th data-options="field:'chaoshuibiao_zhidanren_zj'">制单人主键</th>
                       <th data-options="field:'chaoshuibiao_fentanrenshu',width:90"><div>分摊人数</div></th>
                       <th data-options="field:'chaoshuibiao_yj_fentanrenshu',width:90"><div>已分摊人数</div></th>
                    <th data-options="field:'chaoshuibiao_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    <th data-options="field:'chaoshuibiao_gelibiaoshi'">隔离标识</th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <div>
                <a href="javascript:void(0)"iconCls="icon-remove" class="easyui-linkbutton" plain="true" onclick="dellRow()">删除一行</a>
                <a href="javascript:void(0)" iconCls="icon-reload" class="easyui-linkbutton" plain="true" onclick="easyuiGridReload('dg')">刷新</a>
                <a href="javascript:void(0)" iconCls="icon-edit" class="easyui-linkbutton" plain="true" onclick="updateRow()">修改</a>
                <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="seeRow()">明细</a>
                <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="f_condition()">过滤条件</a>
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
        <div id="showConditionPage" class="easyui-window" style="overflow: hidden" fit="true" 
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
    </body>
</html>
