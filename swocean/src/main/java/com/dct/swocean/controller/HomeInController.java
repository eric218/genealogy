package com.dct.swocean.controller;

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


    //图腾
    @RequestMapping("uploadFamily")
    public Response<SysAreaInfo> upload(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, @RequestParam(value = "pic") String pic) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            homeInService.update(areaCode, pic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtlis.success("上传成功");
    }

    //宣言
    @RequestMapping("uploadTitle")
    public Response<SysDescribeInfo> uploadTitle(HttpServletResponse response, SysDescribeInfo sysDescribeInfo) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.updateSummary(sysDescribeInfo);
        return ResponseUtlis.success("修改成功");
    }

    //联谊会概况
    //数量
    @RequestMapping("countDesc")
    public Response<DescInfo> countDesc(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                        @RequestParam(value = "status", defaultValue = "1") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        DescInfo descInfo = homeInService.countDescInfo(areaCode, status);
        return ResponseUtlis.success("descInfo");
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
                                                   @RequestParam(value = "status", defaultValue = "2") Integer status) {

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

    //上传
    @RequestMapping("uploadPic")
    public Response<SysPicInfo> uploadPic(HttpServletResponse response, String pic, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                          @RequestParam(value = "status", defaultValue = "1") Integer status, Integer sort) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.uploadPic(areaCode, pic, status, sort);
        return ResponseUtlis.success("上传成功");
    }

    //前台删除
    @RequestMapping("updatePic")
    public Response<SysPicInfo> updatePic(HttpServletResponse response,String id,@RequestParam(value = "status", defaultValue = "2") Integer status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        homeInService.deletePic(id,status);
        return ResponseUtlis.success("删除成功");
    }
}
