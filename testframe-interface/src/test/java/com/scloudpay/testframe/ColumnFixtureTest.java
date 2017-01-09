/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest<br/>
 * <b>文件名：</b>ColumnFixtureTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午1:45:33<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe;

import fit.ColumnFixture;

/**
 *
 * ColumnFixtureTest
 * 
 * @author TanDong 2017年1月5日 下午1:45:33
 * 
 * @version 1.0.0
 *
 */
public class ColumnFixtureTest extends ColumnFixture {

	public String firstPart; // 对应列名|first part|

	public String secondPart; // 对应列名|second part|

	public String together() {// 对应列名|together?|

		return firstPart + "," + secondPart;

	}

	public int totalLength() {// 对应列名|total length?|

		return firstPart.length() + secondPart.length();

	}


}
