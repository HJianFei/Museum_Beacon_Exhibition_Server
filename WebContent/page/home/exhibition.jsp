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
	<!-- 实例化 -->
	<script type="text/javascript">
		var test = new Vcity.CitySelector({
			input : 'citySelect'
		});
	</script>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 内容列表</strong> <a href=""
				style="float: right; display: none;">添加字段</a>
		</div>
		<form method="post"
			action="exhibition!getAllExhibitionByCity?pagenow=" id="listform">
			<div class="padding border-bottom">
				<ul class="search" style="padding-left: 10px;">
					<li><a class="button border-main icon-plus-square-o"
						href="page/home/exhibition_add.jsp"> 添加内容</a></li>

					<li>搜索：</li>
					<li>城市 <input type="text" name="city" class="input" value=""
						size="15" id="homecity_name" name="homecity_name"
						mod="address|notice" mod_address_source="hotel"
						mod_address_suggest="@Beijing|北京|53@Shanghai|上海|321@Shenzhen|深圳|91@Guangzhou|广州|80@Qingdao|青岛|292@Chengdu|成都|324@Hangzhou|杭州|383@Wuhan|武汉|192@Tianjin|天津|343@Dalian|大连|248@Xiamen|厦门|61@Chongqing|重庆|394@"
						mod_address_reference="cityid" mod_notice_tip="中文/拼音"
						style="width: 100px; line-height: 17px; display: inline-block" />
					</li>
					<li><input type="text" placeholder="请输入搜索关键字" name="tip"
						class="input" value=""
						style="width: 250px; line-height: 17px; display: inline-block" />
						<input type="submit" value="搜索"
						class="button border-main icon-search" /></li>
				</ul>
			</div>
		</form>
		<table class="table table-hover text-center">
			<!-- 查询结果 -->
			<c:if test="${request.exhibitions!=null }">
				<tr>
					<th width="100" style="text-align: left; padding-left: 20px;">ID</th>
					<th>图片</th>
					<th>展览名称</th>
					<th>城市</th>
					<th width="10%">时间</th>
					<th width="310">操作</th>
				</tr>
				<c:forEach items="${exhibitions }" var="s">
					<tr>
						<td style="text-align: left; padding-left: 20px;">${s.id}</td>

						<td width="10%"><img src="${s.img_url}" alt="" width="120"
							height="80" /></td>

						<td width="35%">${s.content}</td>

						<td>${s.type}</td>

						<td>${s.time}</td>

						<td><div class="button-group">
								<a class="button border-main" href="exhibition!update?flag=update&id=${s.id}"><span
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
								<form action="exhibition!getAllExhibitionByCity?city=&tip=" method="post">
									<a
										href="exhibition!getAllExhibitionByCity?city=&tip=&pagenow=1">
										第一页</a>&nbsp; <a
										href="exhibition!getAllExhibitionByCity?city=&tip=&pagenow=${pagenow - 1}">上一页</a>&nbsp;
									<a
										href="exhibition!getAllExhibitionByCity?city=&tip=&pagenow=${pagenow + 1}">下一页</a>&nbsp;
									<a
										href="exhibition!getAllExhibitionByCity?city=&tip=&pagenow=${pagecount}">最后一页</a>
									转跳到 <input type="text" maxlength="3" size="3" name="pagenow" />页
									<input style="height: 25px; width: auto; cursor: pointer"
										type="submit" value="转跳" />
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
				window.location.href = ("exhibition!delete?city=&tip=&pagenow=&id="+id);
			}
		}
	</script>
	<div id="jsContainer" class="jsContainer" style="height: 0">
		<div id="tuna_alert"
			style="display: none; position: absolute; z-index: 999; overflow: hidden;"></div>
		<div id="tuna_jmpinfo"
			style="visibility: hidden; position: absolute; z-index: 120;"></div>
	</div>
	<script type="text/javascript" src="js/fixdiv.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
</body>
</html>