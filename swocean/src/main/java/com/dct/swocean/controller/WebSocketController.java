package com.dct.swocean.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.dct.swocean.entity.SysMessageInfo;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
@ServerEndpoint("/websocket")
public class WebSocketController {

	/*//初始化集合,用来存放每个客户端对应的服务器端的wesocket对象  
	private static CopyOnWriteArraySet<WebSocketController> server=
			new CopyOnWriteArraySet<WebSocketController>();*/
	@Autowired
	private SysWritingInfoService sysWritingInfoServer;
	
	private Session session=null;
	/** 
     * 当服务器接收到客户端发送的消息时所调用的方法 
     * 该方法可能包含一个javax.websocket.Session可选参数 
     * 如果有这个参数，容器将会把当前发送消息客户端的连接Session注入进去 
     */ 
    /*@OnMessage 
    public void onMessage(String message,Session session,HttpServletRequest request) throws IOException, InterruptedException {  
        // 打印从客户端获取到的信息  
        System.out.println("从客户端接收到的信息:" + message);  
        //向客户端第一次发送信息  
        session.getBasicRemote().sendText("=======向客户端第一次发送信息=======");  
        //每秒向客户端发送一次信息，连续发送3次  
        int sentMessages = 0;  
        while (sentMessages < 3) {  
            Thread.sleep(1000);  
            session.getBasicRemote().sendText("即时发送信息，当前是第 ” + sentMessages+“次…");  
            sentMessages++;  
        }  
        
      //获取用户在index页面输入的用户名  有待修改
    	String userName = request.getParameter("text");
    	sysWritingInfoServer.answer(userName, message);
        
        // 向客户端发送最后一次信息  
        session.getBasicRemote().sendText("=======向客户端发送最后一次信息=======");  
    }  */
    
   /* //像用户记录数据插入数据
    @OnMessage
    public void storage(String message,Session session,HttpServletRequest request) {
    	//获取用户在index页面输入的用户名  有待修改
    	String userName = request.getParameter("text");
    	sysWritingInfoServer.answer(userName, message);
    }*/
    /** 
     * 当一个新用户连接时所调用的方法 
     * 该方法可能包含一个javax.websocket.Session可选参数 
     * 如果有这个参数，容器将会把当前发送消息客户端的连接Session注入进去 
     */ 
    @OnOpen 
    public void onOpen(Session session) {  
    	this.session=session;
    	/*//加入刚刚创建的websocket
    	server.add(this);*/
        System.out.println("客户端连接成功");  
    }  
    
    //像客户端发送消息
    @OnMessage
    public void OnMessage(String msg) {
    	try {
			this.session.getBasicRemote().sendText(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    
    /** 当一个用户断开连接时所调用的方法*/ 
    @OnClose 
    public void onClose() {  
    	/*//删除关闭的用户
    	server.remove(this);*/
        System.out.println("客户端关闭");  
    }  
    
}
