package com.mcg.itext;

import java.util.List;
import java.util.Map;

/**
 * Created by macg11 on 2018/9/13.
 */
public class PDFTableDto {
    private String colNames;
    private String colFields;
    private List<Map<String, Object>> dataList;

    public String getColNames() {
        return colNames;
    }
    public void setColNames(String colNames) {
        this.colNames = colNames;
    }
    public String getColFields() {
        return colFields;
    }
    public void setColFields(String colFields) {
        this.colFields = colFields;
    }
    public List<Map<String, Object>> getDataList() {
        return dataList;
    }
    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }
}
