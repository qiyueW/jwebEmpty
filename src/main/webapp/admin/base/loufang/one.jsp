<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加部门管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
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
                       <th data-options="field:'loufang2_mingcheng',width:130"><div>名称</div></th>
                       <th data-options="field:'loufang2_chuangwei',width:90"><div>床位</div></th>
                       <th data-options="field:'loufang2_ruzhurenshu',width:90"><div>入住人数</div></th>
                    <th data-options="field:'loufang2_ruzhuren_zj'">入住人主键集合</th>
                       <th data-options="field:'loufang2_lx',width:90"><div>房间类型</div></th>
                       <th data-options="field:'loufang2_bz',width:250"><div>备注</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
                <div id="LoufangFormID">
                    <table>
                        <tr>
                            <td>名称</td><td colspan="3"><input type="text" readonly="true" style="width:500px;"value="${Loufang.loufang_mc}"  id="loufang_mc" name="loufang_mc" data-options="required:true" class="easyui-textbox"/></td>
                            <!--<td>分类</td><td><input type="hidden" id="loufangfl_zj" value="${Loufang.loufangfl_zj}"/><input type="text" style="width:168px;"id="loufangfl_mc" readonly="true" data-options="required:true" class="easyui-textbox"/></td>-->
                        </tr>
                        <tr>
                            <td>单间床位</td>
                            <td  colspan="3">
                                <input type="text"  value="${Loufang.loufang_danjian_chuangwei}"  readonly="true" id="loufang_danjian_chuangwei" name="loufang_danjian_chuangwei" data-options="required:false" class="easyui-textbox"/>
                            已用单间床位<input type="text"  value="${Loufang.loufang_danjian_chuangwei2}"  readonly="true" id="loufang_danjian_chuangwei2" name="loufang_danjian_chuangwei2" data-options="required:false" class="easyui-textbox"/>
                            </td>
                        </tr>
                        <tr>
                            <td>套间床位</td>
                            <td colspan="3">
                                <input type="text"  value="${Loufang.loufang_taojian_chuangwei}"  readonly="true" id="loufang_taojian_chuangwei" name="loufang_taojian_chuangwei" data-options="required:false" class="easyui-textbox"/>
                                已用套间床位<input type="text"  value="${Loufang.loufang_taojian_chuangwei2}"  readonly="true" id="loufang_taojian_chuangwei2" name="loufang_taojian_chuangwei2" data-options="required:false" class="easyui-textbox"/>
                            </td>
                        </tr>
                        <tr>
                            <td>地址</td><td colspan="3"><input type="text" readonly="true" style="width:500px;" value="${Loufang.loufang_dizhi}" id="loufang_dizhi" name="loufang_dizhi" data-options="required:false" class="easyui-textbox"/></td>
                        </tr>
                        <tr>
                            <td>备注</td><td colspan="3"><input type="text" readonly="true" style="width:500px;" value="${Loufang.loufang_bz}"  id="loufang_bz" name="loufang_bz" data-options="required:false" class="easyui-textbox"/></td>
                        </tr>
                    </table>
                </div>
            </div>
        <!--/div-->
    </body>
</html>

