<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加系统权限</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtquanxian/add.js"></script>
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
            <div id="divID_Tree_menu_XtQuanxian" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <input type="hidden" id="xt_quanxian_zj" name="xt_quanxian_zj" value="">
            <input type="hidden" id="xt_quanxian_fzj" name="xt_quanxian_fzj" value="">
            <input type="hidden" id="xt_quanxian_zt" name="xt_quanxian_zt" value="0">

            <div class="container"  id="XtQuanxianFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtQuanxianFormID')">保存</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >上级</span>
                        <input type="text" id="xt_quanxian_fzj_mc" name="xt_quanxian_fzj_mc" readonly="true" class="easyui-textbox">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >排序</span>
                        <input type="text"  id="xt_quanxian_px" name="xt_quanxian_px" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  id="xt_quanxian_mc" name="xt_quanxian_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >权限代码</span>
                        <input type="text"  id="xt_quanxian_dm" name="xt_quanxian_dm" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >url</span>
                        <input type="text"  id="xt_quanxian_url" name="xt_quanxian_url" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >可视</span>
                        <input type="text"  id="xt_quanxian_keshi" name="xt_quanxian_keshi" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >展开</span>
                        <input type="text"  id="xt_quanxian_zhankai" name="xt_quanxian_zhankai" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  id="xt_quanxian_bz" name="xt_quanxian_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
<!--                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >隔离标识</span>
                        <input type="text"  id="xt_quanxian_gelibiaoshi" name="xt_quanxian_gelibiaoshi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>-->
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >级别</span>
                        <select id="xt_quanxian_jibie">
                            <option value="3">用户使用-3</option>
                            <option value="2">管理员使用-2</option>
                            <option value="1">超级管理专用-1</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
