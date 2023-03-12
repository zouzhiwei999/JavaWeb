<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		//加载
		$(function () {

			//验证码绑定点击事件
			$("#img_token").click(function () {
				this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			})

			//绑点失去焦点
			//用户名5-12位
			$("#username").blur(function () {
				//获取内容
				var username = $("#username").val();

				//ajax判断数据库中是否已经存在
				$.getJSON(
						"http://localhost:8080/book/userServlet",
						"action=ajaxExistsUsername&username=" + username,
						function (data) {
							if (data.existsUsername) {
								$("span.errorMsg").text("用户名已存在!");
							} else {
								$("span.errorMsg").text("用户名可以使用!");
								//验证格式
								var patt = /^\w{5,12}$/;
								if (!patt.test(username)){
									$("span.errorMsg").text("用户名错误!");
								} else if (patt.test(username)){
									$("span.errorMsg").text("");
								}
							}
						}
				);
			})

			//密码5-12位
			$("#password").blur(function () {
				//获取内容
				var password = $("#password").val();
				//验证格式
				var patt = /^\w{5,12}$/;
				if (!patt.test(password)){
					$("span.errorMsg").text("密码错误!");
				} else if (patt.test(password)){
					$("span.errorMsg").text("");
				}
			})

			//确认密码
			$("#repwd").blur(function () {
				//获取内容
				var repwd = $("#repwd").val();
				//获取密码
				var password = $("#password").val();

				//比较是否一致

				if (repwd != password){
					$("span.errorMsg").text("确认密码错误!");
				} else if (repwd == password){
					$("span.errorMsg").text("");
				}
			})

			//邮箱
			$("#email").blur(function () {
				//获取内容
				var email = $("#email").val();
				//验证格式
				var patt = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				if (!patt.test(email)){
					$("span.errorMsg").text("邮箱错误!");
				} else if (patt.test(email)){
					$("span.errorMsg").text("");
				}
			})

			//验证码
			$("#code").blur(function () {
				//获取内容
				var code = $("#code").val();
				// alert("你妹"+code+"的");

				//取出前后空格
				var s = $.trim(code);
				// alert("你妹"+s+"的");

				//验证码不为空
				if (s == null && s == ""){
					$("span.errorMsg").text("验证码不能为空!");
				} else {
					$("span.errorMsg").text("");
				}
			})

		})
	</script>

	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${ requestScope.msg }
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${ requestScope.username }" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value=" ${requestScope.username} " />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" id="code" name="code"/>
									<img id="img_token" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 120px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>