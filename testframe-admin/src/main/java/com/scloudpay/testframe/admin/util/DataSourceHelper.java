/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.util<br/>
 * <b>文件名：</b>DataSourceUtil.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-下午3:02:08<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.conn.entity.DataSourceConn;

/**
 *
 * DataSourceUtil 测试数据库操作工具类
 * 
 * @author TanDong 2016年12月23日 下午3:02:08
 * 
 * @version 1.0.0
 *
 */
public class DataSourceHelper {

	private static Logger logger = LoggerFactory.getLogger(DataSourceHelper.class);

	public String DB_URL = "jdbc:mysql://rdsp5ae3ypidj48wkt2o.mysql.rds.aliyuncs.com:3306/pay_channel?useUnicode=true&amp;characterEncoding=UTF-8";

	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	private DataSourceConn dataSource;

	public Connection conn = null;

	public PreparedStatement preparedStatement = null;

	/**
	 * 创建一个新的实例 DataSourceHelper.
	 *
	 * @param dataSource
	 */
	public DataSourceHelper(DataSourceConn dataSource) {
		this.dataSource = dataSource;
		DB_URL = "jdbc:mysql://"+dataSource.getIpAddress()+":"+dataSource.getPort()+"/"+dataSource.getDbName()+"?useUnicode=true&amp;characterEncoding=UTF-8";
	}

	public static void sshConnect() {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession("root", "101.200.130.76", 22);
			session.setConfig("StrictHostKeyChecking", "no");  
			session.setPassword("JOCxzOe6He");
			
			int assinged_port = session.setPortForwardingL("10.3.43.15",3307, "rdsp5ae3ypidj48wkt2o.mysql.rds.aliyuncs.com", 3306);//端口映射 转发
			System.out.println("localhost:" + assinged_port);
			
			session.connect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeSQL(String sql) throws ApplicationException{
		ResultSet ret = null;
		try {
			Class.forName(DRIVER_NAME);// 指定连接类型
			
			// sshConnect();
			conn = DriverManager.getConnection(DB_URL, dataSource.getUserName(), dataSource.getPwd());// 获取连接
			preparedStatement = conn.prepareStatement(sql);
			ret = preparedStatement.executeQuery();
		} catch (Exception e) {
			logger.error("数据源连接异常", e);
			throw new ApplicationException("ERROR_DB", "数据源连接异常");
		}
		return ret;
	}

	/**
	 * close(这里用一句话描述这个方法的作用)<br/>
	 * void
	 * 
	 * @exception @since
	 *                1.0.0
	 */
	public void close() {
		try {
			this.conn.close();
			this.preparedStatement.close();
		} catch (SQLException e) {
			logger.error("数据源连接关闭异常", e);
		}
	}

}
