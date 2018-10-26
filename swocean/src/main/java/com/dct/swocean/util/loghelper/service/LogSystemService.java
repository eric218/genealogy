package com.dct.swocean.util.loghelper.service;

import java.util.List;

import com.dct.swocean.entity.LogSystem;

public interface LogSystemService
{
    public LogSystem addLogSystem(String json);
    
    public List<LogSystem> queryLogSystem(String json);
}
