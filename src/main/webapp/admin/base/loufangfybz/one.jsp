<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-楼房费用标准</title>
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
            <input type="hidden" id="loufang_fybz_zj" name="loufang_fybz_zj" value="${LoufangFYBZ.loufang_fybz_zj}">
            <input type="hidden" id="loufang_fybz_loufang_zj" name="loufang_fybz_loufang_zj" value="${LoufangFYBZ.loufang_fybz_loufang_zj}">
            <input type="hidden" id="loufang_fybz_zt" name="loufang_fybz_zt" value="${LoufangFYBZ.loufang_fybz_zt}">
            <input type="hidden" id="loufang_fybz_gelibiaoshi" name="loufang_fybz_gelibiaoshi" value="${LoufangFYBZ.loufang_fybz_gelibiaoshi}">
<div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >楼名</span>
                            ${LoufangFYBZ.loufang_fybz_loufang_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >电费标准</span>
                            ${LoufangFYBZ.loufang_fybz_dianfei}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >水费标准</span>
                            ${LoufangFYBZ.loufang_fybz_shuifei}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >冷水费标准</span>
                            ${LoufangFYBZ.loufang_fybz_shuifei_leng}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >热水费标准</span>
                            ${LoufangFYBZ.loufang_fybz_shuifei_re}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >煤气费标准</span>
                            ${LoufangFYBZ.loufang_fybz_meiqi}
                    </div>
                </div>
        </div>
    </body>
</html>

