<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>楼房-添加</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/loufang/add.js"></script>
        <script>
            $(function () {
                f_extend_select();
                for (var i = 0; i < 50; i++) {
                    $('#dg').datagrid('insertRow', {//tiaojian_panduanfuhao:'IN'
                        index: 1,
                        row: {}
                    })
                }
                $('#dg').datagrid('hideColumn', 'loufang_zj');
                $('#dg').datagrid('hideColumn', 'loufang2_gelibiaoshi');
                $('#dg').datagrid('hideColumn', 'loufang2_zj');
                $('#dg').datagrid('hideColumn', 'loufang2_ruzhuren_zj');
                toCreateTree("divID_Tree_menu_LoufangFL", "loufangfl_zj", "loufangfl_fzj", "loufangfl_mc", "/base/loufangfl/select/json.jw", false, function (event, id, treeNode) {
                    $("#loufangfl_zj").val(treeNode.loufangfl_zj)
                     $("#loufangfl_mc").textbox('setValue',treeNode.loufangfl_mc);
                }, true);
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

        <div data-options="region:'west',split:true,title:'选下面分类进行选择'" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_LoufangFL" class="ztree">bean</div>
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
                        <th data-options="field:'loufang_zj'">父键</th>
                        <th data-options="field:'loufang2_gelibiaoshi'">隔离标识</th>
                        <th data-options="field:'loufang2_zj'">主键</th>
                        <th data-options="field:'loufang2_bianhao',width:90,editor:'text'"><div>编号</div></th>
                <th data-options="field:'loufang2_mingcheng',width:90,editor:'text'"><div>名称</div></th>
                <th data-options="field:'loufang2_chuangwei',width:90,editor:'text'"><div>床位</div></th>
                <th data-options="field:'loufang2_ruzhurenshu',width:90,editor:'text'"><div>入住人数</div></th>
                <th data-options="field:'loufang2_ruzhuren_zj'">入住人主键集合</th>
                <th data-options="field:'loufang2_lx',width:90,editor:'text'"><div>房间类型</div></th>
                <th data-options="field:'loufang2_bz',width:90,editor:'text'"><div>备注</div></th>
                </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dellRow()">移除行</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addRow()">添加行</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="clearValue()">清空值</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true"onclick="clearForm()">清空</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" plain="true"onclick="submitForm('LoufangFormID')">保存</a>
                </div>
                <div id="LoufangFormID">
                    <table>
                        <tr>
                            <td>名称</td><td><input type="text" style="width:300px;" id="loufang_mc" name="loufang_mc" data-options="required:true" class="easyui-textbox"/></td>
                            <td>分类</td><td><input type="hidden" id="loufangfl_zj"/><input type="text" style="width:168px;"id="loufangfl_mc" readonly="true" data-options="required:true" class="easyui-textbox"/></td>
                        </tr>
                        <tr>
                            <td>地址</td><td colspan="3"><input type="text" style="width:500px;" id="loufang_dizhi" name="loufang_dizhi" data-options="required:false" class="easyui-textbox"/></td>
                        </tr>
                        <tr>
                            <td>备注</td><td colspan="3"><input type="text" style="width:500px;" id="loufang_bz" name="loufang_bz" data-options="required:false" class="easyui-textbox"/></td>
                        </tr>
                    </table>
<!--                    <div class="container"  id="LoufangFormID">
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单人房总数</span>
                                <input type="text"  id="loufang_tj_danrenfang" name="loufang_tj_danrenfang" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >套间房总数</span>
                                <input type="text"  id="loufang_tj_taojianfang" name="loufang_tj_taojianfang" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                    </div>-->
                </div>
            </div>
        </div>
    </body>
</html>

