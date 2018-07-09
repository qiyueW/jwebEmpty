<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加职位</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/zhiwei/add.js"></script>
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
            <div id="divID_Tree_menu_Zhiwei" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <div class="container"  id="ZhiweiFormID">
                <input type="hidden" id="zhiwei_zj" name="zhiwei_zj" value="">
                <input type="hidden" id="zhiwei_fzj" name="zhiwei_fzj" value="">
                <input type="hidden" id="zhiwei_zt" name="zhiwei_zt" value="0">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('ZhiweiFormID')">保存</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >上级</span>
                        <input type="text" id="zhiwei_fzj_mc" name="zhiwei_fzj_mc" readonly="true" class="easyui-textbox">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  id="zhiwei_mc" name="zhiwei_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <textarea rows=5  class="textarea easyui-validatebox" id="zhiwei_bz" name="zhiwei_bz" data-options="required:false"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
