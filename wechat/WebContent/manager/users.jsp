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
<title>天使卓越</title>
<jsp:include page="/userlist"></jsp:include>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery.mobile-1.4.5.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
function del(x){
	$.ajax({
        url:"<%=basePath%>userlist",
        type:"POST",
        data:"del="+x,
        success:function(data){
        	location.reload();
        }
	});
}
</script>
<style type="text/css">
#tab{
text-align: center;
}
.ui-page{  
background:#f1fbae;
}
#title{
font-weight: bold;
}
</style>
</head>
<body>
<table class="table" id="tab">
<tr id="title">
	<td>中奖内容/电话</td>
	<td>时间</td>
	<td>操作</td>
</tr>
<c:forEach items="${list}" var="users">
<tr>
	<td>
	${users.t_prizename}<br>
	${users.t_tel}
	</td>
	<td>${users.t_time}</td>
	<td onclick="del(${users.t_id})">
		<input  type="button" value="送出"/>
	</td>		
</tr>
</c:forEach>
</table>
</body>
</html>