package com.scloudpay.testframe.admin.channel.service;

import java.util.List;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.channel.entity.ChannelInfo;

/**
 * 
 * 基金渠道服务接口
 * 
 * @author TanDong
 *
 */
public interface IChannelInfoService {
	
	
	public List<ChannelInfo> getAllChannel() throws ApplicationException;

	public int insertChannelInfoHis(String batchNo);
}
