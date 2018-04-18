package com.account.APITest;

import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by hehaifeng on 2017/7/10.
 */
public class getAllDetails  extends BaseControllerWebAppContextSetupTest{
    // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(FrozenAccountTest.class);

    @Test
    public void getAllDetails() throws Exception {

        // 获取流水号
        String tradeNo = "";

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "8098e4a0-5578-4d9a-b92b-f972daad51f6");
        jsonObjAddAccount.put("systemSource", "dz");
        // 账户充值业务类型
        // jsonObjAddAccount.put("description",
        // TESTFALG
        // +
        // " 账户充值");
//        jsonObjAddAccount.put("description", "addAccount");
//        jsonObjAddAccount.put("city_code", "801000");
//        jsonObjAddAccount.put("pay_type", "account");
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

        //String refundUrl = "http://localhost:8080/account/addAccount.do";
//        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do";
        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/withdrawMoney/getAllDetails.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }

    @Test
    public void getWithdrawCash() throws Exception {

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "b481df97-8c4e-4819-ac1b-fff265578935");
        jsonObjAddAccount.put("pageNo", "1");
        jsonObjAddAccount.put("pageSize", 200);
        jsonObjAddAccount.put("systemSource", "wz");//

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

        //String refundUrl = "http://localhost:8080/account/addAccount.do";
        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/withdrawMoney/getWithdrawCash.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }

    @Test
    public void getFrozenAndBalance() throws Exception {

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("startAccountId", "1");
        jsonObjAddAccount.put("endAccountId", "100");

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

        //String refundUrl = "http://localhost:8080/account/addAccount.do";
        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/bankAction/getFrozenAndBalance.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }


}
