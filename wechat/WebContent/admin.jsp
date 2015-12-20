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
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery.mobile-1.4.5.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.mobile-1.4.5.min.js"></script>
<title>天使卓越</title>
<style type="text/css">
#title{
text-align: center;
font-size: 20px;
font-weight: bold;
}
.ui-page{  
background:#f1fbae;
}
</style>
</head>
<body>
<div id="title">管理员密码</div>
<input type="text" id="password" placeholder="请输入密码">
<input type="button" value="登录" onclick="login()">
<script type="text/javascript">
function login(){
	var value=$("#password").val();
	$.ajax({
        url:"<%=basePath%>login",
        type:"POST",
        data:"password="+value,
        success:function(data){
 			if(data==1){
 				window.location.href="<%=basePath%>manager/pageSelect.jsp";
 			}
 			if(data==0){
 				alert("密码错误")
 			}
        }
    });
}
</script>
</body>
</html>