package com.insure;


/**
 * Created by liyb58 on 2018/2/22.
 */
public class AttReq {
    /**
     * 附件类型	I	int	是
     */
    private int attType;
    /**
     * 附件url	I	String	是
     */
    private String attUrl;
    /**
     * 材料	I	String	是
     */
    private String stuffType;

    public int getAttType() {
        return this.attType;
    }

    public void setAttType(int attType) {
        this.attType = attType;
    }

    public String getAttUrl() {
        return this.attUrl;
    }

    public void setAttUrl(String attUrl) {
        this.attUrl = attUrl;
    }

    public String getStuffType() {
        return this.stuffType;
    }

    public void setStuffType(String stuffType) {
        this.stuffType = stuffType;
    }
}
