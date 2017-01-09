package com.scloudpay.testframe.admin.sysmgr.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.sysmgr.entity.SysMenu;
import com.scloudpay.testframe.admin.sysmgr.web.TreeNode;

/**
 * 
 * 菜单服务接口
 * 
 * @author TanDong
 *
 */
public interface ISysMenuService {
	
	/**
	 * 获取角色的所有功能菜单
	 * @param roleId 角色ID
	 * @return 功能菜单集合,TreeNode结构数据
	 * @throws ApplicationException
	 */
	public List<TreeNode> getRoleMenus(long roleId) throws ApplicationException;
	
	/**
	 * 获取菜单树
	 * @param withRoot 是否返回默认根节点
	 * @param menuIds 条件（菜单Id在数组范围之内）
	 * @return
	 * @throws ApplicationException
	 */
	public List<TreeNode> getMenuTree(boolean withRoot, long[] menuIds) throws ApplicationException;
	
	/**
	 * 分页查询菜单
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<SysMenu> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	
	/**
	 * 增加菜单
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveSysMenu(SysMenu sysMenu) throws ApplicationException;
	
	/**
	 * 更新菜单信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateSysMenu(SysMenu sysMenu) throws ApplicationException;
	
	/**
	 * 删除菜单信息
	 * @param id 菜单ID
	 * @throws ApplicationException
	 */
	public void delSysMenu(long id) throws ApplicationException;
	
	/**
	 * 根据ID获取菜单信息
	 * @param id 菜单ID
	 * @return
	 * @throws ApplicationException
	 */
	public SysMenu getSysMenu(long id) throws ApplicationException;

}
