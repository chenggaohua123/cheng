<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 苹果男装管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
		var regId=/^\w+$/;
		var regPassword=/^\w+$/;
		
		
		function submitForm(){
			var id=$("#userCode").val();
			var password=$("#paz").val();
			var checkId=/^\w{5,16}$/;
			
			if(id==null || id==""){
			$("#reuserCode").html("用户名不能为空");
			}else if(password==null || password==""){
				$("#repassword").html("密码不能为空");
			}else if(!checkId.test(id)){
				$("#reuserCode").html("用户名长度5-16");
			}
			else{
				document.actionForm.submit();
			}
		}
		
    </script>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>苹果男装管理系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath }/dologin.html"  name="actionForm"   method="post" >
				<div class="info">${message }</div>
				<div class="inputbox">
                    <label for="user">用户名：</label>
					<input type="text" class="input-text" id="userCode" name="id" placeholder="请输入用户名"  required/> <div id="reuserCode" style="color:red;"></div>
				</div>	
				<div class="inputbox">
                    <label for="mima">密码：</label>
                    <input type="password" id="paz" name="password" placeholder="请输入密码" required/><div id="repassword" style="color:red;"></div>
                </div>	
				<div class="subBtn">
                    <input type="button" onclick="submitForm()" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
