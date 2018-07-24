<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加部门管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/chaoshuibiao/edit.js"></script>
        <script>
            $(function () {
                //f_extend_select();
                $('#dg').datagrid('hideColumn', 'chaoshuibiaofengtan_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiaofengtan_nfsj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiaofengtan_nfr_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiaofengtan_nfr');
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
                    <input type="hidden" id="chaoshuibiao_zj" name="chaoshuibiao_zj" value="${ChaoShuibiao.chaoshuibiao_zj}">
                    <input type="hidden" id="chaoshuibiao_loufang_zj" name="chaoshuibiao_loufang_zj" value="${ChaoShuibiao.chaoshuibiao_loufang_zj}">
                    <input type="hidden" id="chaoshuibiao_loufang2_zj" name="chaoshuibiao_loufang2_zj" value="${ChaoShuibiao.chaoshuibiao_loufang2_zj}">
                    <input type="hidden" id="chaoshuibiao_zhidanren" name="chaoshuibiao_zhidanren" value="${ChaoShuibiao.chaoshuibiao_zhidanren}">
                    <input type="hidden" id="chaoshuibiao_zhidanren_zj" name="chaoshuibiao_zhidanren_zj" value="${ChaoShuibiao.chaoshuibiao_zhidanren_zj}">
                    <input type="hidden" id="chaoshuibiao_zt" name="chaoshuibiao_zt" value="${ChaoShuibiao.chaoshuibiao_zt}">
                    <input type="hidden" id="chaoshuibiao_gelibiaoshi" name="chaoshuibiao_gelibiaoshi" value="${ChaoShuibiao.chaoshuibiao_gelibiaoshi}">
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
                   url:'${path_home}/service/chaoshuibiao/select/selectOne/bodyGrid.jw?pid=${ChaoShuibiao.chaoshuibiao_zj}',
                   onClickCell: onClickCell
                   ">
                <thead>
                    <tr>                
                    <th data-options="field:'chaoshuibiaofengtan_zj'">主键</th>
                    <th data-options="field:'chaoshuibiao_zj'">水表记录主键</th>
                       <th data-options="field:'chaoshuibiaofengtan_shui',width:90,editor:'text'"><div>水</div></th>
                       <th data-options="field:'chaoshuibiaofengtan_shui_danjia',width:90,editor:'text'"><div>水单价</div></th>
                       <th data-options="field:'chaoshuibiaofengtan_feiyong',width:90,editor:'text'"><div>分摊费</div></th>
                    <th data-options="field:'chaoshuibiaofengtan_nfsj'">纳费时间</th>
                    <th data-options="field:'chaoshuibiaofengtan_nfr_zj'">纳费人主键</th>
                    <th data-options="field:'chaoshuibiaofengtan_nfr'">纳费人</th>
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
                    <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" onclick="submitForm('ChaoShuibiaoFormID')">保存修改</a>
                </div>
                <div>
<div class="container"  id="ChaoShuibiaoFormID">
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >楼名称</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_loufang_mc}" id="chaoshuibiao_loufang_mc" name="chaoshuibiao_loufang_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >房编号</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_loufang2_bianma}" id="chaoshuibiao_loufang2_bianma" name="chaoshuibiao_loufang2_bianma" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >上次读数</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_dushu1}" id="chaoshuibiao_dushu1" name="chaoshuibiao_dushu1" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >上次抄表日期</span>
                            <input class="easyui-datebox" type="text"  id="chaoshuibiao_riqi1" value="${ChaoShuibiao.chaoshuibiao_riqi1}" name="chaoshuibiao_riqi1" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>                            
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >读数</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_dushu2}" id="chaoshuibiao_dushu2" name="chaoshuibiao_dushu2" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >抄表日期</span>
                            <input class="easyui-datebox" type="text"  id="chaoshuibiao_riqi2" value="${ChaoShuibiao.chaoshuibiao_riqi2}" name="chaoshuibiao_riqi2" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>                            
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >水(吨)</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_shui}" id="chaoshuibiao_shui" name="chaoshuibiao_shui" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >水单价</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_shui_danjia}" id="chaoshuibiao_shui_danjia" name="chaoshuibiao_shui_danjia" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >金额</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_shui_jine}" id="chaoshuibiao_shui_jine" name="chaoshuibiao_shui_jine" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >分摊人数</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_fentanrenshu}" id="chaoshuibiao_fentanrenshu" name="chaoshuibiao_fentanrenshu" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >已分摊人数</span>
                        <input type="text"  value="${ChaoShuibiao.chaoshuibiao_yj_fentanrenshu}" id="chaoshuibiao_yj_fentanrenshu" name="chaoshuibiao_yj_fentanrenshu" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
                </div>
            </div>
        <!--</div>-->
    </body>
</html>

