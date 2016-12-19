package com.ziroom.account.daoTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.ziroom.common.util.NetUtil;

public class AddTaskByTradeNoTest extends Exception {
	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(AddTaskByTradeNoTest.class);

	@Test
	public void testAddTask() throws Exception {

		logger.info("testAddTask start!");

		String tradeNo;
		String[] tradeNos = {"DJBJYD2016101900114"};

		// System.out.println(tradeNos.length);

		logger.info(tradeNos.length);

		for (int i = 0; i < tradeNos.length; i++) {
			tradeNo = tradeNos[i];
			if (tradeNo == null) {
				logger.info("null");
				// System.out.println("null");
				continue;
			}

			Map<String, String> param = new HashMap<String, String>();
			param.put("tradeNo", tradeNo);
			String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/addTask.do";
			// String refundUrl =
			// "http://10.10.64.39:8080/ZRFinance/fcPayVouchers/addFcPayVourchers.do";
			NetUtil.sendPostRequest(refundUrl, param);
			// MockHttpServletRequestBuilder mo =
			// MockMvcRequestBuilders.get(path
			// + "addTask?tradeNo=" + tradeNo);
			// // 请求
			// ResultActions result = mockMvc.perform(mo);

			// logger.info(result);
			System.out.println("do  end");
			logger.info("testAddTask end !");

		}
	}
}
