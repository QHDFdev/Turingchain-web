package com.tulingchain.model;

import java.util.Date;
import java.util.List;

public class Rawmaterial {
	
	private int id;					//id
	private String rawmName;		//名称
	private String rawmNum;		    //编号
	private String number;			//数量
	private String image;			//图像
	private String iu;				//单位
	private String price;			//价格
	private String origin;			//原产地
	private String productQuantity; //生产数量
	private Date expirationDate;	//保质期
	private Date productedDate;		//生产日期
	private Date sendDate;
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

	public String getRawmName() {
		return rawmName;
	}
	public void setRawmName(String rawmName) {
		this.rawmName = rawmName;
	}
	public String getRawmNum() {
		return rawmNum;
	}
	public void setRawmNum(String rawmNum) {
		this.rawmNum = rawmNum;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getProductedDate() {
		return productedDate;
	}
	public void setProductedDate(Date productedDate) {
		this.productedDate = productedDate;
	}
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
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
	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}
	public int getPurchaserId() {
		return purchaserId;
	}
	public void setPurchaserId(int purchaserId) {
		this.purchaserId = purchaserId;
	}
	public Noder getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(Noder purchaser) {
		this.purchaser = purchaser;
	}
	@Override
	public String toString() {
		return "Rawmaterial [id=" + id + ", rawmName=" + rawmName
				+ ", rawmNum=" + rawmNum + ", number=" + number + ", image="
				+ image + ", iu=" + iu + ", price=" + price + ", origin="
				+ origin + ", productQuantity=" + productQuantity
				+ ", expirationDate=" + expirationDate + ", productedDate="
				+ productedDate + ", sendDate=" + sendDate + ", transComName="
				+ transComName + ", transComNum=" + transComNum
				+ ", principalName=" + principalName + ", principalNum="
				+ principalNum + ", txPubKeyPair=" + txPubKeyPair
				+ ", txPrivKeyPair=" + txPrivKeyPair + ", state=" + state
				+ ", sellerId=" + sellerId + ", purchaseId=" + purchaseId
				+ ", purchaserId=" + purchaserId + ", transportId="
				+ transportId + ", purchase=" + purchase + ", seller=" + seller
				+ ", purchaser=" + purchaser + "]";
	}
	public String getBlockId() {
		return blockId;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	
}
