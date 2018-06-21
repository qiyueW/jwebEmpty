<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改楼房分类</title>
        <script type="text/javascript" src="${path_home}/static/js/loufangfl/edit.js"></script>
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
        <div data-options="region:'west',split:true,title:'导航栏'" style="width:250px;padding:10px;">            <div id="divID_Tree_menu_LoufangFL" class="ztree">bean</div>
        </div>
        <input type="hidden" id="loufangfl_zt" name="loufangfl_zt" value="${LoufangFL.loufangfl_zt}">
        <div data-options="region:'center'" id='centerMain'> 
            <input type="hidden" id="loufangfl_zj" name="loufangfl_zj" value="${LoufangFL.loufangfl_zj}">
            <input type="hidden" id="loufangfl_fzj" name="loufangfl_fzj" value="${LoufangFL.loufangfl_fzj}">
            <input type="hidden" id="loufangfl_zt" name="loufangfl_zt" value="${LoufangFL.loufangfl_zt}">

            <div class="container"  id="LoufangFLFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearFather()">清空上级</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('LoufangFLFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="loufangfl_fzj_mc" name="loufangfl_fzj_mc" value="${fl_P.loufangfl_mc}" readonly="true" class="easyui-textbox">
                    </div>
                </div>                            
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >排序</span>
                        <input type="text"  value="${LoufangFL.loufangfl_px}" id="loufangfl_px" name="loufangfl_px" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  value="${LoufangFL.loufangfl_mc}" id="loufangfl_mc" name="loufangfl_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  value="${LoufangFL.loufangfl_bz}" id="loufangfl_bz" name="loufangfl_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

