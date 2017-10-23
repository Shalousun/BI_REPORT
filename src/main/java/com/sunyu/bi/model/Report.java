package com.sunyu.bi.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * Table:
 * @author yu
 * @date 2017-10-21 22:41:24
 *
 */
public class Report implements Serializable {

    private static final long serialVersionUID = -6343063187016703904L;

   	private Integer id;
	//报表名称
	private String name;
	//使用数据源编号
	private Integer dataSetId;

	//getters and setters
   	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDataSetId() {
		return dataSetId;
	}

	public void setDataSetId(Integer dataSetId) {
		this.dataSetId = dataSetId;
	}


    @Override
    public String toString() {
        return "Report{" + 
                "id =" + id +
                ",name ='" + name + '\'' +
                ",dataSetId =" + dataSetId +
                '}';
    }
}