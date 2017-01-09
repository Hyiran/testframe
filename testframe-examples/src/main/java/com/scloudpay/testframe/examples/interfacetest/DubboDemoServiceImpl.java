/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.examples<br/>
 * <b>文件名：</b>DubboDemoServiceImpl.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午3:53:30<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.examples.interfacetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.examples.api.DubboDemoService;
import com.scloudpay.testframe.examples.bean.RequestBean;
import com.scloudpay.testframe.examples.bean.ResponseBean;

/**
 *
 * DubboDemoServiceImpl
 * 
 * @author TanDong
 * 2017年1月5日 下午3:53:30
 * 
 * @version 1.0.0
 *
 */
public class DubboDemoServiceImpl implements DubboDemoService {

	Logger logger = LoggerFactory.getLogger(DubboDemoServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.examples.api.DubboDemoService#dk(com.scloudpay.testframe.examples.bean.RequestBean)
	 */
	public ResponseBean dk(RequestBean request) throws ApplicationException {
		logger.info("执行Dubbo测试服务...");
		System.out.println("参数数据："+"卡号："+request.getCardNo()+"订单号："+request.getOrderNo());
		return new ResponseBean("ORDERNO_201701050000001",1);
	}

}
