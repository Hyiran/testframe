/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.helptools<br/>
 * <b>文件名：</b>ReconDataHelper.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-下午3:18:44<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.helptools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.helptools.entity.ChannelDKOrder;
import com.scloudpay.testframe.admin.helptools.mode.ReconDataConfig;
import com.scloudpay.testframe.admin.util.DataSourceHelper;

/**
 *
 * ReconDataHelper 参与外部对账的订单数据生成辅助类
 * 
 * @author TanDong 2016年12月23日 下午3:18:44
 * 
 * @version 1.0.0
 *
 */
public class OutReconOrderDataHelper {

	private static Logger logger = LoggerFactory.getLogger(OutReconOrderDataHelper.class);

	private ReconDataConfig config;

	private DataSourceHelper dsHelper;

	public OutReconOrderDataHelper(DataSourceHelper dsHelper, ReconDataConfig config) {
		this.config = config;
		this.dsHelper = dsHelper;
	}

	/**
	 * getDKOrderData(获取外部对账代扣订单数据)<br/>
	 * 
	 * @return List<Object>
	 * @exception @since
	 *                1.0.0
	 */
	public List<ChannelDKOrder> getDKOrderData() throws ApplicationException {

		List<ChannelDKOrder> dkOrders = new ArrayList<ChannelDKOrder>();

		String sql = "select * from channel_dktrade t where date_format(t.create_time, '%Y%m%d')  =  '"
				+ config.getTradeDate() + "' and t.inter_code = '" + config.getChannelNo() + "'";
		ResultSet ret = null;

		try {
			ret = dsHelper.executeSQL(sql);
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			while (ret.next()) {
				ChannelDKOrder dkOrder = new ChannelDKOrder();
				dkOrder.setId(ret.getLong(1));
				dkOrder.setPayOrderNo(ret.getString(2));
				dkOrder.setChannelOrderNo(ret.getString(3));
				dkOrder.setAmount(ret.getBigDecimal(8));
				dkOrder.setChannelCode(ret.getString(15));
				dkOrder.setInterCode(ret.getString(16));
				dkOrder.setInstCode(ret.getString(17));
				dkOrder.setTradeStatu(ret.getInt(26));
				dkOrder.setTradeDate(format1.format(ret.getTimestamp(24)));
				dkOrders.add(dkOrder);
			}
		}catch (Exception e) {
			logger.error("获取外部对账代扣订单数据失败", e);
			throw new ApplicationException("ERROR_DB", "获取外部对账代扣订单数据失败");
		} finally {
			try {
				if (null != ret) {
					ret.close();
				}
				dsHelper.close();// 关闭连接
			} catch (SQLException e) {
				logger.error("数据源连接关闭失败", e);
			}
		}

		return dkOrders;
	}

}
