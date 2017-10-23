package com.sunyu.bi.vo;



import com.sunyu.bi.engine.EchartsSeriesConfig;

import java.io.Serializable;
import java.util.List;

public class ConfigContent implements Serializable {

    private static final long serialVersionUID = -5966104765071339651L;
    private XaxisConfig xAxisCfg;
    private List<EchartsSeriesConfig> seriesCfg;

    public XaxisConfig getxAxisCfg() {
        return xAxisCfg;
    }

    public void setxAxisCfg(XaxisConfig xAxisCfg) {
        this.xAxisCfg = xAxisCfg;
    }

    public List<EchartsSeriesConfig> getSeriesCfg() {
        return seriesCfg;
    }

    public void setSeriesCfg(List<EchartsSeriesConfig> seriesCfg) {
        this.seriesCfg = seriesCfg;
    }
}
