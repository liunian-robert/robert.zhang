<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>查找产品类别</title>
</head>
<body>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/class/classView?method=suggest">
	<input type="hidden" name="pageNum" value="${mp.pageNum}" />
	<input type="hidden" name="numPerPage" value="${mp.numPerPage}" />
</form>
 <div class="panelBar" style=" border-width:1px;">
			<ul class="toolBar">
				<li><span style="margin-left:-25px; font-weight: bolder;">当前位置：产品信息管理 >> 查找产品类别</span></li>
			</ul>
  </div>
 <%--  <div class="pageHeader">
		  <form method="post" action="${pageContext.request.contextPath}/class/classView.action?method=suggest" onsubmit="return dwzSearch(this, 'dialog');">
		  	<input type="hidden" name="pageNum" value="${mp.currentPage}" />
			<input type="hidden" name="numPerPage" value="${mp.numPerPage}" />
		  <div class="searchBar">
	       <table class="searchContent">
				<tbody style="text-align:right;" >
					<tr>
						<td>
								<select name="selector">
							 			<option value="id" <c:if test="${mp.selector=='id' }">selected="selected"</c:if>>账户编号</label></option>
							 			<option  value="name" <c:if test="${mp.selector=='name' }">selected="selected"</c:if>><label >账户名称</label></option>
							 	</select>
						</td>
						<td><input type="text"  name="blank" value="${mp.blank}" style="width:300px;"/></td>
						<td>
                        <div class="buttonActive">
                          <div class="buttonContent">
                          <button type="submit">检索</button>
                          </div>
                        </div>
                       </td>
					</tr>
					</tbody>
		     </table>
		     </div>
	       </form>
	   </div> --%>
<div class="pageContent">
	<div id="w_list_print">
	<table class="list" width="100%" layoutH="50">
				<thead>
					<tr height="25" style="text-align: center;">
								<th class="center">序号</th>
								<th class="center">产品类别</th>
								<th class="center">请选择</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${mp.list}" var="productClass" varStatus="status">
					 <tr style="text-align: center;"height="20" rel="${productClass.id}" target="id">
					 		<td>${status.index+1}</td>
					 		<td>${productClass.name}</td>
					 		<td  class="center"><a class="btnSelect" href="javascript:$.bringBack({class_id:'${productClass.id}', class_name:'${productClass.name}'})" title="查找带回">选择</a></td>
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
			    <%-- <option value="10" <c:if test="${mp.numPerPage=='10' }">selected="selected"</c:if>>10</option>
			    <option value="15" <c:if test="${mp.numPerPage=='15' }">selected="selected"</c:if>>15</option> --%>
			</select>
			<span>条,共${mp.totalCount}条,每页${mp.numPerPage}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${mp.totalCount}" numPerPage="${mp.numPerPage}" pageNumShown="${mp.totalPage}" currentPage="${mp.pageNum}"></div>
	</div>

</div>		
  </body>
</html>
