var LouObj = new f_onHidePanel_combogrid();
var FangObj = new f_onHidePanel_combogrid();
var RYObj = new f_onHidePanel_combogrid();
var XMFObj = new f_onHidePanel_combogrid();
function inidoCommon() {
    //配置楼的combogrid相关信息
    $('#zhusuhetong_loufangGrid').combogrid('grid').datagrid('hideColumn', 'loufang_zj');
    LouObj.setGridID("zhusuhetong_loufangGrid");
    LouObj.setFieldID_HiddenID("loufang_zj", "zhusuhetong_loufang_zj");
    LouObj.setFieldText_HiddenText("loufang_mc", "zhusuhetong_loufang_mc");
    //配置房的combogrid相关信息
    $('#zhusuhetong_loufang2Grid').combogrid('grid').datagrid('hideColumn', 'loufang2_zj');
    FangObj.setGridID("zhusuhetong_loufang2Grid");
    FangObj.setFieldID_HiddenID("loufang2_zj", "zhusuhetong_loufang2_zj");
    FangObj.setFieldText_HiddenText("loufang2_bianhao", "zhusuhetong_loufang2_bianhao");
    //配置人员的combogrid相关信息
    $('#zhusuhetong_qianyuerenGrid').combogrid('grid').datagrid('hideColumn', 'ry_zj');
    RYObj.setGridID("zhusuhetong_qianyuerenGrid");
    RYObj.setFieldID_HiddenID("ry_zj", "zhusuhetong_qianyueren_zj");
    RYObj.setFieldText_HiddenText("ry_mc", "zhusuhetong_qianyueren");
    //配置项目费用的combogrid相关信息
    $('#zhusuhetong_xmlGRID').combogrid('grid').datagrid('hideColumn', 'loufangxmf_zj');
    XMFObj.setGridID("zhusuhetong_xmlGRID");
    XMFObj.setFieldText_HiddenText("loufangxmf_mc", "zhusuhetong_xml_zj");
}
function f_lou_onHidePanel_combogrid() {
    LouObj.setValue(function (mycheckData) {
        $('#zhusuhetong_loufang2Grid').combogrid('grid').datagrid('reload', path_home + '/base/loufang/select/selectOne/bodyGrid.jw?pid=' + mycheckData.id);
    });
}
function f_fang_onHidePanel_combogrid() {
    FangObj.setValue();
}
function f_ry_onHidePanel_combogrid() {
    RYObj.setValue();
}
function f_xmf_onHidePanel_combogrid() {
    XMFObj.setValueByCheckbox(function (data,rows) {
        var count=0;
        for(var i=0;i<rows.length;i++){
            count=count+parseInt(rows[i].loufangxmf_feiyong);
        }
        $("#zhusuhetong_tj_xml").val(count);
    });
}