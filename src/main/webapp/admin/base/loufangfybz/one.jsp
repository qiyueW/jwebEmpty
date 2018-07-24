<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-楼房费用标准</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <link rel="stylesheet" href="${path_home}/static/css/loufangfybz/common.css"  type="text/css" />
        <script>
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
        </script>
    </head>
    <body class="easyui-layout">
        <input type="hidden" id="loufang_fybz_zj" name="loufang_fybz_zj" value="${LoufangFYBZ.loufang_fybz_zj}">
        <div class="operationHead">
            <a href="javascript:void(0)"  class="easyui-linkbutton"  onclick="closeMySelf()">关闭</a>
        </div>
        <table border="1" cellpadding="0" cellspacing="0" bordercolor="#0000CC">
            <col width="102" />
            <col width="198" />
            <col width="102" />
            <col width="198" />
            <tr height="32">
                <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">楼</span></td>
                <td colspan="3" bordercolor="#9900FF">
                    <input type="text" readonly="true" id="loufang_fybz_loufang_mc" value="${LoufangFYBZ.loufang_fybz_loufang_mc}"/>
                    <input type="hidden" id="loufang_fybz_loufang_zj" value="${LoufangFYBZ.loufang_fybz_loufang_zj}">
                </td>
            </tr>
            <tr height="32">
                <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">电费标准</span></td>
                <td bordercolor="#9900FF"><input class="easyui-textbox" type="text" readonly="true" value="${LoufangFYBZ.loufang_fybz_dianfei}"  id="loufang_fybz_dianfei"  data-options="required:true"/></td>
                <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">水费标准</span></td>
                <td bordercolor="#9900FF"><input class="easyui-textbox" type="text" readonly="true" value="${LoufangFYBZ.loufang_fybz_shuifei}" id="loufang_fybz_shuifei"  data-options="required:true"/></td>
            </tr>
        </table>
    </body>
</html>

