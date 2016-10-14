package com.tulingchain.model;
 
import java.util.Date;
 
public class Apply {
   private String userName;           //用户名
   private int userId;                //用户ID
   private long idNumber;             //用户身份证号
   private String userProvince;       //省
   private String userCity;           //市
   private String userCounty;         //县、区
   private String userAddress;        //街道地址
   private String business;           //用户所属行业
   private String reason;             //权限升级原因
   private Date registerStart;        //用户注册使用开始时间
   private Date applyTime;            //用户升级申请时间
   private String companyName;        //用户公司名称
   private int companyId;             //用户公司营业执照注册号
   private String companyCode;        //用户公司组织机构代码
   private String lawerName;          //用户公司法人代表名称
   private Date companyRegist;        //公司注册时间
   private String applyType;          //升级类别
   private String file;               //用户资质证明文件
   private String record;             //有无不良记录历史
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}
	public String getUserProvince() {
		return userProvince;
	}
	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserCounty() {
		return userCounty;
	}
	public void setUserCounty(String userCounty) {
		this.userCounty = userCounty;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	@Override
	public String toString() {
		return "Apply [userName=" + userName + ", userId=" + userId + ", idNumber="
				+ idNumber + ", userProvince=" + userProvince + ", userCity="
				+ userCity + ", userCounty=" + userCounty + ", userAddress="
				+ userAddress + ", business=" + business + ", reason=" + reason
				+ ", registerStart=" + registerStart + ", applyTime=" + applyTime
				+ ", companyName=" + companyName + ", companyId=" + companyId
				+ ", companyCode=" + companyCode + ", lawerName=" + lawerName
				+ ", companyRegist=" + companyRegist + ", applyType=" + applyType
				+ ", file=" + file + ", record=" + record + "]";
	}
	   
		
}