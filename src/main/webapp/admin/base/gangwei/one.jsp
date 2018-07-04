<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-岗位</title>
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
            <input type="hidden" id="gangwei_zj" name="gangwei_zj" value="${Gangwei.gangwei_zj}">
            <input type="hidden" id="gangwei_fzj" name="gangwei_fzj" value="${Gangwei.gangwei_fzj}">
            <input type="hidden" id="gangwei_zt" name="gangwei_zt" value="${Gangwei.gangwei_zt}">
<div class="container"  style="height:100%;overflow-y: scroll">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="gangwei_fzj_mc" name="gangwei_fzj_mc" value="${fl_P.gangwei_mc}" readonly="true">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >名称</span>
                            ${Gangwei.gangwei_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >备注</span>
                            <textarea rows=5 readonly="true" class="textarea easyui-validatebox" id="gangwei_bz" name="gangwei_bz" data-options="required:false">${Gangwei.gangwei_bz}</textarea>
                    </div>
                </div>                 
<!--                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >隔离标识</span>
                            ${Gangwei.gangwei_gelibiaoshi}
                    </div>
                </div>-->
        </div>
    </body>
</html>

