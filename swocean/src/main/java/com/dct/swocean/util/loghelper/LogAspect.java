package com.dct.swocean.util.loghelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.ExceptionHandle;

/**  
 * 日志操作切面
 * Created by huangxueshan on 2018/4/18.
 */
//申明是个切面
@Aspect
//申明是个spring管理的bean
@Component
public class LogAspect {

	private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	/**
	 * 定义拦截规则：拦截com.dct.swocean.controller包下面的所有类中，有@RequestMapping注解的方法。 
	 */
	@Pointcut("execution(* com.dct.swocean.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logController(){
    }

	/**
	 * 切面方法执行前操作
	 * @param joinPoint
	 */
    @Before("logController()")//在调用上面 @Pointcut标注的方法前执行以下方法
    public void doBefore(JoinPoint joinPoint){//用于获取类方法
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
        HttpSession session = request.getSession();
        //通过session存取一些不方便获取的信息
        Map<String,Object> sessionMap = new HashMap<>();
        sessionMap.put("url", request.getRequestURI());
        sessionMap.put("method", request.getMethod());
        session.setAttribute(ConstantClassField.OPERATION_LOG,sessionMap);
    }

    /**
     * 切面方法执行后操作
     * @param joinPoint
     */
	@SuppressWarnings("unchecked")
	@Async
    @After("logController()")//无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter(JoinPoint joinPoint){
		//获取参数表数据
		Object[] objs = joinPoint.getArgs();
		Map<String,Object> map = new HashMap<String,Object>();
		String json = (String)objs[1];
/*		if(json!=null&&!json.isEmpty()){
		    map = (Map<String, Object>) JSON.parse(json);
		}*/
		
        //获取session信息
      	//Map<String,Object> sessionMap = (Map<String, Object>) session.getAttribute(ConstantClassField.OPERATION);
		//map.putAll(sessionMap);
        String message = json;
		logger.info(message,ConstantClassField.OPERATION_LOG,"用户ID,从session取",DateUtil.getTime(),"操作类型：增删改查导入导出，从参数表中获取");
		
    }

	/**
	 * 切面方法返回结果后操作
	 * @param obj
	 */
	@Async
    @AfterReturning(returning = "obj",pointcut = "logController()")//在调用上面 @Pointcut标注的方法后执行。用于获取返回值
    public void doAfterReturning(Object obj){
        
    }
	
	/**
	 * 切面方法抛出异常后操作
	 * 若controller层没有使用try catch时，此处捕获错误日志
	 * @param joinPoint
	 * @param ex
	 */
	@SuppressWarnings("unchecked")
	@Async
	@AfterThrowing(pointcut = "logController()",throwing="ex")
	public void doAfterThrowing(JoinPoint joinPoint,Throwable ex){
		//获取参数表数据
		Object[] objs = joinPoint.getArgs();
		Map<String,Object> map = (Map<String, Object>) JSON.parse(objs[1]==null?"":(String) objs[1]);
		map.put("stack", ExceptionHandle.printStackTraceToString(ex));
		map.put("message", ex.getMessage());
        //获取session信息
      	//Map<String,Object> sessionMap = (Map<String, Object>) session.getAttribute(LogType.OPERATION.getCode());
		//map.putAll(sessionMap);
        String message = JSON.toJSONString(map);
		logger.info(message,ConstantClassField.ERROR_LOG,"用户ID,从session取",DateUtil.getTime(),"操作类型：增删改查导入导出，从参数表中获取");
    }
}
