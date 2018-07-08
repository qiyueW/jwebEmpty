<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加系统辅管员</title>
                <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/xt/js/xtguanliyuan/add2.js"></script>
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
<!--
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_XtGuanliyuan" class="ztree">bean</div>
        </div>
-->
        <div data-options="region:'center'" id='centerMain'>
                    <input type="hidden" id="xt_guanliyuan_zj" name="xt_guanliyuan_zj" value="">
                    <input type="hidden" id="xt_guanliyuan_zt" name="xt_guanliyuan_zt" value="0">

<div class="container"  id="XtGuanliyuanFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtGuanliyuanFormID')">保存</a>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >辅管员名称</span>
                        <input type="text"  id="xt_guanliyuan_mc" name="xt_guanliyuan_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >辅管员账号</span>
                        <input type="text"  id="xt_guanliyuan_zhanghao" name="xt_guanliyuan_zhanghao" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >辅管员密码</span>
                        <input type="text"  id="xt_guanliyuan_mima" name="xt_guanliyuan_mima" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >辅管员邮箱</span>
                        <input type="text"  id="xt_guanliyuan_youxiang" name="xt_guanliyuan_youxiang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >辅管员备注</span>
                        <input type="text"  id="xt_guanliyuan_bz" name="xt_guanliyuan_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
