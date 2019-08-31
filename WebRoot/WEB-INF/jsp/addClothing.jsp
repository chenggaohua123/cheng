<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 添加衣服页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" enctype="multipart/form-data"
            		action="${pageContext.request.contextPath }/clothing/doSaveClothing">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="title"><font color="red">*</font>货号：</label>
                    <input type="text" name="code" id="code" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="title"><font color="red">*</font>名称：</label>
                    <input type="text" name="title" id="title" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="typeId"><font color="red">*</font>类型：</label>
                    <select id="typeId" name="typeId">
                    	<option value="" selected="selected">--请选择--</option>
                    	<c:forEach items="${typeList }" var="type">
                    		<option value="${type.typeId }">${type.typeName }</option>
                   	 	</c:forEach>
                    </select>
					<font color="red"></font>
                </div>
                <div>
                    <label for="size"><font color="red">*</font>尺码：</label>
                    <select id="size" name="size">
                    		<option value="" selected="selected">--请选择--</option>
                    		<option value="M">M</option>
                    		<option value="L">L</option>
                    		<option value="XL">XL</option>
                    		<option value="XXl">XXL</option>
                    		<option value="XXXl">XXXL</option>
                    </select>
					<font color="red"></font>
                </div>
                <div>
                    <label for="color">颜色：</label>
                    <input type="text" name="color" id="color" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="brand">品牌：</label>
                    <select  name="brand" id="brand">
                    	<option value="" selected="selected">--请选择--</option>
                    	<option value="pingguo">苹果</option>
                    	<option value="other">其它</option>
                    </select>
					<font color="red"></font>
                </div>
                <div>
                    <label for="number">衣服入库数量：</label>
					<input type="text" name="number" id="number">
                </div>
               <!--  <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div> -->
                <div>
                    <label for="oldprice">原价：</label>
					<input type="text" name="oldprice" id="oldprice" >
					<font color="red"></font>
                </div>
                <div>
                    <label for="discountprice">折后价：</label>
                    <input type="text" name="discountprice" id="discountprice" value=""> 
					<font color="red"></font>
                </div>
                
                <div>
                    <label for="listingTime">上市日期：</label>
                   <input type="text" name="listingTime" id="listingTime"  value="">
                   <font color="red"></font>
                </div>
                
                <div>
                    <label for="material">材质：</label>
                   <input type="text" name="material" id="material"  value="">
                   <font color="red"></font>
                </div>
                <!-- 上传个人证件照 -->
                 <div>
                    <label for="clothingImg">衣服照片:</label>
                    <div>
                    	<input type="file" name="clothingImg" > 
                    	<font><input type="button" value="+" onclick="addimg()"></font>
                    </div>
					<font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
        
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
