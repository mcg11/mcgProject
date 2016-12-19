/**  
 * @Title: ReduceAccountTest.java
 * @Package com.ziroom.account.webTest
 * @Description: TODO
 * @author yokoboy
 * @date 2014年11月15日
 */
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
 * ClassName: ReduceAccountTest
 * 
 * @Description: 账户消费测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class ReduceAccountTest extends Exception {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(ReduceAccountTest.class);

	/**
	 * <p>
	 * Description:
	 * </p>
	 */
	public ReduceAccountTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 账户消费Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void reduceAccount() throws Exception {
		// json数据
		JSONObject jsonObjReduceAccount = new JSONObject();
		jsonObjReduceAccount.put("uid", "ae6bfa65-68ec-2707-4a1a-d0908f578b85");
		jsonObjReduceAccount.put("total_fee",2);
		jsonObjReduceAccount.put("city_code", "801000");

		jsonObjReduceAccount.put("description", "手工补录");
		jsonObjReduceAccount.put("pay_type", "wx_ios_pay");
		jsonObjReduceAccount.put("biz_common", "pay_reduce_account");// pay_reduce_account
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjReduceAccount.toString(), "8w091ql5l2tt6qxj");
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

//		String refundUrl = "http://account.ziroom.com/reduceAccount.html";
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/reduceAccount.do";
		String refundUrl = "http://localhost:8080/ZRAccount/account/reduceAccount.do";

		String url = refundUrl + encryption3;

		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		// MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
		// + "reduceAccount.do?encryption=" + encryption);
		// // 请求
		// ResultActions result = mockMvc.perform(mo).andExpect(
		// MockMvcResultMatchers.jsonPath("$.meta.status")
		// .value("SUCCESS"));
		//
		// // 日志 返回值详情
		// logger.info("单元测试  addAccountTest result is "
		// + result.andReturn().getResponse().getContentAsString());
	}
}
