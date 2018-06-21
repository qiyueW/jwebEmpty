<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-楼房分类</title>
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
            <input type="hidden" id="loufangfl_zj" name="loufangfl_zj" value="${LoufangFL.loufangfl_zj}">
            <input type="hidden" id="loufangfl_fzj" name="loufangfl_fzj" value="${LoufangFL.loufangfl_fzj}">
            <input type="hidden" id="loufangfl_zt" name="loufangfl_zt" value="${LoufangFL.loufangfl_zt}">
<div class="container"  style="height:100%;overflow-y: scroll">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="loufangfl_fzj_mc" name="loufangfl_fzj_mc" value="${fl_P.loufangfl_mc}" readonly="true">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >排序</span>
                            ${LoufangFL.loufangfl_px}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >名称</span>
                            ${LoufangFL.loufangfl_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >备注</span>
                            ${LoufangFL.loufangfl_bz}
                    </div>
                </div>
        </div>
    </body>
</html>

