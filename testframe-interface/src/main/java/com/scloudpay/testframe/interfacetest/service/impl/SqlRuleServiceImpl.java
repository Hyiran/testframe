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
import com.scloudpay.testframe.interfacetest.dao.InterfaceSqlRuleMapper;
import com.scloudpay.testframe.interfacetest.entity.InterfaceSqlRule;
import com.scloudpay.testframe.interfacetest.service.ISqlRuleService;

@Service("sqlRuleService")
@Transactional(readOnly = true)
public class SqlRuleServiceImpl implements ISqlRuleService {

	private static Log logger = LogFactory.getLog(SqlRuleServiceImpl.class);

	@Autowired
	private InterfaceSqlRuleMapper interfaceSqlRuleMapper;

	public List<InterfaceSqlRule> queryAll() throws ApplicationException {
		try {
			return interfaceSqlRuleMapper.queryAll();
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException("查询错误");
		}
	}

	public PageList<InterfaceSqlRule> queryWithPage(Map<String, Object> params, PageBounds pageBounds)
			throws ApplicationException {
		try {
			return interfaceSqlRuleMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException("查询错误");
		}
	}

	public void insert(InterfaceSqlRule record) throws ApplicationException {
		interfaceSqlRuleMapper.insert(record);
	}

	public void update(InterfaceSqlRule record) throws ApplicationException {
		interfaceSqlRuleMapper.updateByPrimaryKeySelective(record);
	}

	public void delete(long id) throws ApplicationException {
		interfaceSqlRuleMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Long> ids) throws ApplicationException {
		for(Long id : ids){
			interfaceSqlRuleMapper.deleteByPrimaryKey(id);
		}
	}

	public InterfaceSqlRule get(long id) throws ApplicationException {
		return interfaceSqlRuleMapper.selectByPrimaryKey(id);
	}
	
	
}
