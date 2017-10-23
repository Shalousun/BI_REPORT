package com.sunyu.bi.controller;

import com.boco.common.model.CommonResult;
import com.sunyu.bi.database.DataSourceInfo;
import com.sunyu.bi.database.JdbcTemplate;
import com.sunyu.bi.engine.EchartsBarChartBuilder;
import com.sunyu.bi.engine.EchartsSeriesConfig;
import com.sunyu.bi.model.DataSource;
import com.sunyu.bi.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ReportViewController extends BaseController {

    @Resource
    private ReportService reportService;
    @GetMapping(value = "/ReportView/{id}")
    public String index(ModelMap map, @PathVariable int id) {
        CommonResult result = reportService.queryById(id);
        map.put("result",result);
        return this.renderBeetl("/index");
    }

    @GetMapping(value = "/index")
    public String toIndex(){
        return this.renderJSP("/index");
    }
}
