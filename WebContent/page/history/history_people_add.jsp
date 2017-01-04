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
				action="chinaHistoryPeople!save?name=&pagenow=&type=上古">
				<div class="form-group">
					<div class="label" align="center">
						<label>名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="china_History_People.name"
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
							name="china_History_People.img_url" value="" style="float: left;">
					</div>
				</div>
				<div class="form-group">
					<div class="label" align="center">
						<label>详情URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="china_History_People.detail_url"
							data-validate="required:请输入详情URL" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>朝代：</label>
					</div>
					<div class="field">
						<select name="china_History_People.type" class="input w50">
							<option value="上古">上古</option>
							<option value="夏朝">夏朝</option>
							<option value="商朝">商朝</option>
							<option value="周朝">周朝</option>
							<option value="春秋战国">春秋战国</option>
							<option value="秦朝">秦朝</option>
							<option value="汉朝">汉朝</option>
							<option value="三国">三国</option>
							<option value="晋朝">晋朝</option>
							<option value="南北朝">南北朝</option>
							<option value="隋朝">隋朝</option>
							<option value="唐朝">唐朝</option>
							<option value="五代十国">五代十国</option>
							<option value="宋朝">宋朝</option>
							<option value="元朝">元朝</option>
							<option value="明朝">明朝</option>
							<option value="清朝">清朝</option>
							<option value="近代">近代</option>
							<option value="国际">国际</option>
						</select>
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