package com.sunyu.bi.engine;


import com.boco.common.util.StringUtil;
import com.sunyu.bi.database.JdbcTemplate;
import com.sunyu.bi.model.DataSource;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 百度echarts图标工具 bar chart创建器
 */
public class EchartsBarChartBuilder {


    public static String build(List<Map<String,Object>> datas, List<EchartsSeriesConfig> seriesConfigs, String  xAxisField){
        StringBuilder builder = new StringBuilder();
        builder.append("<script>\n");
        builder.append("var myChart = echarts.init(document.getElementById('main'));\n");
        builder.append("var option = {\n");
        builder.append("    tooltip: {\n");
        builder.append("        trigger: 'axis'\n");
        builder.append("    },\n");
        builder.append("    legend: {\n");
        builder.append("        data: ").append(createLegendData(seriesConfigs));
        builder.append("    },\n");
        builder.append("    toolbox: {\n");
        builder.append("        show: true,\n");
        builder.append("        feature: {\n");
        builder.append("            magicType: {type: ['line', 'bar']},\n");
        builder.append("            restore: {},\n");
        builder.append("            saveAsImage: {}\n");
        builder.append("        }\n");
        builder.append("    },\n");
        builder.append("    xAxis: {\n");
        builder.append("        data:").append(createData(datas,xAxisField));
        builder.append("    },\n");
        builder.append("    yAxis: [\n");
        builder.append("        {\n");
        builder.append("            type: 'value',\n");
        builder.append("            axisLabel: {\n");
        builder.append("                formatter: '{value} 元'\n");
        builder.append("            }\n");
        builder.append("        },\n");
        builder.append("        {\n");
        builder.append("            type: 'value',\n");
        builder.append("            axisLabel: {\n");
        builder.append("                formatter: '{value} %'\n");
        builder.append("            }\n");
        builder.append("        }\n");
        builder.append("    ],\n");
        builder.append("    series: ").append(createSeries(datas,seriesConfigs));
        builder.append("};\n");
        builder.append("myChart.setOption(option);\n");
        builder.append("</script>");
        return builder.toString();
    }

    /**
     * 创建legend data
     * @param seriesConfigs
     * @return
     */
    public static String createLegendData(List<EchartsSeriesConfig> seriesConfigs){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int counter = 0;
        int configSize = seriesConfigs.size();
        for(EchartsSeriesConfig config:seriesConfigs){
            if(counter<configSize-1){
                builder.append("\"").append(config.getName()).append("\"").append(",");
            }else{
                builder.append("\"").append(config.getName()).append("\"");
            }
            counter ++;
        }
        builder.append("]\n");
        return builder.toString();
    }

    public static String createData(List<Map<String,Object>> datas,String  field){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Map<String,Object> map:datas){
            Object value =  map.get(field);

            if(value instanceof String){
                builder.append("\"").append(value).append("\"").append(",");
            }else {
                builder.append(value).append(",");
            }
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("]\n");
        return builder.toString();
    }

    public static String createSeries(List<Map<String,Object>> datas,List<EchartsSeriesConfig> seriesConfigs){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int counter = 0;
        int dataSize = datas.size();
        for (EchartsSeriesConfig config:seriesConfigs){
            builder.append("{\n");
            builder.append("        name:'").append(config.getName()).append("',\n");
            builder.append("        type:'").append(config.getType()).append("',\n");
            if(StringUtil.isNotEmpty(config.getyAxisIndex())){
                builder.append("        yAxisIndex:").append(1).append(",\n");
            }
            builder.append("        data: ").append(createData(datas,config.getDataField()));
            if(counter < dataSize-1){
                builder.append("    },");
            }else{
                builder.append("        },\n");
            }


            counter ++;
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("]\n");
        return builder.toString();
    }

    public static void main(String[] args) {
        EchartsSeriesConfig config1 = new EchartsSeriesConfig();
        config1.setName("机构人数");
        config1.setType("bar");
        config1.setDataField("renshu");

        EchartsSeriesConfig config2 = new EchartsSeriesConfig();
        config2.setName("机构人数2");
        config2.setType("bar");
        config2.setDataField("renshu");

        List<EchartsSeriesConfig> configList = new ArrayList<>();
        configList.add(config1);

        DataSource info = new DataSource();
        info.setDriver("com.mysql.cj.jdbc.Driver");
        info.setLinkUrl("jdbc:mysql://localhost:3306/edu?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        info.setLinkPwd("root");
        info.setLinkName("root");

        String sql = "SELECT org.`name`,COUNT(*) as renshu from org_student os LEFT JOIN t_organization  org on os.organization_id = org.id  GROUP BY organization_id";

        List<Map<String,Object>> list = JdbcTemplate.queryList(info,sql,null);

        String data = build(list,configList,"name");
        System.out.println(data);


    }
}
