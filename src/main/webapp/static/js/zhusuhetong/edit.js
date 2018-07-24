var close = false;
function closeMySelf() {
    if (!close) {
        $.messager.confirm('请确认', "单据还没保存，是否关闭此页面?", function (r) {
            if (r) {
                window.parent.closethisWindow();
            }
        });
    } else {
        window.parent.closethisWindow();
    }
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#' + formid).form('enableValidation').form('validate');
    if (vcheck) {
        close = true
        var data = {}
        data.zhusuhetong_zj = $("#zhusuhetong_zj").val()//主键
        data.zhusuhetong_gelibiaoshi = $("#zhusuhetong_gelibiaoshi").val()//隔离标识
        data.zhusuhetong_zt = fzFormatZT($("#zhusuhetong_zt").val())//状态
        data.zhusuhetong_loufang_zj = fzFormatZT($("#zhusuhetong_loufang_zj").val())//楼主键
        data.zhusuhetong_loufang_mc = fzFormatZT($("#zhusuhetong_loufang_mc").val())//楼名称
        data.zhusuhetong_loufang2_zj = fzFormatZT($("#zhusuhetong_loufang2_zj").val())//房主键
        data.zhusuhetong_loufang2_bianhao = fzFormatZT($("#zhusuhetong_loufang2_bianhao").val())//房编号
        data.zhusuhetong_qianyueren = fzFormatZT($("#zhusuhetong_qianyueren").val())//签约人
        data.zhusuhetong_qianyueren_zj = fzFormatZT($("#zhusuhetong_qianyueren_zj").val())//签约人主键
        data.zhusuhetong_yajin = fzFormatZT($("#zhusuhetong_yajin").val())//押金
        data.zhusuhetong_zujin = fzFormatZT($("#zhusuhetong_zujin").val())//租金
        data.zhusuhetong_xml_zj = $("#zhusuhetong_xml_zj").val()//项目费名称
        data.zhusuhetong_tj_xml = $("#zhusuhetong_tj_xml").val()//项目费合计
        data.zhusuhetong_kaishiriqi = fzFormatZT($("#zhusuhetong_kaishiriqi").val())//开始日期
        data.zhusuhetong_jieshuriqi = fzFormatZT($("#zhusuhetong_jieshuriqi").val())//结束日期
        data.zhusuhetong_jffs = fzFormatZT($("#zhusuhetong_jffs").val())//
        data.zhusuhetong_jffs_zdrq = fzFormatZT($("#zhusuhetong_jffs_zdrq").val())//计费方式-指定日期
        data.zhusuhetong_zuixiaozhusuriqi = fzFormatZT($("#zhusuhetong_zuixiaozhusuriqi").val())//最小住宿日期
        data.zhusuhetong_zhidanshijian = fzFormatZT($("#zhusuhetong_zhidanshijian").val())//制单时间
        data.zhusuhetong_zhidanren = fzFormatZT($("#zhusuhetong_zhidanren").val())//制单人
        data.zhusuhetong_zhidanren_zj = fzFormatZT($("#zhusuhetong_zhidanren_zj").val())//制单人主键
        data.zhusuhetong_xiugaishijian = fzFormatZT($("#zhusuhetong_xiugaishijian").val())//修改时间
        data.zhusuhetong_xiugairen = fzFormatZT($("#zhusuhetong_xiugairen").val())//修改人
        data.zhusuhetong_xiugairen_zj = fzFormatZT($("#zhusuhetong_xiugairen_zj").val())//修改人主键
        data.zhusuhetong_bz = fzFormatZT($("#zhusuhetong_bz").val())//备注
        easyuiAjax("/base/zhusuhetong/update.jw", data, "请确认修改操作", function () {
            //$.fn.zTree.getZTreeObj("divID_Tree_menu_ZhusuHetong").reAsyncChildNodes(null, "refresh");
        });
    }
}
