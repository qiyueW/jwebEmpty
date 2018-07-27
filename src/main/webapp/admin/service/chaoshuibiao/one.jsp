<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>水表明细</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <link rel="stylesheet" href="${path_home}/static/css/chaoshuibiao/common.css"  type="text/css" />
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'chaoshuibiaofengtan_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiao_zj');
                $('#dg').datagrid('hideColumn', 'chaoshuibiaofengtan_nfr_zj');
                var date=new Date("${ChaoShuibiao.chaoshuibiao_riqi1}");
                var date2=new Date("${ChaoShuibiao.chaoshuibiao_riqi2}");
                $("#chaoshuibiao_riqi1").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate())
                $("#chaoshuibiao_riqi2").val(date2.getFullYear()+"-"+(date2.getMonth()+1)+"-"+date2.getDate())
            });
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
        </script>
    </head>
    <body class="easyui-layout">
        <input type="hidden" id="chaoshuibiao_zj" name="chaoshuibiao_zj" value="${ChaoShuibiao.chaoshuibiao_zj}">
        <input type="hidden" id="chaoshuibiao_zt" name="chaoshuibiao_zt" value="${ChaoShuibiao.chaoshuibiao_zt}">
        <table id="dg" class="easyui-datagrid" fit='true'
               data-options="
               rownumbers:true,
               singleSelect:true,
               toolbar:'#tb',
               url:'${path_home}/service/chaoshuibiao/select/selectOne/bodyGrid.jw?pid=${ChaoShuibiao.chaoshuibiao_zj}'
               ">
            <thead>
                <tr>                
                    <th data-options="field:'chaoshuibiaofengtan_zj'">主键</th>
                    <th data-options="field:'chaoshuibiao_zj'">水表记录主键</th>
                    <th data-options="field:'chaoshuibiaofengtan_nfr',width:130">纳费人</th>
                    <th data-options="field:'chaoshuibiaofengtan_zhanyongtian',width:60"><div>占用天数</div></th>
                    <th data-options="field:'chaoshuibiaofengtan_shui',width:90"><div>水</div></th>
                    <th data-options="field:'chaoshuibiaofengtan_shui_danjia',width:90"><div>水单价</div></th>
                    <th data-options="field:'chaoshuibiaofengtan_feiyong',width:90"><div>分摊费</div></th>
                    <th data-options="field:'chaoshuibiaofengtan_nfsj',width:135">纳费时间</th>
                    <th data-options="field:'chaoshuibiaofengtan_nfr_zj'">纳费人主键</th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <div>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
            </div>
            <div>
                <div id="ChaoShuibiaoFormID">
                    <table border="1" cellpadding="0" cellspacing="0" bordercolor="#0000CC">
                        <col width="102" />
                        <col width="198" />
                        <col width="102" />
                        <col width="198" />
                        <tr height="32">
                            <td width="102" height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">楼</span></td>
                            <td width="198" bordercolor="#9900FF"> 
                                <input type="text" readonly id="chaoshuibiao_loufang_mc" value="${ChaoShuibiao.chaoshuibiao_loufang_mc}"/>
                                <input type="hidden" readonly id="chaoshuibiao_loufang_zj"value="${ChaoShuibiao.chaoshuibiao_loufang_zj}">
                            </td>
                            <td width="102" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">房间</span></td>
                            <td width="198" bordercolor="#9900FF">
                                <input type="text" readonly id="chaoshuibiao_loufang2_bianma" value="${ChaoShuibiao.chaoshuibiao_loufang2_bianma}"/>
                                <input type="hidden" readonly id="chaoshuibiao_loufang2_zj" value="${ChaoShuibiao.chaoshuibiao_loufang2_zj}">
                            </td>
                        </tr>
                        <tr height="32">
                            <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">本次抄表日期</span></td>
                            <td bordercolor="#9900FF">
                                <input type="text" readonly id="chaoshuibiao_riqi2"/>
                            </td>
                            <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">上次抄表日期</span></td>
                            <td bordercolor="#9900FF">
                                <input type="text" readonly id="chaoshuibiao_riqi1"/>
                            </td>
                        </tr>                        
                        <tr height="32">
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">本次读数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly id="chaoshuibiao_dushu2" data-options="required:true" value="${ChaoShuibiao.chaoshuibiao_dushu2}"class="easyui-textbox"/></td>
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">上次读数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly id="chaoshuibiao_dushu1" data-options="required:true" value="${ChaoShuibiao.chaoshuibiao_dushu1}" class="easyui-textbox"/></td>
                        </tr>
                        <tr height="32">
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">水(吨)</span></td>
                            <td bordercolor="#9900FF"><input type="text"readonly  id="chaoshuibiao_shui" data-options="required:true" value="${ChaoShuibiao.chaoshuibiao_shui}"class="easyui-textbox"/></td>
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">水单价/金额</span></td>
                            <td bordercolor="#9900FF">
                                <input type="text"style="width:60px;" readonly id="chaoshuibiao_shui_danjia" data-options="required:true" value="${ChaoShuibiao.chaoshuibiao_shui_danjia}" class="easyui-textbox"/>
                                /<input type="text" style="width:60px;" readonly id="chaoshuibiao_shui_jine" data-options="required:true" value="${ChaoShuibiao.chaoshuibiao_shui_jine}"class="easyui-textbox"/>
                            </td>
                        </tr>
                        <tr height="32">
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">分摊人数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly value="${ChaoShuibiao.chaoshuibiao_fentanrenshu}" id="chaoshuibiao_fentanrenshu"  data-options="required:true" class="easyui-textbox"/></td>
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">已纳费人数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly value="${ChaoShuibiao.chaoshuibiao_yj_fentanrenshu}" id="chaoshuibiao_yj_fentanrenshu"data-options="required:true"  class="easyui-textbox"/></td>
                        </tr>                        
                    </table>
                </div>
            </div>
        </div>
        <!--/div-->
    </body>
</html>

