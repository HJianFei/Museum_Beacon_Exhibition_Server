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
<title>文物信息管理</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/cultural!save"
		method="post">
		<table>
			<tr>
				<td><h3>添加文物信息</h3></td>
			</tr>
			<tr>
				<td align="right">文物名称：</td>
				<td align="left"><input type="text" name="cultural.name" /></td>
			</tr>
			<tr>
				<td align="right">时间：</td>
				<td align="left"><input type="text" name="cultural.time" />
				</td>
			</tr>
			<tr>
				<td align="right">简介：</td>
				<td align="left"><input type="text" name="cultural.intro" /></td>
			</tr>
			<tr>
				<td align="right">图片：</td>
				<td align="left"><input type="text" name="cultural.img_url" /></td>
			</tr>
			<tr>
				<td align="right">视频：</td>
				<td align="left"><input type="text" name="cultural.video_url" /></td>
			</tr>
			<tr>
				<td align="right">音频：</td>
				<td align="left"><input type="text" name="cultural.voice_url" /></td>
			</tr>
			<tr>
				<td align="right">Major：</td>
				<td align="left"><input type="text" name="cultural.major" /></td>
			</tr>
			<tr>
				<td align="right">Minor：</td>
				<td align="left"><input type="text" name="cultural.minor" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="提交" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>