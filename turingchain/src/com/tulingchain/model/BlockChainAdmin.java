package com.tulingchain.model;

import java.util.Date;

public class BlockChainAdmin {
	private int id;
	private String bcAdmName;
	private String email;
	private String password;
	private String address;
	private String companyName;
	private String companyRegNum;
	private String companyAddress;
	private String referrerName;
	private String referrerKey;
	private String userBusinessType;
	private String nodeBlockChainName;
	private String nodeBlockChainNum;
	private String sonNodeNum;
	private String authority;
	private String nodePublicKey;
	private String nodePrivaeteKey;
	private String applyReason;
	private Date applyDate;
	private Date registDate;
	private String blockChainAdminState;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBcAdmName() {
		return bcAdmName;
	}

	public void setBcAdmName(String bcAdmName) {
		this.bcAdmName = bcAdmName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyRegNum() {
		return companyRegNum;
	}

	public void setCompanyRegNum(String companyRegNum) {
		this.companyRegNum = companyRegNum;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getReferrerName() {
		return referrerName;
	}

	public void setReferrerName(String referrerName) {
		this.referrerName = referrerName;
	}

	public String getReferrerKey() {
		return referrerKey;
	}

	public void setReferrerKey(String referrerKey) {
		this.referrerKey = referrerKey;
	}

	public String getUserBusinessType() {
		return userBusinessType;
	}

	public void setUserBusinessType(String userBusinessType) {
		this.userBusinessType = userBusinessType;
	}

	public String getNodeBlockChainName() {
		return nodeBlockChainName;
	}

	public void setNodeBlockChainName(String nodeBlockChainName) {
		this.nodeBlockChainName = nodeBlockChainName;
	}

	public String getNodeBlockChainNum() {
		return nodeBlockChainNum;
	}

	public void setNodeBlockChainNum(String nodeBlockChainNum) {
		this.nodeBlockChainNum = nodeBlockChainNum;
	}

	public String getSonNodeNum() {
		return sonNodeNum;
	}

	public void setSonNodeNum(String sonNodeNum) {
		this.sonNodeNum = sonNodeNum;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getNodePublicKey() {
		return nodePublicKey;
	}

	public void setNodePublicKey(String nodePublicKey) {
		this.nodePublicKey = nodePublicKey;
	}

	public String getNodePrivaeteKey() {
		return nodePrivaeteKey;
	}

	public void setNodePrivaeteKey(String nodePrivaeteKey) {
		this.nodePrivaeteKey = nodePrivaeteKey;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getBlockChainAdminState() {
		return blockChainAdminState;
	}

	public void setBlockChainAdminState(String blockChainAdminState) {
		this.blockChainAdminState = blockChainAdminState;
	}
	@Override
	public String toString() {
		return "BlockChainAdmin [id=" + id + ", bcAdmName=" + bcAdmName + ", email="
				+ email + ", password=" + password + ", address=" + address
				+ ", companyName=" + companyName + ",companyRegNum" + companyRegNum
				+ ", companyAddress=" + companyAddress + ",referrerName" + referrerName
				+ ", referrerKey=" + referrerKey + ",userBusinessType" + userBusinessType
				+ ", nodeBlockChainName=" + nodeBlockChainName + ",nodeBlockChainNum" + nodeBlockChainNum
				+ ", sonNodeNum=" + sonNodeNum + ",authority" + authority
				+ ", nodePublicKey=" + nodePublicKey + ",nodePrivaeteKey" + nodePrivaeteKey
				+ ", applyReason=" + applyReason + ",applyDate" + applyDate
				+ ", registDate=" + registDate + ",blockChainAdminState" + blockChainAdminState
				+ "]";
	}

}
