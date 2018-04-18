/**
 * 
 */
package com.account.APITest;


import com.ziroom.common.util.NetUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

/**
 * ClassName: GetADetailTest
 * 
 * @Description: 获取账户信息测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class GetADetailTest extends BaseControllerWebAppContextSetupTest {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(GetADetailTest.class);

	/**
	 * 
	 */
	public GetADetailTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取账户信息Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void getADetailTest() throws Exception {
		// json数据
		String uid;
		//String[] uids = {"﻿53bf1777-b485-7656-9f08-0cb30d38c5e5" };
	String[] uids = {"b481df97-8c4e-4819-ac1b-fff265578935" };
		System.out.println(uids.length);
		InputStream resultContentInputStream = null;
		for (int i = 0; i < uids.length; i++) {
			uid = uids[i];
			if (uid == null) {
				// logger.info("null");
				System.out.println("null");
				continue;
			}
			JSONObject jsonObjGetADetail = new JSONObject();
			jsonObjGetADetail.put("uid", uid);
			jsonObjGetADetail.put("city_code", "100001");
			
			
			
//			}
			Map<String, String> resultMap = EncryptionUtil.encryptionWay(
					jsonObjGetADetail.toString(), key_ziroom);
			String encryption = (String) resultMap.get("encryption");
			System.out.println("加密参数："+encryption);



			//
			String refundUrl = "http://account.t.ziroom.com/getADetail.html";
//			String refundUrl = "http://localhost:8083/account/getADetail.do";
			resultContentInputStream = NetUtil.sendPostRequest(refundUrl,
					resultMap);

			String resultContent = NetUtil.getTextContent(resultContentInputStream, "UTF-8");
			System.out.println(resultContent);

		}

	}

}
