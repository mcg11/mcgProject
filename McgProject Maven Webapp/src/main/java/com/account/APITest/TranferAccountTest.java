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
 * Created by macg11 on 2017/7/28.
 */
public class TranferAccountTest  extends BaseControllerWebAppContextSetupTest{

    // 日志处理类
    private final static transient Log logger = LogFactory
            .getLog(TranferAccountTest.class);

    @Test
    public void rfrozenAccountTest() throws Exception {
        // json数据
        JSONObject jsonObjRfrozenAccount = new JSONObject();
        jsonObjRfrozenAccount.put("orig_uid", "8ef91082-1bb7-4c97-9a1b-f58b076a0af7");
        jsonObjRfrozenAccount.put("orig_city_code", "801300");
        jsonObjRfrozenAccount.put("uid_type", "yz");
        // jsonObjRfrozenAccount.put("description", TESTFALG + "消耗用户冻结金额");
        jsonObjRfrozenAccount.put("reduce_type", 4);
        jsonObjRfrozenAccount.put("target_uid", "a3f9cc95-fdf1-c3e2-efeb-db14daba6bef");
        jsonObjRfrozenAccount.put("target_city_code", "801300");
        jsonObjRfrozenAccount.put("orig_business_type", "");
        jsonObjRfrozenAccount.put("pay_type", null);
        jsonObjRfrozenAccount.put("target_uid_type", "kh");
        jsonObjRfrozenAccount.put("add_type", 3);
        jsonObjRfrozenAccount.put("trade_no", "FK170728A9BUGVDE093049");
        jsonObjRfrozenAccount.put("total_fee", 20000);
        jsonObjRfrozenAccount.put("biz_common", "dz_transfersAccount");
        jsonObjRfrozenAccount.put("description", null);
        jsonObjRfrozenAccount.put("order_id", "170724L0G5788U093655");
        jsonObjRfrozenAccount.put("sys_source", "dz");
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

        // System.out.println(encryption3);

        //String refundUrl = "http://localhost:8080/account/rfrozenAccount.do";
        String refundUrl = "http://localhost:8083/account/transferAccount.do";
        String url = refundUrl + encryption3;

        System.out.println(url);

        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                refundUrl, resultMap);

        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");
        System.out.println(resultContent);

        // MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
        // + "rfrozenAccount.do?encryption=" + encryption);
        // // 请求
        // ResultActions result = mockMvc.perform(mo).andExpect(
        // MockMvcResultMatchers.jsonPath("$.meta.status")
        // .value("SUCCESS"));
        // // 日志 返回值详情
        // logger.info("单元测试  rfrozenAccountTest result is "
        // + result.andReturn().getResponse().getContentAsString());
    }
}
