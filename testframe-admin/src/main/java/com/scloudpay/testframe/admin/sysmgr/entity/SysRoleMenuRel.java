package com.scloudpay.testframe.admin.sysmgr.entity;

public class SysRoleMenuRel {
	
	private long id;
	
	private long roleId;
	
	private long menuId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
}
