package com.xkit.ssm.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.xkit.ssm.validator.UserLogin;
import com.xkit.ssm.validator.UserRegist;

public class Easybuy_user {
	private Integer id;
	@NotEmpty(groups={UserLogin.class,UserRegist.class},message="账户不能为空！")
	private String loginName;
	@NotEmpty(groups={UserRegist.class},message="请输入您的姓名！")
	private String userName;
	@NotEmpty(groups={UserLogin.class,UserRegist.class},message="密码不能为空！")
	private String password;
	@NotEmpty(groups={UserRegist.class},message="请确认您的密码！")
	private String password2;
	@NotEmpty(groups={UserRegist.class},message="请选择您的性别！")
	private Integer sex;
	@NotEmpty(groups={UserRegist.class},message="请输入您的身份证！")
	private String identityCode;
	@NotEmpty(groups={UserRegist.class},message="请输入您的邮箱！")
	private String email;
	@NotEmpty(groups={UserRegist.class},message="请输入您的手机！")
	private String mobile;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	  
	
	
	
	
}
