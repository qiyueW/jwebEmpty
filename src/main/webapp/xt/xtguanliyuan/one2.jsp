<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-系统辅管员</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script>
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
        </script>
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
            <input type="hidden" id="xt_guanliyuan_zj" name="xt_guanliyuan_zj" value="${XtGuanliyuan.xt_guanliyuan_zj}">
            <input type="hidden" id="xt_guanliyuan_zt" name="xt_guanliyuan_zt" value="${XtGuanliyuan.xt_guanliyuan_zt}">
<div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >辅管员名称</span>
                            ${XtGuanliyuan.xt_guanliyuan_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >辅管员账号</span>
                            ${XtGuanliyuan.xt_guanliyuan_zhanghao}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >辅管员邮箱</span>
                            ${XtGuanliyuan.xt_guanliyuan_youxiang}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >辅管员备注</span>
                            ${XtGuanliyuan.xt_guanliyuan_bz}
                    </div>
                </div>
        </div>
    </body>
</html>

