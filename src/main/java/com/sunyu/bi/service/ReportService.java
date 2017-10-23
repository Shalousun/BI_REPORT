package com.sunyu.bi.service;

import com.boco.common.model.CommonResult;

/**
 *
 * @author yu
 * @date 2017-10-21 22:41:24
 *
 */

public interface ReportService {


	/**
	 * 根据报表编号获取渲染配置
	 * @param id
	 * @return
     */
	CommonResult queryById(int id);


}