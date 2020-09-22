package com.jpayment;

import com.account.APITest.RfrozenAccountTest;
import com.ziroom.common.util.CryptAES;
import com.ziroom.common.util.DesBase64Tool;
import com.ziroom.common.util.JdUtil.GsonUtils;
import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.account.APITest.EncryptionUtil.encryptionWay;

/**
 * Created by macg11 on 2017/7/17.
 */
public class WhiteTipQryActionTest {
    private final static transient Log logger = LogFactory
            .getLog(WhiteTipQryActionTest.class);

    @Test
    public void testOrderQry() throws Exception {

        //json数据
        JSONObject jsonObjJDPay = new JSONObject();
        String cityCode = "100001";

        jsonObjJDPay.put("cityCode", cityCode);
        try {
            //加密
            Map<String, String> resultMap = encryptionWay(jsonObjJDPay.toString(), "8w091ql5l2tt6qxj");
            String encryption = (String) resultMap.get("encryption");
            if (encryption.equals("")) {
                logger.error((String) resultMap.get("error"));
                return;
            }
//            String url = "http://localhost:8080/whiteRefundAccountInfo.do";
            String url = "http://jpayment.ziroom.com/ZRPaysPlatform/whiteRefundAccountInfo.do";


            Map<String, String> param = new HashMap<String, String>();
            param.put("encryption", encryption);

            InputStream resultContentInputStream = NetUtil.sendPostRequest(url, param);
            String resultContent = NetUtil.getTextContent(resultContentInputStream, "UTF-8");

            logger.info(resultContent);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void tttt()throws Exception{
        String a="J4240q+WyUIDX+/vwSJVerxn5G1Ft7xLF6WyW3zyDDw6eQ5y3R5AX/rNvXBKf61T2bIPCZkKGCGpB/v33t07/3oEtNeQyc7krNBeScBlrM3XAESyQ/OCoFwefOn9UclXtBPCrrnpjvOMN/I4B3RAQD8p9Rb800+O6ZUGyReBsEUmzJK9PLMBE4JSg68OUPn8UR9hrWlipsBX7iWwoRfR/8vkO3ulYyKan1E9kT+X0Idbei4rEz1jQlFUXYMH46WJMkTKvbEVeuInw4weAYZDENaCQQ9bSofFn06+0Kq2OHL1siJU3i9y64Z+kv42A/o+TvoS8Y0qC0YqPcDlYynI1IgEqHxvJA/6Ln4eo9uB0H5l9mbWIxfUq8NgJNPOEpoBH/3cyENNlALn7/6WmuLwPXYjr8RG5QEuYElaC3UYLzC2/GkfPOeGwpOEqsibjkgC4nyNhcPOavCLtBHPw9Cw4Y4zHEB5vUEKzabgGaoAnKtbhRYUkRzJXIlTkmUW7k+TIs2EL662guXgoX0hVb8M/jJN/UkcMU+uJCRUhJJUmf2q+8GB+8ldVveCKwzD4ra3O3uZCj5Xlf+HlpB/Zn+LM+vcac+3LkU5dyuTyjtHvq/NemyFnPDka7gOvkB/MqCd8zCdoG/SPnEonwHHOV+vRO5ExlZcPHdxwzKx6mvEZp8Wd7LiTBa3xWeax6zmTR3mgtElI3jVfbwNcLK+RBRYCejS7+6NtVKKhg1Dx8NF+BrMgY8uUzzPXLbXHEBwdJyb9TNuOpoe+X3/OtJo49YaCx+G//0f6jrSTAAvJyNCNFyKVvXsd+o+EAGBj18bUoOL5HgqgDEF6WjNw4wvgsRHxy+fC1k4RaX6UHuXemcGZqX3JJV2ZLODR/CYLGS+l2YYcArOMlTptaHRDuKamoHxJzzEHdwiT81tYCGZ1w0yRmUwEDTDEdoGR24K0ft/1JEPdO37G58ZZjKXM8X/jnb3yD6G/zsizzGOh0+EU0CFHvEkZbymOJB5CbQLav9mhnd4ybZO6CppnAKp/BKLUyc1sbA3/+VNHTIpGerIAxJlfUY=";
        //String result = DesBase64Tool.desDecrypt(a, "8w091ql5l2tt6qxj3z0emh21");
//        String result = DesBase64Tool.desDecrypt("0884e837817903f1",a);
//        CryptAES.AES_Encrypt(PERINFOKEY, bizInfo)
       String result = CryptAES.AES_Decrypt("5218b0deed29f542", a);
//        'encryption = DesBase64Tool.desDecrypt(encryption, key);

        logger.info("解密后:"+result);

    }
    @Test
    public void WhiteGetPlanQry() throws Exception {

        //json数据
        JSONObject jsonObjJDPay = new JSONObject();
        String cityCode = "330100";
        String merchantUserId = "d78eb8ba-cf9e-4de5-ab39-931197d5b613";

        jsonObjJDPay.put("cityCode", cityCode);
        jsonObjJDPay.put("merchantUserId", merchantUserId);
        jsonObjJDPay.put("merchantOrderId", "HZZYCW82002295077_1582970151512");
        try {
            //加密//8w091ql5l2tt6qxj3z0emh21
            //加密//8w091ql5l2tt6qxj
            Map<String, String> resultMap = encryptionWay(jsonObjJDPay.toString(), "8w091ql5l2tt6qxj");
            String encryption = (String) resultMap.get("encryption");

//            String url = "http://localhost:8080/whiteRefundAccountInfo.do";
            String url = "http://localhost:8080/whiteGetPlanQry.do";
//            String url = "http://jpayment.ziroom.com/ZRPaysPlatform/whiteGetPlanQry.do";
//            String url = "http://localhost:8081/ZRPaysPlatform/whiteGetPlanQry.do";



            Map<String, String> param = new HashMap<String, String>();
            param.put("encryption", encryption);

            InputStream resultContentInputStream = NetUtil.sendPostRequest(url, param);
            String resultContent = NetUtil.getTextContent(resultContentInputStream, "UTF-8");

            logger.info(resultContent);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
