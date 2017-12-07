package com.account.APITest;

import com.ziroom.common.util.CryptAES;
import com.ziroom.common.util.DesBase64Tool;

import java.util.HashMap;
import java.util.Map;

public class EncryptionUtil {

	// 密钥
	protected final static String key = "8w091ql5l2tt6qxj3z0emh21";
	protected final static String key_ziroom = "8w091ql5l2tt6qxj";

	/**
	 * @Description: 加密算法选择
	 * @param @param jsonStr
	 * @param @param encryptionKey 传key 是 base64测试 传key_ziroom 是 AES加密测试
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @author liuxm
	 * @date 2014年11月27日
	 */
	public static Map<String, String> encryptionWay(String jsonStr,
			String encryptionKey) {
		Map<String, String> map = new HashMap<String, String>();
		String encryption = "";
		// 加密
		try {
			if (encryptionKey.equals(key)) {
				encryptionKey = "key   DesBase64Tool加密方式出现异常";
				encryption = DesBase64Tool.desEncrypt(jsonStr, key);
			} else {
				encryptionKey = "key_ziroom   CryptAES加密方式出现异常";
				encryption = CryptAES.AES_Encrypt(key_ziroom, jsonStr);
			}
			map.put("encryption", encryption);
			map.put("error", "");
			return map;
		} catch (Exception e) {
			map.put("error", encryptionKey + " 具体异常-----" + e);
			map.put("encryption", "");
			return map;
		}
	}

}
