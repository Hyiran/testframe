/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.config.service.impl<br/>
 * <b>文件名：</b>DataSourceConnInfoServiceImpl.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-上午10:07:42<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.conn.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.conn.dao.DataSourceConnMapper;
import com.scloudpay.testframe.admin.conn.entity.DataSourceConn;
import com.scloudpay.testframe.admin.conn.service.IDataSourceConnInfoService;

/**
 *
 * DataSourceConnInfoServiceImpl
 * 
 * @author TanDong
 * 2016年12月23日 上午10:07:42
 * 
 * @version 1.0.0
 *
 */
@Service("dataSourceConnService")
@Transactional(readOnly = true)
public class DataSourceConnInfoServiceImpl implements IDataSourceConnInfoService {
	
	private static Logger logger = LoggerFactory.getLogger(DataSourceConnInfoServiceImpl.class);

	@Autowired
	private DataSourceConnMapper dataSourceConnMapper;
	
	/* 
	 * 保存系统数据库连接信息，同时保存数据库连接信息的权限设置
	 * @see com.tandong.ssm.sysmgr.service.IDataSourceConnInfoService#saveDataSourceConnInfo(com.tandong.ssm.sysmgr.entity.DataSourceConnInfo)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveDataSourceConnInfo(DataSourceConn dataSourceConn)
			throws ApplicationException {
		try{
			//插入数据库连接信息主表
			dataSourceConnMapper.insert(dataSourceConn);
			
		}catch(Exception e){
			logger.error("添加数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateDataSourceConnInfo(DataSourceConn dataSourceConn) throws ApplicationException {
		try{
			dataSourceConnMapper.updateByPrimaryKeySelective(dataSourceConn);
		}catch(Exception e){
			logger.error("更新数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delDataSourceConnInfo(long id) throws ApplicationException {
		try{
			//删除系统数据库连接信息
			dataSourceConnMapper.deleteByPrimaryKey(id);
		}catch(Exception e){
			logger.error("删除数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delDataSourceConnInfo(List<Long> ids) throws ApplicationException {
		try{
			
			for(int i=0; i<ids.size(); i++){
				//删除系统数据库连接信息
				dataSourceConnMapper.deleteByPrimaryKey(ids.get(i));
			}
			
		}catch(Exception e){
			logger.error("删除数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ninefbank.smallpay.aitest.config.service.IDataSourceConnInfoService#getDataSourceConnInfo(long)
	 */
	public DataSourceConn getDataSourceConnInfo(long id) throws ApplicationException {
		try{
			return dataSourceConnMapper.selectByPrimaryKey(id);
		}catch(Exception e){
			logger.error("获取数据库连接信息失败", e);
			throw new ApplicationException("error.dataSourceConn.get");
		}
	}

	/* (non-Javadoc)
	 * @see com.ninefbank.smallpay.aitest.config.service.IDataSourceConnInfoService#queryWithPage(java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
	 */
	public PageList<DataSourceConn> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return dataSourceConnMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询数据库连接信息失败", e);
			throw new ApplicationException("error.ftpconn.query");
		}
	}
	
	public List<DataSourceConn> queryAll() throws ApplicationException {
		try{
			return dataSourceConnMapper.selectAll();
		} catch (Exception e) {
			logger.error("查询数据库连接信息失败", e);
			throw new ApplicationException("error.ftpconn.query");
		}
	}
}
