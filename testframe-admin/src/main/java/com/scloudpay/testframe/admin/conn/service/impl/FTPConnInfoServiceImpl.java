/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.config.service.impl<br/>
 * <b>文件名：</b>FTPConnInfoServiceImpl.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-上午10:07:42<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.conn.service.impl;

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
import com.scloudpay.testframe.admin.conn.dao.FTPConnInfoMapper;
import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;
import com.scloudpay.testframe.admin.conn.service.IFTPConnInfoService;

/**
 *
 * FTPConnInfoServiceImpl
 * 
 * @author TanDong
 * 2016年12月23日 上午10:07:42
 * 
 * @version 1.0.0
 *
 */
@Service("ftpConnInfoService")
@Transactional(readOnly = true)
public class FTPConnInfoServiceImpl implements IFTPConnInfoService {
	
	private static Log logger = LogFactory.getLog(FTPConnInfoServiceImpl.class);

	@Autowired
	private FTPConnInfoMapper ftpConnInfoMapper;
	
	/* 
	 * 保存系统数据库连接信息，同时保存数据库连接信息的权限设置
	 * @see com.tandong.ssm.sysmgr.service.IFTPConnInfoService#saveFTPConnInfo(com.tandong.ssm.sysmgr.entity.FTPConnInfo)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveFTPConnInfo(FTPConnInfo ftpConnInfo)
			throws ApplicationException {
		try{
			//插入数据库连接信息主表
			ftpConnInfoMapper.insert(ftpConnInfo);
			
		}catch(Exception e){
			logger.error("添加数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateFTPConnInfo(FTPConnInfo ftpConnInfo) throws ApplicationException {
		try{
			ftpConnInfoMapper.updateByPrimaryKeySelective(ftpConnInfo);
		}catch(Exception e){
			logger.error("更新数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delFTPConnInfo(long id) throws ApplicationException {
		try{
			//删除系统数据库连接信息
			ftpConnInfoMapper.deleteByPrimaryKey(id);
		}catch(Exception e){
			logger.error("删除数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delFTPConnInfo(List<Long> ids) throws ApplicationException {
		try{
			
			for(int i=0; i<ids.size(); i++){
				//删除系统数据库连接信息
				ftpConnInfoMapper.deleteByPrimaryKey(ids.get(i));
			}
			
		}catch(Exception e){
			logger.error("删除数据库连接信息失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ninefbank.smallpay.aitest.config.service.IFTPConnInfoService#getFTPConnInfo(long)
	 */
	public FTPConnInfo getFTPConnInfo(long id) throws ApplicationException {
		try{
			return ftpConnInfoMapper.selectByPrimaryKey(id);
		}catch(Exception e){
			logger.error("获取数据库连接信息失败", e);
			throw new ApplicationException("error.ftpConnInfo.get");
		}
	}

	/* (non-Javadoc)
	 * @see com.ninefbank.smallpay.aitest.config.service.IFTPConnInfoService#queryWithPage(java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
	 */
	public PageList<FTPConnInfo> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return ftpConnInfoMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询数据库连接信息失败", e);
			throw new ApplicationException("error.ftpconn.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.ninefbank.smallpay.aitest.conn.service.IFTPConnInfoService#queryAll()
	 */
	public List<FTPConnInfo> queryAll() throws ApplicationException {
		try{
			return ftpConnInfoMapper.selectAll();
		} catch (Exception e) {
			logger.error("查询数据库连接信息失败", e);
			throw new ApplicationException("error.ftpconn.query");
		}
	}
}
