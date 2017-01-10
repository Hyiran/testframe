package com.scloudpay.testframe.mock.third.msg;

import com.ninefbank.smallpay.channel.common.dto.BaseRepDTO;
import com.ninefbank.smallpay.channel.common.enums.EnumAuthStatus;

/**
 * 快捷返回结果基类
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月3日 下午1:02:31
 */
public class BaseInfoRepDTO extends BaseRepDTO {
	
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * 银行卡认证状态
	 */
	 private EnumAuthStatus authStatus;

	public EnumAuthStatus getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(EnumAuthStatus authStatus) {
		this.authStatus = authStatus;
	}
	 
	 
}
