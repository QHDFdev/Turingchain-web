package com.tulingchain.model;

import java.util.Date;
import java.util.List;

public class Product {
	
	private int id;						//ID
	private String productName;			//产品名称
	private String productNum;			//产品编号
	private String number;
	private String image;				//图像
	private String iu;					//单位
	private String price;				//价格
	private Date sendDate;
	private Date productDate;			//生产日期
	private String productQuantity;		//生产数量
	private Date expirationDate;		//保质期
	private String transComName;
	private String transComNum;
	private String principalName;
	private String principalNum;
	private String txPubKeyPair;
	private String txPrivKeyPair;
	private String state;
	private String blockId;
	private String txId;

	private int sellerId;
	private int purchaseId;
	private int purchaserId;
	private int transportId;
	
	private Purchase purchase;
	private Noder seller;
	private Noder purchaser;
	private Noder transport;
	
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getBlockId() {
		return blockId;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIu() {
		return iu;
	}
	public void setIu(String iu) {
		this.iu = iu;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Date getExpirationDate(){
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPrincipalNum() {
		return principalNum;
	}
	public void setPrincipalNum(String principalNum) {
		this.principalNum = principalNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getPurchaserId() {
		return purchaserId;
	}
	public void setPurchaserId(int purchaserId) {
		this.purchaserId = purchaserId;
	}
	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public Noder getSeller() {
		return seller;
	}
	public void setSeller(Noder seller) {
		this.seller = seller;
	}
	public Noder getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(Noder purchaser) {
		this.purchaser = purchaser;
	}
	public Noder getTransport() {
		return transport;
	}
	public void setTransport(Noder transport) {
		this.transport = transport;
	}
	public String getTransComName() {
		return transComName;
	}
	public void setTransComName(String transComName) {
		this.transComName = transComName;
	}
	public String getTransComNum() {
		return transComNum;
	}
	public void setTransComNum(String transComNum) {
		this.transComNum = transComNum;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getTxPubKeyPair() {
		return txPubKeyPair;
	}
	public void setTxPubKeyPair(String txPubKeyPair) {
		this.txPubKeyPair = txPubKeyPair;
	}
	public String getTxPrivKeyPair() {
		return txPrivKeyPair;
	}
	public void setTxPrivKeyPair(String txPrivKeyPair) {
		this.txPrivKeyPair = txPrivKeyPair;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", productNum=" + productNum + ", number=" + number
				+ ", image=" + image + ", iu=" + iu + ", price=" + price
				+ ", sendDate=" + sendDate + ", productDate=" + productDate
				+ ", productQuantity=" + productQuantity + ", expirationDate="
				+ expirationDate + ", transComName=" + transComName
				+ ", transComNum=" + transComNum + ", principalName="
				+ principalName + ", principalNum=" + principalNum
				+ ", txPubKeyPair=" + txPubKeyPair + ", txPrivKeyPair="
				+ txPrivKeyPair + ", state=" + state + ", sellerId=" + sellerId
				+ ", purchaseId=" + purchaseId + ", purchaserId=" + purchaserId
				+ ", transportId=" + transportId + ", purchase=" + purchase
				+ ", seller=" + seller + ", purchaser=" + purchaser
				+ ", transport=" + transport + "]";
	}
}
