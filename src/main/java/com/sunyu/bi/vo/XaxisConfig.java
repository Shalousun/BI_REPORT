package com.sunyu.bi.vo;

import java.io.Serializable;

public class XaxisConfig implements Serializable {

    private static final long serialVersionUID = 7097557654218944618L;
    private String colname;

    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }
}
