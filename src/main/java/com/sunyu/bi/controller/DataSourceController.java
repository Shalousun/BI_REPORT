package com.sunyu.bi.controller;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageInfo;
import com.boco.common.model.CommonResult;
import com.sunyu.bi.model.DataSource;
import com.sunyu.bi.service.DataSourceService;

/**
 *
 * @author yu
 * @date 2017-10-21 11:56:07
 *
 */
@Controller
@RequestMapping("dataSource")
public class DataSourceController {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(DataSourceController.class);

	@Resource
	private DataSourceService dataSourceService;

	@ResponseBody
	@PostMapping(value = "/add")
	public CommonResult save(DataSource entity) {
		return dataSourceService.save(entity);
	}

	@ResponseBody
	@PostMapping(value = "/update")
	public CommonResult update(DataSource entity) {
		return dataSourceService.update(entity);
	}

	@ResponseBody
	@GetMapping(value = "/delete/{id}")
	public CommonResult delete(@PathVariable int id) {
		return dataSourceService.delete(id);
	}

	@ResponseBody
	@GetMapping(value = "/query/{id}")
	public CommonResult queryById(@PathVariable int id) {
		return dataSourceService.queryById(id);
	}

    @ResponseBody
    @GetMapping(value = "page/{offset}/{limit}")
    public PageInfo queryPage(@PathVariable int offset,@PathVariable int limit) {
        return dataSourceService.queryPage(offset,limit);
    }
}