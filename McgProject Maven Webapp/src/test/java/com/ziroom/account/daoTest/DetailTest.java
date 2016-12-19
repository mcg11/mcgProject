package com.ziroom.account.daoTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class DetailTest extends Exception {
	// 日志处理类
	private final static transient Log logger = LogFactory
			.getLog(DetailTest.class);

	@Test
	public void getDetailByTradeNoTest() throws Exception {
		logger.info("getDetailByTradeNoTest start!");

		String tradeNo;
		String[] tradeNos = { "524b5e44fef2db34b1e03b4b1f7eb3b" };

		logger.info(tradeNos.length);

		System.out.println(tradeNos.length);
		for (int i = 0; i < tradeNos.length; i++) {
			tradeNo = tradeNos[i];
			if (tradeNo == null) {
				logger.info("null");
				// System.out.println("null");
				continue;
			}
			/*MockHttpServletRequestBuilder mo = MockMvcRequestBuilders.get(path
					+ "selectDetail?tradeNo=" + tradeNo);*/
			// 请求
			//ResultActions result = mockMvc.perform(mo);

			/*logger.info("getDetailByTradeNoTest result "
					+ result.andReturn().getResponse().getContentAsString());*/

			logger.info("getDetailByTradeNoTest end !");

		}

	}
}
