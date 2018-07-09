<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改岗位</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/gangwei/edit.js"></script>
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
        <div data-options="region:'west',split:true,title:'导航栏'" style="width:250px;padding:10px;">            <div id="divID_Tree_menu_Gangwei" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>                    <input type="hidden" id="gangwei_zj" name="gangwei_zj" value="${Gangwei.gangwei_zj}">
            <input type="hidden" id="gangwei_fzj" name="gangwei_fzj" value="${Gangwei.gangwei_fzj}">
            <input type="hidden" id="gangwei_zt" name="gangwei_zt" value="${Gangwei.gangwei_zt}">

            <div class="container"  id="GangweiFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearFather()">清空上级</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('GangweiFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="gangwei_fzj_mc" name="gangwei_fzj_mc" value="${fl_P.gangwei_mc}" readonly="true" class="easyui-textbox">
                    </div>
                </div>                            
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  value="${Gangwei.gangwei_mc}" id="gangwei_mc" name="gangwei_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <textarea rows=5  class="textarea easyui-validatebox" id="gangwei_bz" name="gangwei_bz" data-options="required:false">${Gangwei.gangwei_bz}</textarea>
                    </div>
                </div>                            
<!--                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >隔离标识</span>
                        <input type="text"  value="${Gangwei.gangwei_gelibiaoshi}" id="gangwei_gelibiaoshi" name="gangwei_gelibiaoshi" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>-->
            </div>
        </div>
    </body>
</html>

