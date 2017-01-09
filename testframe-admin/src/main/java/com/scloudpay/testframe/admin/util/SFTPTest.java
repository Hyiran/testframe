/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.util<br/>
 * <b>文件名：</b>SFTPTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月26日-下午2:54:52<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.util;

import java.util.HashMap;
import java.util.Map;

import com.jcraft.jsch.ChannelSftp;
import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;

/**
 *
 * SFTPTest
 * 
 * @author TanDong
 * 2016年12月26日 下午2:54:52
 * 
 * @version 1.0.0
 *
 */
public class SFTPTest {
	
	public static final String SFTP_REQ_HOST = "host";
    public static final String SFTP_REQ_PORT = "port";
    public static final String SFTP_REQ_USERNAME = "username";
    public static final String SFTP_REQ_PASSWORD = "password";
    public static final int SFTP_DEFAULT_PORT = 22;
    public static final String SFTP_REQ_LOC = "location";
	
	public SFTPHelper getSFTPHelper() {
        return new SFTPHelper();
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SFTPTest test = new SFTPTest();

        FTPConnInfo ftpCfg = new FTPConnInfo();
 	   	ftpCfg.setId(new Long(1));
 	   	ftpCfg.setIpAddress("101.200.130.76");
 	   	ftpCfg.setPort(22);
 	   	ftpCfg.setUserName("channelfile");
 	   	ftpCfg.setPwd("123456");
 	   	ftpCfg.setRootPath("");
        
        String src = "D:\\111.txt"; // 本地文件名
        String dst = "/data/ftp02/tandong/111.txt"; // 目标文件名
              
        SFTPHelper channel = test.getSFTPHelper();
        ChannelSftp chSftp = channel.getChannel(ftpCfg, 60000);
        chSftp.put(src, dst, ChannelSftp.OVERWRITE); // 代码段2
        chSftp.quit();
        channel.closeChannel();
    }
}