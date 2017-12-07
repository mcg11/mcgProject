package com.jpayment;

import java.io.Serializable;

/**
 * 京东白条点对点通知订单详情
 * 
 * @author: gaojk
 * @date:2015年5月8日 下午3:33:22
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class CallbackOrderEntityVo implements Serializable {

	// 业务参考号 由京东金融生成的唯一标识
	private String refOrderId;
	// 贷款单号
	private String loanId;
	// 订单金额(金额：元)
	private String amount;
	// 商家商户号
	private String merchantCode;
	// 商家订单号
	private String merchantOrderId;
	// 订单时间
	private String merchantOrderDate;
	// 订单状态 1，收单完成；2单款申请中，3贷款完成
	private String payState;
	// 交易成功时间
	private String tradeDate;
	// 扩展信息
	private String extParam;

	/**
	 * @return the refOrderId
	 */
	public String getRefOrderId() {
		return refOrderId;
	}

	/**
	 * @param refOrderId
	 *            the refOrderId to set
	 */
	public void setRefOrderId(String refOrderId) {
		this.refOrderId = refOrderId;
	}

	/**
	 * @return the loanId
	 */
	public String getLoanId() {
		return loanId;
	}

	/**
	 * @param loanId
	 *            the loanId to set
	 */
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @return the merchantOrderId
	 */
	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	/**
	 * @param merchantOrderId
	 *            the merchantOrderId to set
	 */
	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	/**
	 * @return the merchantOrderDate
	 */
	public String getMerchantOrderDate() {
		return merchantOrderDate;
	}

	/**
	 * @param merchantOrderDate
	 *            the merchantOrderDate to set
	 */
	public void setMerchantOrderDate(String merchantOrderDate) {
		this.merchantOrderDate = merchantOrderDate;
	}

	/**
	 * @return the payState
	 */
	public String getPayState() {
		return payState;
	}

	/**
	 * @param payState
	 *            the payState to set
	 */
	public void setPayState(String payState) {
		this.payState = payState;
	}

	/**
	 * @return the tradeDate
	 */
	public String getTradeDate() {
		return tradeDate;
	}

	/**
	 * @param tradeDate
	 *            the tradeDate to set
	 */
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	/**
	 * @return the extParam
	 */
	public String getExtParam() {
		return extParam;
	}

	/**
	 * @param extParam
	 *            the extParam to set
	 */
	public void setExtParam(String extParam) {
		this.extParam = extParam;
	}

}
