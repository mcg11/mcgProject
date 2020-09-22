package com.insure;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 受伤人员信息表
 * </p>
 *
 * @author liyb58
 * @since 2018-02-26
 */
public class TInjuredPerson  {

    private static final long serialVersionUID = 1L;


    public TInjuredPerson() {
    }



    private Integer id;
    /**
     * 自如保险单号
     */
    private String injuredName;
    /**
     * 江泰受理人伤流水号
     */
    private Integer injuredSex;
    /**
     * 是否含人伤 1含有 2不含
     */
    private String injuredCardType;
    /**
     * 出险人姓名
     */
    private String injuredCardNo;
    /**
     * 性别 男=1，女=0
     */
    private String injuredAge;


    /**
     * 估损金额(精度:保留两位小数)
     */
    private BigDecimal injuredAmount;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInjuredName() {
        return this.injuredName;
    }

    public void setInjuredName(String injuredName) {
        this.injuredName = injuredName;
    }

    public Integer getInjuredSex() {
        return this.injuredSex;
    }

    public void setInjuredSex(Integer injuredSex) {
        this.injuredSex = injuredSex;
    }


    public String getInjuredCardType() {
        return this.injuredCardType;
    }

    public void setInjuredCardType(String injuredCardType) {
        this.injuredCardType = injuredCardType;
    }

    public String getInjuredCardNo() {
        return this.injuredCardNo;
    }

    public void setInjuredCardNo(String injuredCardNo) {
        this.injuredCardNo = injuredCardNo;
    }

    public String getInjuredAge() {
        return this.injuredAge;
    }

    public void setInjuredAge(String injuredAge) {
        this.injuredAge = injuredAge;
    }


    public BigDecimal getInjuredAmount() {
        return this.injuredAmount;
    }

    public void setInjuredAmount(BigDecimal injuredAmount) {
        this.injuredAmount = injuredAmount;
    }
}
