package com.dct.swocean.service.impl;

import com.dct.swocean.common.*;
import com.dct.swocean.dao.*;
import com.dct.swocean.entity.*;
import com.dct.swocean.service.HomeInService;
import com.dct.swocean.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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

    @Autowired
    private SysUploadInfoMapper sysUploadInfoMapper;

    @Autowired
    private SysWritingInfoMapper sysWritingInfoMapper;

    @Autowired
    private AreaLeaderMapper areaLeaderMapper;

    @Autowired
    private AreaLeaderInfoMapper areaLeaderInfoMapper;

    @Autowired
    private SysUserRegInofMapper sysUserRegInofMapper;

    @Autowired
    private SysAccountInfoMapper sysAccountInfoMapper;

    @Autowired
    private SysDonationInfoMapper sysDonationInfoMapper;

    @Override
    public SysAccountInfo select(String account) {
        String sql = "select account,sum(remain) remain from sys_account where account = "+"'"+account+"'"+" group by account";
        return sysAccountInfoMapper.findOne(sql);
    }

    @Override
    public SysAccountInfo selectByType(String account, Integer type) {
        String sql = "select * from sys_account where account = "+"'"+account+"'"+" and type = "+type;
        return sysAccountInfoMapper.findOne(sql);
    }

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
    public SysAreaInfo selectByArea(String areaCode) {
        String sql = "select * from sys_area where area_code = " + "'" + areaCode + "'";
        return sysAreaInfoMapper.findOne(sql);
    }

    @Override
    public void update(String areaCode, String pic) {

        try {
            FastDFSClient fastDFSClient = new FastDFSClient("E:\\work\\genealogy\\swocean\\src\\main\\resources\\fastDFS.properties");
            pic = ConstantClassField.IP_FAST_DFS + fastDFSClient.uploadFile(pic);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "update sys_area set pic = " + "'" + pic + "'" + " where area_code =" + "'" + areaCode + "'";
        sysAreaInfoMapper.update(sql);
    }

    @Override
    public SysDescribeInfo selectByAreaCode(String areaCode) {
        String sql = "select * from sys_describe where area_code = " + "'" + areaCode + "'";
        return sysDescribeMapper.findOne(sql);
    }

    @Override
    public void updateSummary(SysDescribeInfo sysDescribeInfo) {
        String sql = "";
        if (!"".equals(sysDescribeInfo.getTitle())) {
            sql = "update sys_describe set title =" + "'" + sysDescribeInfo.getTitle() + "'" + " where id = " + "'" + sysDescribeInfo.getId() + "'";
        }
        if (!"".equals("sysDescribeInfo.getDescription()")) {
            sql = "update sys_describe set description =" + "'" + sysDescribeInfo.getDescription() + "'" + " where id=" + "'" + sysDescribeInfo.getId() + "'";
        }
        sysDescribeMapper.update(sql);
    }

    @Override
    public DescInfo countDescInfo(String areaCode, Integer status) {
        String sql = "select area_code areaCode,count(*) count from sys_desc where area_code =" + "'" + areaCode + "'" + " and status =" + status;
        return descInfoMapper.findOne(sql);
    }

    @Override
    public void addDescInfo(SysDescInfo sysDescInfo) {
        String id = IDUtils.genId() + "";
        String sql = "insert into sys_desc values (" + "'" + id + "'" + "," + "'" + sysDescInfo.getDescGroup() + "'" + "," + "'" + sysDescInfo.getDescRoot() + "'" + "," + "'" + sysDescInfo.getAreaCode() + "'" + "," + "'" + sysDescInfo.getDescLeader() + "'" + "," + "'" + sysDescInfo.getPhone() + "'" + "," + 0 + "," + 0 + "," + sysDescInfo.getStatus() + ")";
        sysDescInfoMapper.insert(sql);
    }

    @Override
    public List<SysDescInfo> selectSysDescInfo(String areaCode, Integer status) {
        String sql = "select * from sys_desc where area_code = " + "'" + areaCode + "'" + " and status !=" + status + " order by desc_id desc";
        return sysDescInfoMapper.findList(sql);
    }

    @Override
    public SysDescInfo selectById(String id) {
        String sql = "select * from sys_desc where desc_id = " + "'" + id + "'";
        return sysDescInfoMapper.findOne(sql);
    }

    @Override
    public void updateSysDescInfo(SysDescInfo sysDescInfo) {

        String sql = "update sys_desc set desc_group =" + "'" + sysDescInfo.getDescGroup() + "'" + "," + " desc_root =" + "'" + sysDescInfo.getDescRoot() + "'" + "," + " desc_leader =" + "'" + sysDescInfo.getDescLeader() + "'" + "," + " phone =" + "'" + sysDescInfo.getPhone() + "'" + "," + " status =" + sysDescInfo.getStatus() + " where desc_id =" + "'" + sysDescInfo.getDescId() + "'";
        sysDescInfoMapper.update(sql);
    }

    @Override
    public void deleteSysDescInfo(String id) {
        String sql = "update sys_desc set status =" + 0 + " where desc_id =" + "'" + id + "'";
        sysDescInfoMapper.update(sql);
    }

    @Override
    public List<SysPicInfo> selectListByAreaCode(String areaCode, Integer status) {
        String sql = "select * from sys_pic where area_code =" + "'" + areaCode + "'" + " and status != " + status;
        return sysPicMapper.findList(sql);
    }

    @Override
    public void addPic(SysPicInfo sysPicInfo) {

        try {

            String id = IDUtils.genId() + "";
            FastDFSClient fastDFSClient = new FastDFSClient("E:\\work\\genealogy\\swocean\\src\\main\\resources\\fastDFS.properties");
            String pic = ConstantClassField.IP_FAST_DFS + fastDFSClient.uploadFile(sysPicInfo.getPicUrl());

            String sql = "insert into sys_pic values (" + "'" + id + "'" + "," + "'" + pic + "'" + "," + "'" + sysPicInfo.getAreaCode() + "'" + "," + 1 + "," + sysPicInfo.getSort() + ")";

            sysPicMapper.insert(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updatePic(String pic, String picId) {

        try {

            FastDFSClient fastDFSClient = new FastDFSClient("E:\\work\\genealogy\\swocean\\src\\main\\resources\\fastDFS.properties");
            pic = ConstantClassField.IP_FAST_DFS + fastDFSClient.uploadFile(pic);

            String sql = "update sys_pic set pic_url =" + "'" + pic + "'" + " where pic_id =" + "'" + picId + "'";

            sysPicMapper.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePic(String id, Integer status) {
        String sql = "update sys_pic set status =" + status + " where pic_id =" + "'" + id + "'";
        sysPicMapper.update(sql);
    }

    @Override
    public List<SysWritingInfo> selectWritingInfo(String areaCode, Integer status, String type,Integer pageNo,Integer pageSize) {
        String sql = "select * from sys_writing where region ="+"'"+areaCode+"'"+" and type = "+"'"+type+"'"+" and status ="+status+" order by publish_time desc limit "+pageNo+","+pageSize;
        return sysWritingInfoMapper.findList(sql);
    }

    @Override
    public void updateSysWriting(String id, Integer status) {
        String sql = "update sys_writing set status =" +status+" where writings_id ="+"'"+id+"'";
         sysWritingInfoMapper.update(sql);
    }

    @Override
    public List<SysUploadInfo> selectByUploadTime(String areaCode, String fileType, Integer status,Integer pageNo,Integer pageSize) {
        String sql = "select * from sys_uploadinfo where region =" + "'" + areaCode + "'" + " and file_type =" + "'" + fileType + "'" + " and status =" + status+" order by upload_time desc limit "+pageNo+","+pageSize;
        return sysUploadInfoMapper.findList(sql);
    }

    @Override
    public void updateSysUpload(String id, Integer status) {
        String sql = "update sys_uploadinfo set status ="+status+" where file_id ="+"'"+id+"'";
        sysUploadInfoMapper.update(sql);
    }

    @Override
    public AreaLeader selectByAreaCodeAndFamilyName(String areaCode, String family, Integer status) {
        String sql = "select region areaCode,surname familyName,count(*) count from sys_user_reg where region ="+"'"+areaCode+"'"+" and surname ="+"'"+family+"'"+" and status ="+status;
        return areaLeaderMapper.findOne(sql);
    }

    @Override
    public List<AreaLeaderInfo> selectByStatus(String areaCode, String familyName, Integer status) {
        String sql="select region areaCode,surname familyName,phone,status,real_name name from sys_user_reg where region ="+"'"+areaCode+"'"+" and surname ="+"'"+familyName+"'"+" and status ="+status;
        return areaLeaderInfoMapper.findList(sql);
    }

    @Override
    public void updateAreaLeaderInfo(String id,String phone,String realName) {
        String sql = "update sys_user_reg set phone ="+"'"+phone+"'"+","+" real_name ="+"'"+realName+"'"+" where reg_id ="+"'"+id+"'";
        sysUserRegInofMapper.update(sql);
    }

    @Override
    public void updateAreaLeader(String id, Integer status) {
        String sql = "update sys_user_reg set status =" + status + " where reg_id =" + "'" + id + "'";
        sysUserRegInofMapper.update(sql);
    }

    @Override
    public SysUserRegInof selectByRealName(String text) {
        String sql = "select * from sys_user_reg where real_name ="+"'"+text+"'"+ " or phone ="+"'"+text+"'";
        return sysUserRegInofMapper.findOne(sql);
    }

    @Override
    public void add(String account, BigDecimal payCount, Integer type) {
        String sql = "update sys_account set remain = remain +"+"'"+payCount+"'"+" where account ="+"'"+account+"'"+" and type ="+type;
        sysAccountInfoMapper.update(sql);
    }

    @Override
    public void up(String account, BigDecimal payCount, Integer type) {
        String sql = "update sys_account set remain = remain -"+"'"+payCount+"'"+" where account ="+"'"+account+"'"+" and type ="+type;
        sysAccountInfoMapper.update(sql);
    }

    @Override
    public void addSysDonationInfo(SysDonationInfo sysDonationInfo) {

        String id = IDUtils.genId()+"";
        Timestamp date = DateUtil.format(new Date());

        String sql = "insert into sys_donation(donation_id,account,donor,pay_amount,"
                + "pay_time,create_time,creator,type) values(" + id + ',' + sysDonationInfo.getAccount() + ','
               +"'" + sysDonationInfo.getDonor() + "'"+','
                + sysDonationInfo.getPayAmount() + ',' + "'" + date + "'" + ',' + "'" + date + "'" + ','
                + "'" + sysDonationInfo.getDonor() + "'" + "," + sysDonationInfo.getType()+ ")";
        sysDonationInfoMapper.insert(sql);
    }

}
