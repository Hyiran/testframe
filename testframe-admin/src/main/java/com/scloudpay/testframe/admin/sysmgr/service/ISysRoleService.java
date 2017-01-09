package com.scloudpay.testframe.admin.sysmgr.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.sysmgr.entity.SysRole;

/**
 * 
 * 角色/岗位服务接口
 * 
 * @author TanDong
 *
 */
public interface ISysRoleService {
	
	/**
	 * 分页查询角色/岗位
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<SysRole> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	
	/**
	 * 增加角色/岗位
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveSysRole(SysRole sysRole) throws ApplicationException;
	
	/**
	 * 更新角色/岗位信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateSysRole(SysRole sysRole) throws ApplicationException;
	
	/**
	 * 删除角色/岗位信息
	 * @param id 角色/岗位ID
	 * @throws ApplicationException
	 */
	public void delSysRole(long id) throws ApplicationException;
	
	/**
	 * 根据ID获取角色/岗位信息
	 * @param id 角色/岗位ID
	 * @return
	 * @throws ApplicationException
	 */
	public SysRole getSysRole(long id) throws ApplicationException;
	
	/**
	 * 获取角色拥有的功能菜单
	 * @param roleId 角色ID
	 * @return 菜单功能ID数组
	 * @throws ApplicationException
	 */
	public long[] getRoleMenus(long userId) throws ApplicationException;

}
