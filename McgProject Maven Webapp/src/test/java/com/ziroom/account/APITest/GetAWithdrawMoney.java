/**
 * 
 */
package com.ziroom.account.APITest;

import account.utils.EncryptionUtil;

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
public class GetAWithdrawMoney extends Exception {

	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(GetAWithdrawMoney.class);

	/**
	 *
	 */
	public GetAWithdrawMoney() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取账户信息Test
	 * 
	 * @throws Exception
	 */
	@Test
	public void getAgetABalanceListTest() throws Exception {
		// json数据
		String uid;
		InputStream resultContentInputStream = null;
		String[] uids = {"aa57540b-2dbb-2a68-cedc-3dd77597c501" };

			uid = uids[0];
			JSONObject jsonObjGetADetail = new JSONObject();
			jsonObjGetADetail.put("uid", uid);
			jsonObjGetADetail.put("systemSource", "crm");
		jsonObjGetADetail.put("pageNo", 1);
		jsonObjGetADetail.put("pageSize", 10);
			//jsonObjGetADetail.put("city_code", "801000");
			// 加密
			Map<String, String> resultMap = EncryptionUtil.encryptionWay(
					jsonObjGetADetail.toString(), "8w091ql5l2tt6qxj");
			String encryption = (String) resultMap.get("encryption");
			if (encryption.equals("")) {
				logger.error((String) resultMap.get("error"));
				return;
			}
			System.out.println("加密前"+jsonObjGetADetail.toString());
			System.out.println("加密参数"+encryption);

			String refundUrl = "http://account.t.ziroom.com/withdrawMoney/getWithdrawCash.html";
		resultContentInputStream = NetUtil.sendPostRequest(refundUrl,
				resultMap);

		String resultContent = NetUtil.getTextContent(
				resultContentInputStream, "UTF-8");
		System.out.println(resultContent);
		}
	}
