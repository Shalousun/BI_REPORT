package com.sunyu.bi.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * Table:
 * @author yu
 * @date 2017-10-21 22:41:24
 *
 */
public class DataSource implements Serializable {

    private static final long serialVersionUID = -7613591587297448966L;

   	private Integer id;
	private String uuid;
	//数据库名称
	private String linkType;
	//数据库登录名
	private String linkName;
	//数据库连接密码
	private String linkPwd;
	//数据源名称
	private String dsname;
	//数据类型
	private String use;
	//数据库连接url
	private String linkUrl;
	//数据库驱动名称
	private String driver;

	//getters and setters
   	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkPwd() {
		return linkPwd;
	}

	public void setLinkPwd(String linkPwd) {
		this.linkPwd = linkPwd;
	}

	public String getDsname() {
		return dsname;
	}

	public void setDsname(String dsname) {
		this.dsname = dsname;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}


    @Override
    public String toString() {
        return "DataSource{" + 
                "id =" + id +
                ",uuid ='" + uuid + '\'' +
                ",linkType ='" + linkType + '\'' +
                ",linkName ='" + linkName + '\'' +
                ",linkPwd ='" + linkPwd + '\'' +
                ",dsname ='" + dsname + '\'' +
                ",use ='" + use + '\'' +
                ",linkUrl ='" + linkUrl + '\'' +
                ",driver ='" + driver + '\'' +
                '}';
    }
}