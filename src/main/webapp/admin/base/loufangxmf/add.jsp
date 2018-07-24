<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加楼房项目费</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/loufangxmf/add.js"></script>
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
            <div id="divID_Tree_menu_LoufangXMF" class="ztree">bean</div>
        </div>
-->
        <div data-options="region:'center'" id='centerMain'>
                    <input type="hidden" id="loufangxmf_zj" name="loufangxmf_zj" value="">
                    <input type="hidden" id="loufangxmf_gelibiaoshi" name="loufangxmf_gelibiaoshi" value="">
                    <input type="hidden" id="loufangxmf_zt" name="loufangxmf_zt" value="0">

<div class="container"  id="LoufangXMFFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('LoufangXMFFormID')">保存</a>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >项目名称</span>
                        <input type="text"  id="loufangxmf_mc" name="loufangxmf_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >项目费</span>
                        <input type="text"  id="loufangxmf_feiyong" name="loufangxmf_feiyong" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
