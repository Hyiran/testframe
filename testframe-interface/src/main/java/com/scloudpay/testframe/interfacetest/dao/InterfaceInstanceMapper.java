package com.scloudpay.testframe.interfacetest.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.interfacetest.entity.InterfaceInstance;

public interface InterfaceInstanceMapper {

	public List<InterfaceInstance> queryAll() throws Exception;

	public PageList<InterfaceInstance> queryWithPage(Map<String, Object> params, PageBounds pageBounds)
			throws Exception;

	int deleteByPrimaryKey(Long id);

	int insert(InterfaceInstance record);

	int insertSelective(InterfaceInstance record);

	InterfaceInstance selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(InterfaceInstance record);

	int updateByPrimaryKey(InterfaceInstance record);
}