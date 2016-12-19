package account;

import org.junit.Test;

import com.ziroom.common.util.CryptAES;
import com.ziroom.common.util.DesBase64Tool;

public class AESAndBase64 {
	
	/**
	 * account 参数 生产 测试 解密 
	 * @throws Exception 
	 */
	@Test
	public void accountC() throws Exception{
//		{error=, encryption=BQUcfwqVgD8a9auwdnc3G5MwhOJVGJxYrvGZ/VpJKu6PigQ6zDHZPN62qqJCh/BctmxLdVi1x94k084xNT3yTYkVcu9kBmH0eLiYDH0pXHdCTcz72X1bEhHVKHL/HF0DDaaVgS//LnZv8DClc1ke+y61CaCa2/6+EexlnCw2vrXORWh8P4+YCH7aXfuRVMVAYH57B6pEPTuP536eBJi/rkJfZt/a2gnDlFlU2B8Rr0xwPRAojAwMqFvGwMLSsAznuE8ShMLgpBD2h/OQXsjX2OakA66sCb+JnYTzwTrLju7w3ugF/E0g0kx+Djg63VnEVM56K4yo9P96lIEZzuj2XoYy/xTGCZAy9QW658rwwd8n5yLKTkSV0JvidK5yPKNmvy8zb1A381wsUfpdmH58RA==}
		String encryption="BQUcfwqVgD8a9auwdnc3G5MwhOJVGJxYrvGZ/VpJKu6PigQ6zDHZPN62qqJCh/BctmxLdVi1x94k084xNT3yTYkVcu9kBmH0eLiYDH0pXHdCTcz72X1bEhHVKHL/HF0DDaaVgS//LnZv8DClc1ke+y61CaCa2/6+EexlnCw2vrXORWh8P4+YCH7aXfuRVMVAYH57B6pEPTuP536eBJi/rkJfZt/a2gnDlFlU2B8Rr0xwPRAojAwMqFvGwMLSsAznuE8ShMLgpBD2h/OQXsjX2OakA66sCb+JnYTzwTrLju7w3ugF/E0g0kx+Djg63VnEVM56K4yo9P96lIEZzuj2XoYy/xTGCZAy9QW658rwwd8n5yLKTkSV0JvidK5yPKNmvy8zb1A381wsUfpdmH58RA==";
		String encryptio2="BQUcfwqVgD8a9auwdnc3G5MwhOJVGJxYrvGZ/VpJKu6PigQ6zDHZPN62qqJCh/BctmxLdVi1x94k084xNT3yTYkVcu9kBmH0eLiYDH0pXHdCTcz72X1bEhHVKHL/HF0DDaaVgS//LnZv8DClc1ke+y61CaCa2/6+EexlnCw2vrXORWh8P4+YCH7aXfuRVMVAYH57B6pEPTuP536eBJi/rkJfZt/a2gnDlFlU2B8Rr0xwPRAojAwMqFvGwMLSsAznuE8ShMLgpBD2h/OQXsjX2OakA66sCb+JnYTzwTrLju7w3ugF/E0g0kx+Djg63VnEVM56K4yo9P96lIEZzuj2XoYy/xTGCZAy9QW658rwwd8n5yLKTkSV0JvidK5yPKNmvy8zb1A381wsUfpdmH58RA==";
		//在浏览器中请求，会自动转换/ + =,接收到的时候又转换回来了
		String encryption1 = encryption.replace("/", "%2F");
		String encryption2 = encryption1.replace("+", "%2B");
		String encryption3 = encryption2.replace("=", "%3D");
		System.out.println(encryption3);
		//cim  支付调用时的解密
		String result=CryptAES.AES_Decrypt("8w091ql5l2tt6qxj", encryption);
		
		//资产调用时的解密方式
//		String result=DesBase64Tool.desDecrypt(encryption, "8w091ql5l2tt6qxj3z0emh21");
		
		System.out.println("结果"+result);
	}
}
