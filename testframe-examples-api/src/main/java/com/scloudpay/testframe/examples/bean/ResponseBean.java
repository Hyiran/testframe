/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.examples.bean<br/>
 * <b>文件名：</b>ResponseBean.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午4:06:54<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.examples.bean;

import java.io.Serializable;

/**
 *
 * ResponseBean
 * 
 * @author TanDong
 * 2017年1月5日 下午4:06:54
 * 
 * @version 1.0.0
 *
 */
public class ResponseBean implements Serializable {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	public ResponseBean(String orderNo, int statu){
		this.orderNo = orderNo;
		this.statu = statu;
	}
	
	private String orderNo;
	
	private int statu;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}
	
}
