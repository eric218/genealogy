package com.dct.swocean.util.loghelper;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dct.swocean.entity.LoggingEventVo;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import com.dct.swocean.util.loghelper.service.ILoggingEventService;

/**  
 * 日志操作controller 
 * Created by huangxueshan on 2018/4/18.
 */
@Controller
@RequestMapping("/log")
public class LogController {

	@Autowired
	private ILoggingEventService loggingEventService;
	
	/**
	 * 查询日志
	 * @param request
	 * @param json
	 * @return
	 */
	@RequestMapping("/queryLog")
	@ResponseBody
	public Response<?> queryLog(HttpServletRequest request,String json) {
	    JSONObject jsonObj = JSONObject.parseObject(json);
		String logType = jsonObj.getString("logType")==null?"":jsonObj.getString("logType");
        String userId = jsonObj.getString("userId")==null?"":jsonObj.getString("userId");
        String loginId = jsonObj.getString("loginId");
        String startDate = jsonObj.getString("startDate");
        String endDate = jsonObj.getString("endDate");
        List<LoggingEventVo> result = loggingEventService.queryLogsdtls(logType, userId, loginId, startDate, endDate);
		return ResponseUtlis.success(result);
	}
}
