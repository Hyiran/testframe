package com.scloudpay.testframe.admin.sysmgr.dao;

import java.util.List;
import java.util.Map;

import com.scloudpay.testframe.admin.sysmgr.entity.SysRoleMenuRel;

/**
 * 角色/岗位和菜单关系数据访问接口
 * 
 * @author TanDong
 * 
 */
public interface SysRoleMenuRelMapper extends BaseMapper {


	public List<SysRoleMenuRel> queryByParams(Map<String, Object> params) throws Exception;
	
	public void insertRoleMenuRel(SysRoleMenuRel roleMenuRel) throws Exception;
	
	public void delByRoleId(long roleId) throws Exception;
	
}
