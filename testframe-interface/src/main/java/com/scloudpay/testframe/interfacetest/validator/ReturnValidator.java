/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest.validator<br/>
 * <b>文件名：</b>ReturnValidator.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午5:51:22<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.interfacetest.validator;

import com.scloudpay.testframe.examples.bean.ResponseBean;
import com.scloudpay.testframe.interfacetest.bean.ValidatorMessage;

/**
 *
 * ReturnValidator
 * 
 * @author TanDong
 * 2017年1月5日 下午5:51:22
 * 
 * @version 1.0.0
 *
 */
public class ReturnValidator implements Validator {

	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.interfacetest.validator.Validator#validate(java.lang.Object)
	 */
	public ValidatorMessage validate(Object obj) {
		ResponseBean res = (ResponseBean)obj;
				
		ValidatorMessage vmsg = new ValidatorMessage();
		vmsg.setResult(res.getStatu());
		return vmsg;
	}

	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.interfacetest.validator.Validator#validate()
	 */
	public ValidatorMessage validate() {
		return null;
	}

}
