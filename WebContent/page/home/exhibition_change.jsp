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
		<!-- 查询结果 -->
		<c:if test="${request.exhibition!=null}">
			<div class="body-content">
				<form method="post" class="form-x"
					action="exhibition!update?city=&tip=&pagenow=&flag=updated&id=${request.exhibition.id}">
					<div class="form-group">
						<div class="label" align="center">
							<label>ID：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.exhibition.id} " readonly="readonly"
								name="exhibition.id"/>
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label" align="center">
							<label>展览名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.exhibition.content}" name="exhibition.content"
								data-validate="required:请输入展览名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>图片：</label>
						</div>
						<div class="field">
							<input type="file" class="button bg-blue margin-left" id="image1"
								name="fileUrl" value="${request.exhibition.img_url}"
								style="float: left;">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>详情URL：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50"
								value="${request.exhibition.detail_url}"
								name="exhibition.detail_url" data-validate="required:请输入详情URL" />
							<div class="tips"></div>
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>城市：</label>
						</div>
						<div class="field">
							<input type="text" name="exhibition.type" class="input"
								value="${request.exhibition.type}" size="15" id="homecity_name"
								name="homecity_name" mod="address|notice"
								mod_address_source="hotel"
								mod_address_suggest="@Beijing|北京|53@Shanghai|上海|321@Shenzhen|深圳|91@Guangzhou|广州|80@Qingdao|青岛|292@Chengdu|成都|324@Hangzhou|杭州|383@Wuhan|武汉|192@Tianjin|天津|343@Dalian|大连|248@Xiamen|厦门|61@Chongqing|重庆|394@"
								mod_address_reference="cityid" mod_notice_tip="中文/拼音"
								style="width: 100px; line-height: 17px; display: inline-block" />
							<div class="tips"></div>
						</div>
					</div>


					<div class="form-group">
						<div class="label">
							<label>发布时间：</label>
						</div>
						<div class="field">
							<script src="js/laydate/laydate.js"></script>
							<input type="text" class="laydate-icon input w50"
								name="exhibition.time" value="${request.exhibition.time}"
								data-validate="required:日期不能为空"
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
		</c:if>
	</div>
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