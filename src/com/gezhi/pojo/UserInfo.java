package com.gezhi.pojo;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private Integer infoId;
	private String nickName;
	private String email;
	private String phone;
	private Integer gender;
	private String address;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInfo [infoId=" + infoId + ", nickName=" + nickName + ", email=" + email + ", phone=" + phone
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
}
