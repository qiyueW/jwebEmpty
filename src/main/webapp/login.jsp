<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${path_home}/static/js/login.js"></script> 
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <script>
            var path_home = "${path_home}/"
            $(function () {
                f_inidoLogin();
            });
        </script>
    </head>
    <body style=" background-color: #cccfff">
        <div class="container" style=" max-width:400px; margin:120px auto;">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="xt_gelibiaoshi">
                            公司标识
                        </label>
                        <input class="form-control required" type="text" placeholder="公司标识" id="xt_gelibiaoshi" name="xt_gelibiaoshi" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <label for="account">
                            账号
                        </label>
                        <input class="form-control required" type="text" placeholder="账号" id="account" name="account"  autocomplete="false" maxlength="32"/>
                    </div>
                    <div class="form-group">
                        <label for="password">
                            密码
                        </label>
                        <input class="form-control required" type="password" placeholder="密码" id="password" name="password" autocomplete="false" maxlength="32"/>
                    </div>
                    <div class="form-group">
                        <select id="sort" name="sort">
                            <option value="user">业务操作</option>
                            <option value="admin">管理员后台</option>
                        </select>
                    </div>
                    <div class="form-group" hidden="true" id="show_xt_safecodeDivID">
                        <label for="xt_safecode">
                            验证码
                        </label>
                        <input class="form-control required" type="text" placeholder="放鼠标到框内显示验证码" id="xt_safecode" name="xt_safecode" autocomplete="false" maxlength="6"/>
                        <div id="showsafecodeDivID" class="panel panel-default" hidden="true">
                            <div class="panel-body">
                                <a href="javascript:void(0);" onclick="refreshsafecode();"><img id="safecodeImg"src=""/></a>
                                <br/>若验证码失效，请点击图片重新获取
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remember">
                            记住我
                        </label>
                        <input type="checkbox" name="remember" value="1"/>
                    </div>
                    <input type="button" id="submitBTID"class="btn btn-primary pull-right" name="submitBTID" value="登录"/>
                    <div class="form-group">
                        <div id="showmsgDivID" class="panel panel-default" hidden="true">
                            <div class="panel-body" id="showmsgDivIDBody" style=" color: red">
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
