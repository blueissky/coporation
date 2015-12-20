<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.ui-page{  
background:#f1fbae;
}
#title{
font-weight: bold;
}
</style>
</head>
<body>
<jsp:include page="/prizecontent"></jsp:include>
<table class="table">
<tr id="title">
<td>序号</td>
<td>名称</td>
<td>操作</td>
</tr>
	<c:forEach items="${list}" var="prizeContent">
		<tr>
		<td>${prizeContent.t_id}</td>
		<td><input type="text" value="${prizeContent.t_name}" id="${prizeContent.t_id}"></td>
		<td><input type="button" value="修改" onclick="alter(${prizeContent.t_id})"></td>
		</tr>
	</c:forEach>
</table>
<script type="text/javascript">
function alter(id){
	var text=$("#"+id).val();//获取修改的内容
	$.ajax({
	    url:"<%=basePath%>prizecontent",
	    type:"POST",
	    data:"id="+id+"&text="+text,
	    success:function(data){
	    	location.reload();
			}
		});
}
</script>
</body>
</html>