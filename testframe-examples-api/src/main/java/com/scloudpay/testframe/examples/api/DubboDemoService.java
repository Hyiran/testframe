/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.examples<br/>
 * <b>文件名：</b>DubboDemoService.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午3:53:42<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.examples.api;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.examples.bean.RequestBean;
import com.scloudpay.testframe.examples.bean.ResponseBean;

/**
 *
 * DubboDemoService
 * 
 * @author TanDong
 * 2017年1月5日 下午3:53:42
 * 
 * @version 1.0.0
 *
 */
public interface DubboDemoService {
	
	public ResponseBean dk(RequestBean request) throws ApplicationException;

}
