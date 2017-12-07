package com.jpayment;

/**
 * 接口响应信息基类
 * 
 * @author: gaojk
 * @date:2015年5月8日 下午3:28:27
 * @since 1.0.0
 */
public class ResponseBaseVo {

	// 响应码
	private String resultCode;
	// 响应描述
	private String resultInfo;

	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode
	 *            the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the resultInfo
	 */
	public String getResultInfo() {
		return resultInfo;
	}

	/**
	 * @param resultInfo
	 *            the resultInfo to set
	 */
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

}
