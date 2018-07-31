<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>明细-楼房纳费</title>
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
            <input type="hidden" id="loufangnafei_zj" name="loufangnafei_zj" value="${LoufangNafei.loufangnafei_zj}">
            <input type="hidden" id="loufangnafei_lou_zj" name="loufangnafei_lou_zj" value="${LoufangNafei.loufangnafei_lou_zj}">
            <input type="hidden" id="loufangnafei_fang_zj" name="loufangnafei_fang_zj" value="${LoufangNafei.loufangnafei_fang_zj}">
            <input type="hidden" id="loufangnafei_gelibiaoshi" name="loufangnafei_gelibiaoshi" value="${LoufangNafei.loufangnafei_gelibiaoshi}">
            <input type="hidden" id="loufangnafei_ren_zj" name="loufangnafei_ren_zj" value="${LoufangNafei.loufangnafei_ren_zj}">
            <input type="hidden" id="loufangnafei_feiyong_shui_zj" name="loufangnafei_feiyong_shui_zj" value="${LoufangNafei.loufangnafei_feiyong_shui_zj}">
            <input type="hidden" id="loufangnafei_feiyong_dian_zj" name="loufangnafei_feiyong_dian_zj" value="${LoufangNafei.loufangnafei_feiyong_dian_zj}">
            <input type="hidden" id="loufangnafei_feiyong_xm_zj" name="loufangnafei_feiyong_xm_zj" value="${LoufangNafei.loufangnafei_feiyong_xm_zj}">
            <input type="hidden" id="loufangnafei_feiyong_meiqi_zj" name="loufangnafei_feiyong_meiqi_zj" value="${LoufangNafei.loufangnafei_feiyong_meiqi_zj}">
            <input type="hidden" id="loufangnafei_zt" name="loufangnafei_zt" value="${LoufangNafei.loufangnafei_zt}">
<div class="container"  style="height:100%;overflow-y: scroll">
            <div class="row-fluid">
                <div class="span12">
                    <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="closeMySelf()">关闭</a>
                </div>
            </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >楼名称</span>
                            ${LoufangNafei.loufangnafei_lou_mc}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >房编码</span>
                            ${LoufangNafei.loufangnafei_fang_bianma}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >纳费人</span>
                            ${LoufangNafei.loufangnafei_ren}
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">应纳日期</span>
                        <input class="easyui-datebox" type="text" value="${LoufangNafei.loufangnafei_yingnariqi}"  readonly="true" name="loufangnafei_yingnariqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
               <div class="row-fluid">
                    <div class="span12">
                        <span class="myname">纳费日期</span>
                        <input class="easyui-datebox" type="text" value="${LoufangNafei.loufangnafei_nafeiriqi}"  readonly="true" name="loufangnafei_nafeiriqi" data-options="formatter:easyuidateformatter,parser:easyuidateparser"/>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >总费用</span>
                            ${LoufangNafei.loufangnafei_zongfeiyong}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >已纳费用</span>
                            ${LoufangNafei.loufangnafei_zongfeiyong2}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >房租</span>
                            ${LoufangNafei.loufangnafei_fangzu}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >水费</span>
                            ${LoufangNafei.loufangnafei_feiyong_shui}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >电费</span>
                            ${LoufangNafei.loufangnafei_feiyong_dian}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >项目费</span>
                            ${LoufangNafei.loufangnafei_feiyong_xm}
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                            <span class="myname" >煤气费</span>
                            ${LoufangNafei.loufangnafei_feiyong_meiqi}
                    </div>
                </div>
        </div>
    </body>
</html>

