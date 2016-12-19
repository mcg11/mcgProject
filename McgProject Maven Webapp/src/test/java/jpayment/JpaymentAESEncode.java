package jpayment;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.ziroom.common.util.CryptAES;

public class JpaymentAESEncode {
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
	@Test
	public  void queryJdTradeInfo() {
		String order_id="0914091409140914141419";
        JSONObject json = new JSONObject();
        json.put("order_id", order_id);// 本次退款金额
        json.put("companyCode", "");// 本次退款金额
        // 城市实体
        // 进行加密操作
//        String encryption = CryptAES.AES_Encrypt("5218b0deed29f542", json.toString());// 密钥5218b0deed29f542
        String encryption = "CgnacubGxIqV3tcC6z5Rr9GJsSV5Sa/y4EfEVek91pFtWOB6cMnoF2wYib2i0Egl+FjGO8iNCbuAKFzj1hB7KEgMlEJmwLzaJ7PaNz7u9CLmGzUWHRHUKQj6q52v66RS+zefGxsXo9RqjGojq79YJLQH+Oq9bLZ3Nm5gAN7hRRXtOwm80k2LmaSPyMTcovypxfyuRp9s4pxc0tsbkVPdWH47Zb7OYGHQGN1LyYdle7X+HbDyCmF92QvBryf4UpqU";// 密钥5218b0deed29f542
        
        String encryption1 = encryption.replace("/", "%2F");
		String encryption2 = encryption1.replace("+", "%2B");
		String encryption3 = encryption2.replace("=", "%3D");
		System.out.println(encryption3);
        System.out.println(encryption);
    }
}
