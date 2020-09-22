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
        jsonObjAddAccount.put("uid", "9fd1d68e-09c8-98e2-43e4-efc24c5fa39b");
        jsonObjAddAccount.put("systemSource", "dz");
        // 账户充值业务类型
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
//        resultMap=new HashMap<String, String>();
//        resultMap.put("encryption","");
        String encryption1 = encryption.replace("/", "%2F");
        String encryption2 = encryption1.replace("+", "%2B");
        String encryption3 = encryption2.replace("=", "%3D");

        // System.out.println(encryption3);

        String refundUrl = "http://localhost:8083/account/withdrawMoney/getAllDetails.do";
//        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do";
//        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/lineWithdrawMoney/isHaveStopTX.do";
//        String refundUrl = "http://localhost:8083/account/lineWithdrawMoney/isHaveStopTX.do";

//        String refundUrl = "http://10.216.5.234:8081/ZRAccount/account/withdrawMoney/getAllDetails.do";
//        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/withdrawMoney/getAllDetails.do";
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
        jsonObjAddAccount.put("uid", "40396f31-2834-45b2-a423-ec9242232f14");
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

    @Test
    public void test(){
        String code1="MIIGJgYJKoZIhvcNAQcCoIIGFzCCBhMCAQExCzAJBgUrDgMCGgUAMIHIBgkqhkiG9w0BBwGggboEgbc4YTkwOGYwOTYzOTRiNzYyMDE2MzlhZDU4MmRhMDEzZV80YmQ4NzdhMS0zN2E1LTRkYTMtOGQzZS0xOWUxZDNiNzU1YjVfMV8zNjIzMjQxOTkwMDUzMDYwNTJfM19TYXQgTWF5IDI2IDAwOjAwOjAwIENTVCAyMDE4X1R1ZSBTZXAgMjUgMDA6MDA6MDAgQ1NUIDIwMThfOGE5MGEzYWI1N2U3MDU0YTAxNTdlNzQzYzM2ODA0N2WgggPgMIID3DCCAsSgAwIBAgIUQMy0IeBt4HWEm5npQCdm7f9HPZgwDQYJKoZIhvcNAQEFBQAwgZAxCzAJBgNVBAYTAkNOMTMwMQYDVQQKDCrljJfkuqzoh6rlpoLlj4vlrrbotYTkuqfnrqHnkIbmnInpmZDlhazlj7gxFTATBgNVBAsMDOaKgOacr";
        String code2="MIIGJgYJKoZIhvcNAQcCoIIGFzCCBhMCAQExCzAJBgUrDgMCGgUAMIHIBgkqhkiG9w0BBwGggboEgbc4YTkwOGYwOTYzOTRiNzYyMDE2MzlhZDU4MmRhMDEzZV80YmQ4NzdhMS0zN2E1LTRkYTMtOGQzZS0xOWUxZDNiNzU1YjVfMV8zNjIzMjQxOTkwMDUzMDYwNTJfM19TYXQgTWF5IDI2IDAwOjAwOjAwIENTVCAyMDE4X1R1ZSBTZXAgMjUgMDA6MDA6MDAgQ1NUIDIwMThfOGE5MGEzYWI1N2U3MDU0YTAxNTdlNzQzYzM2ODA0N2WgggPgMIID3DCCAsSgAwIBAgIUQMy0IeBt4HWEm5npQCdm7f9HPZgwDQYJKoZIhvcNAQEFBQAwgZAxCzAJBgNVBAYTAkNOMTMwMQYDVQQKDCrljJfkuqzoh6rlpoLlj4vlrrbotYTkuqfnrqHnkIbmnInpmZDlhazlj7gxFTATBgNVBAsMDOaKgOacr";

       if( code1.equals(code2)){
           logger.info("一样");
       }
    }
    @Test
    public void getAllDetailss() throws Exception {

        // 获取流水号
        String[] tradeNo = {"116f847e-be79-4250-9d2d-f1647e799cef",
                "1d76a8c3-784b-4836-85ae-599fb3b9d8e8",
                "1e053e3c-f6f6-40a3-aa0a-985f7d0f0c58",
                "240e0a97-2f23-41ee-a353-86d9648c77d9",
                "3f1a484b-f65c-59cc-befd-7c3f49e8ccdb",
                "506e7eab-048a-49d7-8684-2f9f80898fd4",
                "60229a76-4ded-441b-9905-7ad4222139d8",
                "65de5df1-4a28-47ab-a449-01845a31f2ff",
                "6c8506c7-54cd-42cb-9ac6-eb939900b701",
                "85752ff5-fb00-477a-87c9-a586c6a6c88b",
                "85b6c48e-7a83-4b44-8f1f-6bc26b09bab9",
                "873c2787-6e8b-4f62-9947-c018d332c036",
                "9786e5af-1626-4e87-b40e-a43e3d97f436",
                "9786e5af-1626-4e87-b40e-a43e3d97f436",
                "9786e5af-1626-4e87-b40e-a43e3d97f436",
                "9786e5af-1626-4e87-b40e-a43e3d97f436",
                "aca17170-21e9-4a1e-b8f1-0a007563097c",
                "afb0fa3d-f97f-4044-a6ca-5fa78a086aee",
                "b286bfba-30ce-ac37-5edf-3fc11b39df00",
                "e7f50c67-e8dc-4344-8b0e-6f2850975dfd",
                "f98f8850-c07f-4ea6-ac53-ad1c8e935dcc",
                "fa3fc81c-1fdb-45bd-bce0-8cfef78e8ca5",
                "fa3fc81c-1fdb-45bd-bce0-8cfef78e8ca5"};

        // json数据
        String[] bb=new String[100];
        Integer[] ss=new Integer[100];

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        for (int i=0;i<tradeNo.length;i++) {
            JSONObject jsonObjAddAccount = new JSONObject();
            jsonObjAddAccount.put("uid", tradeNo[i]);
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
            String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do";
            //        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/withdrawMoney/getAllDetails.do";
            String url = refundUrl + encryption3;
//            System.out.println(url);

            InputStream resultContentInputStream = NetUtil.sendPostRequest(
                    refundUrl, resultMap);

            String resultContent = NetUtil.getTextContent(resultContentInputStream,
                    "UTF-8");
            com.alibaba.fastjson.JSONObject object= com.alibaba.fastjson.JSONObject.parseObject(resultContent);
            String data=object.getString("data");
            com.alibaba.fastjson.JSONObject boj= com.alibaba.fastjson.JSONObject.parseObject(data);
            Integer balanct=boj.getInteger("balance");
            if(balanct>=0){
                Map<String,Object> map=new HashMap<String, Object>();

                map.put("uid",tradeNo[i]);
//                map.put("money",balanct);
                list.add(map);
                bb[i]=tradeNo[i]+"\n";
//                ss[i]=balanct;

            }

        }

        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(list));
        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(bb));
//        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(ss));


    }
    @Test
    public void getUidCityDetails() throws Exception {

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "4144fb10-6e91-44fc-ab50-548c2a8fcb2e");
        jsonObjAddAccount.put("systemSource", "dz");//
        jsonObjAddAccount.put("cityCode", "801000");//

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
        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/lineWithdrawMoney/getUidCityDetails.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }


    @Test
    public void cancel() throws Exception {

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("uid", "09627cf7-2c18-4213-9ed0-5a3e2d0900a8");

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

        String refundUrl = "http://localhost:8083/api/tool/checkCancel.do";
//        String refundUrl = "http://account.t.ziroom.com/ZRAccount/api/tool/checkCancel.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }
    @Test
    public void getByUniqueNum() throws Exception {

        // 获取流水号
        String tradeNo = "";

        // json数据
        JSONObject jsonObjAddAccount = new JSONObject();
        jsonObjAddAccount.put("unique_num", "dc2393ab-01af-7de9-dd3d-bef4f324c38e");
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


        String refundUrl = "http://localhost:8083/account/getByUniqueNum.do";
        String url = refundUrl + encryption3;
        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);


    }
}
