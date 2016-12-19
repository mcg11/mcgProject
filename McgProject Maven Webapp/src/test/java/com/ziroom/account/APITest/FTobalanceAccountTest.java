package com.ziroom.account.APITest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import account.utils.EncryptionUtil;

import com.google.gson.Gson;
import com.ziroom.common.util.JsonUtil;
import com.ziroom.common.util.NetUtil;

/**
 * ClassName: FTobalanceAccountTest
 * 
 * @Description: 用户冻结金额转账户余额
 * @author liuxm
 * @date 2014年11月15日
 */
public class FTobalanceAccountTest extends Exception {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(FTobalanceAccountTest.class);

	public FTobalanceAccountTest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 用户冻结金额转账户余额Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void fTobalanceAccountTest() throws Exception {

		Map<String, String> jsonObjFTobalanceAccount = new HashMap<String, String>();
//		JSONObject jsonObjFTobalanceAccount = new JSONObject();

		jsonObjFTobalanceAccount.put("uid","ae6bfa65-68ec-2707-4a1a-d0908f578b85");
		jsonObjFTobalanceAccount.put("total_fee", "2");
		jsonObjFTobalanceAccount.put("biz_common", "contract_to_account");
		jsonObjFTobalanceAccount.put("description", "bu_dan");
		jsonObjFTobalanceAccount.put("tradeNo", "20160819161141782150093674");
		// jsonObjFTobalanceAccount.put("description", TESTFALG +
		// "用户冻结金额转账户余额");
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("order_id", "1111");
		map.put("total_free", 11);
		list.add(map);
		map=new HashMap<String, Object>();
		map.put("order_id", "2222");
		map.put("total_free", 222);
		list.add(map);
		jsonObjFTobalanceAccount.put("order_id",JsonUtil.listToJson(list));
		jsonObjFTobalanceAccount.put("city_code", "801000"); // 加密
		
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				new Gson().toJson(jsonObjFTobalanceAccount), "8w091ql5l2tt6qxj");
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

		//String refundUrl = "http://account.t.ziroom.com/fTobalanceAccount.html";
		String refundUrl = "http://localhost:8080/ZRAccount/account/fTobalanceAccount.do";
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
