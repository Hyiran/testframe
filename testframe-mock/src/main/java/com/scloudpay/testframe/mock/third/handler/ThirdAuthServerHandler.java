/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock.server.handler<br/>
 * <b>文件名：</b>ThirdAuthServerHandler.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-下午12:16:36<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock.third.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * ThirdAuthServerHandler
 * 
 * @author TanDong
 * 2017年1月10日 下午12:16:36
 * 
 * @version 1.0.0
 *
 */
public class ThirdAuthServerHandler extends HttpServerInboundHandler {

	Logger logger = LoggerFactory.getLogger(ThirdAuthServerHandler.class);

	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.mock.server.handler.HttpServerInboundHandler#getResponseMsg(java.lang.String)
	 */
	public byte[] getResponseMsg(String reqMsg) {
		//String 转换为DTO
		//根据DTO进行响应消息构建
		return null;
	}


}
