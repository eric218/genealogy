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
        String sql = "select count(*) count,region,type,publisher useId from sys_writing where region="+"'"+areaCode+"'"+" and type ="+"'"+type+"'"+" and status ="+"'"+status+"'";
        return articleAreaInfoMapper.findOne(sql);
    }

    @Override
    public List<ArticlerInfo> select( String areaCode, String status,String type, Integer pageNo, Integer pageSize) {
        String sql="select real_name userId,w.region,r.pic from sys_writing w,sys_user_reg r,sys_user_login u where w.publisher=u.user_id and u.user_name=r.real_name and w.region="+"'"+areaCode+"'"+" and type ="+"'"+type+"'"+" and w.status ="+"'"+status+"'"+" group by publisher order by publish_time desc limit "+pageNo+","+pageSize;
        return articlerInfoMapper.findList(sql);
    }

    @Override
    public UserVideoInfo countVideo(String areaCode, String type, String status) {
        String sql = "select count(*) videoCount,region areaCode from sys_uploadinfo where region="+"'"+areaCode+"'"+""+" and file_type ="+"'"+type+"'"+" and status ="+"'"+status+"'";
        return userVideoInfoMapper.findOne(sql);
    }

    @Override
    public List<ArticlerInfo> selectByAreaCode( String areaCode, String status,String type, Integer pageNo, Integer pageSize) {
        String sql = "select real_name userId,u.region,r.pic from sys_uploadinfo u,sys_user_reg r,sys_user_login u where region="+"'"+areaCode+"'"+" and type ="+"'"+type+"'"+" and u.status ="+"'"+status+"'"+" group by upload_user order by upload_time desc limit "+pageNo+","+pageSize;
        return articlerInfoMapper.findList(sql);
    }
}
