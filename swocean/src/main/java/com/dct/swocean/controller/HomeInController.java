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
import org.springframework.web.bind.annotation.ResponseBody;
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
                                              @RequestParam(value = "type", defaultValue = "03") String type,@RequestParam(value = "status", defaultValue = "1") String status) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        ArticleAreaInfo articleAreaInfo = homeInService.countArticle(areaCode, type, status);
        return ResponseUtlis.success(articleAreaInfo);

    }

    //活跃宗亲
    @RequestMapping("articler")
    public Response<ArticlerInfo> select(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                         @RequestParam(value = "type", defaultValue = "03") String type,@RequestParam(value = "status", defaultValue = "1") String status,
                                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<ArticlerInfo> articlerInfos = homeInService.select(areaCode, status, type, pageNo - 1, pageSize);
        return ResponseUtlis.success(articlerInfos);
    }

    //个人视频数
    @RequestMapping("video")
    public Response<UserVideoInfo> selectByAreaCode(HttpServletResponse response,@RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                    @RequestParam(value = "type", defaultValue = "03") String type,@RequestParam(value = "status", defaultValue = "1") String status){

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        UserVideoInfo userVideoInfo = homeInService.countVideo(areaCode, type, status);
        return ResponseUtlis.success(userVideoInfo);
    }

    //活跃宗亲
    @RequestMapping("article")
    public Response<ArticlerInfo> selectByAreaCode(HttpServletResponse response, @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                         @RequestParam(value = "type", defaultValue = "03") String type,@RequestParam(value = "status", defaultValue = "1") String status,
                                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<ArticlerInfo> articlerInfos = homeInService.selectByAreaCode(areaCode, status, type, pageNo - 1, pageSize);
        return ResponseUtlis.success(articlerInfos);
    }
}
