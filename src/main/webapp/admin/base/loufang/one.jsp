<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加部门管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'loufang_zj');
                $('#dg').datagrid('hideColumn', 'loufang2_gelibiaoshi');
                $('#dg').datagrid('hideColumn', 'loufang2_zj');
                $('#dg').datagrid('hideColumn', 'loufang2_ruzhuren_zj');
            });
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
        </script>
    </head>
    <body class="easyui-layout">
                    <input type="hidden" id="loufang_zj" name="loufang_zj" value="${Loufang.loufang_zj}">
                    <input type="hidden" id="loufangfl_zj" name="loufangfl_zj" value="${Loufang.loufangfl_zj}">
                    <input type="hidden" id="loufang_gelibiaoshi" name="loufang_gelibiaoshi" value="${Loufang.loufang_gelibiaoshi}">
                    <input type="hidden" id="loufang_zt" name="loufang_zt" value="${Loufang.loufang_zt}">
        <!--div data-options="region:'center'" id='centerMain'-->
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   rownumbers:true,
                   singleSelect:true,
                   toolbar:'#tb',
                   url:'${path_home}/base/loufang/select/selectOne/bodyGrid.jw?pid=${Loufang.loufang_zj}'
                   ">
                <thead>
                    <tr>                
                    <th data-options="field:'loufang_zj'">父键</th>
                    <th data-options="field:'loufang2_gelibiaoshi'">隔离标识</th>
                    <th data-options="field:'loufang2_zj'">主键</th>
                       <th data-options="field:'loufang2_bianhao',width:90"><div>编号</div></th>
                       <th data-options="field:'loufang2_mingcheng',width:90"><div>名称</div></th>
                       <th data-options="field:'loufang2_chuangwei',width:90"><div>床位</div></th>
                       <th data-options="field:'loufang2_ruzhurenshu',width:90"><div>入住人数</div></th>
                    <th data-options="field:'loufang2_ruzhuren_zj'">入住人主键集合</th>
                       <th data-options="field:'loufang2_lx',width:90"><div>房间类型</div></th>
                       <th data-options="field:'loufang2_bz',width:90"><div>备注</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
                <div>
<div class="container"  id="LoufangFormID">
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  value="${Loufang.loufang_mc}"  readonly="true" id="loufang_mc" name="loufang_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >单人房总数</span>
                        <input type="text"  value="${Loufang.loufang_tj_danrenfang}"  readonly="true" id="loufang_tj_danrenfang" name="loufang_tj_danrenfang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >套间房总数</span>
                        <input type="text"  value="${Loufang.loufang_tj_taojianfang}"  readonly="true" id="loufang_tj_taojianfang" name="loufang_tj_taojianfang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >地址</span>
                        <input type="text"  value="${Loufang.loufang_dizhi}"  readonly="true" id="loufang_dizhi" name="loufang_dizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  value="${Loufang.loufang_bz}"  readonly="true" id="loufang_bz" name="loufang_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
                </div>
            </div>
        <!--/div-->
    </body>
</html>

