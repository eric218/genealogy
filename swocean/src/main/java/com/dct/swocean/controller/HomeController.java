package com.dct.swocean.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import com.dct.swocean.common.*;
import com.dct.swocean.entity.*;
import com.dct.swocean.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.MessageUtil;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import io.swagger.annotations.Api;

@Api(value = "首页")
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private SysAreaInfoService sysAreaInfoService;

    @Autowired
    private SysUserLoginService sysUserLoginService;

    @Autowired
    private SysRightInfoService sysRightInfoService;

    private SysAreaInfo sysAreaInfo;

    @Autowired
    private SysDonationInfoService sysDonationInfoService;

    @Autowired
    private SysAccountService sysAccountService;

    @Autowired
    private SysCultureService sysCultureService;

    @Autowired
    private SysPayLogInfoService sysPayLogInfoService;

    @Autowired
    private SysIndustryService sysIndustryService;

    @Autowired
    private SysUserRegInfoService sysUserRegInfoService;

    @Autowired
    private SysWritingInfoService sysWritingInfoService;

    @Autowired
    private SysZiPaiService sysZiPaiService;

    @Autowired
    private SysDescService sysDescService;

    // 标题
    @ResponseBody
    @RequestMapping("headline")
    public Response<SysAreaInfo> selectHeadline(@RequestParam(name = "area_id", defaultValue = "1") String area_id,
                                                HttpServletResponse response) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        sysAreaInfo = sysAreaInfoService.select(area_id);
        return ResponseUtlis.success(sysAreaInfo);
    }

    // 用戶登録
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<SysUserLoginInfo> selectByUsername(@RequestParam("username") String username,
                                                       @RequestParam("password") String password, HttpServletResponse response) {

        SysUserLoginInfo sysUserLoginInfo = sysUserLoginService.selectByUserId(username);

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        // 判斷對象是否為空
        if (!StringUtils.isEmpty(sysUserLoginInfo)) {
            if (sysUserLoginInfo.getPassword().equals(password)) {
                return ResponseUtlis.success(sysUserLoginInfo);
            } else {
                return ResponseUtlis.error(400, "用户名或密码错误");
            }
        } else {
            return ResponseUtlis.error(500, "用户名不存在");
        }
    }

    // 忘记密码

    String message = null;
    String mobilePhone = null;

    @ResponseBody
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMsg(HttpServletResponse response, @RequestParam("mobilePhone") String mobilePhone)
            throws ClientException, IOException {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        message = MessageUtil.sendMessage(mobilePhone);

        System.out.println(message);
        System.out.println(mobilePhone);

        if (message != null) {
            response.getWriter().println("message success");
        } else {
            response.getWriter().println("message failed");
        }

    }

    // 修改密码
    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Response<SysUserLoginInfo> updateUser(HttpServletResponse response,
                                                 @RequestParam("mobilePhone") String mobilePhone, @RequestParam("yanzheng") String yanzheng,
                                                 @RequestParam("password") String password) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        if (message.equals(yanzheng)) {
            sysUserLoginService.update(mobilePhone, password);
            return ResponseUtlis.success("修改成功");
        } else {
            return ResponseUtlis.error(300, "驗證碼錯誤");
        }
    }

    // 短信驗證碼
    String message2;

    @ResponseBody
    @RequestMapping("/send")
    public void send(HttpServletResponse response, @RequestParam("mobilePhone") String mobilePhone)
            throws ServerException, ClientException, IOException {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        message2 = MessageUtil.sendMessage(mobilePhone);

        System.out.println(message2);
        System.out.println(mobilePhone);
        if (message2 != null) {
            response.getWriter().println("message success");
        } else {
            response.getWriter().println("message failed");
        }
    }

    // 用戶註冊
    @ResponseBody
    @RequestMapping(value = "/reg01", method = RequestMethod.POST)
    public Response<SysUserLoginInfo> reg(@RequestParam("username") String username,
                                          @RequestParam(name = "surname", required = true) String surname,
                                          @RequestParam(name = "mobilePhone", required = true) String mobilePhone,
                                          @RequestParam(name = "yanzheng", required = true) String yanzheng,
                                          @RequestParam(name = "password", required = true) String password,
                                          @RequestParam(name = "region", required = false, defaultValue = "3") String region,
                                          HttpServletResponse response) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        String format = DateUtil.format(new Date(), "yyyyMMddHHmmss");
        String random = String.format("%02d", new Random().nextInt(100));
        String id = "user" + format + random;

        SysUserLoginInfo sysUserLoginInfo = new SysUserLoginInfo();

        sysUserLoginInfo.setUserId(id);
        sysUserLoginInfo.setUserName(username);
        sysUserLoginInfo.setPassword(password);
        sysUserLoginInfo.setMobilPhone(mobilePhone);

        SysUserRegInof sysUserRegInfo = new SysUserRegInof();
        sysUserRegInfo.setSurname(surname);
        sysUserRegInfo.setUserId(id);
        sysUserRegInfo.setRegion(region);

        SysUserLoginInfo sysUserLoginInfo01 = sysUserLoginService.selectByUserId(username);
        SysUserLoginInfo sysUserLoginInfo02 = sysUserLoginService.selectByUserId(mobilePhone);
        if (StringUtils.isEmpty(sysUserLoginInfo01)) {
            if (!StringUtils.isEmpty(sysUserLoginInfo02)) {
                return ResponseUtlis.error(400, "手机号已经注册");
            } else {
                if (message2.toString().equals(yanzheng)) {
                    sysUserLoginService.insert(sysUserLoginInfo);

                    sysUserRegInfoService.insert(sysUserRegInfo);
                    return ResponseUtlis.success("注册成功");
                } else {
                    return ResponseUtlis.error(300, "验证码错误");
                }
            }
        } else if (StringUtils.isEmpty(sysUserLoginInfo02)) {
            if (!StringUtils.isEmpty(sysUserLoginInfo01)) {
                return ResponseUtlis.error(500, "用戶名已经注册");
            }
        }
        return null;
    }

    // 首页导航
    @ResponseBody
    @RequestMapping("/title")
    public Response<SysRightinfoInfo> selectTitle(@RequestParam("id") Integer id, HttpServletResponse response) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysRightinfoInfo sysRightinfoInfo = sysRightInfoService.select(id);
        return ResponseUtlis.success(sysRightinfoInfo);
    }

    // 联谊会概况
    @ResponseBody
    @RequestMapping("desc")
    public Response<SysDescInfo> selectByAreaCode(HttpServletResponse response,
                                                  @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysDescInfo sysDescInfo = sysDescService.selectByAreaCode(areaCode);
        return ResponseUtlis.success(sysDescInfo);
    }

    // 公益基金
    @ResponseBody
    @RequestMapping("charityMoney")
    public Response<SysAccountInfo> selectMoney(HttpServletResponse response,
                                                @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode) {
        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysAccountInfo sysAccountInfo = sysAccountService.selectByAreaCode(areaCode);
        return ResponseUtlis.success(sysAccountInfo);
    }

    // 本派字根
    @ResponseBody
    @RequestMapping("group")
    public Response<SysZipaiInfo> selectGroup(HttpServletResponse response,
                                              @RequestParam(value = "famliyname", defaultValue = "张") String famliyname) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysZipaiInfo> SysZipaiInfoList = sysZiPaiService.selectByFamilyName(famliyname);
        return ResponseUtlis.success(SysZipaiInfoList);
    }

    // 即时通讯
    //
    //
    //

    // 家族动态
    // 查询动态公告数据
    @ResponseBody
    @RequestMapping("/dynamic")
    public Response<RecordNotice> recordPage(HttpServletResponse res,
                                             @RequestParam(value = "style", defaultValue = "33") String style,
                                             @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, // areaCode 地区ID
                                             @RequestParam(value = "familyName", defaultValue = "张") String familyName) {// familyName 姓氏名称
        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");
        List<RecordNotice> recordList = new ArrayList<RecordNotice>();
        recordList = sysWritingInfoService.selectWriting(style, areaCode, familyName);
        return ResponseUtlis.success(recordList);
    }

    // 查询县级公告数据
    @ResponseBody
    @RequestMapping("/countyPage")
    public Response<RecordNotice> countyPage(HttpServletResponse res,
                                             @RequestParam(value = "style", defaultValue = "34") String style,
                                             @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, // areaCode 地区ID
                                             @RequestParam(value = "familyName", defaultValue = "张") String familyName) {// familyName 姓氏名称
        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");
        List<RecordNotice> recordList = new ArrayList<RecordNotice>();
        recordList = sysWritingInfoService.selectWriting(style, areaCode, familyName);
        return ResponseUtlis.success(recordList);
    }

    // 最新动态
    @ResponseBody
    @RequestMapping(value = "/newest", method = RequestMethod.POST)
    public Response<RecordNotice> newest(HttpServletResponse res,
                                         @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, // 地区ID
                                         @RequestParam(value = "familyName", defaultValue = "张") String familyName) {// familyName 姓氏名称
        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");
        List<RecordNotice> noticeList = sysWritingInfoService.newest(areaCode, familyName);
        return ResponseUtlis.success(noticeList);
    }

    // 家族名人
    // 会长
    @ResponseBody
    @RequestMapping("/celebrity")
    public Response<FamilyCelebrity> celebrity(@RequestParam(value = "name", defaultValue = "yuzhou") String name,
                                               @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                               @RequestParam(value = "style", defaultValue = "28") String style, HttpServletResponse res) {
        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");

        FamilyCelebrity celebrity = sysWritingInfoService.celebrity(areaCode, style, name);
        return ResponseUtlis.success(celebrity);
    }

    // 家族文化
    @ResponseBody
    @RequestMapping("/culture")
    public Response<CulturePage> commonality03(@RequestParam(value = "style", defaultValue = "2") String style,
                                               @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, // areaCode 地区ID
            /* @RequestParam(value = "familyName") String familyName, // familyName 姓氏名称 */
                                               @RequestParam(name = "pageNow", defaultValue = "1") Integer pageNow,
                                               @RequestParam(name = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {

        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");

        List<SysWritingInfo> cultureList = sysCultureService.culture(pageSize, pageNow - 1, style, areaCode);

        return ResponseUtlis.success(cultureList);
    }

    // 家族基金
    // 基金支出
    @ResponseBody
    @RequestMapping("/payLog")
    public Response<SysPayLogInfo> selectPayLogByPayTime(HttpServletResponse response,
                                                         @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                         @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "style", defaultValue = "18") String style) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysWritingInfo> sysWritingInfos = sysWritingInfoService.selectPayLog(style, areaCode, pageNo - 1,
                pageSize);
        return ResponseUtlis.success(sysWritingInfos);
    }

    // 基金收入
    @ResponseBody
    @RequestMapping("/donation")
    public Response<SysDonationInfo> selectDonationByPayTime(HttpServletResponse response,
                                                             @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
                                                             @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(value = "pagesize", defaultValue = "4") Integer pageSize,
                                                             @RequestParam(value = "style", defaultValue = "17") String style) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysWritingInfo> sysWritingInfos = sysWritingInfoService.selectPayLog(style, areaCode, pageNo - 1,
                pageSize);
        return ResponseUtlis.success(sysWritingInfos);
    }

    // 总基金
    @ResponseBody
    @RequestMapping("charity")
    public Response<SysAccountInfo> Select(HttpServletResponse response,
                                           @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode) {
        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysAccountInfo sysAccountInfo = sysAccountService.selectByAreaCode(areaCode);
        return ResponseUtlis.success(sysAccountInfo);
    }

    // 捐赠个人金额
    @ResponseBody
    @RequestMapping("/donor")
    public Response<Donor> selectByDonor(HttpServletResponse response,
                                         @RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
                                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                         @RequestParam(name = "pagesize", defaultValue = "4") Integer pageSize) {

        // 跨域解决
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<Donor> donorList = sysDonationInfoService.selectByDonor(areaCode, pageNo - 1, pageSize);
        return ResponseUtlis.success(donorList);
    }

    // 家族產業
    // 查询公共产业
    @ResponseBody
    @RequestMapping(value = "/commonality", method = RequestMethod.POST)
    public Response<FamilyIndustry> commonality01(@RequestParam(value = "style", defaultValue = "15") String style,
                                                  @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, // areaCode 地区ID
                                                  @RequestParam(value = "familyName", defaultValue = "张") String familyName, // familyName 姓氏名称
                                                  HttpServletResponse res) {

        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");

        List<FamilyIndustry> familyIndustryList = sysIndustryService.industry(style, areaCode, familyName);

        return ResponseUtlis.success(familyIndustryList);
    }

    // 查询私人产业
    @ResponseBody
    @RequestMapping("/person")
    public Response<FamilyIndustry> commonality02(@RequestParam(value = "style", defaultValue = "16") String style,
                                                  @RequestParam(value = "areaCode", defaultValue = "420115") String areaCode, // areaCode 地区ID
                                                  @RequestParam(value = "familyName", defaultValue = "张") String familyName, // familyName 姓氏名称
                                                  HttpServletResponse res) {

        // 跨域解决
        res.setHeader("Access-Control-Allow-Origin", "*");

        List<FamilyIndustry> familyIndustryList = sysIndustryService.industry(style, areaCode, familyName);

        return ResponseUtlis.success(familyIndustryList);
    }

}
