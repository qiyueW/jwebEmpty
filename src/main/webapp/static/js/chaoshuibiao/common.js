var LouObj = new f_onHidePanel_combogrid();
var FangObj = new f_onHidePanel_combogrid();
function inidoCommon() {
    //配置楼的combogrid相关信息
    $('#chaoshuibiao_loufangGrid').combogrid('grid').datagrid('hideColumn', 'loufang_zj');
    LouObj.setGridID("chaoshuibiao_loufangGrid");
    LouObj.setFieldID_HiddenID("loufang_zj", "chaoshuibiao_loufang_zj");
    LouObj.setFieldText_HiddenText("loufang_mc", "chaoshuibiao_loufang_mc");
    //配置房的combogrid相关信息
    $('#chaoshuibiao_loufang2Grid').combogrid('grid').datagrid('hideColumn', 'loufang2_zj');
    FangObj.setGridID("chaoshuibiao_loufang2Grid");
    FangObj.setFieldID_HiddenID("loufang2_zj", "chaoshuibiao_loufang2_zj");
    FangObj.setFieldText_HiddenText("loufang2_bianhao", "chaoshuibiao_loufang2_bianma");
}
function f_lou_onHidePanel_combogrid() {
    LouObj.setValue(function (mycheckData) {
        $('#chaoshuibiao_loufang2Grid').combogrid('grid').datagrid('reload', path_home + '/base/loufang/select/selectOne/bodyGrid.jw?pid=' + mycheckData.id);
    });
}
function f_fang_onHidePanel_combogrid() {
    FangObj.setValue();
}