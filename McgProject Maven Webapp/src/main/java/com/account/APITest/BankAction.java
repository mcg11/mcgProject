package com.account.APITest;

import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macg11 on 2017/7/20.
 */
public class BankAction  extends BaseControllerWebAppContextSetupTest{
    // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(AddAccountTest.class);
    @Test
    public void rfrozenAccountTest() throws Exception {
        // json数据
        JSONObject jsonObjRfrozenAccount = new JSONObject();
        jsonObjRfrozenAccount.put("uid", "7d7cddd8-fc44-0059-943d-4ac0903ea7fc");
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjRfrozenAccount.toString(), key_ziroom);
        String encryption = (String) resultMap.get("encryption");
        if (encryption.equals("")) {
            logger.error((String) resultMap.get("error"));
            return;
        }

        // 打印传递的参数
        logger.info(encryption);

        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        //String refundUrl = "http://localhost:8080/account/rfrozenAccount.do";
        String refundUrl = "http://account.q.ziroom.com/bankAction/queryBankCardInfo.html";
//        String refundUrl = "http://10.30.26.46:8080/bankAction/queryBankCardInfo.do";
//        String refundUrl = "http://localhost:8083/account/bankAction/queryBankCardInfo.do";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);

        // + result.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void bindBankCard() throws Exception {

        // json数据
        JSONObject jsonObjRfrozenAccount = new JSONObject();
        jsonObjRfrozenAccount.put("uid", "1cd0de90-1b46-541c-8299-854a610e79c4");
        jsonObjRfrozenAccount.put("userName", "齐宁超");
        jsonObjRfrozenAccount.put("certificateNum", "62280119900812121X");
        jsonObjRfrozenAccount.put("bankCardNo", "6212260200113633974");
        jsonObjRfrozenAccount.put("mobile", "15810286826");
        jsonObjRfrozenAccount.put("bankCode", "102100099996");
        jsonObjRfrozenAccount.put("bankName", "工商银行");
        jsonObjRfrozenAccount.put("appIcon", "http:///dddd");
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjRfrozenAccount.toString(), key_ziroom);
        String encryption = (String) resultMap.get("encryption");
        if (encryption.equals("")) {
            logger.error((String) resultMap.get("error"));
            return;
        }

        // 打印传递的参数
        logger.info(encryption);

        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        //String refundUrl = "http://localhost:8080/account/rfrozenAccount.do";
        String refundUrl = "http://account.q.ziroom.com/bankAction/bindBankCard.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);

        // + result.andReturn().getResponse().getContentAsString());
    }
  @Test
    public void getUserBankCardAccount() throws Exception {

        // json数据
        JSONObject jsonObjRfrozenAccount = new JSONObject();
        jsonObjRfrozenAccount.put("uid", "49235a1f-8f41-4951-85dd-f9af324dc034");
        jsonObjRfrozenAccount.put("systemSource", "mbs");
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjRfrozenAccount.toString(), key_ziroom);
        String encryption = (String) resultMap.get("encryption");
        if (encryption.equals("")) {
            logger.error((String) resultMap.get("error"));
            return;
        }

        // 打印传递的参数
        logger.info(encryption);

        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        //String refundUrl = "http://localhost:8080/account/rfrozenAccount.do";
        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bankAccount/getUserBankCardAccount.do";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);

        // + result.andReturn().getResponse().getContentAsString());
    }

}
