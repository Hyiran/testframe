package com.scloudpay.testframe.admin.conn.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.admin.conn.entity.FTPConnInfo;

public interface FTPConnInfoMapper {
	
	public List<FTPConnInfo> selectAll() throws Exception;
	
	public PageList<FTPConnInfo> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
    int deleteByPrimaryKey(Long id);

    int insert(FTPConnInfo record);

    int insertSelective(FTPConnInfo record);

    FTPConnInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FTPConnInfo record);

    int updateByPrimaryKey(FTPConnInfo record);
}