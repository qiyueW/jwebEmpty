
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>维护人员管理</title>
        <script type="text/javascript" src="${path_home}/static/js/ry/list.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                $('#dg').treegrid('hideColumn', 'ry_zj');
                $('#dg').treegrid('hideColumn', 'ry_bm_zj');
                $('#dg').treegrid('hideColumn', 'ry_gangwei_zj');
                $('#dg').treegrid('hideColumn', 'ry_zhiwei_zj');
                $('#dg').treegrid('hideColumn', 'ry_zhidanren_zj');
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
               url:'${path_home}/base/ry/select/grid.jw',
               onRowContextMenu:f_gridMenu
               ">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                    <th data-options="field:'ry_zj'">主键</th>
                    <th data-options="field:'ry_bm',width:140"><div>部门</div></th>
                    <th data-options="field:'ry_bm_zj'">部门主键</th>
                    <th data-options="field:'ry_mc',width:90"><div>人员名称</div></th>
                    <th data-options="field:'ry_zhanghao',width:90"><div>账号</div></th>
                    <!--<th data-options="field:'ry_mima',width:90"><div>密码</div></th>-->
                    <th data-options="field:'ry_xingbie',width:90"><div>性别</div></th>
                    <th data-options="field:'ry_ruzhiriqi',width:80"><div>入职日期</div></th>
                    <th data-options="field:'ry_lizhiriqi',width:80"><div>离职日期</div></th>
                    <th data-options="field:'ry_gangwei_zj'">岗位主键</th>
                    <th data-options="field:'ry_gangwei',width:120"><div>岗位</div></th>
                    <th data-options="field:'ry_zhiwei_zj'">职位主键</th>
                    <th data-options="field:'ry_zhiwei',width:120"><div>职位</div></th>
                    <th data-options="field:'ry_zt',width:60,formatter:f_common_style"><div>状态</div></th>
                    <th data-options="field:'ry_bz',width:90"><div>备注</div></th>
                    <th data-options="field:'ry_chushengriqi',width:80"><div>出生日期</div></th>
                    <th data-options="field:'ry_jiguan',width:90"><div>籍贯</div></th>
                    <th data-options="field:'ry_shouji1',width:90"><div>手机1</div></th>
                    <th data-options="field:'ry_youxiang',width:90"><div>邮箱</div></th>
                    <th data-options="field:'ry_hunyin',width:90"><div>婚姻状态</div></th>
                    <th data-options="field:'ry_tupian',width:60,formatter:f_grid_img"><div>图片</div></th>
<!--                    <th data-options="field:'ry_shenfenzheng',width:90"><div>身份证号码</div></th>
                    <th data-options="field:'ry_tupian_zhengjian1',width:60,formatter:f_grid_file"><div>证件图_正面</div></th>
                    <th data-options="field:'ry_tupian_zhengjian2',width:60,formatter:f_grid_file"><div>证件图_反面</div></th>-->
                    <th data-options="field:'ry_xianzhudizhi',width:90"><div>现住地址</div></th>
                    <th data-options="field:'ry_jiatingdizhi',width:90"><div>家庭地址</div></th>
                    <th data-options="field:'ry_jinjilianxiren',width:90"><div>紧急联系人</div></th>
                    <th data-options="field:'ry_jinjilianxiren_dianhua',width:90"><div>紧急联系人电话</div></th>
                    <th data-options="field:'ry_gudingdianhua1',width:90"><div>固定电话1</div></th>
                    <th data-options="field:'ry_gudingdianhua2',width:90"><div>固定电话2</div></th>
                    <th data-options="field:'ry_qitatongxing',width:90"><div>其他通信</div></th>
                    <th data-options="field:'ry_qitatongxing1',width:90"><div>其他通信1</div></th>
                    <th data-options="field:'ry_qitatongxing2',width:90"><div>其他通信2</div></th>
                    <th data-options="field:'ry_qitatongxing3',width:90"><div>其他通信3</div></th>
                    <th data-options="field:'ry_qitatongxing4',width:90"><div>其他通信4</div></th>
                    <th data-options="field:'ry_qitatongxing5',width:90"><div>其他通信5</div></th>
                    <th data-options="field:'ry_neibutongxing1',width:90"><div>内部通信1</div></th>
                    <th data-options="field:'ry_neibutongxing2',width:90"><div>内部通信2</div></th>
                    <th data-options="field:'ry_neibutongxing3',width:90"><div>内部通信3</div></th>
                    <th data-options="field:'ry_neibutongxing4',width:90"><div>内部通信4</div></th>
                    <th data-options="field:'ry_neibutongxing5',width:90"><div>内部通信5</div></th>
                    <th data-options="field:'ry_neibutongxing6',width:90"><div>内部通信6</div></th>
                    <th data-options="field:'ry_neibutongxing7',width:90"><div>内部通信7</div></th>
                    <th data-options="field:'ry_neibutongxing8',width:90"><div>内部通信8</div></th>
                    <th data-options="field:'ry_neibutongxing9',width:90"><div>内部通信9</div></th>
                    <th data-options="field:'ry_neibutongxing10',width:90"><div>内部通信10</div></th>
                    <th data-options="field:'ry_zhidanren_zj'">制单人主键</th>
                    <th data-options="field:'ry_zhidanren',width:90"><div>制单人</div></th>
                    <th data-options="field:'ry_gelibiaoshi',width:90"><div>隔离标识</div></th>
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
            <div onclick="easyuiTreeGridReload('dg')">刷新</div>
            <div class="menu-sep"></div>
            <div onclick="update01()">审核</div>
            <div onclick="update10()">反审核</div>
        </div>
    </body>
</html>
