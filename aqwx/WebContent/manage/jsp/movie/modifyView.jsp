<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新视频</title>
  </head>
  
  <body>
            <div class="panelBar" style=" border-width:1px;">
                            <ul class="toolBar">
                                <li><span style="margin-left:-25px;">当前位置：视频管理 >> 更新视频</span></li>
                            </ul>
            </div>
            <div  class="pageContent">
                <form method="post" action="${pageContext.request.contextPath}/movie/modify" class="pageForm required-validate"   enctype="multipart/form-data"  onsubmit="return iframeCallback(this, dialogAjaxDone);">
                        <div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
                            <table style="margin-top:30px;margin-left:-10px;height:130px;">
                                <tbody style="text-align:right;">
                                      <tr class="nowrap"><td><label>视频名称：</label></td><td  align="left"><input type="text" name="name" class="required" style="width:200px;" value="${movie.name}" maxlength="600"/></td></tr>
                                      <tr><td><input type="hidden" name="id" value="${movie.id}"/></td><td><input type="hidden" name="movie" value="${movie.movie}"/></td></tr>
                                      <tr class="nowrap"><td><label>原视频：</label></td><td  align="left"><input type="text"  readonly="readonly"  name="xxx" value="点击观看" style="width:200px;border:0;" maxlength="600" /><a class="btnLook" href="${pageContext.request.contextPath}/movie/seeVideo?movie=${movie.movie}"  lookupGroup="movie" lookupPk="orgNum"resizable="false"  title="视频观看" maxable="false"  width="600" height="500" style="text-decoration: none;"></a></td></tr>
                                      <tr><td></td><td></td></tr>
                                      <tr class="nowrap"><td><label>更新视频：</label></td><td align="left"><input type="file" name="fm" class="required" style="width:200px;" value="" maxlength="600"/></td></tr>
                                     <tr class="nowrap">
                                        <td colspan="2">
                                            <div class="buttonActive"  style="margin-left:150px;"><div class="buttonContent"><button type="submit" >保存</button></div></div>
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
