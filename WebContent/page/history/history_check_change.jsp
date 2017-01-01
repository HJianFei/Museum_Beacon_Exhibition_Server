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
		<!-- 查询结果 -->
		<c:if test="${request.check!=null}">
			<div class="body-content">
				<form method="post" class="form-x"
					action="chinaHistoryCheck!update?flag=updated&search=&pagenow=">
					<div class="form-group">
						<div class="label" align="center">
							<label>ID：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${request.check.id }"
								readonly="readonly" name="check.id" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label" align="center">
							<label>名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.check.title }"
								name="check.title"
								data-validate="required:请输入名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>图片：</label>
						</div>
						<div class="field">
							<input type="file" class="button bg-blue margin-left" id="image1"
								name="check.img_url"
								value="${request.check.img_url }" style="float: left;">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>详情URL：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.check.detail_url }"
								name="check.detail_url"
								data-validate="required:请输入详情URL" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="form-group">
						<div class="label">
							<label>排期：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.check.time }"
								name="check.time"
								data-validate="required:请输入排期" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="clear"></div>
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
		</c:if>
	</div>
</body>
</html>