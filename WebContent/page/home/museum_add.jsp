<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="museum!save?name=&pagenow=">
				<div class="form-group">
					<div class="label" align="center">
						<label>博物馆名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="museum.museum_name" data-validate="required:请输入博物馆名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>图片：</label>
					</div>
					<div class="field">
						<input type="file" class="button bg-blue margin-left" id="image1"
							name="museum.museum_img" value="" style="float: left;">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>博物馆简介：</label>
					</div>
					<div class="field">
						<textarea name="museum.museum_title" class="input"
							style="height: 200px; border: 1px solid #ddd;"></textarea>
						<div class="tips"></div>
					</div>
				</div>

				<div class="clear"></div>


				<div class="form-group">
					<div class="label">
						<label>馆藏珍品类型：<br/>以逗号（<font color="red">，</font>）隔开   </label>
					</div>
					<div class="field">
						<script src="js/laydate/laydate.js"></script>
						<input type="text" class="laydate-icon input w50"
							name="museum.type" value=""
							style="padding: 10px !important; height: auto !important; border: 1px solid #ddd !important;" />
						
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>