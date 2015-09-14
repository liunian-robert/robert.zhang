<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/link/linkView.action">
	<input type="hidden" name="pageNum" value="${mp.pageNum}" />
	<input type="hidden" name="numPerPage" value="${mp.numPerPage}" />
</form><!-- style=" border-width:1px;" -->
 <div class="panelBar" >
			<ul class="toolBar">
				<li><span style="margin-left:-25px;">当前位置：友情链接管理 >>友情链接管理</span></li>
			</ul>
  </div>
<div class="pageContent">
<div class="panelBar">
		<ul class="toolBar">
				<li><a class="add" href="${pageContext.request.contextPath}/link/addView" target="dialog" rel="dialogid" resizable="false"  maxable="false" width="400" height="300"><span >添加友情链接</span></a></li>
				<li><a class="edit" href="${pageContext.request.contextPath}/link/modifyView?id={id}" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="400" height="300"><span >更新友情链接</span></a></li>
				<li><a class="delete" href="${pageContext.request.contextPath}/link/delete?id={id}" target="ajaxTodo" title="确定要删除吗"><span target="navTab">删除友情链接</span></a></li>
		</ul>
	</div>
	<div id="w_list_print">
	<table class="list" width="100%" layoutH="80">
				<thead>
					<tr height="25" style="text-align: center;">
								<th class="center" >序号</th>
								<th class="center">友情链接名称</th>
								<th class="center">友情链接地址</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach items="${mp.list}" var="link" varStatus="status">
					 <tr style="text-align: center;"height="20" rel="${link.id}" target="id">
					 		<td>${status.count+mp.flag}</td>
					 		<td>${link.name}</td>
					 		<td><a href="${link.link}" target="_blank" style="text-decoration: none;">${link.link}</a></td>
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
