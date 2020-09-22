package com.account.APITest;

import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

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
        jsonObjFrozenAccount.put("applicationTime", "2020-07-20 09:42:10");
        jsonObjFrozenAccount.put("wmAmount", 1);
        jsonObjFrozenAccount.put("wmUid","b481df97-8c4e-4819-ac1b-fff265578935");
        jsonObjFrozenAccount.put("bankCode",1100);
        jsonObjFrozenAccount.put("bankNum",  "62148301143004281");
        jsonObjFrozenAccount.put("bankName",   "招商银行股份有限公司");
        jsonObjFrozenAccount.put("wmName",  "张志琼");
        jsonObjFrozenAccount.put("uniqueNo","1ww3cee712564eb3374882da8f");

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
        jsonObjFrozenAccount.put("status", 2);
        jsonObjFrozenAccount.put("systemSource", "finance");
        jsonObjFrozenAccount.put("wmNo", "txn20200609000848647");
         jsonObjFrozenAccount.put("remark", "打款失败");
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
//        String refundUrl = "http://account.q.ziroom.com/withdrawMoney/updateWithdrawMoneyStatus.html";
//        String refundUrl = "http://account.ziroom.com/frozenAccount.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);
        TreeMap<String,String> trrr=new TreeMap<String, String>();

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
//        String refndUrl = "http://account.q.ziroom.com/bankAction/getFrozenAndBalance.html";
        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/lineWithdrawMoney/isHaveStopTX.do    ";
//        String refundUrl = "http://account.t.ziroom.com/account/lineWithdrawMoney/isHaveStopTX.do    ";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }

}
