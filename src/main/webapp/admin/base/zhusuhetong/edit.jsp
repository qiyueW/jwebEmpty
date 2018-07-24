<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改住宿合同</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/zhusuhetong/edit.js?id=<%=new Date()%>"></script>
        <link rel="stylesheet" href="${path_home}/static/css/zhusuhetong/common.css"  type="text/css" />
        <script type="text/javascript" src="${path_home}/static/js/zhusuhetong/common.js"></script>
        <script>
            $(function () {
                inidoCommon();
            });
            function f_xmf_onLoadSuccess() {
                var names = ($("#zhusuhetong_xml_zj").val()).split(",");
                var g = XMFObj.getGridObject();
                var rows = g.datagrid('getRows');
                console.log(rows.length);
                for (var i = 0; i < names.length; i++) {
                    for (var j = 0; j < rows.length; j++) {
                        if (names[i] == rows[j].loufangxmf_mc) {
                            g.datagrid('checkRow', g.datagrid('getRowIndex', rows[j]));
                        }
                    }
                }
            }
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="zhusuhetong_zj" name="zhusuhetong_zj" value="${ZhusuHetong.zhusuhetong_zj}">
            <input type="hidden" id="zhusuhetong_gelibiaoshi" value="${ZhusuHetong.zhusuhetong_gelibiaoshi}">
            
            <div class="operationHead">
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="closeMySelf()">关闭</a>
                <a href="javascript:void(0)"  class="easyui-linkbutton" onclick="submitForm('XtGuanliyuanFormID')">保存修改</a>
            </div>
            <div class="container"  id="ZhusuHetongFormID">
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#0000CC">
                    <col width="102" />
                    <col width="198" />
                    <col width="102" />
                    <col width="198" />
                    <tr height="32">
                        <td width="102" height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">楼</span></td>
                        <td width="198" bordercolor="#9900FF"> 
                            <input type="hidden"  id="zhusuhetong_loufang_mc" value="${ZhusuHetong.zhusuhetong_loufang_mc}"/>
                            <input type="hidden" id="zhusuhetong_loufang_zj" value="${ZhusuHetong.zhusuhetong_loufang_zj}">
                            <input id="zhusuhetong_loufangGrid" class="easyui-combogrid" value="${ZhusuHetong.zhusuhetong_loufang_zj}"style=" width:100%"data-options="
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
                                   onLoadSuccess:f_lou_onHidePanel_combogrid,
                                   fitColumns: true
                                   "/>
                        </td>
                        <td width="102" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">房间</span></td>
                        <td width="198" bordercolor="#9900FF">
                            <input type="hidden" id="zhusuhetong_loufang2_bianhao" value="${ZhusuHetong.zhusuhetong_loufang2_bianhao}"/>
                            <input type="hidden" id="zhusuhetong_loufang2_zj" value="${ZhusuHetong.zhusuhetong_loufang2_zj}">
                            <input id="zhusuhetong_loufang2Grid" value="${ZhusuHetong.zhusuhetong_loufang2_zj}" class="easyui-combogrid" style=" width:100%"data-options="
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
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">签约人</span></td>
                        <td colspan="3" bordercolor="#9900FF">
                            <input id="zhusuhetong_qianyueren" type="hidden" value="${ZhusuHetong.zhusuhetong_qianyueren}"/>
                            <input id="zhusuhetong_qianyueren_zj" type="hidden" value="${ZhusuHetong.zhusuhetong_qianyueren_zj}"/>
                            <input id="zhusuhetong_qianyuerenGrid" value="${ZhusuHetong.zhusuhetong_qianyueren_zj}" class="easyui-combogrid" style=" width:100%"data-options="
                                   required:true,
                                   panelWidth:600,
                                   idField: 'ry_zj',
                                   textField: 'ry_mc',
                                   url:'${path_home}/base/ry/select/grid2.jw',
                                   method:'post',
                                   columns: [[
                                   {field:'ry_zj',title:'ID',width:80},
                                   {field:'ry_bm',title:'部门',width:80},
                                   {field:'ry_mc',title:'人员名称',width:90},
                                   {field:'ry_zhanghao',title:'账号',width:80,align:'center'},
                                   {field:'ry_xingbie',title:'性别',width:80,align:'center'},
                                   {field:'ry_ruzhiriqi',title:'入职日期',width:200}
                                   ]],
                                   onHidePanel:f_ry_onHidePanel_combogrid,
                                   fitColumns: true
                                   "/>
                        </td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">租金</span></td>
                        <td bordercolor="#9900FF"><input type="text" value="${ZhusuHetong.zhusuhetong_zujin}" id="zhusuhetong_zujin" data-options="required:true" class="easyui-textbox"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">押金</span></td>
                        <td bordercolor="#9900FF"><input type="text" value="${ZhusuHetong.zhusuhetong_yajin}" id="zhusuhetong_yajin" data-options="required:false" class="easyui-textbox"/></td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">项目费</span></td>
                        <td colspan="3" bordercolor="#9900FF">
                            <input type="text" id="zhusuhetong_xmlGRID" class="easyui-combogrid" data-options="
                                   panelWidth:600,
                                   multiple: true,
                                   editable:false,
                                   idField: 'loufangxmf_zj',
                                   textField: 'loufangxmf_mc',
                                   url:'${path_home}/base/loufangxmf/select/grid2.jw',
                                   method:'post',
                                   columns: [[
                                   {field:'ck',checkbox:true},
                                   {field:'loufangxmf_zj',title:'ID',width:80},
                                   {field:'loufangxmf_mc',title:'名称',width:80},
                                   {field:'loufangxmf_feiyong',title:'费用',width:90}
                                   ]],
                                   onHidePanel:f_xmf_onHidePanel_combogrid,
                                   onLoadSuccess:f_xmf_onLoadSuccess,
                                   fitColumns: true"
                                   />
                            <input type="hidden" id="zhusuhetong_xml_zj" value="${ZhusuHetong.zhusuhetong_xml_zj}"/>
                            <input type="text"  id="zhusuhetong_tj_xml" value="${ZhusuHetong.zhusuhetong_tj_xml}" readonly="true" style=" width: 60px;"/>
                        </td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">开始日期</span></td>
                        <td bordercolor="#9900FF"><input class="easyui-datebox" type="text" value="${ZhusuHetong.zhusuhetong_kaishiriqi}" id="zhusuhetong_kaishiriqi" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">结束日期</span></td>
                        <td bordercolor="#9900FF"><input class="easyui-datebox" type="text" value="${ZhusuHetong.zhusuhetong_jieshuriqi}" id="zhusuhetong_jieshuriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/></td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">最小住宿日期</span></td>
                        <td bordercolor="#9900FF"><input class="easyui-datebox" type="text"  id="zhusuhetong_zuixiaozhusuriqi" value="${ZhusuHetong.zhusuhetong_zuixiaozhusuriqi}" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/></td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">　</span></td>
                        <td bordercolor="#9900FF">　</td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">计费方式</span></td>
                        <td bordercolor="#9900FF">
                            <select  id="zhusuhetong_jffs" data-options="required:true,editable:false" class=" easyui-combobox">
                                <option value="1" ${ZhusuHetong.zhusuhetong_jffs eq "1"?"selected":""}>按入住日</option>
                                <option value="2" ${ZhusuHetong.zhusuhetong_jffs eq "2"?"selected":""}>每月月底</option>
                                <option value="3" ${ZhusuHetong.zhusuhetong_jffs eq "3"?"selected":""}>每月x号（右侧填具体的）</option>
                            </select>
                        </td>
                        <td align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">指定几号</span></td>
                        <td bordercolor="#9900FF"><input type="text"  id="zhusuhetong_jffs_zdrq" value="${ZhusuHetong.zhusuhetong_jffs_zdrq}"  data-options="required:false" class="easyui-textbox"/></td>
                    </tr>
                    <tr height="32">
                        <td height="32" align="right" valign="middle" bordercolor="#9900FF" bgcolor="#CCCCFF"><span class="STYLE2">备注</span></td>
                        <td colspan="3" bordercolor="#9900FF"><input type="text" value="${ZhusuHetong.zhusuhetong_bz}" id="zhusuhetong_bz"style=" width:100%" data-options="required:false" class="easyui-textbox"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>

