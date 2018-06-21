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
    $("#submitBTID").on('click', function () {
        $("#showsafecodeDivID").hide()
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
        if (data.account.length == 0) {
            doshowmsg("请输入账号")
            $("#account").focus();
            return;
        }
        if (data.password.length == 0) {
            doshowmsg("请输入密码")
            $("#password").focus();
            return;
        }
        clickupstatus = true;
        $btn = $('#submitBTID').val('正在登录中......');
        $.post(path_home + "xt/loginmanager/login/user.jw", data, function (data) {
            $('#xt_safecode').val("");
            doshowmsg(data.msg);
            if (data.statusCode == '0') {
                clickupstatus = false;
                setTimeout(function () {
                    $btn = $('#submitBTID').val('登录');
                }, 1100);
                return;
            } else if (data.statusCode == '-1') {
                clickupstatus = false;
                $("#show_xt_safecodeDivID").show();
                refreshsafecode();
                setTimeout(function () {
                    $btn = $('#submitBTID').val('登录');
                }, 1100);
                return;
            } else if (data.statusCode == '1') {
                var url = path_home + "xt/index.jsp";
                if ($('#sort').val() == "admin") {
                    url = path_home + "xt/index.jsp";
                }
                console.log(url);
                window.location.href = url;
            }
        }, "json");
    });
}
function refreshsafecode() {
    document.getElementById("safecodeImg").src = path_home + "xt/yanzhengma/tupian.jw?z=" + Math.random()
}
function doshowmsg(msg) {
    if (msg) {
        $("#showmsgDivID").show()
        $("#showmsgDivIDBody").html(msg);
        setTimeout(function () {
            $("#showmsgDivID").hide()
            $("#showmsgDivIDBody").html("");
        }, 2500);
    } else {
        $("#showmsgDivID").hide()
        $("#showmsgDivIDBody").html("");
    }
}