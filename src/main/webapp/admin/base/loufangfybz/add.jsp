<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加楼房费用标准</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <link rel="stylesheet" href="${path_home}/static/css/loufangfybz/common.css"  type="text/css" />
        <script type="text/javascript" src="${path_home}/static/js/loufangfybz/common.js"></script>
        <script type="text/javascript" src="${path_home}/static/js/loufangfybz/add.js"></script>
        <script>
            $(function () {
                inidoAdd();
                inidoCommon();
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="loufang_fybz_zt" name="loufang_fybz_zt" value="0">
            <div class="operationHead">
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="clearForm()">清空</a>
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="submitForm('LoufangFYBZFormID')">保存</a>
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
                            <input type="hidden"  id="loufang_fybz_loufang_mc" value=""/>
                            <input type="hidden" id="loufang_fybz_loufang_zj" value="">
                            <input id="loufang_fybz_loufangGrid" class="easyui-combogrid" style=" width:100%"data-options="
                                   required:true,
                                   panelWidth:600,
                                   idField: 'loufang_zj',
                                   textField: 'loufang_mc',
                                   url:'${path_home}/base/loufang/select/grid2.jw',
                                   method:'post',
                                   columns: [[
                                   {field:'loufang_zj',title:'ID'},
                                   {field:'loufang_dizhi',title:'地址',width:220},
                                   {field:'loufang_mc',title:'名称',width:130},
                                   {field:'loufang_danjian_chuangwei',title:'可用单间床位',width:90,align:'center'},
                                   {field:'loufang_taojian_chuangwei',title:'可用套间床位',width:90},
                                   ]],
                                   onHidePanel:f_lou_onHidePanel_combogrid,
                                   fitColumns: true
                                   "/>
                        </td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">电费标准</span></td>
                        <td bordercolor="#9900FF"><input class="easyui-textbox" type="text"  id="loufang_fybz_dianfei"  data-options="required:true"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">水费标准</span></td>
                        <td bordercolor="#9900FF"><input class="easyui-textbox" type="text"  id="loufang_fybz_shuifei"  data-options="required:true"/></td>
                    </tr>
                </table>
                <!--                <div class="row-fluid">
                                    <div class="span12">
                                        <span class="myname" >冷水费标准</span>
                                        <input type="text"  id="loufang_fybz_shuifei_leng" name="loufang_fybz_shuifei_leng" data-options="required:true" class="easyui-textbox"/>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span12">
                                        <span class="myname" >热水费标准</span>
                                        <input type="text"  id="loufang_fybz_shuifei_re" name="loufang_fybz_shuifei_re" data-options="required:true" class="easyui-textbox"/>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span12">
                                        <span class="myname" >煤气费标准</span>
                                        <input type="text"  id="loufang_fybz_meiqi" name="loufang_fybz_meiqi" data-options="required:true" class="easyui-textbox"/>
                                    </div>
                                </div>-->
            </div>
        </div>
    </body>
</html>
