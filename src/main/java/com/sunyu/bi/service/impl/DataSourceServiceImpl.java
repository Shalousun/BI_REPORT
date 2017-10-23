package com.sunyu.bi.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.boco.common.model.CommonResult;
import com.sunyu.bi.model.DataSource;
import com.sunyu.bi.dao.DataSourceDao;
import com.sunyu.bi.service.DataSourceService;

/**
 *
 * @author yu
 * @date 2017-10-21 11:56:07
 *
 */
@Service("dataSourceService")
public class DataSourceServiceImpl  implements DataSourceService{

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(DataSourceService.class);

	@Resource
	private DataSourceDao dataSourceDao;

	@Override
	public CommonResult save(DataSource entity) {
		CommonResult result = new CommonResult();
        try {
        	dataSourceDao.save(entity);
        	result.setSuccess(true);
        } catch (Exception e) {
        	result.setMessage("添加数据失败");
        	logger.error("添加数据异常：",e);
        }
        return result;
	}

	@Override
	public CommonResult update(DataSource entity) {
		CommonResult result = new CommonResult();
        try {
            dataSourceDao.update(entity);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("修改数据失败");
            logger.error("修改数据异常：",e);
        }
        return result;
	}

	@Override
	public CommonResult delete(int id) {
		CommonResult result = new CommonResult();
        try {
            dataSourceDao.delete(id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("删除数据失败");
            logger.error("删除数据异常：",e);
        }
        return result;
	}



	@Override
	public CommonResult queryById(int id) {
	    CommonResult result = new CommonResult();
	    DataSource entity = dataSourceDao.queryById(id);
	    if (null != entity) {
        	result.setData(entity);//成功返回数据
        	result.setSuccess(true);
        } else {
        	result.setMessage("没有找到匹配数据");
        	logger.info("未查询到数据，编号：{}",id);
        }
        return result;
	}

	@Override
    public PageInfo queryPage(int offset, int limit) {
        PageHelper.offsetPage(offset,limit);
        List<DataSource> list = dataSourceDao.queryPage();
        return new PageInfo(list);
    }

}