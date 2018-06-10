<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-系统权限</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
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
            <input type="hidden" id="xt_quanxian_zj" name="xt_quanxian_zj" value="${XtQuanxian.xt_quanxian_zj}">
            <input type="hidden" id="xt_quanxian_fzj" name="xt_quanxian_fzj" value="${XtQuanxian.xt_quanxian_fzj}">
            <input type="hidden" id="xt_quanxian_zt" name="xt_quanxian_zt" value="${XtQuanxian.xt_quanxian_zt}">
<div class="container"  style="height:100%;overflow-y: scroll">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="xt_quanxian_fzj_mc" name="xt_quanxian_fzj_mc" value="${fl_P.xt_quanxian_mc}" readonly="true">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >排序</span>
                            ${XtQuanxian.xt_quanxian_px}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >名称</span>
                            ${XtQuanxian.xt_quanxian_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >权限代码</span>
                            ${XtQuanxian.xt_quanxian_dm}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >url</span>
                            ${XtQuanxian.xt_quanxian_url}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >可视</span>
                            ${XtQuanxian.xt_quanxian_keshi}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >展开</span>
                            ${XtQuanxian.xt_quanxian_zhankai}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >备注</span>
                            ${XtQuanxian.xt_quanxian_bz}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >隔离标识</span>
                            ${XtQuanxian.xt_quanxian_gelibiaoshi}
                    </div>
                </div>
        </div>
    </body>
</html>

