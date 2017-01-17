package com.scloudpay.testframe.admin.conn.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.admin.conn.entity.DataSourceConnInfo;

public interface DataSourceConnMapper {
	
	public List<DataSourceConnInfo> selectAll() throws Exception;
	
	public PageList<DataSourceConnInfo> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
    int deleteByPrimaryKey(Long id);

    int insert(DataSourceConnInfo record);

    int insertSelective(DataSourceConnInfo record);

    DataSourceConnInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataSourceConnInfo record);

    int updateByPrimaryKey(DataSourceConnInfo record);
}