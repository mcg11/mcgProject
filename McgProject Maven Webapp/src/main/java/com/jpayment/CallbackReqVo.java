package com.jpayment;


/**
 * 
 * @description:点对点通知bean
 * @author: gaojk
 * @date:2015年4月27日 下午2:27:40
 * @since 1.0.0
 */
public class CallbackReqVo extends ResponseBaseVo {

	// 通知详情
	private CallbackOrderEntityVo orderEntity;

	/**
	 * @return the orderEntity
	 */
	public CallbackOrderEntityVo getOrderEntity() {
		return orderEntity;
	}

	/**
	 * @param orderEntity
	 *            the orderEntity to set
	 */
	public void setOrderEntity(CallbackOrderEntityVo orderEntity) {
		this.orderEntity = orderEntity;
	}

}
