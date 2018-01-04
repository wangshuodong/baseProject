<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线物业管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="${staticPath}/static/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${staticPath}/static/app/css/login/components.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="${staticPath}/static/app/css/login/login-5.css" rel="stylesheet" type="text/css"/>
    <link href="${staticPath}/static/favicon.ico" rel="shortcut icon"/>
</head>

<body class="login">
<div class="user-login-5">
    <div class="row bs-reset">
        <div class="col-md-6 bs-reset mt-login-5-bsfix">
            <div class="login-bg" style="background-image:url(${staticPath}/static/app/img/login/bg1.jpg)">
                <img class="login-logo" src="${staticPath}/static/app/img/login/yhw.png"/></div>
        </div>
        <div class="col-md-6 login-container bs-reset mt-login-5-bsfix">
            <div class="login-content">
                <h1>在线物业管理系统</h1>
                <p>请输入用户名和密码登录</p>
                <form action="${path}/doLogin" class="login-form" method="post">
                    <div id="tip1" class="alert alert-danger display-hide">
                        <button class="close" data-close="alert"></button>
                        <span>请输入用户名或密码. </span>
                    </div>
                    <c:if test="${not empty error}">
                        <div id="tip2" class="alert alert-danger">
                            <button class="close" data-close="alert"></button>
                            <span>${error} </span>
                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col-xs-6">
                            <input class="form-control form-control-solid placeholder-no-fix form-group" type="text"
                                   autocomplete="off" placeholder="用户名" name="loginName" required/></div>
                        <div class="col-xs-6">
                            <input class="form-control form-control-solid placeholder-no-fix form-group" type="password"
                                   autocomplete="off" placeholder="密码" name="password" required/></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="rem-password">
                                <label class="rememberme mt-checkbox mt-checkbox-outline">
                                    <input type="checkbox" name="rememberMe" value="1"/> 记住我
                                    <span></span>
                                </label>
                            </div>
                        </div>
                        <div class="col-sm-6 text-right">
                            <button type="submit" class="btn green btn-block uppercase">登 录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${staticPath}/static/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${staticPath}/static/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${staticPath}/static/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${staticPath}/static/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<script src="${staticPath}/static/app/js/login/app.js" type="text/javascript"></script>
<script src="${staticPath}/static/app/js/login/login-5.js" type="text/javascript"></script>
<script>
    var basePath = "${staticPath }";
</script>
</body>

</html>
