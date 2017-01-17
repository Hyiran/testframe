package com.scloudpay.testframe.interfacetest.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.interfacetest.entity.InterfaceInstance;

public interface IInstanceService {
	
	public List<InterfaceInstance> queryAll() throws ApplicationException;

	public PageList<InterfaceInstance> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	public void insert(InterfaceInstance record) throws ApplicationException;
	
	public void update(InterfaceInstance record) throws ApplicationException;
	
	public void delete(long id) throws ApplicationException;
	
	public void deleteBatch(List<Long> ids) throws ApplicationException;
	
	public InterfaceInstance get(long id) throws ApplicationException;

}
