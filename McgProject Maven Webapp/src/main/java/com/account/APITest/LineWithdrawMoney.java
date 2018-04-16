package com.account.APITest;

import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.content.image.png;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hehaifeng on 2017/7/11.
 */
public class LineWithdrawMoney extends BaseControllerWebAppContextSetupTest implements Runnable{

        public  void run() {
            {
                JSONObject jsonObjFrozenAccount = new JSONObject();
                jsonObjFrozenAccount.put("amount", "1");
                List<String> attch=new ArrayList<String>();
                attch.add("www.baidu.com");
                jsonObjFrozenAccount.put("attachmentUrl", attch);
                jsonObjFrozenAccount.put("cityCode", "801000");
                jsonObjFrozenAccount.put("contractNo", "BJZYCW81709163562");
                jsonObjFrozenAccount.put("contractPartyType", "1");
                jsonObjFrozenAccount.put("department","部门");
                jsonObjFrozenAccount.put("operator","张志琼");
                jsonObjFrozenAccount.put("operatorEmail","zhangzq95@ziroom.com");
                jsonObjFrozenAccount.put("receivableBank","301290000007");
                jsonObjFrozenAccount.put("receivableBankArea","交通银行");
                jsonObjFrozenAccount.put("receivableBankName","交通银行");
                jsonObjFrozenAccount.put("receivableBankNum","6222600910069651436");
                jsonObjFrozenAccount.put("receivableMobile","13810352846");
                jsonObjFrozenAccount.put("receivableName","张志琼");
                jsonObjFrozenAccount.put("receivableNum","420621199009058668");
                jsonObjFrozenAccount.put("receivableNumType",1);
                jsonObjFrozenAccount.put("sigingPhone","13810352846");
                jsonObjFrozenAccount.put("signingNum","420621199009058668");
                jsonObjFrozenAccount.put("signingTheme","张志琼");
                jsonObjFrozenAccount.put("signingType",2);
                jsonObjFrozenAccount.put("supplyReason","333d");
                jsonObjFrozenAccount.put("systemNo","20248068");
                jsonObjFrozenAccount.put("systemSource","33");
                jsonObjFrozenAccount.put("type",3);
                jsonObjFrozenAccount.put("uid","580bcd13-3701-8691-97dd-94ec320fdbc1");
                jsonObjFrozenAccount.put("withdrawReason","2");
                logger.info("uuuuuu");


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

                String refundUrl = "http://localhost:8083/account/lineWithdrawMoney/applyLineWithdrayMoney.do";
//        String refundUrl = "http://account.t.ziroom.com/lineWithdrawMoney/applyLineWithdrayMoney.html";
                String url = refundUrl + encryption3;

                System.out.println(url);
                try {
                    InputStream resultContentInputStream = NetUtil.sendPostRequest(
                            refundUrl, resultMap);

                    String resultContent = NetUtil.getTextContent(resultContentInputStream,
                            "UTF-8");
                    System.out.println("返回结果为:" + resultContent);
                }catch (Exception e){
                    e.printStackTrace();

                }
            }
    }

        // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(GetAWithdrawMoney.class);
    @Test
    public void applyLineWithdrayMoney() throws Exception {

        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("amount", "1");
        List<String> attch=new ArrayList<String>();
        attch.add("www.baidu.com");
        jsonObjFrozenAccount.put("attachmentUrl", attch);
        jsonObjFrozenAccount.put("cityCode", "120000");
        jsonObjFrozenAccount.put("contractNo", "BJZYCW81709163562");
        jsonObjFrozenAccount.put("contractPartyType", "1");
        jsonObjFrozenAccount.put("department","部门");
        jsonObjFrozenAccount.put("operator","张志琼");
        jsonObjFrozenAccount.put("operatorEmail","zhangzq95@ziroom.com");
        jsonObjFrozenAccount.put("receivableBank","301290000007");
        jsonObjFrozenAccount.put("receivableBankArea","交通银行");
        jsonObjFrozenAccount.put("receivableBankName","交通银行");
        jsonObjFrozenAccount.put("receivableBankNum","6222600910069651436");
        jsonObjFrozenAccount.put("receivableMobile","13810352846");
        jsonObjFrozenAccount.put("receivableName","张志琼");
        jsonObjFrozenAccount.put("receivableNum","420621199009058668");
        jsonObjFrozenAccount.put("receivableNumType",1);
        jsonObjFrozenAccount.put("sigingPhone","13810352846");
        jsonObjFrozenAccount.put("signingNum","420621199009058668");
        jsonObjFrozenAccount.put("signingTheme","张志琼");
        jsonObjFrozenAccount.put("signingType",2);
        jsonObjFrozenAccount.put("supplyReason","333d");
        jsonObjFrozenAccount.put("systemNo","20248068");
        jsonObjFrozenAccount.put("systemSource","33");
        jsonObjFrozenAccount.put("type",3);
        jsonObjFrozenAccount.put("uid","32d25b82-3861-550f-7942-4a9005731da3");
        jsonObjFrozenAccount.put("withdrawReason","2");



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

//        String refundUrl = "http://localhost:8083/account/lineWithdrawMoney/applyLineWithdrayMoney.do";
        String refundUrl = "http://account.t.ziroom.com/lineWithdrawMoney/applyLineWithdrayMoney.html";
        String url = refundUrl + encryption3;

        System.out.println(url);

            InputStream resultContentInputStream = NetUtil.sendPostRequest(
                    refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println("返回结果为:"+resultContent);

    }


    public static void main(String arg[]){
        LineWithdrawMoney dw = new LineWithdrawMoney();
        Thread t = new Thread(dw);
        Thread t2 = new Thread(dw);
        Thread t3 = new Thread(dw);


        t.start();
        t2.start();
        t3.start();
    }
    @Test
    public void queryLineWithdrayMoney() throws Exception {


        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("systemNo", "");
        jsonObjFrozenAccount.put("withdrawMoneyNo", "");
        jsonObjFrozenAccount.put("contractNo", "");
        jsonObjFrozenAccount.put("operator", "");
         jsonObjFrozenAccount.put("receivableNum","");
        jsonObjFrozenAccount.put("receivableName","");
        jsonObjFrozenAccount.put("receivableNumType",  1);
        jsonObjFrozenAccount.put("contractPartyType",   null);
        jsonObjFrozenAccount.put("signingNum",  "");
        jsonObjFrozenAccount.put("signingType",null);
        jsonObjFrozenAccount.put("withdrawMoneyStatus",  null);
        jsonObjFrozenAccount.put("paymentFormStatus",  null);

        jsonObjFrozenAccount.put("comfirmStatus",  null);
        jsonObjFrozenAccount.put("signingTheme",  "");


        jsonObjFrozenAccount.put("offset", 1);
        jsonObjFrozenAccount.put("pageSize", 100);
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

//        String refundUrl = "http://localhost:8080/account/lineWithdrawMoney/queryLineWithdrayMoney.do";
        String refundUrl = "http://account.t.ziroom.com/lineWithdrawMoney/queryLineWithdrayMoney.html";
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

        String refundUrl = "http://localhost:8080/account/lineWithdrawMoney/queryLineWithdrayLog.do";
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
    public void updatePaymentStatus() throws Exception {
        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("department", "payment-System");
        jsonObjFrozenAccount.put("operator", "system");
        jsonObjFrozenAccount.put("remitTime", "Fri Jul 21 18:04:06 CST 2017");
        jsonObjFrozenAccount.put("role", "system");
        jsonObjFrozenAccount.put("status",1);
        jsonObjFrozenAccount.put("systemNo","");
        jsonObjFrozenAccount.put("systemSource",  "finance");
        jsonObjFrozenAccount.put("wmNo",   "tx201707211752470001");

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

//        String refundUrl = "http://localhost:8080/ZRAccount/withdrawMoney/createWithdrawCash.html";
        String refundUrl = "http://localhost:8083/account/lineWithdrawMoney/updatePaymentStatus.do";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }
    @Test
    public void isHaveStopTX() throws Exception {
        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
//        jsonObjFrozenAccount.put("department", "payment-System");

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

//        String refundUrl = "http://localhost:8080/ZRAccount/withdrawMoney/createWithdrawCash.html";
//        String refundUrl = "http://localhost:8083/account/lineWithdrawMoney/isHaveStopTX.do";
        String refundUrl = "http://account.t.ziroom.com/lineWithdrawMoney/isHaveStopTX.html";

        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }

    @Test
    public void getUidCityDetails() throws Exception {
        // json数据
        JSONObject jsonObjFrozenAccount = new JSONObject();
        jsonObjFrozenAccount.put("uid", "db609bbc-f04e-4653-b47b-84db8376f148");
        jsonObjFrozenAccount.put("systemSource", "dz");
        jsonObjFrozenAccount.put("cityCode", "801000");

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

        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/lineWithdrawMoney/getUidCityDetails.do";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }
}
