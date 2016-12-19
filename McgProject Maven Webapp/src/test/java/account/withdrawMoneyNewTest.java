package account;

import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

import account.utils.EncryptionUtil;

import com.ziroom.common.util.NetUtil;

public class withdrawMoneyNewTest {
	/**
	 * 生成提现单
	 */
	@Test
	public void createWithdrawCash() throws Exception{
		String uniqueNo="1111111111115551";//数据唯一标识
		String applicationTime="2016-10-05 11:11:11";//提现申请时间
		String wmAmount="1";//提现金额
		String wmUid="32d25b82-3861-550f-7942-4a9005731da3";//uid
		String bankArea="鞍山";//开卡所在行
		String bankCode="1046";//银行编码
		String bankNum="6222600910069651436";//银行卡号
		String bankName="交通银行";//银行名字
		String wmName="张志琼";//提现客户名字
		String sytemSource="dz";//来源
		JSONObject obj=new JSONObject();
		obj.put("uniqueNo", uniqueNo);
		obj.put("applicationTime", applicationTime);
		obj.put("wmAmount", wmAmount);
		obj.put("wmUid", wmUid);
		obj.put("bankArea", bankArea);
		obj.put("bankCode", bankCode);
		obj.put("bankNum", bankNum);
		obj.put("bankName", bankName); 
		obj.put("wmName", wmName);
		obj.put("systemSource", sytemSource);
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(obj.toString(), "8w091ql5l2tt6qxj");
		
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do?";
//		String refundUrl = "http://localhost:8080/ZRAccount/account/withdrawMoney/createWithdrawCash.do?";
		String refundUrl = "http://account.t.ziroom.com/withdrawMoney/createWithdrawCash.html?";
		InputStream resultContentInputStream = NetUtil.sendPostRequest(refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}

}
