package com.account.APITest;

import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by hehaifeng on 2017/7/11.
 */
public class WithdrawMoneyDetailTest extends BaseControllerWebAppContextSetupTest{

    // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(GetAWithdrawMoney.class);


    @Test
    public void createWithdrawCash() throws Exception {

        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("systemSource", "wz");
        jsonObjFrozenAccount.put("bankArea", "北京市");
        jsonObjFrozenAccount.put("applicationTime", "2018-03-20 09:42:10");
        jsonObjFrozenAccount.put("wmAmount", 1);
        jsonObjFrozenAccount.put("wmUid","94b347b7-9c5e-4be1-917f-9ae661720883");
        jsonObjFrozenAccount.put("bankCode",1106);
        jsonObjFrozenAccount.put("bankNum",  "6226680205237195");
        jsonObjFrozenAccount.put("bankName",   "中国光大银行");
        jsonObjFrozenAccount.put("wmName",  "马春格");
        jsonObjFrozenAccount.put("uniqueNo","1w5e3345794c63e438");

       // jsonObjFrozenAccount.put("pay_time", "2015-09-09 20:05:21");
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjFrozenAccount.toString(), key_ziroom);
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

        String refundUrl = "http://localhost:8083/account/withdrawMoney/createWithdrawCash.do";
//        String refundUrl = "http://account.q.ziroom.com/withdrawMoney/createWithdrawCash.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }
    @Test
    public void queryLineWithdrayLog() throws Exception {


        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("withdrawMoneyNo", "tx201707111501360001");
        jsonObjFrozenAccount.put("offset", 1);
        jsonObjFrozenAccount.put("pageSize", 100);
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjFrozenAccount.toString(), key_ziroom);
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

        String refundUrl = "http://localhost:8083/account/lineWithdrawMoney/queryLineWithdrayLog.do";
//        String refundUrl = "http://account.ziroom.com/frozenAccount.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }
    @Test
    public void queryLineWithdrayById() throws Exception {


        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("withdrawMoneyNo", "tx201706271612360001");
        // jsonObjFrozenAccount.put("pay_time", "2015-09-09 20:05:21");
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjFrozenAccount.toString(), key_ziroom);
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

        String refundUrl = "http://localhost:8080/account/lineWithdrawMoney/queryLineWithdrayById.do";
//        String refundUrl = "http://account.ziroom.com/frozenAccount.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }

    @Test
    public void updateWithdrawMoneyStatus() throws Exception {


        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("department", "payment-System");
        jsonObjFrozenAccount.put("operator", "system");
        jsonObjFrozenAccount.put("remitTime", "2017-07-27 16:10:03");
        jsonObjFrozenAccount.put("role", "system");
        jsonObjFrozenAccount.put("status", 1);
        jsonObjFrozenAccount.put("systemSource", "finance");
        jsonObjFrozenAccount.put("wmNo", "tx201707201906360001");
        // jsonObjFrozenAccount.put("pay_time", "2015-09-09 20:05:21");
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjFrozenAccount.toString(), key_ziroom);
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

        String refundUrl = "http://localhost:8083/account/withdrawMoney/updateWithdrawMoneyStatus.do";
//        String refundUrl = "http://account.ziroom.com/frozenAccount.html";
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
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("startAccountId", "116143444");
        jsonObjFrozenAccount.put("endAccountId", "116143445");
        // 加密
        Map<String, String> resultMap = EncryptionUtil.encryptionWay(
                jsonObjFrozenAccount.toString(), key_ziroom);
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

//        String refundUrl = "http://localhost:8083/account/bankAction/getFrozenAndBalance.do";
        String refundUrl = "http://account.q.ziroom.com/bankAction/getFrozenAndBalance.html";
//        String refundUrl = "http://account.ziroom.com/frozenAccount.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }

}
