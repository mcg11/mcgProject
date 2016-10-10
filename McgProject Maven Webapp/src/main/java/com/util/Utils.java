package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	    
	    public List<Object> importExceltoList(String fileUrl) throws IOException{
	    	
	    	InputStream is = new FileInputStream(fileUrl);//fileUrl如：d:\\111.xlsx"
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
			int rowNum = xssfSheet.getLastRowNum();
			List<Object> list = new ArrayList<Object>();
			for(int i =1;i<=rowNum;i++){
				Object obj = null;
				XSSFRow xssfRow = xssfSheet.getRow(i);
				if (xssfRow != null) {
					for (int colNum = 0; colNum < xssfRow.getLastCellNum(); colNum++) {
						obj = getValue(xssfRow.getCell(colNum)).trim();
						list.add(obj);
					}
				}
			}
			return list;
	    }
	    public  String getValue(XSSFCell xssfRow) {
			if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
				return String.valueOf(xssfRow.getBooleanCellValue());
			} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
				DecimalFormat df = new DecimalFormat("0");  
			     String strCell = df.format(xssfRow.getNumericCellValue()); 
				return strCell;
			} else {
				return String.valueOf(xssfRow.getStringCellValue());
			}
		}
}
