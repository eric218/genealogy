package com.dct.swocean.util.loghelper;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.util.DateUtil;

/**  
 * 登录日志切面 
 * Created by huangxueshan on 2018/4/18.
 */
@Aspect
@Component
public class LogLoginAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(LogLoginAspect.class);
	
	/**
	 * 定义拦截规则：拦截com.dct.swocean.controller包下面登录方法
	 */
	@Pointcut("execution(* com.dct.swocean.controller.UserController.login(..)))")
	public void loginController() {
	}

	/**
	 * 切面方法执行前操作
	 * @param joinPoint
	 */
	@Before("loginController()") // 在调用上面 @Pointcut标注的方法前执行以下方法
	public void doBefore(JoinPoint joinPoint) {// 用于获取类方法
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpSession session = request.getSession();
		//通过session存取一些不方便获取的信息
        Map<String,Object> sessionMap = new HashMap<>();
        sessionMap.put("User-Agent", request.getHeader("User-Agent"));
        sessionMap.put("ip", request.getRemoteAddr());
        session.setAttribute(ConstantClassField.LOGIN_LOG,sessionMap);
	}
	
	/**
	 * 切面方法执行后操作
	 * @param joinPoint
	 */
	@SuppressWarnings("unchecked")
	@Async
    @After("loginController()")//无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter(JoinPoint joinPoint){
		//获取参数表数据
		Object[] objs = joinPoint.getArgs();
		Map<String,Object> map = (Map<String, Object>) JSON.parse(objs[1]==null?"":(String) objs[1]);
        //获取session信息
//      Map<String,Object> sessionMap = (Map<String, Object>) session.getAttribute(LogType.OPERATION.getCode());
//		map.putAll(sessionMap);
//		String mac = GetMacAddress.getMacInWindows(sessionMap.get("ip"));
//		String User_Agent = sessionMap.get("User-Agent");
//		String channel = "Windows";
//		if (User_Agent.contains("Android") || User_Agent.contains("Linux")) {
//			channel = "Android移动客户端";
//		} else if (User_Agent.contains("iPhone")) {
//			channel = "iPhone移动客户端";
//		} else if (User_Agent.contains("iPad")) {
//			channel = "iPad客户端";
//		}
//		map.put("channel", channel);
        String message = JSON.toJSONString(map);
		logger.info(message,ConstantClassField.LOGIN_LOG,"用户ID,从session取",DateUtil.getTime());
		
    }
	
	/**
	 * 切面方法返回结果后操作
	 * @param obj
	 */
	@Async
	@AfterReturning(returning = "obj",pointcut = "loginController()")//无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter(Object obj){
		
	}
	
	/**
	 * 定义拦截规则：拦截com.dct.swocean.controller包下面登出方法
	 */
	@Pointcut("execution(* com.dct.swocean.controller.UserController.login(..)))")
	public void logoutController() {
	}
}
