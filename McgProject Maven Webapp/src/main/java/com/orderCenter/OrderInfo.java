package com.orderCenter;

import com.account.APITest.EncryptionUtil;
import com.util.HttpUtil;
import com.ziroom.common.util.JdUtil.GsonUtils;
import com.ziroom.common.util.NetUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macg11 on 2017/12/16.
 */
public class OrderInfo {
    @Test
    public void createOrder() throws Exception {

        // json数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sysCode", "100003");
        map.put("bizType", "1");
        map.put("parentBizType", "1");
        map.put("bizCode", "111111");
        map.put("parentBizCode", "22222");
        map.put("orderName", "洗衣机使用订单");
        map.put("orderDesc", "洗衣机使用订单的订单");
        map.put("orderSource", "crm");
        map.put("orderType", 1);
        map.put("cityCode", "801000");
        map.put("feeType", 1);
        map.put("orderAddress", "北京市朝阳区");
        map.put("inContractCode", "123445");
        map.put("outContractCode", "3443222");
        map.put("uid", "ewrewerwrewe");
        map.put("userName","小明");
        map.put("userPhone", "158999999999");
        map.put("orderMoney", 100);
        map.put("orderExpirTime", "2017-09-09 22:33:30");
        map.put("orderRole", "角色");
        map.put("discountTYpe", 1);
        map.put("discountMoney", 10);
        map.put("periods", 1);
        map.put("callbackUrl", "http://paycenter.ziroom.com");
        map.put("orderDetailUrl", "http://order.ziroom.com");
        Map<String,String> details=new HashMap<String, String>();
        details.put("deviceName","电冰箱");
        details.put("deviceCode","3333");
        details.put("serviceStartTime","2017-09-09 22:33:3");
        details.put("serviceEndTime","2017-09-09 22:33:3");

        map.put("detail", com.alibaba.fastjson.JSON.toJSON(details));

        Map<String,String> billList=new HashMap<String, String>();
        List< Map<String,String>> billLists=new ArrayList<Map<String, String>>();
        billList.put("isContract","1");
        billList.put("documentType","2");
        billList.put("costCode","sf");
        billLists.add(billList);

        map.put("billList", com.alibaba.fastjson.JSON.toJSON(billLists));


        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        // 加密



        String refundUrl = "http://localhost:8081/api/order/createOrder.do";
//        String refundUrl = "http://account.q.ziroom.com/bankAction/bindBankCard.html";

        String resultContent = HttpUtil.postJson(refundUrl, GsonUtils.toJson(map));

//        String resultContentInputStream = NetUtil.sendPostReqByJsonParam(
//                com.alibaba.fastjson.JSON.toJSONString(map),refundUrl);

//        String resultContent = NetUtil.getTextContent(resultContentInputStream,
//                "UTF-8");
        System.out.println(resultContent);

        // + result.andReturn().getResponse().getContentAsString());
    }
}
