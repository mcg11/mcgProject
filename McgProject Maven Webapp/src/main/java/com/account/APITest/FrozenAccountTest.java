package com.account.APITest;


import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

/**
 * ClassName: FrozenAccountTest
 * 
 * @Description: 增加账户冻结余额测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class FrozenAccountTest extends BaseControllerWebAppContextSetupTest {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(FrozenAccountTest.class);

	public FrozenAccountTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 增加账户冻结余额Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void frozenAccountTest() throws Exception {

		// 获取流水号
		String tradeNo = "";

		// json数据
		JSONObject jsonObjFrozenAccount = new JSONObject();
		jsonObjFrozenAccount.put("uid", "7b7dac3e-80e7-490d-91d4-4d3a8eaf2eac");
		jsonObjFrozenAccount.put("trade_no", "20160912193128190191973");
		jsonObjFrozenAccount.put("total_fee", 878000);
		jsonObjFrozenAccount.put("biz_common", "pay_to_account_froze");
		jsonObjFrozenAccount.put("description", "zrpay");
		// jsonObjFrozenAccount.put("description", TESTFALG + "增加账户冻结余额");
		jsonObjFrozenAccount.put("pay_type", "wx_ad_pay");
		jsonObjFrozenAccount.put("city_code", "801000");
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

		// System.out.println(encryption3);

		//String refundUrl = "http://localhost:8080/account/frozenAccount.do";
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/frozenAccount.do";
		String refundUrl = "http://localhost:8083/account/frozenAccount.do";
		String url = refundUrl + encryption3;

		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		// MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
		// + "frozenAccount.do?encryption=" + encryption);
		// // 请求
		// ResultActions result = mockMvc
		// .perform(mo)
		// .andExpect(
		// MockMvcResultMatchers.jsonPath("$.meta.status").value(
		// "SUCCESS"))
		// .andExpect(
		// MockMvcResultMatchers.jsonPath("$.result").value(
		// tradeNo + "_account"));
		// // 日志 返回值详情
		// logger.info("单元测试  frozenAccountTest result is "
		// + result.andReturn().getResponse().getContentAsString());
	}
}
