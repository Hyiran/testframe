/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest<br/>
 * <b>文件名：</b>ChannelInfoAuthTest.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月6日-下午5:02:36<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe;

import com.ninefbank.smallpay.channel.api.vo.info.AuthCardRepVo;
import com.ninefbank.smallpay.channel.api.vo.info.AuthCardReqVo;
import com.scloudpay.testframe.interfacetest.DubboCaller;

/**
 *
 * ChannelInfoAuthTest
 * 
 * @author TanDong
 * 2017年1月6日 下午5:02:36
 * 
 * @version 1.0.0
 *
 */
public class ChannelInfoAuthTest {
	
	public String authStatu;//认证状态
	
	public boolean orderData;//渠道订单数据正确性标识
	
	public void testInfoAuth(){
		
		DubboCaller<AuthCardReqVo, AuthCardRepVo> caller = new DubboCaller<AuthCardReqVo, AuthCardRepVo>();
		caller.init(new String[]{"channel-infoauth-consumer.xml"});
		
		AuthCardReqVo  rq = new AuthCardReqVo();
		
		AuthCardRepVo res = caller.call(rq, "infoAuthFacade", "authCardInfo");
		authStatu = res.getAuthStatus().getVaule();
		
	}
	

}
