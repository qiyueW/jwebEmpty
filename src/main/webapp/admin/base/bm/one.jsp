<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-部门管理</title>
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
        <input type="hidden" id="bm_zj" name="bm_zj" value="${BM.bm_zj}">
        <input type="hidden" id="bm_fzj" name="bm_fzj" value="${BM.bm_fzj}">
        <input type="hidden" id="bm_fuzhiren_zj" name="bm_fuzhiren_zj" value="${BM.bm_fuzhiren_zj}">
        <input type="hidden" id="bm_zt" name="bm_zt" value="${BM.bm_zt}">
        <div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname">上级</span>
                    <input type="text" id="bm_fzj_mc" name="bm_fzj_mc" value="${fl_P.bm_mc}" readonly="true">
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >名称</span>
                    ${BM.bm_mc}
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >编码</span>
                    ${BM.bm_bianma}
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >部门简介</span>
                    <textarea rows=5 readonly="true" class="textarea easyui-validatebox" id="bm_jianjie" name="bm_jianjie" data-options="required:false">${BM.bm_jianjie}</textarea>
                </div>
            </div>                 
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >部门图片1</span>
                    <a href="${path_home}/${BM.bm_tupian1}" target="_bland"><img src="${path_home}/${BM.bm_tupian1}" style="max-width:300px;"/></a>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >部门图片2</span>
                    <a href="${path_home}/${BM.bm_tupian2}" target="_bland"><img src="${path_home}/${BM.bm_tupian2}" style="max-width:300px;"/></a>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname" >部门负责人</span>
                    ${BM.bm_fuzhiren}
                </div>
            </div>
        </div>
    </body>
</html>

