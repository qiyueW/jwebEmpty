<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>抄水表-添加</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <link rel="stylesheet" href="${path_home}/static/css/chaoshuibiao/common.css"  type="text/css" />
        <script type="text/javascript" src="${path_home}/static/js/chaoshuibiao/add.js"></script>
        <script type="text/javascript" src="${path_home}/static/js/chaoshuibiao/common.js"></script>
        <script>
            $(function () {
                inidoCommon();
                $('#chaoshuibiao_riqi2').datebox('setValue',jwebGetDate());
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="zhusuhetong_zj" name="zhusuhetong_zj" value="">
            <input type="hidden" id="zhusuhetong_loufang2_zj" name="zhusuhetong_loufang2_zj" value="">
            <div class="operationHead">
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="clearForm()">清空</a>
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="submitForm('ChaoShuibiaoFormID')">保存</a>
            </div>
            <div id="ChaoShuibiaoFormID">
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#0000CC">
                    <col width="102" />
                    <col width="198" />
                    <col width="102" />
                    <col width="198" />
                    <tr height="32">
                        <td width="102" height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">楼</span></td>
                        <td width="198" bordercolor="#9900FF"> 
                            <input type="hidden"  id="chaoshuibiao_loufang_mc"/>
                            <input type="hidden" id="chaoshuibiao_loufang_zj" value="">
                            <input id="chaoshuibiao_loufangGrid" class="easyui-combogrid" style=" width:100%"data-options="
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
                        <td width="102" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">房间</span></td>
                        <td width="198" bordercolor="#9900FF">
                            <input type="hidden" id="chaoshuibiao_loufang2_bianma" />
                            <input type="hidden" id="chaoshuibiao_loufang2_zj" value="">
                            <input id="chaoshuibiao_loufang2Grid" class="easyui-combogrid" style=" width:100%"data-options="
                                   required:true,
                                   panelWidth:600,
                                   idField: 'loufang2_zj',
                                   textField: 'loufang2_bianhao',
                                   columns: [[
                                   {field:'loufang2_zj',title:'ID'},
                                   {field:'loufang2_bianhao',title:'编号',width:120},
                                   {field:'loufang2_mingcheng',title:'名称',width:130},
                                   {field:'loufang2_chuangwei',title:'床位',width:90,align:'center'},
                                   {field:'loufang2_ruzhurenshu',title:'入住人数',width:40},
                                   {field:'loufang2_lx',title:'房间类型',width:90},
                                   {field:'loufang2_bz',title:'备注',width:190},
                                   ]],
                                   onHidePanel:f_fang_onHidePanel_combogrid,
                                   fitColumns: true
                                   "/>
                        </td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">上次读数</span></td>
                        <td bordercolor="#9900FF"><input type="text"  id="chaoshuibiao_dushu1" data-options="required:true" class="easyui-textbox"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">上次抄表日期</span></td>
                        <td bordercolor="#9900FF"><input type="text"  id="chaoshuibiao_riqi1" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser" class="easyui-datebox"/></td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">本次读数</span></td>
                        <td bordercolor="#9900FF"><input type="text"  id="chaoshuibiao_dushu2" data-options="required:true" class="easyui-textbox"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">本次抄表日期</span></td>
                        <td bordercolor="#9900FF"><input type="text"  id="chaoshuibiao_riqi2" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser" class="easyui-datebox"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>

