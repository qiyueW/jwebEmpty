var LouObj = new f_onHidePanel_combogrid();
var caobj = new Obj_condition_append();
function inidoCommon() {
    //配置楼的combogrid相关信息
    $('#chaoshuibiao_loufangGrid').combogrid('grid').datagrid('hideColumn', 'loufang_zj');
    LouObj.setGridID("chaoshuibiao_loufangGrid");
    LouObj.setFieldID_HiddenID("loufang_zj", "chaoshuibiao_loufang_zj");
    LouObj.setFieldText_HiddenText("loufang_mc", "chaoshuibiao_loufang_mc");
}
function f_lou_onHidePanel_combogrid() {
    LouObj.setValue(function (mycheckData) {
        $('#dg_fang').datagrid('reload', path_home + '/base/loufang/select/selectOne/bodyGrid.jw?pid=' + mycheckData.id);
        var queryParams = $('#dg').datagrid('options').queryParams;
        caobj.setConditionData(queryParams.key);
        caobj.appendAND("zhusuhetong_loufang_zj","=",mycheckData.id);
        queryParams.key =caobj.getConditionByJSonStr();
        $('#dg').datagrid('reload');
    });
}

function f_fang_onHidePanel_combogrid() {
    
};