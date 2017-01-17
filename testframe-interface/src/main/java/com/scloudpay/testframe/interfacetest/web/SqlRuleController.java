package com.scloudpay.testframe.interfacetest.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.scloudpay.testframe.interfacetest.entity.InterfaceSqlRule;
import com.scloudpay.testframe.interfacetest.service.ISqlRuleService;

@Controller
@RequestMapping("rule/sql")
public class SqlRuleController extends BaseController {

	
	@Autowired
	private ISqlRuleService sqlRuleService;

	/**
	 * 分页查询FTP连接信息
	 * 
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/queryWithPage", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryInterfaceSqlRule(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String condition) throws ApplicationException {

		Map<String, Object> params = new HashMap<String, Object>();

		PageBounds pageBounds = buildPageBounds(pageSize, currentPage, true);
		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%" + condition + "%");
		}

		PageList<InterfaceSqlRule> ret = sqlRuleService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, currentPage, ret);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryAll() throws ApplicationException {

		List<InterfaceSqlRule> ret = sqlRuleService.queryAll();

		return buildResult(ret);
	}


	/**
	 * 新增FTP连接信息
	 * 
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addInterfaceSqlRule(@RequestBody InterfaceSqlRule record) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sqlRuleService.insert(record);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 更新FTP连接信息
	 * 
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateInterfaceSqlRule(@RequestBody InterfaceSqlRule record)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sqlRuleService.update(record);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除FTP连接信息
	 * 
	 * @param id
	 *            FTP连接信息ID
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delInterfaceSqlRule(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sqlRuleService.delete(id);
		ret.put("success", true);
		return ret;
	}
	
	@RequestMapping(value = "/delBatch", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delInterfaceSqlRuleBatch(@RequestParam("ids[]") List<Long> ids)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sqlRuleService.deleteBatch(ids);
		ret.put("success", true);
		return ret;
	}
}
