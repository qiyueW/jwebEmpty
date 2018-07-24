<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-楼房项目费</title>
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
            <input type="hidden" id="loufangxmf_zj" name="loufangxmf_zj" value="${LoufangXMF.loufangxmf_zj}">
            <input type="hidden" id="loufangxmf_gelibiaoshi" name="loufangxmf_gelibiaoshi" value="${LoufangXMF.loufangxmf_gelibiaoshi}">
            <input type="hidden" id="loufangxmf_zt" name="loufangxmf_zt" value="${LoufangXMF.loufangxmf_zt}">
<div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >项目名称</span>
                            ${LoufangXMF.loufangxmf_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >项目费</span>
                            ${LoufangXMF.loufangxmf_feiyong}
                    </div>
                </div>
        </div>
    </body>
</html>

