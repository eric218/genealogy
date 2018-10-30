package com.dct.swocean.service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.entity.SysWritingInfo;

public interface SysPLRecordServices {
	/**
	 * 添加文章
	 * @param sysPLRecord
	 */
	void inser(SysWritingInfo sysPLRecord);
	/**
	 * 上传视频
	 * @param sysUploadInfo
	 */
	void insert(SysUploadInfo sysUploadInfo);
	/**
	 * 分页
	 * @param pageSize
	 * @param pageNow
	 * @param style
	 * @param publisher
	 * @return
	 */
	public CulturePage culture(Integer pageSize, Integer pageNow, String style, String publisher);
}
