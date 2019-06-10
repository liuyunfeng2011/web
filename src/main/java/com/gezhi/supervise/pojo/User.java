package com.gezhi.supervise.pojo;

import java.io.Serializable;
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

	
	public User(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}


	private Integer userId;
	private String userName;
	private String userPwd;
	//0-禁用 -1删除  1-正常
	private Integer userType;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userType=" + userType
				+ "]";
	}
	
}
