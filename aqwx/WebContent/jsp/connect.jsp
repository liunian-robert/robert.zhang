<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>联系我们—阿奇纹绣</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="纹绣,阿奇,纹媚">
	<meta http-equiv="description" content="这个页面是关于我们公司的基本信息">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
	<link href="${pageContext.request.contextPath}/css/templatemo_style_main.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nivo-slider.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/slimbox2.css" type="text/css" media="screen" /> 
	<script src="${pageContext.request.contextPath}/js/connect.js" type="text/javascript" charset="gbk"></script>
	<script src="${pageContext.request.contextPath}/js/site.js" type="text/javascript" charset="gbk"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/clearText.js">	</script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
	<script type="text/JavaScript" src="${pageContext.request.contextPath}/js/slimbox2.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.nivo.slider.js" type="text/javascript"></script>
	 <script src="${pageContext.request.contextPath}/js/jQuery-jcMarquee.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/slider.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/marquee.js"></script>
	<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"7","bdPos":"left","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
  </head>
  <body>
  	<span id="site"><a href="javascript:void(0);" onclick="setHome(this,'www.aqiwx.com')" title="设为首页">设为首页</a> | <a href="javascript:void(0);"onclick="addFavorite(window.location,document.title)" title="加入收藏">加入收藏</a> | <a href="tencent://message/?uin=${mp.company.qq1}"  title="联系我们">联系我们</a></span>
  	<div id="templatemo_wrapper">
    	<div id="templatemo_header">   
   	  	<div id="site_title"><h1><a href="http://www.aqiwx.com">阿奇@纹绣</a></h1></div>
       <!--  <div id="twitter"><a href="tencent://message/?uin=773970865" style="font-size:15px;">联系我们</a></div>         -->
    </div>
     <div id="templatemo_menu">
        <ul style="width:1200px;margin-left:45px;">
            <li><a href="http://www.aqiwx.com" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/about" class="current">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/news">新闻动态</a></li>
            <li><a href="${pageContext.request.contextPath}/product">产品简介</a></li>
            <li><a href="${pageContext.request.contextPath}/knowledge">专业知识</a></li>
            <li><a href="${pageContext.request.contextPath}/team">精英团队</a></li>
            <li><a href="${pageContext.request.contextPath}/train">培训加盟</a></li>
            <li><a href="${pageContext.request.contextPath}/student">学员风采</a></li>
            <li><a href="${pageContext.request.contextPath}/technology">技术收费</a></li>
        </ul>    	
    </div>
	<div id="slider_wrapper">
        <div id="slider">
            <c:forEach items="${mp.brochure}" var="brochure">
            	<a rel="lightbox[portfolio]"  href="${pageContext.request.contextPath}${brochure.image}"  title="${brochure.name}"><img src="${pageContext.request.contextPath}${brochure.image}"  title="${brochure.name}"/></a>
        	</c:forEach>
        </div>
	</div>      
    <div id="templatemo_main">
			<div class="col_w900 col_w900_last">
            	<div class="col_w280 float_l">
	            	<img src="${pageContext.request.contextPath}/images/product_class.jpg">
	            	<div class="lbe_box">
               		 	<ul class="tmo_list">
		                	<c:forEach items="${mp.productclass }" var="productclass">
		                		<li>>><a href="${pageContext.request.contextPath}/product?id=${productclass.id}">${productclass.name}</a></li>
		                		<div style="BORDER-TOP: silver 1px dashed; OVERFLOW: hidden; HEIGHT: 1px"></div>
		                    </c:forEach>
						</ul>
               		 </div>
               		 <img src="${pageContext.request.contextPath}/images/team.jpg">
	            	<div class="lbe_box" >
	            				<div id="Marquee_x" style="width:248px;margin-bottom:2px;height:237px;">
								    <ul style="margin-top:2px;margin-bottom:2px;">
								      <li>
								      	<c:forEach items="${mp.team}" var="team">
								        	<a href="${pageContext.request.contextPath}/teamDetail?id=${team.id}"><div><img height="231" width="160" src="${pageContext.request.contextPath}${team.image}" alt="${team.name}" /></div></a>
								       	</c:forEach>
								      </li>
								    </ul>
								 </div>
               		 </div>
                	<div class="lbe_box" style="background-color: #EEEEEE;background-image: url('${pageContext.request.contextPath}/images/join.jpg');background-repeat: no-repeat;">
               		 	<span><h6><font style="font-weight: bold;color:#EA2B7B;margin-left:50px;font-size: 15px;">加盟热线:${mp.company.phone1}</font></h6></span>
						<span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">全国客服：${mp.company.phone}</font></h6></span>              
		 				<br/>
		 				<span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">公司地址：${mp.company.adress}</font></h6></span>
		                <span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">直营店：${mp.company.adress2}</font></h6></span>
		                <span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">E—mail：${mp.company.email}</font></h6></span>
            			<br/>
            			<sapn><a href="${pageContext.request.contextPath}/connect"><img src="${pageContext.request.contextPath}/images/connect.jpg" width="80"/></a><a href="${pageContext.request.contextPath}/train" ><img src="${pageContext.request.contextPath}/images/cooperation.jpg" width="80"/></a><a href="tencent://message/?uin=${company.qq1}"><img src="${pageContext.request.contextPath}/images/answer.jpg" width="80"/></a></sapn>
               		 </div>
          </div>
          <div class="col_w580 float_r">
          	<%-- <img src="${pageContext.request.contextPath}/images/relation.jpg"/> --%>
          	<div style="width:650px;"><div style="float:left;"><img src="${pageContext.request.contextPath}/images/relation.jpg"/></div><div id="position" style="float:right;">>>当前位置：联系我们</div></div>
           	  <div class="post_box" style="font-size: 18px;padding:10px;">
           	  		 <span style="margin-top:10px;"><font style="font-weight: bold;color:#EA2B7B;">公司邮箱：</font>${mp.company.email}</span></br></br>
           	  		 <span style="margin-top:10px;"><font style="font-weight: bold;color:#EA2B7B;">公司地址：</font>${mp.company.adress}</span></br></br>
           	  		 <span style="margin-top:10px;"><font style="font-weight: bold;color:#EA2B7B;">直营店地址：</font>${mp.company.adress2}</span></br></br>
           	  		 <span style="margin-top:10px;"><font style="font-weight: bold;color:#EA2B7B;">公司电话：</font>${mp.company.phone1}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mp.company.phone2}</span></br></br>
           	  		 <span style="margin-top:10px;"><font style="font-weight: bold;color:#EA2B7B;">全国客服：</font>${mp.company.phone}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></br></br>
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
