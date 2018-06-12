<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改系统角色</title>
        <script type="text/javascript" src="${path_home}/xt/js/xtjuese/edit.js"></script>
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
        <div data-options="region:'west',split:true,title:'导航栏'" style="width:250px;padding:10px;">            <div id="divID_Tree_menu_XtJuese" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>                    <input type="hidden" id="xt_juese_zj" name="xt_juese_zj" value="${XtJuese.xt_juese_zj}">
                    <input type="hidden" id="xt_juese_fzj" name="xt_juese_fzj" value="${XtJuese.xt_juese_fzj}">
                    <input type="hidden" id="xt_juese_zt" name="xt_juese_zt" value="${XtJuese.xt_juese_zt}">
                    <input type="hidden" id="xt_juese_zhidanren_zj" name="xt_juese_zhidanren_zj" value="${XtJuese.xt_juese_zhidanren_zj}">
                    <input type="hidden" id="xt_juese_xiugairen_zj" name="xt_juese_xiugairen_zj" value="${XtJuese.xt_juese_xiugairen_zj}">

<div class="container"  id="XtJueseFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearFather()">清空上级</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('XtJueseFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="xt_juese_fzj_mc" name="xt_juese_fzj_mc" value="${fl_P.xt_juese_mc}" readonly="true" class="easyui-textbox">
                    </div>
                </div>                            
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  value="${XtJuese.xt_juese_mc}" id="xt_juese_mc" name="xt_juese_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >代码</span>
                        <input type="text"  value="${XtJuese.xt_juese_dm}" id="xt_juese_dm" name="xt_juese_dm" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >公私角色</span>
                        <input type="text"  value="${XtJuese.xt_juese_gongsi}" id="xt_juese_gongsi" name="xt_juese_gongsi" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  value="${XtJuese.xt_juese_bz}" id="xt_juese_bz" name="xt_juese_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >隔离标识</span>
                        <input type="text"  value="${XtJuese.xt_juese_gelibiaoshi}" id="xt_juese_gelibiaoshi" name="xt_juese_gelibiaoshi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >制单人</span>
                        <input type="text"  value="${XtJuese.xt_juese_zhidanren}" id="xt_juese_zhidanren" name="xt_juese_zhidanren" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >修改人</span>
                        <input type="text"  value="${XtJuese.xt_juese_xiugairen}" id="xt_juese_xiugairen" name="xt_juese_xiugairen" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >修改时间</span>
                            <input class="easyui-datebox" type="text"  id="xt_juese_xiugaishijian" value="${XtJuese.xt_juese_xiugaishijian}" name="xt_juese_xiugaishijian" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>                            
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

