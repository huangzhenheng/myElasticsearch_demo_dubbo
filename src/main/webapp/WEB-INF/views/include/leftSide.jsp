<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
                <li class="header">栏目</li>
                <li class="${param.menu == 'home' ? 'active' : ''}"><a href="/"><i class="fa fa-home"></i> <span>首页</span></a></li>
                <li class="${param.menu == 'notice' ? 'active' : ''}"><a href="#"><i class="fa fa-bullhorn"></i> <span>公告</span></a></li>
                <li class="${param.menu == 'sales' ? 'active' : ''}"><a href="#"><i class="fa fa-building-o"></i> <span>销售机会</span></a></li>
                <li class="${param.menu == 'customer' ? 'active' : ''}"><a href="#"><i class="fa fa-users"></i> <span>客户管理</span></a></li>
                <li class="${param.menu == 'task' ? 'active' : ''}"><a href="#"><i class="fa fa-calendar-check-o"></i> <span>待办事项</span></a></li>
                <li class="${param.menu == 'chart' ? 'active' : ''}"><a href="/chart"><i class="fa fa-bar-chart"></i> <span>统计</span></a></li>
                <li class="${param.menu == 'document' ? 'active' : ''}"><a href="#"><i class="fa fa-file-text"></i> <span>文档管理</span></a></li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-cogs"></i> <span>系统</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-cog"></i>员工管理</a></li>
                        <li><a href="#"><i class="fa fa-wrench"></i>系统设置</a></li>
                    </ul>
                </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>