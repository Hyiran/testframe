/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.config.service<br/>
 * <b>文件名：</b>IDataSourceConnInfoService.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-上午10:07:24<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.conn.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.conn.entity.DataSourceConnInfo;

/**
 *
 * IDataSourceConnInfoService
 * 
 * @author TanDong
 * 2016年12月23日 上午10:07:24
 * 
 * @version 1.0.0
 *
 */
public interface IDataSourceConnInfoService {
	
	public List<DataSourceConnInfo> queryAll() throws ApplicationException;
	

	/**
	 * 分页查询数据库连接信息
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<DataSourceConnInfo> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 增加数据库连接信息
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveDataSourceConnInfo(DataSourceConnInfo dataSourceConnInfo) throws ApplicationException;
	
	/**
	 * 更新数据库连接信息信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateDataSourceConnInfo(DataSourceConnInfo dataSourceConnInfo) throws ApplicationException;
	
	/**
	 * 删除数据库连接信息信息
	 * @param id 数据库连接信息ID
	 * @throws ApplicationException
	 */
	public void delDataSourceConnInfo(long id) throws ApplicationException;
	
	public void delDataSourceConnInfo(List<Long> ids) throws ApplicationException;
	
	/**
	 * 根据ID获取数据库连接信息信息
	 * @param id 数据库连接信息ID
	 * @return
	 * @throws ApplicationException
	 */
	public DataSourceConnInfo getDataSourceConnInfo(long id) throws ApplicationException;

}
