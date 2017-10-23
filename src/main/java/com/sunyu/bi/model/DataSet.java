package com.sunyu.bi.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * Table:
 * @author yu
 * @date 2017-10-21 22:41:23
 *
 */
public class DataSet implements Serializable {

    private static final long serialVersionUID = -6570770946569133366L;

   	private Integer id;
	//数据集名称
	private String name;
	//使用的数据源
	private Integer dataSourceId;
	//数据集对应查查询sql
	private String querySql;

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

	public Integer getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(Integer dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}


    @Override
    public String toString() {
        return "DataSet{" + 
                "id =" + id +
                ",name ='" + name + '\'' +
                ",dataSourceId =" + dataSourceId +
                ",querySql ='" + querySql + '\'' +
                '}';
    }
}