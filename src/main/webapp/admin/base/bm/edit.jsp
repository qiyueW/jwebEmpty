<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改部门管理</title>
        <script type="text/javascript" src="${path_home}/static/js/bm/edit.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <link rel="stylesheet" type="text/css" href="${path_home}/lib/webuploader/0.1.5/webuploader.css">
        <script type="text/javascript" src="${path_home}/lib/webuploader/0.1.5/webuploader.min.js"></script> 
        <script type="text/javascript" src="${path_home}/lib/webuploader/webuploader.js"></script> 
        <script>
            $(function () {
                inido();
                upOneImgByAotu('${path_home}/base/bm/up/img.jw', '#bm_tupian1_choose', function (file, res) {
                    $('#bm_tupian1').val(res.path_fileName);
                    $('#bm_tupian1FN').textbox('setValue', res.fileName);
                });
                upOneImgByAotu('${path_home}/base/bm/up/img.jw', '#bm_tupian2_choose', function (file, res) {
                    $('#bm_tupian2').val(res.path_fileName);
                    $('#bm_tupian2FN').textbox('setValue', res.fileName);
                });
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
        <div data-options="region:'west',split:true,title:'导航栏'" style="width:250px;padding:10px;">            <div id="divID_Tree_menu_BM" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>                    <input type="hidden" id="bm_zj" name="bm_zj" value="${BM.bm_zj}">
            <input type="hidden" id="bm_fzj" name="bm_fzj" value="${BM.bm_fzj}">
            <input type="hidden" id="bm_fuzhiren_zj" name="bm_fuzhiren_zj" value="${BM.bm_fuzhiren_zj}">
            <input type="hidden" id="bm_zt" name="bm_zt" value="${BM.bm_zt}">
            <input type="hidden"  value="${BM.bm_gelibiaoshi}" id="bm_gelibiaoshi"/>
            <div class="container"  id="BMFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearFather()">清空上级</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('BMFormID')">保存修改</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">上级</span>
                        <input type="text" id="bm_fzj_mc" name="bm_fzj_mc" value="${fl_P.bm_mc}" readonly="true" class="easyui-textbox">
                    </div>
                </div>                            
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  value="${BM.bm_mc}" id="bm_mc" name="bm_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >编码</span>
                        <input type="text" readonly="true" value="${BM.bm_bianma}" id="bm_bianma" name="bm_bianma" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门简介</span>
                        <textarea rows=5  class="textarea easyui-validatebox" id="bm_jianjie" name="bm_jianjie" data-options="required:false">${BM.bm_jianjie}</textarea>
                    </div>
                </div>                            
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">
                            <div id="bm_tupian1_choose">部门图片1<input type="hidden"  id="bm_tupian1" value="${BM.bm_tupian1}"/></div>
                        </span>
                        <div id="bm_tupian1uploader">
                            <div id="thelist" class="uploader-list"></div>
                            <input type="text" id="bm_tupian1FN"  readonly="true" class="easyui-textbox"  value="${fn:substring(BM.bm_tupian1,37,fn:length(BM.bm_tupian1))}">
                        </div>
                    </div>
                </div>                
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">
                            <div id="bm_tupian2_choose">部门图片2<input type="hidden"  id="bm_tupian2" value="${BM.bm_tupian2}"/></div>
                        </span>
                        <div id="bm_tupian2uploader">
                            <div id="thelist" class="uploader-list"></div>
                            <input type="text" id="bm_tupian2FN"  readonly="true" class="easyui-textbox"  value="${fn:substring(BM.bm_tupian2,37,fn:length(BM.bm_tupian2))}">
                        </div>
                    </div>
                </div>                
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门负责人</span>
                        <input type="text"  value="${BM.bm_fuzhiren}" id="bm_fuzhiren" name="bm_fuzhiren" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

