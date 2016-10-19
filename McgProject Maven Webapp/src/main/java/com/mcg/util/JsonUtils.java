package com.mcg.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.util.Utils;

public class JsonUtils {
	   private static final Logger logger = LoggerFactory.getLogger(Utils.class);
		private static final List<String> IGNORE_FIELDS = Lists.newArrayList(
		            "id", "create_time", "last_modify_time"
		    );

		    /**
		     * 将json转化为对应的bean
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
		    
		    /**
			 * 将json转化为Map格式
			 * @param jsonStr json格式
			 * @return
			 * @since 1.0.0
			 */
			public static Map<String, Object> parseJSON2Map(String jsonStr){
				
					if(logger.isDebugEnabled()){
						logger.debug("传过来的String字符串json值为："+jsonStr);
					}
				
			        Map<String, Object> map = new HashMap<String, Object>();
			        
			        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(jsonStr);
			        for(Object k : json.keySet()){
			            Object v = json.get(k); 
			            
			            if(v instanceof JSONArray){
			                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			                @SuppressWarnings("unchecked")
							Iterator<JSONObject> it = ((JSONArray)v).iterator();
			                while(it.hasNext()){
			                    JSONObject json2 = it.next();
			                    list.add(parseJSON2Map(json2.toString()));
			                }
			                map.put(k.toString(), list);
			            } else {
			                map.put(k.toString(), v);
			            }
			        }
			        return map;
			    }
}
