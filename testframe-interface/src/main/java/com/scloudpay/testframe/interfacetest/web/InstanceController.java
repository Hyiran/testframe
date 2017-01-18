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
import com.scloudpay.testframe.examples.bean.RequestBean;
import com.scloudpay.testframe.interfacetest.DubboCaller;
import com.scloudpay.testframe.interfacetest.bean.ValidatorMessage;
import com.scloudpay.testframe.interfacetest.entity.InterfaceInstance;
import com.scloudpay.testframe.interfacetest.entity.InterfaceReturnRule;
import com.scloudpay.testframe.interfacetest.entity.InterfaceSqlRule;
import com.scloudpay.testframe.interfacetest.service.IInstanceService;
import com.scloudpay.testframe.interfacetest.service.IReturnRuleService;
import com.scloudpay.testframe.interfacetest.service.ISqlRuleService;
import com.scloudpay.testframe.interfacetest.validator.ReturnValidator;

@Controller
@RequestMapping("instance/api")
public class InstanceController extends BaseController {

	
	@Autowired
	private IInstanceService instanceService;
	
	@Autowired
	private IReturnRuleService returnRuleService;
	
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
	public @ResponseBody Map<String, Object> queryInterfaceReturnRule(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String condition) throws ApplicationException {

		Map<String, Object> params = new HashMap<String, Object>();

		PageBounds pageBounds = buildPageBounds(pageSize, currentPage, true);
		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%" + condition + "%");
		}

		PageList<InterfaceInstance> ret = instanceService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, currentPage, ret);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryAll() throws ApplicationException {

		List<InterfaceInstance> ret = instanceService.queryAll();

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
	public Map<String, Object> addInterfaceInstance(@RequestBody InterfaceInstance record) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		instanceService.insert(record);
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
	public Map<String, Object> updateInterfaceInstance(@RequestBody InterfaceInstance record)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		instanceService.update(record);
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
	public @ResponseBody Map<String, Object> delInterfaceInstance(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		instanceService.delete(id);
		ret.put("success", true);
		return ret;
	}
	
	@RequestMapping(value = "/delBatch", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delInterfaceInstanceBatch(@RequestParam("ids[]") List<Long> ids)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		instanceService.deleteBatch(ids);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 执行接口测试实例
	 * @param instance
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/execute", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> execute(@RequestBody InterfaceInstance instance) throws ApplicationException {

		DubboCaller caller = new DubboCaller();
		caller.init(new String[]{"dubbo-consumer.xml"});
		
		RequestBean rq = new RequestBean();
		rq.setCardNo("6225880135053925");
		rq.setOrderNo("test_order_no_2017010500001");
		String returnJson = caller.call1(rq, instance.getApiName(), instance.getMethodName());
		InterfaceReturnRule returnRule = returnRuleService.get(instance.getReturnRuleId());
		InterfaceSqlRule sqlRule = sqlRuleService.get(instance.getSqlRuleId());
		
		ReturnValidator returnVal = new ReturnValidator();
		returnVal.setExpression(returnRule.getExpression());
		ValidatorMessage msg = returnVal.validate(returnJson);
		return buildResult(msg);
	}
}
