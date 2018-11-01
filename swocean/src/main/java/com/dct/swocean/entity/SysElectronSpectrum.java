package com.dct.swocean.entity;

import java.io.Serializable;

public class SysElectronSpectrum implements Serializable {
    /**
	 * 电子谱
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private int netId;
    private int showPositionId;
    private String spectrumName;
    private String contactName;
    private String province;
    private String city;
    private String area;
    private String password;
    private String srcUrl;
    private String fileName;
    private String fileType;
    private int auth;
    private int isDel;
    private String createTime;
    private int createUser;
    private String updateTime;
    private int updateUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNetId() {
		return netId;
	}
	public void setNetId(int netId) {
		this.netId = netId;
	}
	public int getShowPositionId() {
		return showPositionId;
	}
	public void setShowPositionId(int showPositionId) {
		this.showPositionId = showPositionId;
	}
	public String getSpectrumName() {
		return spectrumName;
	}
	public void setSpectrumName(String spectrumName) {
		this.spectrumName = spectrumName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSrcUrl() {
		return srcUrl;
	}
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
