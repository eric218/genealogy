package com.dct.swocean.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dct.swocean.entity.LoggingEvent;

/**  
 * 日志查询mapper   
 * Created by huangxueshan on 2018/4/18.
 */
@Mapper
public interface LoggingEventMapper {

	@Select(value = { "select * from logging_event order by event_id " })
	public List<LoggingEvent> queryAllLoggingEvent();

	@Select(value = { "select * from logging_event ${where}" })
	public List<LoggingEvent> queryLogsdtls(@Param("where") String where);
}
