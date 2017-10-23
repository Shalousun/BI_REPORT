package com.sunyu.bi.engine;

import java.io.Serializable;


/**
 * echarts 图表series配置
 */
public class EchartsSeriesConfig implements Serializable {
    private static final long serialVersionUID = 2978042573225950275L;

    /**
     * series名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * y轴索引
     */
    private String yAxisIndex;

    /**
     * 对应的数据字段
     */
    private String dataField;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(String yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }
}
