/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest<br/>
 * <b>文件名：</b>TableFixtureTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月6日-下午2:01:47<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe;

import fitnesse.fixtures.TableFixture;

/**
 *
 * TableFixtureTest
 * 
 * @author TanDong 2017年1月6日 下午2:01:47
 * 
 * @version 1.0.0
 *
 */
public class TableFixtureTest extends TableFixture {

	protected void doStaticTable(int rows) {

		TaxCalculator tc = new TaxCalculator();
		double totaltax = 0;

		for (int row = 1; row < rows - 3; row++) {
			totaltax += tc.GetTax(getText(row, 1), Double.parseDouble(getText(row, 2)));
		}
		double taxintable = Double.parseDouble(getText(rows - 2, 2));
		if (taxintable == totaltax)
			right(rows - 2, 2);
		else
			wrong(rows - 2, 2, String.valueOf(totaltax));
	}
}
