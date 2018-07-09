<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-职位</title>
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
        <input type="hidden" id="zhiwei_zj" name="zhiwei_zj" value="${Zhiwei.zhiwei_zj}">
        <input type="hidden" id="zhiwei_fzj" name="zhiwei_fzj" value="${Zhiwei.zhiwei_fzj}">
        <input type="hidden" id="zhiwei_zt" name="zhiwei_zt" value="${Zhiwei.zhiwei_zt}">
        <div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname">上级</span>
                    <input type="text" id="zhiwei_fzj_mc" name="zhiwei_fzj_mc" value="${fl_P.zhiwei_mc}" readonly="true">
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >名称</span>
                    ${Zhiwei.zhiwei_mc}
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >备注</span>
                    <textarea rows=5 readonly="true" class="textarea easyui-validatebox" id="zhiwei_bz" name="zhiwei_bz" data-options="required:false">${Zhiwei.zhiwei_bz}</textarea>
                </div>
            </div>                 
        </div>
    </body>
</html>

