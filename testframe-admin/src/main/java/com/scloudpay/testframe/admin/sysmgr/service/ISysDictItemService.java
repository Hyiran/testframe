package com.scloudpay.testframe.admin.sysmgr.service;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.scloudpay.testframe.admin.sysmgr.DictCache;
import com.scloudpay.testframe.admin.sysmgr.entity.SysDictItem;

/**
 * 
 * 字典项目服务接口
 * 
 * @author TanDong
 *
 */
public interface ISysDictItemService {
	
	/**
	 * 获取字典项名称
	 * @param typeCode 字典类型代码
	 * @param itemCode 字典项代码
	 * @return 字典项名称
	 * @throws ApplicationException
	 */
	public String getItemName(String typeCode, String itemCode) throws ApplicationException;
	
	/**
	 * 获取所有字典项
	 * @param typeCode 字典类型代码
	 * @return 字典项集合
	 * @throws ApplicationException
	 */
	public List<SysDictItem> getDictItems(String typeCode) throws ApplicationException;
	
	
	/**
	 * 获取所有字典数据（包含所有的字典类型和字典项）
	 * @return
	 * @throws ApplicationException
	 */
	public DictCache getAll() throws ApplicationException;
	
	public Map<String, Object> getMap() throws ApplicationException;
	
	
	/**
	 * 分页查询字典项
	 * @return
	 * @throws ApplicationException
	 */
	public PageList<SysDictItem> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	
	/**
	 * 增加字典项
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void saveSysDictItem(SysDictItem dictItem) throws ApplicationException;
	
	/**
	 * 更新字典项信息 
	 * @param dictType
	 * @throws ApplicationException
	 */
	public void updateSysDictItem(SysDictItem dictItem) throws ApplicationException;
	
	/**
	 * 删除字典项信息
	 * @param id 字典项ID
	 * @throws ApplicationException
	 */
	public void delSysDictItem(long id) throws ApplicationException;
	
	/**
	 * 根据ID获取字典项信息
	 * @param id 字典项ID
	 * @return
	 * @throws ApplicationException
	 */
	public SysDictItem getSysDictItem(long id) throws ApplicationException;

	/**
	 * 根据字典类型和值  获取class属性
	 * @param typeCode
	 * @param itemCode
	 * @return
	 * @throws ApplicationException
	 */
	public String getItemClass(String typeCode, String itemCode) throws ApplicationException;
}
