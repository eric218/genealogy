package com.dct.swocean.util.loghelper.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.dao.LoggingEventMapper2;
import com.dct.swocean.entity.LoggingEvent;
import com.dct.swocean.entity.LoggingEventVo;
import com.dct.swocean.util.loghelper.service.ILoggingEventService;

/**  
 * 日志操作service实现
 * Created by huangxueshan on 2018/4/18.
 */
@Service
@CacheConfig(cacheNames="loggingCache")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
public class LoggingEventServiceImpl implements ILoggingEventService {

	@Autowired
	private LoggingEventMapper2 loggingEventMapper;
	
	/**
	 * 日志查询
	 */
	@Override
	public List<LoggingEventVo> queryLogsdtls(String logType,String userId,String loginId,String startDate,String endDate) {
		String where = " where 1=1 ";
		if(!logType.isEmpty()){
		    where = where + " and arg0 = '"+ logType+"'";
		}
		if(!userId.isEmpty()){
		    where = where + " and arg1 = '"+ userId+"'";
		}
		if(!loginId.isEmpty()){
		    where = where + " and arg3 = '"+ loginId+"'";
		}
		if(!startDate.isEmpty()){
		    where = where + " and arg2 >= '"+ startDate+"'";
		}
		if(!endDate.isEmpty()){
            where = where + " and arg2 <= '"+ endDate+"'";
        }
		List<LoggingEvent> list = loggingEventMapper.queryLogsdtls(where);
		List<LoggingEventVo> result = logToVo(list);
		return result;
	}

	/**
	 * 将日志实体翻译为VO
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<LoggingEventVo> logToVo(List<LoggingEvent> list) {
		List<LoggingEventVo> result = new ArrayList<LoggingEventVo>();
		for (LoggingEvent log : list) {
			LoggingEventVo vo = new LoggingEventVo();
			vo.setAddTime(log.getArg2());
			vo.setCallerClass(log.getCallerClass());
			vo.setCallerFilename(log.getCallerFilename());
			vo.setCallerLine(vo.getCallerLine());
			vo.setCallerMethod(log.getCallerMethod());
			vo.setLogType(log.getArg0());
			vo.setLoginId(log.getArg3());
			vo.setUserName("通过ID查询");
			if(null!=log.getFormattedMessage()){
			    vo.setFormattedMessage(log.getFormattedMessage());
			    Map<String,Object> map = (Map<String, Object>) JSON.parse(log.getFormattedMessage());
	            vo.setChannel(map.get("channel")==null?"":(String) map.get("channel"));
	            vo.setIp(map.get("ip")==null?"":(String) map.get("ip"));
	            vo.setMac(map.get("mac")==null?"":(String) map.get("mac"));
	            vo.setStack(map.get("stack")==null?"":(String) map.get("stack"));
	            vo.setUrl(map.get("url")==null?"":(String) map.get("url"));
			}
			result.add(vo);
		}
		return result;
	}

}
