package com.scloudpay.testframe.interfacetest.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.interfacetest.entity.InterfaceReturnRule;

public interface IReturnRuleService {
	
	public List<InterfaceReturnRule> queryAll() throws ApplicationException;

	public PageList<InterfaceReturnRule> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	public void insert(InterfaceReturnRule record) throws ApplicationException;
	
	public void update(InterfaceReturnRule record) throws ApplicationException;
	
	public void delete(long id) throws ApplicationException;
	
	public void deleteBatch(List<Long> ids) throws ApplicationException;
	
	public InterfaceReturnRule get(long id) throws ApplicationException;

}
