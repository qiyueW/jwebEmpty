<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>系统条件管理-添加</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/xt/js/xttiaojian/common.js?id=<%=new Date()%>"></script>
        <script type="text/javascript" src="${path_home}/xt/js/xttiaojian/ry_tiaojian.js?id=<%=new Date()%>"></script>
        <script>
            $(function () {
                f_extend_select();
                for (var i = 0; i < 50; i++) {
                    $('#dg').datagrid('insertRow', {//tiaojian_panduanfuhao:'IN'
                        index: 1,
                        row: {}
                    })
                }
                $('#dg').datagrid('hideColumn', 'xt_tiaojian1_zj');
                $('#dg').datagrid('hideColumn', 'xt_tiaojian_zj');
                $('#dg').datagrid('hideColumn', 'xt_tiaojian1_lianjiefu');
                $('#dg').datagrid('hideColumn', 'xt_shezhi_tiaojian1_zhi');
                $('#dg').datagrid('hideColumn', 'xt_tiaojian1_panduan');
                toCreateTree("divID_Tree_menu"
                        , "xt_tiaojian_zj", "", "xt_tiaojian_mc", "${path_home}/xt/xttiaojian/select/myself/json.jw?key=${param.key}", false, function (event, id, treeNode) {
                                            var queryParams = $('#dg').datagrid('options').queryParams;
                                            $("#xt_tiaojian_zj").val(treeNode.xt_tiaojian_zj);
                                            $("#xt_tiaojian_mc").textbox('setValue', treeNode.xt_tiaojian_mc);
                                            queryParams.pid = treeNode.xt_tiaojian_zj;
                                            $('#dg').datagrid('reload');
                                        }, true);
                            });
        </script>
    </head>
    <body class="easyui-layout">

        <div data-options="region:'west',split:true" style="width:250px;">
            <div id="divID_Tree_menu" class="ztree">查询方案列表</div>
        </div>

        <div data-options="region:'center'" id='centerMain'>
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   rownumbers:true,
                   singleSelect: true,
                   toolbar:'#tb',
                   url:'${path_home}/xt/xttiaojian/select/selectOne/bodyGrid.jw',
                   method:'post',queryParams: {pid:''},
                   onClickCell: onClickCell
                   ">
                <thead>
                    <tr>                
                        <th data-options="field:'xt_tiaojian1_zj'">主键</th>
                        <th data-options="field:'xt_tiaojian_zj'">表头主键</th>
                        <th data-options="field:'xt_tiaojian1_lianjiefu'"><div>接连符</div></th>
                        <th data-options="field:'xt_shezhi_tiaojian1_zhi'"><div>条件区值</div></th>
                        <th data-options="field:'xt_tiaojian1_panduan'"><div>判断区</div></th>
                        <th data-options="field:'xt_tiaojian1_kuohao',width:90,editor:'text'"><div>括号区</div></th>
                        <th data-options="field:'xt_tiaojian1_lianjiefu_mc',width:90,formatter:f_lianjiefu,editor:{type:'select',options:{
                            data:TIAOJIAN_LIANJIE
                            ,editable:false
                            ,width:200
                            ,valueField:'xt_tiaojian1_lianjiefu'
                            ,textField:'xt_tiaojian1_lianjiefu_mc'
                            }
                            }"><div>接连符</div></th>
                        <th data-options="field:'xt_shezhi_tiaojian1_mc',width:150,formatter:f_tiaojianzhi,editor:{type:'select',options:{
                            url:'${path_home}/xt/xtshezhitiaojian/select/selectOne/bodyJSON.jw?key=${param.key}'
                            ,editable:false
                            ,width:250
                            ,valueField:'xt_shezhi_tiaojian1_zhi'
                            ,textField:'xt_shezhi_tiaojian1_mc'
                            }
                            }"><div>条件区</div></th>
                        <th data-options="field:'xt_tiaojian1_panduan_mc',width:100,formatter:f_panduan,editor:{type:'select',options:{
                            data:TIAOJIAN_PANDUAN
                            ,editable:false
                            ,width:200
                            ,valueField:'xt_tiaojian1_panduan'
                            ,textField:'xt_tiaojian1_panduan_mc'
                            }
                            }"><div>判断区</div></th>
                        <th data-options="field:'xt_tiaojian1_zhi',width:190,editor:'text'"><div>条件值</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)"iconCls="icon-remove" class="easyui-linkbutton" plain="true" onclick="dellRowServlet()">删除方案</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" plain="true"onclick="submitForm('submitFormID', false)">新增方案</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormIDU" plain="true"onclick="submitForm('submitFormIDU', true)">修改方案</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton"  plain="true"onclick="f_queryByCondition()">执行查询</a>
                </div>
                <div>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dellRow()">移除行</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addRow()">添加行</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton"  plain="true"onclick="closeCondition()">关闭条件框</a>
                </div>
                <div id="XTTiaojianFormID">
                    <table>
                        <tr>
                            <td>条件方案名称</td>
                            <td>
                                <input type="text"  id="xt_tiaojian_mc" name="xt_tiaojian_mc" data-options="required:true" class="easyui-textbox"/>
                                <input type="hidden"  id="xt_tiaojian_zj"/>
                                <input type="hidden" id="xt_shezhi_tiaojian_zhi" value="${param.key}"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

