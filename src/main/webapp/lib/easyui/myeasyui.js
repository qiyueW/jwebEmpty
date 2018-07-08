function f_onHidePanel_combotree() {
    var mytree = $(this).combotree('tree').tree('getSelected');
    if (mytree) {
        $(this).combotree('setValue', mytree.id);
        $(this).combotree('setText', mytree.text);
        return;
    }
    $(this).combotree('clear');
}
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
                        var x = eval(options.param);
                        datas = f_myajax(options.url, x())
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

function easyuidateformatter(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
function easyuidateparser(s) {
    if (!s)
        return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0], 10);
    var m = parseInt(ss[1], 10);
    var d = parseInt(ss[2], 10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
        return new Date(y, m - 1, d);
    } else {
        return new Date();
    }
}
function easyuiGridReload(tgid) {
    $('#' + tgid).datagrid('reload');//刷新
}
function easyuiTreeGridReload(tgid, parentNode) {
    if (parentNode) {
        $('#' + tgid).treegrid('reload', parentNode.target);//刷新
    } else {
        $('#' + tgid).treegrid('reload');//刷新
    }
    $('#' + tgid).treegrid('unselectAll');
}
function easyuiGetRowsID(rows, idname) {
    var ids = "";
    for (var i = 0; i < rows.length; i++) {
        ids = ids + "," + rows[i][idname];
    }
    return ids.length > 0 ? ids.substring(1) : "";
}
function easyuiLoadWindowByURL(winID, title, url) {
	if(url.indexOf("/")!=0){
		url="/"+url;
	}
    var winID2 = '#' + winID;
    $(winID2).panel({title: title});
    $(winID2).window('open');
    document.getElementById(winID).innerHTML = '<iframe scrolling="no" frameborder="0"  src="' +path_home+ url + '" style="width:100%;height:100%;"></iframe>';
}

function f_grid_img(value, row, index) {
    var url = "${path_home}/" + value;
    if (value) {
        return "<a href=\"javascript:void(0)\" onclick=\"f_grid_showIMGtoPanel('" + url + "')\">图片</a>";
    }
}
function f_grid_file(value, row, index) {
    var url = "${path_home}/" + value;
    if (value) {
        return "<a href=\"" + url + "\" target=\"_bland\">文件下载</a>";
    }
}
function f_grid_showIMGtoPanel(url) {
    $('#gridShowIMG').window({
        width: 600,
        height: 400,
        title: '图片展示',
        content: '<a href="' + url + '" target="_bland"><img src="' + url + '" style="max-width:570px;" /></a>',
        modal: true
    });
}
/**
 * 
 * @param {String} url 上传的路径
 * @param {String} data 上传的数据
 * @param {String} msg 确认的信息
 * @param {function} okfun  操作成功回调
 * @param {String} async 默认同步 false. 异步需设置为true
 * @param {function} fun  调用自己的方法处理服务器响应的返回事件
 * @param {int} w  长
 * @param {int} h  高
 * @returns {void}
 */
function easyuiAjax(url, data, msg, okfun, async, fun, w, h) {
    w = w ? w : 300;
    h = h ? h : 200;
    if (msg) {
        $.messager.confirm('请确认', msg, function (r) {
            if (r) {
                doajax()
            }
        });
    } else {
        doajax();
    }
    function doajax() {
    	if(url.indexOf("/")!=0){
    		url="/"+url;
    	}
        $.ajax({
            url: path_home + url
            , data: data
            , dataType: "json"
            , async: async ? true : false
            , type: "post"
            , success: function (rs) {
                if (fun) {
                    fun(rs);
                } else {
                    if (rs.statusCode == 99) {
                        var msg = "";
                        for (var i in rs.msg) {
                            msg = msg + rs.msg[i] + "<br/>";
                        }
                        showmsg_error('执行异常', msg,w,h);
                    } else if (rs.statusCode == 1) {
                    	showmsg_ok('操作成功', rs.msg,w,h);
                        if (okfun)
                            okfun();
                    } else {
                    	showmsg_error('执行异常', rs.msg,w,h);
                    }
                }
            }
            , timeout: 4000
        });
    }
}
 
function showmsg_error(title,content,w,h){
    w = w ? w : 300;
    h = h ? h : 200;
	$.messager.show({title: '<div style="color:red;font-size:9px;">'+title+'</div>', width: w, height: h, msg:content, showType: 'show', style: {
        right: '',
        top: '',
        bottom: -document.body.scrollTop - document.documentElement.scrollTop
    }});
}
function showmsg_ok(title,content,w,h){
    w = w ? w : 300;
    h = h ? h : 200;
	$.messager.show({title: '<div style="color:#339933;font-size:9px;">'+title+'</div>', width: w, height: h, msg:content, showType: 'show', style: {
        right: '',
        top: '',
        bottom: -document.body.scrollTop - document.documentElement.scrollTop
    }});
}