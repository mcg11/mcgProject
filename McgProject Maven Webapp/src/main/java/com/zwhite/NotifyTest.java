package com.zwhite;

import com.account.APITest.BaseControllerWebAppContextSetupTest;
import com.alibaba.fastjson.JSONObject;
import com.util.HttpUtil;
import com.ziroom.common.util.JdUtil.GsonUtils;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by macg11 on 2018/2/7.
 */
public class NotifyTest extends BaseControllerWebAppContextSetupTest {

    @Test
    public void addAccountTest() throws Exception {


        Map<String,Object> map = new HashMap<String, Object>();
        map.put("contractId", "aaa");
        map.put("type", "3");
        map.put("result", "success");
        map.put("message", "回调成功了");
        map.put("contractUrl", "http://signature.t.ziroom/api/contract/download?contractId=xxx&systemId=xxx");

        String refundUrl = "http://localhost:8080/api/notify/notifyContract";

        String resultContent = HttpUtil.postJson(refundUrl, GsonUtils.toJson(map));

        JSONObject object=JSONObject.parseObject(resultContent);
        String contractId=object.getString("contractId");

        System.out.println(contractId);
    }
}
