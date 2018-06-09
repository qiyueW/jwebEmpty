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
        <script type="text/javascript" src="${path_home}/static/js/danju/add.js"></script>//测试时，调整防缓存：?id=<%=new Date()%>
        <script>
            $(function () {
                f_extend_select();
                for (var i = 0; i < 50; i++) {
                    $('#dg').datagrid('insertRow', {//tiaojian_panduanfuhao:'IN'
                        index: 1,
                        row: {}
                    })
                }
                $('#dg').datagrid('hideColumn', 'danjuziduan_zj');
                $('#dg').datagrid('hideColumn', 'danju_zj');
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
                   toolbar:'#tb',
                   onClickCell: onClickCell
                   ">
                <thead>
                    <tr>                
                        <th data-options="field:'danjuziduan_zj'">主键</th>
                        <th data-options="field:'danju_zj'">表头id</th>
                        <th data-options="field:'danjuziduan_mc',width:90,editor:'text'"><div>字段名称</div></th>
                        <th data-options="field:'danjuziduan_daima',width:90,editor:'text'"><div>字段代码</div></th>
                        <th data-options="field:'danjuziduan_leixing',width:90,editor:'text'"><div>字段类型</div></th>
                        <th data-options="field:'danjuziduan_xiaoshudian',width:90,editor:'text'"><div>字段小数点</div></th>
                        <th data-options="field:'danjuziduan_changdu',width:90,editor:'text'"><div>字段长度</div></th>
                        <th data-options="field:'danjuziduan_jiaonian',width:90,editor:'text'"><div>是否必须校验</div></th>
                        <th data-options="field:'danjuziduan_jiaoniankuizhi',width:90,editor:'text'"><div>检验规则</div></th>
                        <th data-options="field:'danjuziduan_bz',width:90,editor:'text'"><div>备注</div></th>
                        <th data-options="field:'danjuziduan_px',width:90,editor:'text'"><div>排序</div></th>
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
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true"onclick="clearForm()">清空</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" plain="true"onclick="submitForm('DanjuFormID')">保存新增的查询方案</a>
                </div>
                <div>
                    <div class="container"  id="DanjuFormID">
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >模块名</span>
                                <input type="text"  id="danju_mc" name="danju_mc" data-options="required:true" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >模块代码</span>
                                <input type="text"  id="danju_daima" name="danju_daima" data-options="required:true" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单据前缀</span>
                                <input type="text"  id="danju_qianzhui" name="danju_qianzhui" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单据时间</span>
                                <input type="text"  id="danju_shijian" name="danju_shijian" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单据流水号</span>
                                <input type="text"  id="danju_liushuihao" name="danju_liushuihao" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >备注</span>
                                <input type="text"  id="danju_bz" name="danju_bz" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >修改时间</span>
                                <input class="easyui-datebox" type="text"  id="danju_xiugaishijian" name="danju_xiugaishijian" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >排序</span>
                                <input type="text"  id="danju_px" name="danju_px" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

