/**
 * 
 */
package com.account.APITest;

import com.alibaba.fastjson.JSONObject;
import com.ziroom.common.util.DateUtil;
import com.ziroom.common.util.NetUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

/**
 * ClassName: AddAccountTest
 * 
 * @Description: 账户充值测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class AddAccountNewTest extends BaseControllerWebAppContextSetupTest {

    // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(AddAccountNewTest.class);
    /**
     * 账户充值Test
     *
     * @throws Exception
     */
    @Test
    public void addAccountTest() throws Exception {

        // 获取流水号
        String tradeNo = "";

        // json数据
        com.alibaba.fastjson.JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "94b347b7-9c5e-4be1-917f-9ae661720883");
        jsonObjAddAccount.put("biz_common", "finance_add_account");//
        // 账户充值业务类型
        // jsonObjAddAccount.put("description",
        // TESTFALG
        // +
        // " 账户充值");
        jsonObjAddAccount.put("description", "提现测试充值余额");
        jsonObjAddAccount.put("city_code", "801000");
        jsonObjAddAccount.put("sys_source", "finance");


        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> map=new HashMap<String, String>();
        map.put("trade_no","BJYD2018090400359_sub_1_WXAPP153679801000ces");
        map.put("total_free","59800");
        map.put("pay_type","zhzf");
//        map.put("bus_id","20180903001");
        list.add(map);

        jsonObjAddAccount.put("trade_no",list);
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjAddAccount.toString(), key_ziroom);
        String encryption = (String) resultMap.get("encryption");
        if (encryption.equals("")) {
            logger.error((String) resultMap.get("error"));
            return;
        }

        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        // System.out.println(encryption3);

//        String refundUrl = "http://localhost:8083/account/addAccount.do";
//		String refundUrl = "http://account.ziroom.com/addAccount.html";
        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/addAccountNew.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");

        System.out.println(resultContent);

    }

}
