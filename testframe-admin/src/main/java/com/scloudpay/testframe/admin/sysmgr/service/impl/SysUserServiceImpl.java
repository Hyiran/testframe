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
import com.scloudpay.testframe.admin.sysmgr.dao.SysUserMapper;
import com.scloudpay.testframe.admin.sysmgr.dao.SysUserRoleRelMapper;
import com.scloudpay.testframe.admin.sysmgr.entity.SysRole;
import com.scloudpay.testframe.admin.sysmgr.entity.SysUser;
import com.scloudpay.testframe.admin.sysmgr.entity.SysUserRoleRel;
import com.scloudpay.testframe.admin.sysmgr.service.ISysUserService;

/**
 * 用户服务实现
 * 
 * @author TanDong
 *
 */
@Service("sysUserService")
@Transactional(readOnly = true)
public class SysUserServiceImpl implements ISysUserService {

	private static Log logger = LogFactory.getLog(SysUserServiceImpl.class);

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleRelMapper sysUserRoleRelMapper;
	
	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysUserService#login(java.lang.String, java.lang.String)
	 */
	public SysUser login(String loginName, String loginPwd) throws ApplicationException {
		logger.info("用户登陆，用户名："+loginName+" 密码："+loginPwd);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("loginPwd", loginPwd);
		List<SysUser> ret = null;
		try {
			ret = sysUserMapper.queryByParams(params);
		} catch (Exception e) {
			logger.error("登录失败", e);
			throw new ApplicationException("error.sysuser.login");
		}
		if(ret == null || ret.size() == 0){
			return null;
		}
		
		//设置当前登录用户的当前色信息
		SysUser sysUser = ret.get(0);
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("userId", sysUser.getId());
		List<SysUserRoleRel> urrs = null;
		try {
			urrs = sysUserRoleRelMapper.queryByParams(params1);
			if(null == urrs || urrs.size() == 0){
				return sysUser;
			}
			SysUserRoleRel urr = urrs.get(0);
			SysRole currentRole = sysRoleMapper.getSysRoleById(urr.getRoleId());
			sysUser.setCurrentRole(currentRole);
			return sysUser;
		} catch (Exception e) {
			logger.error("登录失败", e);
			throw new ApplicationException("error.sysuser.login");
		}
	}
	
	
	/* 
	 * 保存系统用户，同时保存用户的权限设置
	 * @see com.tandong.ssm.sysmgr.service.ISysUserService#saveSysUser(com.tandong.ssm.sysmgr.entity.SysUser)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveSysUser(SysUser sysUser)
			throws ApplicationException {
		try{
			//插入用户主表
			sysUserMapper.insertSysUser(sysUser);
			
			//删除用户角色
			sysUserRoleRelMapper.delByUserId(sysUser.getId());
			
			//重新授权用户角色
			String rids = sysUser.getUserRoleIds();
			if(null != rids && rids.length() > 0){
				String[] ridArray = rids.split(",");
				for(int i=0; i<ridArray.length; i++){
					long roleId = Long.valueOf(ridArray[i]);
					SysUserRoleRel userRoleRel = new SysUserRoleRel();
					userRoleRel.setUserId(sysUser.getId());
					userRoleRel.setRoleId(roleId);
					sysUserRoleRelMapper.insertUserRoleRel(userRoleRel);
				}
			}
			
		}catch(Exception e){
			logger.error("添加用户失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateSysUser(SysUser sysUser) throws ApplicationException {
		try{
			sysUserMapper.updateSysUser(sysUser);
			
			//删除用户角色
			sysUserRoleRelMapper.delByUserId(sysUser.getId());
			
			//重新授权用户角色
			String rids = sysUser.getUserRoleIds();
			if(null != rids && rids.length() > 0){
				String[] ridArray = rids.split(",");
				for(int i=0; i<ridArray.length; i++){
					long roleId = Long.valueOf(ridArray[i]);
					SysUserRoleRel userRoleRel = new SysUserRoleRel();
					userRoleRel.setUserId(sysUser.getId());
					userRoleRel.setRoleId(roleId);
					sysUserRoleRelMapper.insertUserRoleRel(userRoleRel);
				}
			}
			
		}catch(Exception e){
			logger.error("更新用户失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysUser(long id) throws ApplicationException {
		try{
			//删除系统用户
			sysUserMapper.delSysUser(id);
			
			//同时删除系统用户的授权角色关系
			sysUserRoleRelMapper.delByUserId(id);
			
		}catch(Exception e){
			logger.error("删除用户失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysUser(List<Long> ids) throws ApplicationException {
		try{
			
			for(int i=0; i<ids.size(); i++){
				//删除系统用户
				sysUserMapper.delSysUser(ids.get(i));
				
				//同时删除系统用户的授权角色关系
				sysUserRoleRelMapper.delByUserId(ids.get(i));
			}
			
		}catch(Exception e){
			logger.error("删除用户失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	public SysUser getSysUser(long id) throws ApplicationException {
		try{
			return sysUserMapper.getSysUserById(id);
		}catch(Exception e){
			logger.error("获取用户失败", e);
			throw new ApplicationException("error.sysUser.get");
		}
	}

	public PageList<SysUser> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return sysUserMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询用户失败", e);
			throw new ApplicationException("error.membermain.query");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysUserService#getUserRoles(long)
	 */
	public long[] getUserRoles(long userId) throws ApplicationException {
		long[] userRoleIds = null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		try {
			List<SysUserRoleRel> urrs = sysUserRoleRelMapper.queryByParams(params);
			userRoleIds = new long[urrs.size()];
			if(null == urrs || urrs.size() == 0){
				return userRoleIds;
			}
			for(int i=0; i<urrs.size(); i++){
				userRoleIds[i] = urrs.get(i).getRoleId();
			}
		} catch (Exception e) {
			logger.error("查询用户授权角色失败", e);
			throw new ApplicationException("error.membermain.query");
		}
		return userRoleIds;
	}

}
