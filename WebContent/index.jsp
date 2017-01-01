<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-red" href="login.jsp"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display: block">
			<li><a href="page/admin/admin_add.jsp" target="right"><span
					class="icon-caret-right"></span>增加管理员</a></li>
			<li><a href="info.html" target="right"><span
					class="icon-caret-right"></span>网站设置</a></li>
			<li><a href="pass.html" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>
			<li><a href="page.html" target="right"><span
					class="icon-caret-right"></span>单页管理</a></li>
			<li><a href="adv.html" target="right"><span
					class="icon-caret-right"></span>首页轮播</a></li>
			<li><a href="book.html" target="right"><span
					class="icon-caret-right"></span>留言管理</a></li>
			<li><a href="column.html" target="right"><span
					class="icon-caret-right"></span>栏目管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>栏目管理
		</h2>
		<ul>
			<li><a href="list.html" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="add.html" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>首页轮播
		</h2>
		<ul>
			<li><a href="viewPager!getAllViewPagerWeb" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>热门展厅
		</h2>
		<ul>
			<li><a href="exhibition!getAllExhibitionByCity?city=&tip=&pagenow=" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="page/home/exhibition_add.jsp" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>博物馆
		</h2>
		<ul>
			<li><a href="museum!getAllMuseumWeb?name=&pagenow=" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="page/home/museum_add.jsp" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="info.html" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>