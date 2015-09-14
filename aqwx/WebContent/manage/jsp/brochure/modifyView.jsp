<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>更新宣传册</title>
  </head>
  
  <body>
            <div class="panelBar" style=" border-width:1px;">
                            <ul class="toolBar">
                                <li><span style="margin-left:-25px;">当前位置：宣传册管理 >> 更新宣传册</span></li>
                            </ul>
            </div>
            <div  class="pageContent">
                <form method="post" action="${pageContext.request.contextPath}/brochure/update" class="pageForm required-validate" enctype="multipart/form-data"    onsubmit="return iframeCallback(this, dialogAjaxDone);">
                        <div class="pageFormContent nowrap" style="overflow-x:hidden" layoutH="56">
                            <table style="margin-top:30px;margin-left:-10px;height:130px;">
                                <tbody style="text-align:right;">
                                      <tr class="nowrap"><td><label>宣传册名称：</label></td><td><input type="text" name="name" class="required" style="width:200px;" value="${brochure.name}" maxlength="600"/></td></tr>
                                      <tr><td><input type="hidden" name="id" value="${brochure.id}"/></td><td><input type="hidden" name="image" value="${brochure.image}"/></td></tr>
                                      <tr><td></td><td></td></tr>
                                      <tr class="nowrap"><td><label>原宣传册图片：</label></td><td><input type="text"  readonly="readonly"  name="xx" value="点击查看" style="width:200px;" maxlength="600" /><a class="btnLook" href="${pageContext.request.contextPath}/brochure/imageView?image=${brochure.image}"  lookupGroup="img" lookupPk="orgNum"resizable="false"  title="查看" maxable="false"  width="960" height="280" style="text-decoration: none;"></a></td></tr>
                                      <tr><td></td><td></td></tr>
                                      <tr class="nowrap"><td><label>新宣传册图片：</label></td><td align="left"><input type="file" name="fm"  style="width:200px;"  maxlength="600"/></td></tr>
                                     <tr class="nowrap">
                                        <td colspan="2">
                                            <div class="buttonActive"  style="margin-left:130px;"><div class="buttonContent"><button type="submit" >保存</button></div></div>
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
