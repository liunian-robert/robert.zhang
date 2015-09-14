<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新产品信息</title>
  </head>
  
  <body>
			<div class="panelBar" style=" border-width:1px;">
							<ul class="toolBar">
								<li><span style="margin-left:-25px;">当前位置：产品信息管理 >> 更新产品信息动态</span></li>
							</ul>
			</div>
			<div  class="pageContent">
				<form method="post" action="${pageContext.request.contextPath}/product/update" class="pageForm required-validate"   enctype="multipart/form-data"  onsubmit="return iframeCallback(this, dialogAjaxDone);">
				  		<div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
				  			<table style="margin-top:30px;margin-left:-30px;height:130px;">
								<tbody style="text-align:right;">
									  <tr class="nowrap"><td><label>产品名称：</label></td><td><input type="text" name="name" class="required" style="width:437px;" value="${mp.name}" maxlength="600"/></td></tr>
									  <tr><td><input type="hidden" name="id" value="${mp.id}"/></td><td><input type="hidden" name="image" value="${mp.image}"/></td></tr>
									  <tr class="nowrap" ><td><label>原图片：</label></td><td style="text-align: left;"><input type="text"  readonly="readonly"  name="xxxx" value="点击查看" style="width:410px;border:0;" maxlength="600" /><a class="btnLook" href="${pageContext.request.contextPath}/product/imageView?image=${mp.image}"  lookupGroup="img" lookupPk="orgNum"resizable="false"  title="查看" maxable="false"  width="200" height="300" style="text-decoration: none;"></a></td></tr>
									  <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>新图片：</label></td><td><input type="file" name="fm" style="width:437px;" maxlength="600"/></td></tr>
									 <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>产品特色：</label></td><td><textarea class="required" name="content" rows="13" cols="70" >${mp.content}</textarea></td></tr>
									  <tr ><td></td><td></td></tr>
									  <tr  class="nowrap">
									  		<td><label>产品类别：</label></td>
									  		<td><input type="hidden" name="product.class_id"  value="${mp.class_id}"/>
													<input type="text"  disabled="disabled" readonly="readonly"  name="product.class_name"  value="${mp.class_name}"class="required" style="width:410px;" maxlength="600" />	
													<a class="btnLook" href="${pageContext.request.contextPath}/class/classView.action?method=suggest"  lookupGroup="product" resizable="false" maxable="false"  width="500" height="400" lookupPk="orgNum" title="查找" ></a>
											</td>
										</tr>
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
