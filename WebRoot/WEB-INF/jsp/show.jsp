<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style type="text/css">
  		.content{background-color: rgba(0,0,0,0.3)}
  		#main{width:600px;margin:20px auto;}
  </style>
  <script type="text/javascript" src="<%=path %>/static/js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  	function subimtFrom(){
  		var repContent=$("#repContent").val();
  		var infoId=$("#infoId").val();
  		if(repContent==null || repContent==""){
  			$("#contentMessage").html("请填写回复内容");
  		}else if(repContent.length>200){
  			$("#contentMessage").html("字符长度不能超过200");
  		}else{
  			$.ajax({
  			"url" 		:	"<%=path%>/saveReplies.html",
  			"data"		:	{"infoId":infoId,"repContent":repContent},
  			"type"		:	"post",
  			"success"	:	callBack
  			});
  		}
  	
  		function callBack(data){
  			$("#replie").html(data);
  			$("#repContent").val("");
  		}
  	}
  	function comeback(){
  		window.location.href="<%=path %>/index.html";
  	}
  </script>
  </head>
 
  <body>
  	<!-- 提示栏 -->
  	
  	<!-- 页面内容 -->
    <div id="main" class="main">
    	<h1>${informations.title}</h1>
    	<div>发表于:<fmt:formatDate value="${informations.reportTime}" pattern="yyyy-MM-dd hh:mm:ss"/></div>
    	<div>${informations.content}</div>
    	<h2>读者回应</h2>
    	<div id="replie">
    	<c:if test="${informations.repliesList !=null}">
    	<c:forEach var="replies" items="${informations.repliesList}">
    		<div class="content">
    			<p>发表于:<fmt:formatDate value="${replies.replyTime}" pattern="yyyy-MM-dd 24HH:mm:ss" /></p>
    			<p>${replies.repContent}</p>
    		</div>
    	</c:forEach>
    	</c:if>
    	<c:if test="${informations.repliesList==null || informations.repliesList==''}">
				<p class="content">暂时没有评论</p>
		</c:if>
		</div>
    	
		<div id="from">
			<form action="<%=path %>/saveReplies.html" name="saveReplies" method="post">
				<p>快速回复(字数200以内)</p>
				<input type="hidden" name="infoId" id="infoId" value="${informations.id}">
				<textarea id="repContent" rows="2" cols="20" name="content"></textarea>
				<span id="contentMessage" style="color:red;"></span>
				<br/>
				<input type="button" onclick="subimtFrom()" value="提交 " />
				<input type="button" onclick="comeback()" value="换回首页"/>
			</form>
		</div>
    </div>
  </body>
</html>


















