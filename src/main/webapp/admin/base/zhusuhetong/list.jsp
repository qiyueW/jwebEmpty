
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护住宿合同</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/zhusuhetong/list.js"></script>
        <script>
            $(function (){
                $('#dg').treegrid('hideColumn', 'zhusuhetong_zj');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_gelibiaoshi');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_loufang_zj');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_loufang2_zj');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_qianyueren_zj');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_zhidanren');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_zhidanren_zj');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_xiugaishijian');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_xiugairen');
                $('#dg').treegrid('hideColumn', 'zhusuhetong_xiugairen_zj');
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
               url:'${path_home}/base/zhusuhetong/select/grid.jw',
               onRowContextMenu:f_gridMenu
               ">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>                    <th data-options="field:'zhusuhetong_zj'">主键</th>
                    <th data-options="field:'zhusuhetong_gelibiaoshi'">隔离标识</th>
                    <th data-options="field:'zhusuhetong_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    <th data-options="field:'zhusuhetong_loufang_zj'">楼主键</th>
                       <th data-options="field:'zhusuhetong_loufang_mc',width:90"><div>楼名称</div></th>
                    <th data-options="field:'zhusuhetong_loufang2_zj'">房主键</th>
                       <th data-options="field:'zhusuhetong_loufang2_bianhao',width:90"><div>房编号</div></th>
                       <th data-options="field:'zhusuhetong_qianyueren',width:90"><div>签约人</div></th>
                    <th data-options="field:'zhusuhetong_qianyueren_zj'">签约人主键</th>
                       <th data-options="field:'zhusuhetong_yajin',width:90"><div>押金</div></th>
                       <th data-options="field:'zhusuhetong_zujin',width:90"><div>租金</div></th>
                    <th data-options="field:'zhusuhetong_kaishiriqi',width:130"><div>开始日期</div></th>
                    <th data-options="field:'zhusuhetong_jieshuriqi',width:130"><div>结束日期</div></th>
                       <th data-options="field:'zhusuhetong_jffs',width:90,formatter:f_common_loufang_jsfs"><div>计费方式</div></th>
                       <th data-options="field:'zhusuhetong_jffs_zdrq',width:90"><div>计费方式-指定日期</div></th>
                    <th data-options="field:'zhusuhetong_zuixiaozhusuriqi',width:130"><div>最小住宿日期</div></th>
                    <th data-options="field:'zhusuhetong_zhidanshijian',width:130"><div>制单时间</div></th>
                    <th data-options="field:'zhusuhetong_zhidanren'">制单人</th>
                    <th data-options="field:'zhusuhetong_zhidanren_zj'">制单人主键</th>
                    <th data-options="field:'zhusuhetong_xiugaishijian'">修改时间</th>
                    <th data-options="field:'zhusuhetong_xiugairen'">修改人</th>
                    <th data-options="field:'zhusuhetong_xiugairen_zj'">修改人主键</th>
                       <th data-options="field:'zhusuhetong_bz',width:90"><div>备注</div></th>
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
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)});">
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
