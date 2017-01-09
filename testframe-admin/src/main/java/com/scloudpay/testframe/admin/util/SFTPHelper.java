/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.util<br/>
 * <b>文件名：</b>SFTPHelper.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月26日-下午2:38:31<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.util;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.ninefbank.smallpay.common.exception.SystemException;
import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;

/**
 *
 * SFTPHelper
 * 
 * @author TanDong 2016年12月26日 下午2:38:31
 * 
 * @version 1.0.0
 *
 */
public class SFTPHelper {

	Session session = null;
	Channel channel = null;

	private static final Logger logger = LoggerFactory.getLogger(SFTPHelper.class);

	public ChannelSftp getChannel(FTPConnInfo ftpConnInfo, int timeout) throws JSchException {

		String ftpHost = ftpConnInfo.getIpAddress();
		int port = ftpConnInfo.getPort();
		String ftpUserName = ftpConnInfo.getUserName();
		String ftpPassword = ftpConnInfo.getPwd();

		JSch jsch = new JSch(); // 创建JSch对象
		session = jsch.getSession(ftpUserName, ftpHost, port); // 根据用户名，主机ip，端口获取一个Session对象
		logger.debug("Session created.");
		if (ftpPassword != null) {
			session.setPassword(ftpPassword); // 设置密码
		}
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config); // 为Session对象设置properties
		session.setTimeout(timeout); // 设置timeout时间
		session.connect(); // 通过Session建立链接
		logger.debug("Session connected.");

		logger.debug("Opening Channel.");
		channel = session.openChannel("sftp"); // 打开SFTP通道
		channel.connect(); // 建立SFTP通道的连接
		logger.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName + ", returning: " + channel);
		return (ChannelSftp) channel;
	}

	/**
	 * createDir(创建FTP路径)<br/>
	 * @param createpath
	 * @param sftp
	 * void
	 * @exception
	 * @since  1.0.0
	*/
	public void createDir(String createpath, ChannelSftp sftp) {
		try {
			if (isDirExist(createpath, sftp)) {
				sftp.cd(createpath);
			}
			String pathArry[] = createpath.split("/");
			StringBuffer filePath = new StringBuffer("/");
			for (String path : pathArry) {
				if (path.equals("")) {
					continue;
				}
				filePath.append(path + "/");
				if (isDirExist(filePath.toString(), sftp)) {
					sftp.cd(filePath.toString());
				} else {
					// 建立目录
					sftp.mkdir(filePath.toString());
					// 进入并设置为当前目录
					sftp.cd(filePath.toString());
				}
			}
			sftp.cd(createpath);
		} catch (SftpException e) {
			logger.error("创建路径错误",e);
			throw new SystemException("创建路径错误：" + createpath);
		}
	}

	public boolean isDirExist(String directory, ChannelSftp sftp) {
		boolean isDirExistFlag = false;
		try {
			SftpATTRS sftpATTRS = sftp.lstat(directory);
			isDirExistFlag = true;
			return sftpATTRS.isDir();
		} catch (Exception e) {
			if (e.getMessage().toLowerCase().equals("no such file")) {
				isDirExistFlag = false;
			}
		}
		return isDirExistFlag;
	}

	public void closeChannel() throws Exception {
		if (channel != null) {
			channel.disconnect();
		}
		if (session != null) {
			session.disconnect();
		}
	}
}
