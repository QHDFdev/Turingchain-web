package com.tulingchain.model;

import java.util.Date;

public class Transport {
	private int id;
	private String transportNum;
	private String price;
	private String becity;
	private String articleName;
	private String articleNum;
	private String articleType;
	private String destination;
	private Date receiveDate;
	private Date sentDate;	
	private Date deliveryDate;	
	private String senderName;	
	private String senderNum;
	private String sendComName;	
	private String sendComNum;	
	private String sendComAddress;	
	private String recipientName;	
	private String recipientNum;	
	private String recipientComName;
	private String recipientComNum;	
	private String recipientComAddress;
	private String carrierNum;	
	private String carrierName;
	private String transportComName;
	private String transportComNum;	
	private String transportComAddress;
	private String txPubKeyPair;
	private String txPrivKeyPair;
    private String state;
	private String txId;
	
	private int transportId;
	private int purchaserId;
	private int sellerId;
	private int purchaseId;
	
	private Noder transport;
	private Noder purchaser;
	private Noder seller;
	private Purchase purchase; 
	
	
	
	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransportNum() {
		return transportNum;
	}

	public void setTransportNum(String transportNum) {
		this.transportNum = transportNum;
	}

	public String getBecity() {
		return becity;
	}

	public void setBecity(String becity) {
		this.becity = becity;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(String articleNum) {
		this.articleNum = articleNum;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderNum() {
		return senderNum;
	}

	public void setSenderNum(String senderNum) {
		this.senderNum = senderNum;
	}

	public String getSendComName() {
		return sendComName;
	}

	public void setSendComName(String sendComName) {
		this.sendComName = sendComName;
	}

	public String getSendComNum() {
		return sendComNum;
	}

	public void setSendComNum(String sendComNum) {
		this.sendComNum = sendComNum;
	}

	public String getSendComAddress() {
		return sendComAddress;
	}

	public void setSendComAddress(String sendComAddress) {
		this.sendComAddress = sendComAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientNum() {
		return recipientNum;
	}

	public void setRecipientNum(String recipientNum) {
		this.recipientNum = recipientNum;
	}

	public String getRecipientComName() {
		return recipientComName;
	}

	public void setRecipientComName(String recipientComName) {
		this.recipientComName = recipientComName;
	}

	public String getRecipientComNum() {
		return recipientComNum;
	}

	public void setRecipientComNum(String recipientComNum) {
		this.recipientComNum = recipientComNum;
	}

	public String getRecipientComAddress() {
		return recipientComAddress;
	}

	public void setRecipientComAddress(String recipientComAddress) {
		this.recipientComAddress = recipientComAddress;
	}

	public String getCarrierNum() {
		return carrierNum;
	}

	public void setCarrierNum(String carrierNum) {
		this.carrierNum = carrierNum;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getTransportComName() {
		return transportComName;
	}

	public void setTransportComName(String transportComName) {
		this.transportComName = transportComName;
	}

	public String getTransportComNum() {
		return transportComNum;
	}

	public void setTransportComNum(String transportComNum) {
		this.transportComNum = transportComNum;
	}

	public String getTransportComAddress() {
		return transportComAddress;
	}

	public void setTransportComAddress(String transportComAddress) {
		this.transportComAddress = transportComAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(int purchaserId) {
		this.purchaserId = purchaserId;
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
	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public Noder getTransport() {
		return transport;
	}

	public void setTransport(Noder transport) {
		this.transport = transport;
	}

	public Noder getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Noder purchaser) {
		this.purchaser = purchaser;
	}

	public Noder getSeller() {
		return seller;
	}

	public void setSeller(Noder seller) {
		this.seller = seller;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	@Override
	public String toString() {
		return "Transport [id=" + id + ", transportNum=" + transportNum
				+ ", price=" + price + ", becity=" + becity + ", articleName="
				+ articleName + ", articleNum=" + articleNum + ", articleType="
				+ articleType + ", destination=" + destination
				+ ", receiveDate=" + receiveDate + ", sentDate=" + sentDate
				+ ", deliveryDate=" + deliveryDate + ", senderName="
				+ senderName + ", senderNum=" + senderNum + ", sendComName="
				+ sendComName + ", sendComNum=" + sendComNum
				+ ", sendComAddress=" + sendComAddress + ", recipientName="
				+ recipientName + ", recipientNum=" + recipientNum
				+ ", recipientComName=" + recipientComName
				+ ", recipientComNum=" + recipientComNum
				+ ", recipientComAddress=" + recipientComAddress
				+ ", carrierNum=" + carrierNum + ", carrierName=" + carrierName
				+ ", transportComName=" + transportComName
				+ ", transportComNum=" + transportComNum
				+ ", transportComAddress=" + transportComAddress
				+ ", txPubKeyPair=" + txPubKeyPair + ", txPrivKeyPair="
				+ txPrivKeyPair + ", state=" + state + ", transportId="
				+ transportId + ", purchaserId=" + purchaserId + ", sellerId="
				+ sellerId + ", purchaseId=" + purchaseId + ", transport="
				+ transport + ", purchaser=" + purchaser + ", seller=" + seller
				+ ", purchase=" + purchase + "]";
	}

}
