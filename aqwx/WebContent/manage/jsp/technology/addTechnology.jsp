<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加技术收费信息</title>
  </head>
  
  <body style="background-repeat: no-repeat;background-position: center;background: url('${pageContext.request.contextPath}/Images/background.jpg');">
			<div class="panelBar" style=" border-width:1px;">
							<ul class="toolBar">
								<li><span style="margin-left:-25px;">当前位置：技术收费管理 >> 添加技术收费</span></li>
							</ul>
			</div>
			<div  class="pageContent">
				<form method="post" action="${pageContext.request.contextPath}/technology/addTechnology" class="pageForm required-validate"  enctype="multipart/form-data"  onsubmit="return iframeCallback(this, dialogAjaxDone);">
				  		<div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
				  			<table style="margin-top:30px;margin-left:-30px;height:130px;">
								<tbody style="text-align:right;">
									  <tr class="nowrap"><td><label>技术名称：</label></td><td><textarea class="required" rows="16" cols="70" name="name" ></textarea></td></tr>
									  <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>收费图片：</label></td><td><input type="file" name="fm" class="required" style="width:437px;" maxlength="600"/></td></tr>
									 <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>定价时间：</label></td><td><input type="text" name="date" class="date"   style="width:420px;" maxlength="600"/>
     					 							<a class="inputDateButton" href="javascript:;"/></td></tr>
									 <tr class="nowrap" height=12>
										<td colspan="2">
											<div class="buttonActive"  style="margin-left:250px;"><div class="buttonContent"><button type="submit" >保存</button></div></div>
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
