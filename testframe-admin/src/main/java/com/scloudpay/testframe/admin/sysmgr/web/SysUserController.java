package com.scloudpay.testframe.admin.sysmgr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.ninefbank.smallpay.common.web.BaseController;
import com.scloudpay.testframe.admin.AppConstants;
import com.scloudpay.testframe.admin.sysmgr.entity.SysUser;
import com.scloudpay.testframe.admin.sysmgr.service.ISysUserService;

/**
 * 角色/岗位页面请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController {
	
	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 系统用户登录
	 * @param loginName 登录名
	 * @param loginPwd 登录密码
	 * @param validateCode 验证码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(HttpServletRequest request, @RequestParam String loginName, @RequestParam String loginPwd, String validateCode) {
		//校验验证码
		boolean codeFlag = true;
		if(!codeFlag){
			return buildErrorResult("验证码错误");
		}
		//校验登录名和登录密码
		SysUser loginUser = sysUserService.login(loginName, loginPwd);
		if(null == loginUser){
			return buildErrorResult("用户名或密码错误");
		}
		//将当前登录用户放到SESSION中
		request.getSession().setAttribute(AppConstants.CURRENT_LOGIN_USER, loginUser);
		request.getSession().setMaxInactiveInterval(5);
		
		return this.buildResult("登录成功");
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> logout() {
		return null;
	}

	/**
	 * 分页查询角色/岗位
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/querySysUser", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> querySysUser(@RequestParam Integer rows, @RequestParam Integer page, @RequestParam String condition) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		
		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%"+condition+"%");
		}
		PageList<SysUser> ret = sysUserService.queryWithPage(params, pageBounds);
		
		return buildResult(rows, page, ret);
	}
	
	/**
	 * 查询系统用户的授权角色集合
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping(value = "/queryUserRoles", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryUserRoles(@RequestParam long userId) {
		
		long[] urrs = sysUserService.getUserRoles(userId);
		
		return buildResult(urrs);
	}
	
	/**
	 * 新增角色/岗位
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addSysUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSysUser(@RequestBody SysUser sysUser)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.saveSysUser(sysUser);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 更新角色/岗位
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateSysUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateSysUser(@RequestBody SysUser sysUser)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.updateSysUser(sysUser);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除角色/岗位
	 * @param id 角色/岗位ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/delSysUser", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delSysUser(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.delSysUser(id);
		ret.put("success", true);
		return ret;
	}
	
	@RequestMapping(value = "/delSysUserBatch", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delSysUserBatch(@RequestParam("ids[]") List<Long> ids) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.delSysUser(ids);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 根据ID获取角色/岗位
	 * @param id 角色/岗位ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/getSysUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSysUser(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser data = sysUserService.getSysUser(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping(value = "/pwd/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updatePwd(HttpServletRequest request, @RequestParam String oldPwd, @RequestParam String newPwd)throws ApplicationException  {
		//获取当前登录用户
		SysUser loginUser = (SysUser)request.getSession().getAttribute(AppConstants.CURRENT_LOGIN_USER);
		if(null == loginUser){
			throw new ApplicationException("Current login user is null.");
		}
		if(!loginUser.getLoginPwd().equals(oldPwd)){
			return this.buildErrorResult("密码错误");
		}
		loginUser.setLoginPwd(newPwd);
		sysUserService.updateSysUser(loginUser);
		return this.buildResult();
	}

}
