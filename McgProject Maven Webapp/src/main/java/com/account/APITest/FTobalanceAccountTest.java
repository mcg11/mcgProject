package com.account.APITest;


import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
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


		jsonObjFTobalanceAccount.put("uid","c6387b52-beda-408b-a8a0-421660f033af");
		jsonObjFTobalanceAccount.put("total_fee", 100);
		jsonObjFTobalanceAccount.put("biz_common", "contract_to_account");
		jsonObjFTobalanceAccount.put("description", "bu_dan");
		jsonObjFTobalanceAccount.put("tradeNo", "budan_WXAPP151943083593514450111110000");
		// jsonObjFTobalanceAccount.put("description", TESTFALG +
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> map=new HashMap<String, String>();
        map.put("order_id","WXAPP151943083593514450111110000");
        map.put("total_free","293300");
        list.add(map);

        jsonObjFTobalanceAccount.put("order_id",list);
		// "用户冻结金额转账户余额");
		jsonObjFTobalanceAccount.put("city_code", "100001"); // 加密
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
//		String refundUrl = "http://localhost:8083/account/fTobalanceAccount.do";
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


    @Test
    public void contractDownLoad1() throws Exception {
        // json数据

        String refundUrl = "http://localhost:8081/api/contract/downLoad";
//        URL url = new URL(fileUrl);
//        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
//        urlCon.setConnectTimeout(30000);
//        urlCon.setReadTimeout(30000);
//        InputStream inStream = urlCon.getInputStream();
        Map<String, String> resultMap=new HashMap<String, String>();
        resultMap.put("contractId","1111");

//        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/fTobalanceAccount.do";
//		String refundUrl = "http://localhost:8080/account/fTobalanceAccount.do";
      InputStream resultContentInputStream = NetUtil.sendPostRequest(
        refundUrl, resultMap);
        String fileUrl="";

        // 将inputstream转换成字符流
        InputStreamReader inputStreamReader = new InputStreamReader(resultContentInputStream);
//
        BufferedReader reader = new BufferedReader(inputStreamReader);
        File file = new File(fileUrl);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String line;
        while (null != (line = reader.readLine())) {
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();



        String resultContent = NetUtil.getTextContent(resultContentInputStream,
                "UTF-8");

    }

}
