<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>系统首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="../../common/importCss.jsp" %>
    <%@ include file="../../common/importJs.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="javascript:;" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><img src="${staticPath }/commons/img/yhw.png" class="mylogoimg"></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">
                <img src="${staticPath }/commons/img/yhw.png" class="mylogoimg">
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
                            <img src="${staticPath }/commons/img/admin.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">管理员</span>
                        </a>
                        <ul class="dropdown-menu" style="width: 200px;">
                            <!-- User image -->
                            <li class="user-header" style="height: 120px;">
                                <img src="${staticPath }/commons/img/admin.png" class="img-circle" alt="User Image">
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

    <!-- =============================================== -->

    <!-- Left side column. contains the sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${staticPath }/commons/img/admin.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>管理员</p>
                    <a href="javascript:;"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">系统菜单</li>
                <li><a href="${path }/pages/welcome.jsp" class="myselect"><i class="fa fa-desktop text-lime"></i> <span>系统首页</span></a></li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-cloud"></i> <span>服务商管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="${path }/pages/list.jsp">我的服务商</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-snowflake-o"></i> <span>物业管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:;">我的物业</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-bank"></i> <span>小区管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:;">我的小区</a></li>
                        <li><a href="javascript:;">房屋信息</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-bar-chart-o"></i> <span>账单管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:;">我的账单</a></li>
                        <li><a href="javascript:;">电子发票</a></li>
                        <li><a href="javascript:;">交易中心</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-user-circle-o"></i> <span>用户管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:;">用户中心</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="javascript:;">
                        <i class="fa fa-gears"></i> <span>系统设置</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:;">角色管理</a></li>
                        <li><a href="javascript:;">费用类型</a></li>
                    </ul>
                </li>


                <li class="header">个人中心</li>
                <li><a href="${path }/form.jsp" class="myselect"><i class="fa fa-circle-o text-red"></i> <span>个人信息</span></a></li>
                <li><a href="${path }/test.jsp" class="myselect"><i class="fa fa-circle-o text-yellow"></i> <span>修改密码</span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- =============================================== -->

    <div class="content-wrapper" id="main-content">
        <%@ include file="pages/welcome.jsp" %>
    </div>

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.4.0
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>

    <%--<div class="control-sidebar-bg"></div>--%>
</div>
<!-- ./wrapper -->


<script>
    $(document).ajaxStart(function () {
        Pace.restart()
    });
    $(document).ready(function () {
        //一级菜单点击
        $('.sidebar-menu > li > a.myselect').click(function (e) {
            e.preventDefault();
            $('.sidebar-menu').find('.active').removeClass('active');
            var menu_open = $('.sidebar-menu').find('.menu-open');
            menu_open.children('ul').css('display', 'none');
            menu_open.removeClass('menu-open');
            $(this).parent().addClass('active');
            $(this).parents('.sidebar-open').removeClass('sidebar-open');
            var url = this.href;
            if (url != null && url != 'javascript:;') {
                $.ajax({
                    url: url, success: function (result) {
                        $('#main-content').html(result)
                    }
                })
            }
        });
        //二级子菜单点击
        $('.sidebar-menu ul a').click(function (e) {
            e.preventDefault();
            $(this).parents('li').addClass('active');
            $(this).parents('li').siblings('.active').removeClass('active');
            $(this).parents('.sidebar-open').removeClass('sidebar-open');
            var url = this.href;
            if (url != null && url != 'javascript:;') {
//                $.get(url, function(data) {
//                    $('#main-content').html(data);
//                });
                $.ajax({
                    url: url, success: function (result) {
                        $('#main-content').html(result)
                    }
                })
            }
        });
        //$('.sidebar-menu').tree()
    })
</script>
</body>
</html>
