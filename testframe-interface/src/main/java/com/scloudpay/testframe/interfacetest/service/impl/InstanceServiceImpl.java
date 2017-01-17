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
import com.scloudpay.testframe.interfacetest.dao.InterfaceInstanceMapper;
import com.scloudpay.testframe.interfacetest.entity.InterfaceInstance;
import com.scloudpay.testframe.interfacetest.service.IInstanceService;

@Service("instanceService")
@Transactional(readOnly = true)
public class InstanceServiceImpl implements IInstanceService {

	private static Log logger = LogFactory.getLog(InstanceServiceImpl.class);

	@Autowired
	private InterfaceInstanceMapper interfaceInstanceMapper;

	public List<InterfaceInstance> queryAll() throws ApplicationException {
		try {
			return interfaceInstanceMapper.queryAll();
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException("查询错误");
		}
	}

	public PageList<InterfaceInstance> queryWithPage(Map<String, Object> params, PageBounds pageBounds)
			throws ApplicationException {
		try {
			return interfaceInstanceMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException("查询错误");
		}
	}

	public void insert(InterfaceInstance record) throws ApplicationException {
		interfaceInstanceMapper.insert(record);
	}

	public void update(InterfaceInstance record) throws ApplicationException {
		interfaceInstanceMapper.updateByPrimaryKeySelective(record);
	}

	public void delete(long id) throws ApplicationException {
		interfaceInstanceMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Long> ids) throws ApplicationException {
		for(Long id : ids){
			interfaceInstanceMapper.deleteByPrimaryKey(id);
		}
	}

	public InterfaceInstance get(long id) throws ApplicationException {
		return interfaceInstanceMapper.selectByPrimaryKey(id);
	}
	
	
}
