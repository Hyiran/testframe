/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock<br/>
 * <b>文件名：</b>ServerMockTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-下午1:39:59<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock;

import com.scloudpay.testframe.mock.third.ThirdAuthServerMock;

import junit.framework.TestCase;

/**
 *
 * ServerMockTest
 * 
 * @author TanDong
 * 2017年1月10日 下午1:39:59
 * 
 * @version 1.0.0
 *
 */
public class ThirdAuthServerMockTest extends TestCase {
	
	public void test(){
		ThirdAuthServerMock mock = new ThirdAuthServerMock();
		mock.start(8090);
	}

}
