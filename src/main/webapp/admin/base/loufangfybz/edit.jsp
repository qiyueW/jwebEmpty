<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改楼房费用标准</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <link rel="stylesheet" href="${path_home}/static/css/loufangfybz/common.css"  type="text/css" />
        <!--<script type="text/javascript" src="${path_home}/static/js/loufangfybz/common.js"></script>-->
        <script type="text/javascript" src="${path_home}/static/js/loufangfybz/edit.js"></script>
        <script>
            $(function () {
//                inidoCommon();
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="loufang_fybz_zj"  value="${LoufangFYBZ.loufang_fybz_zj}"/>
            <input type="hidden" id="loufang_fybz_zt"  value="${LoufangFYBZ.loufang_fybz_zt}"/>
            <input type="hidden" id="loufang_fybz_gelibiaoshi"  value="${LoufangFYBZ.loufang_fybz_gelibiaoshi}">
            
            <div class="operationHead">
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="closeMySelf()">关闭</a>
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="submitForm('XtGuanliyuanFormID')">保存修改</a>
            </div>
            <div id="LoufangFYBZFormID">
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
                        <td bordercolor="#9900FF"><input class="easyui-textbox" type="text" value="${LoufangFYBZ.loufang_fybz_dianfei}"  id="loufang_fybz_dianfei"  data-options="required:true"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">水费标准</span></td>
                        <td bordercolor="#9900FF"><input class="easyui-textbox" type="text" value="${LoufangFYBZ.loufang_fybz_shuifei}" id="loufang_fybz_shuifei"  data-options="required:true"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>

