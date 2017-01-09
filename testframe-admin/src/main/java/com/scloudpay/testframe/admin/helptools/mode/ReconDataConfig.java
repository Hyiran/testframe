/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.helptools.entity<br/>
 * <b>文件名：</b>ReconDataConfig.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月22日-下午1:08:50<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.helptools.mode;

import java.io.Serializable;

/**
 *
 * ReconDataConfig 对账数据生成配置信息
 * 
 * @author TanDong
 * 2016年12月22日 下午1:08:50
 * 
 * @version 1.0.0
 *
 */
public class ReconDataConfig implements Serializable{
	
	/**
	 * serialVersionUID:（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	public static String FTLNAME = "reconfile.ftl";
	
	private String tempDir;//临时目录用户临时存放生成的对账文件
	
	private String reconOrderTableName;//对账订单表名
	
	private long ftpConfigId;
	
	private long dataSourceId;

	private String channelNo;
	
	private String tradeDate;
	
	private String recon_error1;
	
	private String recon_error1_val;
	
	private String recon_error2;
	
	private String recon_error2_val;
	
	private String recon_error3;
	
	private String recon_error3_val;
	
	public String getTempDir() {
		return tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public long getFtpConfigId() {
		return ftpConfigId;
	}

	public void setFtpConfigId(long ftpConfigId) {
		this.ftpConfigId = ftpConfigId;
	}

	public long getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(long dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getRecon_error1() {
		return recon_error1;
	}

	public void setRecon_error1(String recon_error1) {
		this.recon_error1 = recon_error1;
	}

	public String getRecon_error1_val() {
		return recon_error1_val;
	}

	public void setRecon_error1_val(String recon_error1_val) {
		this.recon_error1_val = recon_error1_val;
	}

	public String getRecon_error2() {
		return recon_error2;
	}

	public void setRecon_error2(String recon_error2) {
		this.recon_error2 = recon_error2;
	}

	public String getRecon_error2_val() {
		return recon_error2_val;
	}

	public void setRecon_error2_val(String recon_error2_val) {
		this.recon_error2_val = recon_error2_val;
	}

	public String getRecon_error3() {
		return recon_error3;
	}

	public void setRecon_error3(String recon_error3) {
		this.recon_error3 = recon_error3;
	}

	public String getRecon_error3_val() {
		return recon_error3_val;
	}

	public void setRecon_error3_val(String recon_error3_val) {
		this.recon_error3_val = recon_error3_val;
	}

	public String getReconOrderTableName() {
		return reconOrderTableName;
	}

	public void setReconOrderTableName(String reconOrderTableName) {
		this.reconOrderTableName = reconOrderTableName;
	}

}
