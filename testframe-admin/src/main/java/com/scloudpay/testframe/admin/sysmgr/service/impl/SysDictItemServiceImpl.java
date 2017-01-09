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
import com.scloudpay.testframe.admin.sysmgr.DictCache;
import com.scloudpay.testframe.admin.sysmgr.dao.SysDictItemMapper;
import com.scloudpay.testframe.admin.sysmgr.dao.SysDictTypeMapper;
import com.scloudpay.testframe.admin.sysmgr.entity.SysDictItem;
import com.scloudpay.testframe.admin.sysmgr.entity.SysDictType;
import com.scloudpay.testframe.admin.sysmgr.service.ISysDictItemService;

/**
 * 字典项服务实现
 * 
 * @author TanDong
 * 
 */
@Service("dictItemService")
@Transactional(readOnly = true)
public class SysDictItemServiceImpl implements ISysDictItemService {

	private static Log logger = LogFactory.getLog(SysDictItemServiceImpl.class);

	@Autowired
	private SysDictItemMapper sysDictItemMapper;

	@Autowired
	private SysDictTypeMapper sysDictTypeMapper;

	static String DICT_CACHE_NAME = "DICT_CACHE";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #getItemName(java.lang.String, java.lang.String)
	 */
	public String getItemName(String typeCode, String itemCode)
			throws ApplicationException {
		String ret = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("typeCode", typeCode);
		try {
			ArrayList<SysDictItem> itemList = (ArrayList<SysDictItem>) sysDictItemMapper
					.queryByParams(params);
			for (SysDictItem item : itemList) {
				if (item.getItemCode().equals(itemCode)) {
					ret = item.getItemName();
				}
			}
			return ret;
		} catch (Exception e) {
			logger.error("分页查询字典项失败", e);
			throw new ApplicationException("error.dictitem.query");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #getDictItems(java.lang.String)
	 */
	public List<SysDictItem> getDictItems(String typeCode)
			throws ApplicationException {
		try {
			ArrayList<SysDictItem> items = null;
			if (null == items || items.size() == 0) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("typeCode", typeCode);
				items = (ArrayList<SysDictItem>) sysDictItemMapper
						.queryByParams(params);
			}
			return items;
		} catch (Exception e) {
			logger.error("分页查询字典项失败", e);
			throw new ApplicationException("error.dictitem.query");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #getAll()
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public DictCache getAll() throws ApplicationException {
		try {
			DictCache dictCache = null;

			List<SysDictType> dictTypes = sysDictTypeMapper.queryByParams(null);
			List<SysDictItem> dictItems = sysDictItemMapper.queryByParams(null);

			dictCache = new DictCache();
			dictCache.setDictTypes(dictTypes);
			dictCache.setDictItems(dictItems);
			return dictCache;
		} catch (Exception e) {
			logger.error("分页查询字典项失败", e);
			throw new ApplicationException("error.dictitem.query");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #saveSysDictItem
	 * (org.pbccrc.devplatform.component.dictionary.entity.SysDictItem)
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void saveSysDictItem(SysDictItem dictItem)
			throws ApplicationException {
		try {
			sysDictItemMapper.insertDictItem(dictItem);
		} catch (Exception e) {
			logger.error("添加字典项失败", e);
			throw new ApplicationException("error.dictitem.add");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #updateSysDictItem
	 * (org.pbccrc.devplatform.component.dictionary.entity.SysDictItem)
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void updateSysDictItem(SysDictItem dictItem)
			throws ApplicationException {
		try {
			sysDictItemMapper.updateDictItem(dictItem);
		} catch (Exception e) {
			logger.error("更新字典项失败", e);
			throw new ApplicationException("error.dictitem.update");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #delSysDictItem(long)
	 */
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void delSysDictItem(long id) throws ApplicationException {
		try {
			sysDictItemMapper.delDictItem(id);
		} catch (Exception e) {
			logger.error("删除典项失败", e);
			throw new ApplicationException("error.dictitem.delete");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.pbccrc.devplatform.component.dictionary.service.ISysDictItemService
	 * #getSysDictItem(long)
	 */
	public SysDictItem getSysDictItem(long id) throws ApplicationException {
		try {
			return sysDictItemMapper.getDictItemById(id);
		} catch (Exception e) {
			logger.error("获取字典项失败", e);
			throw new ApplicationException("error.dictItem.get");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuchengtech.ycp2pcommon.dict.service.ISysDictItemService#getItemClass
	 * (java.lang.String, java.lang.String)
	 */
	public String getItemClass(String typeCode, String itemCode)
			throws ApplicationException {
		try {
			SysDictItem item = sysDictItemMapper
					.getDictItem(typeCode, itemCode);
			return null == item ? "" : item.getClassName();
		} catch (Exception e) {
			logger.error("获取字典项失败", e);
			throw new ApplicationException("error.dictItem.get");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yuchengtech.ycp2pcommon.dict.service.ISysDictItemService#queryWithPage
	 * (java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
	 */
	public PageList<SysDictItem> queryWithPage(Map<String, Object> params,
			PageBounds pageBounds) throws ApplicationException {
		try {
			return sysDictItemMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("error.membermain.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.tandong.ssm.sysmgr.service.ISysDictItemService#getMap()
	 */
	public Map<String, Object> getMap() throws ApplicationException {
		try {
			Map<String, Object> dictCache = new HashMap<String, Object>();
			
//			RedisListTranscoder<SysDictItem> listTranscoder = new RedisListTranscoder<SysDictItem>();
//			
//			//从缓存中获取字典数据
//			byte[] dictCacheData = RedisUtil.getJedis().get(DICT_CACHE_NAME.getBytes());
//			
//			//如果缓存数据为空则从数据库中查询字典
//			if(null == dictCacheData || dictCacheData.length == 0){
				Map<String, Object> params = null;
				List<SysDictType> dictTypes = sysDictTypeMapper.queryByParams(null);
				for(SysDictType type : dictTypes){
					params = new HashMap<String, Object>();
					params.put("typeCode", type.getTypeCode());
					List<SysDictItem> dictItems = sysDictItemMapper.queryByParams(params);
					dictCache.put(type.getTypeCode(), dictItems);
				}
//				RedisUtil.getJedis().set(DICT_CACHE_NAME.getBytes(), listTranscoder.serialize(dictCache));
				dictCache.put("dictTypes", dictTypes);
				return dictCache;
//			}
//			return listTranscoder.deserialize(dictCacheData);
			
		} catch (Exception e) {
			logger.error("分页查询字典项失败", e);
			throw new ApplicationException("error.dictitem.query");
		}
	}

}
