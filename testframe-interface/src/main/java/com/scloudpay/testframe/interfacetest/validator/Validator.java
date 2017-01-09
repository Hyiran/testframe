/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest.validator<br/>
 * <b>文件名：</b>Validator.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午5:44:51<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.interfacetest.validator;

import com.scloudpay.testframe.interfacetest.bean.ValidatorMessage;

/**
 *
 * Validator
 * 
 * @author TanDong
 * 2017年1月5日 下午5:44:51
 * 
 * @version 1.0.0
 *
 */
public interface Validator {
	
	public ValidatorMessage validate(Object obj);
	
	public ValidatorMessage validate();

}
