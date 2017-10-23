package com.sunyu.bi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boco.common.model.CommonResult;
import com.boco.common.util.StringUtil;
import com.sunyu.bi.dao.DataSetDao;
import com.sunyu.bi.dao.DataSourceDao;
import com.sunyu.bi.dao.EchartsConfigDao;
import com.sunyu.bi.dao.ReportDao;
import com.sunyu.bi.database.JdbcTemplate;
import com.sunyu.bi.engine.EchartsBarChartBuilder;
import com.sunyu.bi.engine.EchartsSeriesConfig;
import com.sunyu.bi.model.DataSet;
import com.sunyu.bi.model.DataSource;
import com.sunyu.bi.model.EchartsConfig;
import com.sunyu.bi.model.Report;
import com.sunyu.bi.service.ReportService;
import com.sunyu.bi.vo.ConfigContent;
import com.sunyu.bi.vo.XaxisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yu
 * @date 2017-10-21 22:41:24
 *
 */
@Service("reportService")
public class ReportServiceImpl  implements ReportService{

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ReportService.class);

	@Resource
	private ReportDao reportDao;

	@Resource
    private DataSetDao dataSetDao;


	@Resource
    private DataSourceDao dataSourceDao;

	@Resource
	private EchartsConfigDao echartsConfigDao;


	@Override
	public CommonResult queryById(int id) {
	    CommonResult result = new CommonResult();
	    Report entity = reportDao.queryById(id);
	    if (null != entity) {
	        int dataSetId = entity.getDataSetId();
            DataSet dataSet = dataSetDao.queryById(dataSetId);
            if(null == dataSet){
                result.setMessage("未查询到该报表配置的数据源");
                return result;
            }

            int dataSourceId = dataSet.getDataSourceId();
        	DataSource dataSource = dataSourceDao.queryById(dataSourceId);
        	if(null == dataSource){
        	    result.setMessage("该报表对应的数据源未查询到");
        	    return result;
            }
            String sql = dataSet.getQuerySql();
            List<Map<String,Object>> data = JdbcTemplate.queryList(dataSource,sql,null);

			EchartsConfig echartsConfig = echartsConfigDao.queryById(id);
			if(null == echartsConfig){
				result.setMessage("您请求的报表为查询到相关的chart配置");
				return result;
			}
			String configContent = echartsConfig.getConfigContent();
			if(StringUtil.isEmpty(configContent)){
				result.setMessage("您请求的报表为查询到相关的chart配置不正确");
				return result;
			}
			try{
				ConfigContent content = JSONObject.parseObject(configContent,ConfigContent.class);
			    XaxisConfig xAxisConfig = content.getxAxisCfg();
				String colName = xAxisConfig.getColname();
				if(StringUtil.isEmpty(colName)){
					result.setMessage("您请求的报表为查询到相关的chart配置不正确,解析发生错误");
					return result;
				}
				List<EchartsSeriesConfig> seriesConfigList = content.getSeriesCfg();
				String chart = EchartsBarChartBuilder.build(data,seriesConfigList,colName);
				result.setData(chart);
				result.setSuccess(true);
			}catch (Exception e){
				logger.error("您请求的报表为查询到相关的chart配置不正确,解析发生错误:",e);
				result.setMessage("您请求的报表为查询到相关的chart配置不正确,解析发生错误");
			}
        } else {
        	result.setMessage("您查询的报表被狗叼走了！");
        	logger.info("未查询到该报表：{}",id);
        }
        return result;
	}

}