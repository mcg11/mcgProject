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
        String a="J4240q+WyUIDX+/vwSJVesoTYyYM8retj1zQ9G2ZaC0E0dwCK50IqDnPzi1VzFE+QFiX+9qyfiwaJl+bWvGiw3YUbqaEwJQz8ObD/eIcMsukbmpwgNsWqBo7zmnM2hwkLGoS7mTNcYQRd5pw8Vr/At5Hj9FmR3l/UuUrLGnnnoAdoOyV6mYYEjVWIVdKeuqs65ka8ur3J+LnsNUE98YSY8ZRAWPpf4r0BRPdwdiXmcR31fJ3aQZWcUCCX+6UNAX67MQvTuTcmQ7kFx7T5I2MyxbJVUk9PG6+rAtXHC2pW1J8PQr0GHTSBKuec2pBROWXlOBKV2OOogWqx3e2k+pRBx1oHIUazHEfjXGIZcPHeKsgaVZFz0lQv4eI2TjTxsEEwXAWkb5Up9RbCY73n8DKRBgpBrf1RA9W54QAUUqs8gUKBD0Pvvqg0q9mREAOOcyZCpMWfZ6+aqj2mpnikDyLWzFsm+fIUJEDKflT4dU9ssed8OMvY+HkPPsNBo7E4JKlh27Grkt4RzAvhq9dEBUoiKGGSuspxYfofx9wX0lzyQIoz4Lsg6Z4PtZV6FYhoEIyQtDJVPVb7FxkP3SvH6XHXJPKA3r6wInLxVHZjX+HTxbjsT8TOBvThAPXSJIczUA5snbi61CIV2S8zonct4HsF7H45w9SDai6Edp+g2RUwI3dqv1EQHr3ZnUdFxJFp9IMU2W62xhu9aEydXQjPL50iFoezX8wfbI7PTAOnwTVgRiUbPhJR/JbzW44wSrZyR1vt8v1lHbb1t3L5UZr/Rh1xsoOSpXala07xnRqgTVM8/TNHVw7ZigDwQGBhiSnuES84pA0Wu5JoTh546y2FxhVvBf8RFDLwYK3F6yHzT7JdrH+i5D7iOI/elOoOBMY4Y7w0uqbg7WWYkQB3fUJQv9tXc1A1Skg2TTLxwnTb+oeJ1WOYk9f03bWRpKg/PR2iE43qBY+N/D6vesdoZBMbbQiZByNYKdwj8S/BGDqn8bq1sNzJ9I9Za8BAIh5JUd1Q4v4";
        //String result = DesBase64Tool.desDecrypt(a, "8w091ql5l2tt6qxj3z0emh21");
        String result = DesBase64Tool.desDecrypt("0884e837817903f1",a);
//        CryptAES.AES_Encrypt(PERINFOKEY, bizInfo)
        result = CryptAES.AES_Decrypt("0884e837817903f1", a);
        //'encryption = DesBase64Tool.desDecrypt(encryption, key);

        logger.info("解密后:"+result);

    }
}
