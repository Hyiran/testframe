package com.scloudpay.testframe.admin.sysmgr.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.sysmgr.entity.SysUser;

/**
 * 
 * 用户服务接口
 * 
 * @author TanDong
 *
 */
public interface ISysUserService {
	
	/**
	 * 系统用户登录
	 * @param loginName 登录名称
	 * @param loginPwd 登录密码
	 * @return 
	 * @throws ApplicationException
	 */
	public SysUser login(String loginName, String loginPwd) throws ApplicationException;
	
	/**
	 * 分页查询用户
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<SysUser> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 获取系统用户拥有的角色
	 * @param userId 用户ID
	 * @return 角色ID数组
	 * @throws ApplicationException
	 */
	public long[] getUserRoles(long userId) throws ApplicationException;
	
	/**
	 * 增加用户
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveSysUser(SysUser sysUser) throws ApplicationException;
	
	/**
	 * 更新用户信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateSysUser(SysUser sysUser) throws ApplicationException;
	
	/**
	 * 删除用户信息
	 * @param id 用户ID
	 * @throws ApplicationException
	 */
	public void delSysUser(long id) throws ApplicationException;
	
	public void delSysUser(List<Long> ids) throws ApplicationException;
	
	/**
	 * 根据ID获取用户信息
	 * @param id 用户ID
	 * @return
	 * @throws ApplicationException
	 */
	public SysUser getSysUser(long id) throws ApplicationException;

}
