<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header class="main-header">
    <!-- Logo -->
    <a href="javascript:;" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><img src="${staticPath }/static/app/img/yhw.png" class="mylogoimg"></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">
                <img src="${staticPath }/static/app/img/yhw.png" class="mylogoimg">
                <b>物业管理系统</b>
            </span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="javascript:;" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${staticPath }/static/app/img/admin.png" class="user-image" alt="User Image">
                        <span class="hidden-xs">管理员</span>
                    </a>
                    <ul class="dropdown-menu" style="width: 200px;">
                        <!-- User image -->
                        <li class="user-header" style="height: 120px;">
                            <img src="${staticPath }/static/app/img/admin.png" class="img-circle" alt="User Image">
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-6 text-center">
                                    <a href="javascript:;">个人信息</a>
                                </div>
                                <div class="col-xs-6 text-center">
                                    <a href="javascript:;">修改密码</a>
                                </div>
                            </div>
                            <!-- /.row -->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="javascript:;" class="btn btn-default btn-flat">锁屏</a>
                            </div>
                            <div class="pull-right">
                                <a href="javascript:;" class="btn btn-default btn-flat">退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/logout" class="dropdown-toggle" data-toggle="tooltip" title="退出"
                       data-placement="bottom">
                        <i class="fa fa-sign-out"></i>
                    </a>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li>
                    <a href="javascript:;" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                </li>
            </ul>
        </div>
    </nav>
</header>