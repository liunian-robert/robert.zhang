<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录系统</title>
    <c:if test="${timeout=='timeout' }">
	<script language="javascript">
		alert("服务器超时,请重新登录!");
		window.location.replace("${pageContext.request.contextPath}/manage");
	</script>
</c:if>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manage/css/login.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/js/jquery-1.7.2.js"></script>
  	<script type="text/javascript" charset="gb2312">
				$(function(){
					$("input[name='submit']").click(function(){
						if($("input[name='name']").val()==""){
							alert("请输入用户名!");
							return false;
						}
						if($("input[name='password']").val()==""){
							alert("请输入用户密码!");
							return false;
						}
					});
					});  		
  	</script>
  </head>
  <body>
  				<form action="${pageContext.request.contextPath}/manage/login" method="post">
  					<table id="table">
  							<tr>
  									<td><input type="text" name="name" style="width:200px;"/></td>
  							</tr>
  							<tr><td></td><td></td></tr>
  							<tr><td></td><td></td></tr>
  							<tr>
  									<td><input type="password" name="password"style="width:200px;"/></td>
  							</tr>
  							<tr><td></td><td></td></tr>
  							<tr>
  									<td colspan="2">
  											<input type="submit" name="submit" value="登录" style="margin-left:30px;"/>
  											<input type="reset" name="reset" value="重置" style="margin-left:30px;"></td>
  							</tr>
  					</table>
  				</form>
  </body>
</html>
