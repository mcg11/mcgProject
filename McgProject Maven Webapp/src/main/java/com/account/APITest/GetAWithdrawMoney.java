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
public class GetAWithdrawMoney extends BaseControllerWebAppContextSetupTest {

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
	public void getWithdrawCash() throws Exception {
		// json数据
		String uid;
		InputStream resultContentInputStream = null;
		String[] uids = {"3c44a32f-21d9-585b-0eb3-fc806354ba68" };

			uid = uids[0];
			JSONObject jsonObjGetADetail = new JSONObject();
			jsonObjGetADetail.put("uid", uid);
			jsonObjGetADetail.put("systemSource", "wz");
		jsonObjGetADetail.put("pageNo", 1);
		jsonObjGetADetail.put("pageSize", 1000);
//			jsonObjGetADetail.put("accountId", 50038765);
			// 加密
			Map<String, String> resultMap = EncryptionUtil.encryptionWay(
					jsonObjGetADetail.toString(), key_ziroom);
			String encryption = (String) resultMap.get("encryption");
			if (encryption.equals("")) {
				logger.error((String) resultMap.get("error"));
				return;
			}
			System.out.println("加密前"+jsonObjGetADetail.toString());
			System.out.println("加密参数"+encryption);

//			String refundUrl = "http://localhost:8083/account/withdrawMoney/getWithdrawCash.html";
        String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getWithdrawCash.do";

        resultContentInputStream = NetUtil.sendPostRequest(refundUrl,
				resultMap);

		String resultContent = NetUtil.getTextContent(
				resultContentInputStream, "UTF-8");
		System.out.println(resultContent);
		}
	}
