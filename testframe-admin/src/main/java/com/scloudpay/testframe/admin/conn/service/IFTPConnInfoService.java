/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.config.service<br/>
 * <b>文件名：</b>IFTPConnInfoService.java<br/>
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
import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;

/**
 *
 * IFTPConnInfoService
 * 
 * @author TanDong
 * 2016年12月23日 上午10:07:24
 * 
 * @version 1.0.0
 *
 */
public interface IFTPConnInfoService {
	
	/**
	 * queryAll(这里用一句话描述这个方法的作用)<br/>
	 * @return
	 * @throws ApplicationException
	 * List<FTPConnInfo>
	 * @exception
	 * @since  1.0.0
	*/
	public List<FTPConnInfo> queryAll() throws ApplicationException;
	

	/**
	 * 分页查询FTP连接信息
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<FTPConnInfo> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 增加FTP连接信息
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveFTPConnInfo(FTPConnInfo ftpConnInfo) throws ApplicationException;
	
	/**
	 * 更新FTP连接信息信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateFTPConnInfo(FTPConnInfo ftpConnInfo) throws ApplicationException;
	
	/**
	 * 删除FTP连接信息信息
	 * @param id FTP连接信息ID
	 * @throws ApplicationException
	 */
	public void delFTPConnInfo(long id) throws ApplicationException;
	
	public void delFTPConnInfo(List<Long> ids) throws ApplicationException;
	
	/**
	 * 根据ID获取FTP连接信息信息
	 * @param id FTP连接信息ID
	 * @return
	 * @throws ApplicationException
	 */
	public FTPConnInfo getFTPConnInfo(long id) throws ApplicationException;

}
