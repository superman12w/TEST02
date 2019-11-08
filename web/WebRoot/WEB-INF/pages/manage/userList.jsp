<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
<!--
	function dosubmit(pageIndex){
		document.getElementById('pageIndex').value=pageIndex;
		document.getElementById('queryUserForm').submit();
	}
//-->
</script>
<div class="m_right">
            <p></p>
            <div class="mem_tit">查看用户</div>
            <div>${msg }</div>
           	<form id="queryUserForm" action="${pageContext.request.contextPath }/manage/queryUser" method="post">
           	姓名：<input type="text" name="userName" value="${easybuy_user.userName }" /> ，账户:<input type="text" name="loginName" value="${easybuy_user.loginName }"/><br/>
           	性别：<input type="radio" name="sex" value="1" ${easybuy_user.sex==1?'checked':'' } />男，<input type="radio" name="sex" ${easybuy_user.sex==0?'checked':''} value="0" />女<br/>
           	电话：<input type="text" name="mobile" value="${easybuy_user.mobile }"/><br/>
           	<input type="hidden" name="pageIndex" id="pageIndex" />
           	<input type="submit" value="搜索" /> 
           	</form>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%">账户</td>
                <td width="25%">姓名</td>
                <td width="15%">性别</td>
                <td width="25%">电话</td>
                <td width="15%">操作</td>
              </tr>
              <c:forEach items="${pagebean.dataList}" var="user">
              	<tr>
                <td><font color="#ff4e00">${user.loginName }</font></td>
                <td>${user.userName }</td>
                <td>${user.sex==1?"男":"女" }</td>
                <td>${user.mobile }</td>
                <td><a href="">修改</a> <a href="${pageContext.request.contextPath }/manage/delUser/${user.id}">删除</a></td>
              </tr>
              </c:forEach>
            </table>
            <p style="text-align:center;font-size:16px;">
            一共${pagebean.pageCount }页，当前第${pagebean.pageIndex }页 
             <a href="javascript:;" onclick="dosubmit(1)">首页</a>  <a href="javascript:;" onclick="dosubmit(${pagebean.pageIndex-1 })">上一页</a> 
              <a href="javascript:;" onclick="dosubmit(${pagebean.pageIndex+1 })">下一页</a>  <a href="javascript:;" onclick="dosubmit(${pagebean.pageCount})">尾页</a> <br/>
       		</p>
        </div>