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
<title>首页轮播条</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_1").click(function() {
			$("#d_1").toggle();
		});
	});
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 内容列表</strong>
		</div>
		<div class="padding border-bottom">
			<button type="button" class="button border-yellow" id="btn_1">
				<span class="icon-plus-square-o"></span> 添加内容
			</button>
		</div>
		<!-- 查询结果 -->
		<c:if test="${request.viewPagers!=null }">
			<table class="table table-hover text-center">
				<tr>
					<th width="10%">ID</th>
					<th width="20%">图片</th>
					<th width="20%">描述</th>
					<th width="15%">操作</th>
				</tr>
				<c:forEach items="${viewPagers }" var="s">
					<tr>
						<td>${s.id}</td>
						<td><img src="${s.img_url}" alt="" width="120" height="50" /></td>
						<td>${s.content}</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="viewPager!update?flag=update&id=${s.id}"><span
									class="icon-edit"></span> 修改</a><a class="button border-red"
									href="javascript:void(0)" onclick="return del(1,${s.id})"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<script type="text/javascript">
		function del(id, mid) {
			if (confirm("您确定要删除吗?")) {
				window.location.href=("viewPager!delete?id="+mid);
			}
		}
	</script>
	<div class="panel admin-panel margin-top" id="d_1"
		style="display: none">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="viewPager!save"
				enctype="multipart/form-data">
				<div class="form-group">
					<div class="label">
						<label>详情URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="viewPager.detail_url"
							value="" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>图片：</label>
					</div>
					<div class="field">
						<input type="file" class="button bg-blue margin-left" id="image1"
							name="fileUrl" value="" style="float: left;">
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>描述：</label>
					</div>
					<div class="field">
						<textarea type="text" class="input" name="viewPager.content"
							style="height: 120px;" value=""></textarea>
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


	<!-- 查询结果 -->
	<c:if test="${request.viewPager2!=null}">
			<div class="panel admin-panel margin-top">
				<div class="panel-head">
					<strong><span class="icon-pencil-square-o"></span> 修改内容</strong>
				</div>
				<div class="body-content">
					<form method="post" class="form-x" action="viewPager!update?flag=updated&id=${request.viewPager2.id}"
						enctype="multipart/form-data">
						<div class="form-group">
							<div class="label">
								<label>ID：</label>
							</div>
							<div class="field">
								<input type="text" class="input w50" name="viewPager.id"
									value="${request.viewPager2.id}" readonly="readonly" />
								<div class="tips"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label>详情URL：</label>
							</div>
							<div class="field">
								<input type="text" class="input w50" name="viewPager.detail_url"
									value="${request.viewPager2.detail_url}" />
								<div class="tips"></div>
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label>图片：</label>
							</div>
							<div class="field">
								<input type="file" class="button bg-blue margin-left"
									id="image1" name="fileUrl" value="${request.viewPager2.img_url}"
									style="float: left;">
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label>描述：</label>
							</div>
							<div class="field">
								<textarea  class="input" name="viewPager.content"
									style="height: 120px;" >${request.viewPager2.content}</textarea>
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
	</c:if>
</body>
</html>