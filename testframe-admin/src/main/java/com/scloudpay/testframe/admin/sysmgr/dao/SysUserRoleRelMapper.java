package com.scloudpay.testframe.admin.sysmgr.dao;

import java.util.List;
import java.util.Map;

import com.scloudpay.testframe.admin.sysmgr.entity.SysUserRoleRel;

/**
 * 系统用户和角色/岗位关系数据访问接口
 * 
 * @author TanDong
 * 
 */
public interface SysUserRoleRelMapper extends BaseMapper {


	public List<SysUserRoleRel> queryByParams(Map<String, Object> params) throws Exception;
	
	public void insertUserRoleRel(SysUserRoleRel userRoleRel) throws Exception;
	
	public void delByUserId(long userId) throws Exception;
}
