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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

import com.scloudpay.testframe.mock.third.ThirdAuthServerMock;
import com.scloudpay.testframe.mock.third.config.ThridMockConfig;

import junit.framework.TestCase;

/**
 *
 * ServerMockTest
 * 
 * @author TanDong 2017年1月10日 下午1:39:59
 * 
 * @version 1.0.0
 *
 */
public class ThirdAuthServerMockTest extends TestCase {
	
	ThirdAuthServerMock mock;

	@Before
	public void testInit() {

		final ThridMockConfig conf = new ThridMockConfig();
		conf.setPort(8090);

		
		new Thread(){
			public void run(){
				mock = new ThirdAuthServerMock(conf);
				mock.start();
			}
		}.start();
	}

	@Test
	public void testSend() {
		HttpClient client = new HttpClient();
        try {
			client.connect("127.0.0.1", 8090);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void testStop() {
		mock.stop();
	}
}
