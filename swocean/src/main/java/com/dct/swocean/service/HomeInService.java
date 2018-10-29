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

    //姓氏图腾
    void update(String areaCode, String pic) throws Exception;

    //修改地区内容(宣言,简介)
    void updateSummary(SysDescribeInfo sysDescribeInfo);

    //联谊会堂号数量
    DescInfo countDescInfo(String areaCode, Integer status);

    //添加联谊会概况
    void addDescInfo(SysDescInfo sysDescInfo);

    //查询联谊会概况
    List<SysDescInfo> selectSysDescInfo(String areaCode, Integer status);

    //单一查询联谊会概况
    SysDescInfo selectById(String id);

    //修改联谊会概况
    void updateSysDescInfo(SysDescInfo sysDescInfo);

    //删除联谊会概况
    void deleteSysDescInfo(String id);

    //上传轮播图
    void uploadPic(String areaCode, String pic, Integer status, Integer sort);

    //前台删除
    void deletePic(String id, Integer status);

    //查询轮播图
}
