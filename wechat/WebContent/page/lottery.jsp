<%@ page language="java" contentType="text/html; utf-8"
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
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>天使卓越</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.rotate.js"></script>
<script>
$(document).ready(function(){//奖 12
	var one=false;//防止重复点击
	$("#wheel").on("click",function(){
		if(one)return;
		one=true;
        var num=new Array();
        var p=100;//设置频率
        var sum=0;
        for(var i=1;i<=12;i++){
            sum=i*p+sum;
            num[i]=sum;
        }
        var large=num[12];//最大变化
        var nn=Math.round(Math.random()*large);
        var x=0;//第一个
        for(var y=1;y<=11;y++){//设置区间
            if(num[y]<nn&&nn<=num[y+1]){
                x=y;//依次增长
            }
        }
        var r=(30*x)+15+360*3;
	    $('#wheel').css('rotate',0);
	    $('#wheel').animate({rotate: r}, 3000);	
		x++;
		setTimeout(function(){
			$.ajax({
		           url:"<%=basePath%>lottery",
		           type:"POST",
		           data:"prizeId="+x,
		           success:function(data){
		        	   $('body').load("<%=basePath%>page/prize.jsp",{"flag":data});
		           }
			});
		},4000);
	});
});
</script>
<style>
        body{
            padding: 0px;
            margin: 0px;
            background-color: #fa4c29;
        }
        #wheel{
            margin: auto;
            width: 100%;
            height: 100%;
        }
        #arrow{
            margin: auto;
            width: 100%;
            height: 100%;
        }
        #head{
            margin: auto;
            width: 100%;
            height: 100%;
        }
        #w1{
            margin: auto;
        }
        #content{
            margin: auto;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div>
    <img id="head" src="<%=basePath%>img/head.png">
</div>
<div id="w1">
    <img id="wheel" src="<%=basePath%>img/wheel.png">
</div>
<div>
    <img id="arrow" src="<%=basePath%>img/arrow.png">
</div>
</body>
</html>