package com.scloudpay.testframe.admin.channel.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.channel.dao.ChannelInfoMapper;
import com.scloudpay.testframe.admin.channel.entity.ChannelInfo;
import com.scloudpay.testframe.admin.channel.service.IChannelInfoService;

/**
 * 申购业务订单服务实现
 * 
 * @author TanDong
 *
 */
@Service("channelInfoService")
@Transactional(readOnly = true)
public class ChannelInfoServiceImpl implements IChannelInfoService {

	private static Log logger = LogFactory.getLog(ChannelInfoServiceImpl.class);

	@Autowired
	private ChannelInfoMapper channelInfoMapper;
	
	public List<ChannelInfo> getAllChannel() throws ApplicationException {
		try{
			return channelInfoMapper.getAllChannel();
		} catch (Exception e) {
			logger.error("查询基金渠道信息失败", e);
			throw new ApplicationException("error.fundchannel.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.iknowbox.admin.channel.service.IChannelInfoService#insertChannelInfoHis(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int insertChannelInfoHis(String batchNo) {
		int i=0; 
		try {
			i = channelInfoMapper.insertChannelInfoHis(batchNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	

}
