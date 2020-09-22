/**
 * 
 */
package com.ziroom.account.APITest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import account.utils.EncryptionUtil;

import com.ziroom.common.util.JsonUtil;
import com.ziroom.common.util.NetUtil;
import org.junit.Test;

/**
 * ClassName: GetADetailTest
 * 
 * @Description: 获取账户信息测试类
 * @author liuxm
 * @date 2014年11月15日
 */
public class GetADetailTest extends Exception {

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
		
		JSONObject jsonObjGetADetail = new JSONObject();
		jsonObjGetADetail.put("uid", "ae6bfa65-68ec-2707-4a1a-d0908f578b85");
		jsonObjGetADetail.put("city_code", "5005");
		jsonObjGetADetail.put("uid_type", "kh");
		jsonObjGetADetail.put("sys_source", "");
		jsonObjGetADetail.put("intercompany", "");
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("order_id", "1111");
		map.put("total_free", 11);
		list.add(map);
		
		jsonObjGetADetail.put("order_id", JsonUtil.listToJson(list));

		System.out.println(jsonObjGetADetail);
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				jsonObjGetADetail.toString(), "8w091ql5l2tt6qxj");
		String encryption = (String) resultMap.get("encryption");
		System.out.println("加密参数："+encryption);


//		String refundUrl = "http://account.t.ziroom.com/getADetailNew.html";
		String refundUrl = "http://localhost:8083/account/getADetail.do";
		InputStream resultContentInputStream = NetUtil.sendPostRequest(refundUrl,
				resultMap);

		String resultContent = NetUtil.getTextContent(resultContentInputStream, "UTF-8");
		System.out.println(resultContent);

	}
}
