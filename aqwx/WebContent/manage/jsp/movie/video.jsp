<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/video/images/swfobject.js"></script>
				<div class="video" id="CuPlayer">
						<strong>系统友情提示：您的Flash Player版本过低，请<a href="https://get.adobe.com/cn/flashplayer/" target="_blank">点此进行网页播放器升级</a>！</strong>
				</div>
				<script type="text/javascript">
					var so = new SWFObject("${pageContext.request.contextPath}/js/video/CuPlayerMiniV4.swf","CuPlayerV4","590","450","9","#000000");
					so.addParam("allowfullscreen","true");
					so.addParam("allowscriptaccess","always");
					so.addParam("wmode","opaque");
					so.addParam("quality","high");
					so.addParam("salign","lt");
					so.addVariable("CuPlayerSetFile","${pageContext.request.contextPath}/js/video/CuPlayerSetFile.xml"); //播放器配置文件地址,例SetFile.xml、SetFile.asp、SetFile.php、SetFile.aspx
					so.addVariable("CuPlayerWidth","590"); 
					so.addVariable("CuPlayerHeight","450"); 
					so.addVariable("CuPlayerAutoPlay","yes"); 
					so.addVariable("CuPlayerImage","${pageContext.request.contextPath}/js/video/images/start.jpg");
					so.addVariable("CuPlayerLogo","${pageContext.request.contextPath}/js/video/images/logo.png"); 
					so.addVariable("CuPlayerPosition","bottom-right"); 
					so.addVariable("CuPlayerFile","${pageContext.request.contextPath}${movie.movie}"); 
					so.write("CuPlayer");
				</script>
</div>
  </body>
</html>
