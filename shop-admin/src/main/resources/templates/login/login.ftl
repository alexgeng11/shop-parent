<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <title> - 登录</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <#include '/common/common-js.ftl'>
    <script src="${req.contextPath}/static/js/kaysen.encode.js"></script>
    <link href="${req.contextPath}/static/css/lrtk.css" rel="stylesheet">
    <link href="${req.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>
<body>
<!-- 代码 开始 -->
<div id="login">
    <div class="wrapper">
        <div class="login">
            <form action="" method="post" class="container offset1 loginform">
                <div id="owl-login">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
                    <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk=">
                    <div class="control-group">
                        <div class="controls">
                            <label for="email" class="control-label fa fa-user"></label>
                            <input id="userName" type="text" name="userName" placeholder="用户名" tabindex="1" value="anhry"
                                   autofocus="autofocus" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label fa fa-asterisk"></label>
                            <input id="password" type="password" name="password" placeholder="密码" tabindex="2" value="Anhry654321"
                                   class="form-control input-medium">
                        </div>
                    </div>
                </div>
                <div class="form-actions"><a href="http://www.lanrentuku.com/" tabindex="5"
                                             class="btn pull-left btn-link text-muted">忘记密码?</a>
                    <button type="button" tabindex="4" class="btn btn-primary" onclick="toLogin()">登录</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        //登录方法
        function toLogin() {
            if (check()){
                var userName = $("#userName").val();
                var password = $("#password").val();
                $("#password").val(hex_sha1(userName+password+"kaysen"));
                var data=$(".loginform").serialize()
                $.post("/doLogin",data,function (res) {
                    if (res.isAccuss) {
                        layer.msg(res.errMsg,{icon:1,time:1000},function () {
                            window.location.href="/system/main";
                        })

                    }else {
                        layer.msg(res.errMsg,{icon:2})
                    }
                },"json")
            }

        }
        //校验
        function check() {

            if ($("#userName").val() == "") {
                layer.tips('用户名不得为空', '#userName');
                $("#userName").focus();
                return false;
            } else {
                $("#userName").val(jQuery.trim($('#userName').val()));
            }

            if ($("#password").val() == "") {
                layer.tips('密码不得为空', '#password');
                $("#password").focus();
                return false;
            }
            // if ($("#code").val() == "") {
            //
            //     $("#code").tips({
            //         side : 1,
            //         msg : '验证码不得为空',
            //         bg : '#AE81FF',
            //         time : 3
            //     });
            //
            //     $("#code").focus();
            //     return false;
            // }
            var index=layer.msg('登录中。。。', {
                icon: 16
                // ,time:60*1000
            });
            layer.title('111', index)
            return true;
        }
        $(function () {
            $('#login #password').focus(function () {
                $('#owl-login').addClass('password');
            }).blur(function () {
                $('#owl-login').removeClass('password');
            });
        });
    </script>
</div>
<!-- 代码 结束 -->
</body>
</html>