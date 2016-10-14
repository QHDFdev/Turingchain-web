package com.tulingchain.model;

import java.util.Date;
import java.util.List;

public class Purchase {
	private int purchaseid;
	private String purchaseNum;
	private String number;
	private String articleName;
	private String articleNum;
	private String iu;
	private Date purchaseDate;
	private int purchaserId;
	private int sellerId;
	private String sellerComName;
	private String sellerComNum;
	private String state;
	private Noder purchaser;
	private Noder seller;
	
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getIu() {
		return iu;
	}
	public void setIu(String iu) {
		this.iu = iu;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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
	public String getSellerComName() {
		return sellerComName;
	}
	public void setSellerComName(String sellerComName) {
		this.sellerComName = sellerComName;
	}
	public String getSellerComNum() {
		return sellerComNum;
	}
	public void setSellerComNum(String sellerComNum) {
		this.sellerComNum = sellerComNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	@Override
	public String toString() {
		return "Purchase [purchaseid=" + purchaseid + ", purchaseNum="
				+ purchaseNum + ", number=" + number + ", articleName="
				+ articleName + ", articleNum=" + articleNum + ", iu=" + iu
				+ ", purchaseDate=" + purchaseDate + ", purchaserId="
				+ purchaserId + ", sellerId=" + sellerId + ", sellerComName="
				+ sellerComName + ", sellerComNum=" + sellerComNum + ", state="
				+ state + ", purchaser=" + purchaser + ", seller=" + seller
				+ "]";
	}
	
}
