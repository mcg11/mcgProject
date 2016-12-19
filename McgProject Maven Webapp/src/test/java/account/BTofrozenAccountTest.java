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
 * ClassName: BTofrozenAccountTest
 * 
 * @Description: 用户余额转冻结
 * @author liuxm
 * @date 2014年11月15日
 */
public class BTofrozenAccountTest  {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(BTofrozenAccountTest.class);


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
				"f4250a5f-a7de-3112-58ff-86d00c3537a2");
		jsonObjBTofrozenAccount.put("total_fee", 301867);
		jsonObjBTofrozenAccount.put("biz_common", "pay_bTofrozen_account");
		// jsonObjBTofrozenAccount.put("description", TESTFALG + "用户余额转冻结");
		jsonObjBTofrozenAccount.put("city_code", "100001");
		
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjBTofrozenAccount.toString(), "8w091ql5l2tt6qxj");
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

//		String refundUrl = "http://account.ziroom.com/bTofrozenAccount.html";
//		String refundUrl = "http://localhost:8080/ZRAccount/account/bTofrozenAccount.do";
		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bTofrozenAccount.do";


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
