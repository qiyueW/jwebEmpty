                                    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>系统管理员权限</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtguanliyuan/quanxian.js?id=<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                inidoAdd();
                $('#dg').datagrid('hideColumn', 'xt_guanliyuan_zj');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'east',split:true,title:''" style="width:450px;padding:10px;">
            <div id="divID_Tree_menu_XtQuanxian" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   pagination:true,
                   pageSize:50,
                   pageList:[30,50,100,300,400,500],
                   rownumbers:true,
                   singleSelect:true,
                   showFooter:true,
                   toolbar:'#tb',
                   url:'${path_home}/xt/xtguanliyuan1/select/grid.jw',
                   onRowContextMenu:f_gridMenu
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'xt_guanliyuan_zj'">管理员主键</th>
                        <th data-options="field:'xt_guanliyuan_mc',width:90"><div>管理员名称</div></th>
                        <th data-options="field:'xt_guanliyuan_zhanghao',width:90"><div>管理员账号</div></th>
                        <th data-options="field:'xt_guanliyuan_mima',width:90"><div>管理员密码</div></th>
                        <th data-options="field:'xt_guanliyuan_youxiang',width:90"><div>管理员邮箱</div></th>
                        <th data-options="field:'xt_guanliyuan_jibie',width:90,formatter:f_xtguanliyuan_jibie"><div>管理员级别</div></th>
                        <th data-options="field:'xt_guanliyuan_zt',width:60,formatter:f_common_style"><div>管理员状态</div></th>
                        <th data-options="field:'xt_guanliyuan_bz',width:90"><div>管理员备注</div></th>
                        <th data-options="field:'xt_guanliyuan_gelibiaoshi',width:90"><div>隔离标识</div></th>
                        <th data-options="field:'xt_guanliyuan_zhidanshijian',width:130"><div>制单时间</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="seeRowPower()">展示权限</a>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="f_condition()">过滤条件</a>
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
        </div>
    </body>
</html>
