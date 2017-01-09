/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.helptools.entity<br/>
 * <b>文件名：</b>ChannelDKOrder.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-下午4:47:56<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.helptools.entity;

import java.math.BigDecimal;

/**
 *
 * ChannelDKOrder 渠道代扣订单
 * 
 * @author TanDong
 * 2016年12月23日 下午4:47:56
 * 
 * @version 1.0.0
 *
 */
public class ChannelDKOrder {
	
	private long id;
	
	private String channelOrderNo;
	
	private String payOrderNo;
	
	private BigDecimal amount;
	
	private String tradeDate;
	
	private int tradeStatu;
	
	private String channelCode;
	
	private String interCode;
	
	private String instCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}

	public String getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public int getTradeStatu() {
		return tradeStatu;
	}

	public void setTradeStatu(int tradeStatu) {
		this.tradeStatu = tradeStatu;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getInterCode() {
		return interCode;
	}

	public void setInterCode(String interCode) {
		this.interCode = interCode;
	}

	public String getInstCode() {
		return instCode;
	}

	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
	
}
