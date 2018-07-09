<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改职位</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/zhiwei/edit.js"></script>
        <script>
            $(function () {
                inido();
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
        <div data-options="region:'west',split:true,title:'导航栏'" style="width:250px;padding:10px;">            <div id="divID_Tree_menu_Zhiwei" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>                    <input type="hidden" id="zhiwei_zj" name="zhiwei_zj" value="${Zhiwei.zhiwei_zj}">
            <input type="hidden" id="zhiwei_fzj" name="zhiwei_fzj" value="${Zhiwei.zhiwei_fzj}">
            <input type="hidden" id="zhiwei_zt" name="zhiwei_zt" value="${Zhiwei.zhiwei_zt}">

            <div class="container"  id="ZhiweiFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearFather()">清空上级</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('ZhiweiFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="zhiwei_fzj_mc" name="zhiwei_fzj_mc" value="${fl_P.zhiwei_mc}" readonly="true" class="easyui-textbox">
                    </div>
                </div>                            
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  value="${Zhiwei.zhiwei_mc}" id="zhiwei_mc" name="zhiwei_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <textarea rows=5  class="textarea easyui-validatebox" id="zhiwei_bz" name="zhiwei_bz" data-options="required:false">${Zhiwei.zhiwei_bz}</textarea>
                    </div>
                </div>                            
            </div>
        </div>
    </body>
</html>

