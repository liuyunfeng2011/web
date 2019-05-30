package com.gezhi.pojo;

import java.io.Serializable;
import java.util.List;
/**
 * 用户类
 * @author Liuyf
 *
 */
public class User implements Serializable{
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String userPwd, Integer userType) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}
	
	public User(Integer userId, String userName, Integer userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
	}

	//用户ID
	private Integer userId;
	//用户姓名
	private String userName;
	//用户密码
	private String userPwd;
	//用户状态 1-正常  0-禁止登录    3-删除
	private Integer userType;
	private UserInfo userInfo;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userType=" + userType
				+ ", userInfo=" + userInfo + "]";
	}
	
}
