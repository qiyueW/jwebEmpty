<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改楼房费用标准</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/loufangfybz/edit.js"></script>
        <script>
            $(function () {
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
        
<!--
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_LoufangFYBZ" class="ztree">bean</div>
        </div>
-->

        <div data-options="region:'center'" id='centerMain'>                    <input type="hidden" id="loufang_fybz_zj" name="loufang_fybz_zj" value="${LoufangFYBZ.loufang_fybz_zj}">
                    <input type="hidden" id="loufang_fybz_loufang_zj" name="loufang_fybz_loufang_zj" value="${LoufangFYBZ.loufang_fybz_loufang_zj}">
                    <input type="hidden" id="loufang_fybz_zt" name="loufang_fybz_zt" value="${LoufangFYBZ.loufang_fybz_zt}">
                    <input type="hidden" id="loufang_fybz_gelibiaoshi" name="loufang_fybz_gelibiaoshi" value="${LoufangFYBZ.loufang_fybz_gelibiaoshi}">

<div class="container"  id="LoufangFYBZFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtGuanliyuanFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >楼名</span>
                        <input type="text"  value="${LoufangFYBZ.loufang_fybz_loufang_mc}" id="loufang_fybz_loufang_mc" name="loufang_fybz_loufang_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >电费标准</span>
                        <input type="text"  value="${LoufangFYBZ.loufang_fybz_dianfei}" id="loufang_fybz_dianfei" name="loufang_fybz_dianfei" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >水费标准</span>
                        <input type="text"  value="${LoufangFYBZ.loufang_fybz_shuifei}" id="loufang_fybz_shuifei" name="loufang_fybz_shuifei" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >冷水费标准</span>
                        <input type="text"  value="${LoufangFYBZ.loufang_fybz_shuifei_leng}" id="loufang_fybz_shuifei_leng" name="loufang_fybz_shuifei_leng" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >热水费标准</span>
                        <input type="text"  value="${LoufangFYBZ.loufang_fybz_shuifei_re}" id="loufang_fybz_shuifei_re" name="loufang_fybz_shuifei_re" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >煤气费标准</span>
                        <input type="text"  value="${LoufangFYBZ.loufang_fybz_meiqi}" id="loufang_fybz_meiqi" name="loufang_fybz_meiqi" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>

