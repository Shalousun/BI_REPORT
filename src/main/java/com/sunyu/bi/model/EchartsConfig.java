package com.sunyu.bi.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * Table:
 * @author yu
 * @date 2017-10-21 22:41:24
 *
 */
public class EchartsConfig implements Serializable {

    private static final long serialVersionUID = -4761976287017149560L;

   	private Integer id;
	//名称
	private String name;
	private String configContent;
	//所属报表
	private Integer reportId;

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

	public String getConfigContent() {
		return configContent;
	}

	public void setConfigContent(String configContent) {
		this.configContent = configContent;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}


    @Override
    public String toString() {
        return "EchartsConfig{" + 
                "id =" + id +
                ",name ='" + name + '\'' +
                ",configContent ='" + configContent + '\'' +
                ",reportId =" + reportId +
                '}';
    }
}