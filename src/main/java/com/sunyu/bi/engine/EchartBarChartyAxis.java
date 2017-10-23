package com.sunyu.bi.engine;

/**
 * @author sunyu
 * @date 2017-10-22 21:56:55
 */
public class EchartBarChartyAxis {

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    /**
     * 最小值
     */
    private String min;

    /**
     * 最大值
     */
    private String  max;

    /**
     * 位置，主要值为：right,left
     */
    private String position;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
