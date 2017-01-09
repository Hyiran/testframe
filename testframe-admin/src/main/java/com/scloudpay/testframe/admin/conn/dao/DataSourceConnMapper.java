package com.scloudpay.testframe.admin.conn.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.admin.conn.entity.DataSourceConn;

public interface DataSourceConnMapper {
	
	public List<DataSourceConn> selectAll() throws Exception;
	
	public PageList<DataSourceConn> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
    int deleteByPrimaryKey(Long id);

    int insert(DataSourceConn record);

    int insertSelective(DataSourceConn record);

    DataSourceConn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataSourceConn record);

    int updateByPrimaryKey(DataSourceConn record);
}