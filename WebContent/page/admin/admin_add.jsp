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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<base href="<%=basePath%>"></base>
<title>增加管理员</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span> 增加管理员</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="admin!save">
				<div class="form-group">
					<div class="label">
						<label for="sitename">管理员名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="mpass"
							name="admin.admin_name" size="50" placeholder="请输入管理员名称"
							data-validate="required:请输入管理员名称" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">手机号码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="mpass"
							name="admin.admin_phone" size="50" placeholder="请输入手机号码"
							data-validate="required:请输入手机号码" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" name="admin.admin_pwd"
							size="50" placeholder="请输入密码"
							data-validate="required:请输入密码,length#>=5:密码不能小于5位" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">确认密码：</label>
					</div>
					<div class="field">
						<input type="password" class="input w50" name="renewpass"
							size="50" placeholder="请再次输入密码"
							data-validate="required:请再次输入密码,repeat#admin.admin_pwd:两次输入的密码不一致" />
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