var LouObj = new f_onHidePanel_combogrid();
function inidoCommon() {
    $('#loufang_fybz_loufangGrid').combogrid('grid').datagrid('hideColumn', 'loufang_zj');
    LouObj.setGridID("loufang_fybz_loufangGrid");
    LouObj.setFieldID_HiddenID("loufang_zj", "loufang_fybz_loufang_zj");
    LouObj.setFieldText_HiddenText("loufang_mc", "loufang_fybz_loufang_mc");
}
function f_lou_onHidePanel_combogrid() {
    LouObj.setValue();
}