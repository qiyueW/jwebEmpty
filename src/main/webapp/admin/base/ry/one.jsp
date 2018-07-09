<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-人员管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script>
            function closeMySelf() {
                window.parent.closethisWindowSeeOne();//调取aa函数
            }
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
        <input type="hidden" id="ry_zj" name="ry_zj" value="${RY.ry_zj}">
        <input type="hidden" id="ry_bm_zj" name="ry_bm_zj" value="${RY.ry_bm_zj}">
        <input type="hidden" id="ry_gangwei_zj" name="ry_gangwei_zj" value="${RY.ry_gangwei_zj}">
        <input type="hidden" id="ry_zhiwei_zj" name="ry_zhiwei_zj" value="${RY.ry_zhiwei_zj}">
        <input type="hidden" id="ry_zhidanren_zj" name="ry_zhidanren_zj" value="${RY.ry_zhidanren_zj}">

        <div style=" margin:8px;">
            <a href="javascript:void(0)" class="btn btn-default btn-large" onclick="closeMySelf()">关闭</a>
        </div>
        <div class="easyui-tabs" fit="true"  id="RYFormID">
            <div title="基本信息">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >部门</span>
                        <input  id="ry_bm_zj" class="easyui-combotree" value="${RY.ry_bm_zj}" readonly="true"
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
                        <input type="text" readonly="true" value="${RY.ry_mc}" id="ry_mc" name="ry_mc" data-options="required:true" class="easyui-textbox"/>
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
                        <select id="ry_xingbie" readonly="true" name="ry_xingbie" data-options="required:true" class="myname" style=" height:30px;">
                            <option value="男" ${RY.ry_xingbie eq '男'?'selected':''}>男</option>
                            <option value="女" ${RY.ry_xingbie eq '女'?'selected':''}>女</option>
                        </select>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >入职日期</span>
                        <input class="easyui-datebox"  readonly="true"type="text" value="${RY.ry_ruzhiriqi}" id="ry_ruzhiriqi" name="ry_ruzhiriqi" data-options="required:true,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >岗位</span>
                        <input  readonly="true" value="${RY.ry_gangwei_zj}"id="ry_gangwei_zj" class="easyui-combotree"
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
                        <input  readonly="true" value="${RY.ry_zhiwei_zj}" id="ry_zhiwei_zj" class="easyui-combotree"
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
                        <input type="text"  readonly="true" value="${RY.ry_bz}" id="ry_bz" name="ry_bz" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="基本信息2">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >出生日期</span>
                        <input class="easyui-datebox"  readonly="true" value="${RY.ry_chushengriqi}"type="text"  id="ry_chushengriqi" name="ry_chushengriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >籍贯</span>
                        <input type="text"  readonly="true"value="${RY.ry_jiguan}" id="ry_jiguan" name="ry_jiguan" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >手机1</span>
                        <input type="text"  readonly="true" value="${RY.ry_shouji1}"  id="ry_shouji1" name="ry_shouji1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >邮箱</span>
                        <input type="text"  readonly="true" value="${RY.ry_youxiang}"  id="ry_youxiang" name="ry_youxiang" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >婚姻状态</span>
                        <input type="text"  readonly="true" value="${RY.ry_hunyin}"  id="ry_hunyin" name="ry_hunyin" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >离职日期</span>
                        <input class="easyui-datebox"  readonly="true" value="${RY.ry_lizhiriqi}" type="text"  id="ry_lizhiriqi" name="ry_lizhiriqi" data-options="required:false,formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="基本信息3">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >现住地址</span>
                        <input type="text"  readonly="true"  value="${RY.ry_xianzhudizhi}" id="ry_xianzhudizhi" name="ry_xianzhudizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >家庭地址</span>
                        <input type="text" readonly="true"  value="${RY.ry_jiatingdizhi}" id="ry_jiatingdizhi" name="ry_jiatingdizhi" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >紧急联系人</span>
                        <input type="text"  readonly="true" value="${RY.ry_jinjilianxiren}"id="ry_jinjilianxiren" name="ry_jinjilianxiren" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >紧急联系人电话</span>
                        <input type="text"  readonly="true" value="${RY.ry_jinjilianxiren_dianhua}"id="ry_jinjilianxiren_dianhua" name="ry_jinjilianxiren_dianhua" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >固定电话1</span>
                        <input type="text" readonly="true" value="${RY.ry_gudingdianhua1}" id="ry_gudingdianhua1" name="ry_gudingdianhua1" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >固定电话2</span>
                        <input type="text"  readonly="true" value="${RY.ry_gudingdianhua2}"id="ry_gudingdianhua2" name="ry_gudingdianhua2" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div><br/><br/>
            </div>
            <div title="图片识别类">
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >图片</span>
                        <a href="${path_home}/${RY.ry_tupian}" target="_bland"><img src="${path_home}/${RY.ry_tupian}" style="max-width:300px;"/></a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >身份证号码</span>
                        <input type="text"  readonly="true" value="${RY.ry_shenfenzheng}" id="ry_shenfenzheng" name="ry_shenfenzheng" data-options="required:false" class="easyui-textbox"/>
                    </div>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >证件图_正面</span>
                         <a href="${path_home}/${RY.ry_tupian_zhengjian1}" target="_bland"><img src="${path_home}/${RY.ry_tupian_zhengjian1}" style="max-width:300px;"/></a>
                    </div>
                </div>  
                <div class="row-fluid">
                    <div class="span12">
                        <span class="myname" >证件图_反面</span>
                         <a href="${path_home}/${RY.ry_tupian_zhengjian2}" target="_bland"><img src="${path_home}/${RY.ry_tupian_zhengjian2}" style="max-width:300px;"/></a>
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
    </body>
</html>

