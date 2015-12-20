<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<title>天使卓越</title>
<style type="text/css">
body {
	padding: 0;
    margin: 0;
	background-color: #fa4c29;
}
img{
	width:100%;
}
#head{
width: 200px;
margin: auto;
text-align: center;
}
#head,#head2{
font-family: "楷体";
font-size: 16px;
font-weight: bold;
}
#content{
width: 300px;
margin: auto;
margin-top: 30px;
text-align: center;
font-family: "楷体";
font-size: 16px;
font-weight: bold;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var flag=<%=request.getParameter("flag")%>;
	switch (flag){
	            case 1:
	              	$("#mineprize").text("天使计划D");
	            	break;
	            case 2:
	            	$("#mineprize").text("私募基金");
	                break;
	            case 3:
	              	$("#mineprize").text("天使计划C");
	            	break;
	            case 4:
	            	$("#mineprize").text("天使计划B");
	                break;
	            case 5:
	              	$("#mineprize").text("票据理财");
	            	break;
	            case 6:
	            	$("#mineprize").text("债券投资");
	                break;
	            case 7:
	              	$("#mineprize").text("天使计划A");
	            	break;
	            case 8:
	            	$("#mineprize").text("不要灰心");
	                break;
	            case 9:
	              	$("#mineprize").text("典当行");
	            	break;
	            case 10:
	            	$("#mineprize").text("融资租赁");
	                break;
	            case 11:
	              	$("#mineprize").text("天使计划E");
	            	break;
	            case 12:
	            	$("#mineprize").text("商业保理");
	                break;
	        }
});
</script>
</head>
<body>
<jsp:include page="/prizecontent"></jsp:include>
<div>
<img src="<%=basePath%>img/head.png">
</div>
<div id="head">
抽奖结果：<font id="mineprize"></font>
<div id="head2">参照表</div>
</div>
<div id="content">
    天使计划D：<c:out value="${p1}"></c:out><br>
    私募基金：<c:out value="${p2}"></c:out><br>
    天使计划C：<c:out value="${p3}"></c:out><br>
    天使计划B：<c:out value="${p4}"></c:out><br>
    票据理财：<c:out value="${p5}"></c:out><br>
    债券投资：<c:out value="${p6}"></c:out><br>
    天使计划A：<c:out value="${p7}"></c:out><br>
    不要灰心：<c:out value="${p8}"></c:out><br>
    典当行：<c:out value="${p9}"></c:out><br>
    融资租赁：<c:out value="${p10}"></c:out><br>
    天使计划E：<c:out value="${p11}"></c:out><br>
    商业保理：<c:out value="${p12}"></c:out><br>
</div>
</body>
</html>