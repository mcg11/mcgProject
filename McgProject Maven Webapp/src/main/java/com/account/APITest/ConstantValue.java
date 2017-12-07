package com.account.APITest;

/**
 * 常量值
 * 
 * @author: gaojk 
 * @date:2015年5月11日 下午2:36:05
 * @since 1.0.0
 */
public class ConstantValue {
	
	//逻辑删除
	public static final Integer IS_DEL_Y = 1;
	//逻辑未删除
	public static final Integer IS_DEL_N = 0;	
	//定时任务开启
	public static final Integer TASK_OPENING = 0;
	//定时任务关闭
	public static final Integer TASK_CLOSE = 1;	
	//同步时间间隔 5分钟1次
	public static final int SYNC_DISTANCE = 5;
	//同步时间范围25分钟(>时间间隔*数据最大同步次数)
	public static final int SYNC_FIELD = 25;
	//回调空间状态：失败
	public static final String FAULT = "F";
	//回调空间状态：成功
	public static final String SUCCESS = "S";
	//白条成功状态
	public static final String WHITESUCCESS = "3";
	//url在redis存储时间，单位：秒
	public static final int URL_IN_REDIS = 3600;

}
