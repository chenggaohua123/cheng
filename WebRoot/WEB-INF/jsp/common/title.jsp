<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

   <%--  <base href="<%=basePath%>">
	<style type="text/css">
		li{
			list-style: none;
		} 
	</style>--%>
    <ul style="width:1200px;height:35px;line-height:35px;" class="Navmenu">
    	<li style="font-size:12px;padding-right:28px;"></li>
    	 <c:forEach items="${typeList }" var="type">
    		<li style="font-size:12px;padding-right:28px;"><a href="<%=path %>/clothing/index.html?typeId=${type.typeId}">${type.typeName }</a></li>
    	</c:forEach>
    </ul>

