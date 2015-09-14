<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加管理员</title>
  </head>
  
  <body style="background-repeat: no-repeat;background-position: center;background: url('${pageContext.request.contextPath}/Images/background.jpg');">
			<div class="panelBar" style=" border-width:1px;">
							<ul class="toolBar">
								<li><span style="margin-left:-25px;">当前位置：新闻动态管理 >> 添加新闻动态</span></li>
							</ul>
			</div>
			<div  class="pageContent">
				<form method="post" action="${pageContext.request.contextPath}/product/addProduct" class="pageForm required-validate"  enctype="multipart/form-data"  onsubmit="return iframeCallback(this, dialogAjaxDone);">
				  		<div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
				  			<table style="margin-top:30px;margin-left:-30px;height:130px;">
								<tbody style="text-align:right;">
									  <tr class="nowrap"><td><label>产品名称：</label></td><td><input type="text" name="name" class="required" style="width:437px;" maxlength="600"/></td></tr>
									  <tr><td></td><td></td></tr>
									  <tr  class="nowrap">
									  		<td><label>产品类别：</label></td>
									  		<td><input type="hidden" name="product.class_id" />
													<input type="text"  disabled="disabled" readonly="readonly"  name="product.class_name" class="required" style="width:405px;" maxlength="600" />	
													<a class="btnLook" href="${pageContext.request.contextPath}/class/classView.action?method=suggest"  lookupGroup="product" resizable="false" maxable="false"  width="500" height="400" lookupPk="orgNum" title="查找" ></a>
											</td>
										</tr>
									  <tr class="nowrap"><td><label>产品图片：</label></td><td><input type="file" name="fm" class="required" style="width:437px;" maxlength="600"/></td></tr>
									 <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>产品特色：</label></td><td><textarea class="required" name="content" rows="13" cols="70" ></textarea></td></tr>
									  <tr ><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>添加日期：</label></td><td><input type="text" name="date" class="date"   style="width:420px;" maxlength="600"/>
     					 							<a class="inputDateButton" href="javascript:;"/></td></tr>
									 <tr class="nowrap">
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
