//页面文档加载完后-调用此函数。
//需要初始化的，统一放到此函数来
function inidoAdd() {
//    toCreateTree("divID_Tree_menu_LoufangNafei", "loufangnafei_zj", "${treeMypid}", "${treeMyname}", "/service/loufangnafei/select/json.jw", false, function (event, id, treeNode) {
//        $("#${treeMypid}").val(treeNode.loufangnafei_zj)
//        $("#${treeMypid}_mc").textbox('setValue',treeNode.${treeMyname});        
//    }, true);
}
//提交表单
function submitForm(formid) {
    var vcheck = $('#'+formid).form('enableValidation').form('validate');
            if (vcheck) {
                var data = {}
                //data.loufangnafei_zj = $("#loufangnafei_zj").val()                
                data.loufangnafei_lou_zj = fzFormatZT($("#loufangnafei_lou_zj").val())//楼主键
                data.loufangnafei_fang_zj = fzFormatZT($("#loufangnafei_fang_zj").val())//房主键
                data.loufangnafei_gelibiaoshi = fzFormatZT($("#loufangnafei_gelibiaoshi").val())//隔离标识
                data.loufangnafei_lou_mc = fzFormatZT($("#loufangnafei_lou_mc").val())//楼名称
                data.loufangnafei_fang_bianma = fzFormatZT($("#loufangnafei_fang_bianma").val())//房编码
                data.loufangnafei_ren = fzFormatZT($("#loufangnafei_ren").val())//纳费人
                data.loufangnafei_ren_zj = fzFormatZT($("#loufangnafei_ren_zj").val())//纳费人主键
                data.loufangnafei_yingnariqi = fzFormatZT($("#loufangnafei_yingnariqi").val())//应纳日期
                data.loufangnafei_nafeiriqi = fzFormatZT($("#loufangnafei_nafeiriqi").val())//纳费日期
                data.loufangnafei_zongfeiyong = fzFormatZT($("#loufangnafei_zongfeiyong").val())//总费用
                data.loufangnafei_zongfeiyong2 = fzFormatZT($("#loufangnafei_zongfeiyong2").val())//已纳费用
                data.loufangnafei_fangzu = fzFormatZT($("#loufangnafei_fangzu").val())//房租
                data.loufangnafei_feiyong_shui = fzFormatZT($("#loufangnafei_feiyong_shui").val())//水费
                data.loufangnafei_feiyong_shui_zj = fzFormatZT($("#loufangnafei_feiyong_shui_zj").val())//水费主键集合
                data.loufangnafei_feiyong_dian = fzFormatZT($("#loufangnafei_feiyong_dian").val())//电费
                data.loufangnafei_feiyong_dian_zj = fzFormatZT($("#loufangnafei_feiyong_dian_zj").val())//电费主键集合
                data.loufangnafei_feiyong_xm = fzFormatZT($("#loufangnafei_feiyong_xm").val())//项目费
                data.loufangnafei_feiyong_xm_zj = fzFormatZT($("#loufangnafei_feiyong_xm_zj").val())//项目费主键集合
                data.loufangnafei_feiyong_meiqi = fzFormatZT($("#loufangnafei_feiyong_meiqi").val())//煤气费
                data.loufangnafei_feiyong_meiqi_zj = fzFormatZT($("#loufangnafei_feiyong_meiqi_zj").val())//煤气费主键集合
                data.loufangnafei_zt = fzFormatZT($("#loufangnafei_zt").val())//状态
                data.loufangnafei_chuzhangshijian = fzFormatZT($("#loufangnafei_chuzhangshijian").val())//出账时间
                easyuiAjax("/service/loufangnafei/save.jw", data, "请确认保存操作", function () {
                });
            }
}
function clearForm() {
    $('#LoufangNafeiFormID').form('clear');
}
