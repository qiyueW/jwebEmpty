<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-系统角色</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
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
            <input type="hidden" id="xt_juese_zj" name="xt_juese_zj" value="${XtJuese.xt_juese_zj}">
            <input type="hidden" id="xt_juese_fzj" name="xt_juese_fzj" value="${XtJuese.xt_juese_fzj}">
            <input type="hidden" id="xt_juese_zt" name="xt_juese_zt" value="${XtJuese.xt_juese_zt}">
            <input type="hidden" id="xt_juese_zhidanren_zj" name="xt_juese_zhidanren_zj" value="${XtJuese.xt_juese_zhidanren_zj}">
            <input type="hidden" id="xt_juese_xiugairen_zj" name="xt_juese_xiugairen_zj" value="${XtJuese.xt_juese_xiugairen_zj}">
<div class="container"  style="height:100%;overflow-y: scroll">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="xt_juese_fzj_mc" name="xt_juese_fzj_mc" value="${fl_P.xt_juese_mc}" readonly="true">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >名称</span>
                            ${XtJuese.xt_juese_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >代码</span>
                            ${XtJuese.xt_juese_dm}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >备注</span>
                            ${XtJuese.xt_juese_bz}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >隔离标识</span>
                            ${XtJuese.xt_juese_gelibiaoshi}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >制单人</span>
                            ${XtJuese.xt_juese_zhidanren}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >修改人</span>
                            ${XtJuese.xt_juese_xiugairen}
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">修改时间</span>
                        <input class="easyui-datebox" type="text" value="${XtJuese.xt_juese_xiugaishijian}"  readonly="true" name="xt_juese_xiugaishijian" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
        </div>
    </body>
</html>

