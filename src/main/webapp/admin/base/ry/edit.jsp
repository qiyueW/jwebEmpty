<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>修改人员管理</title>
        <script type="text/javascript" src="${path_home}/static/js/ry/edit.js"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%--<%@include file="/WEB-INF/jspf/boostrap.jspf"%>--%>
        <%--<%@include file="/WEB-INF/jspf/artDialog.jspf"%>--%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <link rel="stylesheet" type="text/css" href="${path_home}/lib/webuploader/0.1.5/webuploader.css">
        <script type="text/javascript" src="${path_home}/lib/webuploader/0.1.5/webuploader.min.js"></script> 
        <script type="text/javascript" src="${path_home}/lib/webuploader/webuploader.js"></script> 
        <script>
            $(function () {
                upOneImgByAotu('${path_home}/base/ry/up/file.jw', '#ry_tupian_choose', function (file, res) {
                    $('#ry_tupian').val(res.path_fileName);
                    $('#ry_tupianFN').val(res.fileName);
                });
                upOneImgByAotu('${path_home}/base/ry/up/file.jw', '#ry_tupian_zhengjian1_choose', function (file, res) {
                    $('#ry_tupian_zhengjian1').val(res.path_fileName);
                    $('#ry_tupian_zhengjian1FN').val(res.fileName);
                });
                upOneImgByAotu('${path_home}/base/ry/up/file.jw', '#ry_tupian_zhengjian2_choose', function (file, res) {
                    $('#ry_tupian_zhengjian2').val(res.path_fileName);
                    $('#ry_tupian_zhengjian2FN').val(res.fileName);
                });
            });
        </script>
        <style>
            .row-fluid{
                margin: 6px;
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
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"  onclick="closeMySelf()">关闭</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save"  onclick="submitForm('XtGuanliyuanFormID')">保存修改</a>
            </div>
            <input type="hidden" id="ry_zj" name="ry_zj" value="${RY.ry_zj}">
            <input type="hidden"  id="ry_mima" value="ababaabababababab" name="ry_mima" data-options="required:true" class="easyui-textbox"/>
        </div>
        <div data-options="region:'center'" class="easyui-tabs"  id="RYFormID">
            <div title="基本信息" fit='true'>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门</span>
                        <input  id="ry_bm_zj" class="easyui-combotree" value="${RY.ry_bm_zj}"
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
                        <input type="text" value="${RY.ry_mc}" id="ry_mc" name="ry_mc" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >账号</span>
                        <input type="text"  value="${RY.ry_zhanghao}"id="ry_zhanghao" readonly="true" name="ry_zhanghao" data-options="required:true" class="easyui-textbox"/>
                    </div>
                </div>
                <!--                        <div class="row-fluid">
                                            <div class="span12">
                                                <span class="myname" >密码</span>
                                                <input type="password"  id="ry_mima" name="ry_mima" data-options="required:true" class="easyui-textbox"/>
                                            </div>
                                        </div>-->
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >性别</span>
                        <select id="ry_xingbie" name="ry_xingbie" data-options="required:true" class="myname" style=" height:30px;">
                            <option value="男" ${RY.ry_xingbie eq '男'?'selected':''}>男</option>
                            <option value="女" ${RY.ry_xingbie eq '女'?'selected':''}>女</option>
                        </select>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >入职日期</span>
                        <input class="easyui-datebox" type="text" value="${RY.ry_ruzhiriqi}" id="ry_ruzhiriqi" name="ry_ruzhiriqi" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >岗位</span>
                        <input  value="${RY.ry_gangwei_zj}"id="ry_gangwei_zj" class="easyui-combotree"
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
                        <input  value="${RY.ry_zhiwei_zj}" id="ry_zhiwei_zj" class="easyui-combotree"
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
                        <input type="text" value="${RY.ry_bz}" id="ry_bz" name="ry_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="基本信息2">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >出生日期</span>
                        <input class="easyui-datebox" value="${RY.ry_chushengriqi}"type="text"  id="ry_chushengriqi" name="ry_chushengriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >籍贯</span>
                        <input type="text" value="${RY.ry_jiguan}" id="ry_jiguan" name="ry_jiguan" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >手机1</span>
                        <input type="text"  value="${RY.ry_shouji1}"  id="ry_shouji1" name="ry_shouji1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >邮箱</span>
                        <input type="text" value="${RY.ry_youxiang}"  id="ry_youxiang" name="ry_youxiang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >婚姻状态</span>
                        <input type="text"  value="${RY.ry_hunyin}"  id="ry_hunyin" name="ry_hunyin" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >离职日期</span>
                        <input class="easyui-datebox" value="${RY.ry_lizhiriqi}" type="text"  id="ry_lizhiriqi" name="ry_lizhiriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="基本信息3">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >现住地址</span>
                        <input type="text"  value="${RY.ry_xianzhudizhi}" id="ry_xianzhudizhi" name="ry_xianzhudizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >家庭地址</span>
                        <input type="text"  value="${RY.ry_jiatingdizhi}" id="ry_jiatingdizhi" name="ry_jiatingdizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >紧急联系人</span>
                        <input type="text"  value="${RY.ry_jinjilianxiren}"id="ry_jinjilianxiren" name="ry_jinjilianxiren" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >紧急联系人电话</span>
                        <input type="text"  value="${RY.ry_jinjilianxiren_dianhua}"id="ry_jinjilianxiren_dianhua" name="ry_jinjilianxiren_dianhua" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >固定电话1</span>
                        <input type="text" value="${RY.ry_gudingdianhua1}" id="ry_gudingdianhua1" name="ry_gudingdianhua1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >固定电话2</span>
                        <input type="text"  value="${RY.ry_gudingdianhua2}"id="ry_gudingdianhua2" name="ry_gudingdianhua2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="图片识别类">

                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >身份证号码</span>
                        <input type="text" value="${RY.ry_shenfenzheng}" id="ry_shenfenzheng" name="ry_shenfenzheng" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <br/><br/>
            </div>
            <div title="人员通信">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信</span>
                        <input type="text"  value="${RY.ry_qitatongxing}" id="ry_qitatongxing" name="ry_qitatongxing" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信1</span>
                        <input type="text"  value="${RY.ry_qitatongxing1}" id="ry_qitatongxing1" name="ry_qitatongxing1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信2</span>
                        <input type="text"  value="${RY.ry_qitatongxing2}" id="ry_qitatongxing2" name="ry_qitatongxing2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信3</span>
                        <input type="text"  value="${RY.ry_qitatongxing3}" id="ry_qitatongxing3" name="ry_qitatongxing3" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信4</span>
                        <input type="text"  value="${RY.ry_qitatongxing4}" id="ry_qitatongxing4" name="ry_qitatongxing4" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >其他通信5</span>
                        <input type="text"  value="${RY.ry_qitatongxing5}" id="ry_qitatongxing5" name="ry_qitatongxing5" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <br/><br/>
            </div>
            <div title="人员通信2">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信1</span>
                        <input type="text"  value="${RY.ry_neibutongxing1}" id="ry_neibutongxing1" name="ry_neibutongxing1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信2</span>
                        <input type="text"  value="${RY.ry_neibutongxing2}" id="ry_neibutongxing2" name="ry_neibutongxing2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信3</span>
                        <input type="text"  value="${RY.ry_neibutongxing3}" id="ry_neibutongxing3" name="ry_neibutongxing3" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信4</span>
                        <input type="text"  value="${RY.ry_neibutongxing4}" id="ry_neibutongxing4" name="ry_neibutongxing4" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信5</span>
                        <input type="text"  value="${RY.ry_neibutongxing5}" id="ry_neibutongxing5" name="ry_neibutongxing5" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信6</span>
                        <input type="text"  value="${RY.ry_neibutongxing6}" id="ry_neibutongxing6" name="ry_neibutongxing6" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信7</span>
                        <input type="text"  value="${RY.ry_neibutongxing7}" id="ry_neibutongxing7" name="ry_neibutongxing7" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信8</span>
                        <input type="text"  value="${RY.ry_neibutongxing8}" id="ry_neibutongxing8" name="ry_neibutongxing8" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信9</span>
                        <input type="text"  value="${RY.ry_neibutongxing9}" id="ry_neibutongxing9" name="ry_neibutongxing9" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >内部通信10</span>
                        <input type="text"  value="${RY.ry_neibutongxing10}" id="ry_neibutongxing10" name="ry_neibutongxing10" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <br/><br/>
            </div>
        </div>
        <div data-options="region:'west',title:'图片处理区'" style="width:400px;">
            <div>
                <div class="row-fluid">
                    <span class="myname">
                        <div id="ry_tupian_choose">图片<input type="hidden"  id="ry_tupian" value="${RY.ry_tupian}"/></div>
                    </span>
                    <div id="ry_tupianuploader">
                        <div id="thelist" class="uploader-list"></div>
                        <input type="text" id="ry_tupianFN"  value="${fn:substring(RY.ry_tupian,37,fn:length(RY.ry_tupian))}">
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">
                            <div id="ry_tupian_zhengjian1_choose">证件图_正面<input type="hidden"  id="ry_tupian_zhengjian1" value="${RY.ry_tupian_zhengjian1}"/></div>
                        </span>
                        <div id="ry_tupian_zhengjian1uploader">
                            <div id="thelist" class="uploader-list"></div>
                            <input type="text" id="ry_tupian_zhengjian1FN"  value="${fn:substring(RY.ry_tupian_zhengjian1,37,fn:length(RY.ry_tupian_zhengjian1))}">
                        </div>
                    </div>
                </div>                
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">
                            <div id="ry_tupian_zhengjian2_choose">证件图_反面<input type="hidden"  id="ry_tupian_zhengjian2" value="${RY.ry_tupian_zhengjian2}"/></div>
                        </span>
                        <div id="ry_tupian_zhengjian2uploader">
                            <div id="thelist" class="uploader-list"></div>
                            <input type="text" id="ry_tupian_zhengjian2FN"   value="${fn:substring(RY.ry_tupian_zhengjian2,37,fn:length(RY.ry_tupian_zhengjian2))}">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

