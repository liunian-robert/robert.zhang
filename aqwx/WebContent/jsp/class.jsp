<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>产品类别—阿奇纹绣</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="纹绣,阿奇,纹媚">
	<meta http-equiv="description" content="这个页面是关于我们公司产品分类信息">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
	<c:import url="${path}jsp/scriptOther.jsp" charEncoding="UTF-8"/>
  </head>
  <body>
  	<span id="site"><a href="javascript:void(0);" onclick="setHome(this,'www.aqiwx.com')" title="设为首页">设为首页</a> | <a href="javascript:void(0);"onclick="addFavorite(window.location,document.title)" title="加入收藏">加入收藏</a></span>
  	<div id="templatemo_wrapper">
    	<div id="templatemo_header">   
   	  	<div id="site_title"><h1><a href="${path}">阿奇@纹绣</a></h1></div>
        <div id="twitter"><a href="tencent://message/?uin=773970865" style="font-size:15px;">联系我们</a></div>        
    </div>
     <div id="templatemo_menu">
        <ul style="width:1200px;margin-left:45px;">
            <li><a href="${path}" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/about" >关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/news">新闻动态</a></li>
            <li><a href="${pageContext.request.contextPath}/product">产品简介</a></li>
            <li><a href="${pageContext.request.contextPath}/knowledge">专业知识</a></li>
            <li><a href="${pageContext.request.contextPath}/team">精英团队</a></li>
            <li><a href="${pageContext.request.contextPath}/train">培训加盟</a></li>
            <li><a href="${pageContext.request.contextPath}/student" class="current">学员风采</a></li>
            <li><a href="${pageContext.request.contextPath}/technology">技术收费</a></li>
        </ul>    	
    </div>
	<div id="slider_wrapper">
        <div id="slider">
            <a href="#"><img src="${pageContext.request.contextPath}/images/slideshow/01.jpg" alt="01" title="美女1"/></a>
            <a href="#"><img src="${pageContext.request.contextPath}/images/slideshow/02.jpg" alt="02" title="美女2"/></a>
            <a href="#"><img src="${pageContext.request.contextPath}/images/slideshow/03.jpg" alt="03" title="美女3"/></a>
            <a href="#"><img src="${pageContext.request.contextPath}/images/slideshow/04.jpg" alt="04" title="美女4"/></a>
            <a href="#"><img src="${pageContext.request.contextPath}/images/slideshow/05.jpg" alt="05" title="美女5"/></a>
        </div>
	</div>      
    <div id="templatemo_main">
			<div class="col_w900 col_w900_last">
            	<div class="col_w280 float_l">
	            	<img src="${pageContext.request.contextPath}/images/product_class.jpg">
	            	<div class="lbe_box">
               		 	<ul class="tmo_list">
	                		<li><a href="#">Nullam eget magna tellus</a></li>
	                   		<li><a href="#">Quisque a sapien tortor</a></li>
	                   		<li><a href="#">Aenean sit amet libero augue</a></li>
	                        <li><a href="#">Suscipit tincidunt gravida</a></li>
	                        <li><a href="#">Diam accumsan a auctor metus</a></li>
					    </ul>
               		 </div>
               		 <img src="${pageContext.request.contextPath}/images/team.jpg">
	            	<div class="lbe_box" >
	            				<div id="Marquee_x" style="width:248px;margin-bottom:2px;height:237px;">
								    <ul style="margin-top:2px;margin-bottom:2px;">
								      <li>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/1.jpg" alt="图片1" /></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/2.jpg" alt="图片2"/></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/3.jpg" alt="图片3"/></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/4.jpg" alt="图片4" /></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/5.jpg" alt="图片5"/></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/6.jpg" alt="图片1" /></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/7.jpg" alt="图片2"/></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/8.jpg" alt="图片3"/></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/9.jpg" alt="图片4" /></div></a>
								        <a href=""><div><img height="230" width="170" src="${pageContext.request.contextPath}/images/teacher/10.jpg" alt="图片5"/></div></a>
								      </li>
								    </ul>
								 </div>
               		 </div>
               		 <img src="${pageContext.request.contextPath}/images/join.jpg">
                	<div class="lbe_box">
                   		 <h3><a href="#">Nam scelerisque cursus dolor</a></h3>
                  		 <p> Nam sodales, pede vel dapibus lobortis, ipsum diam molestie risus, a vulputate risus nisl pulvinar lacus. Donec in nisi.</p>
                   		 <p class="date">June 24, 2048</p>
               		 </div>
          </div>
          <div class="col_w580 float_r">
          	<img src="${pageContext.request.contextPath}/images/about_message.jpg"/>
           	  <div class="post_box">
	        		<a class="more" href="#">Detail</a>
	                <div class="cleaner"></div>
              </div>
            </div>
            <div class="cleaner"></div>
		</div>
        <div class="cleaner"></div>
    </div> 
</div> 
<div id="templatemo_footer">   
        <ul class="footer_menu">
            <li><a href="${pageContext.request.contextPath}/about">关于我们 |</a></li>
            <li><a href="${pageContext.request.contextPath}/news">新闻动态 |</a></li>
            <li><a href="${pageContext.request.contextPath}/product">产品简介 |</a></li>
            <li><a href="${pageContext.request.contextPath}/knowledge">专业知识 |</a></li>
            <li><a href="${pageContext.request.contextPath}/team">精英团队 |</a></li>
            <li><a href="${pageContext.request.contextPath}/train">培训加盟 |</a></li>
            <li><a href="${pageContext.request.contextPath}/student">学员风采|</a></li>
            <li class="last_menu"><a href="${pageContext.request.contextPath}/technology">技术收费</a></li>
        </ul>
        Copyright © 2048 <a href="http://www.aqiwx.com">阿奇纹绣</a> <!-- Credit: www.aqiwx.com -->| 
        技术支持：<a href="http://www.zzu.edu.cn/" target="_blank">郑州大学java实验室</a>
</div>
  </body>
</html>
