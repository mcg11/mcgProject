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
 * ClassName: RfrozenAccountTest
 * 
 * @Description: 消耗用户冻结金额
 * @author liuxm
 * @date 2014年11月15日
 */
public class RfrozenAccountTest extends BaseControllerWebAppContextSetupTest {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(RfrozenAccountTest.class);

	public RfrozenAccountTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 账户消费冻结余额Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void rfrozenAccountTest() throws Exception {
		// json数据
		JSONObject jsonObjRfrozenAccount = new JSONObject();
		jsonObjRfrozenAccount
				.put("uid", "750a50ea-0803-4a67-8663-c574f3f207e9");
		jsonObjRfrozenAccount.put("total_fee", 49800);
		jsonObjRfrozenAccount.put("biz_common", "frozen_to_reduce_web");
		// jsonObjRfrozenAccount.put("description", TESTFALG + "消耗用户冻结金额");
		jsonObjRfrozenAccount.put("pay_type", null);
		jsonObjRfrozenAccount.put("city_code", 320100);
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> map=new HashMap<String, String>();
        map.put("order_id","WXAPP155064480610328410307320100");
        map.put("total_free","49800");
        list.add(map);

		jsonObjRfrozenAccount.put("order_id",list);
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
		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/rfrozenAccount.do";
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
