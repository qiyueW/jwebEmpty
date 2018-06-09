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
                $('#dg').datagrid('hideColumn', 'danjuziduan_zj');
                $('#dg').datagrid('hideColumn', 'danju_zj');
            });
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
        </script>
    </head>
    <body class="easyui-layout">
        <input type="hidden" id="danjufl_zj" name="danjufl_zj" value="${Danju.danjufl_zj}">
        <input type="hidden" id="danju_zj" name="danju_zj" value="${Danju.danju_zj}">
        <input type="hidden" id="danju_zhidanren_zj" name="danju_zhidanren_zj" value="${Danju.danju_zhidanren_zj}">
        <input type="hidden" id="danju_xiugairen_zj" name="danju_xiugairen_zj" value="${Danju.danju_xiugairen_zj}">
        <input type="hidden" id="danju_zt" name="danju_zt" value="${Danju.danju_zt}">
        <div data-options="region:'center'" id='centerMain'>
            <table id="dg" class="easyui-datagrid" fit='true'
                   data-options="
                   rownumbers:true,
                   singleSelect:true,
                   toolbar:'#tb',
                   url:'${path_home}/base/danju/select/selectOne/bodyGrid.jw?pid=${Danju.danju_zj}'
                   ">
                <thead>
                    <tr>                
                        <th data-options="field:'danjuziduan_zj'">主键</th>
                        <th data-options="field:'danju_zj'">表头id</th>
                        <th data-options="field:'danjuziduan_mc',width:90"><div>字段名称</div></th>
                        <th data-options="field:'danjuziduan_daima',width:90"><div>字段代码</div></th>
                        <th data-options="field:'danjuziduan_leixing',width:90"><div>字段类型</div></th>
                        <th data-options="field:'danjuziduan_xiaoshudian',width:90"><div>字段小数点</div></th>
                        <th data-options="field:'danjuziduan_changdu',width:90"><div>字段长度</div></th>
                        <th data-options="field:'danjuziduan_jiaonian',width:90"><div>是否必须校验</div></th>
                        <th data-options="field:'danjuziduan_jiaoniankuizhi',width:90"><div>检验规则</div></th>
                        <th data-options="field:'danjuziduan_bz',width:90"><div>备注</div></th>
                        <th data-options="field:'danjuziduan_px',width:90"><div>排序</div></th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <div>
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
                <div>
                    <div class="container"  id="DanjuFormID">
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >模块名</span>
                                <input type="text"  value="${Danju.danju_mc}"  readonly="true" id="danju_mc" name="danju_mc" data-options="required:true" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >模块代码</span>
                                <input type="text"  value="${Danju.danju_daima}"  readonly="true" id="danju_daima" name="danju_daima" data-options="required:true" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单据前缀</span>
                                <input type="text"  value="${Danju.danju_qianzhui}"  readonly="true" id="danju_qianzhui" name="danju_qianzhui" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单据时间</span>
                                <input type="text"  value="${Danju.danju_shijian}"  readonly="true" id="danju_shijian" name="danju_shijian" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >单据流水号</span>
                                <input type="text"  value="${Danju.danju_liushuihao}"  readonly="true" id="danju_liushuihao" name="danju_liushuihao" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >备注</span>
                                <input type="text"  value="${Danju.danju_bz}"  readonly="true" id="danju_bz" name="danju_bz" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >修改时间</span>
                                <input class="easyui-datebox" type="text"  readonly="true" id="danju_xiugaishijian" value="${Danju.danju_xiugaishijian}" name="danju_xiugaishijian" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                            </div>
                        </div>                            
                        <div class="row-fluid">
                            <div class="span12">
                                <span class="myname" >排序</span>
                                <input type="text"  value="${Danju.danju_px}"  readonly="true" id="danju_px" name="danju_px" data-options="required:false" class="easyui-textbox"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

