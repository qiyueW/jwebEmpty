<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护电表</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/chaodianbiao/list.js"></script>        
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'chaodianbiao_zj');
                $('#dg').datagrid('hideColumn', 'chaodianbiao_loufang_zj');
                $('#dg').datagrid('hideColumn', 'chaodianbiao_loufang2_zj');
                $('#dg').datagrid('hideColumn', 'chaodianbiao_zhidanren');
                $('#dg').datagrid('hideColumn', 'chaodianbiao_zhidanren_zj');
                $('#dg').datagrid('hideColumn', 'chaodianbiao_gelibiaoshi');
            });
            function computeLoader() {//计算函数
                var rows = $('#dg').datagrid('getRows');//获取当前的数据行
                console.log(rows);
                var chaodianbiao_dian = 0;//电
                var chaodianbiao_dian_jine = 0;//金额
                var chaodianbiao_dushu1 = 0;
                var chaodianbiao_dushu2 = 0;
                for (var i = 0; i < rows.length; i++) {
                    chaodianbiao_dian += parseFloat(rows[i]['chaodianbiao_dian']);
                    chaodianbiao_dian_jine += parseFloat(rows[i]['chaodianbiao_dian_jine']);
                    chaodianbiao_dushu1 += parseFloat(rows[i]['chaodianbiao_dushu1']);
                    chaodianbiao_dushu2 += parseFloat(rows[i]['chaodianbiao_dushu2']);
                }
                $('#dg').datagrid('appendRow', {
                    chaodianbiao_loufang_mc: '<b>统计：</b>',
                    chaodianbiao_dian:chaodianbiao_dian,
                    chaodianbiao_dian_jine:chaodianbiao_dian_jine,
                    chaodianbiao_dushu1:chaodianbiao_dushu1,
                    chaodianbiao_dushu2:chaodianbiao_dushu2
                });
            }
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
               url:'${path_home}/service/chaodianbiao/select/grid.jw',
               onRowContextMenu:f_gridMenu,
               onLoadSuccess:computeLoader
               ">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                    <th data-options="field:'chaodianbiao_zj'">主键</th>
                    <th data-options="field:'chaodianbiao_loufang_zj'">楼主键</th>
                    <th data-options="field:'chaodianbiao_loufang_mc',width:90"><div>楼名称</div></th>
                    <th data-options="field:'chaodianbiao_loufang2_zj'">房主键</th>
                    <th data-options="field:'chaodianbiao_loufang2_bianma',width:90"><div>房编号</div></th>
                    <th data-options="field:'chaodianbiao_riqi2',width:80"><div>抄表日期</div></th>
                    <th data-options="field:'chaodianbiao_riqi1',width:80"><div>上次抄表日期</div></th>
                    <th data-options="field:'chaodianbiao_dushu2',width:90"><div>读数</div></th>
                    <th data-options="field:'chaodianbiao_dushu1',width:90"><div>上次读数</div></th>
                    <th data-options="field:'chaodianbiao_dian',width:60"><div>电(度)</div></th>
                    <th data-options="field:'chaodianbiao_dian_danjia',width:90"><div>电单价</div></th>
                    <th data-options="field:'chaodianbiao_dian_jine',width:90"><div>金额</div></th>
                    <th data-options="field:'chaodianbiao_fentanrenshu',width:60"><div>分摊人数</div></th>
                    <th data-options="field:'chaodianbiao_yj_fentanrenshu',width:60"><div>已纳费人数</div></th>
                    <th data-options="field:'chaodianbiao_zhidanshijian',width:130"><div>制单时间</div></th>
                    <th data-options="field:'chaodianbiao_zhidanren'">制单人</th>
                    <th data-options="field:'chaodianbiao_zhidanren_zj'">制单人主键</th>
                    <th data-options="field:'chaodianbiao_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    <th data-options="field:'chaodianbiao_gelibiaoshi'">隔离标识</th>
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
            <div onclick="easyuiGridReload('dg')">刷新</div>
            <div class="menu-sep"></div>
            <div onclick="update01()">审核</div>
            <div onclick="update10()">反审核</div>
        </div>
    </body>
</html>
