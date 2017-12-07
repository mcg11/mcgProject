package com.account.APITest;


import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

/**
 * ClassName: BTofrozenAccountTest
 * 
 * @Description: 用户余额转冻结
 * @author liuxm
 * @date 2014年11月15日
 */
public class BTofrozenAccountTest extends BaseControllerWebAppContextSetupTest {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(BTofrozenAccountTest.class);

	/**
	 * 
	 */
	public BTofrozenAccountTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 用户余额转冻结Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void bTofrozenAccountTest() throws Exception {

		// json数据
		JSONObject jsonObjBTofrozenAccount = new JSONObject();
		jsonObjBTofrozenAccount.put("uid",
				"2cf365c8-86f8-e6ba-d1a6-e1ddb52e0656");
		jsonObjBTofrozenAccount.put("total_fee", 60000000);
		jsonObjBTofrozenAccount.put("biz_common", "pay_bTofrozen_account");
		// jsonObjBTofrozenAccount.put("description", TESTFALG + "用户余额转冻结");
		jsonObjBTofrozenAccount.put("city_code", "801000");
		
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjBTofrozenAccount.toString(), key_ziroom);
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

		//String refundUrl = "http://account.ziroom.com/bTofrozenAccount.html";
        String refundUrl = "http://account.t.ziroom.com/ZRAccount/account/bTofrozenAccount.do";

		String url = refundUrl + encryption3;

		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		/*
		 * logger.info(encryption);
		 * 
		 * MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path +
		 * "bTofrozenAccount.do?encryption=" + encryption); // 请求 //
		 * ResultActions ResultActions result = mockMvc.perform(mo).andExpect(
		 * MockMvcResultMatchers.jsonPath("$.meta.status") .value("SUCCESS"));
		 * // 日志 返回值详情 logger.info("单元测试  bTofrozenAccountTest result is " +
		 * result.andReturn().getResponse().getContentAsString());
		 */
	}
}
