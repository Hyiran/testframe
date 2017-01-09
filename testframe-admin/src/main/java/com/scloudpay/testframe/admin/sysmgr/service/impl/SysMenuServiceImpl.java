package com.scloudpay.testframe.admin.sysmgr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.sysmgr.dao.SysMenuMapper;
import com.scloudpay.testframe.admin.sysmgr.dao.SysRoleMenuRelMapper;
import com.scloudpay.testframe.admin.sysmgr.entity.SysMenu;
import com.scloudpay.testframe.admin.sysmgr.entity.SysRoleMenuRel;
import com.scloudpay.testframe.admin.sysmgr.service.ISysMenuService;
import com.scloudpay.testframe.admin.sysmgr.web.TreeNode;

/**
 * 菜单服务实现
 * 
 * @author TanDong
 *
 */
@Service("sysMenuService")
@Transactional(readOnly = true)
public class SysMenuServiceImpl implements ISysMenuService {

	private static Log logger = LogFactory.getLog(SysMenuServiceImpl.class);

	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private SysRoleMenuRelMapper sysRoleMenuRelMapper;
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveSysMenu(SysMenu sysMenu)
			throws ApplicationException {
		try{
			sysMenuMapper.insertSysMenu(sysMenu);
		}catch(Exception e){
			logger.error("添加菜单失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateSysMenu(SysMenu sysMenu)
			throws ApplicationException {
		try{
			sysMenuMapper.updateSysMenu(sysMenu);
		}catch(Exception e){
			logger.error("更新菜单失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysMenu(long id) throws ApplicationException {
		try{
			sysMenuMapper.delSysMenu(id);
		}catch(Exception e){
			logger.error("删除菜单失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	public SysMenu getSysMenu(long id) throws ApplicationException {
		try{
			return sysMenuMapper.getSysMenuById(id);
		}catch(Exception e){
			logger.error("获取菜单失败", e);
			throw new ApplicationException("error.sysMenu.get");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysMenuService#queryWithPage(java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
	 */
	public PageList<SysMenu> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return sysMenuMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询菜单失败", e);
			throw new ApplicationException("error.membermain.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysMenuService#getMenuTree(boolean)
	 */
	public List<TreeNode> getMenuTree(boolean withRoot, long[] menuIds) throws ApplicationException {
		
		List<TreeNode> menuTreeNodes = new ArrayList<TreeNode>();
		List<SysMenu> topMenus = new ArrayList<SysMenu>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parent", 0);
		if(null != menuIds){
			params.put("menuIds", menuIds);
		}
		
		List<TreeNode> topTreeNodes = new ArrayList<TreeNode>();
		try {
			topMenus = sysMenuMapper.queryByParams(params);
			//返回带默认根节点的数据
			if(withRoot){
				for(SysMenu menu : topMenus){
					TreeNode node = new TreeNode();
					node.setId(String.valueOf(menu.getId()));
					node.setText(menu.getMenuName());
					node.setIcon("icon-sys");
					node.setState("open");
					node.setExtValue1("0");
					node.setUrl(menu.getMenuUrl());
					node.setChildren(getChildNodes(menu.getId(), menuIds));
					if(withRoot){
						topTreeNodes.add(node);
					}
				}
				
				TreeNode root = new TreeNode();
				root.setId("0");
				root.setIcon("icon-sys");
				root.setState("open");
				root.setText("功能菜单");
				root.setUrl("");
				root.setChildren(topTreeNodes);
				menuTreeNodes.add(root);
			//返回不带默认根节点的数据
			}else{
				for(SysMenu menu : topMenus){
					TreeNode node = new TreeNode();
					node.setId(String.valueOf(menu.getId()));
					node.setText(menu.getMenuName());
					node.setState("open");
					node.setIcon("icon-sys");
					node.setExtValue1("0");
					node.setUrl(menu.getMenuUrl());
					node.setChildren(getChildNodes(menu.getId(), menuIds));
					menuTreeNodes.add(node);
				}
			}
		} catch (Exception e) {
			logger.error("查询菜单失败", e);
			throw new ApplicationException("error.membermain.query");
		}
		return menuTreeNodes;
	}
	
	private List<TreeNode> getChildNodes(long parent, long[] menuIds) throws Exception{
		
		List<TreeNode> childTreeNodes = new ArrayList<TreeNode>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parent", parent);
		List<SysMenu> childMenus = sysMenuMapper.queryByParams(params);
		for(SysMenu menu : childMenus){
			TreeNode node = new TreeNode();
			node.setId(String.valueOf(menu.getId()));
			node.setText(menu.getMenuName());
			node.setExtValue1(String.valueOf(parent));
			node.setIcon("icon-nav");
			node.setUrl(menu.getMenuUrl());
			childTreeNodes.add(node);
		}
		return childTreeNodes;
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysMenuService#getRoleMenus(long)
	 */
	public List<TreeNode> getRoleMenus(long roleId) throws ApplicationException {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		long[] roleMenuIds = null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		try {
			List<SysRoleMenuRel> rmrs = sysRoleMenuRelMapper.queryByParams(params);
			roleMenuIds = new long[rmrs.size()];
			if(null == rmrs || rmrs.size() == 0){
				return ret;
			}
			for(int i=0; i<rmrs.size(); i++){
				roleMenuIds[i] = rmrs.get(i).getMenuId();
			}
			ret.addAll(this.getMenuTree(false, roleMenuIds));
			
		} catch (Exception e) {
			logger.error("查询角色授权功能菜单失败", e);
			throw new ApplicationException("error.membermain.query");
		}
		return ret;
	}

}
