/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock<br/>
 * <b>文件名：</b>ChannelDaiKouMock.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-上午9:40:40<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock.channel;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import com.ninefbank.smallpay.channel.api.server.IDaikouFacade;
import com.ninefbank.smallpay.channel.api.vo.daikou.DPayRepVo;
import com.ninefbank.smallpay.channel.api.vo.daikou.DPayReqVo;

/**
 *
 * ChannelDaiKouMock 渠道系统代扣模拟
 * 
 * @author TanDong
 * 2017年1月10日 上午9:40:40
 * 
 * @version 1.0.0
 *
 */
public class DaiKouMock extends ChannelMock {
	
	/**
	 * mockDKSuccess(模拟渠道系统代扣成功)<br/>
	 * @param req
	 * @return
	 * DPayRepVo
	 * @exception
	 * @since  1.0.0
	 */
	public static IDaikouFacade mockDKSuccess(DPayReqVo req){
		
		IDaikouFacade daikouFacade = mock(IDaikouFacade.class);  
		when(daikouFacade.pay(req)).thenReturn(buildSuccessRes(req)); 
		
		return daikouFacade;
	}
	
	/**
	 * mockDKError(模拟渠道系统代扣失败)<br/>
	 * @param req
	 * @return
	 * DPayRepVo
	 * @exception
	 * @since  1.0.0
	 */
	public static IDaikouFacade mockDKError(DPayReqVo req){
		
		IDaikouFacade facade = mock(IDaikouFacade.class);  
		when(facade.pay(req)).thenReturn(buildErrorRes(req)); 
		return facade;
	}
	
	/**
	 * mockDKTimeOut(模拟渠道系统代扣超时)<br/>
	 * @param req
	 * @param time
	 * @return
	 * DPayRepVo
	 * @exception
	 * @since  1.0.0
	 */
	public static IDaikouFacade mockDKTimeOut(DPayReqVo req, long time){
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		IDaikouFacade facade = mock(IDaikouFacade.class);  
		when(facade.pay(req)).thenReturn(buildSuccessRes(req)); 
		return facade;
	}
	
	
	
	@Test
	public void test(){
		
		DPayReqVo req = new DPayReqVo();
		req.setAmount(new BigDecimal(1000));
		req.setPayProductCode("P0001");
		req.setChannelCode("BF01");
		req.setOrderNo("P00012017011000001");
		
		IDaikouFacade facade = DaiKouMock.mockDKSuccess(req);
		DPayRepVo res = facade.pay(req);
		
		System.out.println(res.getChannelOrderNo());
	}

}
