//给查询引擎的结果追加额外的条件。
function Obj_condition_append() {
    this.conditiondata = {};
}
Obj_condition_append.prototype.setConditionData = function (data) {
    if (null == data || data == "") {
        return;
    } else if (typeof data == 'string') {
        this.conditiondata = $.parseJSON(data);
    } else {
        this.conditiondata = data;
    }
}
Obj_condition_append.prototype.appendAND = function (name, pdf, value) {
    var count = Object.keys(this.conditiondata).length;
    if (count > 0) {
        for (var i = 0; i < count; i++) {
            if (this.conditiondata[i].xt_shezhi_tiaojian1_zhi == name) {
                this.conditiondata[i] = tool_tosetTiaojianObj("AND", name, pdf, value);
                return;
            }
        }
        this.conditiondata[count] = tool_tosetTiaojianObj("AND", name, pdf, value);
    } else {
        this.conditiondata[0] = tool_tosetTiaojianObj("AND", name, pdf, value);
    }
    console.log(this.conditiondata)
}
Obj_condition_append.prototype.appendOR = function (name, pdf, value) {
    if (this.conditiondata) {
        var count = Object.keys(this.conditiondata).length;
        for (var i = 0; i < count; i++) {
            if (this.conditiondata[i].xt_shezhi_tiaojian1_zhi == name) {
                this.conditiondata[i] = tool_tosetTiaojianObj("OR", name, pdf, value);
                return;
            }
        }
        this.conditiondata[count] = tool_tosetTiaojianObj("OR", name, pdf, value);
    } else {
        this.conditiondata[0] = tool_tosetTiaojianObj("OR", name, pdf, value);
    }
}
Obj_condition_append.prototype.getConditionByJSonObj = function () {
    return this.conditiondata;
}
Obj_condition_append.prototype.getConditionByJSonStr = function () {
    var str = "";
    var count = Object.keys(this.conditiondata).length;
    console.log(count);
    if(count==0){
        return "[]";
    }
    for (var i = 0; i < count; i++) {
        str = str + tool_getJsonByBody(this.conditiondata[i], ",");
    }
    return "["+str.substring(1)+"]";
}
function tool_getJsonByBody(obj, fh) {
    var str = (fh ? fh : "") + '{'
            + '"xt_tiaojian1_zj":"' + toFormatZT(obj.xt_tiaojian1_zj) + '"' //主键
            + ',"xt_tiaojian_zj":"' + toFormatZT(obj.xt_tiaojian_zj) + '"' //表头主键
            + ',"xt_tiaojian1_kuohao":"' + toFormatZT(obj.xt_tiaojian1_kuohao) + '"' //括号区
            + ',"xt_tiaojian1_lianjiefu":"' + obj.xt_tiaojian1_lianjiefu + '"' //接连符
            + ',"xt_tiaojian1_lianjiefu_mc":"' + toFormatZT(obj.xt_tiaojian1_lianjiefu_mc) + '"' //接连符展示名
            + ',"xt_shezhi_tiaojian1_mc":"' + toFormatZT(obj.xt_shezhi_tiaojian1_mc) + '"' //条件区展示名
            + ',"xt_shezhi_tiaojian1_zhi":"' + toFormatZT(obj.xt_shezhi_tiaojian1_zhi) + '"' //条件区值
            + ',"xt_tiaojian1_panduan":"' + obj.xt_tiaojian1_panduan + '"' //判断区
            + ',"xt_tiaojian1_panduan_mc":"' + toFormatZT(obj.xt_tiaojian1_panduan_mc) + '"' //判断区展示名
            + ',"xt_tiaojian1_zhi":"' + toFormatZT(obj.xt_tiaojian1_zhi) + '"}'; //条件值
    return str;
}
function tool_tosetTiaojianObj(ljf, name, pdf, value) {
    var oneObj = {};
    oneObj.xt_tiaojian1_zj = "";//主键
    oneObj.xt_tiaojian_zj = "";//表头主键
    oneObj.xt_tiaojian1_kuohao = "";//括号区
    oneObj.xt_tiaojian1_lianjiefu = ljf;//接连符
    oneObj.xt_tiaojian1_lianjiefu_mc = ljf;//接连符展示名
    oneObj.xt_shezhi_tiaojian1_mc = name;//条件区展示名
    oneObj.xt_shezhi_tiaojian1_zhi = name;//条件区值
    oneObj.xt_tiaojian1_panduan = pdf;//判断区
    oneObj.xt_tiaojian1_panduan_mc = pdf; //判断区展示名
    oneObj.xt_tiaojian1_zhi = value;//条件值
    return oneObj;
}