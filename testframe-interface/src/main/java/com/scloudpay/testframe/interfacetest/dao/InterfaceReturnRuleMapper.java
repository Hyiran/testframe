package com.scloudpay.testframe.interfacetest.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.interfacetest.entity.InterfaceReturnRule;

public interface InterfaceReturnRuleMapper {
	
	public List<InterfaceReturnRule> queryAll() throws Exception;
	
	public PageList<InterfaceReturnRule> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
    int deleteByPrimaryKey(Long id);

    int insert(InterfaceReturnRule record);

    int insertSelective(InterfaceReturnRule record);

    InterfaceReturnRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InterfaceReturnRule record);

    int updateByPrimaryKey(InterfaceReturnRule record);
}