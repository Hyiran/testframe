package com.scloudpay.testframe.admin.sysmgr.entity;

public class SysRole {
	
	private long id;
	
	private String roleName;
	
	private String memo;
	
	private String insertTime;
	
	private String lastUpdateTime;
	
	private String roleMenuIds;//授权功能菜单ID，多个菜单id逗号分割
	
	public String getRoleMenuIds() {
		return roleMenuIds;
	}

	public void setRoleMenuIds(String roleMenuIds) {
		this.roleMenuIds = roleMenuIds;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
