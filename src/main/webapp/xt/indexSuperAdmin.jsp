<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/jspf/meta.jspf"%>
<%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
<%@include file="/WEB-INF/jspf/ztree.jspf"%>
<script src="${path_home}/xt/js/indexSuperAdmin.js" type="text/javascript"></script>

<title>您好，欢迎您进入超级管理员后台</title>
<script type="text/javascript">
	$(function() {
		loadUserMainTree("divID_Tree_Main");
		$("#tt").tabs({
			onContextMenu : function(e, title, index) {
				e.preventDefault();
				$("#indexMainTabRClickMenu").menu('show', {
					left : e.pageX,
					top : e.pageY
				});
				$("#tabsRClickDoSaveValueID").val(title);
			}
		});
	})
</script>
</head>
<body class="easyui-layout" style="margin: 0;">
	<input type="hidden" id="tabsRClickDoSaveValueID" />
	<div data-options="region:'west',split:true" title="菜单"
		style="width: 280px;">
		<div id="divID_Tree_Main" class="ztree powertablediv">---</div>
	</div>
	<div data-options="region:'center'">
		<div data-options="border:false,fit:true" class="easyui-tabs" id="tt">
			<!--<div title="个人中心" data-options="href:'${path_home}/admin/iniView.jsp'"></div>-->
		</div>
	</div>
	<div data-options="region:'south',split:true"
		style="height: 30px; overflow: hidden; text-align: center;">
		<%=hyy%>
		<a href="javascript:void(0)" onclick="$('#div_udpatepassword').dialog('open')">修改密码</a> &nbsp;&nbsp;&nbsp; <a
			href="${path_home}/xt/loginmanager/out/superAdmin.jw">退出登陆</a>
	</div>
	<!-- 以下为tabs右击事件 -->
	<div id="indexMainTabRClickMenu" class="easyui-menu"
		style="width: 120px;">
		<div onclick="javascript:index_main_tab_close1()">闭关当前页面</div>
		<div onclick="javascript:index_main_tab_close_other()">关闭其他页面</div>
		<div onclick="javascript:index_main_tab_close()">关闭全部页面</div>
		<div onclick="javascript:index_main_tab_reflash()">刷新</div>
	</div>
	<div id="div_udpatepassword" class="easyui-dialog"
		style="width: 600px; height: 300px"
		data-options="title:'修改密码',buttons:'#tool_udpatepassword',modal:true,closed:true">
		<table>
			<tr>
				<td>现有的密码</td>
				<td><input type="text" id="oldpassword"  onfocus="this.type='password'" autocomplete="off"/></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="text" id="newpassword"  onfocus="this.type='password'" autocomplete="off"/></td>
			</tr>
			<tr>
				<td>再次确认新密码</td>
				<td><input type="text" id="newpassword2" onfocus="this.type='password'" autocomplete="off" /></td>
			</tr>
		</table>
	</div>
	<div id="tool_udpatepassword">
		<a href="javascript:void(0)" id="bt_updatepassword"
			onclick="f_updatepassword();" class="easyui-linkbutton">修改</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="$('#div_udpatepassword').dialog('close')">关闭</a>
	</div>
</body>
</html>
