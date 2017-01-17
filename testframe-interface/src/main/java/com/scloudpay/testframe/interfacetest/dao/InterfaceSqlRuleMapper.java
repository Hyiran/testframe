package com.scloudpay.testframe.interfacetest.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.interfacetest.entity.InterfaceSqlRule;

public interface InterfaceSqlRuleMapper {
	
	public List<InterfaceSqlRule> queryAll() throws Exception;

	public PageList<InterfaceSqlRule> queryWithPage(Map<String, Object> params, PageBounds pageBounds)
			throws Exception;

	
    int deleteByPrimaryKey(Long id);

    int insert(InterfaceSqlRule record);

    int insertSelective(InterfaceSqlRule record);

    InterfaceSqlRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InterfaceSqlRule record);

    int updateByPrimaryKey(InterfaceSqlRule record);
}