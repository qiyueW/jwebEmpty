<%@page import="wx.xt.bean.xtguanliyuan.XtGuanliyuan"%>
<%@page import="wx.web.bean.RY"%>
<%@page import="wx.xt.Gelibiaoshi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	RY ry = Gelibiaoshi.getUserInfoBySession(session);
	if (null != ry) {
		response.sendRedirect(application.getAttribute("path_home").toString() + "/xt/indexUser.jsp");
		return;
	}
	XtGuanliyuan admin = Gelibiaoshi.getSuperAdminInfoBySession(session);
	if (null != admin) {
		response.sendRedirect(application.getAttribute("path_home").toString()
				+ (admin.getXt_guanliyuan_jibie() == 1 ? "/xt/indexSuperAdmin.jsp" : "/xt/indexAdmin.jsp"));
		return;
	}
%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
<head>
<title>JWeb官网-登陆</title>

<%@include file="/WEB-INF/jspf/meta.jspf"%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
<script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="lib/jquery/cookie.js" type="text/javascript"></script>
<script type="text/javascript" src="${path_home}/static/js/login.js"></script>
<script>
	if (typeof module === 'object') {
		window.jQuery = window.$ = module.exports;
	};
</script>
<%-- <%@include file="/WEB-INF/jspf/artDialog.jspf"%> --%>
<script>
	var path_home = "${path_home}/"
	$(function() {
		f_inidoLogin();
	});
</script>
<style>
.input-group {
	margin-top: 5px;
}
</style>
</head>

<body>
	<div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">总管级账号【一个账号等于一间公司】数据是隔离的</h4>
					</div>
					<div class="modal-body">
						<table class="table table-striped">
							<tr class="success">
								<td>标识</td>
								<td>账号</td>
								<td>密码</td>
								<td>方向</td>
							</tr>
							<tr>
								<td>fs001</td>
								<td>fsdemo</td>
								<td>fsdemo</td>
								<td>管理后台</td>
							</tr>
							<tr>
								<td>sz001</td>
								<td>szdemo</td>
								<td>szdemo</td>
								<td>管理后台</td>
							</tr>
							<tr>
								<td>zh001</td>
								<td>zhdemo</td>
								<td>zhdemo</td>
								<td>管理后台</td>
							</tr>
						</table>
						<div>
							备注 <br />
							<h6>标识： 代表公司。不同标识，代表不同公司。不同公司，意味着数据是隔离的</h6>
							<h6>方向： 总管与辅总登陆，必须选【管理后台】，业务员账号登陆必须选【业务操作】</h6>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<p style="visibility: hidden;">
		<input type="text" value="admin"
			style="position: absolute; z-index: -1;" disabled autocomplete="off" />
		<input type="password" value=" "
			style="position: absolute; z-index: -1;" disabled autocomplete="off" />
	</p>
	<div class="container" style="width: 400px; margin-top: 65px;">
		<div class="row">
			<div class="col-md-12">
				<a href="javascript:void(0)" data-toggle="modal"
					data-target="#myModal">点我取得演示的账号密码</a>
			</div>
			<div class="col-md-12">
				<div class="input-group">
					<span class="input-group-addon" id="basic-xt_gelibiaoshi">标识</span>
					<input class="form-control" type="text" placeholder="公司标识"
						id="xt_gelibiaoshi" autofocus="autofocus" maxlength="20" />
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-account">账号</span> <input
						class="form-control" type="text" placeholder="账号" id="account"
						autocomplete="off" maxlength="32" />
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-password">密码</span> <input
						class="form-control" type="password" placeholder="密码"
						id="password" autocomplete="off" maxlength="32" />
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-sort" style="color: red;">方向</span>
					<select id="sort" name="sort" class="form-control">
						<option value="user">业务操作</option>
						<option value="admin">管理后台</option>
					</select>
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-remember">记忆</span> <select
						id="remember" name="remember" class="form-control">
						<option value="0">不记住（安全）</option>
						<option value="1">记住除密码之外的（较安全）</option>
						<option value="2">记住所有（不安全）</option>
					</select>
				</div>
				<div hidden="true" id="show_xt_safecodeDivID">
					<span class="input-group-addon" id="basic-show_xt_safecodeDivID">验证码</span>
					<input class="form-control" type="text" placeholder="放鼠标到框内显示验证码"
						id="xt_safecode" name="xt_safecode" autocomplete="false"
						maxlength="6" />
					<div id="showsafecodeDivID" class="panel panel-default"
						hidden="true">
						<div class="panel-body">
							<a href="javascript:void(0);" onclick="refreshsafecode();"><img
								id="safecodeImg" src="" /></a> <br />若验证码失效，请点击图片重新获取
						</div>
					</div>
				</div>
				<input type="button" id="submitBTID"
					class="btn btn-default form-control" name="submitBTID" value="登录"
					style="margin-top: 8px;" />
				<div id="showmsgDivID" class="panel panel-default" hidden="true">
					<div class="panel-body" id="showmsgDivIDBody" style="color: red">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
