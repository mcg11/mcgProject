package com.insure;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liyb58 on 2018/2/26.
 */
public class ContractPeopleVo {



    private String contactPeopleName;

    private String contactPhone;

    private String contactAmount;

    public String getContactPeopleName() {
        return this.contactPeopleName;
    }

    public void setContactPeopleName(String contactPeopleName) {
        this.contactPeopleName = contactPeopleName;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAmount() {
        return this.contactAmount;
    }

    public void setContactAmount(String contactAmount) {
        this.contactAmount = contactAmount;
    }
}
