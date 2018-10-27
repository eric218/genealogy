package com.dct.swocean.service.impl;

import com.dct.swocean.dao.*;
import com.dct.swocean.entity.*;
import com.dct.swocean.service.HomeInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeInServiceImpl implements HomeInService {

    @Autowired
    private DontionAreaInfoMapper dontionAreaInfoMapper;

    @Autowired
    private DonorMapper donorMapper;

    @Autowired
    private ArticleAreaInfoMapper articleAreaInfoMapper;

    @Autowired
    private ArticlerInfoMapper articlerInfoMapper;

    @Autowired
    private UserVideoInfoMapper userVideoInfoMapper;

    @Override
    public DontionAreaInfo countDonor(String areaCode) {
        String sql = "select count(distinct donor) donorNum,area_code from sys_donation d,sys_area a,sys_account t where t.name = a.area_name and t.account=d.account and a.area_code ="+"'"+areaCode+"'";
        return dontionAreaInfoMapper.findOne(sql);
    }

    @Override
    public List<Donor> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize) {
        String sql = "select * from sys_donation d,sys_area a,sys_account t where a.area_code=" + "'" + areaCode + "'"
                + " order by pay_time desc limit " + pageNo + "," + pageSize;
        return donorMapper.findList(sql);
    }

    @Override
    public ArticleAreaInfo countArticle(String areaCode, String type,String status) {
        String sql = "select count(*),region from sys_writing where region="+"'"+areaCode+"'"+" and type ="+"'"+type+"'"+" and status ="+"'"+status+"'";
        return articleAreaInfoMapper.findOne(sql);
    }

    @Override
    public List<ArticlerInfo> select( String areaCode, String status,String type, Integer pageNo, Integer pageSize) {
        String sql = "select publisher,count(*),region from sys_writing where region=region="+"'"+areaCode+"'"+" and type ="+"'"+type+"'"+" and status ="+"'"+status+"'"+" order by publisher limit "+pageNo+","+pageSize;
        return articlerInfoMapper.findList(sql);
    }

    @Override
    public UserVideoInfo countVideo(String areaCode, String type, String status) {
        String sql = "select count(*),region from sys_uploadinfo where region="+"'"+areaCode+"'"+""+" and file_type ="+"'"+type+"'"+" and status ="+"'"+status+"'";
        return userVideoInfoMapper.findOne(sql);
    }

    @Override
    public List<ArticlerInfo> selectByAreaCode( String areaCode, String status,String type, Integer pageNo, Integer pageSize) {
        String sql = "select publisher,count(*),region from sys_uploadinfo where region=region="+"'"+areaCode+"'"+" and type ="+"'"+type+"'"+" and status ="+"'"+status+"'"+" order by publisher limit "+pageNo+","+pageSize;
        return articlerInfoMapper.findList(sql);
    }
}