package com.sunyu.bi.service;

import com.github.pagehelper.PageInfo;
import com.boco.common.model.CommonResult;
import com.sunyu.bi.model.DataSource;

/**
 *
 * @author yu
 * @date 2017-10-21 11:56:07
 *
 */

public interface DataSourceService {

	/**
	 * 保存数据
	 * @param entity
	 * @return
     */
	CommonResult save(DataSource entity);

	/**
	 * 修改数据
	 * @param entity
	 * @return
     */
	CommonResult update(DataSource entity);

	/**
	 * 删除数据
	 * @param id
	 * @return
     */
	CommonResult delete(int id);

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
     */
	CommonResult queryById(int id);

	/**
     * 分页查询
     * @param offset 偏移量
     * @param limit 每页大小
     * @return
     */
    PageInfo queryPage(int offset, int limit);
}