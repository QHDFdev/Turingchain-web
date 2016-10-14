package com.tulingchain.model.bill;

import java.util.Date;

public class BillNoder {
	private int id;                  //用户ID
	private String noderName;        //用户名
	private long idNumber;           //用户身份证号
	private String email;            //邮箱
	private String password;         //登录密码
	private String noderImg;		 //用户头像
	private String noderProvince;    //省
	private String noderCity;        //市
	private String noderCounty;      //县、区
	private String noderAddress;     //街道地址
	private String noderKey;         //用户授权码
	private int noderType;        //节点用户类别
	private int noderState;       //节点状态
	private String business;         //用户所属行业
	private Date registerStart;      //用户注册使用开始时间
	private Date applyTime;          //用户升级申请时间
	private String companyName;      //用户公司名称
	private int companyId;           //用户公司营业执照注册号
	private String companyCode;      //用户公司组织机构代码
	private String lawerName;        //用户公司法人代表名称
	private Date companyRegist;      //公司注册时间
	private String noderFile;        //用户资质证明文件
	private String record;           //有无不良记录
	private String nodeCount;        //节点名称（默认为计数值）
	private String nodeIp;           //节点分配IP
	private String chainCount;       //节点使用区块名称（计数值）
	private int chainId;             //节点所属区块链节点号
	private String nodePubKey;       //节点公钥
	private String nodePrivateKey;   //节点私钥
	private Date noderEnd;           //节点注销时间
	private String upReason;         //节点申请原因
	private String endReason;        //节点注销原因
	private String protectRecord;    //节点维护记录
	private String authority;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoderName() {
		return noderName;
	}
	public void setNoderName(String noderName) {
		this.noderName = noderName;
	}
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
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
	public String getNoderImg() {
		return noderImg;
	}
	public void setNoderImg(String noderImg) {
		this.noderImg = noderImg;
	}
	public String getNoderProvince() {
		return noderProvince;
	}
	public void setNoderProvince(String noderProvince) {
		this.noderProvince = noderProvince;
	}
	public String getNoderCity() {
		return noderCity;
	}
	public void setNoderCity(String noderCity) {
		this.noderCity = noderCity;
	}
	public String getNoderCounty() {
		return noderCounty;
	}
	public void setNoderCounty(String noderCounty) {
		this.noderCounty = noderCounty;
	}
	public String getNoderAddress() {
		return noderAddress;
	}
	public void setNoderAddress(String noderAddress) {
		this.noderAddress = noderAddress;
	}
	public String getNoderKey() {
		return noderKey;
	}
	public void setNoderKey(String noderKey) {
		this.noderKey = noderKey;
	}
	public int getNoderType() {
		return noderType;
	}
	public void setNoderType(int noderType) {
		this.noderType = noderType;
	}
	public int getNoderState() {
		return noderState;
	}
	public void setNoderState(int noderState) {
		this.noderState = noderState;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public Date getRegisterStart() {
		return registerStart;
	}
	public void setRegisterStart(Date registerStart) {
		this.registerStart = registerStart;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getLawerName() {
		return lawerName;
	}
	public void setLawerName(String lawerName) {
		this.lawerName = lawerName;
	}
	public Date getCompanyRegist() {
		return companyRegist;
	}
	public void setCompanyRegist(Date companyRegist) {
		this.companyRegist = companyRegist;
	}
	public String getNoderFile() {
		return noderFile;
	}
	public void setNoderFile(String noderFile) {
		this.noderFile = noderFile;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getNodeCount() {
		return nodeCount;
	}
	public void setNodeCount(String nodeCount) {
		this.nodeCount = nodeCount;
	}
	public String getNodeIp() {
		return nodeIp;
	}
	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}
	public String getChainCount() {
		return chainCount;
	}
	public void setChainCount(String chainCount) {
		this.chainCount = chainCount;
	}
	public int getChainId() {
		return chainId;
	}
	public void setChainId(int chainId) {
		this.chainId = chainId;
	}
	public String getNodePubKey() {
		return nodePubKey;
	}
	public void setNodePubKey(String nodePubKey) {
		this.nodePubKey = nodePubKey;
	}
	public String getNodePrivateKey() {
		return nodePrivateKey;
	}
	public void setNodePrivateKey(String nodePrivateKey) {
		this.nodePrivateKey = nodePrivateKey;
	}
	public Date getNoderEnd() {
		return noderEnd;
	}
	public void setNoderEnd(Date noderEnd) {
		this.noderEnd = noderEnd;
	}
	public String getUpReason() {
		return upReason;
	}
	public void setUpReason(String upReason) {
		this.upReason = upReason;
	}
	public String getEndReason() {
		return endReason;
	}
	public void setEndReason(String endReason) {
		this.endReason = endReason;
	}
	public String getProtectRecord() {
		return protectRecord;
	}
	public void setProtectRecord(String protectRecord) {
		this.protectRecord = protectRecord;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "BillNoder [id=" + id + ", noderName=" + noderName + ", idNumber=" + idNumber + ", email=" + email
				+ ", password=" + password + ", noderImg=" + noderImg + ", noderProvince=" + noderProvince
				+ ", noderCity=" + noderCity + ", noderCounty=" + noderCounty + ", noderAddress=" + noderAddress
				+ ", noderKey=" + noderKey + ", noderType=" + noderType + ", noderState=" + noderState + ", business="
				+ business + ", registerStart=" + registerStart + ", applyTime=" + applyTime + ", companyName="
				+ companyName + ", companyId=" + companyId + ", companyCode=" + companyCode + ", lawerName=" + lawerName
				+ ", companyRegist=" + companyRegist + ", noderFile=" + noderFile + ", record=" + record
				+ ", nodeCount=" + nodeCount + ", nodeIp=" + nodeIp + ", chainCount=" + chainCount + ", chainId="
				+ chainId + ", nodePubKey=" + nodePubKey + ", nodePrivateKey=" + nodePrivateKey + ", noderEnd="
				+ noderEnd + ", upReason=" + upReason + ", endReason=" + endReason + ", protectRecord=" + protectRecord
				+ ", authority=" + authority + "]";
	}

	

}
