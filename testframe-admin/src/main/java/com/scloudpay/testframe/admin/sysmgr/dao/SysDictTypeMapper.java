package com.scloudpay.testframe.admin.sysmgr.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.admin.sysmgr.entity.SysDictType;

/**
 * 字典类型数据访问接口
 * 
 * @author TanDong
 * 
 */
public interface SysDictTypeMapper extends BaseMapper {
	
	public PageList<SysDictType> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据ID获取字典类型
	 * @param id 字典类型ID
	 * @return
	 * @throws Exception
	 */
	public SysDictType getDictTypeById(long id) throws Exception;
	
	/**
	 * 根据查询条件查询所有字典类型
	 * @param params 查询条件参数
	 * @return
	 * @throws Exception
	 */
	public List<SysDictType> queryByParams(Map<String, Object> params) throws Exception;

	/**
	 * 插入字典类型
	 * @param dictType
	 * @return
	 * @throws Exception
	 */
	public Long insertDictType(SysDictType dictType) throws Exception;

	/**
	 * 修改字典类型
	 * @param dictType
	 * @return
	 * @throws Exception
	 */
	public Long updateDictType(SysDictType dictType) throws Exception;

	/**
	 * 删除字典类型
	 * @param id
	 * @throws Exception
	 */
	public void delDictType(Long id) throws Exception;

}
