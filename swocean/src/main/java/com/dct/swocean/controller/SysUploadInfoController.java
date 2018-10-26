package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.service.SysUploadInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

@Controller
public class SysUploadInfoController {

	@Autowired
	private SysUploadInfoService sysUploadInfoService;

	@ResponseBody
	@RequestMapping("/upload")
	public Response<SysUploadInfo> upload(@RequestParam("file_name") String file_name,
			@RequestParam("file_type") String file_type, @RequestParam("file_path") String file_path,
			@RequestParam("upload_user") String upload_user) {
		SysUploadInfo sysUploadInfo = new SysUploadInfo();
		sysUploadInfo.setFileName(file_name);
		sysUploadInfo.setFilePath(file_path);
		sysUploadInfo.setFileType(file_type);
		sysUploadInfo.setUploadUser(upload_user);
		sysUploadInfoService.insert(sysUploadInfo);
		return ResponseUtlis.success("上传成功");
	}
}
