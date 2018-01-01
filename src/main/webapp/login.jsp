<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="common/importCss.jsp" %>
    <%@ include file="common/importJs.jsp" %>
</head>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>Admin</b>LTE</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">请输入用户名和密码登录</p>

        <form action="../../index2.html" method="post">
            <div class="form-group has-feedback mg">
                <input type="text" class="form-control"  name="userName" placeholder="用户名" data-rule="用户名:required;username;">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback mg">
                <input type="password" class="form-control" name="password"  placeholder="密码"  data-rule="密码:required;password;">
                <span class="glyphicon glyphicon-lock form-control-feedback" ></span>
            </div>
            <div class="form-group has-feedback">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group has-feedback mg">
                            <input type="text" class="form-control" name="captcha" placeholder="验证码" data-rule="验证码:required;length(5);" size="5" >
                            <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group has-feedback">
                            <a href="javascript:$('.img').attr('src','/login/captcha');"><img alt="如果看不清楚，请单击图片刷新！" class="pointer img" src="/login/captcha">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 记住我
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat"><i class="fa fa-sign-in"></i> 登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>
</body>
</html>
