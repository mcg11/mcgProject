package com.jpayment;

import com.ziroom.common.util.JdUtil.AlgorithmUtils;
import com.ziroom.common.util.JdUtil.GsonUtils;
import com.ziroom.common.util.NetUtil;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: gaojk 
 * @date:2015年4月27日 下午4:29:16
 * @since 1.0.0
 */

public class WhiteTipNotifyActionTest {

	/**
	 * @throws Exception
	 */
	@Test
	public void testwhiteNotify() throws Exception {
		
		CallbackReqVo cb=new CallbackReqVo();
		CallbackOrderEntityVo orderEntity=new CallbackOrderEntityVo();
		orderEntity.setAmount("1");
		orderEntity.setLoanId("123123123");
		orderEntity.setMerchantCode("666666");
		orderEntity.setMerchantOrderId("1111100011110001");
		orderEntity.setPayState("3");
		orderEntity.setMerchantOrderDate("20150202121212");
		orderEntity.setRefOrderId("121231231");
		orderEntity.setTradeDate("20150202121212");
		
		cb.setOrderEntity(orderEntity);
		cb.setResultCode("000000");
		cb.setResultInfo("success");
		Map<String,String> aa=new HashMap<String,String>();
		aa.put("sign", "aa");
		String dataJson= GsonUtils.toJson(cb);
		String data=BizEntityHelper.createCipherText(dataJson, "012345678901234567890123", "UTF-8");
		BizEntity biz=new BizEntity("1.0", "UTF-8", "05",
				data, "7000000006", null);
		BizEntityHelper.createSignSHA256(biz, "012345678901234567890123");

        Map<String, String> param  = new HashMap();
        param.put("version", "1.0");
        param.put("charset", "UTF-8");
        param.put("sign", biz.getSign());
        param.put("tradeType", "05");
        param.put("merchantCode","7000000006");
        param.put("data", biz.getData());

		String url="/sign="+biz.getSign()+"&tradeType=05&data="+biz.getData()+"&charset=UTF-8&merchantCode=7000000006&version=1.0";
//		String testUrl="http://jpayment.t.ziroom.com/ZRPaysPlatform/whiteNotify.htm";
		String testUrl="http://localhost:8080/whiteNotify.htm";
        InputStream resultContentInputStream = NetUtil.sendPostRequest(
                testUrl, param);
        String resultContent = NetUtil.getTextContent(
                resultContentInputStream, "UTF-8");
        System.out.println("结果:"+resultContent);




//
	}

}
