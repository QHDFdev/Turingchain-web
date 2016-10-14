package com.tulingchain.model;

import java.util.Date;

public class NoderApplyBlock {

	private String userNameID;
	private Date registerDate;
	private String nodeIP;
	private String nodeID;
	private String nodeAddr;
	private String nodeIPRegion;
	private String nodeOrga;
	private Date nodeCreaTime;
	private String nodeConfMEM;
	private String nodeConfCPU;
	private String nodeConfOS;
	private String nodeConfNetwork;
	private String nodeConfUsedList;
	private String nodeChargeID;
	private String nodeChargeContact;
	private int nodeType;
	private String reason;
	private String refereeID;
	private String others;
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserNameID() {
		return userNameID;
	}
	public void setUserNameID(String userNameID) {
		this.userNameID = userNameID;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getNodeIP() {
		return nodeIP;
	}
	public void setNodeIP(String nodeIP) {
		this.nodeIP = nodeIP;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getNodeAddr() {
		return nodeAddr;
	}
	public void setNodeAddr(String nodeAddr) {
		this.nodeAddr = nodeAddr;
	}
	public String getNodeIPRegion() {
		return nodeIPRegion;
	}
	public void setNodeIPRegion(String nodeIPRegion) {
		this.nodeIPRegion = nodeIPRegion;
	}
	public String getNodeOrga() {
		return nodeOrga;
	}
	public void setNodeOrga(String nodeOrga) {
		this.nodeOrga = nodeOrga;
	}
	public Date getNodeCreaTime() {
		return nodeCreaTime;
	}
	public void setNodeCreaTime(Date nodeCreaTime) {
		this.nodeCreaTime = nodeCreaTime;
	}
	public String getNodeConfMEM() {
		return nodeConfMEM;
	}
	public void setNodeConfMEM(String nodeConfMEM) {
		this.nodeConfMEM = nodeConfMEM;
	}
	public String getNodeConfCPU() {
		return nodeConfCPU;
	}
	public void setNodeConfCPU(String nodeConfCPU) {
		this.nodeConfCPU = nodeConfCPU;
	}
	public String getNodeConfOS() {
		return nodeConfOS;
	}
	public void setNodeConfOS(String nodeConfOS) {
		this.nodeConfOS = nodeConfOS;
	}
	public String getNodeConfNetwork() {
		return nodeConfNetwork;
	}
	public void setNodeConfNetwork(String nodeConfNetwork) {
		this.nodeConfNetwork = nodeConfNetwork;
	}
	public String getNodeConfUsedList() {
		return nodeConfUsedList;
	}
	public void setNodeConfUsedList(String nodeConfUsedList) {
		this.nodeConfUsedList = nodeConfUsedList;
	}
	public String getNodeChargeID() {
		return nodeChargeID;
	}
	public void setNodeChargeID(String nodeChargeID) {
		this.nodeChargeID = nodeChargeID;
	}
	public String getNodeChargeContact() {
		return nodeChargeContact;
	}
	public void setNodeChargeContact(String nodeChargeContact) {
		this.nodeChargeContact = nodeChargeContact;
	}
	public int getNodeType() {
		return nodeType;
	}
	public void setNodeType(int nodeType) {
		this.nodeType = nodeType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefereeID() {
		return refereeID;
	}
	public void setRefereeID(String refereeID) {
		this.refereeID = refereeID;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	
	@Override
	public String toString(){
		return "NoderApplyBlock [userNameID=" + userNameID + ", registerDate=" + registerDate + ",nodeIP=" + nodeIP 
				+ ", nodeID=" + nodeID + ", nodeAddr=" + nodeAddr + ", nodeIPRegion=" + nodeIPRegion 
				+ ", nodeOrga=" + nodeOrga + ", nodeCreaTime=" + nodeCreaTime + ", nodeConfMEM=" + nodeConfMEM 
				+ ", nodeConfCPU=" + nodeConfCPU + ", nodeConfOS=" + nodeConfOS + ", nodeConfNetwork=" + nodeConfNetwork 
				+ ", nodeConfUsedList=" + nodeConfUsedList + ", nodeChargeID=" + nodeChargeID + ", nodeChargeContact=" + nodeChargeContact 
				+ ", nodeType=" + nodeType + ", reason=" + reason + ", refereeID=" + refereeID + ", others=" + others + ", state=" + state
				+ "]";
	}
	
}
