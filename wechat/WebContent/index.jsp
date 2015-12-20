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
<!-- <link rel="stylesheet" href="css/jquery.mobile-1.4.5.css" /> -->
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script> -->
<title>天使卓越</title>
<style type="text/css">
	   body{
			padding: 0;
            margin: 0;
            background-color: #fcce30;
		}
		div{
        	width: 100%;
        }
        table{
        	width: 100%;
        }
		#head{
            top: 0px;
            width: 100%;
        }
        #foot{
            bottom: 0px;
            width: 100%;
        }
        #tel{
        	font-size: 18px;
        	width: 100%;
        	height: 30px;
        	background: transparent;
			border: 0; 
			text-align: center;
        }
        #button{
        	font-size: 18px;
        	width: 100%;
        	height: 30px;
        	margin: auto;
        	background: transparent;
        	border: 0;
			text-align: center;
        
        }
</style>
<script>
$(document).ready(function(){
/* 	var sw=window.screen.width;
	$("img").attr(width,sw);
	$("body").attr(width,sw); */
	$("#button").on("click", function(){
	var tel=$("#tel").val();
    var reg=/^1[0-9]{10}$/;
    var flag=tel.match(reg);
    if(flag==null){
        alert("请输入手机号码!")
        return;
    }
	$.ajax({
           url:"<%=basePath%>Login",
           type:"POST",
           data:"tel="+tel,
           success:function(data){
				if(data==2){
					alert("您已经抽过奖了！");
				}
				if(data==1){	
	        	   window.location.href="<%=basePath%>page/lottery.jsp";
				}
			  }
			});
		});
	});
</script>
</head>
<body>
	<div>
		<img id="head" src="<%=basePath%>img/head1.png">
	</div>
	<div id="middle">
		<input id="tel" type="text" placeholder="输入您的电话号码"><br>			
		<input id="button" type="button" value="开始抽奖">			
	</div>
	<div>
		<img id="foot" src="<%=basePath%>img/foot.png">
	</div>
</body>
</html>