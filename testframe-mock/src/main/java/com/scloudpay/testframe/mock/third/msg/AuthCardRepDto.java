package com.scloudpay.testframe.mock.third.msg;


/**
 * 
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月29日 上午9:39:54
 */
public class AuthCardRepDto extends BaseInfoRepDTO {
	
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	private String authCardNo;//请求纯银行卡认证订单号
	private String channelAuthCardNo;//渠道纯银行卡认证订单号
	private String cardNo ;		//卡号
	private String holderName ;	//姓名
	private String certNo ;		//证件号
	private String mobileNo ;	//手机号
	private String cvv2 ;		//cvv2
	private String expireDate ;	//有效期
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAuthCardNo() {
		return authCardNo;
	}
	public void setAuthCardNo(String authCardNo) {
		this.authCardNo = authCardNo;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getChannelAuthCardNo() {
		return channelAuthCardNo;
	}
	public void setChannelAuthCardNo(String channelAuthCardNo) {
		this.channelAuthCardNo = channelAuthCardNo;
	}
}
