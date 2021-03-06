<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>阿奇纹绣网站后台管理平台</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<link href="${pageContext.request.contextPath}/manage/js/dwz/themes/green/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${pageContext.request.contextPath}/manage/js/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${pageContext.request.contextPath}/manage/js/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${pageContext.request.contextPath}/manage/js/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="${pageContext.request.contextPath}/manage/js/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
 <script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/chart/raphael.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/chart/g.raphael.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/chart/g.bar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/chart/g.line.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/chart/g.pie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/manage/js/dwz/chart/g.dot.js"></script>

<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<c:if test="${none=='none'}">
	<script type="text/javascript">
			alert("用户名或密码错误,请重新登录!");
			window.location.href="${pageContext.request.contextPath}/manage/"
	</script>
</c:if>
<c:if test="${save_status=='success'}">
	<script type="text/javascript">
			alert("数据库备份成功!");
	</script>
</c:if>
<script src="${pageContext.request.contextPath}/manage/js/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	DWZ.init("${pageContext.request.contextPath}/manage/js/dwz/dwz.frag.xml", {
		loginUrl:"${pageContext.request.contextPath}/manage/jsp/loginDialog.jsp",loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${pageContext.request.contextPath}/manage/js/dwz/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
$(function(){
	$("#a").click(function(){
		if(confirm("确定要退出系统吗?")){
			return true;
		}
		return false;
	});
	$("#mid").click(function(){
		if(confirm("确定要退出系统吗?")){
			window.location.href="${pageContext.request.contextPath}/manage/exit";
		}
		return false;
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			 <div class="headerNav">
			    <a class="logo" href="http://www.aqiwx.com" target="_blank">标志</a>
				<ul class="nav" >
					<!-- <li id="switchEnvBox"><a href="javascript:void(0);"><span></span></a>
						<ul>
							<li><a href="sidebar_1.html">北京</a></li>
							<li><a href="sidebar_2.html">上海</a></li>
							<li><a href="sidebar_2.html">南京</a></li>
							<li><a href="sidebar_2.html">深圳</a></li>
							<li><a href="sidebar_2.html">广州</a></li>
							<li><a href="sidebar_2.html">天津</a></li>
							<li><a href="sidebar_2.html">杭州</a></li>
						</ul> -->
					</li>
					<!-- <li><a href="javascript:void(0);" target="_blank">捐赠</a></li>
					<li><a href="javascript:void(0);" target="_blank" >设置</a></li>-->
					<li><a href="javascript:void(0);">${date}</a></li>
					<li><a href="javascript:void(0);">${week}!</a></li> 
					<li><a href="javascript:void(0);">${user.name}&nbsp;&nbsp;欢迎您!</a></li>
					<li><a href="${pageContext.request.contextPath}/manage/exit" id="a">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div>蓝色</div></li>
					<li theme="green"><div class="selected">绿色</div></li>
					<!-- <li theme="red"><div>红色</div></li> -->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
			<!-- navMenu -->
			
		</div>

		<div id="leftside" >
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>阿奇纹绣后台管理平台</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
				         	  <li><a>公司基本信息管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/company/companyView" target="navTab" rel="w_table">基本信息管理</a></li>
										<li><a href="${pageContext.request.contextPath}/link/linkView" target="navTab" rel="w_table">友情链接管理</a></li>
										<li><a href="${pageContext.request.contextPath}/brochure/brochureView" target="navTab" rel="w_table">宣传册管理</a></li>
										<li><a href="${pageContext.request.contextPath}/movie/movieView" target="navTab" rel="w_table">视频管理</a></li>
									</ul>
								</li>
								<li><a>新闻动态管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/news/newsView" target="navTab" rel="w_table">新闻动态管理</a></li>
									</ul>
								</li>
							 <li><a>产品信息管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/class/classView" target="navTab" rel="w_table">产品类别管理</a></li>
										<li><a href="${pageContext.request.contextPath}/product/productView" target="navTab" rel="w_table">产品信息管理</a></li>
									</ul>
								</li>
								<li><a>纹绣技术管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/knowledge/knowledgeView" target="navTab" rel="w_table">纹绣技术管理</a></li>
									</ul> 
								</li>
								<li><a>精英团队管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/team/teamView" target="navTab" rel="w_table">精英团队管理</a></li>
									</ul>
								</li>
								<li><a>培训加盟管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/join/joinView" target="navTab" rel="w_table">培训加盟管理</a></li>
									</ul>
								</li>
								<li><a>学员风采管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/student/studentView" target="navTab" rel="w_table">学员风采管理</a></li>
									</ul>
								</li>
								<li><a>技术收费管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/technology/technologyView" target="navTab" rel="w_table">技术收费管理</a></li>
									</ul>
								</li> 
								<li><a>系统管理</a>
									<ul>
										<li><a href="${pageContext.request.contextPath}/manage/managerView" target="navTab" rel="w_table">管理员管理</a></li>
										<li><a href="${pageContext.request.contextPath}/manage/saveDatabase" target="ajaxTodo" rel="w_table" title="确定进行数据库备份吗?">数据库备份</a></li>
										<li><a href="${pageContext.request.contextPath}/log/logView" target="navTab" rel="w_table">登陆日志</a></li>
										<li><a id="mid" href="${pageContext.request.contextPath}/manage/exit" rel="w_table">退出系统</a></li>
									</ul>
								</li>
					   </ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					 <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin"  -->
						 <ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">基本信息</span></span></a></li>
						</ul>
					</div>
					 <div class="tabsLeft tabsLeftDisabled">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight tabsRightDisabled">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				 <ul class="tabsMoreList">
					<li><a href="javascript:;">基本信息</a></li>
				</ul>
				 <div class="navTab-panel tabsPageContent layoutBox">
				 		<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
							</div>
							<div class="right">
							</div>
							<p><span>阿奇纹绣公司基本信息</span></p>
							<p style="margin-left:120px;">阿奇纹绣官方网站:<a href="http://www.aqiwx.com" target="_blank">${company.site}</a></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							
							<p style="color:red">阿奇纹绣官方微博 :<a href="#" target="_blank">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;http://weibo.com/aqiwx</a></p>
							<p style="color:red">阿奇纹绣官方微群:<a href="#" target="_blank"></a></p>

<div class="divider"></div>
<h2>阿奇纹绣公司地址:</h2>
<p style="margin-left:120px;">${company.adress}</p>

<div class="divider"></div>
<h2>阿奇纹绣联系方式:</h2>
<div class="unit" style="margin-left:120px;">官方客服1(qq)：${company.qq1}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;官方客服2(qq)：${company.qq2}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;官方Email：${company.email }</div>
<div class="unit" style="margin-left:120px;">联系电话：${company.phone1}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系手机：${company.phone2 }</div>

<div class="divider"></div>
<h2>阿奇纹绣公司图片:</h2>
<pre style="margin:5px;margin-left:120px;line-height:1.4em">
<a href="${pageContext.request.contextPath}/company/imageView?image=${company.image}&&flag=company" target="dialog" rel="dialogid" resizable="false"  maxable="false"  width="600" height="500" title="查看"><img src="${pageContext.request.contextPath}${company.image}" width="50" height="50"/></a>
<!-- Error loading XML document: dwz.frag.xml
直接用IE打开index.html弹出一个对话框：Error loading XML document: dwz.frag.xml
原因：没有加载成功dwz.frag.xml。IE ajax laod本地文件有限制, 是ie安全级别的问题, 不是框架的问题。
解决方法：部署到apache 等 Web容器下。 -->
</pre>

<div class="divider"></div>
<h2>阿奇公司简介:</h2>
<pre style="margin:5px;margin-left:120px;line-height:1.4em;">
	${company.content}
</pre>
</div>
						
						<!-- <div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
							<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div> -->
					</div>
					
				</div>
				</div>
			</div>
	</div> 
	</div>
 <div id="footer">Copyright &copy; 2020 <a href="http://www.zzu.edu.cn" target="_blank" style="text-decoration: none;">郑州大学java实验室</a></div>
</div>
</body>
</html>