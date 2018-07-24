<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-住宿合同</title>
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
            <input type="hidden" id="zhusuhetong_zj" name="zhusuhetong_zj" value="${ZhusuHetong.zhusuhetong_zj}">
            <input type="hidden" id="zhusuhetong_gelibiaoshi" name="zhusuhetong_gelibiaoshi" value="${ZhusuHetong.zhusuhetong_gelibiaoshi}">
            <input type="hidden" id="zhusuhetong_zt" name="zhusuhetong_zt" value="${ZhusuHetong.zhusuhetong_zt}">
            <input type="hidden" id="zhusuhetong_loufang_zj" name="zhusuhetong_loufang_zj" value="${ZhusuHetong.zhusuhetong_loufang_zj}">
            <input type="hidden" id="zhusuhetong_loufang2_zj" name="zhusuhetong_loufang2_zj" value="${ZhusuHetong.zhusuhetong_loufang2_zj}">
            <input type="hidden" id="zhusuhetong_qianyueren_zj" name="zhusuhetong_qianyueren_zj" value="${ZhusuHetong.zhusuhetong_qianyueren_zj}">
            <input type="hidden" id="zhusuhetong_zhidanren" name="zhusuhetong_zhidanren" value="${ZhusuHetong.zhusuhetong_zhidanren}">
            <input type="hidden" id="zhusuhetong_zhidanren_zj" name="zhusuhetong_zhidanren_zj" value="${ZhusuHetong.zhusuhetong_zhidanren_zj}">
            <input type="hidden" id="zhusuhetong_xiugaishijian" name="zhusuhetong_xiugaishijian" value="${ZhusuHetong.zhusuhetong_xiugaishijian}">
            <input type="hidden" id="zhusuhetong_xiugairen" name="zhusuhetong_xiugairen" value="${ZhusuHetong.zhusuhetong_xiugairen}">
            <input type="hidden" id="zhusuhetong_xiugairen_zj" name="zhusuhetong_xiugairen_zj" value="${ZhusuHetong.zhusuhetong_xiugairen_zj}">
<div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >楼名称</span>
                            ${ZhusuHetong.zhusuhetong_loufang_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >房编号</span>
                            ${ZhusuHetong.zhusuhetong_loufang2_bianhao}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >签约人</span>
                            ${ZhusuHetong.zhusuhetong_qianyueren}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >押金</span>
                            ${ZhusuHetong.zhusuhetong_yajin}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >租金</span>
                            ${ZhusuHetong.zhusuhetong_zujin}
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">开始日期</span>
                        <input class="easyui-datebox" type="text" value="${ZhusuHetong.zhusuhetong_kaishiriqi}"  readonly="true" name="zhusuhetong_kaishiriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">结束日期</span>
                        <input class="easyui-datebox" type="text" value="${ZhusuHetong.zhusuhetong_jieshuriqi}"  readonly="true" name="zhusuhetong_jieshuriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" ></span>
                            ${ZhusuHetong.zhusuhetong_jffs}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >计费方式-指定日期</span>
                            ${ZhusuHetong.zhusuhetong_jffs_zdrq}
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">最小住宿日期</span>
                        <input class="easyui-datebox" type="text" value="${ZhusuHetong.zhusuhetong_zuixiaozhusuriqi}"  readonly="true" name="zhusuhetong_zuixiaozhusuriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >备注</span>
                            ${ZhusuHetong.zhusuhetong_bz}
                    </div>
                </div>
        </div>
    </body>
</html>

