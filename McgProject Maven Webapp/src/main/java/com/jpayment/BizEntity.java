package com.jpayment;

/**
 * 业务实体
 * 
 * @author: gaojk
 * @date:2015年5月11日 上午11:11:19
 * @since 1.0.0
 */
public class BizEntity {

	// 版本号
	private String version;
	// 字符集GBK/UTF-8等
	private String charset;
	// 交易类型，用来代贷款报文
	private String tradeType;
	// 加密后的业务数据
	private String data;
	// 商户号
	private String merchantCode;
	// 所有数据签名
	private String sign;

	public BizEntity() {

	}

	public BizEntity(String version, String charset, String tradeType,
                     String data, String merchantCode, String sign) {
		this.version = version;
		this.charset = charset;
		this.tradeType = tradeType;
		this.data = data;
		this.merchantCode = merchantCode;
		this.sign = sign;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the charset
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * @param charset
	 *            the charset to set
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * @return the tradeType
	 */
	public String getTradeType() {
		return tradeType;
	}

	/**
	 * @param tradeType
	 *            the tradeType to set
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the merchantCode
	 */
	public String getMerchantCode() {
		return merchantCode;
	}

	/**
	 * @param merchantCode
	 *            the merchantCode to set
	 */
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign
	 *            the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "BizEntity{" + "version='" + version + '\'' + ", charset='"
				+ charset + '\'' + ", tradeType='" + tradeType + '\''
				+ ", data='" + data + '\'' + ", merchantCode='" + merchantCode
				+ '\'' + ", sign='" + sign + '\'' + '}';
	}
}
