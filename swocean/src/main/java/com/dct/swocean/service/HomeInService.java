package com.dct.swocean.service;

import com.dct.swocean.common.*;
import com.dct.swocean.entity.*;

import java.math.BigDecimal;
import java.util.List;

public interface HomeInService {

    //地区捐款金额
    SysAccountInfo select(String account);

    //地区线上捐款
    SysAccountInfo selectByType(String account,Integer type);

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

    //查询姓氏图腾
    SysAreaInfo selectByArea(String areaCode);

    //修改姓氏图腾
    void update(String areaCode, String pic) throws Exception;

    //查询地区内容
    SysDescribeInfo selectByAreaCode(String areaCode);

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

    //查询轮播图
    List<SysPicInfo> selectListByAreaCode(String areaCode, Integer status);

    //新增轮播图
    void addPic(SysPicInfo sysPicInfo);

    //修改轮播图
    void updatePic(String pic, String picId);

    //删除轮播图
    void deletePic(String id, Integer status);

    //搜索个人文章和个人视频

    //个人文章
    List<SysWritingInfo> selectWritingInfo(String areaCode, Integer status, String type, Integer pageNo, Integer pageSize);

    //修改文章是否展示
    void updateSysWriting(String id, Integer status);

    //个人视频
    List<SysUploadInfo> selectByUploadTime(String areaCode, String fileType, Integer status, Integer pageNo, Integer pageSize);

    //修改个人视频是否展示
    void updateSysUpload(String id, Integer status);

    //管理员数量
    AreaLeader selectByAreaCodeAndFamilyName(String areaCode, String family, Integer status);

    //管理员信息
    List<AreaLeaderInfo> selectByStatus(String areaCode, String familyName, Integer status);

    //修改管理员信息
    void updateAreaLeaderInfo(String id,String phone,String realName);

    //修改管理员状态
    void updateAreaLeader(String id, Integer status);

    //搜索
    SysUserRegInof selectByRealName(String text);

    //添加线下捐款
    void add(String account, BigDecimal payCount,Integer type);

    //线下捐款支出
    void up(String account, BigDecimal payCount,Integer type);

    //线下捐款流水
    void addSysDonationInfo(SysDonationInfo sysDonationInfo);

}
