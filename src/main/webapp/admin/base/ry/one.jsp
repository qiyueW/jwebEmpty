<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-人员管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/boostrap.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
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
<div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >部门</span>
                            ${RY.ry_bm}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >人员名称</span>
                            ${RY.ry_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >账号</span>
                            ${RY.ry_zhanghao}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >密码</span>
                            ${RY.ry_mima}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >性别</span>
                            ${RY.ry_xingbie}
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">入职日期</span>
                        <input class="easyui-datebox" type="text" value="${RY.ry_ruzhiriqi}"  readonly="true" name="ry_ruzhiriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">出生日期</span>
                        <input class="easyui-datebox" type="text" value="${RY.ry_chushengriqi}"  readonly="true" name="ry_chushengriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">离职日期</span>
                        <input class="easyui-datebox" type="text" value="${RY.ry_lizhiriqi}"  readonly="true" name="ry_lizhiriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >籍贯</span>
                            ${RY.ry_jiguan}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >手机1</span>
                            ${RY.ry_shouji1}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >邮箱</span>
                            ${RY.ry_youxiang}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >婚姻状态</span>
                            ${RY.ry_hunyin}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >岗位</span>
                            ${RY.ry_gangwei}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >职位</span>
                            ${RY.ry_zhiwei}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >图片</span>
                            <a href="${path_home}/${RY.ry_tupian}" target="_bland">下载</a>
                    </div>
                </div>              
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >备注</span>
                            ${RY.ry_bz}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >身份证号码</span>
                            ${RY.ry_shenfenzheng}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >证件图_正面</span>
                            <a href="${path_home}/${RY.ry_tupian_zhengjian1}" target="_bland">下载</a>
                    </div>
                </div>              
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >证件图_反面</span>
                            <a href="${path_home}/${RY.ry_tupian_zhengjian2}" target="_bland">下载</a>
                    </div>
                </div>              
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >现住地址</span>
                            ${RY.ry_xianzhudizhi}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >家庭地址</span>
                            ${RY.ry_jiatingdizhi}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >紧急联系人</span>
                            ${RY.ry_jinjilianxiren}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >紧急联系人电话</span>
                            ${RY.ry_jinjilianxiren_dianhua}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >固定电话1</span>
                            ${RY.ry_gudingdianhua1}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >固定电话2</span>
                            ${RY.ry_gudingdianhua2}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >其他通信</span>
                            ${RY.ry_qitatongxing}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >其他通信1</span>
                            ${RY.ry_qitatongxing1}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >其他通信2</span>
                            ${RY.ry_qitatongxing2}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >其他通信3</span>
                            ${RY.ry_qitatongxing3}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >其他通信4</span>
                            ${RY.ry_qitatongxing4}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >其他通信5</span>
                            ${RY.ry_qitatongxing5}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信1</span>
                            ${RY.ry_neibutongxing1}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信2</span>
                            ${RY.ry_neibutongxing2}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信3</span>
                            ${RY.ry_neibutongxing3}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信4</span>
                            ${RY.ry_neibutongxing4}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信5</span>
                            ${RY.ry_neibutongxing5}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信6</span>
                            ${RY.ry_neibutongxing6}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信7</span>
                            ${RY.ry_neibutongxing7}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信8</span>
                            ${RY.ry_neibutongxing8}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信9</span>
                            ${RY.ry_neibutongxing9}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >内部通信10</span>
                            ${RY.ry_neibutongxing10}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >制单人</span>
                            ${RY.ry_zhidanren}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >隔离标识</span>
                            ${RY.ry_gelibiaoshi}
                    </div>
                </div>
        </div>
    </body>
</html>

