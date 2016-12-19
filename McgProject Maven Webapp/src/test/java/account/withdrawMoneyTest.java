package account;

import java.io.InputStream;
import java.util.Map;

import javax.crypto.Cipher;

import net.sf.json.JSONObject;

import org.junit.Test;

import account.utils.EncryptionUtil;

import com.ziroom.common.util.NetUtil;

/**
 * 提现相关，余额相关
 * @author homelink
 */
public class withdrawMoneyTest {
	/**
	 * 获取账户余额
	 */
	@Test
	public void getAllDetails() throws Exception{
		String uid="b35c6caa-f11a-7cfa-004f-bd1c73c05712";//	用户uid	I	String	是	 
		String systemSource="dz";//
		JSONObject obj=new JSONObject();
		obj.put("uid", uid);
		obj.put("systemSource", systemSource);
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do?";
//		String refundUrl = "http://localhost:8080/ZRAccount/account/withdrawMoney/getAllDetails.do?";
		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}
	/**
	 * 获取提现单
	 */
	@Test
	public void getWithdrawCash() throws Exception{
		String uid="e2b5e0b3-c817-9325-4c7b-31e03912b94b";//	用户uid	I	String	是	 
		String pageNo="1";//
		String pageSize="20";//
		String systemSource="dz";//
		JSONObject obj=new JSONObject();
		obj.put("uid", uid);
		obj.put("pageNo", pageNo);
		obj.put("pageSize", pageSize);
		obj.put("systemSource", systemSource);
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getWithdrawCash.do?";
//		String refundUrl = "http://localhost:8080/ZRAccount/account/withdrawMoney/getWithdrawCash.do?";
		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}
	/**
	 * 生成提现单
	 */
	@Test
	public void createWithdrawCash() throws Exception{
		String uniqueNo="1111111111111";//数据唯一标识
		String applicationTime="2016-10-05 11:11:11";//提现申请时间
		String wmAmount="1";//提现金额
		String wmUid="5e89dba5-4c34-4edf-85a8-e916465e4406";//uid
		String bankArea="鞍山";//开卡所在行
		String bankCode="1038";//银行编码
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
		 
		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/withdrawMoney/getAllDetails.do?";
	/*	String refundUrl = "http://localhost:8080/ZRAccount/account/withdrawMoney/createWithdrawCash.do?";
		String refundUrl = "http://account.ziroom.com/account/withdrawMoney/createWithdrawCash.do?";*/
		InputStream resultContentInputStream = NetUtil.sendPostRequest(refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}

	
}
