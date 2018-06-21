<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>系统条件管理-添加</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript" src="${path_home}/xt/js/xttiaojian/add.js"></script>
        <script type="text/javascript" src="${path_home}/xt/js/xttiaojian/common.js"></script>
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
            });
            function f_panduan(value, row, index) {
                if (value instanceof Object) {
                    row.xt_tiaojian1_panduan = value.xt_tiaojian1_panduan;
                    row.xt_tiaojian1_panduan_mc = value.xt_tiaojian1_panduan_mc;
                }
                return row.xt_tiaojian1_panduan_mc;
            }
            function f_lianjiefu(value, row, index) {
                if (value instanceof Object) {
                    row.xt_tiaojian1_lianjiefu = value.xt_tiaojian1_lianjiefu;
                    row.xt_tiaojian1_lianjiefu_mc = value.xt_tiaojian1_lianjiefu_mc;
                }
                return row.xt_tiaojian1_lianjiefu_mc;
            }
            function f_tiaojianzhi(value, row, index) {
                if (value instanceof Object) {
                    row.xt_shezhi_tiaojian1_zhi = value.xt_shezhi_tiaojian1_zhi;
                    row.xt_shezhi_tiaojian1_mc = value.xt_shezhi_tiaojian1_mc;
                }
                return row.xt_shezhi_tiaojian1_mc;
            }

        </script>
    </head>
    <body class="easyui-layout">
        <!--
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_BM" class="ztree">bean</div>
        </div>
        -->
        <!--<div data-options="region:'center'" id='centerMain'>-->
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
                        url:'${path_home}/xt/xtshezhitiaojian/select/selectOne/bodyJSON.jw?key=RY'
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
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dellRow()">移除行</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addRow()">添加行</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" plain="true"onclick="submitForm('XTTiaojianFormID')">保存</a>
            </div>
            <div id="XTTiaojianFormID">
                <table>
                    <tr>
                        <td>条件方案名称</td>
                        <td><input type="text"  id="xt_tiaojian_mc" name="xt_tiaojian_mc" data-options="required:true" class="easyui-textbox"/></td>
                        <td>模块</td>
                        <td>
                            <input id="xt_shezhi_tiaojian_zhi" class="easyui-combobox" name="xt_shezhi_tiaojian_zhi"
                                   data-options="valueField:'xt_shezhi_tiaojian_zhi',textField:'xt_shezhi_tiaojian_mc'
                                   ,url:'${path_home}/xt/xtshezhitiaojian/select/json.jw'
                                   ">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <!--</div>-->
    </body>
</html>

