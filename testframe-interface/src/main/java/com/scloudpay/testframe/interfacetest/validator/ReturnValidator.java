/**
 * <b>项目名：</b>微支付<br/>
 * <b>包名：</b>com.scloudpay.testframe.interfacetest.validator<br/>
 * <b>文件名：</b>ReturnValidator.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2017年1月5日-下午5:51:22<br/>
 * <b>Copyright (c)</b> 2017 9FBank.com 玖富公司-版权所有<br/>
 *
 */
package com.scloudpay.testframe.interfacetest.validator;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.scloudpay.testframe.interfacetest.bean.ValidatorMessage;

/**
 *
 * ReturnValidator 返回值校验器
 * 
 * @author TanDong 2017年1月5日 下午5:51:22
 * 
 * @version 1.0.0
 *
 */
public class ReturnValidator implements Validator {

	private long id;

	private String name;

	// statu=1&amount=100&bank_rtn_code=10000
	private String expression;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	/* (non-Javadoc)
	 * @see com.scloudpay.testframe.interfacetest.validator.Validator#validate(java.lang.String)
	 */
	public ValidatorMessage validate(String returnJson) {

		ValidatorMessage vmsg = new ValidatorMessage();

		// 将校验的表达式String转换成Map，属性名=属性值形式
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isBlank(expression)) {
			vmsg.setResult(0);
			vmsg.setMessage("表达式错误");
			return vmsg;
		}
		String[] params = expression.split("&");
		for (int i = 0; i < params.length; i++) {
			String[] p = params[i].split("=");
			if (p.length == 2) {
				map.put(p[0], p[1]);
			}
		}

		// 将返回对象转换成Map，属性名=属性值形式
		Map<String, String> mapTarget = JSON.parseObject(returnJson, Map.class);
		
		StringBuffer retMsg = new StringBuffer();
        for(Map.Entry<String, String> entry1:map.entrySet()){
            String m1value = entry1.getValue() == null?"":entry1.getValue();
            String m2value = mapTarget.get(entry1.getKey())==null?"":String.valueOf(mapTarget.get(entry1.getKey()));
            if (!m1value.equals(m2value)) {
            	retMsg.append("属性："+entry1.getKey()+"的值校验失败,错误值："+m2value+"，正确值应为："+m1value+"<br/>");
            }
        }
        if(retMsg.toString().length() > 0){
        	vmsg.setResult(0);
        	vmsg.setMessage("校验失败，校验结果：<br/>" + retMsg.toString());
        }else{
        	vmsg.setResult(1);
        	vmsg.setMessage("校验成功，返回值：<br/>" + map.toString());
        }
        
		return vmsg;
	}
}
