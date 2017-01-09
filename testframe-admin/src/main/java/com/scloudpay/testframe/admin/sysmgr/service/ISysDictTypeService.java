package com.scloudpay.testframe.admin.sysmgr.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.sysmgr.entity.SysDictType;
import com.scloudpay.testframe.admin.sysmgr.web.TreeNode;

/**
 * 字典类型服务接口
 * 
 * @author TanDong
 *
 */
public interface ISysDictTypeService {
	
	public List<TreeNode> getDictTypeTree() throws ApplicationException;
	
	/**
	 * 分页查询字典类型信息
	 * @param pageInfo
	 * @return
	 */
	public PageList<SysDictType> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 增加字典类型
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveSysDictType(SysDictType dictType) throws ApplicationException;
	
	/**
	 * 更新字典类型信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateSysDictType(SysDictType dictType) throws ApplicationException;
	
	/**
	 * 删除字典类型信息
	 * @param id 字典类型ID
	 * @throws ApplicationException
	 */
	public void delSysDictType(long id) throws ApplicationException;
	
	/**
	 * 根据ID获取字典类型信息
	 * @param id 字典类型ID
	 * @return
	 * @throws ApplicationException
	 */
	public SysDictType getSysDictType(long id) throws ApplicationException;

}
