package com.github.vspro.pay.constants;

/**
 * 微信支付模式
 */
public enum PayModelEnum {


    JSAPI("JSAPI"),
    NATIVE("NATIVE "),
    APP("APP "),
    H5("MWEB");

    private String value;

    PayModelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
