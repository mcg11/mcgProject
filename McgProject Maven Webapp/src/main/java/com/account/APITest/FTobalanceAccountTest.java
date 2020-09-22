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


		jsonObjFTobalanceAccount.put("uid","37c7d070-ce18-45d1-f794-2abd288e987a");
		jsonObjFTobalanceAccount.put("total_fee", 1000000);
		jsonObjFTobalanceAccount.put("biz_common", "1");
		jsonObjFTobalanceAccount.put("description", "补数据");
		jsonObjFTobalanceAccount.put("tradeNo", "20190119142301226154787898122664804");
		jsonObjFTobalanceAccount.put("business_type", "1");
		jsonObjFTobalanceAccount.put("sys_source", "crm");
		jsonObjFTobalanceAccount.put("uid_type", "kh");
		// jsonObjFTobalanceAccount.put("description", TESTFALG +
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> map=new HashMap<String, String>();
        map.put("order_id","20190119142301226154787898122664804");
        map.put("total_free","1000000");
//        map.put("bus_id","20180903001");
        list.add(map);

        jsonObjFTobalanceAccount.put("order_id",list);
		// "用户冻结金额转账户余额");
		jsonObjFTobalanceAccount.put("city_code", "801000"); // 加密
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
//        String refundUrl = "http://account.t.ziroom.com/fTobalanceAccount.html";

//        String refundUrl = "http://localhost:8083/account/fTobalanceAccount.do";
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
