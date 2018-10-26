<h2>
	<font color="red">注册</font>
</h2>
<form action="/home/reg01" method="post">
	姓氏:<input type="text" name="surname" placeholder="輸入姓氏:如(王)"><br>
	用户名:<input type="text" name="username" placeholder="请输入用户名"><br>
	密码:<input type="password" name="password" placeholder="请输入6-16位密码"><br>
	確認密碼:<input type="password" name="password" placeholder="確認密碼"><br>
	手機號碼:<input type="number" name="mobilPhone" placeholder="请输入手机号码"><br>
	验证码:<input type="number" name="yanzheng" placeholder="请输入四位验证码">
	<!-- <button style="color: white; background-color: black;"
		onclick="windows.location.href='/send'">点击获取</button> -->
	<a href="#" onclick="windows.location.href='/home/send'">点击获取</a> <br> <input type="submit"
		value="注册"
		style="color: red; background-color: black; width: 100px; height: 30px">
</form>
<script>
	function send() {
		windows.location.href = '/send';
	}
</script>