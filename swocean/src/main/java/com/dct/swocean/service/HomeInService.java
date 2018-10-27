package com.dct.swocean.service;

import com.dct.swocean.entity.*;

import java.util.List;

public interface HomeInService {

    //地区捐款总人数
    DontionAreaInfo countDonor(String areaCode);

    // 查询地区最新捐款流水
    List<Donor> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize);

    //地区个人文章总数
    ArticleAreaInfo countArticle(String areaCode, String type, String status);

    //地区活跃宗亲
    List<ArticlerInfo> select(String areaCode, String status, String type, Integer pageNo, Integer pageSize);

    //地区个人视频数
    UserVideoInfo countVideo(String area, String type, String status);

    //地区活跃宗亲
    List<ArticlerInfo> selectByAreaCode(String areaCode, String status, String type, Integer pageNo, Integer pageSize);
}
