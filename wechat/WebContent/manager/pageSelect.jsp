<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>天使卓越</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery.mobile-1.4.5.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.mobile-1.4.5.min.js"></script>
<style type="text/css">
.ui-page{  
background:#f1fbae;
}
</style>
</head>
<body>
<input type="button" value="设置奖品" onclick="logina()">
<input type="button" value="奖品发送" onclick="loginb()">
<input type="button" value="注销登录" onclick="loginc()">
<script type="text/javascript">
function logina(){
 	window.location.href="<%=basePath%>manager/prizeContent.jsp";
}
function loginb(){
 	window.location.href="<%=basePath%>manager/users.jsp";
}
function loginc(){
 	window.location.href="<%=basePath%>manager/users.jsp?clearAdmin=1";
}
</script>
</body>
</html>