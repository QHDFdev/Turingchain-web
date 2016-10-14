package com.tulingchain.model.bill;
import java.util.Date;
/**
 * @author Administrator
 *  签发票据的数据对象
 *
 */
public class Issuance {
	private int      is_id;   
	private int signer;//外键
	private String billNumber;
	private int payee;//外键
	private int      moneySum;
	private int discountingOrg;//外键
	private Date   expireDate;
	private String whenSolutionPay;
	private String operateType;
	private String transferTo;
	private String createId;
	private String transferId;
	private int isDiscounted;
	
	private BillNoder signerNoder;
	private BillNoder payeeNoder;
	private BillNoder discountingOrgNoder;
	
	public int getIs_id() {
		return is_id;
	}
	public void setIs_id(int is_id) {
		this.is_id = is_id;
	}
	public int getSigner() {
		return signer;
	}
	public void setSigner(int signer) {
		this.signer = signer;
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
	public String gettransferId() {
		return transferId;
	}
	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}
	
	public BillNoder getSignerNoder() {
		return signerNoder;
	}
	public void setSignerNoder(BillNoder signerNoder) {
		this.signerNoder = signerNoder;
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
	
	public int getIsDiscounted() {
		return isDiscounted;
	}
	public void setIsDiscounted(int isDiscounted) {
		this.isDiscounted = isDiscounted;
	}
	
	@Override
	public String toString() {
		return "Issuance [is_id=" + is_id + ", signer=" + signer + ", billNumber=" + billNumber + ", payee=" + payee
				+ ", moneySum=" + moneySum + ", discountingOrg=" + discountingOrg + ", expireDate=" + expireDate
				+ ", whenSolutionPay=" + whenSolutionPay + ", operateType=" + operateType + ", transferTo=" + transferTo
				+ ", createId=" + createId + ", transferId=" + transferId + ", isDiscounted=" + isDiscounted
				+ ", signerNoder=" + signerNoder + ", payeeNoder=" + payeeNoder + ", discountingOrgNoder="
				+ discountingOrgNoder + "]";
	}
	
}
