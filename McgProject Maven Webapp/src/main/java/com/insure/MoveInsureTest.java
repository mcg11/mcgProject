package com.insure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.util.HttpRequestClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macg11 on 2020/2/11.
 */
public class MoveInsureTest {

    @Test
    public void moveInsure() throws Exception {

        // json数据
        Map<String,Object> map = new HashMap<String, Object>();

        map.put("destinationAddress", "山西省运城市河北区大朗镇大朗村");
        map.put("destinationCounty", "河北区");
        map.put("destinationCity", "运城市");
        map.put("destinationProvince", "山西省");
        map.put("destinationCountyCode", "110000");
        map.put("destinationCityCode", "110010");
        map.put("destinationProvinceCode", "110114");
        map.put("consignorDate", "2020-03-18");
        map.put("vehicleLicenceCode", "BX2209");
        map.put("startPlaceAddress", "天津市和平区光明里");
        map.put("startPlaceCounty","和平区");
        map.put("startPlaceCity","天津市");
        map.put("startPlaceProvince","天津市");
        map.put("startPlaceCountyCode","110000");
        map.put("startPlaceCityCode","110010");
        map.put("startPlaceProvinceCode","110114");
        map.put("startDate","2020-07-02 00:00:00");
        map.put("mobile","153315555949");
        map.put("transType","1");
        map.put("transSerialNo","MOVE144288876861440");
        String aa= JSONObject.toJSONString(map);
        // 加密
//        String refundUrl = "http://insure.q.ziroom.com:8081/api/move/moveInsure";//本地
        String refundUrl = "http://insure.t.ziroom.com/api/move/moveInsure";
        String resultContent = HttpRequestClient.postRequest(refundUrl, map);
        System.out.println(resultContent);

    }
    @Test
    public void querymoveInsure() throws Exception {

        // json数据
        Map<String,Object> map = new HashMap<String, Object>();

        map.put("transSerialNo","ddd434dddd4d7d4d244");
        String aa= JSONObject.toJSONString(map);
        // 加密
        String refundUrl = "http://insure.t.ziroom.com/api/move/queryMoveInsure";//本地
//        String refundUrl = "http://insure.q.ziroom.com:8081/api/move/queryMoveInsure";
        String resultContent = HttpRequestClient.postRequest(refundUrl, map);
        System.out.println(resultContent);

    }
    @Test
    public void tuiBaoInsure() throws Exception {

        // json数据
        Map<String,Object> map = new HashMap<String, Object>();

        map.put("transSerialNo","ddd434dddd4d7d4d2443463441");
        map.put("surrenderDate","2020-06-15 16:00:00");
        String aa= JSONObject.toJSONString(map);
        // 加密
//        String refundUrl = "http://insure.t.ziroom.com/api/move/tuiBaoInsure";//本地
        String refundUrl = "http://insure.q.ziroom.com:8081/api/move/tuiBaoInsure";
        String resultContent = HttpRequestClient.postRequest(refundUrl, map);
        System.out.println(resultContent);

    }
}