/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest<br/>
 * <b>文件名：</b>JMEDubboAction.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午1:07:35<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.interfacetest;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.examples.bean.RequestBean;
import com.scloudpay.testframe.examples.bean.ResponseBean;

/**
 *
 * DubboCaller Dubbo接口调用器 
 * 
 * @author TanDong 2017年1月5日 下午1:07:35
 * 
 * @version 1.0.0
 *
 */
public class DubboCaller<S,R> {
	
	Logger logger = LoggerFactory.getLogger(DubboCaller.class);
	
	ClassPathXmlApplicationContext context;
	
	/**
	 * init(Dubbo接口调用器初始化，加载Dubbo消费者配置文件，启动上线文context)<br/>
	 * @param dubboConsumerResources
	 * void
	 * @exception
	 * @since  1.0.0
	*/
	public void init(String[] dubboConsumerResources){
		context = new ClassPathXmlApplicationContext( dubboConsumerResources );
		context.start();
	}
	
	/**
	 * call(调用Dubbo接口)<br/>
	 * @param requestParams
	 * @param interfaceName
	 * @param methodName
	 * @return
	 * @throws ApplicationException
	 * ResponseBean
	 * @exception
	 * @since  1.0.0
	*/
	public R call(S requestParams, String interfaceName, String methodName) throws ApplicationException{
		Object dubboService = context.getBean(interfaceName);
		Class<?> herosClass = dubboService.getClass();
		
		R response = null;
    	try {
    		Method m1 = herosClass.getMethod(methodName, RequestBean.class);
    		response = (R)m1.invoke(dubboService,requestParams);
		} catch (Exception e) {
			logger.error("Dubbo接口调用错误:", e);
			throw new ApplicationException("error_interface_dubbo_caller","Dubbo接口调用错误");
		}
    	return response;
	}
	
	public static void main(String[] args) {
		DubboCaller<RequestBean, ResponseBean> caller = new DubboCaller<RequestBean, ResponseBean>();
		caller.init(new String[]{"dubbo-consumer.xml"});
		
		RequestBean rq = new RequestBean();
		rq.setCardNo("6225880135053925");
		rq.setOrderNo("test_order_no_2017010500001");
		
		ResponseBean res = caller.call(rq, "demoService", "dk");
		System.out.println(res.getStatu()== 1?"调用成功":"调用失败");
		System.out.println("返回订单号："+res.getOrderNo());
	}

}
