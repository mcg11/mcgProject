package com.account.APITest;

import com.ziroom.common.util.NetUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AddTaskByTradeNoTest extends BaseControllerWebAppContextSetupTest {
	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(AddTaskByTradeNoTest.class);

	@Test
	public void testAddTask() throws Exception {

		logger.info("testAddTask start!");
//
//
		String tradeNo;
		String[] tradeNos = {"W1505311025d"};

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

			// logger.info(result);
			System.out.println("do  end");
			logger.info("testAddTask end !");

		}
	}
}
