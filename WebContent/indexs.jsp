<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br /> 获取全部HomeViewPager的信息：
	<br /> http://localhost:8080/BeaconSys/viewPager!getAllViewPager
	<br />
	<br /> 获取全部青花瓷之约的信息:
	<br />
	http://localhost:8080/BeaconSys/appreciate!getAllAppreciate?appreciate.type=青花瓷之约
	<br />
	<br /> 获取全部珍品鉴赏的信息
	<br />
	http://localhost:8080/BeaconSys/appreciate!getAllAppreciate?appreciate.type=珍品鉴赏
	<br />
	<br /> 获取全部专题鉴赏的信息
	<br />
	http://localhost:8080/BeaconSys/appreciate!getAllAppreciate?appreciate.type=专题鉴赏
	<br />
	<br /> 获取全部自然标本的信息
	<br />
	http://localhost:8080/BeaconSys/appreciate!getAllAppreciate?appreciate.type=自然标本
	<br />
	<br /> 获取展览预告的信息
	<br />
	http://localhost:8080/BeaconSys/exhibition!getFirstExhibition?exhibition.type=0
	<br />
	<br />
	<br /> 获取常设展览的信息
	<br />
	http://localhost:8080/BeaconSys/exhibition!getFirstExhibition?exhibition.type=1
	<br />
	<br />
	<br /> 获取临时展览的信息
	<br />
	http://localhost:8080/BeaconSys/exhibition!getFirstExhibition?exhibition.type=2
	<br />
	<br />
	<br /> 获取展览回顾的信息
	<br />
	http://localhost:8080/BeaconSys/exhibition!getFirstExhibition?exhibition.type=3
	<br />
	<br /> 获取全部展览的信息type=0,1,2,3代表展览预告，常设展览，临时展厅，展览回顾
	<br />
	http://localhost:8080/BeaconSys/exhibition!getAllExhibition?exhibition.type=0
	<br />
	<br /> 获取展览详情
	<br />
	http://localhost:8080/BeaconSys/exhibition!getExhibitionDetails?detail_url=

</body>
</html>