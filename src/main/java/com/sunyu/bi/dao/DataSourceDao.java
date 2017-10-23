package com.sunyu.bi.dao;

import java.util.List;
import java.util.Map;

import com.sunyu.bi.model.DataSource;

/**
 *
 * @author yu
 * @date 2017-10-21 22:41:24
 *
 *
 */

public interface DataSourceDao {

	/**
	 * 保存数据
	 * @param entity
	 * @return
     */
	int save(DataSource entity);

    /**
     * 批量添加数据
     * @param entityList
     * @return
     */
	int batchSave(List<DataSource> entityList);

	/**
	 * 更新数据
	 * @param entity
	 * @return
     */
	int update(DataSource entity);

	/**
	 * 删除数据
	 * @param id
	 * @return
     */
	int delete(int id);

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
     */
	DataSource queryById(int id);

	/**
	 * 分页查询数据
	 * @return
     */
	List<DataSource> queryPage();
}