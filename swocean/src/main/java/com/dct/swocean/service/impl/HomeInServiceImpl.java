package com.dct.swocean.service.impl;

import com.dct.swocean.common.FastDFSClient;
import com.dct.swocean.common.IDUtils;
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

    @Autowired
    private SysAreaInfoMapper sysAreaInfoMapper;

    @Autowired
    private SysDescribeMapper sysDescribeMapper;

    @Autowired
    private DescInfoMapper descInfoMapper;

    @Autowired
    private SysDescInfoMapper sysDescInfoMapper;

    @Autowired
    private SysPicMapper sysPicMapper;

    @Override
    public DontionAreaInfo countDonor(String areaCode) {
        String sql = "select count(distinct donor) donorNum,area_code from sys_donation d,sys_area a,sys_account t where t.name = a.area_name and t.account=d.account and a.area_code =" + "'" + areaCode + "'";
        return dontionAreaInfoMapper.findOne(sql);
    }

    @Override
    public List<Donor> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize) {
        String sql = "select * from sys_donation d,sys_area a,sys_account t where a.area_code=" + "'" + areaCode + "'"
                + " order by pay_time desc limit " + pageNo + "," + pageSize;
        return donorMapper.findList(sql);
    }

    @Override
    public ArticleAreaInfo countArticle(String areaCode, String type, String status) {
        String sql = "select count(*) count,region,type,publisher useId from sys_writing where region=" + "'" + areaCode + "'" + " and type =" + "'" + type + "'" + " and status =" + "'" + status + "'";
        return articleAreaInfoMapper.findOne(sql);
    }

    @Override
    public List<ArticlerInfo> select(String areaCode, String status, String type, Integer pageNo, Integer pageSize) {
        String sql = "select real_name userId,w.region,r.pic from sys_writing w,sys_user_reg r,sys_user_login u where w.publisher=u.user_id and u.user_name=r.real_name and w.region=" + "'" + areaCode + "'" + " and type =" + "'" + type + "'" + " and w.status =" + "'" + status + "'" + " group by publisher order by publish_time desc limit " + pageNo + "," + pageSize;
        return articlerInfoMapper.findList(sql);
    }

    @Override
    public UserVideoInfo countVideo(String areaCode, String type, String status) {
        String sql = "select count(*) videoCount,region areaCode from sys_uploadinfo where region=" + "'" + areaCode + "'" + "" + " and file_type =" + "'" + type + "'" + " and status =" + "'" + status + "'";
        return userVideoInfoMapper.findOne(sql);
    }

    @Override
    public List<ArticlerInfo> selectByAreaCode(String areaCode, String status, String type, Integer pageNo, Integer pageSize) {
        String sql = " select upload_user userId,u.region,pic from sys_uploadinfo u,sys_user_reg where upload_user=user_id and u.region =" + "'" + areaCode + "'" + " and file_type =" + "'" + type + "'" + " and u.status =" + "'" + status + "'" + " group by upload_user order by upload_time desc limit " + pageNo + "," + pageSize;
        return articlerInfoMapper.findList(sql);
    }

    @Override
    public void update(String areaCode, String pic) {

        try {
            FastDFSClient fastDFSClient = new FastDFSClient("string");
            pic = fastDFSClient.uploadFile(pic);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "update sys_area set pic = " + "'" + pic + "'" + " where area_code =" + "'" + areaCode + "'";
        sysAreaInfoMapper.update(sql);
    }

    @Override
    public void updateSummary(SysDescribeInfo sysDescribeInfo) {
        String sql = "";
        if (!sysDescribeInfo.getTitle().equals("")) {
            sql = "update sys_describe set title =" + "'" + sysDescribeInfo.getTitle() + "'" + " where id = " + "'" + sysDescribeInfo.getId() + "'";
        } else {
            sql = "update sys_describe set description =" + "'" + sysDescribeInfo.getDescription() + "'" + " where id=" + "'" + sysDescribeInfo.getId() + "'";
        }
        sysDescribeMapper.update(sql);
    }

    @Override
    public DescInfo countDescInfo(String areaCode, Integer status) {
        String sql = "select area_code areaCode,count(*) from sys_desc where area_code =" + "'" + areaCode + "'" + " and status =" + status;
        return descInfoMapper.findOne(sql);
    }

    @Override
    public void addDescInfo(SysDescInfo sysDescInfo) {
        String id = IDUtils.genId() + "";
        String sql = "insert into sys_desc values (" + "'" + id + "'" + "," + "'" + sysDescInfo.getDescGroup() + "'" + "," + "'" + sysDescInfo.getDescRoot() + "'" + "," + "'" + sysDescInfo.getAreaCode() + "'" + "," + "'" + sysDescInfo.getDescLeader() + "'" + "," + "'" + sysDescInfo.getPhone() + "'" + 0 + "," + 0 + "," + sysDescInfo.getStatus() + ")";
        sysDescInfoMapper.insert(sql);
    }

    @Override
    public List<SysDescInfo> selectSysDescInfo(String areaCode, Integer status) {
        String sql = "select * from sys_desc where area_code = " + "'" + areaCode + "'" + " and status !=" + status;
        return sysDescInfoMapper.findList(sql);
    }

    @Override
    public SysDescInfo selectById(String id) {
        String sql = "select * from sys_desc where desc_id = " + "'" + id + "'";
        return sysDescInfoMapper.findOne(sql);
    }

    @Override
    public void updateSysDescInfo(SysDescInfo sysDescInfo) {

        String sql = "update sys_desc set desc_group =" + "'" + sysDescInfo.getDescGroup() + "'" + "," + " desc_root =" + "'" + sysDescInfo.getDescRoot() + "'" + "," + " desc_leader =" + "'" + sysDescInfo.getDescLeader() + "'" + "," + " phone =" + "'" + sysDescInfo.getPhone() + "'" + " where desc_id =" + "'" + sysDescInfo.getDescId() + "'";
        sysDescInfoMapper.update(sql);
    }

    @Override
    public void deleteSysDescInfo(String id) {
        String sql = "update sys_desc set status =" + 2 + " where desc_id =" + "'" + id + "'";
        sysDescInfoMapper.update(sql);
    }

    @Override
    public void uploadPic(String areaCode, String pic, Integer status, Integer sort) {

        try {
            FastDFSClient fastDFSClient = new FastDFSClient("string");
            pic = fastDFSClient.uploadFile(pic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = IDUtils.genId() + "";
        String sql = "insert into sys_pic values (" + "'" + id + "'" + "," + "'" + pic + "'" + "," + "'" + areaCode + "'" + "," + status + "," + sort + ")";
        sysPicMapper.insert(sql);
    }

    @Override
    public void deletePic(String id, Integer status) {
        String sql = "update sys_pic set status ="+status+" where pic_id ="+"'"+id+"'";
        sysPicMapper.update(sql);
    }

}
