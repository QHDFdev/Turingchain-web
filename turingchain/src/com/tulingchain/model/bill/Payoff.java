package com.tulingchain.model.bill;
import java.util.Date;
/**
 * @author Administrator
 * 发薪数据对象
 */
public class Payoff {
	private int payoff_id;
	private int payoffName;
	private String billNumber;
	private int payee;
	private int      moneySum   ;
	private int discountingOrg;
	private Date   expireDate;
	private String whenSolutionPay;
	private String operateType;
	private String transferTo;
	private String remark;
	private String createId;
	private String transferId;
	
	private BillNoder payoffNoder;
	private BillNoder payeeNoder;
	private BillNoder discountingOrgNoder;
	
	
	public int getPayoff_id() {
		return payoff_id;
	}
	public void setPayoff_id(int payoff_id) {
		this.payoff_id = payoff_id;
	}
	public int getPayoffName() {
		return payoffName;
	}
	public void setPayoffName(int payoffName) {
		this.payoffName = payoffName;
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
	public BillNoder getPayoffNoder() {
		return payoffNoder;
	}
	public void setPayoffNoder(BillNoder payoffNoder) {
		this.payoffNoder = payoffNoder;
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
		return "Payoff [payoff_id=" + payoff_id + ", payoffName=" + payoffName + ", billNumber=" + billNumber
				+ ", payee=" + payee + ", moneySum=" + moneySum + ", discountingOrg=" + discountingOrg + ", expireDate="
				+ expireDate + ", whenSolutionPay=" + whenSolutionPay + ", operateType=" + operateType + ", transferTo="
				+ transferTo + ", remark=" + remark + ", createId=" + createId + ", transferId=" + transferId
				+ ", payoffNoder=" + payoffNoder + ", payeeNoder=" + payeeNoder + ", discountingOrgNoder="
				+ discountingOrgNoder + "]";
	}
}
