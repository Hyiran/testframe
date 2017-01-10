/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock<br/>
 * <b>文件名：</b>ChannelMock.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-上午9:38:20<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock.channel;

import java.util.Date;

import com.ninefbank.smallpay.channel.api.vo.daikou.DPayRepVo;
import com.ninefbank.smallpay.channel.api.vo.daikou.DPayReqVo;
import com.ninefbank.smallpay.channel.api.vo.quick.PayConfirmRepVo;
import com.ninefbank.smallpay.channel.api.vo.quick.PayConfirmReqVo;
import com.ninefbank.smallpay.channel.api.vo.quick.SignRepVo;
import com.ninefbank.smallpay.channel.api.vo.quick.SignReqVo;
import com.ninefbank.smallpay.channel.common.enums.EnumTradeStatus;

/**
 *
 * ChannelMock
 * 
 * @author TanDong
 * 2017年1月10日 上午9:38:20
 * 
 * @version 1.0.0
 *
 */
public class ChannelMock {
	
	/**
	 * buildSuccessRes(构建渠道代扣成功返回消息)<br/>
	 * @param req
	 * @return
	 * DPayRepVo
	 * @exception
	 * @since  1.0.0
	*/
	public static DPayRepVo buildSuccessRes(DPayReqVo req){
		//设置返回值
		DPayRepVo res = new DPayRepVo();
		res.setChannelOrderNo(req.getOrderNo());
		res.setAmount(req.getAmount());
		res.setBankFinishTime(new Date(System.currentTimeMillis()));
		res.setChannelFinishTime(new Date(System.currentTimeMillis()));
		res.setPayNo(req.getOrderNo());
		
		res.setBankRtnCode("100000");
		res.setBankRtnMsg("交易成功");
		res.setInstCode("BF01");
		res.setInterCode("BF01");
		res.setTradeStatus(EnumTradeStatus.SUCCESS);
		res.setRtnCode("10000");
		res.setRtnMsg("交易成功");
		res.setInterShortName("宝付");
		res.setInstCode("BF01");
		
		return res;
	}
	
	/**
	 * buildErrorRes(构建渠道代扣失败返回消息)<br/>
	 * @param req
	 * @return
	 * DPayRepVo
	 * @exception
	 * @since  1.0.0
	*/
	public static DPayRepVo buildErrorRes(DPayReqVo req){
		//设置返回值
		DPayRepVo res = new DPayRepVo();
		res.setChannelOrderNo(req.getOrderNo());
		res.setAmount(req.getAmount());
		res.setBankFinishTime(new Date(System.currentTimeMillis()));
		res.setChannelFinishTime(new Date(System.currentTimeMillis()));
		res.setPayNo(req.getOrderNo());
		
		res.setBankRtnCode("100001");
		res.setBankRtnMsg("交易失败");
		res.setInstCode("BF01");
		res.setInterCode("BF01");
		res.setTradeStatus(EnumTradeStatus.EXCEPTION);
		res.setRtnCode("10001");
		res.setRtnMsg("交易失败");
		res.setInterShortName("宝付");
		res.setInstCode("BF01");
		
		return res;
	}
	
	
	public static SignRepVo buildSignSuccessRes(SignReqVo req){
		
		return null;
	}
	
	public static PayConfirmRepVo buildQPSuccessRes(PayConfirmReqVo req){
		
		return null;
	}
	
}
