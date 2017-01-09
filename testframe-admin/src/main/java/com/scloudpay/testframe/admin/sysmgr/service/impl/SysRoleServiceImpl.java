package com.scloudpay.testframe.admin.sysmgr.service.impl;

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
import com.scloudpay.testframe.admin.sysmgr.dao.SysRoleMapper;
import com.scloudpay.testframe.admin.sysmgr.dao.SysRoleMenuRelMapper;
import com.scloudpay.testframe.admin.sysmgr.entity.SysRole;
import com.scloudpay.testframe.admin.sysmgr.entity.SysRoleMenuRel;
import com.scloudpay.testframe.admin.sysmgr.service.ISysRoleService;

/**
 * 角色/岗位服务实现
 * 
 * @author TanDong
 *
 */
@Service("sysRoleService")
@Transactional(readOnly = true)
public class SysRoleServiceImpl implements ISysRoleService {

	private static Log logger = LogFactory.getLog(SysRoleServiceImpl.class);

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRoleMenuRelMapper sysRoleMenuRelMapper;
	
	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysRoleService#saveSysRole(com.tandong.ssm.sysmgr.entity.SysRole)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveSysRole(SysRole sysRole)throws ApplicationException {
		try{
			//保存角色信息
			sysRoleMapper.insertSysRole(sysRole);
			
			//删除角色授权功能菜单
			sysRoleMenuRelMapper.delByRoleId(sysRole.getId());
			
			//重新授权角色的功能菜单
			String mids = sysRole.getRoleMenuIds();
			if(null != mids && mids.length() > 0){
				String[] midArray = mids.split(",");
				for(int i=0; i<midArray.length; i++){
					long menuId = Long.valueOf(midArray[i]);
					SysRoleMenuRel roleMenuRel = new SysRoleMenuRel();
					roleMenuRel.setMenuId(menuId);
					roleMenuRel.setRoleId(sysRole.getId());
					sysRoleMenuRelMapper.insertRoleMenuRel(roleMenuRel);
				}
			}
			
		}catch(Exception e){
			logger.error("添加角色/岗位失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysRoleService#updateSysRole(com.tandong.ssm.sysmgr.entity.SysRole)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateSysRole(SysRole sysRole) throws ApplicationException {
		try{
			//更新角色信息
			sysRoleMapper.updateSysRole(sysRole);
			
			//删除角色授权功能菜单
			sysRoleMenuRelMapper.delByRoleId(sysRole.getId());
			
			//重新授权角色的功能菜单
			String mids = sysRole.getRoleMenuIds();
			if(null != mids && mids.length() > 0){
				String[] midArray = mids.split(",");
				for(int i=0; i<midArray.length; i++){
					long menuId = Long.valueOf(midArray[i]);
					SysRoleMenuRel roleMenuRel = new SysRoleMenuRel();
					roleMenuRel.setMenuId(menuId);
					roleMenuRel.setRoleId(sysRole.getId());
					sysRoleMenuRelMapper.insertRoleMenuRel(roleMenuRel);
				}
			}
			
		}catch(Exception e){
			logger.error("更新角色/岗位失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysRoleService#delSysRole(long)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysRole(long id) throws ApplicationException {
		try{
			//删除角色
			sysRoleMapper.delSysRole(id);
			
			//删除角色授权功能菜单
			sysRoleMenuRelMapper.delByRoleId(id);
			
		}catch(Exception e){
			logger.error("删除角色/岗位失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysRoleService#getSysRole(long)
	 */
	public SysRole getSysRole(long id) throws ApplicationException {
		try{
			return sysRoleMapper.getSysRoleById(id);
		}catch(Exception e){
			logger.error("获取角色/岗位失败", e);
			throw new ApplicationException("error.sysRole.get");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysRoleService#queryWithPage(java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
	 */
	public PageList<SysRole> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return sysRoleMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询角色/岗位失败", e);
			throw new ApplicationException("error.membermain.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysRoleService#getRoleMenus(long)
	 */
	public long[] getRoleMenus(long roleId) throws ApplicationException {
		long[] roleMenuIds = null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		try {
			List<SysRoleMenuRel> rmrs = sysRoleMenuRelMapper.queryByParams(params);
			roleMenuIds = new long[rmrs.size()];
			if(null == rmrs || rmrs.size() == 0){
				return roleMenuIds;
			}
			for(int i=0; i<rmrs.size(); i++){
				roleMenuIds[i] = rmrs.get(i).getMenuId();
			}
		} catch (Exception e) {
			logger.error("查询角色授权功能菜单失败", e);
			throw new ApplicationException("error.membermain.query");
		}
		return roleMenuIds;
	}

}
