<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加楼房分类</title>
        <script type="text/javascript" src="${path_home}/static/js/loufangfl/add.js"></script>
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
            <div id="divID_Tree_menu_LoufangFL" class="ztree">bean</div>
        </div>
        <input type="hidden" id="loufangfl_zt" name="loufangfl_zt" value="0">
        <div data-options="region:'center'" id='centerMain'>
            <div class="container"  id="LoufangFLFormID">
                <input type="hidden" id="loufangfl_zj" name="loufangfl_zj" value="">
                <input type="hidden" id="loufangfl_fzj" name="loufangfl_fzj" value="">

                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('LoufangFLFormID')">保存</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >上级</span>
                        <input type="text" id="loufangfl_fzj_mc" name="loufangfl_fzj_mc" readonly="true" class="easyui-textbox">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >排序</span>
                        <input type="text"  id="loufangfl_px" name="loufangfl_px" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  id="loufangfl_mc" name="loufangfl_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  id="loufangfl_bz" name="loufangfl_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
