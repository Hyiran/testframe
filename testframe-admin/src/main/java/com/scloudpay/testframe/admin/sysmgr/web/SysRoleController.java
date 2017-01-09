package com.scloudpay.testframe.admin.sysmgr.web;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.web.BaseController;
import com.scloudpay.testframe.admin.sysmgr.entity.SysRole;
import com.scloudpay.testframe.admin.sysmgr.service.ISysRoleService;

/**
 * 角色/岗位页面请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("sysRole")
public class SysRoleController extends BaseController {
	
	@Autowired
	private ISysRoleService sysRoleService;

	/**
	 * 分页查询角色/岗位
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/querySysRole", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> querySysRole(@RequestParam Integer pageSize, @RequestParam Integer currentPageNum, @RequestParam String condition) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		PageBounds pageBounds = buildPageBounds(pageSize, currentPageNum, true);
		
		if (null != condition && !"".equals(condition)) {
			params.put("roleName", "%"+condition+"%");
		}
		PageList<SysRole> ret = sysRoleService.queryWithPage(params, pageBounds);
		
		return buildResult(pageSize, currentPageNum, ret);
	}
	
	/**
	 * 新增角色/岗位
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addSysRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSysRole(@RequestBody SysRole sysRole)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysRoleService.saveSysRole(sysRole);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 更新角色/岗位
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateSysRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateSysRole(@RequestBody SysRole sysRole)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysRoleService.updateSysRole(sysRole);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除角色/岗位
	 * @param id 角色/岗位ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/delSysRole", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delSysRole(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysRoleService.delSysRole(id);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 根据ID获取角色/岗位
	 * @param id 角色/岗位ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/getSysRole", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSysRole(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysRole data = sysRoleService.getSysRole(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}
	
	/**
	 * 查询系统角色授权的功能菜单集合
	 * @param roleId 角色ID
	 * @return
	 */
	@RequestMapping(value = "/queryRoleMenus", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryRoleMenus(@RequestParam long roleId) {
		
		long[] rmrs = sysRoleService.getRoleMenus(roleId);
		
		return buildResult(rmrs);
	}

}
