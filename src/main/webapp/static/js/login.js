var clickupstatus = false;
function f_inidoLogin() {
    $("#xt_safecode").on('focus', function () {
        $("#showsafecodeDivID").show()
    });
    $("#xt_gelibiaoshi").on('focus', function () {
        $("#showsafecodeDivID").hide()
    });
    $("#account").on('focus', function () {
        $("#showsafecodeDivID").hide()
    });
    $("#password").on('focus', function () {
        $("#showsafecodeDivID").hide()
    });
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $("#submitBTID").trigger("click");
        }
    });
    f_getCookieToSet();

    $("#submitBTID").on('click', function () {
//        $("#showsafecodeDivID").hide()
        if (clickupstatus) {
            return;
        }
        doshowmsg()
        var data = {};
        data.xt_safecode = $.trim($('#xt_safecode').val());
        data.xt_gelibiaoshi = $.trim($('#xt_gelibiaoshi').val());
        data.account = $.trim($('#account').val());
        data.password = $.trim($('#password').val());
        data.sort = $.trim($('#sort').val());
        if (data.xt_gelibiaoshi.length == 0) {
            doshowmsg("请输入【标识】")
            $("#xt_gelibiaoshi").focus();
            return;
        }
        if (data.account.length == 0) {
            doshowmsg("请输入【账号】")
            $("#account").focus();
            return;
        }
        if (data.password.length == 0) {
            doshowmsg("请输入【密码】")
            $("#password").focus();
            return;
        }
        if (!$("#show_xt_safecodeDivID").is(':hidden')) {
            if (data.xt_safecode.length != 6) {
                doshowmsg("请输入6位的【验证码】")
                $("#xt_safecode").focus();
                return;
            }
        }
        if ($("#remember").val() != 0) {
            f_setCookie();
        } else {
            f_clearCookie();
        }
        clickupstatus = true;
        $btn = $('#submitBTID').val('正在登录中......');
        $.post(path_home + "xt/loginmanager/login.jw", data, function (data) {
            $('#xt_safecode').val("");
            doshowmsg(data.msg);
            if (data.statusCode == '0') {
                clickupstatus = false;
                setTimeout(function () {
                    $btn = $('#submitBTID').val('登录');
                }, 2100);
                return;
            } else if (data.statusCode == '-1') {
                clickupstatus = false;
                $("#show_xt_safecodeDivID").show();
                refreshsafecode();
                setTimeout(function () {
                    $btn = $('#submitBTID').val('登录');
                }, 2100);
                return;
            } else if (data.statusCode == '1') {
                var url = path_home + "xt/indexUser.jsp";
                if ($('#sort').val() == "admin") {
                    url = path_home + "xt/indexAdmin.jsp";
                }
                window.location.href = url;
            } else if (data.statusCode == '2') {
                window.location.href = path_home + "xt/indexSuperAdmin.jsp";
            }
        }, "json");
    });
}
function refreshsafecode() {
    document.getElementById("safecodeImg").src = path_home + "xt/yanzhengma/tupian.jw?z=" + Math.random()
}
function doshowmsg(msg) {
    f_hiddenORShowMsgDiv(msg);
}
var timer1;
function f_hiddenORShowMsgDiv(msg) {
    if(timer1){
        window.clearTimeout(timer1);
    }
    if (msg) {
        $("#showmsgDivID").show()
        $("#showmsgDivIDBody").html(msg);
        timer1 = window.setTimeout(function () {
            $("#showmsgDivID").hide()
            $("#showmsgDivIDBody").html("");
            timer1=null;
        }, 5000);
    } else {
        $("#showmsgDivID").hide()
        $("#showmsgDivIDBody").html("");
    }
}
function f_setCookie() {
    var data = {};
    var rb = $("#remember").val()
    data.xt_gelibiaoshi = $.trim($('#xt_gelibiaoshi').val());
    data.account = $.trim($('#account').val());
    data.password = rb == 2 ? $.trim($('#password').val()) : "";
    data.sort = $('#sort').val()
    data.remember = rb;
    Cookies.set('userLogin', data, {path: '', expires: 365});
}
function f_getCookieToSet() {
    var data = Cookies.get('userLogin');
    if (data) {
        data = $.parseJSON(data);
        console.log("data.xt_gelibiaoshi" + data.xt_gelibiaoshi)
        $('#xt_gelibiaoshi').val(data.xt_gelibiaoshi);
        $('#account').val(data.account);
        $('#password').val(data.password);
        $('#sort').val(data.sort);
        $('#remember').val(data.remember);
    }
}
function f_clearCookie() {
    Cookies.remove('userLogin', {path: ''});
}