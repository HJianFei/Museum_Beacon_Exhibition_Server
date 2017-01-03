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
<link rel="stylesheet" href="css/cityselect.css">
<script src="js/cityselect.js"></script>
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 内容列表</strong> <a href="#"
				style="float: right; display: none;">添加字段</a>
		</div>
		<form method="post"
			action="chinaHistoryOldenWar!getWarsWeb?pagenow=&type=${request.type }"
			id="listform">
			<div class="padding border-bottom">
				<ul class="search" style="padding-left: 10px;">
					<li><a class="button border-main icon-plus-square-o"
						href="page/war/history_wars_add.jsp"> 添加内容</a></li>

					<li>搜索：</li>
					<li><input type="text" placeholder="请输入搜索关键字" name="search"
						class="input" value=""
						style="width: 250px; line-height: 17px; display: inline-block" />
						<input type="submit" value="搜索"
						class="button border-main icon-search" /></li>
				</ul>
			</div>
		</form>
		<table class="table table-hover text-center">
			<!-- 查询结果 -->
			<c:if test="${request.wars!=null }">
				<tr>
					<th>ID</th>
					<th>名称</th>
					<th>图片</th>
					<th>类型</th>
					<th width="10%">描述</th>
					<th width="310">操作</th>
				</tr>
				<c:forEach items="${wars}" var="s">
					<tr>
						<td>${s.id}</td>
						<td width="20%">${s.name}</td>

						<td width="10%"><img src="${s.img_url}" alt="" width="120"
							height="80" /></td>

						<td>${s.type}</td>

						<td width="30%" height="80">${s.description}......</td>

						<td><div class="button-group">
								<a class="button border-main"
									href="chinaHistoryOldenWar!update?flag=update&id=${s.id}"><span
									class="icon-edit"></span> 修改</a> <a class="button border-red"
									href="javascript:void(0)" onclick="return del(${s.id})"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<c:if test="${request.show != null }">
					<tr>
						<td colspan="8"><div class="pagelist">
								共${pagecount }页，当前第${pagenow }页
								<form
									action="chinaHistoryOldenWar!getWarsWeb?search=&type=${request.type }"
									method="post">
									<a class="button border-main"
										href="chinaHistoryOldenWar!getWarsWeb?search=&type=${request.type }&pagenow=1">
										第一页</a>&nbsp; <a class="button border-main"
										href="chinaHistoryOldenWar!getWarsWeb?search=&type=${request.type }&pagenow=${pagenow - 1}">上一页</a>&nbsp;
									<a class="button border-main"
										href="chinaHistoryOldenWar!getWarsWeb?search=&type=${request.type }&pagenow=${pagenow + 1}">下一页</a>&nbsp;
									<a class="button border-main"
										href="chinaHistoryOldenWar!getWarsWeb?search=&type=${request.type }&pagenow=${pagecount}">最后一页</a>
									转跳到 <input type="text" maxlength="3" size="3" name="pagenow" />页
									<input class="button border-main" type="submit" value="转跳" />
								</form>

							</div></td>
					</tr>
				</c:if>
			</c:if>
		</table>
	</div>
	<script type="text/javascript">
		//单个删除
		function del(id) {
			if (confirm("您确定要删除吗?")) {
				window.location.href = ("chinaHistoryOldenWar!delete?search=&type=古代战争&pagenow=&id="+id);
			}
		}
	</script>
</body>
</html>