package com.weizhong.dto;/**
 * Created by jonyang on 2016/1/11.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (C) @2016 Webank Group Holding Limited
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class TicketDTO {

    /**
     * 当前生效的票据
     */
    private String value;

    /**
     * 有效期至的时间
     */
    @JsonProperty("expire_time")
    private long expireTime;

    /**
     * 有效期
     */
    @JsonProperty("expire_in")
    private int maxAliveTime;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getMaxAliveTime() {
        return maxAliveTime;
    }

    public void setMaxAliveTime(int maxAliveTime) {
        this.maxAliveTime = maxAliveTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
