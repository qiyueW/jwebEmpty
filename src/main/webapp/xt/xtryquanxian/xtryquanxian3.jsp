                                    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>用户角色、权限的绑定</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtryquanxian/xtryquanxian3.js?id=<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                inidoAdd();
                $('#dg').treegrid('hideColumn', 'ry_zj');
                $('#dg').treegrid('hideColumn', 'ry_bm_zj');
                $('#dg').treegrid('hideColumn', 'ry_gangwei_zj');
                $('#dg').treegrid('hideColumn', 'ry_zhiwei_zj');
                $('#dg').treegrid('hideColumn', 'xt_ryquanxian_zj');
                $("#powerMenuTableID").height($(window).height() - 40);
                $(window).resize(function () {
                    $("#powerMenuTableID").height($(window).height() - 40);
                });
            });
//            $(window).width();
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'east',split:true,title:'进行绑定的角色与权限集合'" style="width:620px;padding:1px;">
            <table id="powerMenuTableID" style="height: 500px;">
                <tr  style="height: 30px; text-align:center">
                    <th style="background-color:#d0e0f1">
                        绑定角色
                    </th>
                    <th style="background-color: #FEE">
                        直接绑定权限
                    </th>
                </tr>
                <tr>
                    <td style="width: 300px">
                        <div style="height:100%;overflow-y: scroll"  fit="true">
                            <div id="divID_Tree_menu_XtJuese" class="ztree" ></div>
                        </div>
                    </td>
                    <td style="width: 300px">
                        <div style="height:100%;overflow-y: scroll"  fit="true">
                            <div id="divID_Tree_menu_XtQuanxian" class="ztree"></div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   rownumbers:true,
                   singleSelect:true,
                   showFooter:true,
                   toolbar:'#tb',
                   url:'${path_home}/xt/xtryquanxian3/select/grid.jw',
                   onRowContextMenu:f_gridMenu
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'ry_zj'">主键</th>
                        <th data-options="field:'xt_ryquanxian_zj'">权限表的主键</th>
                        <th data-options="field:'xt_guanliyuan_mc',width:90"><div>附权的管理员</div></th>
                        <th data-options="field:'ry_bm',width:140"><div>部门</div></th>
                        <th data-options="field:'ry_bm_zj'">部门主键</th>
                        <th data-options="field:'ry_mc',width:90"><div>人员名称</div></th>
                        <th data-options="field:'ry_zhanghao',width:90"><div>账号</div></th>
                        <th data-options="field:'ry_xingbie',width:40"><div>性别</div></th>
                        <th data-options="field:'ry_zt',width:40,formatter:f_common_style"><div>状态</div></th>
                        <th data-options="field:'ry_ruzhiriqi',width:80"><div>入职日期</div></th>
                        <th data-options="field:'ry_lizhiriqi',width:80"><div>离职日期</div></th>
                        <th data-options="field:'ry_gangwei_zj'">岗位主键</th>
                        <th data-options="field:'ry_gangwei',width:120"><div>岗位</div></th>
                        <th data-options="field:'ry_zhiwei_zj'">职位主键</th>
                        <th data-options="field:'ry_zhiwei',width:120"><div>职位</div></th>
                        <th data-options="field:'ry_bz',width:90"><div>备注</div></th>
                        <!--<th data-options="field:'xt_guanliyuan_zhidanshijian',width:130"><div>制单时间</div></th>-->
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="f_condition()">过滤条件</a>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="setPower()">设置权限</a>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="seeRowPower()">展示权限</a>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="removeRowPower()">移除权限</a>
                </div>
                <!--                <div>
                                    <select onchange="$('#dg').treegrid({singleSelect: (this.value == 0)});
                                            pageCN('dg', 100)">
                                        <option value="0">单行选择</option>
                                        <option value="1">多行选择</option>
                                    </select>
                                </div>-->
            </div>
        </div>


        <div id="showConditionPage" class="easyui-window" style="overflow: hidden" fit="true" 
             data-options="closable:false,closed:true,modal:true,maximized:true">
        </div> 
        <div id="gridShowIMG"></div>
        <div id="menu" class="easyui-menu" style="width:150px;">
            <div onclick="seeRowPower()">展示权限</div>
            <div onclick="setPower()">设置权限</div>
            <div onclick="removeRowPower()">移除权限</div>
            
        </div>
    </body>
</html>
