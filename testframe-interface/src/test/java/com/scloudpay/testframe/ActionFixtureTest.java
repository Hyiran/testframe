/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest<br/>
 * <b>文件名：</b>ActionFixtureTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午2:18:56<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe;

import fit.Fixture;

/**
 *
 * ActionFixtureTest
 * 
 * @author TanDong 2017年1月5日 下午2:18:56
 * 
 * @version 1.0.0
 *
 */
public class ActionFixtureTest extends Fixture {

	private String first, second, both;

	public void firstPart(String s) { // 对应于|first part|单元

		first = s;

	}

	public void secondPart(String s) { // 对应于|secondPart|单元

		second = s;

	}

	public void join() { // 对应|join|单元

		both = first + "," + second;

	}

	public String together() { // 对应|together|单元

		return both;

	}

}
