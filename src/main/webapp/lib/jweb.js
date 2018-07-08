function toFormatZT(str) {
	return str ? str.replace(/\'/g, "&#39;").replace(/\"/g, "&quot;").replace(/\\/g, "&#92;").replace(/</g, "&#60;").replace(/>/g, "&#62;").replace(/\n/g, "/n") : "";
}
function fzFormatZT(str) {
	return str ? str.replace(/&#39;/g, "'").replace(/&#34;/g, "\"").replace(/&quot;/g, "\"").replace(/&#92;/g, "\\").replace(/&#60;/g, "<").replace(/&#62;/g, ">").replace(/\/n/g, "\n") : "";
}
function f_common_style(value, row, index) {
	switch (value) {
	case '0':
		return "保存"
	case '1':
		return "审核"
	case '2':
		return "流程"
	case '3':
		return "锁定"
	case '4':
		return "作废"
	}
}
function btfunctionStyel(btID, text, int1_0) {
	var bt = document.getElementById(btID);
	bt.value = text;
	bt.disabled = int1_0 == 0 ? true : false;
}