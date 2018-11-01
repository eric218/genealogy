package com.dct.swocean.util.loghelper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.dct.swocean.dao.LogSystemMapper2;
import com.dct.swocean.entity.LogSystem;
import com.dct.swocean.util.loghelper.service.LogSystemService;

@Service
@CacheConfig(cacheNames = "LogSystem")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class LogSystemServiceImpl implements LogSystemService
{
    @Autowired
    private LogSystemMapper2 logSystemMapper;
    
    @Override
    public LogSystem addLogSystem(String json)
    {
        JSONObject jsonObj = JSONObject.parseObject(json);
        LogSystem logSystem = new LogSystem();
        if(jsonObj.containsKey("addby")){
            logSystem.setAddby(jsonObj.getString("addby"));
        }
        if(jsonObj.containsKey("addTime")){
            logSystem.setAddTime(jsonObj.getDate("addTime"));
        }
        if(jsonObj.containsKey("description")){
            logSystem.setDescription(jsonObj.getString("description"));;
        }
        if(jsonObj.containsKey("loginId")){
            logSystem.setLoginId(jsonObj.getString("loginId"));
        }
        if(jsonObj.containsKey("objectId")){
            logSystem.setObjectId(jsonObj.getString("objectId"));
        }
        if(jsonObj.containsKey("remark")){
            logSystem.setRemark(jsonObj.getString("remark"));
        }
        if(jsonObj.containsKey("systemId")){
            logSystem.setSystemId(jsonObj.getIntValue("systemId"));
        }
        if(jsonObj.containsKey("tableCode")){
            logSystem.setTableCode(jsonObj.getString("tableCode"));
        }
        if(jsonObj.containsKey("tableName")){
            logSystem.setTableName(jsonObj.getString("tableName"));
        }
        if(jsonObj.containsKey("type")){
            logSystem.setType(jsonObj.getString("type"));
        }
        
        logSystemMapper.addLogSystem(logSystem);
        return null;
    }

    @Override
    public List<LogSystem> queryLogSystem(String json)
    {
        logSystemMapper.queryLogSystem(json);
        return null;
    }

}
