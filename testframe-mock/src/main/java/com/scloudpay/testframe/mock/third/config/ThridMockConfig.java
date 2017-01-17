/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.mock.server.config<br/>
 * <b>文件名：</b>ThridMockConfig.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月10日-下午1:38:22<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.mock.third.config;

/**
 *
 * ThridMockConfig
 * 
 * @author TanDong
 * 2017年1月10日 下午1:38:22
 * 
 * @version 1.0.0
 *
 */
public class ThridMockConfig {

	int port;
	
	String input;
	
	String output;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}
