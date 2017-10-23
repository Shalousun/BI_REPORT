package com.sunyu.bi.controller;


import org.springframework.stereotype.Controller;

/**
 *
 */
@Controller
public abstract class BaseController {


    /**
     * 该方法用于渲染beetl模板
     * @param viewName  视图名称
     * @return
     */
    protected String renderBeetl(String viewName){
        StringBuilder builder = new StringBuilder();
        builder.append("/template").append(viewName);
        return builder.toString();
    }

    /**
     * 该方法用于渲染传统的jsp
     * @param viewName 视图名称
     * @return
     */
    protected String renderJSP(String viewName){
        StringBuilder builder = new StringBuilder();
        builder.append("/jsp").append(viewName);
        return builder.toString();
    }
}
