<!DOCTYPE html>  
<html>  
<head>  
<title>HTML5 WebSocket测试</title>  
</head>  
<!-- 消息区域 -->

<body>  
<div style="width:800px;height:800px;border: 1px solid red;position: relative">
    <div>
        <ul class="chat-thread" id="message">

        </ul>
    </div>
    <div style="position: absolute;bottom: 0;width: 100%;">
        <input id="msg"  placeholder="在这输入内容" style="width: 100%;height: 50px">
        <div style="position: absolute;bottom: 28%;right: 1%;">发送</div>
    </div>
</div>
   <!--  <p>  
        <input type=“button” value=“Start” onclick=“start()” />  
    </p>  
    <p id=“messages”></p>   -->
    <!-- <script type=“text/javascript”>  
        var webSocket = new WebSocket(‘ws://localhost:8080/swocean/websocket’);  
        socket = new WebSocket("ws://localhost:8090/ws");
        webSocket.onerror = function(event) {  
            alert(event.data);  
        };  
        //与WebSocket建立连接  
        webSocket.onopen = function(event) {  
            document.getElementById(‘messages’).innerHTML = ‘与服务器端建立连接’;  
        };  
        //处理服务器返回的信息  
        webSocket.onmessage = function(event) {  
            document.getElementById(‘messages’).innerHTML += ’<br />‘+ event.data;  
        };  
        function start() {  
            //向服务器发送请求  
            webSocket.send(‘我是jCuckoo’);  
        }  
    </script>   -->
    
    <script type="text/javascript">
    var ws=null;
    if(WebSocket){
    	ws=new WebSocket('ws://loclhost:/swocean/websocket');
    }else{
    	alert("浏览器不支持websocket");
    }
    
  //向服务端发送消息  
    ws.onopen = function(){
	  ws.send("用户已上线");
  }
  //接收服务器端发送的消息
  ws.onmessage = function(event){
	  ws.showMessage(event.data)
  }
  //将消息显示到页面中
  function showMessage(msg){
	  var message= $("#message");
	  var html=message.html;
	  html=html+"<li>"+msg"</li>"
  }

    </script>
    
</body>  
</html>