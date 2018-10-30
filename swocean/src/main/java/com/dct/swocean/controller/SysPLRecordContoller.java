package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysPLRecordServices;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

/**
 * 省级记录家族
 * @author xiaohei
 *
 */
@RequestMapping("/PLRecord")
@RestController
public class SysPLRecordContoller {
	@Autowired
	private SysPLRecordServices sysPLRecordServices;
	
	@RequestMapping(value="/PLRecordfamily",method=RequestMethod.POST)
	//文章发表
			public Response<SysWritingInfo> fabiao(
					@RequestParam("region")String region,
					@RequestParam("title")String title,
					@RequestParam("summary")String summary,
					@RequestParam("text")String text,
//					@RequestParam("column")String column,
					@RequestParam("style")int style,
					@RequestParam("type")String type,
//					@RequestParam("focus")int focus,
//					@RequestParam("like")int like,
//					@RequestParam("share")int share,
//					@RequestParam("relay")int relay,
//					@RequestParam("reward")int reward,
//					@RequestParam("status")int status,
//					@RequestParam("pic")String pic,
					@RequestParam("family")String family
//					@RequestParam("collection")int collection,
//					@RequestParam("examine")int examine,
//					@RequestParam("location")String location
					){
				SysWritingInfo sysPLRecord=new SysWritingInfo();
				sysPLRecord.setRegion(region);
				sysPLRecord.setTitle(title);
				sysPLRecord.setSummary(summary);
				sysPLRecord.setText(text);
//				sysPLRecord.setColumn(column);
				sysPLRecord.setStyle(style);
//				sysPLRecord.setPublisher(publisher);
//				sysPLRecord.setFocus(focus);
//				sysPLRecord.setLike(like);
//				sysPLRecord.setShare(share);
//				sysPLRecord.setRelay(relay);
//				sysPLRecord.setReward(reward);
//				sysPLRecord.setStatus(status);
//				sysPLRecord.setPic(pic);
				sysPLRecord.setFamily(family);
//				sysPLRecord.setCollection(collection);
//				sysPLRecord.setExamine(examine);
//				sysPLRecord.setLocation(location);
				
				sysPLRecordServices.inser(sysPLRecord);
				return ResponseUtlis.success("发表成功");
			}
	//视频文件上传
			@RequestMapping("/uploadvedio")
			public Response<SysUploadInfo> upload(
					@RequestParam("file_name") String file_name,
					@RequestParam("file_type") String file_type, 
					@RequestParam("file_path") String file_path,
					@RequestParam("region") String region,
					@RequestParam("surname") String surname,
					@RequestParam("upload_user") String upload_user,
					@RequestParam("status") int status) {
				SysUploadInfo sysUploadInfo = new SysUploadInfo();
				sysUploadInfo.setFileName(file_name);
				sysUploadInfo.setFilePath(file_path);
				sysUploadInfo.setFileType(file_type);
				sysUploadInfo.setRegion(region);
				sysUploadInfo.setSurname(surname);
				sysUploadInfo.setUploadUser(upload_user);
				sysUploadInfo.setStatus(status);
				
				sysPLRecordServices.insert(sysUploadInfo);
				return ResponseUtlis.success("上传成功");
			}
}
