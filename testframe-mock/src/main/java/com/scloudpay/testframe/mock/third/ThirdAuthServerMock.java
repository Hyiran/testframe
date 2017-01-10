/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock.server<br/>
 * <b>文件名：</b>ThirdAuthServerMock.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-下午12:15:45<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock.third;

import com.scloudpay.testframe.mock.third.handler.ThirdAuthServerHandler;

import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *
 * ThirdAuthServerMock 第三方银行卡认证模拟
 * 
 * @author TanDong
 * 2017年1月10日 下午12:15:45
 * 
 * @version 1.0.0
 *
 */
public class ThirdAuthServerMock extends HttpServerMock {

	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.mock.server.HttpServerMock#getHandler()
	 */
	public ChannelInboundHandlerAdapter getHandler() {
		return new ThirdAuthServerHandler();
	}
	
}
