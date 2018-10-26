package com.dct.swocean.entity;

/**  
 * 日志实体
 * Created by huangxueshan on 2018/4/18.
 */
public class LoggingEvent {
	
	private Long eventId;
	private Long timestmp;
	private String formattedMessage;
	private String loggerName;
	private String levelString;
	private String threadName;
	private Short referenceFlag;
	private String arg0;//日志类型
	private String arg1;//用户ID
	private String arg2;//日志记录时间
	private String arg3;//操作类型
	private String arg4;
	private String arg5;
	private String callerFilename;
	private String callerClass;
	private String callerMethod;
	private Character callerLine;
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getTimestmp() {
		return timestmp;
	}
	public void setTimestmp(Long timestmp) {
		this.timestmp = timestmp;
	}
	public String getFormattedMessage() {
		return formattedMessage;
	}
	public void setFormattedMessage(String formattedMessage) {
		this.formattedMessage = formattedMessage;
	}
	public String getLoggerName() {
		return loggerName;
	}
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	public String getLevelString() {
		return levelString;
	}
	public void setLevelString(String levelString) {
		this.levelString = levelString;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public Short getReferenceFlag() {
		return referenceFlag;
	}
	public void setReferenceFlag(Short referenceFlag) {
		this.referenceFlag = referenceFlag;
	}
	public String getArg0() {
		return arg0;
	}
	public void setArg0(String arg0) {
		this.arg0 = arg0;
	}
	public String getArg1() {
		return arg1;
	}
	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}
	public String getArg2() {
		return arg2;
	}
	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}
	public String getArg3() {
		return arg3;
	}
	public void setArg3(String arg3) {
		this.arg3 = arg3;
	}
	public String getArg4() {
		return arg4;
	}
	public void setArg4(String arg4) {
		this.arg4 = arg4;
	}
	public String getArg5() {
		return arg5;
	}
	public void setArg5(String arg5) {
		this.arg5 = arg5;
	}
	public String getCallerFilename() {
		return callerFilename;
	}
	public void setCallerFilename(String callerFilename) {
		this.callerFilename = callerFilename;
	}
	public String getCallerClass() {
		return callerClass;
	}
	public void setCallerClass(String callerClass) {
		this.callerClass = callerClass;
	}
	public String getCallerMethod() {
		return callerMethod;
	}
	public void setCallerMethod(String callerMethod) {
		this.callerMethod = callerMethod;
	}
	public Character getCallerLine() {
		return callerLine;
	}
	public void setCallerLine(Character callerLine) {
		this.callerLine = callerLine;
	}
	
	
}
