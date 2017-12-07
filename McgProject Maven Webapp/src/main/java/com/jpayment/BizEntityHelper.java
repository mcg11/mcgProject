package com.jpayment;

import com.ziroom.common.util.JdUtil.AlgorithmUtils;

/**
 * 京东白条基础类操作
 * 
 * @author: gaojk
 * @date:2015年5月11日 下午12:57:44
 * @since 1.0.0
 */
public abstract class BizEntityHelper {
	

	/**
	 * 创建密文方法，用于白条交易报文中的DATA字段加密
	 * 加密顺序：3des-->base64-->url编码
	 * <p>
	 * <b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * 
	 * @param plainText
	 *            明文，报文中的DATA明文数据
	 * @param privateKey
	 * @param charset
	 *            字符集，使用指定的字符集进行加密运算，系统中默认使用UTF-8
	 * @return
	 * @author: gaojk
	 * @date:2015年5月11日 下午1:08:47
	 * @since 1.0.0
	 */
	public static String createCipherText(String plainText, String privateKey,
			String charset) {
		String cipherText = AlgorithmUtils.urlEncode((AlgorithmUtils
				.base64Encode(AlgorithmUtils.des3Encrypt(plainText, privateKey,
						charset))), charset);
		return cipherText;
	}

	/**
	 * 由密文返向为明文，用于白条交易报文中的DATA字段解密。
	 * 解密顺序：url解码-->base64-->3des
	 * <p>
	 * <b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * 
	 * @param cipherText  密文，交易报文中传输的密文
	 * @param privateKey
	 * @param charset 字符集，使用指定的字符集进行加密运算，系统中默认使用UTF-8
	 * @return
	 * @author: gaojk
	 * @date:2015年5月11日 下午1:07:41
	 * @since 1.0.0
	 */
	public static String reverseCipherText(String cipherText,
			String privateKey, String charset) {
		String plainText = AlgorithmUtils.des3Decrypt(AlgorithmUtils
				.base64Decode(AlgorithmUtils.urlDecode(cipherText, charset)),
				privateKey, charset);
		return plainText;
	}
	
	/**
	 * 生成BizEntity签名(sha256)
	 * 源串为：版本号 + 字符编码 + 交易类型 + 数据域+ 商户号 + 私钥
	 * <p>
	 * <b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * 
	 * @param bizEntity
	 * @param privateKey
	 * @author: gaojk
	 * @date:2015年5月11日 下午1:10:05
	 * @since 1.0.0
	 */
	public static void createSignSHA256(BizEntity bizEntity, String privateKey) {
		StringBuilder sb = new StringBuilder();
		sb.append(bizEntity.getVersion());
		sb.append(bizEntity.getCharset());
		sb.append(bizEntity.getTradeType());
		sb.append(bizEntity.getData());
		sb.append(bizEntity.getMerchantCode());
		sb.append(privateKey);
		bizEntity.setSign(AlgorithmUtils.sha256Digest(sb.toString(), bizEntity.getCharset()));
	}

	/**
	 * 校验BizEntity签名数据(sha256)
	 * 源串为：版本号 + 字符编码 + 交易类型 + 数据域+ 商户号 + 私钥
	 * 
	 * <p>
	 * <b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * 
	 * @param bizEntity
	 * @param privateKey
	 * @return
	 * @author: gaojk
	 * @date:2015年5月11日 下午1:05:53
	 * @since 1.0.0
	 */
	public static boolean verifySignSHA256(BizEntity bizEntity,	String privateKey) {
		StringBuilder sb = new StringBuilder();	
		sb.append(bizEntity.getVersion());
		sb.append(bizEntity.getCharset());
		sb.append(bizEntity.getTradeType());
		sb.append(bizEntity.getData());
		sb.append(bizEntity.getMerchantCode());
		sb.append(privateKey);
		String tempSign = AlgorithmUtils.sha256Digest(sb.toString(), bizEntity.getCharset());
		
		return tempSign.equalsIgnoreCase(bizEntity.getSign());

	}

	/**
	 * 验证字符串签名
	 * 
	 * <p><b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * @param data
	 * @param privateSignKey
	 * @param charset
	 * @param sign
	 * @param merchantNo
	 * @return
	 * @author: gaojk 
	 * @date:2015年5月11日 下午1:37:17
	 * @since 1.0.0
	 */
	public static boolean verifySignStringSHA256(String data,
			String privateSignKey, String charset, String sign,
			String merchantNo) {
		StringBuilder sb = new StringBuilder();
		sb.append(data);
		sb.append(merchantNo);
		sb.append(privateSignKey);
		String tempSign = AlgorithmUtils.sha256Digest(sb.toString(), charset);

		return tempSign.equalsIgnoreCase(sign);
	}

	/**
	 * 字符串签名
	 * 
	 * <p><b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * @param data
	 * @param privateSignKey
	 * @param charset
	 * @param sign
	 * @param merchantNo
	 * @return
	 * @author: gaojk 
	 * @date:2015年5月11日 下午1:37:17
	 * @since 1.0.0
	 */
	public static String signStringSHA256(String data, String privateSignKey,
			String charset, String merchantNo) {
		StringBuilder sb = new StringBuilder();
		sb.append(data);
		sb.append(merchantNo);
		sb.append(privateSignKey);
		String tempSign = AlgorithmUtils.sha256Digest(sb.toString(), charset);
		return tempSign;
	}

}
