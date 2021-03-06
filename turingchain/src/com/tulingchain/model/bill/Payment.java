package com.tulingchain.model.bill;
import java.util.Date;
/**
 * @author Administrator
 * 支付票据的数据对象
 */
public class Payment {
	private int pay_id;
	private int payerName;
	private String billNumber;
	private int payee;
	private int      moneySum ;
	private int discountingOrg;
	private Date   expireDate ;
	private String whenSolutionPay;
	private String operateType;
	private String transferTo;
	private String createId;
	private String transferId;

	
	private BillNoder payerNoder;
	private BillNoder payeeNoder;
	private BillNoder discountingOrgNoder;
	
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public int getPayerName() {
		return payerName;
	}
	public void setPayerName(int payerName) {
		this.payerName = payerName;
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
	public BillNoder getPayerNoder() {
		return payerNoder;
	}
	public void setPayerNoder(BillNoder payerNoder) {
		this.payerNoder = payerNoder;
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
		return "Payment [pay_id=" + pay_id + ", payerName=" + payerName + ", billNumber=" + billNumber + ", payee="
				+ payee + ", moneySum=" + moneySum + ", discountingOrg=" + discountingOrg + ", expireDate=" + expireDate
				+ ", whenSolutionPay=" + whenSolutionPay + ", operateType=" + operateType + ", transferTo=" + transferTo
				+ ", createId=" + createId + ", transferId=" + transferId + ", payerNoder=" + payerNoder
				+ ", payeeNoder=" + payeeNoder + ", discountingOrgNoder=" + discountingOrgNoder + "]";
	}
}
