<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>添加人员管理</title>
        <script type="text/javascript" src="${path_home}/static/js/ry/add.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%--<%@include file="/WEB-INF/jspf/artDialog.jspf"%>--%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <link rel="stylesheet" type="text/css" href="${path_home}/lib/webuploader/0.1.5/webuploader.css">
        <script type="text/javascript" src="${path_home}/lib/webuploader/0.1.5/webuploader.min.js"></script> 
        <script type="text/javascript" src="${path_home}/lib/webuploader/webuploader.js"></script> 
        <script>
            $(function () {
                inidoAdd();
                upOneImgByAotu('${path_home}/base/ry/up/file.jw', '#ry_tupian_choose', function (file, res) {
                    $('#ry_tupian').val(res.path_fileName);
                    $('#ry_tupianFN').textbox('setValue', res.fileName);
                });
                upOneImgByAotu('${path_home}/base/ry/up/file.jw', '#ry_tupian_zhengjian1_choose', function (file, res) {
                    $('#ry_tupian_zhengjian1').val(res.path_fileName);
                    $('#ry_tupian_zhengjian1FN').textbox('setValue', res.fileName);
                });
                upOneImgByAotu('${path_home}/base/ry/up/file.jw', '#ry_tupian_zhengjian2_choose', function (file, res) {
                    $('#ry_tupian_zhengjian2').val(res.path_fileName);
                    $('#ry_tupian_zhengjian2FN').textbox('setValue', res.fileName);
                });
            });
        </script>
        <style>
            .row-fluid{
                margin: 5px;
            }
            .row-fluid input{
                height: 40px;
                width: 380px;
            }
            .row-fluid textarea{
                width: 380px;
            }
            .myname{
                display:block;
                width: 380px;
                background-color: #ebfceb
            }
        </style>  
    </head>
    <body class="easyui-layout">
        <div data-options="region:'north'" style="height:60px;">
            <div style=" margin-top: 15px;">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearForm()">清空</a>
                <a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-save" onclick="submitForm('RYFormID')">保存</a>
            </div>
        </div>
        <div data-options="region:'center'" class="easyui-tabs" id="RYFormID">
            <div title="基本信息">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门</span>
                        <input  id="ry_bm_zj" class="easyui-combotree"
                                data-options="
                                required:true
                                ,url:'${path_home}/base/bm/select/json2.jw'
                                ,editable:true
                                ,onHidePanel:f_onHidePanel_combotree
                                ">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >人员名称</span>
                        <input type="text"  id="ry_mc" name="ry_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >账号</span>
                        <input type="text"  id="ry_zhanghao" name="ry_zhanghao" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >密码</span>
                        <input type="text"  id="ry_mima" name="ry_mima" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >性别</span>
                        <!--<input type="text"  id="ry_xingbie" name="ry_xingbie" data-options="required:true" class="easyui-textbox"/>-->
                        <select id="ry_xingbie" name="ry_xingbie" data-options="required:true" class="myname" style=" height:30px;">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >入职日期</span>
                        <input class="easyui-datebox" type="text"  id="ry_ruzhiriqi" name="ry_ruzhiriqi" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >岗位</span>
                        <input  id="ry_gangwei_zj" class="easyui-combotree"
                                data-options="
                                required:false
                                ,url:'${path_home}/base/gangwei/select/json2.jw'
                                ,editable:true
                                ,onHidePanel:f_onHidePanel_combotree
                                ">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >职位</span>
                        <!--<input type="text"  id="ry_zhiwei" name="ry_zhiwei" data-options="required:false" class="easyui-textbox"/>-->
                        <input  id="ry_zhiwei_zj" class="easyui-combotree"
                                data-options="
                                required:false
                                ,url:'${path_home}/base/zhiwei/select/json2.jw'
                                ,editable:true
                                ,onHidePanel:f_onHidePanel_combotree
                                ">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >备注</span>
                        <input type="text"  id="ry_bz" name="ry_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="基本信息2">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >出生日期</span>
                        <input class="easyui-datebox" type="text"  id="ry_chushengriqi" name="ry_chushengriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >籍贯</span>
                        <input type="text"  id="ry_jiguan" name="ry_jiguan" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >手机1</span>
                        <input type="text"  id="ry_shouji1" name="ry_shouji1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >邮箱</span>
                        <input type="text"  id="ry_youxiang" name="ry_youxiang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >婚姻状态</span>
                        <input type="text"  id="ry_hunyin" name="ry_hunyin" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >离职日期</span>
                        <input class="easyui-datebox" type="text"  id="ry_lizhiriqi" name="ry_lizhiriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="基本信息3">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >现住地址</span>
                        <input type="text"  id="ry_xianzhudizhi" name="ry_xianzhudizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >家庭地址</span>
                        <input type="text"  id="ry_jiatingdizhi" name="ry_jiatingdizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >紧急联系人</span>
                        <input type="text"  id="ry_jinjilianxiren" name="ry_jinjilianxiren" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >紧急联系人电话</span>
                        <input type="text"  id="ry_jinjilianxiren_dianhua" name="ry_jinjilianxiren_dianhua" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >固定电话1</span>
                        <input type="text"  id="ry_gudingdianhua1" name="ry_gudingdianhua1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >固定电话2</span>
                        <input type="text"  id="ry_gudingdianhua2" name="ry_gudingdianhua2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="身份识别类">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >身份证号码</span>
                        <input type="text"  id="ry_shenfenzheng" name="ry_shenfenzheng" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
            </div>
            <div title="人员通信">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信</span>
                        <input type="text"  id="ry_qitatongxing" name="ry_qitatongxing" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信1</span>
                        <input type="text"  id="ry_qitatongxing1" name="ry_qitatongxing1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信2</span>
                        <input type="text"  id="ry_qitatongxing2" name="ry_qitatongxing2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信3</span>
                        <input type="text"  id="ry_qitatongxing3" name="ry_qitatongxing3" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信4</span>
                        <input type="text"  id="ry_qitatongxing4" name="ry_qitatongxing4" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信5</span>
                        <input type="text"  id="ry_qitatongxing5" name="ry_qitatongxing5" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="人员通信2">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信1</span>
                        <input type="text"  id="ry_neibutongxing1" name="ry_neibutongxing1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信2</span>
                        <input type="text"  id="ry_neibutongxing2" name="ry_neibutongxing2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信3</span>
                        <input type="text"  id="ry_neibutongxing3" name="ry_neibutongxing3" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信4</span>
                        <input type="text"  id="ry_neibutongxing4" name="ry_neibutongxing4" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信5</span>
                        <input type="text"  id="ry_neibutongxing5" name="ry_neibutongxing5" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信6</span>
                        <input type="text"  id="ry_neibutongxing6" name="ry_neibutongxing6" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信7</span>
                        <input type="text"  id="ry_neibutongxing7" name="ry_neibutongxing7" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信8</span>
                        <input type="text"  id="ry_neibutongxing8" name="ry_neibutongxing8" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信9</span>
                        <input type="text"  id="ry_neibutongxing9" name="ry_neibutongxing9" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信10</span>
                        <input type="text"  id="ry_neibutongxing10" name="ry_neibutongxing10" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
        </div>
        <div data-options="region:'west',title:'图片处理区'" style="width:400px;">
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname">
                        <div id="ry_tupian_choose">图片<input type="hidden"  id="ry_tupian" /></div>
                    </span>
                    <div id="ry_tupianuploader">
                        <div id="thelist" class="uploader-list"></div>
                        <input type="text" id="ry_tupianFN"  readonly="true" class="easyui-textbox">
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname">
                        <div id="ry_tupian_zhengjian1_choose">证件图_正面<input type="hidden"  id="ry_tupian_zhengjian1" /></div>
                    </span>
                    <div id="ry_tupian_zhengjian1uploader">
                        <div id="thelist" class="uploader-list"></div>
                        <input type="text" id="ry_tupian_zhengjian1FN"  readonly="true" class="easyui-textbox">
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <span class="myname">
                        <div id="ry_tupian_zhengjian2_choose">证件图_反面<input type="hidden"  id="ry_tupian_zhengjian2" /></div>
                    </span>
                    <div id="ry_tupian_zhengjian2uploader">
                        <div id="thelist" class="uploader-list"></div>
                        <input type="text" id="ry_tupian_zhengjian2FN"  readonly="true" class="easyui-textbox">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
