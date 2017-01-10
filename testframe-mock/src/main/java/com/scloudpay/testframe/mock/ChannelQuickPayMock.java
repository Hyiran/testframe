/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock<br/>
 * <b>文件名：</b>ChannelQuickPayMock.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-上午10:44:14<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ninefbank.smallpay.channel.api.server.IQuickPayFacade;
import com.ninefbank.smallpay.channel.api.vo.quick.PayConfirmReqVo;
import com.ninefbank.smallpay.channel.api.vo.quick.SignReqVo;

/**
 *
 * ChannelQuickPayMock 渠道快捷支付模拟
 * 
 * @author TanDong
 * 2017年1月10日 上午10:44:14
 * 
 * @version 1.0.0
 *
 */
public class ChannelQuickPayMock extends ChannelMock {
	
	/**
	 * mockSignSuccess(这里用一句话描述这个方法的作用)<br/>
	 * @param req
	 * @return
	 * IQuickPayFacade
	 * @exception
	 * @since  1.0.0
	*/
	public static IQuickPayFacade mockSignSuccess(SignReqVo req){
		IQuickPayFacade facade = mock(IQuickPayFacade.class);  
		when(facade.sign(req)).thenReturn(buildSignSuccessRes(req)); 
		return facade;
	}
	
	/**
	 * mockQPSuccess(这里用一句话描述这个方法的作用)<br/>
	 * @param req
	 * @return
	 * IQuickPayFacade
	 * @exception
	 * @since  1.0.0
	*/
	public static IQuickPayFacade mockQPSuccess(PayConfirmReqVo req){
		IQuickPayFacade facade = mock(IQuickPayFacade.class);  
		when(facade.payConfirm(req)).thenReturn(buildQPSuccessRes(req)); 
		return facade;
	}
}
