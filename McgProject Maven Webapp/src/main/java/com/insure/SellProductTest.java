package com.insure;

import com.alibaba.fastjson.JSON;
import com.util.HttpRequestClient;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macg11 on 2020/2/11.
 */
public class SellProductTest {

    @Test
    public void syncOrder() throws Exception {
            // json数据
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> maps = new HashMap<String, Object>();

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        map.put("identifyCode", "1");
        map.put("uid", "aaaaaaaaaaaa");
        map.put("mobile", "15321998188");
        map.put("orderNo", "BJW1591180633233433");
        map.put("applicantName", "小明");
        map.put("applicantNum", "372988199902023456");
        map.put("orderAmount", 300);
        map.put("orderStatus",1);
        list.add(map);
        maps.put("jsonData",JSON.toJSONString(list));
            // 加密
        String refundUrl = "https://qinsure.ziroom.com/api/sell/syncOrder";//本地
//        String refundUrl = "http://insure.q.ziroom.com:8081/api/sell/syncOrder";
        String resultContent = HttpRequestClient.postRequest(refundUrl, maps);
        System.out.println(resultContent);

    }
    @Test
    public void syncInsure() throws Exception {
        // json数据
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> maps = new HashMap<String, Object>();

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        map.put("productId", "20200305");
        map.put("uid", "d57b1851-9407-4f90-bab5-fff11d4ea58c");
        map.put("productName", null);
        map.put("mobile", "BJW15911806");
        map.put("applicantName", "？");
        map.put("applicantNum", "372988199902023456");
        map.put("orderNo", "BJW15911806");
        map.put("policyAmount", "300");
        map.put("policyNo", 33333);
        map.put("policyUrl", "http://www.baidu.com");
        map.put("buyDate","2020-02-02 00:02:00");
        map.put("startDate", "2020-02-02 00:02:00");
        map.put("endDate","2020-02-02 00:02:00");
        list.add(map);
        maps.put("jsonData",JSON.toJSONString(list));
        // 加密
//        String refundUrl = "http://insure.t.ziroom.com/api/sell/syncInsure";//本地
        String refundUrl = "http://qinsure.ziroom.com/api/sell/syncInsure";
        String resultContent = HttpRequestClient.postRequest(refundUrl, maps);
        System.out.println(resultContent);

    }
    @Test
    public void surrenderInsure() throws Exception {
        // json数据


        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> maps = new HashMap<String, Object>();

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        map.put("productId", "01001");
        map.put("policyNo", "HK25N146012000000177");
//        map.put("productName", "15321998188");
        map.put("surrenderAmount", "555");
        map.put("surrenderDate","2020-02-02 00:02:00");
        list.add(map);
        maps.put("jsonData",JSON.toJSONString(list));
        // 加密
//        String refundUrl = "http://insure.t.ziroom.com:8081/api/report/addReport";//本地
        String refundUrl = "http://insure.q.ziroom.com:8081/api/sell/surrenderInsure";
        String resultContent = HttpRequestClient.postRequest(refundUrl, maps);
        System.out.println(resultContent);

    }
    @Test
    public void updateOrderStatus() throws Exception {
        // json数据
//        Map<String,Object> map = new HashMap<String, Object>();
//
//        map.put("orderNo", "BJW15911806");
//        map.put("orderStatus", "2");

        // json数据
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> maps = new HashMap<String, Object>();

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        map.put("orderNo", "BJW159118063");
        map.put("orderStatus", "2");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("orderNo", "20200228000066");
        map.put("orderStatus", "1");
        list.add(map);
        maps.put("jsonData",JSON.toJSONString(list));

        // 加密
//        String refundUrl = "http://insure.t.ziroom.com:8081/api/report/addReport";//本地
        String refundUrl = "http://insure.q.ziroom.com:8081/api/sell/updateOrderStatus";
        String resultContent = HttpRequestClient.postRequest(refundUrl, maps);
        System.out.println(resultContent);

    }

    @Test
    public void queryMyPolicy() throws Exception {
        // json数据
        Map<String,Object> map = new HashMap<String, Object>();

        map.put("uid", "d57b1851-9407-4f90-bab5-fff11d4ea58c");
        // 加密
//        String refundUrl = "http://insure.t.ziroom.com:8081/api/report/addReport";//本地
        String refundUrl = "http://insure-in.ziroom.com/api/sell/queryMyPolicy";
//        String refundUrl = "http://insure.t.ziroom.com/api/sell/queryMyPolicy";
        String resultContent = HttpRequestClient.postRequest(refundUrl, map);
        System.out.println(resultContent);

    }
    @Test
    public void selectAllProduct() throws Exception {
        // json数据
        Map<String,Object> map = new HashMap<String, Object>();

        map.put("uid", "d57b1851-9407-4f90-bab5-fff11d4ea58c");
        // 加密
//        String refundUrl = "http://insure.t.ziroom.com:8081/api/report/addReport";//本地
        String refundUrl = "http://insure.q.ziroom.com/api/sell/selectAllProduct";
//        String refundUrl = "http://insure.q.ziroom.com:8081/api/sell/selectAllProduct";
        String resultContent = HttpRequestClient.postRequest(refundUrl, map);
        System.out.println(resultContent);

    }

}