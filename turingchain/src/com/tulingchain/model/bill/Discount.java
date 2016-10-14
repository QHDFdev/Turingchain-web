package com.tulingchain.model.bill;
import java.util.Date;
/**
 * @author Administrator
 *  贴现的数据对象
 */
public class Discount {
	private int dicount_id;
	private int discountName;	
	private String billNumber;
	private int payee;
	private int      moneySum;
	private int discountingOrg;
	private Date   expireDate;
	private String whenSolutionPay;
	private String operateType;
	private String transferTo;
	private String remark;
	private Date   discountDate;
	private float   discountRate;
	private String createId;
	private String transferId;
	
	private BillNoder discountNoder;
	private BillNoder payeeNoder;
	private BillNoder discountingOrgNoder;
	
	public int getDicount_id() {
		return dicount_id;
	}
	public void setDicount_id(int dicount_id) {
		this.dicount_id = dicount_id;
	}
	public int getDiscountName() {
		return discountName;
	}
	public void setDiscountName(int discountName) {
		this.discountName = discountName;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public int getPayee() {
		return payee;
	}
	public void setPayee(int payee) {
		this.payee = payee;
	}
	public int getMoneySum() {
		return moneySum;
	}
	public void setMoneySum(int moneySum) {
		this.moneySum = moneySum;
	}
	public int getDiscountingOrg() {
		return discountingOrg;
	}
	public void setDiscountingOrg(int discountingOrg) {
		this.discountingOrg = discountingOrg;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getWhenSolutionPay() {
		return whenSolutionPay;
	}
	public void setWhenSolutionPay(String whenSolutionPay) {
		this.whenSolutionPay = whenSolutionPay;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDiscountDate() {
		return discountDate;
	}
	public void setDiscountDate(Date discountDate) {
		this.discountDate = discountDate;
	}
	public float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getTransferId() {
		return transferId;
	}
	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}
	public BillNoder getDiscountNoder() {
		return discountNoder;
	}
	public void setDiscountNoder(BillNoder discountNoder) {
		this.discountNoder = discountNoder;
	}
	public BillNoder getPayeeNoder() {
		return payeeNoder;
	}
	public void setPayeeNoder(BillNoder payeeNoder) {
		this.payeeNoder = payeeNoder;
	}
	public BillNoder getDiscountingOrgNoder() {
		return discountingOrgNoder;
	}
	public void setDiscountingOrgNoder(BillNoder discountingOrgNoder) {
		this.discountingOrgNoder = discountingOrgNoder;
	}
	@Override
	public String toString() {
		return "Discount [dicount_id=" + dicount_id + ", discountName=" + discountName + ", billNumber=" + billNumber
				+ ", payee=" + payee + ", moneySum=" + moneySum + ", discountingOrg=" + discountingOrg + ", expireDate="
				+ expireDate + ", whenSolutionPay=" + whenSolutionPay + ", operateType=" + operateType + ", transferTo="
				+ transferTo + ", remark=" + remark + ", discountDate=" + discountDate + ", discountRate="
				+ discountRate + ", createId=" + createId + ", transferId=" + transferId + ", discountNoder="
				+ discountNoder + ", payeeNoder=" + payeeNoder + ", discountingOrgNoder=" + discountingOrgNoder + "]";
	}
}
