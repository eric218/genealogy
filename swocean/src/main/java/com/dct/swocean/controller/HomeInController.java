package com.dct.swocean.controller;

import com.dct.swocean.common.*;
import com.dct.swocean.entity.*;
import com.dct.swocean.service.HomeInService;
import com.dct.swocean.service.SysDonationInfoService;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@Api(value = "首页后台")
@RestController
@RequestMapping("homeIn")
public class HomeInController {

    @Autowired
    private HomeInService homeInService;

    @Autowired
    private SysDonationInfoService sysDonationInfoService;

    @Autowired
    private SysWritingInfoService sysWritingInfoService;

    //地区捐款总金额
    @RequestMapping("selectAccount")
    public Response<SysAccountInfo> selectAccount(HttpServletResponse response, @RequestParam(value = "account", defaultValue = "10086") String account) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysAccountInfo sysAccountInfo = homeInService.select(account);
        return ResponseUtlis.success(sysAccountInfo);
    }

    //地区线上/线下捐款
    @RequestMapping("selectAccountByType")
    public Response<SysAccountInfo> selectAccountByType(HttpServletResponse response, @RequestParam(value = "account", defaultValue = "10086") String account,
                                                        @RequestParam(value = "type", defaultValue = "1") Integer type) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysAccountInfo sysAccountInfo = homeInService.selectByType(account, type);
        return ResponseUtlis.success(sysAccountInfo);
    }

    //捐款人数
    @RequestMapping("donorNum")
    public Response<DontionAreaInfo> selectDonor(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        DontionAreaInfo dontionAreaInfo = homeInService.countDonor(areaCode);

        return ResponseUtlis.success(dontionAreaInfo);
    }

    //最新捐赠
    @RequestMapping("donor")
    public Response<SysDonationInfo> selectByTime(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                  @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<Donor> donors = homeInService.selectByPayTime(areaCode, pageNo - 1, pageSize);

        return ResponseUtlis.success(donors);
    }

    //个人文章数
    @RequestMapping("articleNum")
    public Response<PersonInfo> selectArticle(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                              @RequestParam(value = "type", defaultValue = "03") String type, @RequestParam(value = "status", defaultValue = "1") String status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        ArticleAreaInfo articleAreaInfo = homeInService.countArticle(areaCode, type, status);
        return ResponseUtlis.success(articleAreaInfo);

    }

    //活跃宗亲
    @RequestMapping("articler")
    public Response<ArticlerInfo> select(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                         @RequestParam(value = "type", defaultValue = "03") String type, @RequestParam(value = "status", defaultValue = "1") String status,
                                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<ArticlerInfo> articlerInfos = homeInService.select(areaCode, status, type, pageNo - 1, pageSize);
        return ResponseUtlis.success(articlerInfos);
    }

    //个人视频数
    @RequestMapping("video")
    public Response<UserVideoInfo> selectByAreaCode(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                    @RequestParam(value = "type", defaultValue = "02") String type, @RequestParam(value = "status", defaultValue = "1") String status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        UserVideoInfo userVideoInfo = homeInService.countVideo(areaCode, type, status);
        return ResponseUtlis.success(userVideoInfo);
    }

    //活跃宗亲
    @RequestMapping("article")
    public Response<ArticlerInfo> selectByAreaCode(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                   @RequestParam(value = "type", defaultValue = "02") String type, @RequestParam(value = "status", defaultValue = "1") String status,
                                                   @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<ArticlerInfo> articlerInfos = homeInService.selectByAreaCode(areaCode, status, type, pageNo - 1, pageSize);
        return ResponseUtlis.success(articlerInfos);
    }

    //查询图腾
    @RequestMapping("selectFamily")
    public Response<SysAreaInfo> selectFamily(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysAreaInfo sysAreaInfo = homeInService.selectByArea(areaCode);
        return ResponseUtlis.success(sysAreaInfo);
    }

    //修改图腾
    @RequestMapping("uploadFamily")
    public Response<SysAreaInfo> uploadFamily(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, @RequestParam(value = "pic") String pic) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            homeInService.update(areaCode, pic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtlis.success("上传成功");
    }

    //查询宣言,简介
    @RequestMapping("selectTitle")
    public Response<SysDescribeInfo> selectTitle(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysDescribeInfo sysDescribeInfo = homeInService.selectByAreaCode(areaCode);
        return ResponseUtlis.success(sysDescribeInfo);
    }

    //修改宣言,简介
    @RequestMapping("uploadTitle")
    public Response<SysDescribeInfo> uploadTitle(HttpServletResponse response, SysDescribeInfo sysDescribeInfo) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateSummary(sysDescribeInfo);
        return ResponseUtlis.success("修改成功");
    }

    //线下捐款
   /* //添加
    @RequestMapping("addSysAccountInfo")
    public Response<SysAccountInfo> addSysAccountInfo(HttpServletResponse response, @RequestParam(value = "account", defaultValue = "10086") String account, BigDecimal payCount,
                                                      @RequestParam(value = "type", defaultValue = "2") Integer type) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.add(account, payCount, type);
        return ResponseUtlis.success("添加成功");
    }*/

    //支出
    @RequestMapping("upSysAccountInfo")
    public Response<SysAccountInfo> upSysAccountInfo(HttpServletResponse response, @RequestParam(value = "account", defaultValue = "10086") String account, BigDecimal payCount,
                                                     @RequestParam(value = "type", defaultValue = "2") Integer type) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.up(account, payCount, type);
        return ResponseUtlis.success("支出成功");
    }

    //联谊会概况
    //数量
    @RequestMapping("countDesc")
    public Response<DescInfo> countDesc(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                        @RequestParam(value = "status", defaultValue = "1") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        DescInfo descInfo = homeInService.countDescInfo(areaCode, status);
        return ResponseUtlis.success(descInfo);
    }

    //添加
    @RequestMapping("addDesc")
    public Response<SysDescInfo> addDesc(HttpServletResponse response, SysDescInfo sysDescInfo) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.addDescInfo(sysDescInfo);
        return ResponseUtlis.success("添加成功");
    }

    //查询
    @RequestMapping("selectDesc")
    public Response<SysDescInfo> selectSysDescInfo(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                   @RequestParam(value = "status", defaultValue = "0") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysDescInfo> sysDescInfos = homeInService.selectSysDescInfo(areaCode, status);
        return ResponseUtlis.success(sysDescInfos);
    }

    //单一查询
    @RequestMapping("selectDescById")
    public Response<SysDescInfo> selectDescById(HttpServletResponse response, String id) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysDescInfo sysDescInfo = homeInService.selectById(id);
        return ResponseUtlis.success(sysDescInfo);
    }

    //修改
    @RequestMapping("updateDesc")
    public Response<SysDescInfo> updateSysDescInfo(HttpServletResponse response, SysDescInfo sysDescInfo) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateSysDescInfo(sysDescInfo);
        return ResponseUtlis.success("修改成功");
    }

    //删除
    @RequestMapping("deleteDesc")
    public Response<SysDescInfo> deleteDesc(HttpServletResponse response, String id) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.deleteSysDescInfo(id);
        return ResponseUtlis.success("删除成功");
    }

    //轮播图(待测)
    //查询
    @RequestMapping("selectPic")
    public Response<SysPicInfo> selectPic(HttpServletResponse response, String pic, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                          @RequestParam(value = "status", defaultValue = "0") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysPicInfo> sysPicInfos = homeInService.selectListByAreaCode(areaCode, status);
        return ResponseUtlis.success(sysPicInfos);
    }

    //新增
    @RequestMapping("addPic")
    public Response<SysPicInfo> addPic(HttpServletResponse response, SysPicInfo sysPicInfo) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.addPic(sysPicInfo);
        return ResponseUtlis.success("上传成功");
    }

    //修改
    @RequestMapping("updatePic")
    public Response<SysPicInfo> updatePic(HttpServletResponse response, String pic, String picId) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updatePic(pic, picId);
        return ResponseUtlis.success("修改成功");
    }

    //删除
    @RequestMapping("delPic")
    public Response<SysPicInfo> delPic(HttpServletResponse response, String id, @RequestParam(value = "status", defaultValue = "2") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.deletePic(id, status);
        return ResponseUtlis.success("删除成功");
    }

    //个人文章
    @RequestMapping("selectWriting")
    public Response<SysWritingInfo> selectWriting(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                  @RequestParam(value = "type", defaultValue = "04") String type, @RequestParam(value = "status", defaultValue = "1") Integer status,
                                                  @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysWritingInfo> sysWritingInfos = homeInService.selectWritingInfo(areaCode, status, type, pageNo - 1, pageSize);
        return ResponseUtlis.success(sysWritingInfos);
    }

    //修改个人文章是否展示
    @RequestMapping("updateWriting")
    public Response<SysWritingInfo> updateWriting(HttpServletResponse response, String id, Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateSysWriting(id, status);
        return ResponseUtlis.success("修改成功");
    }

    //个人视频
    @RequestMapping("selectUpload")
    public Response<SysUploadInfo> selectUpload(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                @RequestParam(value = "fileType", defaultValue = "02") String fileType, @RequestParam(value = "status", defaultValue = "1") Integer status,
                                                @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysUploadInfo> sysUploadInfos = homeInService.selectByUploadTime(areaCode, fileType, status, pageNo - 1, pageSize);
        return ResponseUtlis.success(sysUploadInfos);
    }

    //修改个人视频是否展示
    @RequestMapping("updateSysUploadInfo")
    public Response<SysWritingInfo> updateSysUploadInfo(HttpServletResponse response, String id, Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateSysUpload(id, status);
        return ResponseUtlis.success("修改成功");
    }

    //管理员
    @RequestMapping("countAreaLeader")
    public Response<AreaLeader> countAreaLeader(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                @RequestParam(value = "familyName", defaultValue = "0001") String familyName, @RequestParam(value = "status", defaultValue = "1") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        AreaLeader areaLeader = homeInService.selectByAreaCodeAndFamilyName(areaCode, familyName, status);
        return ResponseUtlis.success(areaLeader);
    }

    //管理员信息
    @RequestMapping("selectAreaLeaderInfo")
    public Response<AreaLeaderInfo> selectAreaLeaderInfo(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                         @RequestParam(value = "familyName", defaultValue = "0001") String familyName, @RequestParam(value = "status", defaultValue = "1") Integer status) {


        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<AreaLeaderInfo> areaLeaderInfos = homeInService.selectByStatus(areaCode, familyName, status);
        return ResponseUtlis.success(areaLeaderInfos);
    }

    //修改管理员信息
    @RequestMapping("updateAreaLeaderInfo")
    public Response<AreaLeaderInfo> updateAreaLeaderInfo(HttpServletResponse response, String id, String phone, String realName) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateAreaLeaderInfo(id, phone, realName);
        return ResponseUtlis.success("修改成功");
    }

    //修改管理员状态
    @RequestMapping("updateAreaLeader")
    public Response<AreaLeaderInfo> updateAreaLeader(HttpServletResponse response, String id, Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateAreaLeader(id, status);
        return ResponseUtlis.success("修改成功");
    }

    //搜索
    @RequestMapping("selectSysUserInfo")
    public Response<SysUserRegInof> selectSysUserInfo(HttpServletResponse response, String text) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysUserRegInof sysUserRegInof = homeInService.selectByRealName(text);
        return ResponseUtlis.success(sysUserRegInof);
    }

    //新增线下捐款信息
    @RequestMapping("addSysDontaionInfo")
    public Response<SysDonationInfo> addSysDontaionInfo(SysDonationInfo sysDonationInfo, HttpServletResponse response) {

        //跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.addSysDonationInfo(sysDonationInfo);

        homeInService.add(sysDonationInfo.getAccount(),  sysDonationInfo.getPayAmount(), sysDonationInfo.getType());

        return ResponseUtlis.success("添加成功");
    }
}
