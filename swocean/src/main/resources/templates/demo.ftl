<div style="text-align: center; color: red, font-size:20px">功德捐款,我捐款我光荣</div>
<img alt="" src="/tu.png" align="middle">
<br>
<!-- <form method="post" id="from1"
	action="http://localhost:8080/pay/wechatPay"> -->
 <form method="post" id="from1" action="http://192.168.2.151:8080/pay/aliPay"> 
	<input type="hidden" name="userId" value="user2018093014268912">
	选项金额: <input type="radio" name="money" value="1"> 1元 <input
		type="radio" name="money" value="5"> 5元 <input type="radio"
		name="money" value="10"> 10元 <input type="radio" name="money"
		value="100"> 100元 <br> 输入金额: <input type="number"
		name="money" placeholder="输入捐款金额">
	<button style="color: pink">确认</button>
	<br>
	<h3 style="color: green">支付平臺</h3>
	<input type="radio" name="action" value="1"> 支付宝 <input
		type="radio" name="action" value=2"> 微信支付 <input type="radio"
		name="action" value="3"> 找人代付
	<!-- <button onclick="ju()" style="color: red">支付捐款</button>  -->
	<input type="submit" value="支付捐款">
</form>
<!-- <script>
	function ju() {
		var a = domcument.get("action")
		var form1 = domcument.getElementById("form1")
		if (1 == a) {
			form1.submit() = "http://localhost:8080/aliPay";
		} else {
			form1.submit() = "http://localhost:8080/wechatPay";
		}
	}
</script> -->

