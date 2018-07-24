<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改楼房项目费</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/loufangxmf/edit.js"></script>
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
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="loufangxmf_zj" name="loufangxmf_zj" value="${LoufangXMF.loufangxmf_zj}">
            <input type="hidden" id="loufangxmf_gelibiaoshi" name="loufangxmf_gelibiaoshi" value="${LoufangXMF.loufangxmf_gelibiaoshi}">
            <input type="hidden" id="loufangxmf_zt" name="loufangxmf_zt" value="${LoufangXMF.loufangxmf_zt}">

            <div class="container"  id="LoufangXMFFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtGuanliyuanFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >项目名称</span>
                        <input type="text"  value="${LoufangXMF.loufangxmf_mc}" id="loufangxmf_mc" name="loufangxmf_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >项目费</span>
                        <input type="text"  value="${LoufangXMF.loufangxmf_feiyong}" id="loufangxmf_feiyong" name="loufangxmf_feiyong" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

