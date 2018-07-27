<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>电表维护</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <link rel="stylesheet" href="${path_home}/static/css/chaodianbiao/common.css"  type="text/css" />
        <script type="text/javascript" src="${path_home}/static/js/chaodianbiao/edit.js"></script>
        <script>
            $(function () {
                $('#dg').datagrid('hideColumn', 'chaodianbiaofengtan_zj');
                $('#dg').datagrid('hideColumn', 'chaodianbiao_zj');
                $('#dg').datagrid('hideColumn', 'chaodianbiaofengtan_nfr_zj');
                var date = new Date("${ChaoDianbiao.chaodianbiao_riqi1}");
                var date2 = new Date("${ChaoDianbiao.chaodianbiao_riqi2}");
                $("#chaodianbiao_riqi1").val(date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate())
                $("#chaodianbiao_riqi2").val(date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate())
            });
        </script>
    </head>
    <body class="easyui-layout">
        <input type="hidden" id="chaodianbiao_zj" name="chaodianbiao_zj" value="${ChaoDianbiao.chaodianbiao_zj}">
        <input type="hidden" id="chaodianbiao_zt" name="chaodianbiao_zt" value="${ChaoDianbiao.chaodianbiao_zt}">
        <table id="dg" class="easyui-datagrid" fit='true'
               data-options="
               rownumbers:true,
               singleSelect:true,
               toolbar:'#tb',
               url:'${path_home}/service/chaodianbiao/select/selectOne/bodyGrid.jw?pid=${ChaoDianbiao.chaodianbiao_zj}',
               onClickCell: onClickCell
               ">
            <thead>
                <tr>                
                    <th data-options="field:'chaodianbiaofengtan_zj'">主键</th>
                    <th data-options="field:'chaodianbiao_zj'">电表记录主键</th>
                    <th data-options="field:'chaodianbiaofengtan_nfr',width:130">纳费人</th>
                    <th data-options="field:'chaodianbiaofengtan_zhanyongtian',width:60"><div>占用天数</div></th>
                    <th data-options="field:'chaodianbiaofengtan_dian',width:90"><div>电</div></th>
                    <th data-options="field:'chaodianbiaofengtan_dian_danjia',width:90"><div>电单价</div></th>
                    <th data-options="field:'chaodianbiaofengtan_feiyong',width:90"><div>分摊费</div></th>
                    <th data-options="field:'chaodianbiaofengtan_nfsj',width:135">纳费时间</th>
                    <th data-options="field:'chaodianbiaofengtan_nfr_zj'">纳费人主键</th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <div style=" margin:5px;">
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" id="submitFormID" onclick="submitForm('ChaoDianbiaoFormID')">保存修改</a>
            </div>
            <div>
                <div class="container"  id="ChaoDianbiaoFormID">
                    <table border="1" cellpadding="0" cellspacing="0" bordercolor="#0000CC">
                        <col width="102" />
                        <col width="198" />
                        <col width="102" />
                        <col width="198" />
                        <tr height="32">
                            <td width="102" height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">楼</span></td>
                            <td width="198" bordercolor="#9900FF"> 
                                <input type="text" readonly id="chaodianbiao_loufang_mc" value="${ChaoDianbiao.chaodianbiao_loufang_mc}"/>
                                <input type="hidden" readonly id="chaodianbiao_loufang_zj"value="${ChaoDianbiao.chaodianbiao_loufang_zj}">
                            </td>
                            <td width="102" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">房间</span></td>
                            <td width="198" bordercolor="#9900FF">
                                <input type="text" readonly id="chaodianbiao_loufang2_bianma" value="${ChaoDianbiao.chaodianbiao_loufang2_bianma}"/>
                                <input type="hidden" readonly id="chaodianbiao_loufang2_zj" value="${ChaoDianbiao.chaodianbiao_loufang2_zj}">
                            </td>
                        </tr>
                        <tr height="32">
                            <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">本次抄表日期</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly id="chaodianbiao_riqi2"/></td>
                            <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">上次抄表日期</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly id="chaodianbiao_riqi1"></td>
                        </tr>                        
                        <tr height="32">
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2" style="color:red;">本次读数</span></td>
                            <td bordercolor="#9900FF"><input type="text" id="chaodianbiao_dushu2" data-options="required:true" value="${ChaoDianbiao.chaodianbiao_dushu2}"class="easyui-textbox"/></td>
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">上次读数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly id="chaodianbiao_dushu1" data-options="required:true" value="${ChaoDianbiao.chaodianbiao_dushu1}" class="easyui-textbox"/></td>
                        </tr>
                        <tr height="32">
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">电(度)</span></td>
                            <td bordercolor="#9900FF"><input type="text"readonly  id="chaodianbiao_dian" data-options="required:true" value="${ChaoDianbiao.chaodianbiao_dian}"class="easyui-textbox"/></td>
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">电单价/金额</span></td>
                            <td bordercolor="#9900FF">
                                <input type="text"style="width:60px;" readonly id="chaodianbiao_dian_danjia" data-options="required:true" value="${ChaoDianbiao.chaodianbiao_dian_danjia}" class="easyui-textbox"/>
                                /<input type="text" style="width:60px;" readonly id="chaodianbiao_dian_jine" data-options="required:true" value="${ChaoDianbiao.chaodianbiao_dian_jine}"class="easyui-textbox"/>
                            </td>
                        </tr>
                        <tr height="32">
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">分摊人数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly value="${ChaoDianbiao.chaodianbiao_fentanrenshu}" id="chaodianbiao_fentanrenshu"  data-options="required:true" class="easyui-textbox"/></td>
                            <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">已纳费人数</span></td>
                            <td bordercolor="#9900FF"><input type="text" readonly value="${ChaoDianbiao.chaodianbiao_yj_fentanrenshu}" id="chaodianbiao_yj_fentanrenshu"data-options="required:true"  class="easyui-textbox"/></td>
                        </tr>                        
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

