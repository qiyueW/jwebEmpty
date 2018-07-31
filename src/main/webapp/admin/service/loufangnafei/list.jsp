
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护楼房纳费</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/loufangnafei/list.js"></script>
        <script>
            $(function (){
                $('#dg').treegrid('hideColumn', 'loufangnafei_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_lou_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_fang_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_gelibiaoshi');
                $('#dg').treegrid('hideColumn', 'loufangnafei_ren_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_feiyong_shui_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_feiyong_dian_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_feiyong_xm_zj');
                $('#dg').treegrid('hideColumn', 'loufangnafei_feiyong_meiqi_zj');
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
               url:'${path_home}/service/loufangnafei/select/grid.jw',
               onRowContextMenu:f_gridMenu
               ">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>                    <th data-options="field:'loufangnafei_zj'">主键</th>
                    <th data-options="field:'loufangnafei_lou_zj'">楼主键</th>
                    <th data-options="field:'loufangnafei_fang_zj'">房主键</th>
                    <th data-options="field:'loufangnafei_gelibiaoshi'">隔离标识</th>
                       <th data-options="field:'loufangnafei_lou_mc',width:90"><div>楼名称</div></th>
                       <th data-options="field:'loufangnafei_fang_bianma',width:90"><div>房编码</div></th>
                       <th data-options="field:'loufangnafei_ren',width:90"><div>纳费人</div></th>
                    <th data-options="field:'loufangnafei_ren_zj'">纳费人主键</th>
                    <th data-options="field:'loufangnafei_yingnariqi',width:130"><div>应纳日期</div></th>
                    <th data-options="field:'loufangnafei_nafeiriqi',width:130"><div>纳费日期</div></th>
                       <th data-options="field:'loufangnafei_zongfeiyong',width:90"><div>总费用</div></th>
                       <th data-options="field:'loufangnafei_zongfeiyong2',width:90"><div>已纳费用</div></th>
                       <th data-options="field:'loufangnafei_fangzu',width:90"><div>房租</div></th>
                       <th data-options="field:'loufangnafei_feiyong_shui',width:90"><div>水费</div></th>
                    <th data-options="field:'loufangnafei_feiyong_shui_zj'">水费主键集合</th>
                       <th data-options="field:'loufangnafei_feiyong_dian',width:90"><div>电费</div></th>
                    <th data-options="field:'loufangnafei_feiyong_dian_zj'">电费主键集合</th>
                       <th data-options="field:'loufangnafei_feiyong_xm',width:90"><div>项目费</div></th>
                    <th data-options="field:'loufangnafei_feiyong_xm_zj'">项目费主键集合</th>
                       <th data-options="field:'loufangnafei_feiyong_meiqi',width:90"><div>煤气费</div></th>
                    <th data-options="field:'loufangnafei_feiyong_meiqi_zj'">煤气费主键集合</th>
                    <th data-options="field:'loufangnafei_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    <th data-options="field:'loufangnafei_chuzhangshijian',width:130"><div>出账时间</div></th>
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
