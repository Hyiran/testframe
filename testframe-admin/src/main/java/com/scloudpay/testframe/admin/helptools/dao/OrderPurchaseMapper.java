package com.scloudpay.testframe.admin.helptools.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.admin.helptools.mode.ReconData;

public interface OrderPurchaseMapper {
	
    int delOrderPurchase(long id) throws Exception;

    int insertOrderPurchase(ReconData record) throws Exception;

    ReconData getOrderPurchaseById(long id) throws Exception;

    int updateOrderPurchase(ReconData record) throws Exception;
    
	/**
	 * 分页条件查询OrderPurchase
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<ReconData> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
}