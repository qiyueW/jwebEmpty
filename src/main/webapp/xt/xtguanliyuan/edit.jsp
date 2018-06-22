<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改系统管理员</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtguanliyuan/edit.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
<!--        <script>
            $(function () {
                inido();
            });
        </script>-->
        <style>
            .row-fluid{
                margin: 10px;
            }
            .row-fluid input{
                height: 40px;
                width: 660px;
            }
            .row-fluid textarea{
                width: 660px;
            }
            .myname{
                display:block;
                width: 660px;
                background-color: #ebfceb
            }
        </style>  
    </head>
    <body class="easyui-layout">
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="xt_guanliyuan_zj" name="xt_guanliyuan_zj" value="${XtGuanliyuan.xt_guanliyuan_zj}">
            <input type="hidden" id="xt_guanliyuan_zt" name="xt_guanliyuan_zt" value="${XtGuanliyuan.xt_guanliyuan_zt}">
            <input type="hidden" id="xt_guanliyuan_gelibiaoshi"  value="${XtGuanliyuan.xt_guanliyuan_gelibiaoshi}" />
            <div class="container"  id="XtGuanliyuanFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearFather()">清空上级</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtGuanliyuanFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员名称</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_mc}" id="xt_guanliyuan_mc" name="xt_guanliyuan_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员账号</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_zhanghao}" id="xt_guanliyuan_zhanghao" name="xt_guanliyuan_zhanghao" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员密码</span>
                        <input type="password"  value="${XtGuanliyuan.xt_guanliyuan_mima}" id="xt_guanliyuan_mima" name="xt_guanliyuan_mima" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员邮箱</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_youxiang}" id="xt_guanliyuan_youxiang" name="xt_guanliyuan_youxiang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员备注</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_bz}" id="xt_guanliyuan_bz" name="xt_guanliyuan_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

