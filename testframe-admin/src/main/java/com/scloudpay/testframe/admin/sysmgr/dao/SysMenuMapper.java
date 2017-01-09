package com.scloudpay.testframe.admin.sysmgr.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.scloudpay.testframe.admin.sysmgr.entity.SysMenu;

/**
 * 菜单数据访问接口
 * 
 * @author TanDong
 * 
 */
public interface SysMenuMapper extends BaseMapper {

	/**
	 * 分页条件查询菜单
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<SysMenu> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据查询参数获取所有菜单
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<SysMenu> queryByParams(Map<String, Object> params) throws Exception;

	/**
	 * 根据ID获取菜单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysMenu getSysMenuById(long id) throws Exception;
	
	/**
	 * 插入菜单
	 * @param sysMenu
	 * @return
	 * @throws Exception
	 */
	public Long insertSysMenu(SysMenu sysMenu) throws Exception;

	/**
	 * 修改菜单
	 * @param sysMenu
	 * @return
	 * @throws Exception
	 */
	public Long updateSysMenu(SysMenu sysMenu) throws Exception;

	/**
	 * 删除菜单
	 * @param id
	 * @throws Exception
	 */
	public void delSysMenu(Long id) throws Exception;

}
