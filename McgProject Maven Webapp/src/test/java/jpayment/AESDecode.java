package jpayment;

import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

import account.utils.EncryptionUtil;

import com.ziroom.common.util.CryptAES;
import com.ziroom.common.util.DesBase64Tool;

public class AESDecode {
	
	/**
	 * jpayment 贷款申请中的bizInfo 生产 测试 解密 
	 */
	@Test
	public void jpaymentBizInfo(){
		String aa="gAr8tngtY5zsej3AH5MVGGjLSX%2FQX8t4d7ARbLYfv4lye2AW%2FWCLx58Jn%2BVgqXiAgu18HLZjYZY%3D";
		String encryption1 = aa.replace("%2F", "/");
		String encryption2 = encryption1.replace("%2B", "+");
		String encryption3 = encryption2.replace("%3D", "=");
		System.out.println(encryption3);
		String result=CryptAES.AES_Decrypt("5218b0deed29f542", encryption3);
		System.out.println(result);
	}
	
	/**
	 * jpayment 京东白条所有参数  生产 测试 解密 
	 */
	@Test
	public void jpaymentPay(){
		String aa="gAr8tngtY5zsej3AH5MVGGjLSX%2FQX8t4d7ARbLYfv4lye2AW%2FWCLx58Jn%2BVgqXiAgu18HLZjYZY%3D";
		//自如网中京东白条key：5218b0deed29f542
		String result=CryptAES.AES_Decrypt("5218b0deed29f542", aa);
		System.out.println(result);
	}
	public static void main(String[] args) {
		String refundAmount="41863.25";
		String	merchantOrderDate="20160828";
		String	cityCode="100001";
		String merchantOrderId="BJCW81403170012-03_1472377266625";
		String refundOrderId="JYBJCW81403170012-03_20161103192003";
		JSONObject obj=new JSONObject();
		obj.put("refundAmount", refundAmount);
		obj.put("merchantOrderDate", merchantOrderDate);
		obj.put("cityCode", cityCode);
		obj.put("merchantOrderId", merchantOrderId);
		obj.put("refundOrderId", refundOrderId);
		String result=CryptAES.AES_Encrypt("5218b0deed29f542", obj.toString());
		
//		Map<String, String> resultMap = EncryptionUtil.encryptionWay(
//				obj.toString(), "5218b0deed29f542");
//		String encryption = (String) resultMap.get("encryption");
//		System.out.println(encryption);
		System.out.println(result);
		
		String bb="3JzGwYg3Dxdk4JQGmeKXIejvvGLTy03pdbro9Tbw4m7b85WoDvUwVL7S6+/wOxdyVAeoK6y0/IWMmrINMHbRlXz8Hs4/D1ZSJDCbzILh8Rp8iIxxDbV+BrdDhasyq3aIy2BV424EztuDYGN2p/E0sAC7n1ARexkGAeqPmEvR1lekeWT+XTovjAexorp0K1gP+KmZdxqDJovBsr6wocOCzqlAii9CWDJ1k48gMQaRDDL0/+NdoeEfWl6Gfaqsbx3n";
		String encryption1 = bb.replace("/", "%2F");
		String encryption2 = encryption1.replace("+", "%2B");
		String encryption3 = encryption2.replace("=", "%3D");
		System.out.println(encryption3);
	}
	
	/**
	 * 请求白条接口参数加密
	 */
	@Test
	public  void AesEncode() {
		 	String refundAmount="41863.25";
			String	merchantOrderDate="20160828";
			String	cityCode="100001";
			String merchantOrderId="BJCW81403170012-03_1472377266625";
			String refundOrderId="JYBJCW81403170012-03_20161103192003";
	        JSONObject json = new JSONObject();
	        json.put("merchantOrderId", merchantOrderId);// 订单号（流水号）
	        json.put("refundOrderId", refundOrderId);
	        json.put("merchantOrderDate",merchantOrderDate);
	        json.put("refundAmount", refundAmount);// 本次退款金额
	        // 城市实体
	        json.put("cityCode", cityCode);// 城市编码
	        // 进行加密操作
	        String encryption = CryptAES.AES_Encrypt("5218b0deed29f542", json.toString());// 密钥5218b0deed29f542
	        System.out.println(encryption);
	    }
	/**
	 * 请求白条接口参数加密
	 */
	


}
