package com.tulingchain.model;

public class NoderDeploy {
	
	private String nodeIP;
	private String nodeID;
	private String region;
	private String ownedOrgnization;
	private String respPerson;
	private String nodeType;
	private String nodePUBKEY;
	private String createdTime;
	private String runtime;
	private String runStatistics;
	private int nodeCpu;
	private int nodeMemory;
	private int nodeBandwidth;
	private String nodeOS;
	private String nodeDisk;
	private String nodeName;
	
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getOwnedOrgnization() {
		return ownedOrgnization;
	}
	public void setOwnedOrgnization(String ownedOrgnization) {
		this.ownedOrgnization = ownedOrgnization;
	}
	public String getRespPerson() {
		return respPerson;
	}
	public void setRespPerson(String respPerson) {
		this.respPerson = respPerson;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getNodePUBKEY() {
		return nodePUBKEY;
	}
	public void setNodePUBKEY(String nodePUBKEY) {
		this.nodePUBKEY = nodePUBKEY;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getRunStatistics() {
		return runStatistics;
	}
	public void setRunStatistics(String runStatistics) {
		this.runStatistics = runStatistics;
	}
	public int getNodeCpu() {
		return nodeCpu;
	}
	public void setNodeCpu(int nodeCpu) {
		this.nodeCpu = nodeCpu;
	}
	public int getNodeMemory() {
		return nodeMemory;
	}
	public void setNodeMemory(int nodeMemory) {
		this.nodeMemory = nodeMemory;
	}
	public int getNodeBandwidth() {
		return nodeBandwidth;
	}
	public void setNodeBandwidth(int nodeBandwidth) {
		this.nodeBandwidth = nodeBandwidth;
	}
	public String getNodeOS() {
		return nodeOS;
	}
	public void setNodeOS(String nodeOS) {
		this.nodeOS = nodeOS;
	}
	public String getNodeDisk() {
		return nodeDisk;
	}
	public void setNodeDisk(String nodeDisk) {
		this.nodeDisk = nodeDisk;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	@Override
	public String toString() {
		return "NoderDeploy [nodeIP=" + nodeIP + ", nodeID=" + nodeID + ", region=" + region + ", ownedOrgnization="
				+ ownedOrgnization + ", respPerson=" + respPerson + ", nodeType=" + nodeType + ", nodePUBKEY="
				+ nodePUBKEY + ", createdTime=" + createdTime + ", runtime=" + runtime + ", runStatistics="
				+ runStatistics + ", nodeCpu=" + nodeCpu + ", nodeMemory=" + nodeMemory + ", nodeBandwidth="
				+ nodeBandwidth + ", nodeOS=" + nodeOS + ", nodeDisk=" + nodeDisk + ", nodeName=" + nodeName + "]";
	}
}
