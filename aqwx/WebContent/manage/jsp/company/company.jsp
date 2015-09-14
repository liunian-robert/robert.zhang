<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/company/companyView.action">
	<input type="hidden" name="pageNum" value="${mp.pageNum}" />
	<input type="hidden" name="numPerPage" value="${mp.numPerPage}" />
</form>
 <div class="panelBar" style=" border-width:1px;">
			<ul class="toolBar">
				<li><span style="margin-left:-25px;">当前位置：基本信息管理 >>基本信息管理</span></li>
			</ul>
  </div>
<div class="pageContent">
<div class="panelBar">
		<ul class="toolBar">
				<li><a class="edit" href="${pageContext.request.contextPath}/company/modifyView?id={id}" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="600" height="550"><span >修改公司基本信息</span></a></li>
		</ul>
	</div>
	<div id="w_list_print">
	<table class="list" width="100%" layoutH="80">
				<thead>
					<tr height="25" style="text-align: center;">
								<th class="center" >序号</th>
								<th class="center">公司名称</th>
								<th class="center">公司Logo</th>
								<th class="center">公司图片</th>
								<th class="center">公司地址</th>
								<th class="center">直营店地址</th>
								<th class="center">公司Email</th>
								<th class="center">全国客服</th>
								<th class="center">公司客服(qq)1</th>
								<th class="center">公司客服(qq)2</th>
								<th class="center">联系电话</th>
								<th class="center">联系手机</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach items="${mp.list}" var="company" varStatus="status">
					 <tr style="text-align: center;"height="20" rel="${company.id}" target="id">
					 		<td>${status.index+1}</td>
					 		<td>${company.name}</td>
					 		<td><a href=" ${pageContext.request.contextPath}/company/imageView?image=${company.logo}" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="200" height="300" title="查看">点击查看</a></td>
					 		<td><a href=" ${pageContext.request.contextPath}/company/imageView?image=${company.image}&&flag=company" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="200" height="300" title="查看">点击查看</a></td>
					 		<td>${company.adress }</td>
					 		<td>${company.adress2 }</td>
					 		<td>${company.email }</td>
					 		<td>${company.phone}</td>
					 		<td>${company.qq1}</td>
					 		<td>${company.qq2 }</td>
					 		<td>${company.phone1 }</td>
					 		<td>${company.phone2}</td>
					 	</tr>
				 </c:forEach>
			</tbody>
	</table>
	</div>
	<div class="panelBar" >
		<div class="pages">
			<span>显示</span>
			<select name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="5" <c:if test="${mp.numPerPage=='5' }">selected="selected"</c:if> >5</option>
			    <option value="10" <c:if test="${mp.numPerPage=='10' }">selected="selected"</c:if>>10</option>
			    <option value="15" <c:if test="${mp.numPerPage=='15' }">selected="selected"</c:if>>15</option>
			</select>
			<span>条,共${mp.totalCount}条,每页${mp.numPerPage}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${mp.totalCount}" numPerPage="${mp.numPerPage}" pageNumShown="${mp.totalPage}" currentPage="${mp.pageNum}"></div>
	</div>

</div>
  			
  </body>
</html>
