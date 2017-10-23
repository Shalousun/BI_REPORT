package com.sunyu.bi.convert;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * spring 时间自动转换器
 * @author sunyu  on 2016/12/29.
 *
 */
public class DateConverter implements Converter<String, Timestamp> {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(DateConverter.class);

    private static final List<String> formarts = new ArrayList<>(4);

    static {
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }

    /**
     * 时间自动转换
     * @param source
     * @return
     */
    @Override
    public Timestamp convert(String source) {
        if ("".equals(source) || null == source) {
            return null;
        }
        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return parseTimestamp(source, formarts.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseTimestamp(source, formarts.get(1));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return parseTimestamp(source, formarts.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseTimestamp(source, formarts.get(3));
        } else {
            logger.error("输入的日期格式错误，接收的值为：{}",source);
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
    }

    /**
     * 功能描述：格式化成时间戳
     *
     * @param date
     *          String 字符型日期
     * @param format
     *          String 时间格式
     * @return
     */
    public Timestamp parseTimestamp(String date, String format) {
        Timestamp time = null;
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            time = new Timestamp(df.parse(date).getTime());
        } catch (Exception e) {

        }
        return time;
    }
}
