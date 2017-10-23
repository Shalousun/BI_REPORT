package com.sunyu.bi.util;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExt implements WebRenderExt {

    static long version = System.currentTimeMillis();
    @Override
    public void modify(Template template, GroupTemplate arg1, HttpServletRequest req, HttpServletResponse resp) {
        String context = req.getContextPath();
        //js,css 的版本编号
        template.binding("ctx",context);
        template.binding("sysVersion",version);
    }
}
