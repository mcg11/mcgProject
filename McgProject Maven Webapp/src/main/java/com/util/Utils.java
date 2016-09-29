package com.util;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	private static final List<String> IGNORE_FIELDS = Lists.newArrayList(
	            "id", "create_time", "last_modify_time"
	    );

	    /**
	     * 将json转化为对应的bean
	     *
	     * @param json  json字符串
	     * @param clazz bean的类型
	     * @param <T>   泛型
	     * @return clazz.newInstance()
	     */
	    public static <T> T parseJsonIntoPOJO(String json, Class<T> clazz) {
	        JSONObject jsonObject = JSONObject.parseObject(json);
	        T t = null;
	        try {
	            t = clazz.newInstance();
	            Field[] fields = clazz.getDeclaredFields();
	            for (Field f : fields) {
	                String fieldName = f.getName();
	                if (IGNORE_FIELDS.contains(fieldName)) {
	                    continue;
	                }
	                Object _obj = jsonObject.get(fieldName);
	                // apache的DateConverter转换String为Date时，发现是空值，即报出错误
	                // No value specified for Date
	                if (_obj != null) {
	                    BeanUtils.setProperty(t, fieldName, _obj);
	                }
	            }
	            return t;
	        } catch (Exception e) {
	            logger.info(e.getMessage(), e);
	        }

	        return t;
	    }

}
