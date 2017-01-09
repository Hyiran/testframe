package com.scloudpay.testframe.admin.helptools.service;

import java.util.Map;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.helptools.mode.ReconDataConfig;

/**
 * 
 * 第三方对账数据生成服务接口
 * 
 * @author TanDong
 *
 */
public interface IProduceReconDataService {
	
	public Map<String, Object> produceReconData(ReconDataConfig rcConfig) throws ApplicationException;
	
}
