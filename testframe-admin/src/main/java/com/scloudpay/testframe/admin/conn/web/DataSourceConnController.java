/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.config.web<br/>
 * <b>文件名：</b>DataSourceConnController.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-上午10:07:53<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.conn.web;

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
import com.scloudpay.testframe.admin.conn.entity.DataSourceConn;
import com.scloudpay.testframe.admin.conn.service.IDataSourceConnInfoService;

/**
 *
 * DataSourceConnController
 * 
 * @author TanDong
 * 2016年12月23日 上午10:07:53
 * 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("conn/db")
public class DataSourceConnController extends BaseController {

	@Autowired
	private IDataSourceConnInfoService dataSourceConnService;

	/**
	 * 分页查询FTP连接信息
	 * 
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/queryWithPage", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryDataSourceConn(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String condition) throws ApplicationException {

		Map<String, Object> params = new HashMap<String, Object>();

		PageBounds pageBounds = buildPageBounds(pageSize, currentPage, true);
		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%" + condition + "%");
		}

		PageList<DataSourceConn> ret = dataSourceConnService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, currentPage, ret);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryAll() throws ApplicationException {

		List<DataSourceConn> ret = dataSourceConnService.queryAll();

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
	public Map<String, Object> addDataSourceConn(@RequestBody DataSourceConn dataSourceConn) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dataSourceConnService.saveDataSourceConnInfo(dataSourceConn);
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
	public Map<String, Object> updateDataSourceConn(@RequestBody DataSourceConn dataSourceConn)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dataSourceConnService.updateDataSourceConnInfo(dataSourceConn);
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
	public @ResponseBody Map<String, Object> delDataSourceConn(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dataSourceConnService.delDataSourceConnInfo(id);
		ret.put("success", true);
		return ret;
	}
	
	@RequestMapping(value = "/delBatch", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delDataSourceConnBatch(@RequestParam("ids[]") List<Long> ids)
			throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dataSourceConnService.delDataSourceConnInfo(ids);
		ret.put("success", true);
		return ret;
	}
}
