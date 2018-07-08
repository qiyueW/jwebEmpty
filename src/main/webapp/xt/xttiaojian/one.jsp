<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加部门管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'xt_tiaojian1_zj');
                $('#dg').datagrid('hideColumn', 'xt_tiaojian_zj');
            });
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
        </script>
    </head>
    <body class="easyui-layout">
        <input type="hidden" id="xt_tiaojian_zj" name="xt_tiaojian_zj" value="${XTTiaojian.xt_tiaojian_zj}">
        <input type="hidden" id="xt_tiaojian_zhidanren_zj" name="xt_tiaojian_zhidanren_zj" value="${XTTiaojian.xt_tiaojian_zhidanren_zj}">
        <input type="hidden" id="xt_tiaojian_zt" name="xt_tiaojian_zt" value="${XTTiaojian.xt_tiaojian_zt}">
        <!--div data-options="region:'center'" id='centerMain'-->
        <table id="dg" class="easyui-datagrid" fit='true'
               data-options="
               rownumbers:true,
               singleSelect:true,
               toolbar:'#tb',
               url:'${path_home}/xt/xttiaojian/select/selectOne/bodyGrid.jw?pid=${XTTiaojian.xt_tiaojian_zj}'
               ">
            <thead>
                <tr>                
                    <th data-options="field:'xt_tiaojian1_zj'">主键</th>
                    <th data-options="field:'xt_tiaojian_zj'">表头主键</th>
                    <th data-options="field:'xt_tiaojian1_kuohao',width:90"><div>括号区</div></th>
                    <th data-options="field:'xt_tiaojian1_lianjiefu',width:90"><div>接连符</div></th>
                    <th data-options="field:'xt_tiaojian1_lianjiefu_mc',width:90"><div>接连符展示名</div></th>
                    <th data-options="field:'xt_shezhi_tiaojian1_mc',width:90"><div>条件区展示名</div></th>
                    <th data-options="field:'xt_shezhi_tiaojian1_zhi',width:90"><div>条件区值</div></th>
                    <th data-options="field:'xt_tiaojian1_panduan',width:90"><div>判断区</div></th>
                    <th data-options="field:'xt_tiaojian1_panduan_mc',width:90"><div>判断区展示名</div></th>
                    <th data-options="field:'xt_tiaojian1_zhi',width:90"><div>条件值</div></th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <div>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
            </div>

            <div id="XTTiaojianFormID">
                <table>
                    <tr>
                        <td>条件方案名称</td>
                        <td><input type="text" value="${XTTiaojian.xt_tiaojian_mc}" id="xt_tiaojian_mc" name="xt_tiaojian_mc" data-options="required:true" class="easyui-textbox"/></td>
                        <td>单据隔离标识</td>
                        <td>
                            <input type="text"  value="${XTTiaojian.xt_tiaojian_gelibiaoshi}"  readonly="true" id="xt_tiaojian_gelibiaoshi" name="xt_tiaojian_gelibiaoshi" data-options="required:true" class="easyui-textbox"/>
                        </td>
                        <td>模块</td>
                        <td>
                            <input id="xt_shezhi_tiaojian_zj" class="easyui-combobox" name="xt_shezhi_tiaojian_zj"
                                   data-options="valueField:'xt_shezhi_tiaojian_zj',textField:'xt_shezhi_tiaojian_mc'
                                   ,url:'${path_home}/xt/xtshezhitiaojian/select/json.jw'
                                   ">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <!--/div-->
    </body>
</html>

