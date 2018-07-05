<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加系统角色</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtjuese/add2.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                inidoAdd();
            });
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
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_XtJuese" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="xt_juese_zj" name="xt_juese_zj" value="">
            <input type="hidden" id="xt_juese_fzj" name="xt_juese_fzj" value="">
            <input type="hidden" id="xt_juese_zt" name="xt_juese_zt" value="0">
            <input type="hidden" id="xt_juese_zhidanren_zj" name="xt_juese_zhidanren_zj" value="">
            <input type="hidden" id="xt_juese_xiugairen_zj" name="xt_juese_xiugairen_zj" value="">
            <input type="hidden" id="xt_juese_gongsi" name="xt_juese_gongsi" value="1">

            <div class="container"  id="XtJueseFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtJueseFormID')">保存</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >上级</span>
                        <input type="text" id="xt_juese_fzj_mc" name="xt_juese_fzj_mc" readonly="true" class="easyui-textbox">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  id="xt_juese_mc" name="xt_juese_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  id="xt_juese_bz" name="xt_juese_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
