/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock<br/>
 * <b>文件名：</b>ChannelDaiKouMock.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-上午9:40:40<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.ninefbank.smallpay.channel.api.server.IDaikouFacade;
import com.ninefbank.smallpay.channel.api.vo.daikou.DPayRepVo;
import com.ninefbank.smallpay.channel.api.vo.daikou.DPayReqVo;
import com.ninefbank.smallpay.channel.common.enums.EnumTradeStatus;

/**
 *
 * ChannelDaiKouMock
 * 
 * @author TanDong
 * 2017年1月10日 上午9:40:40
 * 
 * @version 1.0.0
 *
 */
public class ChannelDaiKouMock extends ChannelMock {
	
	public DPayRepVo mockDKSuccess(DPayReqVo req){
		
		//设置返回值
		DPayRepVo res = new DPayRepVo();
		res.setChannelOrderNo(req.getOrderNo());
		res.setAmount(req.getAmount());
		res.setBankFinishTime(new Date(System.currentTimeMillis()));
		res.setBankRtnCode("100000");
		res.setChannelFinishTime(new Date(System.currentTimeMillis()));
		res.setBankRtnMsg("交易成功");
		res.setInstCode("BF01");
		res.setInterCode("BF01");
		res.setTradeStatus(EnumTradeStatus.SUCCESS);
		
		IDaikouFacade daikouFacade = mock(IDaikouFacade.class);  
		when(daikouFacade.pay(req)).thenReturn(res); 
		
		return res;
	}
	
	public DPayRepVo mockDKError(DPayReqVo req){
		
		//设置返回值
		DPayRepVo res = new DPayRepVo();
		res.setChannelOrderNo(req.getOrderNo());
		res.setAmount(req.getAmount());
		res.setBankFinishTime(new Date(System.currentTimeMillis()));
		res.setBankRtnCode("100000");
		res.setChannelFinishTime(new Date(System.currentTimeMillis()));
		
		IDaikouFacade daikouFacade = mock(IDaikouFacade.class);  
		when(daikouFacade.pay(req)).thenReturn(res); 
		
		return res;
	}
	
	public DPayRepVo mockDKTimeOut(DPayReqVo req, long time){
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.mockDKSuccess(req);
	}
	
	@Test
	public void test(){
		
		DPayReqVo req = new DPayReqVo();
		req.setAmount(new BigDecimal(1000));
		req.setPayProductCode("P0001");
		req.setChannelCode("BF01");
		req.setOrderNo("P00012017011000001");
		
		ChannelDaiKouMock dkMock = new ChannelDaiKouMock();
		DPayRepVo res = dkMock.mockDKSuccess(req);
		
		System.out.println(res.getChannelOrderNo());
	}

}
