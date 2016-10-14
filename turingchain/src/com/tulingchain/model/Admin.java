package com.tulingchain.model;

import java.util.Date;

public class Admin {
	
	private int id;
	private String adminName;
	private String password;
	private Date regDate;
	private String email;
	private int adminType;
	private int adminLevel;
	private String sonCompanyFile;
	private String referrerKey;
	
	public String getSonCompanyFile() {
		return sonCompanyFile;
	}
	public void setSonCompanyFile(String sonCompanyFile) {
		this.sonCompanyFile = sonCompanyFile;
	}
	public int getAdminType() {
		return adminType;
	}
	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAdminLevel() {
		return adminLevel;
	}
	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}
	public String getReferrerKey() {
		return referrerKey;
	}
	public void setReferrerKey(String referrerKey) {
		this.referrerKey = referrerKey;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", password="
				+ password + ", regDate=" + regDate + ", email=" + email
				+ ", adminType=" + adminType + ", adminLevel=" + adminLevel
				+ ", sonCompanyFile=" + sonCompanyFile + ",referrerKey=" + referrerKey + "]";
	}
	
	
}
