<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>阿奇纹绣</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="纹绣,阿奇,纹媚">
	<meta http-equiv="description" content="这个页面是我们网站的首页"/>
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
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/marquee.js">	</script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/video/images/swfobject.js"></script>
   <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"7","bdPos":"left","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
  </head>
  <body>
  	<span id="site"><a href="javascript:void(0);" onclick="setHome(this,'http://www.aqiwx.com')" title="设为首页">设为首页</a> | <a href="javascript:void(0);"onclick="addFavorite(window.location,document.title)" title="加入收藏">加入收藏</a> | <a href="tencent://message/?uin=${company.qq1}"  title="联系我们">联系我们</a></span>
  	<div id="templatemo_wrapper">
    <div id="templatemo_header">   
   	  	<div id="site_title"><h1><a href="http://www.aqiwx.com">阿奇@纹绣</a></h1></div>
        <!-- <div id="twitter"></div>         -->
    </div>
     <div id="templatemo_menu">
        <ul style="width:1200px;margin-left:25px;">
            <li><a href="http://www.aqiwx.com" class="current">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
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
        <div class="col_w900">
        <div>
            <div class="col_allw280 frontpage_box" style="word-break:break-all;">
                <img src="${pageContext.request.contextPath}/images/about.jpg"/><div class="cleaner"></div>
                 <img src="${pageContext.request.contextPath}${mp.company.image}" width="250px" height="207px" style="margin-top:2px;"/>
                <p style="padding:0px;">
               		${mp.company.content}<a href="${pageContext.request.contextPath}/about">[详细]</a>
                </p>
        		</div>
            <div class="col_allw280 frontpage_box" style="width:380px;word-break:break-all;">
              <img src="${pageContext.request.contextPath}/images/news.jpg"/> <div class="cleaner"></div>
              <div style="word-break:break-all;width:380px;">
						<c:forEach items="${mp.news}" var="news">
							<div style="width:380px;"><div class="new_div">>><a style="color:#000;font-weight:normal;"href="${pageContext.request.contextPath}/newsDetail?id=${news.id}">${news.name}</a></div><div class="float_r" style="height:12px;">[${news.date }]</div></div><div class="cleaner"></div>						
							<div style="BORDER-TOP: silver 1px dashed; OVERFLOW: hidden; HEIGHT: 1px;"></div>
						</c:forEach>
				</div>
				<br/>
                <a style="float:right;"  href="${pageContext.request.contextPath}/news">>>>更多</a>
            </div>
            <div class="col_allw280 frontpage_box col_last" >
                <script type="text/javascript" src="${pageContext.request.contextPath}/js/video/images/swfobject.js"></script>
				<div class="video" id="CuPlayer">
						<strong>阿奇纹绣提示：您的Flash Player版本过低，请<a href="https://get.adobe.com/cn/flashplayer/">点此进行网页播放器升级</a>！</strong>
				</div>
				<script type="text/javascript">
					var so = new SWFObject("${pageContext.request.contextPath}/js/video/CuPlayerMiniV4.swf","CuPlayerV4","250","268","9","#000000");
					so.addParam("allowfullscreen","true");
					so.addParam("allowscriptaccess","always");
					so.addParam("wmode","opaque");
					so.addParam("quality","high");
					so.addParam("salign","lt");
					so.addVariable("CuPlayerSetFile","${pageContext.request.contextPath}/js/video/CuPlayerSetFile.xml"); //播放器配置文件地址,例SetFile.xml、SetFile.asp、SetFile.php、SetFile.aspx
					so.addVariable("CuPlayerWidth","250"); 
					so.addVariable("CuPlayerHeight","250"); 
					so.addVariable("CuPlayerAutoPlay","yes"); 
					so.addVariable("CuPlayerImage","${pageContext.request.contextPath}/js/video/images/start.jpg");
					so.addVariable("CuPlayerLogo","${pageContext.request.contextPath}/js/video/images/logo.png"); 
					so.addVariable("CuPlayerPosition","bottom-right"); 
					so.addVariable("CuPlayerFile","${pageContext.request.contextPath}${mp.company.movie}"); 
					so.write("CuPlayer");
				</script>
			 <!--  <a class="more" href="javascript:void(0);" style="margin-top:28px;">更多</a> -->
            </div>
           </div>
           <div class="cleaner"></div>
        </div>
        <div class="col_w900">
            <div class="col_allw280 frontpage_box">
                <img src="${pageContext.request.contextPath}/images/team.jpg"/>
									<div id="Marquee_x" style="width:248px;height:237px;">
								    <ul style="margin-top:2px;">
								      <li>
								      	<c:forEach items="${mp.team}" var="team">
								        	<a href="${pageContext.request.contextPath}/teamDetail?id=${team.id}"><div><img height="231" width="160" src="${pageContext.request.contextPath}${team.image}" alt="${team.name}" /></div></a>
								       </c:forEach>
								      </li>
								    </ul>
  								</div>
        		</div>
            <div class="col_allw280 frontpage_box" style="width:380px;">
                <img src="${pageContext.request.contextPath}/images/skill.jpg"/>
                <div class="cleaner"></div>
                <div style="word-break:break-all;width:380px;">
						<c:forEach items="${mp.knowledge}" var="knowledge">
							<div style="width:380px;"><div class="new_div">>><a style="color:#000;font-weight:normal;"href="${pageContext.request.contextPath}/knowledgeDetail?id=${knowledge.id}">${knowledge.name}</a></div><div class="float_r" style="height:12px;">[${knowledge.date }]</div></div><div class="cleaner"></div>						
							<div style="BORDER-TOP: silver 1px dashed; OVERFLOW: hidden; HEIGHT: 1px;"></div>
						</c:forEach>
				</div>
                	<%-- <ul class="tmo_list">		
                		<c:forEach items="${mp.knowledge}" var="knowledge">
							<li>>><a href="${pageContext.request.contextPath}/knowledgeDetail?id=${knowledge.id}">${knowledge.name}</a><div style="float:right;margin-top:-22px;">[${knowledge.date }]</div></li>
							<div style="BORDER-TOP: silver 1px dashed; OVERFLOW: hidden; HEIGHT: 1px"></div>
						</c:forEach>
                	</ul> --%>
                	<br/>
                <a style="float:right;" href="${pageContext.request.contextPath}/knowledge">>>>更多</a>
            </div>
            <div class="col_allw280 frontpage_box col_last" style="background-color: #F3F0E8;background-image: url('${pageContext.request.contextPath}/images/join.jpg');background-repeat: no-repeat;">
                <%-- <img src="${pageContext.request.contextPath}/images/join.jpg"/> --%>
                 <div class="cleaner"></div>
                <span style="margin-top:10px;"><h6><font style="font-weight: bold;color:#EA2B7B;margin-left:50px;font-size: 15px;">加盟热线:${mp.company.phone1}</font></h6></span>
				 <span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">全国客服：${mp.company.phone}</font></h6></span>              
 				<br/>
 				<span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">公司地址：${mp.company.adress}</font></h6></span>
                <span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">直营店：${mp.company.adress2}</font></h6></span>
                <span><h6><font style="font-weight: bold;font-size:15px;color:#EA2B7B;">E—mail：${mp.company.email}</font></h6></span>
            	<br/>
            	<sapn><a href="${pageContext.request.contextPath}/connect"><img src="${pageContext.request.contextPath}/images/connect.jpg" width="80"/></a><a href="${pageContext.request.contextPath}/train" ><img src="${pageContext.request.contextPath}/images/cooperation.jpg" width="80"/></a><a href="tencent://message/?uin=${company.qq1}"><img src="${pageContext.request.contextPath}/images/answer.jpg" width="80"/></a></sapn>
            </div>
        		<div class="cleaner"></div>
        </div>        
        <div class="col_w900" style="height:300px;">
           	  <img src="${pageContext.request.contextPath}/images/product.jpg"/>
			<div id="Marquee_z">
			    <ul style="margin-top:2px;width:160px;">
			    	<li>
				     <c:forEach items="${mp.product }" var="product">
				         <a href="${pageContext.request.contextPath}/productDetail?id=${product.id}"><div><img height="210" width="160" src="${pageContext.request.contextPath}${product.image}" alt="${product.name }"/></div><div style="margin-top:210px;margin-left:-115px;text-decoration: none;"><a href="${pageContext.request.contextPath}/productDetail?id=${product.id}">${product.name}</a></div></a>
					 </c:forEach>
					 </li>
			    </ul>
			</div>
         </div>   
         <div class="cleaner"></div> 
         <div class="col_w900">
           	 <img src="${pageContext.request.contextPath}/images/href.jpg"/>
                <ul class="tmo_list">
                	<c:forEach items="${mp.link }" var="link">
                		<li>>><a href="${link.link }" target="_blank">${link.name}</a></li>
                		<div style="BORDER-TOP: silver 1px dashed; OVERFLOW: hidden; HEIGHT: 1px"></div>
                    </c:forEach>
				</ul>
         </div>   
         <div class="cleaner"></div>   
		</div>
      <div class="cleaner"></div>
      <span class="bottom"></span>      </div> 
    <!-- end of main -->
</div> <!-- end of templatemo_wrapper -->
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
