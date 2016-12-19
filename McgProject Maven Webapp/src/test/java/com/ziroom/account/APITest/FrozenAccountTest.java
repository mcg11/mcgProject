package com.ziroom.account.APITest;

import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import account.utils.EncryptionUtil;

import com.ziroom.common.util.NetUtil;

/**
 * ClassName: FrozenAccountTest
 * 
 * @Description: 增加账户冻结余额测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class FrozenAccountTest extends Exception {

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

		// json数据
		JSONObject jsonObjFrozenAccount = new JSONObject();
		jsonObjFrozenAccount.put("uid", "ae6bfa65-68ec-2707-4a1a-d0908f578b85");
		jsonObjFrozenAccount.put("trade_no", "mingsu_lizhi_zhuanzhang");
		jsonObjFrozenAccount.put("total_fee", 2314681);
		jsonObjFrozenAccount.put("biz_common", "pay_to_account_froze");
		jsonObjFrozenAccount.put("description", "zrpay");
		// jsonObjFrozenAccount.put("description", TESTFALG + "增加账户冻结余额");
		jsonObjFrozenAccount.put("pay_type", null);
		jsonObjFrozenAccount.put("city_code", "801300");
		jsonObjFrozenAccount.put("sys_source", "dz");
		jsonObjFrozenAccount.put("order_id", "2222");
		// jsonObjFrozenAccount.put("pay_time", "2015-09-09 20:05:21");
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjFrozenAccount.toString(), "8w091ql5l2tt6qxj");
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

		String refundUrl = "http://localhost:8080/ZRAccount/account/frozenAccount.do";
//		String refundUrl = "http://account.ziroom.com/frozenAccount.html"; 
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
