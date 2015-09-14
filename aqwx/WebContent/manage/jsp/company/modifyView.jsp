<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新公司信息</title>
  </head>
  
  <body>
			<div class="panelBar" style=" border-width:1px;">
							<ul class="toolBar">
								<li><span style="margin-left:-25px;">当前位置：基本信息管理 >> 更新公司信息</span></li>
							</ul>
			</div>
			<div  class="pageContent">
				<form method="post" action="${pageContext.request.contextPath}/company/update" class="pageForm required-validate"   enctype="multipart/form-data"  onsubmit="return iframeCallback(this, dialogAjaxDone);">
				  		<div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
				  			<table style="margin-top:30px;margin-left:-30px;height:130px;">
								<tbody style="text-align:right;">
									  <tr class="nowrap"><td><label>公司名称：</label></td><td><input type="text" name="name" class="required" style="width:437px;" maxlength="600" value="${company.name}"/></td></tr>
									  <tr><td><input type="hidden" name="id" value="${company.id}"/></td><td><input type="hidden" name="image" value="${company.image}"/></td></tr>
									  <tr class="nowrap" ><td><label>原图片：</label></td><td style="text-align: left;"><input type="text"  readonly="readonly"  name="xxxx" value="点击查看" style="width:410px;border:0;" maxlength="600" /><a class="btnLook" href="${pageContext.request.contextPath}/company/imageView?image=${company.image}"  lookupGroup="img" lookupPk="orgNum"resizable="false"  title="查看" maxable="false"  width="200" height="300" style="text-decoration: none;"></a></td></tr>
									  <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>新图片：</label></td><td><input type="file" name="fm" style="width:437px;" maxlength="600"/></td></tr>
									 <tr><input type="hidden" name="logo" value="${company.logo}"/><td></td><td></td></tr>
									 <tr class="nowrap" ><td><label>原Logo：</label></td><td style="text-align: left;"><input type="text"  readonly="readonly"  name="xx1" value="点击查看" style="width:410px;border:0;" maxlength="600" /><a class="btnLook" href="${pageContext.request.contextPath}/company/imageView?image=${company.logo}"  lookupGroup="img" lookupPk="orgNum"resizable="false"  title="查看" maxable="false"  width="200" height="300" style="text-decoration: none;"></a></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>新Logo：</label></td><td><input type="file" name="lg" style="width:437px;" maxlength="600"/></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>全国客服：</label></td><td><input type="text" name="phone" class="required" style="width:437px;" maxlength="600" value="${company.phone}"/></td></tr>
									 <tr class="nowrap"><td><label>客服1：</label></td><td><input type="text" name="qq2" class="required" style="width:437px;" maxlength="600" value="${company.qq1}"/></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>客服2：</label></td><td><input type="text" name="qq1" class="required" style="width:437px;" maxlength="600" value="${company.qq2}"/></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>联系电话：</label></td><td><input type="text" name="phone1" class="required" style="width:437px;" maxlength="600" value="${company.phone1}"/></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>联系手机：</label></td><td><input type="text" name="phone2" class="required" style="width:437px;" maxlength="600" value="${company.phone2}"/></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>公司地址：</label></td><td><input type="text" name="adress" class="required" style="width:437px;" maxlength="600" value="${company.adress}"/></td></tr>
									  <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>直营店地址：</label></td><td><input type="text" name="adress2" class="required" style="width:437px;" maxlength="600" value="${company.adress2}"/></td></tr>
									 <tr><td></td><td></td></tr>
									 <tr class="nowrap"><td><label>公司Email：</label></td><td><input type="text" name="email" class="required" style="width:437px;" maxlength="600" value="${company.email}"/></td></tr>
									 <tr><td></td><td></td></tr>
									  <tr class="nowrap"><td><label>新闻内容：</label></td><td><textarea class="required" name="content" rows="7" cols="70" >${company.content}</textarea></td></tr>
									  <tr ><td></td><td></td></tr>
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
