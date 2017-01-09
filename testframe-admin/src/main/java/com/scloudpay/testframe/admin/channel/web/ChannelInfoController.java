package com.scloudpay.testframe.admin.channel.web;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ninefbank.smallpay.common.web.BaseController;
import com.scloudpay.testframe.admin.channel.entity.ChannelInfo;
import com.scloudpay.testframe.admin.channel.service.IChannelInfoService;

/**
 * 渠道信息请求处理
 * 
 * @author TanDong
 *
 */
@Controller
@RequestMapping("channel")
public class ChannelInfoController extends BaseController {

	@Autowired
	private IChannelInfoService channelInfoService;

	/**
	 * 查询所有渠道信息
	 * 
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryOrderPurchase() throws ApplicationException {

		List<ChannelInfo> ret = channelInfoService.getAllChannel();

		return buildResult(ret);
	}

}
