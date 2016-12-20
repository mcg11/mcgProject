package account;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

import jpayment.AESDecode;
import account.utils.EncryptionUtil;

import com.ziroom.common.util.CryptAES;
import com.ziroom.common.util.NetUtil;

public class BankTest {
	/*public static void main(String[] args) throws Exception{
		new Thread(new Runnable() {  
        	public void run() {  
        		try {
					bindBank("580bcd13-3701-8691-97dd-94ec320fdbc1");
				} catch (Exception e) {
					e.printStackTrace();
				}  
            }  
        }).start();  
		new Thread(new Runnable() {  
			public void run() {  
				try {
					bindBank("580bcd13-3701-8691-97dd-94ec320fdbc1");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}  
		}).start();  
		new Thread(new Runnable() {  
			public void run() {  
				try {
					bindBank("580bcd13-3701-8691-97dd-94ec320fdbc1");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}  
		}).start();  
		new Thread(new Runnable() {  
			public void run() {  
				try {
					bindBank("b2fd2903-f921-2755-6927-4578f3364891");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}  
		}).start();  
		new Thread(new Runnable() {  
			public void run() {  
				try {
					bindBank("b2fd2903-f921-2755-6927-4578f3364891");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}  
		}).start();  
		new Thread(new Runnable() {  
			public void run() {  
				try {
					bindBank("b2fd2903-f921-2755-6927-4578f3364891");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}  
		}).start();  
	}*/

	/**
	 * 绑定银行卡
	 * @throws Exception 
	 */
	@Test
	public  void bindBank() throws Exception{
		
		InputStream resultContentInputStream = null;
		String uid=	"580bcd13-3701-8691-97dd-94ec320fdbc1";	//用户uid	I	String	是	 
		String accountName ="";	//	开户名	I	String	否	 
		String bankArea	="北京市"; 	//开户行地区	I	String	否	 
		String bankCode	="1003";	//银行编码	I	Integer	是	 
		String bankName	="北京银行";	//银行名称	I	String	否	 
		String bankCardNo ="749187591759018750185015";	//	银行卡号	I	String	是	数字之间不允许有空格
		String systemSource="dz";	//
		JSONObject obj = new JSONObject();
		obj.put("uid", uid);
		obj.put("accountName", accountName);
		obj.put("bankArea", bankArea);
		obj.put("bankCode", bankCode);
		obj.put("bankName", bankName);
		obj.put("bankCardNo", bankCardNo);
		obj.put("systemSource", systemSource);
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
		
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bankAccount/bindBankCard.do?";
		String refundUrl = "http://localhost:8080/ZRAccount/account/bankAccount/bindBankCard.do?";

		resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}



	/**
	 * 根据uid查询名下的银行卡
	 * @throws Exception 
	 */
	@Test
	public void getUserBankCardAccount() throws Exception{
		String uid="580bcd13-3701-8691-97dd-94ec320fdbc1";
		String systemSource="dz";
		JSONObject obj=new JSONObject();
		obj.put("uid", uid);
		obj.put("systemSource", systemSource);
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bankAccount/getUserBankCardAccount.do?";
		String refundUrl = "http://localhost:8080/ZRAccount/account/bankAccount/getUserBankCardAccount.do?";
		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}
	
	/**
	 * 解绑银行卡
	 * @throws Exception 
	 */
	@Test
	public void unbindBankCard() throws Exception{
		String uid="580bcd13-3701-8691-97dd-94ec320fdbc1";//	用户uid	I	String	是	 
		String bankCode="1003";//	银行编码	I	Integer	否	 
		String bankCardNo="749187591759018750185015";//	银行卡号	I	String	是	 
		String systemSource="dz";//
		JSONObject obj=new JSONObject();
		obj.put("uid", uid);
		obj.put("bankCode", bankCode);
		obj.put("bankCardNo", bankCardNo);
		obj.put("systemSource", systemSource);
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bankAccount/bindBankCard.do?";
		String refundUrl = "http://localhost:8080/ZRAccount/account/bankAccount/unbindBankCard.do?";
		InputStream resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}
	@Test
	public void NewbindBank() throws Exception{
		
		InputStream resultContentInputStream = null;
		String uid=	"409bcd13-3701-8691-97dd-94ec320fdbc1";	//用户uid	I	String	是	 
		String mobile ="13602459062";	//	开户名	I	String	否	 
		String userName	="吴小龄"; 	//开户行地区	I	String	否	 
		String bankCard	="6227001823260036733";	//银行编码	I	Integer	是	 
		String certificateNum="441509876512014787";	//银行名称	I	String	否	 
		JSONObject obj = new JSONObject();
		obj.put("uid", uid);
		obj.put("mobile", mobile);
		obj.put("userName", userName);
		obj.put("bankCardNo", bankCard);
		obj.put("certificateNum", certificateNum);
		obj.put("bankName", "中国银行");
		obj.put("bankCode", "105");
		obj.put("appIcon", "http://localhost..");
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
		
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bankAccount/bindBankCard.do?";
//		String refundUrl = "http://localhost:8080/ZRAccount/bankAction/bindBankCard.do?";
		String refundUrl = "http://account.t.ziroom.com/bankAction/bindBankCard.html?";
 
		resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}
	@Test
	public void queryBankCardInfo() throws Exception{
		
		InputStream resultContentInputStream = null;
		String uid=	"d4b91a76-c06e-2add-9d8d-bbac7afcd9e3";	//用户uid	I	String	是	 
		JSONObject obj = new JSONObject();
		obj.put("uid", uid);
		// 加密
		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
				obj.toString(), "8w091ql5l2tt6qxj");
		
//		String refundUrl = "http://10.16.35.97:8081/ZRAccount/account/bankAccount/bindBankCard.do?";
		String refundUrl = "http://localhost:8080/ZRAccount/account/bankAction/queryBankCardInfo.do?";
//		String refundUrl = "http://account.t.ziroom.com/bankAction/queryBankCardInfo.html?";

		resultContentInputStream = NetUtil.sendPostRequest(
				refundUrl, resultMap);
		String resultContent = NetUtil.getTextContent(resultContentInputStream,"UTF-8");
		
		System.out.println(resultContent);
	}
}
