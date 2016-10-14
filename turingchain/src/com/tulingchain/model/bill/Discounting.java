package com.tulingchain.model.bill;

import java.util.Date;;

/**
 * @author Administrator 承贴机构
 */

public class Discounting {
	private int dis_id;
	private int discountingName;
	private String billNumber;
	private int payee;
	private int moneySum;
	private int discountingOrg;
	private Date expireDate;
	private String whenSolutionPay;
	private String operateType;
	private String transferTo;
	private String createId;
	private String transferId;

	
	private BillNoder discountingNoder;
	private BillNoder payeeNoder;
	private BillNoder discountingOrgNoder;
	
	public int getDis_id() {
		return dis_id;
	}

	public void setDis_id(int dis_id) {
		this.dis_id = dis_id;
	}

	public int getDiscountingName() {
		return discountingName;
	}

	public void setDiscountingName(int discountingName) {
		this.discountingName = discountingName;
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

	public BillNoder getDiscountingNoder() {
		return discountingNoder;
	}

	public void setDiscountingNoder(BillNoder discountingNoder) {
		this.discountingNoder = discountingNoder;
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
		return "Discounting [dis_id=" + dis_id + ", discountingName=" + discountingName + ", billNumber=" + billNumber
				+ ", payee=" + payee + ", moneySum=" + moneySum + ", discountingOrg=" + discountingOrg + ", expireDate="
				+ expireDate + ", whenSolutionPay=" + whenSolutionPay + ", operateType=" + operateType + ", transferTo="
				+ transferTo + ", createId=" + createId + ", transferId=" + transferId + ", discountingNoder="
				+ discountingNoder + ", payeeNoder=" + payeeNoder + ", discountingOrgNoder=" + discountingOrgNoder
				+ "]";
	}

}
