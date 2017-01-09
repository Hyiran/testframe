package com.scloudpay.testframe.admin.sysmgr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.scloudpay.testframe.admin.sysmgr.dao.SysDictTypeMapper;
import com.scloudpay.testframe.admin.sysmgr.entity.SysDictType;
import com.scloudpay.testframe.admin.sysmgr.service.ISysDictTypeService;
import com.scloudpay.testframe.admin.sysmgr.web.TreeNode;

/**
 * 字典类型服务实现
 * 
 * @author TanDong
 *
 */
@Service("dictTypeService")
@Transactional(readOnly = true)
public class SysDictTypeServiceImpl implements ISysDictTypeService {

	private static Log logger = LogFactory.getLog(SysDictTypeServiceImpl.class);
	
	@Autowired
	private SysDictTypeMapper sysDictTypeMapper;
	
	public PageList<SysDictType> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException {
		try{
			return sysDictTypeMapper.queryWithPage(params, pageBounds);
		}catch(Exception e){
			logger.error("分页查询字典类型失败", e);
			throw new ApplicationException("error.dict.query");
		}
	}

	/* (non-Javadoc)
	 * @see org.pbccrc.devplatform.component.dictionary.service.ISysDictTypeService#saveSysDictType(javax.servlet.http.HttpSession, org.pbccrc.devplatform.component.dictionary.entity.SysDictType)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveSysDictType(SysDictType dictType) throws ApplicationException {
		try{
			sysDictTypeMapper.insertDictType(dictType);
		}catch(Exception e){
			logger.error("添加字典类型失败", e);
			throw new ApplicationException("error.dict.add");
		}
	}

	/* (non-Javadoc)
	 * @see org.pbccrc.devplatform.component.dictionary.service.ISysDictTypeService#updateSysDictType(org.pbccrc.devplatform.component.dictionary.entity.SysDictType)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateSysDictType(SysDictType dictType)
			throws ApplicationException {
		try{
			sysDictTypeMapper.updateDictType(dictType);
		}catch(Exception e){
			logger.error("更新字典类型失败", e);
			throw new ApplicationException("error.dict.update");
		}
	}

	/* (non-Javadoc)
	 * @see org.pbccrc.devplatform.component.dictionary.service.ISysDictTypeService#delSysDictType(long)
	 */
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysDictType(long id) throws ApplicationException {
		try{
			sysDictTypeMapper.delDictType(id);
		}catch(Exception e){
			logger.error("删除字典类型失败", e);
			throw new ApplicationException("error.dict.delete");
		}
	}

	/* (non-Javadoc)
	 * @see org.pbccrc.devplatform.component.dictionary.service.ISysDictTypeService#getSysDictType(long)
	 */
	public SysDictType getSysDictType(long id) throws ApplicationException {
		try{
			return sysDictTypeMapper.getDictTypeById(id);
		}catch(Exception e){
			logger.error("获取字典类型失败", e);
			throw new ApplicationException("error.dict.get");
		}
	}

	/* 
	 * 获取字典类型树形结构数据
	 * @see com.tandong.ssm.sysmgr.service.ISysDictTypeService#getDictTypeTree()
	 */
	public List<TreeNode> getDictTypeTree() throws ApplicationException {
		
		List<TreeNode> ret = new ArrayList<TreeNode>();
		
		Map<String, Object> bizParams = new HashMap<String, Object>();
		bizParams.put("typeKind", 2);
		List<SysDictType> bizDictTypes = null;
		try {
			bizDictTypes = sysDictTypeMapper.queryByParams(bizParams);
		} catch (Exception e) {
			logger.error("查询字典类型失败", e);
			throw new ApplicationException("error.dict.query");
		}
		List<TreeNode> bizDictNodes = new ArrayList<TreeNode>();
		for(SysDictType type : bizDictTypes){
			TreeNode itemNode = new TreeNode();
			itemNode.setId(String.valueOf(type.getId()));
			itemNode.setText(type.getTypeName());
			itemNode.setExtValue1(type.getTypeCode());
			itemNode.setExtValue2(String.valueOf(type.getTypeKind()));
			itemNode.setExtValue3(type.getRemark());
			bizDictNodes.add(itemNode);
		}
		
		Map<String, Object> sysParams = new HashMap<String, Object>();
		sysParams.put("typeKind", 1);
		List<SysDictType> sysDictTypes = null;
		try {
			sysDictTypes = sysDictTypeMapper.queryByParams(sysParams);
		} catch (Exception e) {
			logger.error("查询字典类型失败", e);
			throw new ApplicationException("error.dict.query");
		}
		List<TreeNode> sysDictItems = new ArrayList<TreeNode>();
		for(SysDictType type : sysDictTypes){
			TreeNode itemNode = new TreeNode();
			itemNode.setId(String.valueOf(type.getId()));
			itemNode.setText(type.getTypeName());
			itemNode.setExtValue1(type.getTypeCode());
			itemNode.setExtValue2(String.valueOf(type.getTypeKind()));
			itemNode.setExtValue3(type.getRemark());
			sysDictItems.add(itemNode);
		}
		
		TreeNode bizDictType = new TreeNode();
		bizDictType.setId("bizDict");
		bizDictType.setText("业务字典");
		bizDictType.setState("open");
		bizDictType.setExtValue2("2");//2代表业务字典
		bizDictType.setChildren(bizDictNodes);
		
		TreeNode sysDictType = new TreeNode();
		sysDictType.setId("bizDict");
		sysDictType.setText("系统字典");
		sysDictType.setExtValue2("1");//1代表系统字典
		sysDictType.setState("open");
		sysDictType.setChildren(sysDictItems);
		
		ret.add(bizDictType);
		ret.add(sysDictType);
		
		return ret;
	}

	
}
