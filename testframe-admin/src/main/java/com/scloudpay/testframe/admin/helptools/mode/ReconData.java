package com.scloudpay.testframe.admin.helptools.mode;

import java.io.Serializable;

/**
 *
 * ReconData
 * 
 * @author TanDong
 * 2016年12月22日 上午11:47:48
 * 
 * @version 1.0.0
 *
 */
public class ReconData implements Serializable {
    
	private Integer id;

    private String channelNo;

    private String channelName;

    private String channelOrderNo;

    private String bizOrderNo;

    private String tradeTime;

    private String fee;

    private int orderStatu;

    private String orderAmount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}

	public String getBizOrderNo() {
		return bizOrderNo;
	}

	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public int getOrderStatu() {
		return orderStatu;
	}

	public void setOrderStatu(int orderStatu) {
		this.orderStatu = orderStatu;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
}