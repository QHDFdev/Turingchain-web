package com.tulingchain.model.bill;
import java.util.Date;
/**
 * @author Administrator
 * 提薪的数据对象
 */
public class Payroll {
	private int payroll_id;
	private int payrollName;
	private String billNumber;
	private int payee;
	private int      moneySum;
	private int discountingOrg;
	private Date   expireDate ;
	private String whenSolutionPay;
	private String operateType;
	private String transferTo;
	private String remark;
	private String createId;
	private String transferId;
	
	
	private BillNoder payrollNoder;
	private BillNoder payeeNoder;
	private BillNoder discountingOrgNoder;
	
	public int getPayroll_id() {
		return payroll_id;
	}
	public void setPayroll_id(int payroll_id) {
		this.payroll_id = payroll_id;
	}
	public int getPayrollName() {
		return payrollName;
	}
	public void setPayrollName(int payrollName) {
		this.payrollName = payrollName;
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
	public BillNoder getPayrollNoder() {
		return payrollNoder;
	}
	public void setPayrollNoder(BillNoder payrollNoder) {
		this.payrollNoder = payrollNoder;
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
		return "Payroll [payroll_id=" + payroll_id + ", payrollName=" + payrollName + ", billNumber=" + billNumber
				+ ", payee=" + payee + ", moneySum=" + moneySum + ", discountingOrg=" + discountingOrg + ", expireDate="
				+ expireDate + ", whenSolutionPay=" + whenSolutionPay + ", operateType=" + operateType + ", transferTo="
				+ transferTo + ", remark=" + remark + ", createId=" + createId + ", transferId=" + transferId
				+ ", payrollNoder=" + payrollNoder + ", payeeNoder=" + payeeNoder + ", discountingOrgNoder="
				+ discountingOrgNoder + "]";
	}
}
