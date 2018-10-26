package com.dct.swocean.util.loghelper.service;

import java.util.List;

import com.dct.swocean.entity.LoggingEventVo;

/**  
 * 日志操作service接口 
 * Created by huangxueshan on 2018/4/18.
 */
public interface ILoggingEventService {

    /**
     * 日志查询
     * @param logType
     * @param userId
     * @param loginId
     * @param startDate
     * @param endDate
     * @return
     */
	public List<LoggingEventVo> queryLogsdtls(String logType,String userId,String loginId,String startDate,String endDate);
}
