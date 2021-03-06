<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加部门管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/bm/add.js"></script>
        <link rel="stylesheet" type="text/css" href="${path_home}/lib/webuploader/0.1.5/webuploader.css">
        <script type="text/javascript" src="${path_home}/lib/webuploader/0.1.5/webuploader.min.js"></script> 
        <script type="text/javascript" src="${path_home}/lib/webuploader/webuploader.js"></script> 
        <script>
            $(function () {
                inidoAdd();
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
        <input type="hidden" id="bm_zt" name="bm_zt" value="0">
        <input type="hidden"  id="bm_gelibiaoshi" name="bm_gelibiaoshi" value="111"/>
        <div data-options="region:'west',split:true,title:''" style="width:250px;padding:10px;">
            <div id="divID_Tree_menu_BM" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <div class="container"  id="BMFormID">
                <input type="hidden" id="bm_zj" name="bm_zj" value="">
                <input type="hidden" id="bm_fzj" name="bm_fzj" value="">
                <input type="hidden" id="bm_fuzhiren_zj" name="bm_fuzhiren_zj" value="">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('BMFormID')">保存</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >上级</span>
                        <input type="text" id="bm_fzj_mc" name="bm_fzj_mc" readonly="true" class="easyui-textbox">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >名称</span>
                        <input type="text"  id="bm_mc" name="bm_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >编码</span>
                        <input type="text"  id="bm_bianma" name="bm_bianma" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门简介</span>
                        <textarea rows=5  class="textarea easyui-validatebox" id="bm_jianjie" name="bm_jianjie" data-options="required:false"></textarea>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">
                            <div id="bm_tupian1_choose">部门图片1<input type="hidden"  id="bm_tupian1" /></div>
                        </span>
                        <div id="bm_tupian1uploader">
                            <div id="thelist" class="uploader-list"></div>
                            <input type="text" id="bm_tupian1FN"  readonly="true" class="easyui-textbox">
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">
                            <div id="bm_tupian2_choose">部门图片2<input type="hidden"  id="bm_tupian2" /></div>
                        </span>
                        <div id="bm_tupian2uploader">
                            <div id="thelist" class="uploader-list"></div>
                            <input type="text" id="bm_tupian2FN"  readonly="true" class="easyui-textbox">
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门负责人</span>
                        <input type="text"  id="bm_fuzhiren" name="bm_fuzhiren" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
