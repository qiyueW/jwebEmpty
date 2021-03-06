<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加楼房纳费</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/static/js/loufangnafei/add.js"></script>
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
            <div id="divID_Tree_menu_LoufangNafei" class="ztree">bean</div>
        </div>
-->
        <div data-options="region:'center'" id='centerMain'>
                    <input type="hidden" id="loufangnafei_zj" name="loufangnafei_zj" value="">
                    <input type="hidden" id="loufangnafei_lou_zj" name="loufangnafei_lou_zj" value="">
                    <input type="hidden" id="loufangnafei_fang_zj" name="loufangnafei_fang_zj" value="">
                    <input type="hidden" id="loufangnafei_gelibiaoshi" name="loufangnafei_gelibiaoshi" value="">
                    <input type="hidden" id="loufangnafei_ren_zj" name="loufangnafei_ren_zj" value="">
                    <input type="hidden" id="loufangnafei_feiyong_shui_zj" name="loufangnafei_feiyong_shui_zj" value="">
                    <input type="hidden" id="loufangnafei_feiyong_dian_zj" name="loufangnafei_feiyong_dian_zj" value="">
                    <input type="hidden" id="loufangnafei_feiyong_xm_zj" name="loufangnafei_feiyong_xm_zj" value="">
                    <input type="hidden" id="loufangnafei_feiyong_meiqi_zj" name="loufangnafei_feiyong_meiqi_zj" value="">
                    <input type="hidden" id="loufangnafei_zt" name="loufangnafei_zt" value="0">

<div class="container"  id="LoufangNafeiFormID">
                <div class="row-fluid">
                    <div class="span12">
                        <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="clearForm()">清空</a>
                        <a href="javascript:void(0)" class="btn btn-primary btn-large" onclick="submitForm('LoufangNafeiFormID')">保存</a>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >楼名称</span>
                        <input type="text"  id="loufangnafei_lou_mc" name="loufangnafei_lou_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >房编码</span>
                        <input type="text"  id="loufangnafei_fang_bianma" name="loufangnafei_fang_bianma" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >纳费人</span>
                        <input type="text"  id="loufangnafei_ren" name="loufangnafei_ren" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >应纳日期</span>
                        <input class="easyui-datebox" type="text"  id="loufangnafei_yingnariqi" name="loufangnafei_yingnariqi" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >纳费日期</span>
                        <input class="easyui-datebox" type="text"  id="loufangnafei_nafeiriqi" name="loufangnafei_nafeiriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >总费用</span>
                        <input type="text"  id="loufangnafei_zongfeiyong" name="loufangnafei_zongfeiyong" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >已纳费用</span>
                        <input type="text"  id="loufangnafei_zongfeiyong2" name="loufangnafei_zongfeiyong2" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >房租</span>
                        <input type="text"  id="loufangnafei_fangzu" name="loufangnafei_fangzu" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >水费</span>
                        <input type="text"  id="loufangnafei_feiyong_shui" name="loufangnafei_feiyong_shui" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >电费</span>
                        <input type="text"  id="loufangnafei_feiyong_dian" name="loufangnafei_feiyong_dian" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >项目费</span>
                        <input type="text"  id="loufangnafei_feiyong_xm" name="loufangnafei_feiyong_xm" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                 <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >煤气费</span>
                        <input type="text"  id="loufangnafei_feiyong_meiqi" name="loufangnafei_feiyong_meiqi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
