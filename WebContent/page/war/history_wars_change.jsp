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
			<strong><span class="icon-pencil-square-o"></span>修改内容</strong>
		</div>
		<c:if test="${request.war!=null}">
			<div class="body-content">
				<form method="post" class="form-x"
					action="chinaHistoryOldenWar!update?flag=updated&pagenow=&search=&type=古代战争&id=${request.war.id }">
					<div class="form-group">
						<div class="label" align="center">
							<label>ID：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${request.war.id}"
								readonly="readonly" name="china_History_Olden_War.id" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label" align="center">
							<label>名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${request.war.name}"
								name="china_History_Olden_War.name"
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
								name="china_History_Olden_War.img_url"
								value="${request.war.img_url}" style="float: left;">
						</div>
					</div>
					<div class="form-group">
						<div class="label" align="center">
							<label>详情URL：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.war.detail_url}"
								name="china_History_Olden_War.detail_url"
								data-validate="required:请输入详情URL" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>描述：</label>
						</div>
						<div class="field">
							<textarea name="china_History_Olden_War.description"
								class="input" style="height: 200px; border: 1px solid #ddd;">${request.war.description}</textarea>
							<div class="tips"></div>
						</div>
					</div>

					<div class="clear"></div>
					<div class="form-group">
						<div class="label">
							<label>战争类型： </label>
						</div>
						<div class="field">
							<select name="china_History_Olden_War.type" class="input"
								style="width: 200px; line-height: 17px;">
								<option value="古代战争">古代战争</option>
								<option value="近代战争">近代战争</option>
								<option value="外国战争">外国战争</option>
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
		</c:if>
	</div>
</body>
</html>