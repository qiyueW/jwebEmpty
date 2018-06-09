function pageCN(tableID, pagesize, pageList) {
    var p = $('#' + tableID).datagrid('getPager');
    var mpage = pagesize ? pagesize : 50;
    var mpageList = pageList ? pageList : [50, 100, 200, 300, 500]
    $(p).pagination({
        pageSize: mpage, //每页显示的记录条数，默认为10  
        pageList: mpageList, //可以设置每页记录条数的列表  
        beforePageText: '第', //页数文本框前显示的汉字  
        afterPageText: '页,共{pages}页',
        displayMsg: '当前显示 {from} - {to} 条记录 共{total}条记录'
    });
}
function easyuipost(url, mydata) {
    var x = false;
    $.ajax({
        type: "post"
        , url: url
        , data: mydata
        , dataType: "json"
        , async: false //取消异步
        , success: function (d) {
            switch (d.statusCode) {
                case "99":
                    var msg = "";
                    for (var i in d.msg) {
                        msg = msg + d.msg[i] + "<br/>";
                    }
                    ealert(d.msg, "检验未通过")
                    x = false;
                    break;
                case "0":
                    ealert(d.msg)
                    x = false;
                    break;
                case "-1":
                    ealert(d.msg, "异常")
                    x = false;
                    break;
                case "1":
                    ealert(d.msg, "操作成功")
                    x = true;
                    break;
            }
        }
    });
    return x;
}

function ealert(msg, title, showType) {
    $.messager.show({
        title: title ? title : "提示",
        msg: msg,
        showType: showType ? showType : 'slide',
        style: {
            right: '',
            top: '',
            bottom: -document.body.scrollTop - document.documentElement.scrollTop
        }
    });
}

function f_extend_select() {
    $.extend($.fn.datagrid.defaults.editors, {
        // 增加对下拉列表的支持
        select: {
            init: function (container, options) {
                var datas;

                if (options.url) {
                    if (options.param) {
                        var x=eval(options.param);
                        datas = f_myajax(options.url,x())
                    } else {
                        datas = f_myajax(options.url, null)
                    }
                } else {
                    datas = options.data;
                }
                if (!datas) {
                    return '没有可用的数据'
                }
                var rsstr = "";
                for (var i = 0; i < datas.length; i++) {
                    rsstr = rsstr + '<option value=' + datas[i][options.valueField] + '>' + datas[i][options.textField] + '</option>';
                }
                var input = $('<select style="width:' + options.width + '">' + rsstr + '</select>').appendTo(container);
                input.combobox(options);
                return input;
            },
            getValue: function (target) {
                var data = $(target).combobox('getData');
                var opt = $(target).combobox('options');
                var textField = opt.textField;
                var valueField = opt.valueField;
                var v = $(target).val();
                var rs = {};
                for (var i = 0; i < data.length; i++) {
                    if (v == data[i][valueField]) {
                        rs[textField] = data[i][textField];
                        rs[valueField] = data[i][valueField];
                        return rs;
                    }
                }
                return $(target).val();
            },
            setValue: function (target, value) {
                var data = $(target).combobox('getData');
                var opt = $(target).combobox('options');
                var textField = opt.textField;
                var valueField = opt.valueField;
                for (var i = 0; i < data.length; i++) {
                    if (value == data[i][textField]) {
                        value = data[i][valueField];
                        $(target).combobox('setValue', value);
                        $(target).val(value);
                        return;
                    }
                }
                $(target).combobox('setValue', value);
                $(target).val(value);
            }
//            ,
//            resize: function (target, width) {
//                 var input = $(target);
//                 input.width(input.outerWidth()+20);
//                 input.outerWidth(300)
//                console.log(width+"//"+input.outerWidth()+"//"+input.width())
////                $(target)._outerWidth(width+100);
////                var input = $(target);
////                if ($.boxModel == true) {
////                    input.width(width - (input.outerWidth() - input.width()));
////                } else {
////                    input.width(width);
////                }
//            }
        }
    });
}

function f_myajax(url, data) {
    var m;
    $.ajax({
        url: url
        , data: data ? data : {}
        , dataType: "json"
        , async: false
        , type: "post"
        , success: function (rs) {
            m = rs;
            return rs;
        }
        , timeout: 6000
    });
    return m;
}