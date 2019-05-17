package com.github.vspro.pay.client;

import com.github.vspro.pay.request.BaseWxPayRequest;

import java.util.Map;
import java.util.TreeMap;

public class WxRequestHolder {

    private BaseWxPayRequest request;
    private Map<String, Object> additional;


    public WxRequestHolder(BaseWxPayRequest request) {
        this.request = request;
        this.additional = new TreeMap<>();
    }

    public BaseWxPayRequest getRequest() {
        return request;
    }

    public Map<String, Object> getAdditional() {
        return additional;
    }
}
