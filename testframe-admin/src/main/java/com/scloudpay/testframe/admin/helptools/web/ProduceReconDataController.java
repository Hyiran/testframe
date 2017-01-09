package com.scloudpay.testframe.admin.helptools.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.ninefbank.smallpay.common.web.BaseController;
import com.scloudpay.testframe.admin.helptools.mode.ReconDataConfig;
import com.scloudpay.testframe.admin.helptools.service.IProduceReconDataService;

/**
 * 对账数据生成器请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("ht")
public class ProduceReconDataController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(ProduceReconDataController.class);

	@Autowired
	private IProduceReconDataService produceReconDataService;

	/**
	 * 生成对账数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rd/produce", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> produceReconData(HttpServletRequest request, @RequestBody ReconDataConfig rcConfig)
			throws ApplicationException {

		if (null == rcConfig) {
			return this.buildErrorResult("参数为空");
		}
		if (null == rcConfig.getChannelNo() || "".equals(rcConfig.getChannelNo())) {
			return this.buildErrorResult("参数错误：渠道不能为空");
		}
		if (null == rcConfig.getTradeDate() || "".equals(rcConfig.getTradeDate())) {
			return this.buildErrorResult("参数错误：交易日期不能为空");
		}

		String temp = request.getSession().getServletContext().getRealPath("");
		logger.info("保存临时对账文件目录：" + temp);
		rcConfig.setTempDir(temp);// 设置对账文件存储临时目录

		Map<String, Object> result = produceReconDataService.produceReconData(rcConfig);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("count", result.get("count"));
		ret.put("msg", "对账文件数据生成成功，共 " + result.get("count") + "条数据。");
		ret.put("filepath", result.get("filepath"));

		return this.buildResult(ret);
	}

	/**
	 * download(下载生成的对账文件)<br/>
	 * @param tempFilePath
	 * @return
	 * @throws IOException
	 * ResponseEntity<byte[]>
	 * @exception
	 * @since  1.0.0
	*/
	@RequestMapping(value = "/rd/dowload", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@RequestParam String path) throws IOException {
		File file = new File(path);
		String fileName = file.getName();
		String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
