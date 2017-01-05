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
	<%
		String type = request.getParameter("type");
	%>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="foreignHistory!save?title=&pagenow=&country=美国历史&type=<%=type %>">
				<div class="form-group">
					<div class="label" align="center">
						<label>名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="foreign_History.title" data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>国家：</label>
					</div>
					<div class="field">
						<select name="foreign_History.country" class="input"
							style="width: 200px; line-height: 17px;">
							<option value="美国历史">美国历史</option>
							<option value="英国历史">英国历史</option>
							<option value="日本历史">日本历史</option>
							<option value="韩国历史">韩国历史</option>
							<option value="朝鲜历史">朝鲜历史</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>图片：</label>
					</div>
					<div class="field">
						<input type="file" class="button bg-blue margin-left" id="image1"
							name="foreign_History.img_url" value="" style="float: left;">
					</div>
				</div>
				<div class="form-group">
					<div class="label" align="center">
						<label>类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="<%=type %>" readonly="readonly"
							name="foreign_History.type" data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" align="center">
						<label>详情URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="foreign_History.detail_url"
							data-validate="required:请输入详情URL" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>描述：</label>
					</div>
					<div class="field">
						<textarea name="foreign_History.description" class="input"
							data-validate="required:请输入描述"
							style="height: 200px; border: 1px solid #ddd;"></textarea>
						<div class="tips"></div>
					</div>
				</div>

				<div class="clear"></div>
				<div class="form-group">
					<div class="label" align="center">
						<label>时间：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="foreign_History.time" data-validate="required:请输入时间" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label" align="center">
						<label>作者：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="foreign_History.author" data-validate="required:请输入作者" />
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