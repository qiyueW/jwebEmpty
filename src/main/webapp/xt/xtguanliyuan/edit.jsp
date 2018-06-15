<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改系统管理员</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtguanliyuan/edit.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
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
        
<!--
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_XtGuanliyuan" class="ztree">bean</div>
        </div>
-->

        <div data-options="region:'center'" id='centerMain'>                    <input type="hidden" id="xt_guanliyuan_zj" name="xt_guanliyuan_zj" value="${XtGuanliyuan.xt_guanliyuan_zj}">
                    <input type="hidden" id="xt_guanliyuan_zt" name="xt_guanliyuan_zt" value="${XtGuanliyuan.xt_guanliyuan_zt}">

<div class="container"  id="XtGuanliyuanFormID">
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员名称</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_mc}" id="xt_guanliyuan_mc" name="xt_guanliyuan_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员账号</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_zhanghao}" id="xt_guanliyuan_zhanghao" name="xt_guanliyuan_zhanghao" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员密码</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_mima}" id="xt_guanliyuan_mima" name="xt_guanliyuan_mima" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员邮箱</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_youxiang}" id="xt_guanliyuan_youxiang" name="xt_guanliyuan_youxiang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >管理员备注</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_bz}" id="xt_guanliyuan_bz" name="xt_guanliyuan_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >管理员权限集合</span>
                            <textarea rows=5  class="textarea easyui-validatebox" id="xt_guanliyuan_quanxian" name="xt_guanliyuan_quanxian" data-options="required:false">${XtGuanliyuan.xt_guanliyuan_quanxian}</textarea>
                    </div>
                </div>                            
                 <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >管理员部门集合</span>
                            <textarea rows=5  class="textarea easyui-validatebox" id="xt_guanliyuan_bm" name="xt_guanliyuan_bm" data-options="required:false">${XtGuanliyuan.xt_guanliyuan_bm}</textarea>
                    </div>
                </div>                            
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >隔离标识</span>
                        <input type="text"  value="${XtGuanliyuan.xt_guanliyuan_gelibiaoshi}" id="xt_guanliyuan_gelibiaoshi" name="xt_guanliyuan_gelibiaoshi" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

