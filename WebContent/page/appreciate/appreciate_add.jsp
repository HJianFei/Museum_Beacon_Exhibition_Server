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
<script type="text/javascript">
	var XHR = false;
	/*创建XMLHttpRequest对象*/
	function CreateXHR() {
		try {
			XHR = new ActiveXObject("msxm12.XMLHTTP");//检查能否用activexobject
		} catch (e1) {
			try {
				XHR = new ActiveXObject("microsoft.XMLHTTP");//检查能否用activexobject
			} catch (e2) {
				try {
					XHR = new XMLHttpRequest();//检查能否用本地javascript对象
				} catch (e3) {
					XHR = false;
					window.alert("创建XMLHttpRequest失败");
				}
			}
		}

	}

	/*发送ajax请求*/
	function sendRequest(museum) {
		CreateXHR(); //创建XMLHttpRequest对象
		var uri = "http://localhost:8080/BeaconSys/museum!listType?museum="
				+ museum;
		XHR.open("GET", uri, true);
		XHR.onreadystatechange = resultHander;
		XHR.send(null);
	}

	/*Ajax执行成功的回调函数*/
	function resultHander() {
		var f = document.getElementById("type");

		if (XHR.readyState == 4) {
			if (XHR.status == 200) {

				var types = XHR.responseText;
				var obj = JSON.parse(types);
				f.options.length = 1; //清空下啦框原本的选项
				for (var i = 0; i < obj.types.length; i++) //将取得的结果添加到下级的列表框中
				{
					f.add(new Option(obj.types[i]));
				}
			} else {
				alert("您所请求的页面有异常。");
			}
		}
	}
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="appreciate!save?title=&pagenow=&museum=广东省博物馆">
				<div class="form-group">
					<div class="label" align="center">
						<label>名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="appreciate.content" data-validate="required:请输入名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>博物馆：</label>
					</div>
					<div class="field">
						<select name="appreciate.museum_name" class="input"
							onchange="sendRequest(this.value)"
							style="width: 200px; line-height: 17px;">
							<option value="-1">--请选择--</option>
							<option value="广东省博物馆">广东省博物馆</option>
							<option value="旅顺博物馆">旅顺博物馆</option>
							<option value="安徽博物院">安徽博物院</option>
							<option value="陕西博物馆">陕西博物馆</option>
							<option value="福建博物院">福建博物院</option>
							<option value="大连现代博物馆">大连现代博物馆</option>
							<option value="广西博物馆">广西博物馆</option>
							<option value="吉林省博物馆">吉林省博物馆</option>
							<option value="山西博物馆">山西博物馆</option>
							<option value="四川博物馆">四川博物馆</option>
							<option value="天津博物馆">天津博物馆</option>
							<option value="江西博物馆">江西博物馆</option>
							<option value="湖北博物馆">湖北博物馆</option>
							<option value="河北博物院">河北博物院</option>
							<option value="河南博物院">河南博物院</option>
							<option value="湖南博物馆">湖南博物馆</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>文物分类：</label>
					</div>
					<div class="field">

						<select name="appreciate.type" class="input" id="type"
							style="width: 200px; line-height: 17px;">
							<option value="-1">--请选择--</option>
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
							name="appreciate.img_url" value="" style="float: left;">
					</div>
				</div>
				<div class="form-group">
					<div class="label" align="center">
						<label>详情URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value=""
							name="appreciate.detail_url" data-validate="required:请输入详情URL" />
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