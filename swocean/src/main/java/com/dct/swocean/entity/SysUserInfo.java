package com.dct.swocean.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@SuppressWarnings("serial")
@ApiModel(value="User实体对象，----》",description="User对象")
public class SysUserInfo implements Serializable{
	
	@ApiModelProperty(required=true,value="用户编号",name="userid",example="1")
	private Integer userid;
	@ApiModelProperty(required=true,value="登录的用户名",name="loginname",example="abc")
	private String loginname;
	@ApiModelProperty(required=true,value="登录的角色ID",name="roleid",example="12345")
	private String roleid;
	@ApiModelProperty(required=true,value="部门编号",name="work_id",example="5675")
	private Integer work_id;
	@ApiModelProperty(required=true,value="密码",name="password",example="abc")
	private String password;
	@ApiModelProperty(required=true,value="姓名",name="realname",example="abc")
	private String realname;
	@ApiModelProperty(required=true,value="邮箱",name="email",example="abc@qq.com")
	private String email;
	@ApiModelProperty(required=true,value="性别",name="gender",example="1")
	private String gender;
	@ApiModelProperty(required=true,value="年龄",name="age",example="22")
	private Integer age;
	@ApiModelProperty(required=true,value="生日",name="birthday",example="1978/08/10")
	private String birthday;
	@ApiModelProperty(required=true,value="工号",name="job_id",example="23617")
	private Integer job_id;
	@ApiModelProperty(required=true,value="电话",name="tel",example="13006139768")
	private String tel;
	@ApiModelProperty(required=true,value="角色名",name="roleName",example="abc")
	private String roleName;
	

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Integer getWork_id() {
		return work_id;
	}

	public void setWork_id(Integer work_id) {
		this.work_id = work_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
