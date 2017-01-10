package com.scloudpay.testframe.mock.third.msg;

import com.ninefbank.smallpay.channel.common.enums.EnumCertType;
import com.ninefbank.smallpay.channel.common.enums.EnumSourceType;
/**
 * 纯银行卡认证
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月29日 上午9:40:26
 */
public class AuthCardReqDto extends BaseInfoReqDTO {
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 1L;
	private String userId;//银行卡认证用户id
	private String authCardNo;//请求流水号
	private String channelAuthCardNo;//渠道请求流水号哦
	private String holderName ;	//姓名
	private String certNo ;		//证件号
	private EnumCertType certType;//证件类型
	private String mobileNo ;	//手机号
	private String cvv2 ;		//cvv2
	private String expireDate ;	//有效期
	private String payToolCode ;//支付工具编码
	private String payProductCode ;//支付产品编码
	
	private EnumSourceType sourceType  = EnumSourceType.AUTHCARD;//来源
	
	
	public EnumSourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(EnumSourceType sourceType) {
		this.sourceType = sourceType;
	}
	public String getAuthCardNo() {
		return authCardNo;
	}
	public void setAuthCardNo(String authCardNo) {
		this.authCardNo = authCardNo;
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
	public String getPayToolCode() {
		return payToolCode;
	}
	public void setPayToolCode(String payToolCode) {
		this.payToolCode = payToolCode;
	}
	public String getPayProductCode() {
		return payProductCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPayProductCode(String payProductCode) {
		this.payProductCode = payProductCode;
	}
	public String getChannelAuthCardNo() {
		return channelAuthCardNo;
	}
	public void setChannelAuthCardNo(String channelAuthCardNo) {
		this.channelAuthCardNo = channelAuthCardNo;
	}
	public EnumCertType getCertType() {
		return certType;
	}
	public void setCertType(EnumCertType certType) {
		this.certType = certType;
	}
	
}
