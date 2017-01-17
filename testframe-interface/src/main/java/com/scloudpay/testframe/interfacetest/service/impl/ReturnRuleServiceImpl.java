package com.scloudpay.testframe.interfacetest.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.interfacetest.dao.InterfaceReturnRuleMapper;
import com.scloudpay.testframe.interfacetest.entity.InterfaceReturnRule;
import com.scloudpay.testframe.interfacetest.service.IReturnRuleService;

@Service("returnRuleService")
@Transactional(readOnly = true)
public class ReturnRuleServiceImpl implements IReturnRuleService {

	private static Log logger = LogFactory.getLog(ReturnRuleServiceImpl.class);

	@Autowired
	private InterfaceReturnRuleMapper interfaceReturnRuleMapper;

	public List<InterfaceReturnRule> queryAll() throws ApplicationException {
		try {
			return interfaceReturnRuleMapper.queryAll();
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException("查询错误");
		}
	}

	public PageList<InterfaceReturnRule> queryWithPage(Map<String, Object> params, PageBounds pageBounds)
			throws ApplicationException {
		try {
			return interfaceReturnRuleMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException("查询错误");
		}
	}

	public void insert(InterfaceReturnRule record) throws ApplicationException {
		interfaceReturnRuleMapper.insert(record);
	}

	public void update(InterfaceReturnRule record) throws ApplicationException {
		interfaceReturnRuleMapper.updateByPrimaryKeySelective(record);
	}

	public void delete(long id) throws ApplicationException {
		interfaceReturnRuleMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Long> ids) throws ApplicationException {
		for(Long id : ids){
			interfaceReturnRuleMapper.deleteByPrimaryKey(id);
		}
	}

	public InterfaceReturnRule get(long id) throws ApplicationException {
		return interfaceReturnRuleMapper.selectByPrimaryKey(id);
	}
	
	
}
