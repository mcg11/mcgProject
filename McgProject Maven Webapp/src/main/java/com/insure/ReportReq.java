package com.insure;


/**
 * 报案请求参数
 * Created by liyb58 on 2018/2/22.
 */
public class ReportReq {

    /**
     * 自如报案号	I	String	是	字段 从APP 获取附件列表 接口获取
     */
    private String zrReportNo;

    /**
     * 出险时间	I	String	yyyy-mm-dd 时分秒
     */
    private String accidentTime;
    /**
     * 出险原因	I	String	是
     */
    private String accidentReason;
    /**
     * 收房编号	I	String	是
     */
    private String houseNo;
    /**
     * 一级类别code码	I	int	是
     */
    private int oneCode;
    /**
     * 二级类别code码	I	int	是
     */
    private int twoCode;
    /**
     * 报案人姓名	I	String	是
     */
    private String operName;
    /**
     * 报案人系统号	I	String	是
     */
    private String operCode;
    /**
     * 报案人电话	I	String	是
     */
    private String operPhone;
    /**
     * 是否含人伤	I
     */
    private int isInjured;

}
