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
        <script type="text/javascript" src="${path_home}/static/js/bm/condition.js?id=<%=new Date()%>"></script>
        <script>
            $(function () {
                f_extend_select();
                for (var i = 0; i < 50; i++)
                    $('#dg').datagrid('insertRow', {
                        index: 1,
                        row: {tiaojian_panduanfuhao:'IN'}
                    })
            });
            function f_panduan(value, row, index) {
                if (value instanceof Object) {
                    row.tiaojian_panduanfuhao = value.tiaojian_panduan;
                    row.tiaojian_panduanName = value.tiaojian_panduanName;
                }
                return row.tiaojian_panduanName?row.tiaojian_panduanName:value;
            }
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_BM" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   rownumbers:true,
                   singleSelect:true,
                   iconCls: 'icon-edit',
                   singleSelect: true,
                   url:'${path_home}/cc/yushizhi/adu/a/add/select2OneByJson.jw',
                   method:'post',
                   queryParams: {yushizhi_zj:''},
                   toolbar:'#tb',
                   onClickCell: onClickCell
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'tiaojian_kuohao',width:60,editor:'text'">括号区</th>
<!--                        <th data-options="field:'tiaojian_lianjie',width:90,editor:
                            {type:'combobox',options:{
                            url:'${path_home}/static/conditionLianjian.json'
                            ,editable:false
                            ,valueField:'tiaojian_lianjie'
                            ,textField:'tiaojian_lianjieName'}
                            }">连接区</th>-->
                        <th data-options="field:'tiaojian_mingcheng',width:200,editor:'text'">条件区-名称</th>
                        <th data-options="field:'tiaojian_panduanfuhao',width:100,formatter:f_panduan,editor:
                            {type:'select',options:{
                            
                            data:tiaojian_panduan,
                            ,editable:false
                            ,width:100
                            ,valueField:'tiaojian_panduan'
                            ,textField:'tiaojian_panduanName'
                            }
                            }">判断区</th>

                        <!--conditionLianjian_panduanfuhao-->
                        <th data-options="field:'tiaojian_zhi',width:300,editor:'text'">条件区-值</th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="clearForm()">关闭条件框</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dellRow()">移除行</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addRow()">添加行</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="clearValue()">清空值</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true"onclick="submitForm('')">修改现有的方案</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" plain="true"onclick="submitForm('submitFormID')">保存新增的查询方案</a>
                </div>
                <div>方案名：<input type="text" name="bean_mc" id="bean_mc" /></div>
            </div>
        </div>

        <script>

        </script>
    </body>
</html>

