<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护部门管理</title>
        <script type="text/javascript" src="${path_home}/static/js/bm/list.js?<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'bm_zj');
                $('#dg').datagrid('hideColumn', 'bm_fzj');
                $('#dg').datagrid('hideColumn', 'bm_fuzhiren_zj');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <table id="dg" class="easyui-treegrid" fit='true'
               url="${path_home}/base/bm/select/grid.jw"
               rownumbers="true" showFooter="true" toolbar="#tb"idField="bm_zj" treeField="bm_mc" >
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th> 
                    <th data-options="field:'bm_zj'">主键</th>
                    <th data-options="field:'bm_fzj'">父键</th>
                    <th data-options="field:'bm_mc',width:360"><div>名称</div></th>
                    <th data-options="field:'bm_bianma',width:90"><div>编码</div></th>
                    <th data-options="field:'bm_jianjie',width:90"><div>部门简介</div></th>
                    <th data-options="field:'bm_tupian1',width:60,formatter:f_grid_img"><div>部门图片1</div></th>
                    <th data-options="field:'bm_tupian2',width:60,formatter:f_grid_img"><div>部门图片2</div></th>
                    <th data-options="field:'bm_chuangjianshijian',width:130"><div>部门创建时间</div></th>
                    <th data-options="field:'bm_fuzhiren_zj'">部门负责人主键</th>
                    <th data-options="field:'bm_fuzhiren',width:90"><div>部门负责人</div></th>
                    <th data-options="field:'bm_zt',width:60,formatter:f_common_style"><div>部门状态</div></th>
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
    </body>
</html>
