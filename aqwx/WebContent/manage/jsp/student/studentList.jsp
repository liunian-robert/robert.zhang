<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/student/studentView.action">
	<input type="hidden" name="pageNum" value="${mp.pageNum}" />
	<input type="hidden" name="numPerPage" value="${mp.numPerPage}" />
</form>
 <div class="panelBar" style=" border-width:1px;">
			<ul class="toolBar">
				<li><span style="margin-left:-25px;">当前位置：学员风采管理 >>学员风采管理</span></li>
			</ul>
  </div>
<div class="pageContent">
<div class="panelBar">
		<ul class="toolBar">
				<li><a class="add" href="${pageContext.request.contextPath}/student/addView" target="dialog" rel="dialogid" resizable="false"  maxable="false" width="600" height="450"><span >添加新学员</span></a></li>
				<li><a class="edit" href="${pageContext.request.contextPath}/student/modifyView?id={id}" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="600" height="450"><span >修改学员</span></a></li>
				<li><a class="delete" href="${pageContext.request.contextPath}/student/delete?id={id}" target="ajaxTodo" title="确定要删除吗"><span target="navTab">删除学员</span></a></li>
		</ul>
	</div>
	<div id="w_list_print">
	<table class="list" width="100%" layoutH="80">
				<thead>
					<tr height="25" style="text-align: center;">
								<th class="center" >序号</th>
								<th class="center">姓名</th>
								<th class="center">个人秀</th>
								<th class="center">个人特点</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach items="${mp.list}" var="student" varStatus="status">
					 <tr style="text-align: center;"height="20" rel="${student.id}" target="id">
					 		<td>${status.count+mp.flag}</td>
					 		<td>${student.name}</td>
					 		<td><a href=" ${pageContext.request.contextPath}/student/imageView?image=${student.image}" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="200" height="300" title="查看">点击查看</a></td>
					 		<td>${student.content }</td>
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
