/**
 * 
 */
package com.ziroom.account.APITest;

import java.io.InputStream;
import java.util.Map;

import account.utils.EncryptionUtil;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ziroom.common.util.NetUtil;
import org.junit.Test;

/**
 * ClassName: AddAccountTest
 * 
 * @Description: 账户充值测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class AddAccountTest extends Exception {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(AddAccountTest.class);
	/**
	 * 
	 */
	public AddAccountTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 账户充值Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void addAccountTest() throws Exception {

		// 获取流水号

		// json数据
		JSONObject jsonObjAddAccount = new JSONObject();
		jsonObjAddAccount.put("uid", "2f24558d-06e1-4375-acd6-da881e099da2");
		jsonObjAddAccount.put("trade_no", "tuifei_BJYD2016082800029");
		jsonObjAddAccount.put("total_fee", 132400);
		jsonObjAddAccount.put("biz_common", "zch_settlement");//
		// 账户充值业务类型
		// jsonObjAddAccount.put("description",
		// TESTFALG
		// +
		// " 账户充值");
		jsonObjAddAccount.put("description", "addAccount");
		jsonObjAddAccount.put("city_code", "801000");
		jsonObjAddAccount.put("pay_type", "account");
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjAddAccount.toString(), "8w091ql5l2tt6qxj");
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
		String refundUrl = "http://account.ziroom.com/addAccount.html";
		String url = refundUrl + encryption3;
		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		// logger.info(encryption);
		// MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
		// + "addAccount.do?encryption=" + encryption);
		// // 请求
		// ResultActions result = mockMvc.perform(mo);
		// .andExpect(
		// MockMvcResultMatchers.jsonPath("$.meta.status").value(
		// "SUCCESS"))
		// .andExpect(
		// MockMvcResultMatchers.jsonPath("$.result").value(
		// tradeNo + "_account"))
		// 日志 返回值详情
		// logger.info("单元测试  addAccountTest result is "
		// + result.andReturn().getResponse().getContentAsString());
	}
}
