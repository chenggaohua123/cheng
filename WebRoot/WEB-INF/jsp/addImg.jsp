<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addImg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		/*图片预览模态框*/        
        #modal-div {
             visibility: hidden;    
             position: absolute;   /* 使用绝对定位或固定定位  */
             left: 0px;    
             top: 0px;
             width:100%;
             height:100%;
             text-align:center;
             z-index: 20;
             background-color: #ccc; 
             opacity: 1;   /* 背景半透明 */
        }
/* 模态框样式 */
        .modal-img{
             width:600px;
             height:600px
             margin: 300px auto;
             background-color: #fff;
             border:1px solid #000;
             padding:15px;
             text-align:center;
             z-index: 22;
             opacity: 1; 
        }
	</style>
	<script type="text/javascript" src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	var fileUrl="";
		function addimg(){
		}
		function getObjectURL(file) {  
		    var url = null ;   
		    if (window.createObjectURL!=undefined) {  
		      url = window.createObjectURL(file) ;  
		    } else if (window.URL!=undefined) {   
		      url = window.URL.createObjectURL(file) ;  
		    } else if (window.webkitURL!=undefined) {  
		      url = window.webkitURL.createObjectURL(file) ;  
		    }  
		    return url ;  
		}
		function showimg(event){
			var file=event.target.files[0];
			fileUrl=getObjectURL(file);
			
		}
		
		function show(){
			
			$("#myImg").attr("src",fileUrl);
			$("#modal-div").css("visibility","visible");
		}
		
		
		/*  function loadImageFile(event)

        {

                var image = document.getElementById('image');

                image.src = URL.createObjectURL(event.target.files[0]); 

        }; */
	</script>
  </head>
  
  <body>
  	<div id="modal-div"><img  alt="" src="" id="myImg" class="modal-img" ></div>
    <div>
    	<form action="<%=path %>/clothing/saveImg.html" name="clothingImg Myform" 
    		enctype="multipart/form-data" method="post">
    		
    		<div>
	    			<label for="clothingId">衣服货号</label>
	    			<select name="clothingId">
	    				<option value=0>全部类型</option>
	    				<c:forEach items="${clothingList }" var="clothing">
	    					<option value="${clothing.id }">${clothing.code}</option>
	    				</c:forEach>
	    			</select>
	    		<div class="img Myform">
	    			<label for="a_idPicPath">照片:</label>
	    			<input id="file"  type="file" name="a_idPicPath filename" onchange="showimg(event)" />
	    			<font color="red"></font>
	    			<input type="button" value="+" onclick="addimg()">
	    			<input type="button" value="预览" onclick="show()"/>
	    			
    			</div>
    			<div class="img">
	    			<label for="a_idPicPath">照片:</label>
	    			<input type="file" name="a_idPicPath"  />
	    			<font color="red"></font>
	    			<input type="button" value="+" onclick="addimg()">
    			</div>
    			<input type="submit" value="提交" />
    		</div>
    	</form>
    	
    	<!-- <form action="#" name="uploadForm" method="post" enctype="multipart/form-data">  

         <input type="file" name="upload" id="upload" onchange="loadImageFile(event)">

                <img id="image" src="" >

                <input type="submit" value="上传">

        </form>   -->
    </div>
  </body>
</html>
