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
            String url = "http://jpayment.t.ziroom.com/ZRPaysPlatform/whiteRefundAccountInfo.do";


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
        String a="nySQT/kjaTU0pIDS55qf1rBBgao2l9R57kqmPTXNFt0Pe94OGNOhE9IeVZmRuT8YjFO/oSHG1HH+XmppMRNzVnroOiVTh7dEtRAF6ldsnmTQu4syD7hi0QM1pMQUTdMcLuGRG8DAjc9ehi60CYsSLkfzjBczzssEvT0FXKAvpVPKBAJF/3dSOfawlEccdaWDS9QLmwuXnIi1DVCdIZe3jH2lCG8FY/r2d7fPaLtfqtc3dLaiV/20f0hU1BTDeSd2iKhYzMd0wnpBpoe2u9hn6npI+MapyyXv1JO30fX4XRqL28jfW/IhV1XEC8F8w/K7i2i4fKULP+wbASeHJ8UXqHeHBMPjrZTftaIuS8phSQ3bk6L5il0TGxy6Exc0mpXBKJH7dPqNd2atGUsPr6gv20I5P5Hd8BfpLmPLL60V3gp3w36smWf2EtoQhBQuIhE6";
        //String result = DesBase64Tool.desDecrypt(a, "8w091ql5l2tt6qxj3z0emh21");
        String result = DesBase64Tool.desDecrypt("0884e837817903f1",a);
//        CryptAES.AES_Encrypt(PERINFOKEY, bizInfo)
        result = CryptAES.AES_Decrypt("6sijeebzyy4npwys", a);
        //'encryption = DesBase64Tool.desDecrypt(encryption, key);

        logger.info("解密后:"+result);


    }
}
