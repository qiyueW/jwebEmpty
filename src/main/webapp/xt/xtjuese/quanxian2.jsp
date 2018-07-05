                                    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>绑定辅管员-角色权限</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtjuese/quanxian2.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                inidoAdd();
                $('#dg').treegrid('hideColumn', 'xt_juese_zj');
                $('#dg').treegrid('hideColumn', 'xt_juese_fzj');
                $('#dg').treegrid('hideColumn', 'xt_juese_zhidanren_zj');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'east',split:true,title:'角色可代表的权限'" style="width:450px;padding:10px;">
            <div id="divID_Tree_menu_XtQuanxian" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <table id="dg" class="easyui-treegrid" fit='true'
                   data-options="
                   idField:'xt_juese_zj',
                   treeField:'xt_juese_mc',
                   rownumbers:true,
                   singleSelect:true,
                   showFooter:true,
                   toolbar:'#tb',
                   url:'${path_home}/xt/xtjuese2/select/grid.jw',
                   onContextMenu:f_gridMenu
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'xt_juese_zj'">主键</th>
                        <th data-options="field:'xt_juese_fzj'">父键</th>
                        <th data-options="field:'xt_juese_mc',width:360"><div>名称</div></th>
                        <!--<th data-options="field:'xt_juese_dm',width:90"><div>代码</div></th>-->
                        <!--<th data-options="field:'xt_juese_gongsi',width:90"><div>公私角色</div></th>-->
                        <th data-options="field:'xt_juese_bz',width:90"><div>备注</div></th>
                        <th data-options="field:'xt_juese_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                        <!--<th data-options="field:'xt_juese_gelibiaoshi',width:90"><div>隔离标识</div></th>-->
                        <th data-options="field:'xt_juese_zhidanren_zj'">制单人主键</th>
                        <th data-options="field:'xt_juese_zhidanren',width:90"><div>制单人</div></th>
                        <th data-options="field:'xt_juese_zhidanshijian',width:130"><div>制单时间</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="seeRowPower()">展示权限</a>
                    <a href="javascript:void(0)" iconCls="icon-tip" class="easyui-linkbutton" plain="true" onclick="f_condition()">过滤条件</a>
                </div>
                <div>
                    <select onchange="$('#dg').treegrid({singleSelect: (this.value == 0)});
                            pageCN('dg', 100)">
                        <option value="0">单行选择</option>
                        <option value="1">多行选择</option>
                    </select>
                </div>
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
