/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.util<br/>
 * <b>文件名：</b>FTPHelper.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月23日-下午5:22:43<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;

/**
 *
 * FTPHelper FTP辅助类，连接FTP上传对账文件
 * 
 * @author TanDong
 * 2016年12月23日 下午5:22:43
 * 
 * @version 1.0.0
 *
 */
public class FTPHelper {
	
	private static Logger logger = LoggerFactory.getLogger(FTPHelper.class);
	
	private  static FTPClient ftp; 
	
    /**  
     *   
     * @param path 上传到ftp服务器哪个路径下     
     * @param addr 地址  
     * @param port 端口号  
     * @param username 用户名  
     * @param password 密码  
     * @return  
     * @throws Exception  
     */    
    private static boolean connect(String path,String addr,int port,String username,String password) throws Exception {      
        boolean result = false;      
        ftp = new FTPClient();      
        int reply;      
        ftp.connect(addr,port);      
        ftp.login(username,password);      
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);      
        reply = ftp.getReplyCode();      
        if (!FTPReply.isPositiveCompletion(reply)) {      
            ftp.disconnect();      
            return result;      
        }      
        ftp.changeWorkingDirectory(path);      
        result = true;      
        return result;      
    }      
    
    /**
     * upload(这里用一句话描述这个方法的作用)<br/>
     * @param file
     * @throws Exception
     * void
     * @exception
     * @since  1.0.0
    */
    private static void upload(File file) throws Exception{      
        if(file.isDirectory()){           
            ftp.makeDirectory(file.getName());                
            ftp.changeWorkingDirectory(file.getName());      
            String[] files = file.list();             
            for (int i = 0; i < files.length; i++) {      
                File file1 = new File(file.getPath()+"\\"+files[i] );      
                if(file1.isDirectory()){      
                    upload(file1);      
                    ftp.changeToParentDirectory();      
                }else{                    
                    File file2 = new File(file.getPath()+"\\"+files[i]);      
                    FileInputStream input = new FileInputStream(file2);      
                    ftp.storeFile(file2.getName(), input);      
                    input.close();                            
                }                 
            }      
        }else{      
            File file2 = new File(file.getPath());      
            FileInputStream input = new FileInputStream(file2);      
            ftp.storeFile(file2.getName(), input);      
            input.close();        
        }      
    }      
	
	/**
	 * uploadReconFile(上传生成的对账文件数据至FTP)<br/>
	 * @param ftpCfg
	 * @param ftpDir
	 * @param fileName
	 * @return
	 * boolean
	 * @exception
	 * @since  1.0.0
	*/
	public static boolean uploadReconFile(FTPConnInfo ftpCfg, String ftpDir, File reconFile){
		try {
			FTPHelper.connect(ftpDir, ftpCfg.getIpAddress(), ftpCfg.getPort(), ftpCfg.getUserName(), ftpCfg.getPwd());
			FTPHelper.upload(reconFile);
			return true;
		} catch (Exception e) {
			logger.error("对账文件上传FTP失败", e);
			return false;
		}
	}
	
   public static void main(String[] args) throws Exception{ 
	   
	   FTPConnInfo ftpCfg = new FTPConnInfo();
	   ftpCfg.setId(new Long(1));
	   ftpCfg.setIpAddress("101.200.130.76");
	   ftpCfg.setPort(22);
	   ftpCfg.setUserName("channelfile");
	   ftpCfg.setPwd("123456");
	   ftpCfg.setRootPath("");
	   
	   String ftpDir = "";
	   File reconFile = new File("D:\\1111.txt");
	   
	   boolean ret = FTPHelper.uploadReconFile(ftpCfg, ftpDir, reconFile);
	   System.out.println(ret==true?"上传成功":"上传失败");
			   
   } 

}
