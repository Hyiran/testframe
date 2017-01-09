package com.scloudpay.testframe.admin.sysmgr.entity;

/**
 * 组织机构
 * 
 * @author TanDong
 *
 */
public class SysOrg {
	
	private long id;
	
	private String orgName;
	
	private String orgMail;
	
	private String orgManager;
	
	private String orgPhone;
	
	private String address;
	
	private long parent;
	
	private String hasChild;
	
	private String insertTime;
	
	private String lastUpdateTime;
	
	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgMail() {
		return orgMail;
	}

	public void setOrgMail(String orgMail) {
		this.orgMail = orgMail;
	}

	public String getOrgManager() {
		return orgManager;
	}

	public void setOrgManager(String orgManager) {
		this.orgManager = orgManager;
	}

	public String getOrgPhone() {
		return orgPhone;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
