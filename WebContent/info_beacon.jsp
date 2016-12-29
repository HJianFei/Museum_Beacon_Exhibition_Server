<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Beacon信息管理</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/beacon!save"
		method="post">
		<table>
			<tr>
				<td><h3>添加Beacon信息</h3></td>
			</tr>
			<tr>
				<td align="right">UUID：</td>
				<td align="left"><input type="text" name="beacon.uuid" /></td>
			</tr>
			<tr>
				<td align="right">蓝牙地址：</td>
				<td align="left"><input type="text" name="beacon.ble_address" />
				</td>
			</tr>
			<tr>
				<td align="right">Major：</td>
				<td align="left"><input type="text" name="beacon.major" /></td>
			</tr>
			<tr>
				<td align="right">Minor：</td>
				<td align="left"><input type="text" name="beacon.minor" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="提交" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>