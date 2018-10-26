package com.dct.swocean.entity;

import java.io.Serializable;
import java.util.List;

public class PersonInfo implements Serializable {

	private SysZipaiInfo sysZipaiInfo;
	private SysUserRegInof sysUserRegInof;
	private List<SysWritingInfo> sysWritingInfoLog;
	private List<SysWritingInfo> sysWritingInfoStatus;
	private List<SysUploadInfo> sysUploadInfoPhoto;
	private List<SysUploadInfo> sysUploadInfoVideo;
	private Long sysWritingCountLog;
	private Long sysWritingCountStatus;
	private Long sysUploadCountPhoto;
	private Long sysUploadCountVideo;

	public SysZipaiInfo getSysZipaiInfo() {
		return sysZipaiInfo;
	}

	public void setSysZipaiInfo(SysZipaiInfo sysZipaiInfo) {
		this.sysZipaiInfo = sysZipaiInfo;
	}

	public List<SysWritingInfo> getSysWritingInfoLog() {
		return sysWritingInfoLog;
	}

	public void setSysWritingInfoLog(List<SysWritingInfo> sysWritingInfoLog) {
		this.sysWritingInfoLog = sysWritingInfoLog;
	}

	public List<SysWritingInfo> getSysWritingInfoStatus() {
		return sysWritingInfoStatus;
	}

	public void setSysWritingInfoStatus(List<SysWritingInfo> sysWritingInfoStatus) {
		this.sysWritingInfoStatus = sysWritingInfoStatus;
	}

	public List<SysUploadInfo> getSysUploadInfoPhoto() {
		return sysUploadInfoPhoto;
	}

	public void setSysUploadInfoPhoto(List<SysUploadInfo> sysUploadInfoPhoto) {
		this.sysUploadInfoPhoto = sysUploadInfoPhoto;
	}

	public List<SysUploadInfo> getSysUploadInfoVideo() {
		return sysUploadInfoVideo;
	}

	public void setSysUploadInfoVideo(List<SysUploadInfo> sysUploadInfoVideo) {
		this.sysUploadInfoVideo = sysUploadInfoVideo;
	}

	public Long getSysWritingCountLog() {
		return sysWritingCountLog;
	}

	public void setSysWritingCountLog(Long sysWritingCountLog) {
		this.sysWritingCountLog = sysWritingCountLog;
	}

	public Long getSysWritingCountStatus() {
		return sysWritingCountStatus;
	}

	public void setSysWritingCountStatus(Long sysWritingCountStatus) {
		this.sysWritingCountStatus = sysWritingCountStatus;
	}

	public Long getSysUploadCountPhoto() {
		return sysUploadCountPhoto;
	}

	public void setSysUploadCountPhoto(Long sysUploadCountPhoto) {
		this.sysUploadCountPhoto = sysUploadCountPhoto;
	}

	public Long getSysUploadCountVideo() {
		return sysUploadCountVideo;
	}

	public void setSysUploadCountVideo(Long sysUploadCountVideo) {
		this.sysUploadCountVideo = sysUploadCountVideo;
	}

	public SysUserRegInof getSysUserRegInof() {
		return sysUserRegInof;
	}

	public void setSysUserRegInof(SysUserRegInof sysUserRegInof) {
		this.sysUserRegInof = sysUserRegInof;
	}

}
