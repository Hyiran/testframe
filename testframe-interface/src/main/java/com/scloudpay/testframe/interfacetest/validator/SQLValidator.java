/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest.validator<br/>
 * <b>文件名：</b>SQLValidator.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午5:44:36<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.interfacetest.validator;

import com.scloudpay.testframe.interfacetest.bean.ValidatorMessage;

/**
 *
 * SQLValidator SQL验证器，通过执行查询SQL语句验证接口逻辑正确性
 * 
 * @author TanDong
 * 2017年1月5日 下午5:44:36
 * 
 * @version 1.0.0
 *
 */
public class SQLValidator implements Validator {

	public ValidatorMessage validate(Object sql) {
		return null;
	}

	public ValidatorMessage validate() {
		return null;
	}

}
