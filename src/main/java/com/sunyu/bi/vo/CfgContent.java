package com.sunyu.bi.vo;

import java.io.Serializable;

public class CfgContent implements Serializable {

    private static final long serialVersionUID = -1226427298988533019L;
    private XaxisConfig xAxisCfg;

    public XaxisConfig getxAxisCfg() {
        return xAxisCfg;
    }

    public void setxAxisCfg(XaxisConfig xAxisCfg) {
        this.xAxisCfg = xAxisCfg;
    }
}
