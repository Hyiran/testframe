package com.scloudpay.testframe.admin.helptools.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcraft.jsch.ChannelSftp;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.conn.dao.DataSourceConnMapper;
import com.scloudpay.testframe.admin.conn.dao.FTPConnInfoMapper;
import com.scloudpay.testframe.admin.conn.entity.DataSourceConnInfo;
import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;
import com.scloudpay.testframe.admin.helptools.FreeMarker;
import com.scloudpay.testframe.admin.helptools.OutReconOrderDataHelper;
import com.scloudpay.testframe.admin.helptools.entity.ChannelDKOrder;
import com.scloudpay.testframe.admin.helptools.mode.ReconData;
import com.scloudpay.testframe.admin.helptools.mode.ReconDataConfig;
import com.scloudpay.testframe.admin.helptools.service.IProduceReconDataService;
import com.scloudpay.testframe.admin.util.DataSourceUtil;
import com.scloudpay.testframe.admin.util.SFTPHelper;

/**
 * 第三方对账数据生成服务实现
 * 
 * @author TanDong
 *
 */
@Service("produceReconDataService")
@Transactional(readOnly = true)
public class ProduceReconDataServiceImpl implements IProduceReconDataService {

	private static Logger logger = LoggerFactory.getLogger(ProduceReconDataServiceImpl.class);
	
	@Autowired 
	private FTPConnInfoMapper ftpConnMapper;
	
	@Autowired
	private DataSourceConnMapper dataSourceConnMapper;
	

	/* (non-Javadoc)
	 * @see com.ninefbank.smallpay.aitest.helptools.service.IProduceReconDataService#produceReconData(com.ninefbank.smallpay.aitest.helptools.mode.ReconDataConfig)
	 */
	public Map<String, Object> produceReconData(ReconDataConfig rcConfig) throws ApplicationException {
		
		Map<String, Object> ret = new HashMap<String, Object>();
		
		logger.info("开始生成对账数据");
		
		List<ReconData> rds = produceData(rcConfig);
		if(rds.isEmpty()){
			ret.put("count", 0);
			return ret;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("reconDatas", rds);
		
		String tempDir = rcConfig.getTempDir();
		String fileName = rcConfig.getTradeDate()+"_"+rcConfig.getChannelNo()+".txt";
		
		String tempfilepath = tempDir+"/"+fileName;
		
		//写入临时文件
		String filepath = FreeMarker.createFile(ReconDataConfig.FTLNAME, data, tempfilepath);
		
		logger.info("文件生成成功："+filepath);
		
		//获取FTP连接信息并上传文件
		FTPConnInfo ftpConn = ftpConnMapper.selectByPrimaryKey(rcConfig.getFtpConfigId());
		if(null == ftpConn){
			throw new ApplicationException("error_ftp_noexits", "FTP连接信息为空");
		}
		logger.info("正在上传...");
		try{
			SFTPHelper channel = new SFTPHelper();
	        ChannelSftp chSftp = channel.getChannel(ftpConn, 60000);
	        chSftp.put(filepath, ftpConn.getRootPath()+fileName, ChannelSftp.OVERWRITE); // 代码段2
	        chSftp.quit();
	        channel.closeChannel();
		}catch(Exception e){
			logger.error("上传失败", e);
			throw new ApplicationException("error_ftp_upload","对账文件上传失败");
		}
		logger.info("完成上传");
		logger.info("生成对账数据完成");
		
		ret.put("count", rds.size());
		ret.put("filepath", tempfilepath);
		return ret;
				
	}
	
	
	/**
	 * produceData(生产对账文件数据)<br/>
	 * @param rcConfig
	 * @return
	 * Map<String,Object>
	 * @exception
	 * @since  1.0.0
	*/
	private List<ReconData> produceData(ReconDataConfig rcConfig) throws ApplicationException {
		
		DataSourceConnInfo dbConn = dataSourceConnMapper.selectByPrimaryKey(rcConfig.getDataSourceId());
		
		if(null == dbConn){
			throw new ApplicationException("ERROR_DB", "订单数据的数据源配置错误：为null");
		}
		
		//根据对账配置的订单数据源，创建订单数据库访问辅助类
		DataSourceUtil dbHelper = new DataSourceUtil(dbConn);
		
		//根据对账配置的和对账订单数据源访问辅助类，创建外部对账订单数据获取辅助类
		OutReconOrderDataHelper outReconDataHelper = new OutReconOrderDataHelper(dbHelper, rcConfig);
		
		//获取外部对账代扣订单数据
		List<ChannelDKOrder> retData = outReconDataHelper.getDKOrderData();
		
		//根据渠道代扣订单数据和对账数据生成配置项，生成对应的对账文件数据
		List<ReconData> rds = new ArrayList<ReconData>();
		for(ChannelDKOrder order : retData){
			ReconData rd = new ReconData();
			rd.setChannelNo(rcConfig.getChannelNo());
			rd.setChannelName(rcConfig.getChannelNo());
			rd.setTradeTime(order.getTradeDate());
			rd.setBizOrderNo(order.getPayOrderNo());
			rd.setChannelOrderNo(order.getChannelOrderNo());
			rd.setOrderStatu(order.getTradeStatu());
			rd.setOrderAmount(String.valueOf(order.getAmount()));
			rd.setFee(String.valueOf(getOrderFee(order.getInterCode())));
			rds.add(rd);
		}
		
		logger.info("共生成"+rds.size()+"条数据。");
		
		return rds;
		
	}
	
	/**
	 * getOrderFee(根据机构编号，获取该机构每笔订单的手续费)<br/>
	 * @param interCode
	 * @return
	 * BigDecimal
	 * @exception
	 * @since  1.0.0
	*/
	private BigDecimal getOrderFee(String interCode){
		return new BigDecimal(0);
	} 


}
