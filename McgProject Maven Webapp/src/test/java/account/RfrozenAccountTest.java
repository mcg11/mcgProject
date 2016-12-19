package account;

import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import account.utils.EncryptionUtil;

import com.ziroom.common.util.NetUtil;

/**
 * ClassName: RfrozenAccountTest
 * 
 * @Description: 消耗用户冻结金额
 * @author liuxm
 * @date 2014年11月15日
 */
public class RfrozenAccountTest extends Exception {

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
				.put("uid", "6a12f494-18a2-d7f5-0e59-e1ded6449c3c");
		jsonObjRfrozenAccount.put("total_fee", 247227);
		jsonObjRfrozenAccount.put("biz_common", "frozen_to_reduce_web");
		// jsonObjRfrozenAccount.put("description", TESTFALG + "消耗用户冻结金额");
		jsonObjRfrozenAccount.put("pay_type", null);
		jsonObjRfrozenAccount.put("city_code", 801000);
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjRfrozenAccount.toString(), "8w091ql5l2tt6qxj");  
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

//		String refundUrl = "http://account.ziroom.com/rfrozenAccount.html";
		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/rfrozenAccount.do";
//		String refundUrl = "http://localhost:8080/ZRAccount/account/rfrozenAccount.do";
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
