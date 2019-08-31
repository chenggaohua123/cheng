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
	<link rel="stylesheet" type="text/css" href="<%=path %>/statics/style.css">
	 <style type="text/css">
  		.controller td{text-align: center};
  		
  </style>
  
  </head>
 
  <body>
  	
  	<div>
  		 <ul style="width:1200px;height:35px;line-height:35px;" class="Navmenu">
    		<li style="font-size:12px;padding-right:28px;">所有宝贝</li>
    	 	<c:forEach items="${typeList }" var="type" >
    			<li style="font-size:12px;padding-right:28px;"><a href="javascript:chooseType(${type.typeId })">${type.typeName }</a></li>
    		</c:forEach>
    	</ul>
    	<%-- <jsp:include page="/WEB-INF/jsp/common/title.jsp" /> --%>
  	</div>
  	<!-- 提示栏 -->
  	<div id="message">
  		<c:if test="${saveMessage!=null}">
  			<script type="text/javascript">
  				alert('${saveMessage}');
  			</script>
  		 </c:if>
  	</div>
  	<!-- 页面内容 -->
    <div id="main" class="main">
    	<div id="content" class="content clear">
    		<!-- 右侧 主内容-->
    		<div id="rightContent" class="rightContent">
    			<!-- 调节居中用 div-->
    			<div class="controller">
    			<!-- 标题 -->
    			<!-- <div><h2>会员管理</h2></div> -->
    			<!-- 查询部分 -->
    			
  
    				
    			<div id="pics " class="clearfix">
    				<c:forEach var="clothing" items="${clothingList}" varStatus="statu">
    					<div class="pic" style="float:left;height: 255px;margin-top: 30px;" >
    					<dl>
    						<dt><img src="statics/uploadfiles/${clothing.imgList[0].imgName}"></dt>
    						<%-- <dd>count:${statu.count }</dd>
    						<dd>index:${statu.index }</dd> --%>
    						<dd >
    							<c:forEach var="image" items="${clothing.imgList}">
    								<img src="statics/uploadfiles/${image.imgName }" >
    							</c:forEach>
    						</dd>
    						<dd><font color="red">折后价:￥${clothing.discountprice}</font></dd>
    						<dd>${clothing.title}</dd>
    						<%-- <dd>${clothing.type.typeName }</dd> --%>
    					</dl>
    					</div>
    				</c:forEach>
				</div>
    			<!-- 分页部分 -->
	    			<div id="page" class="page">
	    				<ul>
	    					<!-- 处理首页和上一页 -->
	    					<c:if test="${page.currentPageNo<=1 }">
	    						<li><a href="javascript:return false;" style="opacity: 0.2">首页</a></li>
	    						<li>|&nbsp;<a href="javascript:return false;" style="opacity: 0.2">《上一页</a>&nbsp;&nbsp;|</li>
	    					</c:if>
	    					<c:if test="${page.currentPageNo>1 }">
	    						<li><a href="<%=path%>/index.html?currentPageNo=1">首页</a></li>
	    						<li>|&nbsp;<a href="<%=path%>/index.html?currentPageNo=${page.currentPageNo-1}">《上一页</a>&nbsp;&nbsp;|</li>
	    					</c:if>
	    					<!-- 处理末页和下一页 -->
	    					<c:if test="${page.currentPageNo>=page.totalPageCount }">
	    						<li><a href="javascript:return false;" style="opacity: 0.2">下一页》</a></li>
	    						<li>|&nbsp;<a href="javascript:return false;" style="opacity: 0.2">尾页</a></li>
	    					</c:if>
	    					<c:if test="${page.currentPageNo<page.totalPageCount }">
	    						<li><a href="<%=path%>/index.html?currentPageNo=${page.currentPageNo+1}">下一页》</a></li>
	    						<li>|&nbsp;<a href="<%=path%>/index.html?currentPageNo=${page.totalPageCount}">尾页</a></li>
	    					</c:if>
	    					<li>第${page.currentPageNo }页/共${page.totalPageCount }页</li>
	    					<li>(${page.totalCount })</li>
	    				</ul>
	    			</div>
    			<%-- </c:if> --%>
    			<!-- 如果不存查询条件的用户  message==false表示不存在数据-->
    			<c:if test="${informationsList==null}">
    				<h2>抱歉,暂无数据</h2>
    			</c:if>
    		</div>
    		</div>
    	</div>
    		
    	</div>
    	<script type="text/javascript">
    		function chooseType(id){
    			window.location.href="<%=path%>/clothing/index.html?id="+id;
    		}
    	</script>
  </body>
</html>
