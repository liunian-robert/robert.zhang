<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新产品类别</title>
  </head>
  
  <body style="background-repeat: no-repeat;background-position: center;background: url('${pageContext.request.contextPath}/Images/background.jpg');">
			<div class="panelBar" style=" border-width:1px;">
							<ul class="toolBar">
								<li><span style="margin-left:-25px;">当前位置：产品类别管理 >> 更新产品类别</span></li>
							</ul>
			</div>
			<div  class="pageContent">
				<form method="post" action="${pageContext.request.contextPath}/class/modify" class="pageForm required-validate"   enctype="multipart/form-data"  onsubmit="return validateCallback(this, dialogAjaxDone);">
				  		<div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
				  			<table style="margin-top:30px;margin-left:-30px;height:130px;">
								<tbody style="text-align:right;">
									  <tr class="nowrap"><td><label>产品类别名称：</label></td><td><input type="text" name="name" class="required" style="width:200px;" value="${productClass.name}" maxlength="600"/></td></tr>
									  <tr><td><input type="hidden" name="id" value="${productClass.id}"/></td><td></td></tr>
									 <tr class="nowrap">
										<td colspan="2">
											<div class="buttonActive"  style="margin-left:150px;"><div class="buttonContent"><button type="submit" >保存</button></div></div>
											<div class="button" style="margin-left:80px;"><div class="buttonContent"><button type="reset"  class="close">取消</button></div>
										</td>
									</tr>
								</tbody>
							</table>
							</div>
							 </form>
				 </div>
  </body>
</html>
