/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.ninefbank.smallpay.aitest.helptools<br/>
 * <b>文件名：</b>FreeMarker.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016年12月22日-下午12:00:15<br/>
 * <b>Copyright (c)</b> 2016 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.admin.helptools;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scloudpay.testframe.admin.helptools.mode.ReconData;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 *
 * FreeMarker
 * 
 * @author TanDong
 * 2016年12月22日 下午12:00:15
 * 
 * @version 1.0.0
 *
 */
public class FreeMarker {
	
	private static Logger logger = LoggerFactory.getLogger(FreeMarker.class);
	
	private static Configuration cfg = null;  
	  
    /**
     * getConfiguration(获取Freemark配置信息)<br/>
     * @return
     * Configuration
     * @exception
     * @since  1.0.0
    */
    @SuppressWarnings("deprecation")
	private static Configuration getConfiguration() {  
        if (null == cfg) {  
            cfg = new Configuration();  
            cfg.setClassForTemplateLoading(FreeMarker.class,"/templates/recon");  
            cfg.setEncoding(Locale.getDefault(), "UTF-8");  
              
            cfg.setObjectWrapper(new DefaultObjectWrapper());  
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);  
  
        }  
  
        return cfg;  
    }
    
    /**
     * createFile(创建对账数据文件)<br/>
     * @param ftl
     * @param data
     * @param targetFile
     * @return
     * boolean
     * @exception
     * @since  1.0.0
    */
    public  static String createFile(String ftl, Map<String,Object> data, String targetFile) {  
    	  
        try {  
            // 创建Template对象  
            Configuration cfg = FreeMarker.getConfiguration();  
            Template template = cfg.getTemplate(ftl);  
            template.setEncoding("UTF-8");  
  
            // 生成静态页面  
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8"));  
            template.process(data, out);  
            out.flush();  
            out.close();  
            
        } catch (IOException e) {  
        	logger.error("FreeMark生成对账文件数据错误：写文件失败",e);
        } catch (TemplateException e) {  
        	logger.error("FreeMark生成对账文件数据错误：模板错误",e);
        }  
        return targetFile;
    }  
    
    public static void main(String[] args) {
        List<ReconData> reconDatas = new ArrayList<ReconData>();  
        ReconData rd = new ReconData();
        rd.setChannelName("BF01");
        rd.setChannelNo("BF01");
        rd.setChannelOrderNo("T210011161209145952000026");
        rd.setOrderStatu(1);
        rd.setTradeTime("20161209100209");
        rd.setOrderAmount("30000");
        rd.setFee("0.3");
        reconDatas.add(rd);
        
        ReconData rd2 = new ReconData();
        rd2.setChannelName("BF01");
        rd2.setChannelNo("BF01");
        rd2.setChannelOrderNo("T210011161209145952000027");
        rd2.setOrderStatu(1);
        rd2.setTradeTime("20161209100300");
        rd2.setOrderAmount("40000");
        rd2.setFee("0.4");
        reconDatas.add(rd2);
        
        
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("reconDatas", reconDatas);
        
        // 生成HTML的完整路径  
        String htmlFullPath = "D:\\reconfile.txt";
        FreeMarker.createFile("reconfile.ftl", data, htmlFullPath);  
	}

}
