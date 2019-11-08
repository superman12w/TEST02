<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#show").click(function(){
				$.getJSON('<%=path%>/showUserList.action','',function(rs){
					for(var i=0;i<rs.length;i++){
						var li=$("<li></li>");
						li.html(rs[i].userName+","+rs[i].mobile);
						$("#ul_user").append(li);
					}
				});
			});
		});
	</script>
  </head>
  
  <body>
    <button id="show">查看用户</button>
    <ul id="ul_user">
    
    </ul>
  </body>
</html>
