<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加部门管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/xt/js/xtshezhitiaojian/edit.js"></script>
        <script>
            $(function () {
                //f_extend_select();
                $('#dg').datagrid('hideColumn', 'xt_shezhi_tiaojian1_zj');
                $('#dg').datagrid('hideColumn', 'xt_shezhi_tiaojian_zj');
            });
//            function f_panduan(value, row, index) {
//                if (value instanceof Object) {
//                    row.tiaojian_panduanfuhao = value.tiaojian_panduan;
//                    row.tiaojian_panduanName = value.tiaojian_panduanName;
//                }
//                return row.tiaojian_panduanName?row.tiaojian_panduanName:value;
//            }
        </script>
    </head>
    <body class="easyui-layout">
        <input type="hidden" id="xt_shezhi_tiaojian_zj" name="xt_shezhi_tiaojian_zj" value="${XTShezhiTiaojian.xt_shezhi_tiaojian_zj}">
        <input type="hidden" id="xt_shezhi_tiaojian_zt" name="xt_shezhi_tiaojian_zt" value="${XTShezhiTiaojian.xt_shezhi_tiaojian_zt}">
        <!-- 如果需要左侧导航。
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_BM" class="ztree">bean</div>
        </div>
        -->
        <!--<div data-options="region:'center'" id='centerMain'>-->
        <table id="dg" class="easyui-datagrid" fit='true'
               data-options="
               rownumbers:true,
               singleSelect:true,
               toolbar:'#tb',
               url:'${path_home}/xt/xtshezhitiaojian/select/selectOne/bodyGrid.jw?pid=${XTShezhiTiaojian.xt_shezhi_tiaojian_zj}',
               onClickCell: onClickCell
               ">
            <thead>
                <tr>                
                    <th data-options="field:'xt_shezhi_tiaojian1_zj'">主键</th>
                    <th data-options="field:'xt_shezhi_tiaojian_zj'">表头主键</th>
                    <th data-options="field:'xt_shezhi_tiaojian1_mc',width:290,editor:'text'"><div>条件名</div></th>
                    <th data-options="field:'xt_shezhi_tiaojian1_zhi',width:290,editor:'text'"><div>条件值</div></th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <div>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dellRow()">移除行</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addRow()">添加行</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" onclick="submitForm('XTShezhiTiaojianFormID')">保存修改</a>
            </div>
            <div id="XTShezhiTiaojianFormID">
                <table>
                    <tr>
                        <td>展示名称</td><td><input type="text"readonly="true" value="${XTShezhiTiaojian.xt_shezhi_tiaojian_mc}"  id="xt_shezhi_tiaojian_mc" name="xt_shezhi_tiaojian_mc" data-options="required:true" class="easyui-textbox"/></td>
                        <td>使用值</td><td><input type="text" readonly="true"value="${XTShezhiTiaojian.xt_shezhi_tiaojian_zhi}"  id="xt_shezhi_tiaojian_zhi" name="xt_shezhi_tiaojian_zhi" data-options="required:true" class="easyui-textbox"/></td>
                        <td>备注</td><td><input type="text" value="${XTShezhiTiaojian.xt_shezhi_tiaojian_bz}"  id="xt_shezhi_tiaojian_bz" name="xt_shezhi_tiaojian_bz" data-options="required:false" class="easyui-textbox"/></td>
                    </tr>
                </table>
            </div>                
        </div>
        <!--</div>-->
    </body>
</html>

