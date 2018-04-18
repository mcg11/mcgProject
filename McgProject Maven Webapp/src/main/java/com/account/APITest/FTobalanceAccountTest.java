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
 * ClassName: FTobalanceAccountTest
 * 
 * @Description: 用户冻结金额转账户余额
 * @author liuxm
 * @date 2014年11月15日
 */
public class FTobalanceAccountTest extends BaseControllerWebAppContextSetupTest {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(FTobalanceAccountTest.class);

	public FTobalanceAccountTest() {
		// TODO Auto-generated constructor stub
	}
	// 获取流水号
String tradeNo = "";

	/**
	 * 用户冻结金额转账户余额Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void fTobalanceAccountTest() throws Exception {

		JSONObject jsonObjFTobalanceAccount = new JSONObject();


		jsonObjFTobalanceAccount.put("uid","1e61f46d-90a3-4550-9a4d-cd62e1034e02");
		jsonObjFTobalanceAccount.put("total_fee", 100);
		jsonObjFTobalanceAccount.put("biz_common", "contract_to_account");
		jsonObjFTobalanceAccount.put("description", "bu_dan");
		jsonObjFTobalanceAccount.put("tradeNo", "budan_ALAPP151238757830512809452440300");
		// jsonObjFTobalanceAccount.put("description", TESTFALG +
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> map=new HashMap<String, String>();
        map.put("order_id","ALAPP151238757830512809452440300");
        map.put("total_free","972800");
        list.add(map);

        jsonObjFTobalanceAccount.put("order_id",list);
		// "用户冻结金额转账户余额");
		jsonObjFTobalanceAccount.put("city_code", "100003"); // 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjFTobalanceAccount.toString(), key_ziroom);
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

        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/fTobalanceAccount.do";
//		String refundUrl = "http://localhost:8080/account/fTobalanceAccount.do";
		String url = refundUrl + encryption3;

		System.out.println(url);

		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream,
				"UTF-8");
		System.out.println(resultContent);

		// MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
		// + "fTobalanceAccount.do?encryption=" + encryption);
		// // 请求
		// ResultActions result = mockMvc.perform(mo).andExpect(
		// MockMvcResultMatchers.jsonPath("$.meta.status")
		// .value("SUCCESS"));
		// // 日志 返回值详情
		// logger.info("单元测试  fTobalanceAccountTest result is "
		// + result.andReturn().getResponse().getContentAsString());
	}
}
